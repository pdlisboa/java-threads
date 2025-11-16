package com.ph.study.virtual_thread.services

import com.ph.study.virtual_thread.clients.AClient
import com.ph.study.virtual_thread.clients.BClient
import com.ph.study.virtual_thread.clients.CClient
import com.ph.study.virtual_thread.domain.User
import lombok.AllArgsConstructor
import org.springframework.stereotype.Service

@Service
@AllArgsConstructor
class UserService(
    var aClient: AClient,
    val bClient: BClient,
    val cClient: CClient
) {

    fun getUser(username: String): List<User> {
        val a: User? = getUserFromA(username)
        val b: User? = getUserFromB(username)
        val c: User? = getUserFromC(username)

        val list = listOf(a,b,c)
        list.requireNoNulls()


        return list as List<User>
    }

    fun getUserFromA(username: String): User? {
        return aClient.getUser(username)
    }

    fun getUserFromB(username: String): User? {
        return bClient.getUser(username)
    }


    fun getUserFromC(username: String): User? {
        return cClient.getUser(username)
    }

}