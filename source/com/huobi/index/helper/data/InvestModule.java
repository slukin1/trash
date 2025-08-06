package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.hbg.lib.network.hbg.core.bean.HomePageInvestData;

public class InvestModule extends HomePageModule<HomePageInvestData> {

    /* renamed from: c  reason: collision with root package name */
    public boolean f73297c = true;

    public String e() {
        return "SP_TAG_INVEST_AREA_211201";
    }

    /* renamed from: k */
    public String b(HomePageInvestData homePageInvestData) {
        return new Gson().toJson((Object) homePageInvestData);
    }

    /* renamed from: l */
    public HomePageInvestData c(String str) {
        HomePageInvestData homePageInvestData = (HomePageInvestData) new Gson().fromJson(str, HomePageInvestData.class);
        this.f73297c = homePageInvestData.show;
        return homePageInvestData;
    }

    /* renamed from: m */
    public HomePageInvestData i(HomePageInvestData homePageInvestData) {
        if (homePageInvestData == null) {
            return null;
        }
        this.f73297c = homePageInvestData.show;
        return homePageInvestData;
    }
}
