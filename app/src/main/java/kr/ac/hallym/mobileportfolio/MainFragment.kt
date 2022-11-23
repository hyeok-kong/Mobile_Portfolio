package kr.ac.hallym.mobileportfolio

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.mobileportfolio.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        val contents = mutableListOf<Career>()
        for(i in 1..20)
            contents.add(Career("제목$i", "내용$i"))

        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerview.layoutManager = layoutManager
        val adapter = MyAdapter(contents)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(MyDecoration(activity as Context))

        return binding.root
    }
}