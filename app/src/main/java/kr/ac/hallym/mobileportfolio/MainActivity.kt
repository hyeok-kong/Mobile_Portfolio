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
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileportfolio.databinding.ActivityMainBinding
import kr.ac.hallym.mobileportfolio.databinding.ActivitySplashBinding
import kr.ac.hallym.mobileportfolio.databinding.ArticleListBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:MyAdapter

    val articleDatas = mutableListOf<ArticleData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileBtn.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    fun initArticleRecyclerView() {
        val adapter = MyAdapter(articleDatas)
        adapter.datas = articleDatas
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(MyDecoration(this))
    }

    fun initializelist() {
        with(articleDatas) {
            add(ArticleData(getString(R.string.article_title1), getString(R.string.article_content1), 1))
            add(ArticleData(getString(R.string.article_title2), getString(R.string.article_content2),1))
            add(ArticleData(getString(R.string.article_title3), getString(R.string.article_content3),1))
            add(ArticleData(getString(R.string.article_title4), getString(R.string.article_content4),1))
            add(ArticleData(getString(R.string.article_title5), getString(R.string.article_content5),1))
            add(ArticleData(getString(R.string.article_title6), getString(R.string.article_content6),1))
        }
    }
}

class MyDecoration(val context: Context) : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        ViewCompat.setElevation(view, 30.0f)
    }
}