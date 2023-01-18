package com.plcoding.stockmarketapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyInfoEntity(
    @PrimaryKey val id: Int? = null,
    val symbol: String,
    val description: String,
    val name: String,
    val country: String,
    val industry: String
)