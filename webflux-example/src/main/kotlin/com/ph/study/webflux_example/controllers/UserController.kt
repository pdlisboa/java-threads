package com.ph.study.webflux_example.controllers

import com.ph.study.webflux_example.domains.User
import com.ph.study.webflux_example.services.UserService
import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@AllArgsConstructor
class UserController( var userService: UserService) {

    @GetMapping("/user/{username}")
    fun getUser(@PathVariable username: String): Flux<User> {
        return userService.getUser(username)
    }


}