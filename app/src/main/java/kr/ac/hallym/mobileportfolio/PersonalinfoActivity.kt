package kr.ac.hallym.mobileportfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.mobileportfolio.databinding.ActivityPersonalinfoBinding

class PersonalinfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_personalinfo)
        val binding = ActivityPersonalinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}