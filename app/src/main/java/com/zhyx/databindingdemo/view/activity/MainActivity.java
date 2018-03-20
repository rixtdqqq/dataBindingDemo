package com.zhyx.databindingdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ActivityMainBinding;
import com.zhyx.databindingdemo.view.fragment.ChatFragment;
import com.zhyx.databindingdemo.view.fragment.HomeFragment;
import com.zhyx.databindingdemo.view.fragment.MeFragment;
import com.zhyx.databindingdemo.viewmodel.MainActivityViewModel;
import com.zhyx.databindingdemo.viewmodel.adapter.FrgPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private ActivityMainBinding mBinding;
    private List<Fragment> mFragments;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(new MainActivityViewModel());
        mFragments = new ArrayList<>();
        mFragments.add(ChatFragment.newInstance("chat"));
        mFragments.add(HomeFragment.newInstance("1"));
        mFragments.add(HomeFragment.newInstance("2"));
        mFragments.add(MeFragment.newInstance("me"));
        mBinding.setAdapter(new FrgPageAdapter(getSupportFragmentManager(), mFragments));
        mBinding.setNavigationItemReselectedListener(this);
        mBinding.setNavigationItemSelectedListener(this);
        mBinding.setPageChangeListener(this);
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        //在此可以做刷新的操作
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.item_chat:
                mBinding.fragmentViewPager.setCurrentItem(0);
                break;
            case R.id.item_find:
                mBinding.fragmentViewPager.setCurrentItem(1);
                break;
            case R.id.item_settings:
                mBinding.fragmentViewPager.setCurrentItem(2);
                break;
            case R.id.item_me:
                mBinding.fragmentViewPager.setCurrentItem(3);
                break;
        }

        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (menuItem != null) {
            menuItem.setChecked(false);
        } else {
            mBinding.bottomNavigationView.getMenu().getItem(0).setChecked(false);
        }

        menuItem = mBinding.bottomNavigationView.getMenu().getItem(position);
        menuItem.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
