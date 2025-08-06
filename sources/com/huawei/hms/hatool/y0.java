package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

public class y0 extends t0 {

    /* renamed from: f  reason: collision with root package name */
    public String f38297f;

    /* renamed from: g  reason: collision with root package name */
    public String f38298g;

    /* renamed from: h  reason: collision with root package name */
    private String f38299h;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f38299h);
        jSONObject.put("_emui_ver", this.f38280a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f38297f);
        jSONObject.put("_mnc", this.f38298g);
        jSONObject.put("_package_name", this.f38281b);
        jSONObject.put("_app_ver", this.f38282c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.f38283d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f38284e);
        return jSONObject;
    }

    public void f(String str) {
        this.f38297f = str;
    }

    public void g(String str) {
        this.f38298g = str;
    }

    public void h(String str) {
        this.f38299h = str;
    }
}
