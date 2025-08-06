package com.huawei.hms.hatool;

import com.huobi.vulcan.model.VulcanInfo;
import org.json.JSONObject;

public class l extends t {

    /* renamed from: b  reason: collision with root package name */
    private String f38210b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f38211c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f38212d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f38213e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f38214f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f38215g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f38279a);
        jSONObject.put("oaid", this.f38215g);
        jSONObject.put(ZendeskIdentityStorage.UUID_KEY, this.f38214f);
        jSONObject.put("upid", this.f38213e);
        jSONObject.put(VulcanInfo.IMEI, this.f38210b);
        jSONObject.put("sn", this.f38211c);
        jSONObject.put("udid", this.f38212d);
        return jSONObject;
    }

    public void b(String str) {
        this.f38210b = str;
    }

    public void c(String str) {
        this.f38215g = str;
    }

    public void d(String str) {
        this.f38211c = str;
    }

    public void e(String str) {
        this.f38212d = str;
    }

    public void f(String str) {
        this.f38213e = str;
    }

    public void g(String str) {
        this.f38214f = str;
    }
}
