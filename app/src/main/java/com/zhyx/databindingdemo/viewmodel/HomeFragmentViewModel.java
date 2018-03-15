package com.zhyx.databindingdemo.viewmodel;

import android.widget.Toast;

import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.model.Person;

/**
 *  Created by Administrator on 2018/1/27.
 */

public class HomeFragmentViewModel {

    public HomeFragmentViewModel() {
    }

    /**
     * 布局中的提交按钮的点击事件
     * @param text editText控件中值
     */
    public void submit(String text){

        Toast.makeText(App.getAppContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void add(Person person) {
        Toast.makeText(App.getAppContext(), "姓名:"+person.getUserName()+"\n年龄:"+person.getAge()+"\n来自:"+person.getComeFrom(), Toast.LENGTH_SHORT).show();
    }
}
