package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomePageNewHandAreaData;

public class NewHandAreaModule extends HomePageModule<HomePageNewHandAreaData> {

    public class a extends TypeToken<HomePageNewHandAreaData> {
        public a() {
        }
    }

    public class b extends TypeToken<HomePageNewHandAreaData> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_NEW_HAND_AREA_211201";
    }

    /* renamed from: k */
    public String b(HomePageNewHandAreaData homePageNewHandAreaData) {
        return new Gson().toJson((Object) homePageNewHandAreaData, new b().getType());
    }

    /* renamed from: l */
    public HomePageNewHandAreaData c(String str) {
        return (HomePageNewHandAreaData) new Gson().fromJson(str, new a().getType());
    }

    /* renamed from: m */
    public HomePageNewHandAreaData i(HomePageNewHandAreaData homePageNewHandAreaData) {
        return homePageNewHandAreaData;
    }
}
