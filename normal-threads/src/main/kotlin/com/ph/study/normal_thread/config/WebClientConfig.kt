package com.ph.study.normal_thread.config

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class WebClientConfig {

    @Bean
    open fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()
}