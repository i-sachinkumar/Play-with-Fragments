package com.ihrsachin.androidme.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.ihrsachin.androidme.R
import com.ihrsachin.androidme.data.AndroidImageAssets
import java.lang.ClassCastException
import android.widget.AdapterView.OnItemClickListener


class MasterListFragment : Fragment() {


    lateinit var mCallback : OnImageClickListener

    public interface OnImageClickListener{
        fun onImageSelected(position : Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCallback = try {
            context as OnImageClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnImageClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_master_list,container,false)
        val gridView : GridView = rootView!!.findViewById(R.id.images_grid_view)
        val adapter = MasterListAdapter(requireContext(),AndroidImageAssets.getAll())
        gridView.adapter = adapter

        gridView.onItemClickListener =
            OnItemClickListener { adapterView, view, position, l ->
                // Trigger the callback method and pass in the position that was clicked
                mCallback.onImageSelected(position)
            }

        return rootView
    }
}