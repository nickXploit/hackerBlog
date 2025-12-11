package com.nickxploit.hackerblog.data

import com.nickxploit.hackerblog.model.Article
import kotlinx.coroutines.flow.Flow

class ArticleRepository(private val articleDao: ArticleDao) {
    val allArticles: Flow<List<Article>> = articleDao.getAllArticles()
    fun getArticlesByCategory(category: String): Flow<List<Article>> = articleDao.getArticlesByCategory(category)
    suspend fun getArticleById(id: String): Article? = articleDao.getArticleById(id)
    suspend fun insertArticle(article: Article) = articleDao.insertArticle(article)
    suspend fun updateArticle(article: Article) = articleDao.updateArticle(article)
    suspend fun deleteArticle(article: Article) = articleDao.deleteArticle(article)
    suspend fun deleteArticleById(id: String) = articleDao.deleteArticleById(id)
}