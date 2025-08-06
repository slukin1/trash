package com.hbg.lib.data.main;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.data.main.bean.TimeStampMap;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.response.BigInterfaceResponse;
import java.lang.reflect.Type;
import java.util.List;

public class CurrencyDataDiffTools extends BaseDataDiffTools<CurrencyBean> {

    /* renamed from: b  reason: collision with root package name */
    public static final CurrencyDataDiffTools f68849b = new CurrencyDataDiffTools();

    public class a extends TypeToken<TimeStampMap<CurrencyBean>> {
        public a() {
        }
    }

    public static CurrencyDataDiffTools r() {
        return f68849b;
    }

    public String d() {
        return FirebaseAnalytics.Param.CURRENCY;
    }

    public Type e() {
        return new a().getType();
    }

    public d9.a<BigInterfaceResponse<List<CurrencyBean>>> i(String str, String str2) {
        return x8.a.a().getCurrenciesWithDiff(str2, str);
    }

    /* renamed from: s */
    public String h(CurrencyBean currencyBean) {
        return currencyBean.getName();
    }
}
