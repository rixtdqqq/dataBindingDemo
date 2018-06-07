package com.zhyx.databindingdemo.viewmodel.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhyx.databindingdemo.viewmodel.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBindingAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter<ViewHolder> {
    protected Context context;
    protected List<M> items;

    public BaseBindingAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(context), getLayoutResId(viewType), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        B binding = (B) holder.getBinding();
        onBindItem(binding, items.get(position));
    }

    protected abstract @LayoutRes
    int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, M item);
}
