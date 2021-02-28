package com.sample.demo.myapplication.net

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.demo.myapplication.Userinfo
import com.sample.demo.myapplication.bean.UsersDetails
import com.sample.demo.myapplication.bean.UsersList
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoViewModel(var infoRepository: InfoRepository) : ViewModel() {
    var userInfoLiveData = MutableLiveData<UsersDetails>()
    var userListLiveData = MutableLiveData<List<UsersList>>()
    val loading = MutableLiveData<Boolean>()

    @SuppressLint("CheckResult")
    fun getAll() {
        loading.value =true
        infoRepository
            .getAll()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                loading.value =false
                userListLiveData.setValue(result)
            }, { error ->
                loading.value =false
                Log.e("ERROR", error.message)
            })
    }

    @SuppressLint("CheckResult")
    fun getusers(name :String) {
        loading.value =true
        infoRepository
            .getUsers(name)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                loading.value =false
                userInfoLiveData.setValue(result)
            }, { error ->
                loading.value =false
                Log.e("ERROR", error.message)
            })
    }
}