package com.example.presentation.ui.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAuthUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthUserFragment : Fragment(R.layout.fragment_auth_user) {
    private val binding by viewBinding(FragmentAuthUserBinding::bind)
    private val viewModel by viewModels<AuthUserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRequest()
    }

    private fun setupRequest() = with(binding) {
        btnSignUp.setOnClickListener {
            val name = etName.text.toString().trim()
            val surname = etSurname.text.toString().trim()
            val age = etAge.text.toString().trim()

            when {
                name.isNotEmpty() && surname.isNotEmpty() && age.isNotEmpty() -> {
                    viewModel.authUser(name, surname, age.toInt())
                    findNavController().navigate(R.id.action_authUserFragment_to_userInformationFragment)
                }
                else -> {
                    Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}