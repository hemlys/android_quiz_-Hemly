package com.sample.demo.myapplication.net


import io.reactivex.Single
import retrofit2.http.GET
import com.sample.demo.myapplication.bean.UsersDetails
import com.sample.demo.myapplication.bean.UsersList
import retrofit2.http.Path

interface ApiService {

    @GET("/users")
    fun getAll(): Single<List<UsersList>>

    @GET("/users/{name}")
    fun getUsersDetail(@Path("name") name: String): Single<UsersDetails>
}
