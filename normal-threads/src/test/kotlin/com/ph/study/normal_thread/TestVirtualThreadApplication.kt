package com.ph.study.normal_thread

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<NormalThreadApplication>().with(TestcontainersConfiguration::class).run(*args)
}
