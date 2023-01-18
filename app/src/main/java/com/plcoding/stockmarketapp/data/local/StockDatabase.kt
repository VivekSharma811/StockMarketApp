package com.plcoding.stockmarketapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CompanyListingEntity::class, CompanyInfoEntity::class],
    version = 2
)
abstract class StockDatabase : RoomDatabase() {

    abstract val dao: StockDao
}