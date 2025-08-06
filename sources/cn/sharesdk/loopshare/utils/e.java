package cn.sharesdk.loopshare.utils;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.loopshare.MobLink;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.LinkData;
import cn.sharesdk.loopshare.beans.LogData;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.beans.ServerData;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.RxMob;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f13720a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Hashon f13721b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static ConfigData f13722c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f13723d = "http://api.applink.mob.com";

    /* renamed from: e  reason: collision with root package name */
    private static final String f13724e = "http://api.applink.mob.com";

    static {
        a(MobSDK.getContext());
    }

    private static String e() {
        String c11 = c(a());
        return c11 + "/client/link";
    }

    private static String f() {
        String c11 = c(a());
        return c11 + "/client/reco";
    }

    private static String g() {
        String d11 = d(a());
        return d11 + "/client/log";
    }

    private static String h() {
        String d11 = d(a());
        return d11 + "/client/ul";
    }

    /* access modifiers changed from: private */
    public static String i() {
        if (TextUtils.isEmpty(f13720a)) {
            synchronized (e.class) {
                TextUtils.isEmpty(f13720a);
            }
        }
        return f13720a;
    }

    /* access modifiers changed from: private */
    public static String b(boolean z11) {
        String str;
        if (z11) {
            str = f13723d;
        } else {
            str = c(a());
        }
        return str + "/client/conf";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(cn.sharesdk.loopshare.beans.ConfigData r3) {
        /*
            boolean r0 = e(r3)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = r3.b()
            int r3 = r3.c()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0038
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x0038
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "http://"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ":"
            r1.append(r0)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0041
            java.lang.String r3 = f13723d
        L_0x0041:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.loopshare.utils.e.c(cn.sharesdk.loopshare.beans.ConfigData):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(cn.sharesdk.loopshare.beans.ConfigData r3) {
        /*
            boolean r0 = e(r3)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = r3.f()
            int r3 = r3.g()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0038
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x0038
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "http://"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ":"
            r1.append(r0)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0041
            java.lang.String r3 = f13724e
        L_0x0041:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.loopshare.utils.e.d(cn.sharesdk.loopshare.beans.ConfigData):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static boolean e(ConfigData configData) {
        return configData != null && ServerData.a((ServerData) configData);
    }

    public static void a(Context context) {
        f13721b = new Hashon();
    }

    public static LinkData a(String str, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("appkey", MobSDK.getAppkey());
        hashMap2.put("plat", 1);
        hashMap2.put("sysver", DH.SyncMtd.getOSVersionName());
        hashMap2.put("appver", DH.SyncMtd.getAppVersionName());
        hashMap2.put("duid", i());
        hashMap2.put("path", str);
        hashMap2.put("params", hashMap);
        return (LinkData) b(hashMap2, b(e()), LinkData.class);
    }

    /* access modifiers changed from: private */
    public static <T extends ServerData> T b(HashMap<String, Object> hashMap, String str, Class<T> cls) {
        HashMap hashMap2 = new HashMap();
        NLog instance = MobLinkLog.getInstance();
        instance.d(MobLinkLog.FORMAT, "url:" + str);
        try {
            Object requestSynchronized = new MobCommunicator(1024, "d6c42369216f886092bea6cc42977ec0b917508b9d21e2e3b3447d47f500551ddcf1b41a294f081da5fad98b270fd8b99479a5958db8528f9231a4156742b847", "160cb541521f5eafde6138e6c1a3583f529cba9c06618f373e7923460ec5adf715b1d49fda021d6f227e6c7f1c456d4914988d6748b6aab17226f91be6825a730dd0b6aed2f06c877d655bd8c165f60792c518280a46c1695da131f8e4a6c0d5bd1b1ab34f2ec96bae2d796272d1f099a05af736a81b1c6a5969b5a0618abde5").requestSynchronized(hashMap, str, false);
            hashMap2.put("status", 200);
            hashMap2.put("res", requestSynchronized);
        } catch (Throwable th2) {
            if (th2 instanceof MobCommunicator.NetworkError) {
                hashMap2 = f13721b.fromJson(th2.getMessage());
            } else {
                hashMap2.put("status", 10000);
                hashMap2.put("error", th2.getMessage());
            }
        }
        return (ServerData) f13721b.fromJson(f13721b.fromHashMap(hashMap2), cls);
    }

    public static SceneData a(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", MobSDK.getAppkey());
        hashMap.put("plat", "1");
        hashMap.put("sysver", DH.SyncMtd.getOSVersionName());
        hashMap.put("sdkver", Integer.valueOf(MobLink.getSdkVersion()));
        hashMap.put("appver", DH.SyncMtd.getAppVersionName());
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, DH.SyncMtd.getModel());
        hashMap.put("duid", i());
        hashMap.put("run", Integer.valueOf(Math.min(2, i11)));
        return (SceneData) b(hashMap, b(f()), SceneData.class);
    }

    public static ConfigData b() {
        return f13722c;
    }

    public static String b(String str) {
        try {
            return MobSDK.checkRequestUrl(str);
        } catch (Throwable unused) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "checkHttpRequestUrl method of MobSDK is exception");
            return "";
        }
    }

    public static LogData a(String str, int i11, int i12) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", MobSDK.getAppkey());
        hashMap.put("plat", 1);
        hashMap.put("link", str);
        hashMap.put("sysver", DH.SyncMtd.getOSVersionName());
        hashMap.put("sdkver", Integer.valueOf(MobLink.getSdkVersion()));
        hashMap.put("appver", DH.SyncMtd.getAppVersionName());
        hashMap.put("apppkg", DH.SyncMtd.getPackageName());
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, DH.SyncMtd.getModel());
        hashMap.put("duid", i());
        hashMap.put("source", Integer.valueOf(i11));
        hashMap.put("source", Integer.valueOf(i12));
        return (LogData) b(hashMap, b(g()), LogData.class);
    }

    public static ConfigData a() {
        if (f13722c == null) {
            String sdkTag = MobLink.getSdkTag();
            if ("event_id_config".equals(EventRecorder.checkRecord(sdkTag))) {
                f.a("");
            }
            EventRecorder.prepare();
            EventRecorder.clear();
            EventRecorder.addBegin(sdkTag, "event_id_config");
            ConfigData configData = null;
            String b11 = f.b();
            if (!TextUtils.isEmpty(b11)) {
                configData = (ConfigData) f13721b.fromJson(b11, ConfigData.class);
            }
            f13722c = configData;
            boolean z11 = !e(configData);
            RxMob.Subscribable create = RxMob.create(new Protocol$1(z11));
            create.subscribeOn(z11 ? RxMob.Thread.IMMEDIATE : RxMob.Thread.NEW_THREAD);
            create.observeOn(RxMob.Thread.IMMEDIATE);
            create.subscribe(new Protocol$2(sdkTag));
        }
        return f13722c;
    }

    public static SceneData a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", MobSDK.getAppkey());
        hashMap.put("plat", 1);
        hashMap.put("link", str);
        hashMap.put("sysver", DH.SyncMtd.getOSVersionName());
        hashMap.put("appver", DH.SyncMtd.getAppVersionName());
        hashMap.put("duid", i());
        return (SceneData) b(hashMap, b(h()), SceneData.class);
    }
}
