package com.hbg.lib.data.symbol;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.util.SPUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProCurrenciesUtil {
    public static int a(CurrencyBean currencyBean, CurrencyBean currencyBean2) {
        Integer num;
        int i11 = 0;
        try {
            num = Integer.valueOf(b(currencyBean2.getWeight(), 0));
            try {
                i11 = Integer.valueOf(b(currencyBean.getWeight(), 0));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    public static int b(String str, int i11) {
        if (!(str == null || str.length() == 0)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return i11;
    }

    public static List<CurrencyBean> c() {
        ArrayList arrayList = new ArrayList();
        String d11 = SPUtil.d("SP_KEY_CURRENCY", "");
        if (!TextUtils.isEmpty(d11)) {
            try {
                Iterator<JsonElement> it2 = new JsonParser().parse(d11).getAsJsonArray().iterator();
                Gson gson = new Gson();
                while (it2.hasNext()) {
                    arrayList.add((CurrencyBean) gson.fromJson(it2.next(), CurrencyBean.class));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("ProCurrenciesUtil-->readFromFile", e11);
            }
        }
        return arrayList;
    }

    public static void d(List<CurrencyBean> list) {
        String str;
        if (list != null) {
            try {
                str = new Gson().toJson((Object) list);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("ProCurrenciesUtil-->store", e11);
            }
            SPUtil.m("SP_KEY_CURRENCY", str);
        }
        str = "";
        SPUtil.m("SP_KEY_CURRENCY", str);
    }
}
