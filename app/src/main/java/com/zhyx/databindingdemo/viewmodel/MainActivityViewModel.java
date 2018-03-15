package com.zhyx.databindingdemo.viewmodel;

import android.databinding.BindingAdapter;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * 主页面
 *  Created by Administrator on 2018/1/27.
 */

public class MainActivityViewModel {

    public MainActivityViewModel() {
    }

    @BindingAdapter(value = {"android:adapter","android:pageChangeListener"}, requireAll = false)
    public static void setViewPagerAdapter(ViewPager viewPager, FragmentPagerAdapter adapter,ViewPager.OnPageChangeListener listener) {
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(listener);
    }
}
