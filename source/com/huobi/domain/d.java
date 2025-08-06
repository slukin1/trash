package com.huobi.domain;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.lib.core.util.NightHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f43822a = new d();

    public static String a() {
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put("global_api", DomainSwitcher.O().replace("/-/x/pro/", ""));
        hashMap.put("theme", NightHelper.e().g() ? "1" : "0");
        return gson.toJson((Object) hashMap);
    }

    public static String b(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        TextUtils.isEmpty(b(str));
        return str;
    }
}
