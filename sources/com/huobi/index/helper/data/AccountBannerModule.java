package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.entity.HomeActivityEntity;
import java.util.ArrayList;
import tg.r;

public class AccountBannerModule extends HomePageModule<HomeActivityEntityResponse> {

    public class a extends TypeToken<HomeActivityEntityResponse> {
        public a() {
        }
    }

    public class b extends TypeToken<HomeActivityEntityResponse> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_ACCOUNT__BANNER_211201";
    }

    /* renamed from: k */
    public String b(HomeActivityEntityResponse homeActivityEntityResponse) {
        return new Gson().toJson((Object) homeActivityEntityResponse, new b().getType());
    }

    /* renamed from: l */
    public HomeActivityEntityResponse c(String str) {
        return (HomeActivityEntityResponse) new Gson().fromJson(str, new a().getType());
    }

    public HomeActivityEntityResponse m() {
        HomeActivityEntityResponse homeActivityEntityResponse = new HomeActivityEntityResponse();
        homeActivityEntityResponse.adList = new ArrayList();
        T t11 = this.f73291b;
        if (t11 != null && !((HomeActivityEntityResponse) t11).adList.isEmpty()) {
            homeActivityEntityResponse.showSize = ((HomeActivityEntityResponse) this.f73291b).showSize;
            boolean F0 = r.x().F0();
            for (HomeActivityEntity next : ((HomeActivityEntityResponse) this.f73291b).adList) {
                if (next != null && next.isShow == 0) {
                    int i11 = next.isNeedLogin;
                    if (i11 != 0) {
                        if (i11 == 1 && F0) {
                        }
                    } else if (!F0) {
                        continue;
                    }
                    if (homeActivityEntityResponse.adList.size() >= homeActivityEntityResponse.showSize) {
                        break;
                    }
                    homeActivityEntityResponse.adList.add(next);
                }
            }
        }
        return homeActivityEntityResponse;
    }
}
