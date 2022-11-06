package kr.ac.hallym.mobileportfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileportfolio.databinding.ArticleListBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var datas = mutableListOf<ArticleData>()

    inner class MyViewHolder(private val binding: ArticleListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(articleData: ArticleData) {
            binding.articleTitle.text = articleData.title
            binding.articleContent.text = articleData.content
            //binding.articleImage = articleData.img
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =ArticleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datas[position])
    }


}