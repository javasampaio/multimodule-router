package br.com.sam.some

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.com.core.router.ui.FEATURE_ONE_ACTION
import br.com.core.router.ui.FEATURE_THREE_ACTION
import br.com.core.router.ui.Router
import br.com.sam.some.databinding.FeatureSomeActivityBinding
import org.koin.android.ext.android.inject

class FeatureSomeActivity : AppCompatActivity() {

    private lateinit var binding: FeatureSomeActivityBinding
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FeatureSomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.featureBtn.setOnClickListener {
            router.navigateToActivity(this@FeatureSomeActivity, FEATURE_ONE_ACTION)
        }
    }
}