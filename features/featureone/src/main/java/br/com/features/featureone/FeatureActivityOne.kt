package br.com.features.featureone

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.com.core.router.ui.FEATURE_TWO_ACTION
import br.com.core.router.ui.Router
import br.com.features.featureone.databinding.FeatureOneActivityBinding
import org.koin.android.ext.android.inject

class FeatureActivityOne : AppCompatActivity() {

    private lateinit var binding: FeatureOneActivityBinding
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FeatureOneActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.featureBtn.setOnClickListener {
            router.navigateToActivity(this@FeatureActivityOne, FEATURE_TWO_ACTION)
        }
    }
}