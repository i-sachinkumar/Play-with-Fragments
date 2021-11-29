package com.ihrsachin.androidme.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.ihrsachin.androidme.R
import com.ihrsachin.androidme.data.AndroidImageAssets

class AndroidMeActivity : AppCompatActivity() {
    lateinit var headFragment : BodyPartFragment
    lateinit var bodyFragment : BodyPartFragment
    lateinit var legFragment : BodyPartFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) supportActionBar!!.hide()

        if(savedInstanceState == null) {
            // TODO (5) Create a new BodyPartFragment instance and display it using the FragmentManager

            val intent = intent
            val indexes = intent.getBundleExtra("indexes")

            headFragment = BodyPartFragment()
            headFragment.setListAndIndex(AndroidImageAssets.getHeads(), indexes!!.get("head_index") as Int)

            bodyFragment = BodyPartFragment()
            bodyFragment.setListAndIndex(AndroidImageAssets.getBodies(), indexes.get("body_index") as Int)

            legFragment = BodyPartFragment()
            legFragment.setListAndIndex(AndroidImageAssets.getLegs(), indexes.get("body_index") as Int)
            val fragmentManager: FragmentManager = supportFragmentManager

            fragmentManager.beginTransaction().add(R.id.head_section, headFragment).commit()
            fragmentManager.beginTransaction().add(R.id.body_section, bodyFragment).commit()
            fragmentManager.beginTransaction().add(R.id.leg_section, legFragment).commit()
        }
    }
}