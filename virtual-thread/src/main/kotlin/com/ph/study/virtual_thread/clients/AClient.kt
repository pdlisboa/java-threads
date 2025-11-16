package com.ph.study.virtual_thread.clients

import com.ph.study.virtual_thread.domain.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient(url = "\${env.url-a}", name = "AClient")
interface AClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/user/{username}"])
    fun getUser(@PathVariable username: String): User?
}