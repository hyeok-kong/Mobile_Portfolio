package kr.ac.hallym.mobileportfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileportfolio.databinding.ArticleListBinding

class MyViewHolder(val binding: ArticleListBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val contents: MutableList<ArticleData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<ArticleData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ArticleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding

        binding.articleTitle.text = datas[position].title
        binding.articleContent.text = datas[position].content
    }
}