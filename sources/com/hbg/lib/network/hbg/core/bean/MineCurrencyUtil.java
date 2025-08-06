package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.util.SPUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MineCurrencyUtil {
    private static final String SP_KEY_CURRENCY = "SP_KEY_MINE_CURRENCY";

    private MineCurrencyUtil() {
    }

    public static List<MineAccountItem> readFromFile() {
        ArrayList arrayList = new ArrayList();
        String d11 = SPUtil.d(SP_KEY_CURRENCY, "");
        if (!TextUtils.isEmpty(d11)) {
            try {
                Iterator<JsonElement> it2 = new JsonParser().parse(d11).getAsJsonArray().iterator();
                Gson gson = new Gson();
                while (it2.hasNext()) {
                    arrayList.add((MineAccountItem) gson.fromJson(it2.next(), MineAccountItem.class));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("MineCurrencyUtil-->readFromFile", e11);
            }
        }
        return arrayList;
    }

    public static void store(List<MineAccountItem> list) {
        String str;
        if (list != null) {
            try {
                str = new Gson().toJson((Object) list);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("MineCurrencyUtil-->store", e11);
            }
            SPUtil.m(SP_KEY_CURRENCY, str);
        }
        str = "";
        SPUtil.m(SP_KEY_CURRENCY, str);
    }
}
