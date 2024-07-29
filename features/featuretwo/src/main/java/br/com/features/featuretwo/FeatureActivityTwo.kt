package br.com.features.featuretwo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.com.core.router.ui.FEATURE_THREE_ACTION
import br.com.core.router.ui.Router
import br.com.features.featuretwo.databinding.FeatureTwoActivityBinding
import org.koin.android.ext.android.inject

class FeatureActivityTwo : AppCompatActivity() {

    private lateinit var binding: FeatureTwoActivityBinding
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FeatureTwoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.featureBtn.setOnClickListener {
            router.navigateToActivity(this@FeatureActivityTwo, FEATURE_THREE_ACTION)
        }
    }
}