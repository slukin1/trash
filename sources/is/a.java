package is;

import android.text.TextUtils;
import bh.j;
import cl.c;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.statistics.hbg.api.HbgAnalyticsService;
import com.huobi.statistics.hbg.bean.AnalyticsClickItem;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.xiaomi.mipush.sdk.MiPushClient;
import i6.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import tq.p;
import u6.g;
import wi.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Object> f84298a;

    /* renamed from: b  reason: collision with root package name */
    public static String f84299b;

    /* renamed from: c  reason: collision with root package name */
    public static long f84300c;

    /* renamed from: d  reason: collision with root package name */
    public static String f84301d;

    public static void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f84300c > 600000) {
            f84300c = currentTimeMillis;
            String str = f84300c + "_" + new Random().nextInt(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND) + "_" + PhoneUtils.r();
            f84299b = str;
            f84299b = MD5Utils.b(str.getBytes()).toUpperCase(Locale.US);
        }
    }

    public static void b(Map<String, Object> map, AnalyticsExposureItem analyticsExposureItem) {
        if (map != null && analyticsExposureItem != null && !TextUtils.isEmpty(analyticsExposureItem.getEventAction())) {
            map.put("eventAction", analyticsExposureItem.getEventAction());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> c(com.huobi.statistics.hbg.bean.AnalyticsExposureItem r5, boolean r6, java.lang.String r7) {
        /*
            java.lang.String r0 = ""
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 15
            r1.<init>(r2)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "eventTime"
            r1.put(r3, r2)
            iu.a r2 = iu.a.f()     // Catch:{ Exception -> 0x0030 }
            r3 = -1
            java.util.Map r2 = r2.g(r3)     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0034
            boolean r3 = r2.isEmpty()     // Catch:{ Exception -> 0x0030 }
            if (r3 != 0) goto L_0x0034
            java.lang.String r3 = "vHash"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0030 }
            goto L_0x0035
        L_0x0030:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0034:
            r2 = r0
        L_0x0035:
            java.lang.String r3 = "deviceId"
            r1.put(r3, r2)
            tg.r r2 = tg.r.x()
            com.huobi.login.usercenter.data.source.bean.UserInfoData r2 = r2.M()
            if (r2 == 0) goto L_0x005a
            java.lang.String r2 = r2.k()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x005a
            tg.r r0 = tg.r.x()
            com.huobi.login.usercenter.data.source.bean.UserInfoData r0 = r0.M()
            java.lang.String r0 = r0.k()
        L_0x005a:
            java.lang.String r2 = "uuid"
            r1.put(r2, r0)
            r0 = 3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "platform"
            r1.put(r2, r0)
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "app"
            r1.put(r2, r0)
            java.lang.String r0 = com.hbg.lib.common.BaseApplication.e()
            java.lang.String r2 = "version"
            r1.put(r2, r0)
            java.lang.String r0 = "0"
            if (r5 == 0) goto L_0x008f
            java.lang.String r2 = r5.getRef()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x008f
            java.lang.String r2 = r5.getRef()
            goto L_0x0090
        L_0x008f:
            r2 = r0
        L_0x0090:
            java.lang.String r3 = "ref"
            r1.put(r3, r2)
            java.lang.String r2 = "duration"
            java.lang.String r3 = "eventId"
            java.lang.String r4 = "eventAction"
            if (r6 == 0) goto L_0x00bf
            java.lang.String r6 = "expose"
            r1.put(r4, r6)
            java.lang.String r6 = "126"
            r1.put(r3, r6)
            r6 = 0
            if (r5 == 0) goto L_0x00b7
            long r3 = r5.getDuration()
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x00b7
            long r6 = r5.getDuration()
        L_0x00b7:
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r1.put(r2, r6)
            goto L_0x00cf
        L_0x00bf:
            java.lang.String r6 = "click"
            r1.put(r4, r6)
            r1.put(r3, r7)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.put(r2, r6)
        L_0x00cf:
            if (r5 == 0) goto L_0x00d5
            java.lang.String r0 = r5.getPageId()
        L_0x00d5:
            java.lang.String r5 = "pageId"
            r1.put(r5, r0)
            com.hbg.lib.core.util.AppLanguageHelper r5 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()
            java.lang.String r5 = r5.getCurLanguageHeader()
            java.lang.String r6 = "language"
            r1.put(r6, r5)
            java.lang.String r5 = com.hbg.lib.core.util.PhoneUtils.r()
            java.lang.String r6 = "did"
            r1.put(r6, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "android"
            r5.append(r6)
            java.lang.String r6 = android.os.Build.VERSION.RELEASE
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "systemVersion"
            r1.put(r6, r5)
            java.lang.String r5 = f84299b
            java.lang.String r6 = "session_id"
            r1.put(r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: is.a.c(com.huobi.statistics.hbg.bean.AnalyticsExposureItem, boolean, java.lang.String):java.util.Map");
    }

    public static Map<String, Object> d() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("env", 1);
        return hashMap;
    }

    public static Map<String, Object> e() {
        return f84298a;
    }

    public static String f(TradeType tradeType) {
        if (tradeType == TradeType.CONTRACT) {
            return "1005011";
        }
        if (tradeType == TradeType.SWAP) {
            return "1005119";
        }
        return tradeType == TradeType.LINEAR_SWAP ? "1005231" : "";
    }

    public static String g() {
        String str = b.f48040d;
        if (SystemUtils.c()) {
            String b11 = c.c().b();
            if (TextUtils.isEmpty(b11)) {
                return "";
            }
            d.d("getReportUrl : " + b11);
            if (!TextUtils.isEmpty(b11)) {
                b11 = b11 + "/-/x/hbg/";
            }
            if (!TextUtils.isEmpty(b11)) {
                str = str.replace("l10n-api.huobi.cn/", b11);
            }
        }
        String str2 = str + "daq/user-event/info";
        d.d("getReportUrl : " + str2);
        return str2;
    }

    public static void h() {
        String e11 = ConfigPreferences.e("user_config", "APP_ACTIVE", "");
        if (TextUtils.isEmpty(e11) || !e11.contains(String.valueOf(BaseApplication.d()))) {
            Map<String, Object> c11 = c(hs.b.l().m(), false, "0");
            c11.put("eventAction", "active");
            c11.put("pageId", "0000000");
            d.i("[REPORT-ACTIVE]" + c11.toString());
            if (!TextUtils.isEmpty(g())) {
                ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
                ConfigPreferences.m("user_config", "APP_ACTIVE", String.valueOf(BaseApplication.d()));
            }
        }
    }

    public static void i(String str, Map<String, Object> map) {
        Map<String, Object> c11 = c(hs.b.l().m(), false, str);
        if (!TextUtils.isEmpty(str)) {
            AnalyticsClickItem analyticsClickItem = hs.a.b().a().get(str);
            c11.put("pageId", (analyticsClickItem == null || TextUtils.isEmpty(analyticsClickItem.getPageId())) ? "0" : analyticsClickItem.getPageId());
        }
        String a11 = gj.a.b().a();
        if (map != null && !map.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                map.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            }
            c11.put("extend", map);
        } else if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        d.i("[REPORT-CLICK]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void j(String str, Map<String, Object> map, String str2) {
        Map<String, Object> c11 = c(hs.b.l().m(), false, str);
        if (!TextUtils.isEmpty(str2)) {
            c11.put("pageId", str2);
        }
        String a11 = gj.a.b().a();
        if (map != null && !map.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                map.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            }
            c11.put("extend", map);
        } else if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        d.i("[REPORT-CLICK]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void k(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2.toLowerCase(Locale.US));
        }
        i(str, hashMap);
    }

    public static void l(AnalyticsExposureItem analyticsExposureItem) {
        Map<String, Object> c11 = c(analyticsExposureItem, true, (String) null);
        b(c11, analyticsExposureItem);
        String a11 = gj.a.b().a();
        if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        d.i("[REPORT-EXPOSURE]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void m(String str) {
        AnalyticsExposureItem analyticsExposureItem = new AnalyticsExposureItem();
        analyticsExposureItem.setPageId(str);
        l(analyticsExposureItem);
    }

    public static void n(String str, String str2, String str3, Map<String, Object> map) {
        Map<String, Object> c11 = c(hs.b.l().m(), true, str);
        String a11 = gj.a.b().a();
        if (map != null && !map.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                map.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            }
            c11.put("extend", map);
        } else if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        c11.put("pageId", str2);
        if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
            c11.put(IBridgeMediaLoader.COLUMN_DURATION, str3);
        }
        d.i("[REPORT-EXPOSURE]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void o(String str, Map<String, Object> map, String str2) {
        Map<String, Object> c11 = c(hs.b.l().m(), false, str);
        if (!TextUtils.isEmpty(str2)) {
            c11.put("pageId", str2);
        }
        c11.put("eventAction", "H5");
        String a11 = gj.a.b().a();
        if (map != null && !map.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                map.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            }
            c11.put("extend", map);
        } else if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        d.i("[REPORT-H5]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void p(Map<String, Object> map) {
        ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).collectionData(map).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
    }

    public static void q(String str, Map<String, Object> map) {
        Map<String, Object> c11 = c(hs.b.l().m(), false, str);
        c11.put("eventAction", FirebaseAnalytics.Event.LOGIN);
        c11.put("pageId", "");
        d.i("[REPORT-LOGIN]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void r(String str, String str2, String str3, Map<String, Object> map) {
        Map<String, Object> c11 = c(hs.b.l().m(), true, str);
        c11.put("eventAction", "popexpose");
        String a11 = gj.a.b().a();
        if (map != null && !map.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                map.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            }
            c11.put("extend", map);
        } else if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        c11.put("pageId", str2);
        if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
            c11.put(IBridgeMediaLoader.COLUMN_DURATION, str3);
        }
        d.i("[REPORT-EXPOSURE]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void s(String str, String str2, boolean z11, String str3, Map<String, Object> map) {
        Map<String, Object> c11 = c(hs.b.l().m(), z11, str);
        c11.put("eventAction", "popexpose");
        String a11 = gj.a.b().a();
        if (map != null && !map.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                map.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            }
            c11.put("extend", map);
        } else if (!TextUtils.isEmpty(a11)) {
            HashMap hashMap = new HashMap();
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, a11);
            c11.put("extend", hashMap);
        }
        c11.put("pageId", str2);
        if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
            c11.put(IBridgeMediaLoader.COLUMN_DURATION, str3);
        }
        d.i("[REPORT-EXPOSURE]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void t() {
        if (!TextUtils.isEmpty(f84301d)) {
            Map<String, Object> c11 = c(hs.b.l().m(), false, "0");
            c11.put("eventAction", MiPushClient.COMMAND_REGISTER);
            HashMap hashMap = new HashMap();
            hashMap.put("inviter_id", f84301d);
            c11.put("extend", hashMap);
            d.i("[REPORT-ACTIVE]" + c11.toString());
            if (!TextUtils.isEmpty(g())) {
                ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
            }
        }
    }

    public static void u() {
        Map<String, Object> c11 = c(hs.b.l().m(), false, "126");
        c11.put("eventAction", Constants.PUSH);
        c11.put("pageId", "0000000");
        c11.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, gj.a.b().a());
        d.i("[REPORT-ACTIVE]" + c11.toString());
        if (!TextUtils.isEmpty(g())) {
            ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
        }
    }

    public static void v() {
        String h11 = DateTimeUtils.h(System.currentTimeMillis(), "MM.dd");
        if (!h11.equals(ConfigPreferences.e("user_config", "APP_START", ""))) {
            Map<String, Object> c11 = c(hs.b.l().m(), false, "0");
            c11.put("eventAction", "start");
            c11.put("pageId", "0000000");
            boolean b11 = so.b.b(j.c());
            HashMap hashMap = new HashMap();
            hashMap.put("push_permission", Integer.valueOf(b11 ? 1 : 0));
            c11.put("extend", hashMap);
            if (!TextUtils.isEmpty(g())) {
                ((HbgAnalyticsService) p.C(HbgAnalyticsService.class)).reportData(g(), c11).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
                ConfigPreferences.m("user_config", "APP_START", h11);
            }
        }
    }

    public static void w(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("symbol", str2.toLowerCase(Locale.US));
        }
        i(str, hashMap);
    }

    public static void x() {
        f84300c = System.currentTimeMillis();
    }

    public static void y(Map<String, Object> map) {
        f84298a = map;
    }
}
