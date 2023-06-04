package com.example.rawgapp.root.ui

import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.rawgapp.R
import com.example.rawgapp.auth.ui.RegistrationFragment
import com.example.rawgapp.common.mvp.BaseMvpActivity
import com.example.rawgapp.databinding.ActivityRootBinding
import com.example.rawgapp.game.ui.GamesFragment
import com.example.rawgapp.utils.extensions.replaceFragment
import org.koin.android.ext.android.inject

class RootActivity :
    BaseMvpActivity<RootContract.View, RootContract.Presenter>(),
    RootContract.View {

    override val presenter: RootContract.Presenter by inject()

    private lateinit var binding: ActivityRootBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.checkAuthorization()
        setStatusBarColor()
    }

    override fun showRegistration() {
        replaceFragment(RegistrationFragment.create())
    }

    override fun showMainPage() {
        replaceFragment(GamesFragment.create())
    }

    override fun setStatusBarColor() {
        val window: Window = window
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)
    }
}