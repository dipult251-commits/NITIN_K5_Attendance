package com.nitink5.attendance.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nitink5.attendance.databinding.FragmentHistoryBinding
import com.nitink5.attendance.ui.viewmodel.AttendanceViewModel

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AttendanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AttendanceViewModel::class.java)

        viewModel.allAttendance.observe(viewLifecycleOwner) { attendanceList ->
            val history = attendanceList.joinToString("\n") { attendance ->
                "${attendance.date} - ${attendance.day} - ${attendance.status} - ${attendance.markedTime}"
            }
            binding.historyTextView.text = history
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
