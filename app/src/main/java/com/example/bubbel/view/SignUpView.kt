package com.example.bubbel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.databinding.ActivitySignupBinding
import com.example.bubbel.viewmodel.SignUpViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {
    private lateinit var binding: ActivitySignupBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySignupBinding.inflate(inflater, container, false)
        setupViews()
        return binding.root
    }

    private fun setupViews() {
        val signUpButton = binding.signUpButton

        signUpButton.setOnClickListener {
            val username = binding.usernameInputFieldSignup.text.toString()
            val email = binding.emailInputFieldSignup.text.toString()
            val password = binding.passwordInputFieldSignup.text.toString()
            val confirmPassword = binding.confirmPasswordInputFieldSignup.text.toString()

            // Pass the input values to the SignUpViewModel for further processing
            CoroutineScope(Dispatchers.Main).launch {
                println("success")
                viewModel.submitSignUp(username, email, password, confirmPassword)
                println("success")
            }
        }
    }
}
