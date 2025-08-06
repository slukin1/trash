package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class GroupUserItemData implements Serializable {
    private String account;
    private String avatar;
    private int isForbid;
    private String nickname;
    private int role;

    public String getAccount() {
        return this.account;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getIsForBid() {
        return this.isForbid;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getRole() {
        return this.role;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setIsForBid(int i11) {
        this.isForbid = i11;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setRole(int i11) {
        this.role = i11;
    }
}
