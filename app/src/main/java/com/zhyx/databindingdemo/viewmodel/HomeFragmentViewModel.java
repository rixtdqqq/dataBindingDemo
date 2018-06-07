package com.zhyx.databindingdemo.viewmodel;

import android.widget.Toast;

import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.model.entity.Person;

/**
 *  Created by Administrator on 2018/1/27.
 */

public class HomeFragmentViewModel {

    public HomeFragmentViewModel() {
    }

    public void add(Person person) {
        Toast.makeText(App.getAppContext(), "姓名:"+person.getUserName()+"\n年龄:"+person.getAge()+"\n来自:"+person.getComeFrom(), Toast.LENGTH_SHORT).show();
    }
}
