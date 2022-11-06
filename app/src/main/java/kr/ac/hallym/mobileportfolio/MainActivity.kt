package kr.ac.hallym.mobileportfolio

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.mobileportfolio.databinding.ActivityMainBinding
import kr.ac.hallym.mobileportfolio.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:RecyclerViewAdapter

    val articleDatas = mutableListOf<ArticleData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializelist()
        initArticleRecyclerView()
    }


    override fun onSupportNavigateUp(): Boolean { // 앱 재시작
        onBackPressed()

        finishAffinity()
        val intent = Intent(this, IntroActivity::class.java)
        startActivity(intent)

        return super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // 오버플로 메뉴 추가
        val ProfilePicture: MenuItem? = menu?.add(0, 1, 0, getString(R.string.profile_picture))

        return super.onCreateOptionsMenu(menu)
    }


    fun initArticleRecyclerView() {
        val adapter = RecyclerViewAdapter()
        adapter.datas = articleDatas
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }


    fun initializelist() {
        with(articleDatas) {
            add(ArticleData(getString(R.string.article_title1), getString(R.string.article_content1)),1)
            add(ArticleData(getString(R.string.article_title2), getString(R.string.article_content2)),1)
        }
    }
}