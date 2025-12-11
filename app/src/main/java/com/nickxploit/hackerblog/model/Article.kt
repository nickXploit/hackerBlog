package com.nickxploit.hackerblog.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
@Entity(tableName = "articles")
data class Article(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val category: String,
    val content: String,
    val tags: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)