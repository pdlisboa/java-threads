package com.ph.study.webflux_example.services

import com.ph.study.webflux_example.clients.AClient
import com.ph.study.webflux_example.clients.BClient
import com.ph.study.webflux_example.clients.CClient
import com.ph.study.webflux_example.domains.User
import lombok.AllArgsConstructor
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuple3
import java.util.function.Function
import kotlin.math.min



@Service
@AllArgsConstructor
class UserService(
    val aClient: AClient,
    val bClient: BClient,
    val cClient: CClient,
) {

     fun getUser(username: String): Flux<User> {
        val a: Mono<User?> = aClient.getUser(username)
        val b: Mono<User?> = bClient.getUser(username)
        val c: Mono<User?> = cClient.getUser(username)


        return Flux.merge(a, b, c)
            .filter { it != null }
            .map { it!! }
    }




}