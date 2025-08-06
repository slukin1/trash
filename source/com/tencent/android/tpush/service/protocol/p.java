package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

public class p extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f69819a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69820b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f69821c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f69822d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f69823e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f69824f = "";

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.f69819a);
        jSONObject.put("accessKey", this.f69820b);
        jSONObject.put("tag", this.f69821c);
        jSONObject.put("flag", this.f69822d);
        jSONObject.put("timestamp", this.f69823e);
        jSONObject.put("sdkVersion", this.f69824f);
        return jSONObject;
    }

    public MessageType a() {
        return MessageType.TAG_INFO;
    }
}
