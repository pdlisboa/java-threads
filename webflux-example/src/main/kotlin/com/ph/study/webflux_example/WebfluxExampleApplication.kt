package com.ph.study.webflux_example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class WebfluxExampleApplication

fun main(args: Array<String>) {
	runApplication<WebfluxExampleApplication>(*args)
}
