package com.nitink5.attendance.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nitink5.attendance.data.PreferenceManager
import com.nitink5.attendance.databinding.FragmentSettingsBinding
import com.nitink5.attendance.ui.viewmodel.AttendanceViewModel

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AttendanceViewModel
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AttendanceViewModel::class.java)
        preferenceManager = PreferenceManager(requireContext())

        binding.darkModeSwitch.isChecked = preferenceManager.isDarkMode()
        binding.darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            preferenceManager.setDarkMode(isChecked)
        }

        binding.clearDataButton.setOnClickListener {
            viewModel.deleteAllAttendance()
            binding.statusMessage.text = "✅ All data cleared"
        }

        binding.appInfoButton.setOnClickListener {
            binding.statusMessage.text = "NITIN K5 v1.0.0\nSelf Attendance App"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
