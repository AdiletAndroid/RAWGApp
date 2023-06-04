package com.example.rawgapp.auth.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.rawgapp.R
import com.example.rawgapp.common.mvp.BaseMvpFragment
import com.example.rawgapp.databinding.FragmentRegistrationBinding
import com.example.rawgapp.game.ui.GamesFragment
import com.example.rawgapp.utils.extensions.replaceFragment
import com.example.rawgapp.utils.extensions.viewbinding.viewBinding
import org.koin.android.ext.android.inject

class RegistrationFragment :
    BaseMvpFragment<RegistrationContract.View, RegistrationContract.Presenter>(
        R.layout.fragment_registration
    ),
    RegistrationContract.View {

    companion object {
        fun create(): RegistrationFragment = RegistrationFragment()
    }

    override val presenter: RegistrationContract.Presenter by inject()

    private val binding: FragmentRegistrationBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignUp.setOnClickListener {
            val email = binding.editTextMail.text.toString()
            val password = binding.editTextPassword.text.toString()
            presenter.signUp(email, password)

        }
    }

    override fun showMain() {
        replaceFragment(GamesFragment.create())
    }

    override fun showError(@StringRes errorResId: Int) {
        Toast.makeText(requireContext(), errorResId, Toast.LENGTH_SHORT).show()
    }
}
