package com.nitink5.attendance.data

import androidx.lifecycle.LiveData
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class AttendanceRepository(private val attendanceDao: AttendanceDao) {
    val allAttendance: LiveData<List<AttendanceEntity>> = attendanceDao.getAllAttendance()
    val presentCount: LiveData<Int> = attendanceDao.getPresentCount()
    val absentCount: LiveData<Int> = attendanceDao.getAbsentCount()
    val leaveCount: LiveData<Int> = attendanceDao.getLeaveCount()
    val totalDaysCount: LiveData<Int> = attendanceDao.getTotalDaysCount()

    suspend fun insertAttendance(attendance: AttendanceEntity) {
        attendanceDao.insertAttendance(attendance)
    }

    suspend fun updateAttendance(attendance: AttendanceEntity) {
        attendanceDao.updateAttendance(attendance)
    }

    suspend fun deleteAttendance(attendance: AttendanceEntity) {
        attendanceDao.deleteAttendance(attendance)
    }

    suspend fun getAttendanceByDate(date: String): AttendanceEntity? {
        return attendanceDao.getAttendanceByDate(date)
    }

    fun getAttendanceByMonth(yearMonth: YearMonth): LiveData<List<AttendanceEntity>> {
        val monthYear = yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"))
        return attendanceDao.getAttendanceByMonth("$monthYear%")
    }

    suspend fun deleteAllAttendance() {
        attendanceDao.deleteAllAttendance()
    }
}
