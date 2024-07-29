package br.com.core.router.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager

class RouterImpl: Router {
    override fun navigateToActivity(context: Context, activityAction: String, bundle: Bundle?) = with(context) {
        val intent = Intent(activityAction)
        if (packageManager.resolveActivity(intent, 0) != null) {
            bundle?.let {
                intent.putExtras(it)
            }
            startActivity(intent)
        }
    }

    override fun navigateTo(
        context: Context,
        supportFragmentManager: FragmentManager,
        hostFragment: Int,
        routePath: String,
        bundle: Bundle?
    ) {
        val fragmentClassPath = FragmentFactory.loadFragmentClass(context.classLoader, routePath)
        val fragmentInstance = fragmentClassPath.getConstructor().newInstance()

        bundle?.let {
            fragmentInstance.arguments = it
        }

        supportFragmentManager.beginTransaction().apply {
            add(hostFragment, fragmentInstance, routePath)
        }.commitAllowingStateLoss()
    }
}