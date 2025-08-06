package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomeCommonData;

public class HomeCommonDataModule extends HomePageModule<HomeCommonData> {

    public class a extends TypeToken<HomeCommonData> {
        public a() {
        }
    }

    public class b extends TypeToken<HomeCommonData> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_HOME_COMMON_DATA_211201";
    }

    /* renamed from: k */
    public String b(HomeCommonData homeCommonData) {
        return new Gson().toJson((Object) homeCommonData, new b().getType());
    }

    /* renamed from: l */
    public HomeCommonData c(String str) {
        return (HomeCommonData) new Gson().fromJson(str, new a().getType());
    }

    /* renamed from: m */
    public HomeCommonData i(HomeCommonData homeCommonData) {
        return homeCommonData;
    }
}
