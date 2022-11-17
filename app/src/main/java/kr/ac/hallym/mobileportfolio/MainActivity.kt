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
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
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

        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this,binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("kk", "navigation item is clicked: ${it.title}")
            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // 액션바 메뉴 추가
        menuInflater.inflate(R.menu.menu_main, menu)

        val menuItem = menu?.findItem(R.id.mainSearch)
        val searchView = menuItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{ // 검색기능 구현 전
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
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

//    fun initArticleRecyclerView() {
//        val adapter = MyAdapter(articleDatas)
//        adapter.datas = articleDatas
//        binding.itemData.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.addItemDecoration(MyDecoration(this))
//    }
//
//    fun initializelist() { // 내용 추가
//        with(articleDatas) {
//            add(ArticleData(getString(R.string.article_title1), getString(R.string.article_content1), 1))
//            add(ArticleData(getString(R.string.article_title2), getString(R.string.article_content2),1))
//            add(ArticleData(getString(R.string.article_title3), getString(R.string.article_content3),1))
//            add(ArticleData(getString(R.string.article_title4), getString(R.string.article_content4),1))
//            add(ArticleData(getString(R.string.article_title5), getString(R.string.article_content5),1))
//            add(ArticleData(getString(R.string.article_title6), getString(R.string.article_content6),1))
//        }
//    }
}

