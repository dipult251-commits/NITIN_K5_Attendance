package com.nitink5.attendance.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nitink5.attendance.data.AttendanceDatabase
import com.nitink5.attendance.data.AttendanceEntity
import com.nitink5.attendance.data.AttendanceRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime

class AttendanceViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AttendanceRepository
    val allAttendance: LiveData<List<AttendanceEntity>>
    val presentCount: LiveData<Int>
    val absentCount: LiveData<Int>
    val leaveCount: LiveData<Int>
    val totalDaysCount: LiveData<Int>

    init {
        val attendanceDao = AttendanceDatabase.getDatabase(application).attendanceDao()
        repository = AttendanceRepository(attendanceDao)
        allAttendance = repository.allAttendance
        presentCount = repository.presentCount
        absentCount = repository.absentCount
        leaveCount = repository.leaveCount
        totalDaysCount = repository.totalDaysCount
    }

    fun markAttendance(status: String) {
        viewModelScope.launch {
            val today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            val existing = repository.getAttendanceByDate(today)
            if (existing == null) {
                val attendance = AttendanceEntity(
                    date = today,
                    day = LocalDate.now().dayOfWeek.toString(),
                    status = status,
                    markedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                )
                repository.insertAttendance(attendance)
            }
        }
    }

    fun updateAttendance(attendance: AttendanceEntity) {
        viewModelScope.launch {
            repository.updateAttendance(attendance)
        }
    }

    fun deleteAllAttendance() {
        viewModelScope.launch {
            repository.deleteAllAttendance()
        }
    }

    suspend fun getAttendanceByDate(date: String): AttendanceEntity? {
        return repository.getAttendanceByDate(date)
    }

    fun getTodayAttendance(): LiveData<List<AttendanceEntity>> = allAttendance
}
