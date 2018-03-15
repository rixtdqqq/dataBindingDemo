package com.zhyx.databindingdemo.viewmodel.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.ItemPersonBinding;
import com.zhyx.databindingdemo.model.Person;
import com.zhyx.databindingdemo.viewmodel.HomeFragmentViewModel;

import java.util.List;

/**
 *  Created by Administrator on 2018/1/27.
 */

public class MyListAdapter extends BaseAdapter {

    private List<Person> mPeoples;
    private Context mContext;
    public MyListAdapter(List<Person> peoples, Context context) {
        mPeoples = peoples;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPeoples.size();
    }

    @Override
    public Person getItem(int i) {
        return mPeoples.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemPersonBinding binding;
        MyViewHolder holder;
        if (null == view) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_person, viewGroup, false);
            holder = new MyViewHolder();
            holder.setBinding(binding);
            view = binding.getRoot();
            view.setTag(holder);
        } else {
            holder = (MyViewHolder) view.getTag();
            binding = holder.getBinding();
        }
        binding.setViewModel(new HomeFragmentViewModel());
        binding.setPerson(mPeoples.get(i));
        return view;
    }


    private static class MyViewHolder {
        private ItemPersonBinding mBinding;

        public ItemPersonBinding getBinding() {
            return mBinding;
        }

        public void setBinding(ItemPersonBinding binding) {
            mBinding = binding;
        }
    }
}
