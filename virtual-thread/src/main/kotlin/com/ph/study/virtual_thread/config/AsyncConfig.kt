package com.ph.study.virtual_thread.config

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
@EnableAsync
open class AsyncConfig : AsyncConfigurer {

    override fun getAsyncExecutor(): ExecutorService =
        Executors.newVirtualThreadPerTaskExecutor()
}