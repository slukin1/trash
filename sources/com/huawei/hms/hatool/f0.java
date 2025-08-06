package com.huawei.hms.hatool;

import org.json.JSONObject;

public class f0 extends k0 {

    /* renamed from: g  reason: collision with root package name */
    private String f38153g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f38207d);
        jSONObject.put("appid", this.f38204a);
        jSONObject.put("hmac", this.f38153g);
        jSONObject.put("chifer", this.f38209f);
        jSONObject.put("timestamp", this.f38205b);
        jSONObject.put("servicetag", this.f38206c);
        jSONObject.put("requestid", this.f38208e);
        return jSONObject;
    }

    public void g(String str) {
        this.f38153g = str;
    }
}
