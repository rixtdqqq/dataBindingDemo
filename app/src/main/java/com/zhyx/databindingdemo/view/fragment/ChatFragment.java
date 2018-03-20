package com.zhyx.databindingdemo.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhyx.databindingdemo.R;
import com.zhyx.databindingdemo.databinding.FragmentChatBinding;
import com.zhyx.databindingdemo.databinding.FragmentHomeBinding;
import com.zhyx.databindingdemo.view.base.BaseFragment;

/**
 * 聊天
 * Created by Administrator on 2018/1/27.
 */

public class ChatFragment extends BaseFragment {


    public static final String ARGS_PARAMS = "params";
    private String fragmentFlag;
    public static ChatFragment newInstance(String params) {
        Bundle args = new Bundle();
        args.putString(ARGS_PARAMS,params);
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
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

        FragmentChatBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false);
        return binding.getRoot();
    }
}
