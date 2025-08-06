package com.hbg.lib.core.util;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.GlobalAppConfig;
import ex.f;
import java.util.HashMap;
import java.util.Map;

public class ChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f68664a;

    static {
        HashMap hashMap = new HashMap();
        f68664a = hashMap;
        hashMap.put(MTPushConstants.Manufacturer.HUAWEI, "11113450");
        f68664a.put("360", "11113460");
        f68664a.put("yingyongbao", "11113470");
        f68664a.put(MTPushConstants.Manufacturer.OPPO, "11113480");
        f68664a.put("vivo", "11113490");
        f68664a.put("xiaomi", "11113500");
        f68664a.put("wandoujia", "11113530");
        f68664a.put("flyme", "11113540");
        f68664a.put("baidu", "11113550");
        f68664a.put("chuizi", "11113560");
        f68664a.put("anzhuoapk", "11113570");
        f68664a.put("sanxing", "11113580");
        f68664a.put("sougouzhushou", "11113590");
        f68664a.put("lenovo", "11113600");
        f68664a.put(Constants.REFERRER_API_GOOGLE, "11113610");
        f68664a.put("anzhi", "11113620");
        f68664a.put("le", "11113630");
        f68664a.put("uc", "11113640");
        f68664a.put("huobi", "11113650");
    }

    public static String a() {
        String a11 = f.a(BaseApplication.b(), "keyid");
        if (TextUtils.isEmpty(a11)) {
            return d() ? "11113900" : "7890747";
        }
        return a11;
    }

    public static String b() {
        String c11 = f.c(BaseApplication.b());
        if (TextUtils.isEmpty(c11)) {
            return d() ? "GooglePlayAndroid" : "huobi";
        }
        return c11;
    }

    public static String c() {
        return f.a(BaseApplication.b(), "inviteid");
    }

    public static boolean d() {
        return Constants.REFERRER_API_GOOGLE.equals(GlobalAppConfig.b());
    }
}
