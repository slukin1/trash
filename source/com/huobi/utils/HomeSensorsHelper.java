package com.huobi.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import java.util.HashMap;
import tg.r;

public class HomeSensorsHelper {
    public static HashMap<String, Object> a(long j11, String str, String str2) {
        return new HashMap<String, Object>(str, j11, str2) {
            public final /* synthetic */ long val$contentid;
            public final /* synthetic */ String val$derivatives_currency;
            public final /* synthetic */ String val$recom_base_info;

            {
                this.val$recom_base_info = r5;
                this.val$contentid = r6;
                this.val$derivatives_currency = r8;
                String J = r.x().J();
                put("uid", (J == null || J.equals("")) ? "0" : J);
                put("timestamp", Long.valueOf(System.currentTimeMillis()));
                put("category", "homefeeds");
                put("recom_base_info", r5);
                put("contentid", Long.valueOf(r6));
                put("recome_type", "recommend");
                put("title", "");
                put("derivatives_currency", r8);
            }
        };
    }

    public static HashMap b(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("recome_type", c(i11));
        String J = r.x().J();
        if (J == null || J.equals("")) {
            J = "0";
        }
        hashMap.put("uid", J);
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    public static String c(int i11) {
        return i11 == 1 ? "recommend" : i11 == 2 ? ChainInfo.CHAIN_TYPE_NEW : i11 == 3 ? "hot" : i11 == 4 ? "follow" : i11 == 6 ? ChainInfo.CHAIN_TYPE_LIVE : "";
    }

    public static HashMap<String, Object> d(long j11, String str, String str2, String str3, int i11, String str4, int i12) {
        return e(j11, str, str2, str3, i11, str4, 0, i12);
    }

    public static HashMap<String, Object> e(long j11, String str, String str2, String str3, int i11, String str4, int i12, int i13) {
        return new HashMap<String, Object>(str, j11, str2, i13, str3, i12, i11, str4) {
            private static final long serialVersionUID = -2822260857461941515L;
            public final /* synthetic */ String val$content_type;
            public final /* synthetic */ long val$contentid;
            public final /* synthetic */ String val$recom_base_info;
            public final /* synthetic */ int val$shareType;
            public final /* synthetic */ String val$status;
            public final /* synthetic */ int val$tabType;
            public final /* synthetic */ String val$title;
            public final /* synthetic */ int val$type;

            {
                this.val$recom_base_info = r4;
                this.val$contentid = r5;
                this.val$title = r7;
                this.val$type = r8;
                this.val$content_type = r9;
                this.val$shareType = r10;
                this.val$tabType = r11;
                this.val$status = r12;
                try {
                    String J = r.x().J();
                    put("uid", (J == null || J.equals("")) ? "0" : J);
                    put("timestamp", Long.valueOf(System.currentTimeMillis()));
                    put("category", "homefeeds");
                    put("recom_base_info", r4);
                    put("contentid", Long.valueOf(r5));
                    put("title", r7);
                    put("type", String.valueOf(r8));
                    put(FirebaseAnalytics.Param.CONTENT_TYPE, r9);
                    if (r9.equals("community") && r10 != 0) {
                        put("sharetype", Integer.valueOf(r10));
                    }
                    put("recome_type", HomeSensorsHelper.c(r11));
                    if (r12 != null) {
                        put("status", r12);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        };
    }
}
