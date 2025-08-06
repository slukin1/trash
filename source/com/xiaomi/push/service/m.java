package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aw;
import com.xiaomi.push.fh;
import com.xiaomi.push.g;
import com.xiaomi.push.ge;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.j;
import com.xiaomi.push.k;
import com.xiaomi.push.n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class m {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile m f52558a;

    /* renamed from: a  reason: collision with other field name */
    private int f3389a = -1;

    /* renamed from: a  reason: collision with other field name */
    private long f3390a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f3391a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f3392a;

    /* renamed from: a  reason: collision with other field name */
    private String f3393a = null;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicInteger f3394a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f3395a = false;

    /* renamed from: b  reason: collision with root package name */
    private long f52559b = -1;

    /* renamed from: b  reason: collision with other field name */
    private String f3396b = null;

    /* renamed from: b  reason: collision with other field name */
    private final AtomicInteger f3397b = new AtomicInteger(0);

    /* renamed from: b  reason: collision with other field name */
    private final boolean f3398b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f52560c = new AtomicInteger(0);

    /* renamed from: c  reason: collision with other field name */
    private final boolean f3399c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f52561d;

    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", new Object[]{str});
        }

        public static String b() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", new Object[]{str});
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private m(Context context) {
        this.f3391a = context;
        this.f3399c = j.a(context);
        this.f3398b = ah.a(context).a(gl.IntelligentHeartbeatSwitchBoolean.a(), true);
        this.f52561d = g();
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f3392a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.c(), -1) == -1) {
            sharedPreferences.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j11 = sharedPreferences.getLong(a.i(), -1);
        this.f3390a = j11;
        if (j11 == -1) {
            this.f3390a = currentTimeMillis;
            sharedPreferences.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    public static m a(Context context) {
        if (f52558a == null) {
            synchronized (m.class) {
                if (f52558a == null) {
                    f52558a = new m(context);
                }
            }
        }
        return f52558a;
    }

    private void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f3393a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.f52561d) {
                    this.f3393a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f3393a = null;
                }
            }
        } else {
            this.f3393a = str;
        }
        int i11 = this.f3392a.getInt(a.a(this.f3393a), -1);
        long j11 = this.f3392a.getLong(a.b(this.f3393a), -1);
        long currentTimeMillis = System.currentTimeMillis();
        if (i11 != -1) {
            if (j11 == -1) {
                this.f3392a.edit().putLong(a.b(this.f3393a), currentTimeMillis + d()).apply();
            } else if (currentTimeMillis > j11) {
                this.f3392a.edit().remove(a.a(this.f3393a)).remove(a.b(this.f3393a)).apply();
            }
        }
        this.f3394a.getAndSet(0);
        if (TextUtils.isEmpty(this.f3393a) || a() != -1) {
            this.f3395a = false;
        } else {
            this.f3395a = true;
        }
        b.a(String.format("[HB] network changed, netid:%s, %s", new Object[]{this.f3393a, Boolean.valueOf(this.f3395a)}));
    }

    private void e() {
        if (!this.f3392a.getBoolean(a.a(), false)) {
            this.f3392a.edit().putBoolean(a.a(), true).apply();
        }
    }

    private void f() {
        String str;
        int i11 = this.f3389a;
        if (i11 == 0) {
            str = a.g();
        } else if (i11 != 1) {
            str = null;
        } else {
            str = a.h();
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.f3392a.getLong(a.i(), -1) == -1) {
                this.f3390a = System.currentTimeMillis();
                this.f3392a.edit().putLong(a.i(), this.f3390a).apply();
            }
            this.f3392a.edit().putInt(str, this.f3392a.getInt(str, 0) + 1).apply();
        }
    }

    private void g() {
        int i11;
        String[] split;
        String[] split2;
        if (c()) {
            String string = this.f3392a.getString(a.f(), (String) null);
            char c11 = 1;
            char c12 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i12 = 0;
                while (i12 < split.length) {
                    if (!TextUtils.isEmpty(split[i12]) && (split2 = split[i12].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c12];
                        String str2 = split2[c11];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, k.a());
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put(MTPushConstants.Geofence.KEY_INTERVAL, str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", (String) null, hashMap);
                        b.a("[HB] report hb changed events.");
                    }
                    i12++;
                    c11 = 1;
                    c12 = 0;
                }
                this.f3392a.edit().remove(a.f()).apply();
            }
            if (this.f3392a.getBoolean(a.a(), false)) {
                long j11 = this.f3392a.getLong(a.b(), 0);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j11 > 1296000000) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event", "support");
                    hashMap2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, k.a());
                    hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    a("category_hb_change", (String) null, hashMap2);
                    b.a("[HB] report support wifi digest events.");
                    this.f3392a.edit().putLong(a.b(), currentTimeMillis).apply();
                }
            }
            if (e()) {
                int i13 = this.f3392a.getInt(a.d(), 0);
                int i14 = this.f3392a.getInt(a.e(), 0);
                if (i13 > 0 || i14 > 0) {
                    long j12 = this.f3392a.getLong(a.c(), -1);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j12);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MTPushConstants.Geofence.KEY_INTERVAL, valueOf);
                        jSONObject.put("c_short", String.valueOf(i13));
                        jSONObject.put("c_long", String.valueOf(i14));
                        jSONObject.put("count", String.valueOf(i13 + i14));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        b.a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f3392a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (f()) {
                String valueOf4 = String.valueOf(this.f3390a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i15 = this.f3392a.getInt(a.g(), 0);
                if (i15 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i15);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        b.a("[HB] report ping timeout count events of mobile network.");
                        this.f3392a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i11 = 0;
                        this.f3392a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i11 = 0;
                int i16 = this.f3392a.getInt(a.h(), i11);
                if (i16 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i16);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        b.a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f3392a.edit().putInt(a.h(), 0).apply();
                }
                this.f3390a = System.currentTimeMillis();
                this.f3392a.edit().putLong(a.i(), this.f3390a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3021a() {
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m3025c() {
        if (d()) {
            this.f3396b = this.f3393a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m3026d() {
        if (d()) {
            g();
            if (this.f3395a) {
                this.f3394a.getAndSet(0);
            }
        }
    }

    private long c() {
        return this.f3392a.getLong(a.j(), -1);
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m3017e() {
        long j11 = this.f3392a.getLong(a.c(), -1);
        if (j11 == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j11 <= currentTimeMillis && currentTimeMillis - j11 < 259200000) {
            return false;
        }
        return true;
    }

    private void c(String str) {
        if (a(str)) {
            this.f3392a.edit().putInt(a.a(str), 235000).apply();
            this.f3392a.edit().putLong(a.b(this.f3393a), System.currentTimeMillis() + d()).apply();
        }
    }

    private long d() {
        return ah.a(this.f3391a).a(gl.ShortHeartbeatEffectivePeriodMsLong.a(), 7776000000L);
    }

    public synchronized void a(aw awVar) {
        if (d()) {
            String str = null;
            if (awVar == null) {
                b((String) null);
                this.f3389a = -1;
            } else if (awVar.a() == 0) {
                String b11 = awVar.b();
                if (!TextUtils.isEmpty(b11) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(b11)) {
                    str = "M-" + b11;
                }
                b(str);
                this.f3389a = 0;
            } else {
                if (awVar.a() != 1) {
                    if (awVar.a() != 6) {
                        b((String) null);
                        this.f3389a = -1;
                    }
                }
                b("WIFI-ID-UNKNOWN");
                this.f3389a = 1;
            }
        }
    }

    private void d(String str) {
        String str2;
        String str3;
        if (c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else if (str.startsWith("M-")) {
                str2 = "M";
            } else {
                return;
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(":::");
            sb2.append(str2);
            sb2.append(":::");
            sb2.append(valueOf);
            sb2.append(":::");
            sb2.append(valueOf2);
            String string = this.f3392a.getString(a.f(), (String) null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb2.toString();
            } else {
                str3 = string + "###" + sb2.toString();
            }
            this.f3392a.edit().putString(a.f(), str3).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m3015c() {
        boolean a11 = ah.a(this.f3391a).a(gl.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true);
        if (!d() || !a11 || !n.China.name().equals(b.a(this.f3391a).a())) {
            return false;
        }
        return true;
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m3018f() {
        if (this.f3390a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f3390a;
        if (j11 <= currentTimeMillis && currentTimeMillis - j11 < 259200000) {
            return false;
        }
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m3024b() {
        if (d()) {
            f();
            if (this.f3395a && !TextUtils.isEmpty(this.f3393a) && this.f3393a.equals(this.f3396b)) {
                this.f3394a.getAndIncrement();
                b.a("[HB] ping timeout count:" + this.f3394a);
                if (a()) {
                    b.a("[HB] change hb interval for net:" + this.f3393a);
                    c(this.f3393a);
                    this.f3395a = false;
                    this.f3394a.getAndSet(0);
                    d(this.f3393a);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m3022a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m3016d() {
        boolean z11 = c() >= System.currentTimeMillis();
        if (!this.f3399c || (!this.f3398b && !this.f52561d && !z11)) {
            return false;
        }
        return true;
    }

    public void a(int i11) {
        this.f3392a.edit().putLong(a.j(), System.currentTimeMillis() + ((long) (i11 * 1000))).apply();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m3014a() {
        return this.f3394a.get() >= Math.max(ah.a(this.f3391a).a(gl.IntelligentHeartbeatNATCountInt.a(), 3), 3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m3023b() {
        return this.f52559b;
    }

    private boolean b() {
        if (!TextUtils.isEmpty(this.f3393a)) {
            if (this.f3393a.startsWith("M-")) {
                if (!ah.a(this.f3391a).a(gl.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) {
                    return true;
                }
            } else if (!this.f3393a.equals("W-NETWORK_ID_WIFI_DEFAULT") || g()) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m3020a() {
        int a11;
        long b11 = (long) fh.b();
        boolean z11 = true;
        if (this.f3399c && !b() && ((ah.a(this.f3391a).a(gl.IntelligentHeartbeatSwitchBoolean.a(), true) || c() >= System.currentTimeMillis()) && (a11 = a()) != -1)) {
            b11 = (long) a11;
        }
        if (!TextUtils.isEmpty(this.f3393a) && !"WIFI-ID-UNKNOWN".equals(this.f3393a) && this.f3389a == 1) {
            if (b11 >= 300000) {
                z11 = false;
            }
            a(z11);
        }
        this.f52559b = b11;
        b.a("[HB] ping interval:" + b11);
        return b11;
    }

    private int a() {
        if (TextUtils.isEmpty(this.f3393a)) {
            return -1;
        }
        try {
            return this.f3392a.getInt(a.a(this.f3393a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("W-") || str.startsWith("M-")) {
            return true;
        }
        return false;
    }

    private void a(boolean z11) {
        String str;
        if (c()) {
            int incrementAndGet = (z11 ? this.f3397b : this.f52560c).incrementAndGet();
            Object[] objArr = new Object[2];
            String str2 = "short";
            objArr[0] = z11 ? str2 : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                if (z11) {
                    str = a.d();
                } else {
                    str = a.e();
                }
                int i11 = this.f3392a.getInt(str, 0) + incrementAndGet;
                this.f3392a.edit().putInt(str, i11).apply();
                Object[] objArr2 = new Object[2];
                if (!z11) {
                    str2 = "long";
                }
                objArr2[0] = str2;
                objArr2[1] = Integer.valueOf(i11);
                b.a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z11) {
                    this.f3397b.set(0);
                } else {
                    this.f52560c.set(0);
                }
            }
        }
    }

    private void a(String str, String str2, Map<String, String> map) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c("hb_name");
        gkVar.a("hb_channel");
        gkVar.a(1);
        gkVar.b(str2);
        gkVar.a(false);
        gkVar.b(System.currentTimeMillis());
        gkVar.g(this.f3391a.getPackageName());
        gkVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        p a11 = q.a(this.f3391a);
        if (a11 != null && !TextUtils.isEmpty(a11.f3412a)) {
            String[] split = a11.f3412a.split(TIMMentionEditText.TIM_MENTION_TAG);
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put(ZendeskIdentityStorage.UUID_KEY, str3);
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, k.a());
        Context context = this.f3391a;
        map.put("avc", String.valueOf(g.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(60001));
        map.put("cvc", String.valueOf(48));
        gkVar.a(map);
        ge a12 = ge.a(this.f3391a);
        if (a12 != null) {
            a12.a(gkVar, this.f3391a.getPackageName());
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private boolean m3019g() {
        return ah.a(this.f3391a).a(gl.IntelligentHeartbeatForUnsupportWifiDigestBoolean.a(), true);
    }
}
