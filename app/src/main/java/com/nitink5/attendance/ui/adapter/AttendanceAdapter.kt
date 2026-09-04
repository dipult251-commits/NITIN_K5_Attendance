package com.nitink5.attendance.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nitink5.attendance.data.AttendanceEntity
import com.nitink5.attendance.databinding.ItemAttendanceBinding

class AttendanceAdapter(private val attendanceList: List<AttendanceEntity>) :
    RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(private val binding: ItemAttendanceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(attendance: AttendanceEntity) {
            binding.dateTextView.text = attendance.date
            binding.dayTextView.text = attendance.day
            binding.statusTextView.text = attendance.status
            binding.timeTextView.text = attendance.markedTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val binding = ItemAttendanceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AttendanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        holder.bind(attendanceList[position])
    }

    override fun getItemCount(): Int = attendanceList.size
}
