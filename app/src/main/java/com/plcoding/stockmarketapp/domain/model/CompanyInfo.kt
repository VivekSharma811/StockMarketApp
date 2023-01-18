package com.plcoding.stockmarketapp.domain.model

data class CompanyInfo(
    val symbol: String?,
    val description: String?,
    val name: String?,
    val country: String?,
    val industry: String?
) {
    fun isEmpty() = this.symbol.isNullOrEmpty()
            && this.description.isNullOrEmpty()
            && this.name.isNullOrEmpty()
            && this.country.isNullOrEmpty()
            && this.industry.isNullOrEmpty()
}
