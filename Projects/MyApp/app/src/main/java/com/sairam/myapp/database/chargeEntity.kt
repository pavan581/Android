package com.sairam.myapp.database

data class chargeEntity (
        val chargeId: Long = 0L,
        val eventTimeMilli: Long = System.currentTimeMillis(),
        val eventPercentage: Long,
        val eventStatus: String
)