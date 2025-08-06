package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f69812a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f69813b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f69814c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f69815d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f69816e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f69817f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f69818g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bootTime", this.f69812a);
        jSONObject.put("countryCode", this.f69813b);
        jSONObject.put("deviceName", this.f69814c);
        jSONObject.put("carrierInfo", this.f69815d);
        jSONObject.put("memorySize", this.f69816e);
        jSONObject.put("diskSize", this.f69817f);
        jSONObject.put("sysFileTime", this.f69818g);
        return jSONObject;
    }
}
