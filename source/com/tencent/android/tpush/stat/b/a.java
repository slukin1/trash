package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import cn.sharesdk.framework.InnerShareParams;
import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sentry.q;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.stat.b;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static C0756a f69943a;

    /* renamed from: d  reason: collision with root package name */
    private static c f69944d = b.b();

    /* renamed from: e  reason: collision with root package name */
    private static JSONObject f69945e = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    public Integer f69946b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f69947c = null;

    /* renamed from: com.tencent.android.tpush.stat.b.a$a  reason: collision with other inner class name */
    public static class C0756a {

        /* renamed from: a  reason: collision with root package name */
        public String f69948a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f69949b;

        /* renamed from: c  reason: collision with root package name */
        public int f69950c;

        /* renamed from: d  reason: collision with root package name */
        public String f69951d;

        /* renamed from: e  reason: collision with root package name */
        public String f69952e;

        /* renamed from: f  reason: collision with root package name */
        public String f69953f;

        /* renamed from: g  reason: collision with root package name */
        public String f69954g;

        /* renamed from: h  reason: collision with root package name */
        public String f69955h;

        /* renamed from: i  reason: collision with root package name */
        public int f69956i;

        /* renamed from: j  reason: collision with root package name */
        public String f69957j;

        /* renamed from: k  reason: collision with root package name */
        public Context f69958k;

        /* renamed from: l  reason: collision with root package name */
        public long f69959l;

        /* renamed from: m  reason: collision with root package name */
        private String f69960m;

        /* renamed from: n  reason: collision with root package name */
        private String f69961n;

        public void a(JSONObject jSONObject, Thread thread) {
            if (thread == null) {
                if (this.f69949b != null) {
                    jSONObject.put(InnerShareParams.SUBREDDIT, this.f69949b.widthPixels + "*" + this.f69949b.heightPixels);
                    jSONObject.put(VulcanInfo.DPI, this.f69949b.xdpi + "*" + this.f69949b.ydpi);
                }
                if (b.a(this.f69958k).b()) {
                    JSONObject jSONObject2 = new JSONObject();
                    e.a(jSONObject2, "bs", CustomDeviceInfos.getWiFiBBSID(this.f69958k));
                    e.a(jSONObject2, "ss", CustomDeviceInfos.getWiFiSSID(this.f69958k));
                    if (jSONObject2.length() > 0) {
                        e.a(jSONObject, "wf", jSONObject2.toString());
                    }
                }
                JSONArray wifiTopN = CustomDeviceInfos.getWifiTopN(this.f69958k, 10);
                if (wifiTopN != null && wifiTopN.length() > 0) {
                    e.a(jSONObject, "wflist", wifiTopN.toString());
                }
            } else {
                e.a(jSONObject, "thn", thread.getName());
                if (b.c(this.f69960m) && this.f69960m.split("/").length == 2) {
                    e.a(jSONObject, "fram", this.f69960m.split("/")[0]);
                }
                if (b.c(this.f69961n) && this.f69961n.split("/").length == 2) {
                    e.a(jSONObject, "from", this.f69961n.split("/")[0]);
                }
                jSONObject.put(OptionsBridge.UI_KEY, CustomDeviceInfos.getFacilityIdentity(this.f69958k));
                e.a(jSONObject, CommunityConstants.REQUEST_KEY_MID, XGPushConfig.getToken(this.f69958k));
            }
            e.a(jSONObject, "pcn", b.d(this.f69958k));
            e.a(jSONObject, "osn", Build.VERSION.RELEASE);
            e.a(jSONObject, "av", this.f69948a);
            e.a(jSONObject, "ch", Event.channel);
            e.a(jSONObject, "mf", this.f69951d);
            long j11 = this.f69959l;
            if (j11 > 0) {
                e.a(jSONObject, "sv", b.a(this.f69958k, j11));
            }
            e.a(jSONObject, "osd", Build.DISPLAY);
            e.a(jSONObject, "prod", Build.PRODUCT);
            e.a(jSONObject, InnerShareParams.TAGS, Build.TAGS);
            e.a(jSONObject, "id", Build.ID);
            e.a(jSONObject, "fng", Build.FINGERPRINT);
            e.a(jSONObject, "ov", Integer.toString(this.f69950c));
            jSONObject.put(q.f30469g, 1);
            e.a(jSONObject, "op", this.f69953f);
            e.a(jSONObject, "lg", this.f69952e);
            e.a(jSONObject, "tz", this.f69954g);
            int i11 = this.f69956i;
            if (i11 != 0) {
                jSONObject.put("jb", i11);
            }
            e.a(jSONObject, "sd", this.f69955h);
            e.a(jSONObject, "abi", Build.CPU_ABI);
            e.a(jSONObject, "ram", this.f69960m);
            e.a(jSONObject, "rom", this.f69961n);
        }

        private C0756a(Context context, long j11) {
            this.f69950c = Build.VERSION.SDK_INT;
            this.f69951d = Build.MANUFACTURER;
            this.f69952e = Locale.getDefault().getLanguage();
            this.f69956i = 0;
            this.f69957j = null;
            this.f69958k = null;
            this.f69960m = null;
            this.f69961n = null;
            this.f69959l = 0;
            Context applicationContext = context.getApplicationContext();
            this.f69958k = applicationContext;
            this.f69949b = DeviceInfos.getDisplayMetrics(applicationContext);
            this.f69948a = b.b(this.f69958k, j11);
            this.f69953f = CustomDeviceInfos.getSimOperator(this.f69958k);
            this.f69954g = TimeZone.getDefault().getID();
            this.f69955h = DeviceInfos.getExternalStorageInfo(this.f69958k);
            this.f69957j = this.f69958k.getPackageName();
            this.f69960m = DeviceInfos.getSystemMemory(this.f69958k);
            this.f69961n = DeviceInfos.getRomMemory();
            this.f69959l = j11;
        }
    }

    public a(Context context, long j11) {
        try {
            a(context, j11);
            this.f69946b = DeviceInfos.getTelephonyNetworkType(context.getApplicationContext());
            this.f69947c = b.a(context).a();
        } catch (Throwable th2) {
            f69944d.b(th2);
        }
    }

    public static synchronized C0756a a(Context context, long j11) {
        C0756a aVar;
        synchronized (a.class) {
            if (f69943a == null) {
                f69943a = new C0756a(context.getApplicationContext(), j11);
            }
            aVar = f69943a;
        }
        return aVar;
    }

    public void a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            C0756a aVar = f69943a;
            if (aVar != null) {
                aVar.a(jSONObject2, thread);
            }
            e.a(jSONObject2, "cn", this.f69947c);
            Integer num = this.f69946b;
            if (num != null) {
                jSONObject2.put("tn", num);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            JSONObject jSONObject3 = f69945e;
            if (jSONObject3 != null && jSONObject3.length() > 0) {
                jSONObject.put("eva", f69945e);
            }
        } catch (Throwable th2) {
            f69944d.b(th2);
        }
    }
}
