package com.nitink5.attendance.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AttendanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(attendance: AttendanceEntity)

    @Update
    suspend fun updateAttendance(attendance: AttendanceEntity)

    @Delete
    suspend fun deleteAttendance(attendance: AttendanceEntity)

    @Query("SELECT * FROM attendance_table WHERE date = :date")
    suspend fun getAttendanceByDate(date: String): AttendanceEntity?

    @Query("SELECT * FROM attendance_table ORDER BY date DESC")
    fun getAllAttendance(): LiveData<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance_table WHERE date LIKE :monthYear ORDER BY date DESC")
    fun getAttendanceByMonth(monthYear: String): LiveData<List<AttendanceEntity>>

    @Query("SELECT COUNT(*) FROM attendance_table WHERE status = 'PRESENT'")
    fun getPresentCount(): LiveData<Int>

    @Query("SELECT COUNT(*) FROM attendance_table WHERE status = 'ABSENT'")
    fun getAbsentCount(): LiveData<Int>

    @Query("SELECT COUNT(*) FROM attendance_table WHERE status = 'LEAVE'")
    fun getLeaveCount(): LiveData<Int>

    @Query("SELECT COUNT(DISTINCT date) FROM attendance_table")
    fun getTotalDaysCount(): LiveData<Int>

    @Query("DELETE FROM attendance_table")
    suspend fun deleteAllAttendance()
}
