package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
    private String avatar;
    private String email;
    private String introduction;
    private int isCustomer;
    private String jobNo;
    private String nickname;

    public String getAvatar() {
        return this.avatar;
    }

    public String getEmail() {
        return this.email;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public int getIsCustomer() {
        return this.isCustomer;
    }

    public String getJobNo() {
        return this.jobNo;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setIsCustomer(int i11) {
        this.isCustomer = i11;
    }

    public void setJobNo(String str) {
        this.jobNo = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }
}
