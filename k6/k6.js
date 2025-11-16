import http from 'k6/http';
import { Trend } from 'k6/metrics';
import { sleep } from 'k6';
import { htmlReport } from 'https://raw.githubusercontent.com/benc-uk/k6-reporter/latest/dist/bundle.js'


// métricas custom — um Trend para cada arquitetura
let mvc = new Trend("mvc_duration");
let webflux = new Trend("webflux_duration");
let vthreads = new Trend("vthreads_duration");

export let options = {
    vus: 500,          // número de usuários simultâneos
    duration: '20s',   // duração do teste
};

// URLs dos serviços
const MVC_URL = "http://localhost:8081/user/phablo";
const WEBFLUX_URL = "http://localhost:8082/user/phablo";
const VTHREADS_URL = "http://localhost:8083/user/phablo";

export default function () {
    // teste MVC
    let r1 = http.get(MVC_URL);
    mvc.add(r1.timings.duration);


    // // teste WebFlux
    let r2 = http.get(WEBFLUX_URL);
    webflux.add(r2.timings.duration);
    //
    // // teste Virtual Threads
    let r3 = http.get(VTHREADS_URL);
    vthreads.add(r3.timings.duration);

    sleep(1);
}

export function handleSummary(data) {
    return {
        'summary4.html': htmlReport(data),
    }
}