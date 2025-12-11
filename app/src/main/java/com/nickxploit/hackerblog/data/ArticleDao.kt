package com.nickxploit.hackerblog.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nickxploit.hackerblog.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles ORDER BY createdAt DESC")
    fun getAllArticles(): Flow<List<Article>>

    @Query("SELECT * FROM articles WHERE id = :id")
    suspend fun getArticleById(id: String): Article?

    @Query("SELECT * FROM articles WHERE category = :category ORDER BY createdAt DESC")
    fun getArticlesByCategory(category: String): Flow<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<Article>)

    @Update
    suspend fun updateArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("DELETE FROM articles WHERE id = :id")
    suspend fun deleteArticleById(id: String)

    @Query("SELECT COUNT(*) FROM articles")
    suspend fun getArticleCount(): Int
}