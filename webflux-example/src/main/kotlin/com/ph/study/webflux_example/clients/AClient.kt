package com.ph.study.webflux_example.clients

import com.ph.study.webflux_example.domains.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono

@Component
class AClient(@Value("\${env.url-a}") private val url: String) {
     val client = WebClient.create(url)

     fun getUser(@PathVariable username: String): Mono<User?> = client.get()
        .uri("/user/{username}", username).accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(User::class.java)

}