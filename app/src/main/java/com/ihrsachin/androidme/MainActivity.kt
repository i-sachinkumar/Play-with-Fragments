package com.ihrsachin.androidme

import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.ihrsachin.androidme.data.AndroidImageAssets
import com.ihrsachin.androidme.ui.BodyPartFragment

class MainActivity : AppCompatActivity() {
    lateinit var headFragment : BodyPartFragment
    lateinit var bodyFragment : BodyPartFragment
    lateinit var legFragment : BodyPartFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) supportActionBar!!.hide()

        if(savedInstanceState == null) {
            // TODO (5) Create a new BodyPartFragment instance and display it using the FragmentManager
            headFragment = BodyPartFragment()
            headFragment.setListAndIndex(AndroidImageAssets.getHeads(), 0)

            bodyFragment = BodyPartFragment()
            bodyFragment.setListAndIndex(AndroidImageAssets.getBodies(), 0)

            legFragment = BodyPartFragment()
            legFragment.setListAndIndex(AndroidImageAssets.getLegs(), 0)
            val fragmentManager: FragmentManager = supportFragmentManager

            fragmentManager.beginTransaction().add(R.id.head_section, headFragment).commit()
            fragmentManager.beginTransaction().add(R.id.body_section, bodyFragment).commit()
            fragmentManager.beginTransaction().add(R.id.leg_section, legFragment).commit()
        }
    }
}