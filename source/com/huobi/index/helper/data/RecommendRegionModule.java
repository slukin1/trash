package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomePageRecommendRegionData;

public class RecommendRegionModule extends HomePageModule<HomePageRecommendRegionData> {

    public class a extends TypeToken<HomePageRecommendRegionData> {
        public a() {
        }
    }

    public class b extends TypeToken<HomePageRecommendRegionData> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_RECOMMEND_REGION_AREA_211201";
    }

    /* renamed from: k */
    public String b(HomePageRecommendRegionData homePageRecommendRegionData) {
        return new Gson().toJson((Object) homePageRecommendRegionData, new b().getType());
    }

    /* renamed from: l */
    public HomePageRecommendRegionData c(String str) {
        return (HomePageRecommendRegionData) new Gson().fromJson(str, new a().getType());
    }

    /* renamed from: m */
    public HomePageRecommendRegionData i(HomePageRecommendRegionData homePageRecommendRegionData) {
        return homePageRecommendRegionData;
    }
}
