package com.nitink5.attendance.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nitink5.attendance.R
import com.nitink5.attendance.databinding.FragmentHomeBinding
import com.nitink5.attendance.ui.viewmodel.AttendanceViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AttendanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AttendanceViewModel::class.java)

        updateDateTime()
        setupButtons()
    }

    private fun updateDateTime() {
        val today = LocalDate.now()
        val now = LocalDateTime.now()
        binding.dateTextView.text = today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
        binding.dayTextView.text = today.dayOfWeek.toString()
        binding.timeTextView.text = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
    }

    private fun setupButtons() {
        binding.presentButton.setOnClickListener {
            viewModel.markAttendance("PRESENT")
            binding.statusTextView.text = "✅ Present Marked"
        }
        binding.absentButton.setOnClickListener {
            viewModel.markAttendance("ABSENT")
            binding.statusTextView.text = "❌ Absent Marked"
        }
        binding.leaveButton.setOnClickListener {
            viewModel.markAttendance("LEAVE")
            binding.statusTextView.text = "🟡 Leave Marked"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
