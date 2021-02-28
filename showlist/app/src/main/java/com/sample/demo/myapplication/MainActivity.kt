@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.myapplication.adapter.UsersListAdapter
import com.sample.demo.myapplication.bean.UsersList
import com.sample.demo.myapplication.net.InfoViewModel
import com.sample.demo.myapplication.ui.ProgressbarFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()
    private lateinit var rv_animal_list : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = ProgressbarFragment.newInstance(getString(R.string.uploading))
        infoViewModel.userListLiveData.observe(this, Observer {
            rv_animal_list.adapter = UsersListAdapter(it, { partItem : UsersList -> partItemClicked(partItem) })
        })

        rv_animal_list = findViewById(R.id.rv_animal_list)
        rv_animal_list.layoutManager = LinearLayoutManager(this)
        infoViewModel.getAll()
        infoViewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                supportFragmentManager.let{
                    dialog.show(it, "Loading....")
                }
            } else {
                dialog.dismiss()
            }
        })
    }

    private fun partItemClicked(partItem : UsersList) {
//        Toast.makeText(this, "Clicked: ${partItem.login}", Toast.LENGTH_LONG).show()
        val intent = Intent(applicationContext,Userinfo::class.java).apply {
            putExtra("name", partItem.login)
        }
        startActivity(intent)
    }
}
