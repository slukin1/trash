package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.hbg.lib.network.hbg.core.bean.HomePageNoticeData;
import java.util.ArrayList;
import java.util.List;

public class NoticeModule extends HomePageModule<HomePageNoticeData> {

    /* renamed from: c  reason: collision with root package name */
    public List<HomePageNoticeData.Notice> f73321c = null;

    public void a() {
        super.a();
        this.f73321c = null;
    }

    public String e() {
        return "SP_TAG_NOTICE_211201";
    }

    /* renamed from: k */
    public String b(HomePageNoticeData homePageNoticeData) {
        return new Gson().toJson((Object) homePageNoticeData);
    }

    /* renamed from: l */
    public HomePageNoticeData c(String str) {
        HomePageNoticeData homePageNoticeData = (HomePageNoticeData) new Gson().fromJson(str, HomePageNoticeData.class);
        this.f73321c = homePageNoticeData.getNormal();
        return homePageNoticeData;
    }

    public List<HomePageNoticeData.Notice> m() {
        return this.f73321c;
    }

    /* renamed from: n */
    public HomePageNoticeData i(HomePageNoticeData homePageNoticeData) {
        List<HomePageNoticeData.Notice> list = null;
        if (homePageNoticeData == null) {
            return null;
        }
        HomePageNoticeData o11 = o(homePageNoticeData);
        if (o11 != null) {
            list = o11.getNormal();
        }
        this.f73321c = list;
        return o11;
    }

    public final HomePageNoticeData o(HomePageNoticeData homePageNoticeData) {
        HomePageNoticeData homePageNoticeData2 = new HomePageNoticeData();
        ArrayList arrayList = new ArrayList();
        homePageNoticeData2.setNormal(arrayList);
        if (homePageNoticeData != null) {
            if (homePageNoticeData.getTop() != null && homePageNoticeData.getTop().size() > 0) {
                arrayList.addAll(homePageNoticeData.getTop());
            }
            if (homePageNoticeData.getNormal() != null && homePageNoticeData.getNormal().size() > 0) {
                arrayList.addAll(homePageNoticeData.getNormal());
            }
        }
        return homePageNoticeData2;
    }
}
