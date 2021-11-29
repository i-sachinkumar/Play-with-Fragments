package com.ihrsachin.androidme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.ihrsachin.androidme.R

public class BodyPartFragment : Fragment() {

    private var res_list: List<Int>? = null
    private var index: Int = 0

    val LIST_IMG_IDS = "list_img_id"
    val IMG_INDEX = "img_index"

    public fun setListAndIndex(list : List<Int>, index: Int){
        res_list = list
        this.index = index
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        if(savedInstanceState != null){
            res_list = savedInstanceState.getIntegerArrayList(LIST_IMG_IDS) as ArrayList<Int>
            index = savedInstanceState.getInt(IMG_INDEX)
        }


        val rootView : View? = inflater.inflate(R.layout.fragment_body_part,container,false)
        val body_part_imageView = rootView!!.findViewById<ImageView>(R.id.body_part_imageView)

        body_part_imageView.setOnClickListener{
            index = (index+1)%res_list!!.size
            body_part_imageView.setImageResource(res_list!![index])
        }
        body_part_imageView.setImageResource(res_list!![index])
        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList(LIST_IMG_IDS, res_list as ArrayList<Int>)
        outState.putInt(IMG_INDEX, index)
    }

}

