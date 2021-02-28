package com.sample.demo.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.myapplication.adapter.UsersListAdapter
import com.sample.demo.myapplication.bean.UsersList
import com.sample.demo.myapplication.net.InfoViewModel
import com.sample.demo.myapplication.ui.ProgressbarFragment
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.animal_list_item.view.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


class Userinfo : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val intent = intent
        var message = intent.getStringExtra("name")


        val dialog = ProgressbarFragment.newInstance(getString(R.string.uploading))
        infoViewModel.userInfoLiveData.observe(this, Observer {
            Glide
                .with(imageView)
                .load(it.avatar_url)
                .centerCrop()
                .into(imageView);
            textView.text = "name:" + it.name
            textView2.text = "bio:" + it.bio
            textView3.text = "login:" + it.login
            textView4.text = "site_admin:" + it.site_admin
            textView5.text = "location:" + it.location
            textView6.text = "blog:" + it.blog
        })


        infoViewModel.getusers(message)
        infoViewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                supportFragmentManager.let {
                    dialog.show(it, "Loading....")
                }
            } else {
                dialog.dismiss()
            }
        })
    }


}
