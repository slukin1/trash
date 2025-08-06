package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Process;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.appevents.UserDataStore;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.a;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.base.logger.DeviceInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends Event {

    /* renamed from: a  reason: collision with root package name */
    private static DeviceInfo f70019a;

    /* renamed from: b  reason: collision with root package name */
    private String f70020b;

    /* renamed from: l  reason: collision with root package name */
    private JSONArray f70021l;

    /* renamed from: m  reason: collision with root package name */
    private int f70022m;

    /* renamed from: n  reason: collision with root package name */
    private Thread f70023n = null;

    /* renamed from: o  reason: collision with root package name */
    private String f70024o = null;

    /* renamed from: p  reason: collision with root package name */
    private long f70025p = -1;

    /* renamed from: q  reason: collision with root package name */
    private String f70026q = null;

    /* renamed from: r  reason: collision with root package name */
    private String f70027r = null;

    /* renamed from: s  reason: collision with root package name */
    private String f70028s = null;

    public d(Context context, int i11, int i12, JSONArray jSONArray, long j11) {
        super(context, 0, j11);
        this.f70022m = i12;
        this.f70021l = jSONArray;
    }

    private void b(JSONObject jSONObject) {
        JSONObject a11 = a(this.f70023n);
        try {
            if (f70019a == null) {
                f70019a = new DeviceInfo(this.f70003k);
            }
            a11.put("deviceInfo", f70019a);
        } catch (Throwable unused) {
            TLogger.w("ErrorEvent", "unexpected for encodeCrashThread");
        }
        JSONArray jSONArray = this.f70021l;
        if (jSONArray != null) {
            a11.put(InnerShareParams.STACK, jSONArray);
            if (this.f70025p > -1) {
                a11.put("gfra", this.f70021l);
            }
        } else {
            a11.put(InnerShareParams.STACK, this.f70020b);
            if (this.f70025p > -1) {
                a11.put("gfra", this.f70020b);
            }
        }
        jSONObject.put("cth", a11);
        if (this.f70022m == 3) {
            a11.put("nfra", this.f70028s);
        }
    }

    public void a(String str) {
        this.f70024o = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            try {
                if (this.f69998d != dVar.f69998d || !this.f70026q.equals(dVar.f70026q) || !this.f70027r.equals(dVar.f70027r) || !this.f70021l.toString().equals(dVar.f70021l.toString())) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                TLogger.w("ErrorEvent", "unexpected for equals");
            }
        }
        return false;
    }

    public EventType getType() {
        return EventType.ERROR;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean onEncode(JSONObject jSONObject) {
        jSONObject.put("cmode", 2);
        jSONObject.put("ea", this.f70022m);
        jSONObject.put("prcp", Process.myPid());
        jSONObject.put("prct", Process.myTid());
        new a(this.f70003k, this.f69998d).a(jSONObject, this.f70023n);
        b(jSONObject);
        a(jSONObject);
        return true;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessId", this.f69998d);
            jSONObject.put("timestamp", this.f69999e);
            String str = this.f70026q;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.f69997c;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.f70027r;
            if (str3 != null) {
                jSONObject.put("sdkVersion", str3);
            }
            jSONObject.put("et", getType().GetIntValue());
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            TLogger.w("ErrorEvent", "unexpected for toJsonString");
            return null;
        }
    }

    public String toString() {
        return toJsonString();
    }

    private void a(JSONObject jSONObject) {
        jSONObject.put("md5", b.a(this.f70020b));
        jSONObject.put(UserDataStore.CITY, this.f70022m);
        jSONObject.put("bid", this.f70003k.getPackageName());
        jSONObject.put("dt", System.currentTimeMillis() / 1000);
    }

    private JSONObject a(Thread thread) {
        JSONObject jSONObject = new JSONObject();
        if (thread != null) {
            jSONObject.put("id", thread.getId());
            jSONObject.put("name", thread.getName());
            jSONObject.put("pr", thread.getPriority());
        }
        long j11 = this.f70025p;
        if (j11 > -1) {
            jSONObject.put("gthn", j11);
        }
        return jSONObject;
    }

    public boolean a() {
        String str;
        JSONArray jSONArray = this.f70021l;
        if (jSONArray != null) {
            str = jSONArray.toString();
        } else {
            str = this.f70020b;
        }
        return str.contains("com.tencent.android.tpush.") || str.contains("com.tencent.android.tpns.") || str.contains("com.tencent.tpns.");
    }
}
