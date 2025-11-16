package com.ph.study.virtual_thread.config

import org.apache.coyote.ProtocolHandler
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.Executors

@Configuration
open class VirtualThreadConfig {

    @Bean
    open fun virtualThreadExecutorCustomizer(): TomcatProtocolHandlerCustomizer<ProtocolHandler> {
        return TomcatProtocolHandlerCustomizer { protocolHandler ->
            protocolHandler.executor =
                Executors.newVirtualThreadPerTaskExecutor()
        }
    }
}