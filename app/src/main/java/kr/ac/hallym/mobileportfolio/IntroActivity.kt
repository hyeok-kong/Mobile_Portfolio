package kr.ac.hallym.mobileportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.mobileportfolio.databinding.ActivityIntroBinding
import kr.ac.hallym.mobileportfolio.databinding.ActivityMainBinding

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener {
            val Intent = Intent(this, SplashActivity::class.java)
            startActivity(Intent)
            finish()
        }
    }
}