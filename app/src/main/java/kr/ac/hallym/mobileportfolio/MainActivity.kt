package kr.ac.hallym.mobileportfolio

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.mobileportfolio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: kr.ac.hallym.mobileportfolio.databinding.ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = FragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            R.string.drawer_opened,
            R.string.drawer_closed
        )
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("kk", "navigation item is clicked: ${it.title}")
            when (it.title) {
                "Personal Details" -> {
                    val intent = Intent(this, PersonalinfoActivity::class.java)
                    startActivity(intent)
                }
                "Logout" -> {
                    finishAffinity()
                    val intent = Intent(this, IntroActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
//        R.id.addArticle -> { // 내용 추가 버튼 누를 시
//            true
//        }
//
//        R.id.mainSearch -> { // 서치뷰
//            true
//        }

        return super.onOptionsItemSelected(item)
    }


//    override fun onSupportNavigateUp(): Boolean { // 메인에서 뒤로가기 버튼 클릭 시 앱 재시작
//        onBackPressed()
//
//        finishAffinity()
//        val intent = Intent(this, IntroActivity::class.java)
//        startActivity(intent)
//
//        return super.onSupportNavigateUp()
//    }

}

