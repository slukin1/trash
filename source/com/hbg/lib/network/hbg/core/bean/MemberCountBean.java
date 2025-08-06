package com.hbg.lib.network.hbg.core.bean;

import java.util.ArrayList;

public class MemberCountBean {
    private ArrayList<GiftUser> giftTopUser;
    private String memberCount;

    public ArrayList<GiftUser> getGiftTopUser() {
        return this.giftTopUser;
    }

    public String getMemberCount() {
        return this.memberCount;
    }

    public void setGiftTopUser(ArrayList<GiftUser> arrayList) {
        this.giftTopUser = arrayList;
    }

    public void setMemberCount(String str) {
        this.memberCount = str;
    }
}
