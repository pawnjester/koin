package com.andela.learnkoin

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.andela.learnkoin.databinding.ActivityMainBinding
import com.andela.learnkoin.model.Post
import com.andela.learnkoin.ui.DataState.*
import com.andela.learnkoin.ui.PostListAdapter
import com.andela.learnkoin.ui.PostListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: PostListViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    private val listAdapter by lazy {
        PostListAdapter()
    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding.postList) {
            setHasFixedSize(true)
            layoutManager  = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, false
            )
            adapter = this@MainActivity.listAdapter
        }


        viewModel.commands.subscribe {
            when(it) {
                is Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Error -> {
                    error_message.visibility = View.VISIBLE
                }
                is Data -> {
                    displayPost(it.list)
                }
            }
        }
    }

    fun displayPost(list: List<Post>) {
        error_message.visibility = View.GONE
        listAdapter.updateList(list)
    }
}
