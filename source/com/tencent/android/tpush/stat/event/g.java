package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.json.JSONObject;

public class g extends Event {

    /* renamed from: a  reason: collision with root package name */
    public String f70037a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f70038b = null;

    /* renamed from: l  reason: collision with root package name */
    public int f70039l;

    /* renamed from: m  reason: collision with root package name */
    public String f70040m;

    /* renamed from: n  reason: collision with root package name */
    public long f70041n = 0;

    /* renamed from: o  reason: collision with root package name */
    public String f70042o;

    /* renamed from: p  reason: collision with root package name */
    public byte f70043p;

    public g(Context context, int i11, String str) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.f69997c = XGApiConfig.getAccessKey(context);
        this.f69998d = XGApiConfig.getAccessId(context);
        this.f70037a = GuidInfoManager.getToken(context.getApplicationContext());
        this.f70038b = "1.4.4.2";
        this.f70039l = i11;
        this.f70042o = str;
        this.f70043p = DeviceInfos.getNetworkType(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            try {
                if (this.f69998d == gVar.f69998d && this.f69999e == gVar.f69999e && this.f70037a.equals(gVar.f70037a) && this.f70038b.equals(gVar.f70038b) && this.f70039l == gVar.f70039l && this.f70040m.equals(gVar.f70040m) && this.f70041n == gVar.f70041n && this.f70042o.equals(gVar.f70042o) && this.f70043p == gVar.f70043p) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                TLogger.d("RspErrcodeEvent equals Error:", th2.getMessage());
            }
        }
        return false;
    }

    public long getAccessid() {
        return this.f69998d;
    }

    public EventType getType() {
        return EventType.ERRCODE;
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
            String str = this.f70037a;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.f69997c;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.f70038b;
            if (str3 != null) {
                jSONObject.put("sdkVersion", str3);
            }
            jSONObject.put("et", getType().GetIntValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", this.f70039l);
            String str4 = this.f70040m;
            if (str4 != null) {
                jSONObject2.put(RemoteMessageConst.MessageBody.MSG, str4);
            }
            long j11 = this.f70041n;
            if (0 != j11) {
                jSONObject2.put("id", j11);
            }
            jSONObject.put("errCode", jSONObject2);
            String str5 = this.f70042o;
            if (str5 != null) {
                jSONObject.put("errType", str5);
            }
            jSONObject.put("networkType", this.f70043p);
            return jSONObject.toString();
        } catch (Throwable th2) {
            TLogger.e("RspErrcodeEvent toJson Error:", th2.getMessage());
            return null;
        }
    }

    public String toString() {
        return toJsonString();
    }
}
