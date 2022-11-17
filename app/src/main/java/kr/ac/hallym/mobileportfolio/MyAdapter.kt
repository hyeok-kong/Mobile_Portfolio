package kr.ac.hallym.mobileportfolio

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.mobileportfolio.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val contents: MutableList<Career>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemTitle.text = contents[position].title
        binding.itemSub.text = contents[position].sub
    }

    override fun getItemCount(): Int {
        return contents.size
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

//class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
//    override fun getItemOffsets(
//        outRect: Rect,
//        view: View,
//        parent: RecyclerView,
//        state: RecyclerView.State
//    ) {
//        super.getItemOffsets(outRect, view, parent, state)
//        val index = parent.getChildAdapterPosition(view) + 1
//        if(index % 3 == 0)
//            outRect.set(10, 10, 10, 60)
//        else
//            outRect.set(10, 10, 10, 0)
//
//        view.setBackgroundColor(Color.parseColor("#2BA0FF"))
//        ViewCompat.setElevation(view, 20.0f)
//    }
//}
