package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.push.AttributionReporter;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

public class b extends Event {

    /* renamed from: a  reason: collision with root package name */
    public String f70006a;

    /* renamed from: b  reason: collision with root package name */
    public long f70007b = 0;

    /* renamed from: l  reason: collision with root package name */
    private String f70008l = null;

    /* renamed from: m  reason: collision with root package name */
    private String f70009m = null;

    /* renamed from: n  reason: collision with root package name */
    private String f70010n = null;

    /* renamed from: o  reason: collision with root package name */
    private long f70011o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f70012p = 0;

    public b(Context context, long j11, int i11) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.f69997c = XGApiConfig.getAccessKey(context);
        this.f69998d = XGApiConfig.getAccessId(context);
        this.f70008l = GuidInfoManager.getToken(context.getApplicationContext());
        this.f70009m = "1.4.4.2";
        this.f70010n = AppInfos.getCurAppVersion(context);
        this.f70011o = j11;
        this.f70012p = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            try {
                if (this.f69998d != bVar.f69998d || this.f69999e != bVar.f69999e || !this.f70008l.equals(bVar.f70008l) || !this.f70009m.equals(bVar.f70009m) || !this.f70006a.equals(bVar.f70006a) || this.f70007b != bVar.f70007b) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                TLogger.d("CloudEvent equals Error:", th2.getMessage());
            }
        }
        return false;
    }

    public long getAccessid() {
        return this.f69998d;
    }

    public EventType getType() {
        return null;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    public void setAccessid(long j11) {
        this.f69998d = j11;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessId", this.f69998d);
            jSONObject.put("timestamp", this.f69999e);
            String str = this.f70008l;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.f69997c;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.f70009m;
            if (str3 != null) {
                jSONObject.put("sdkVersion", str3);
            }
            String str4 = this.f70010n;
            if (str4 != null) {
                jSONObject.put(AttributionReporter.APP_VERSION, str4);
            }
            jSONObject.put("et", 4);
            jSONObject.put("sdkVersionName", Build.VERSION.RELEASE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cloudVersion", this.f70011o);
            jSONObject2.put("cloudControlRet", this.f70012p);
            jSONObject.put("cloudMsg", jSONObject2);
            return jSONObject.toString();
        } catch (Throwable th2) {
            TLogger.e("CloudEvent toJson Error:", th2.getMessage());
            return null;
        }
    }

    public String toString() {
        return toJsonString();
    }
}
