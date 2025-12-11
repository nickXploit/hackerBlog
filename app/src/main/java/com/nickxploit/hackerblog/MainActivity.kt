package com.nickxploit.hackerblog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.nickxploit.hackerblog.data.AppDatabase
import com.nickxploit.hackerblog.data.ArticleRepository
import com.nickxploit.hackerblog.ui.AppNavHost
import com.nickxploit.hackerblog.ui.ArticleViewModel
import com.nickxploit.hackerblog.ui.ArticleViewModelFactory
import com.nickxploit.hackerblog.ui.theme.HackerBlogTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getDatabase(applicationContext)
        val repository = ArticleRepository(database.articleDao())
        val factory = ArticleViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[ArticleViewModel::class.java]

        setContent {
            HackerBlogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(viewModel = viewModel)
                }
            }
        }
    }
}