import http from 'k6/http';
import { sleep, check } from 'k6';
import { Trend } from 'k6/metrics';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/latest/dist/bundle.js';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';


const mvcTrend = new Trend('duration_mvc');
const webfluxTrend = new Trend('duration_webflux');
const vthreadsTrend = new Trend('duration_vthreads');

export const options = {
    scenarios: {
        mvc_test: {
            executor: 'constant-vus',
            vus: 500,
            duration: '30s',
            exec: 'testMvc', // Função específica
        },
        webflux_test: {
            executor: 'constant-vus',
            vus: 500,
            duration: '30s',
            exec: 'testWebFlux',
        },
        vthreads_test: {
            executor: 'constant-vus',
            vus: 500,
            duration: '30s',
            exec: 'testVThreads',
        },
    },

    thresholds: {
        'duration_mvc': ['p(95)<2000'],
        'duration_webflux': ['p(95)<500'],
        'duration_vthreads': ['p(95)<500'],
    }
};

const MVC_URL = "http://localhost:8081/user/phablo";
const WEBFLUX_URL = "http://localhost:8082/user/phablo";
const VTHREADS_URL = "http://localhost:8083/user/phablo";


export function testMvc() {
    const res = http.get(MVC_URL);
    mvcTrend.add(res.timings.duration);

    check(res, {
        'mvc status is 200': (r) => r.status === 200,
    });

    check(res, {
        'mvc status is 503': (r) => r.status === 503,
    });
}

export function testWebFlux() {
    const res = http.get(WEBFLUX_URL);
    webfluxTrend.add(res.timings.duration);

    check(res, {
        'webflux status is 200': (r) => r.status === 200,
    });

    check(res, {
        'webflux status is 503': (r) => r.status === 503,
    });
}

export function testVThreads() {
    const res = http.get(VTHREADS_URL);
    vthreadsTrend.add(res.timings.duration);

    check(res, {
        'vthreads status is 200': (r) => r.status === 200,
    });

    check(res, {
        'vthreads status is 503': (r) => r.status === 503,
    });
}

export function handleSummary(data) {
    return {
        'summary_comparativo.html': htmlReport(data),
        stdout: textSummary(data, { indent: ' ', enableColors: true }),
    };
}

