package com.zhyx.databindingdemo.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public ViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
    }
}
