package com.ph.study.normal_thread.controllers

import com.ph.study.normal_thread.domain.User
import com.ph.study.normal_thread.services.UserService
import lombok.AllArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@AllArgsConstructor
class UserController( var userService: UserService) {

    @GetMapping("/user/{username}")
    fun getUser(@PathVariable username: String): List<User> {
        return userService.getUser(username)
    }


}