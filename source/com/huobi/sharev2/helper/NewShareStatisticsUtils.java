package com.huobi.sharev2.helper;

import com.huobi.social.share.HBShareHelper;
import gs.g;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;

public class NewShareStatisticsUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getComponentName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            android.app.Activity r0 = com.blankj.utilcode.util.a.c()
            if (r0 == 0) goto L_0x0011
            android.content.ComponentName r0 = r0.getComponentName()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.getClassName()
            return r0
        L_0x0011:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.sharev2.helper.NewShareStatisticsUtils.a():java.lang.String");
    }

    public static void b(String str, String str2, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("share_way", str2);
        if (NewShareHelper.p(str)) {
            str = "unknown";
        }
        hashMap.put("source_name", str);
        hashMap.put("Page_name", a());
        if (i11 >= 0) {
            hashMap.put("img_num", Integer.valueOf(i11 + 1));
        }
        g.i("sharetool_save_click", hashMap);
    }

    public static void c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("share_channel", str2);
        if (NewShareHelper.p(str)) {
            str = "unknown";
        }
        hashMap.put("source_name", str);
        hashMap.put("Page_name", a());
        hashMap.put("share_way", str3);
        g.i("sharetool_click", hashMap);
    }

    public static void d(HBShareHelper.HbPlatform hbPlatform, String str, String str2) {
        if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_FACEBOOK)) {
            c(str, "fb", str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_INSTAGRAM)) {
            c(str, "ins", str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_TWITTER)) {
            c(str, "tw", str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_TELEGRAM)) {
            c(str, "tel", str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_MORE)) {
            c(str, "more", str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_KA_KAO)) {
            c(str, "kakao", str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_LINE)) {
            c(str, Constants.LINE, str2);
        } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_WHATSAPP)) {
            c(str, "whatsapp", str2);
        }
    }

    public static void e(String str, String str2) {
        HashMap hashMap = new HashMap(3);
        if (NewShareHelper.p(str)) {
            str = "unknown";
        }
        hashMap.put("source_name", str);
        hashMap.put("Page_name", a());
        hashMap.put("share_mode", str2);
        g.i("sharetool_mode", hashMap);
    }

    public static void f(String str, String str2) {
        HashMap hashMap = new HashMap(3);
        if (NewShareHelper.p(str)) {
            str = "unknown";
        }
        hashMap.put("source_name", str);
        hashMap.put("Page_name", a());
        hashMap.put("share_way", str2);
        g.i("sharetool_way_click", hashMap);
    }

    public static void g(String str) {
        HashMap hashMap = new HashMap(3);
        if (NewShareHelper.p(str)) {
            str = "unknown";
        }
        hashMap.put("source_name", str);
        hashMap.put("Page_name", a());
        g.i("sharetool_show", hashMap);
    }
}
