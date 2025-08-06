package com.huobi.index.helper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.hbg.core.bean.HomeTransferAmountData;

public class HomeTransferAmountModule extends HomePageModule<HomeTransferAmountData> {

    public class a extends TypeToken<HomeTransferAmountData> {
        public a() {
        }
    }

    public class b extends TypeToken<HomeTransferAmountData> {
        public b() {
        }
    }

    public String e() {
        return "SP_TAG_HOME_TRANSFER_AMOUNT_DATA_211201";
    }

    /* renamed from: k */
    public String b(HomeTransferAmountData homeTransferAmountData) {
        return new Gson().toJson((Object) homeTransferAmountData, new b().getType());
    }

    /* renamed from: l */
    public HomeTransferAmountData c(String str) {
        return (HomeTransferAmountData) new Gson().fromJson(str, new a().getType());
    }

    /* renamed from: m */
    public HomeTransferAmountData i(HomeTransferAmountData homeTransferAmountData) {
        return homeTransferAmountData;
    }
}
