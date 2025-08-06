package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class s extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f69835a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69836b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f69837c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f69838d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f69839e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f69840f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f69841g = "";

    public s() {
    }

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.f69835a);
        jSONObject.put("accessKey", this.f69836b);
        jSONObject.put("channelType", this.f69837c);
        jSONObject.put("channelToken", this.f69838d);
        jSONObject.put("deviceRegion", this.f69839e);
        jSONObject.put("timestamp", this.f69840f);
        jSONObject.put("sdkVersion", this.f69841g);
        return jSONObject;
    }

    public s(long j11, String str, String str2, String str3, String str4, long j12, String str5) {
        this.f69835a = j11;
        this.f69836b = str;
        this.f69837c = str2;
        this.f69838d = str3;
        this.f69839e = str4;
        this.f69840f = j12;
        this.f69841g = str5;
    }

    public MessageType a() {
        return MessageType.UPDATE_OTHER_TOKEN;
    }
}
