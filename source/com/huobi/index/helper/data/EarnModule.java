package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;

public class EarnModule extends HomePageModule<HomePageEarnData> {

    /* renamed from: c  reason: collision with root package name */
    public boolean f73287c = true;

    public String e() {
        return "SP_TAG_EARN_211201";
    }

    public boolean g() {
        return m();
    }

    /* renamed from: k */
    public String b(HomePageEarnData homePageEarnData) {
        return new Gson().toJson((Object) homePageEarnData);
    }

    /* renamed from: l */
    public HomePageEarnData c(String str) {
        HomePageEarnData homePageEarnData = (HomePageEarnData) new Gson().fromJson(str, HomePageEarnData.class);
        boolean z11 = true;
        if (homePageEarnData.show != 1) {
            z11 = false;
        }
        this.f73287c = z11;
        return homePageEarnData;
    }

    public boolean m() {
        return f(34);
    }

    public boolean n() {
        return this.f73287c && m();
    }

    /* renamed from: o */
    public HomePageEarnData i(HomePageEarnData homePageEarnData) {
        if (homePageEarnData == null) {
            return null;
        }
        boolean z11 = true;
        if (homePageEarnData.show != 1) {
            z11 = false;
        }
        this.f73287c = z11;
        return homePageEarnData;
    }
}
