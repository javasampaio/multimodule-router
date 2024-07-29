package br.com.core.router.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager

interface Router {
    fun navigateToActivity(context: Context, activityAction: String, bundle: Bundle?)

    fun navigateTo(
        context: Context,
        supportFragmentManager: FragmentManager,
        hostFragment: Int,
        routePath: String,
        bundle: Bundle?
    )
}