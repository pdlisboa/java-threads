package com.ph.study.virtual_thread

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
open class VirtualThreadApplication

fun main(args: Array<String>) {
	runApplication<VirtualThreadApplication>(*args)
}
