package kr.ac.hallym.mobileportfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.mobileportfolio.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_profile)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}