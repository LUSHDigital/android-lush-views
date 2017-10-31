package com.lush.views.sample

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_text.*

/**
 * <Class Description>
 *
 * @author Jamie Cruwys
 */
class TextSampleActivity : BaseSampleActivity() {
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            if (position == 1) {
                return WhiteTextFragment.newInstance()
            }
            return BlackTextFragment.newInstance()
        }

        override fun getCount(): Int {
            return 2
        }
    }

    class BlackTextFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_text_black, container, false)
        }

        companion object {
            fun newInstance(): BlackTextFragment {
                return BlackTextFragment()
            }
        }
    }

    class WhiteTextFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_text_white, container, false)
        }

        companion object {
            fun newInstance(): WhiteTextFragment {
                return WhiteTextFragment()
            }
        }
    }
}