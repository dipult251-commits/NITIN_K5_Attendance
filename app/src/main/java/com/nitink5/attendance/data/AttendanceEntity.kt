package com.nitink5.attendance.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance_table")
data class AttendanceEntity(
    @PrimaryKey
    val date: String,
    val day: String,
    val status: String,
    val markedTime: String,
    val timestamp: Long = System.currentTimeMillis()
)
