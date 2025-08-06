package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomePageNewUserGiftBagData;

public class NewUserGiftBagModule extends HomePageModule<HomePageNewUserGiftBagData> {

    public class a extends TypeToken<HomePageNewUserGiftBagData> {
        public a() {
        }
    }

    public class b extends TypeToken<HomePageNewUserGiftBagData> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_NEW_USER_GIFT_BAG_211201";
    }

    /* renamed from: k */
    public String b(HomePageNewUserGiftBagData homePageNewUserGiftBagData) {
        return new Gson().toJson((Object) homePageNewUserGiftBagData, new b().getType());
    }

    /* renamed from: l */
    public HomePageNewUserGiftBagData c(String str) {
        return (HomePageNewUserGiftBagData) new Gson().fromJson(str, new a().getType());
    }

    public boolean m() {
        T t11 = this.f73291b;
        if (t11 == null || ((HomePageNewUserGiftBagData) t11).getShow() == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public HomePageNewUserGiftBagData i(HomePageNewUserGiftBagData homePageNewUserGiftBagData) {
        return homePageNewUserGiftBagData;
    }
}
