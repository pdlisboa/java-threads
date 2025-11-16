package com.ph.study.normal_thread

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
open class NormalThreadApplication

fun main(args: Array<String>) {
	runApplication<NormalThreadApplication>(*args)
}
