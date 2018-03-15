package com.zhyx.databindingdemo.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户实体类
 * Created by Administrator on 2018/1/27.
 */

@Entity
public class Person {

    @Id(autoincrement = true)
    private long _id;

    @NotNull
    private String userName;

    @NotNull
    private String nickName;

    @NotNull
    private int age;

    @NotNull
    private String comeFrom;

    @NotNull
    private String gender;

    /**个性签名*/
    private String personalitySignature;

    private String myAddress;

    @NotNull
    private String account;

    @Generated(hash = 886738204)
    public Person(long _id, @NotNull String userName, @NotNull String nickName,
            int age, @NotNull String comeFrom, @NotNull String gender,
            String personalitySignature, String myAddress,
            @NotNull String account) {
        this._id = _id;
        this.userName = userName;
        this.nickName = nickName;
        this.age = age;
        this.comeFrom = comeFrom;
        this.gender = gender;
        this.personalitySignature = personalitySignature;
        this.myAddress = myAddress;
        this.account = account;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getComeFrom() {
        return this.comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonalitySignature() {
        return this.personalitySignature;
    }

    public void setPersonalitySignature(String personalitySignature) {
        this.personalitySignature = personalitySignature;
    }

    public String getMyAddress() {
        return this.myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    



}
