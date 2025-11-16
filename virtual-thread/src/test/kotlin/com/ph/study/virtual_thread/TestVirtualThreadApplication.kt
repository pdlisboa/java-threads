package com.ph.study.virtual_thread

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<VirtualThreadApplication>().with(TestcontainersConfiguration::class).run(*args)
}
