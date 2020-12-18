package com.kylix.submissionbajp1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kylix.submissionbajp1.R
import com.kylix.submissionbajp1.utils.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        toolbar.title = getString(R.string.app_name)
        viewPager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
}