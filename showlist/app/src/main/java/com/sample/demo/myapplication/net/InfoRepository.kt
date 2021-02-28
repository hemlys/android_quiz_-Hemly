package com.sample.demo.myapplication.net

import io.reactivex.Single
import com.sample.demo.myapplication.bean.UsersDetails
import com.sample.demo.myapplication.bean.UsersList


class InfoRepository {
    private val apiService = AppClientManager.retrofit.create(ApiService::class.java)

    fun getAll(): Single<List<UsersList>> {
        return apiService.getAll()
    }
    fun getUsers(name :String): Single<UsersDetails> {
        return apiService.getUsersDetail(name)
    }
}