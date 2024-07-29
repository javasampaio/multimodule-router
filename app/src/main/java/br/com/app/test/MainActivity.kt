package br.com.app.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.app.test.databinding.MainActivityBinding
import br.com.core.router.ui.Router
import br.com.core.router.ui.FEATURE_ONE_ACTION
import br.com.core.router.ui.FEATURE_TWO_ACTION
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.feature1Btn.setOnClickListener {
            router.navigateToActivity(this@MainActivity, FEATURE_ONE_ACTION)
        }

        binding.feature2Btn.setOnClickListener {
            router.navigateToActivity(this@MainActivity, FEATURE_TWO_ACTION)
        }
    }
}