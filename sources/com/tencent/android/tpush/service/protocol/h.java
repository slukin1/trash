package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f69728a;

    /* renamed from: b  reason: collision with root package name */
    public String f69729b;

    /* renamed from: c  reason: collision with root package name */
    public String f69730c;

    /* renamed from: d  reason: collision with root package name */
    public String f69731d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ssid", this.f69728a);
        jSONObject.put("bssid", this.f69729b);
        jSONObject.put("mac", this.f69730c);
        jSONObject.put("wflist", this.f69731d);
        return jSONObject;
    }
}
