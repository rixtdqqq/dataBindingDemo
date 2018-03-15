package com.zhyx.databindingdemo.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.FragmentMeBinding;
import com.zhyx.databindingdemo.view.activity.MainActivity;
import com.zhyx.databindingdemo.view.base.BaseFragment;
import com.zhyx.databindingdemo.viewmodel.MeFragmentViewModel;

/**
 * 我的页面
 * Created by Administrator on 2018/1/27.
 */

public class MeFragment extends BaseFragment {


    public static final String ARGS_PARAMS = "params";
    private String fragmentFlag;
    private MainActivity mMainActivity;
    public static MeFragment newInstance(String params) {
        Bundle args = new Bundle();
        args.putString(ARGS_PARAMS,params);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity= (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            fragmentFlag = arguments.getString(ARGS_PARAMS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentMeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false);
        binding.setViewModel(new MeFragmentViewModel(mMainActivity));
        return binding.getRoot();
    }
}
