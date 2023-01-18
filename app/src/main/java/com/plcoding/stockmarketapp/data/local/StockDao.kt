package com.plcoding.stockmarketapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface StockDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertCompanyListings(
        companyListingEntities: List<CompanyListingEntity>
    )

    @Query("DELETE FROM companylistingentity")
    suspend fun clearCompanyListings()

    @Query(
        """
            SELECT * 
            FROM companylistingentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
            UPPER(:query) == symbol
        """
    )
    suspend fun searchCompanyListing(query: String): List<CompanyListingEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertCompanyInfo(companyInfoEntity: CompanyInfoEntity)

    @Query("DELETE FROM companyinfoentity")
    suspend fun clearAllCompanyInfo()

    @Query("DELETE FROM companyinfoentity WHERE LOWER(symbol) LIKE LOWER(:symbol)")
    suspend fun clearCompanyInfo(symbol: String)

    @Query("SELECT * FROM companyinfoentity WHERE LOWER(symbol) LIKE LOWER(:symbol)")
    suspend fun getCompanyInfo(symbol: String): CompanyInfoEntity?
}