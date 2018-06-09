package com.zhyx.databindingdemo.viewmodel;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.zhyx.databindingdemo.App;
import com.zhyx.databindingdemo.databinding.ActivityUserRegisterBinding;
import com.zhyx.databindingdemo.model.entity.ProvinceBean;
import com.zhyx.databindingdemo.util.ProvinceUtil;
import com.zhyx.databindingdemo.view.activity.UserRegisterActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * 注册页面
 * Created by Administrator on 2018/1/27.
 */

public class UserRegisterActivityViewModel {

    private UserRegisterActivity mActivity;
    private ActivityUserRegisterBinding mBinding;
    private OptionsPickerView pvOptions;

    public UserRegisterActivityViewModel(UserRegisterActivity activity, ActivityUserRegisterBinding binding) {
        mActivity = activity;
        mBinding = binding;
    }

    public void submit(String userName,
                       String password,
                       String passwordConfirm,
                       int gender,
                       String nickname,
                       String area) {

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(App.getAppContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(App.getAppContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordConfirm)) {
            Toast.makeText(App.getAppContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(nickname)) {
            Toast.makeText(App.getAppContext(), "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(area)) {
            Toast.makeText(App.getAppContext(), "请选择地区", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!TextUtils.equals(password, passwordConfirm)) {
            Toast.makeText(App.getAppContext(), "密码输入不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(App.getAppContext(), "提交成功", Toast.LENGTH_SHORT).show();

    }

    /**
     * 城市联动弹窗
     */
    public void selectArea() {
        getProvinceData();

    }


    //  省份
    private ArrayList<ProvinceBean> provinceBeanList = new ArrayList<>();
    //  城市
    private ArrayList<List<String>> cityList = new ArrayList<>();
    //  区/县
    private ArrayList<List<List<String>>> districtList = new ArrayList<>();


    //  解析json填充集合
    private ArrayList<ProvinceBean> parseProvinceJson(String jsonData) {
        ArrayList<ProvinceBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(jsonData);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                ProvinceBean entity = gson.fromJson(data.optJSONObject(i).toString(), ProvinceBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;

    }

    private void initData(String s) {
        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */

        ArrayList<ProvinceBean> jsonBean = parseProvinceJson(s);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        provinceBeanList = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<List<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            cityList.add(CityList);

            /**
             * 添加地区数据
             */
            districtList.add(Province_AreaList);
        }
    }

    public void getProvinceData() {
        Observable.just(ProvinceUtil.getProvinceJson(mActivity,"province.json")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        if (null == pvOptions) {
                            initData(s);
                            pvOptions = new OptionsPickerView.Builder(mActivity, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    //返回的分别是三个级别的选中位置
                                    String tx = provinceBeanList.get(options1).getPickerViewText() +
                                            cityList.get(options1).get(options2) +
                                            districtList.get(options1).get(options2).get(options3);
                                    mBinding.setArea(tx);

                                }
                            })
                                    .setTitleText("城市选择")
                                    .setTitleSize(16)
                                    .setCancelText("取消")
                                    .setOutSideCancelable(true)
                                    .setSubmitText("确定")
                                    .setContentTextSize(14)
                                    .setDividerColor(Color.BLACK)
                                    .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                                    .build();
                            pvOptions.setPicker(provinceBeanList, cityList, districtList);
                        }
                        if (!pvOptions.isShowing()) {
                            pvOptions.show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
