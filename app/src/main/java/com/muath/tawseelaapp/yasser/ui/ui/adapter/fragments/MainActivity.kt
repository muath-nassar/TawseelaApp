package com.muath.tawseelaapp.yasser.ui.ui.adapter.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import com.muath.tawseelaapp.yasser.utils.BR;
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.databinding.ActivityMainBinding
import com.muath.tawseelaapp.yasser.Base.BaseActivity
import com.muath.tawseelaapp.yasser.helper.Constant
import com.muath.tawseelaapp.yasser.ui.ui.adapter.MainMV
import java.util.*



class MainActivity : BaseActivity<ActivityMainBinding?, MainMV?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun initItems() {
        setupViewPager()
        viewDataBinding!!.viewPager.currentItem = 0
        /*
        Calendar c = Calendar.getInstance();
        DecimalFormat decimalFormat = new DecimalFormat("##");
        getViewModel().getDaily(c.get(Calendar.YEAR)+"-"+decimalFormat.format((c.get(Calendar.MONTH)+1))+"-"+decimalFormat.format(c.get(Calendar.DAY_OF_MONTH)-1));
        getViewModel().getDailyModelMutableLiveData().observe(this, new Observer<DailyModel>() {
            @Override
            public void onChanged(DailyModel dailyModel) {
                getViewModel().getTotal();
            }
        });
*/
    }

    override fun initClicks() {
        viewDataBinding!!.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> viewDataBinding!!.viewPager.currentItem = 0
                R.id.AFRIKAANS -> viewDataBinding!!.viewPager.currentItem = 1
                R.id.AFRIKAANS -> viewDataBinding!!.viewPager.currentItem = 2
            }
            false
        }
    }

    private fun setupViewPager() {
        val viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager
        )
        viewPagerAdapter.addFragment(Constant.homeFragment)
        viewPagerAdapter.addFragment(Constant.staticFragment)
        viewPagerAdapter.addFragment(Constant.chatFragment)

/*
        viewPagerAdapter.addFragment(fragmentWallet);
        viewPagerAdapter.addFragment(fragmentNavigationDrawer);
*/      viewDataBinding!!.viewPager.adapter = viewPagerAdapter
        viewDataBinding!!.viewPager.offscreenPageLimit = 3
    }

    override fun getViewModel(): MainMV {
        return ViewModelProviders.of(this)[MainMV::class.java]
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager?) :
        FragmentPagerAdapter(manager!!) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            mFragmentList.add(fragment)
        }
    }
}