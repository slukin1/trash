package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class r extends d {

    /* renamed from: a  reason: collision with root package name */
    public short f69827a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f69828b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f69829c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f69830d = "";

    /* renamed from: e  reason: collision with root package name */
    public byte f69831e = 0;

    /* renamed from: f  reason: collision with root package name */
    public byte f69832f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f69833g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f69834h = "";

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceType", this.f69827a);
        jSONObject.put("accessId", this.f69828b);
        jSONObject.put("accessKey", this.f69829c);
        jSONObject.put("appCert", this.f69830d);
        jSONObject.put("keyEncrypted", this.f69831e);
        jSONObject.put("isUninstall", this.f69832f);
        jSONObject.put("timestamp", this.f69833g);
        jSONObject.put("sdkVersion", this.f69834h);
        return jSONObject;
    }

    public MessageType a() {
        return MessageType.UNREGISTER;
    }
}
