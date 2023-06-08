package com.example.presentation.ui.fragments.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.FragmentUserInformationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserInformationFragment : Fragment(R.layout.fragment_user_information) {
    private val binding by viewBinding(FragmentUserInformationBinding::bind)
    private val viewModel by viewModels<UserInformationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        getData()
    }

    private fun initialize() = with(binding){
        txtName.isVisible = false
        txtSurname.isVisible = false
        txtAge.isVisible = false
        tvName.isVisible = false
        tvSurname.isVisible = false
        tvAge.isVisible = false
        hideData.isVisible = false
    }

    private fun setupListener() = with(binding){
        binding.showData.setOnClickListener {
            txtName.isVisible = true
            txtSurname.isVisible = true
            txtAge.isVisible = true
            tvName.isVisible = true
            tvSurname.isVisible = true
            tvAge.isVisible = true
            hideData.isVisible = true
            showData.isVisible = false
        }

        binding.hideData.setOnClickListener {
            txtName.isVisible = false
            txtSurname.isVisible = false
            txtAge.isVisible = false
            tvName.isVisible = false
            tvSurname.isVisible = false
            tvAge.isVisible = false
            showData.isVisible = true
            hideData.isVisible = false
        }
    }

    private fun getData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUser().apply {
                binding.tvName.text = name
                binding.tvSurname.text = surname
                binding.tvAge.text = age.toString()
            }
        }
    }
}