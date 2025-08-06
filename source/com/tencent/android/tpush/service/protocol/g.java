package com.tencent.android.tpush.service.protocol;

import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public long f69725a;

    /* renamed from: b  reason: collision with root package name */
    public String f69726b;

    /* renamed from: c  reason: collision with root package name */
    public String f69727c;

    public boolean a() {
        return this.f69725a > 0 && !TextUtils.isEmpty(this.f69726b) && !this.f69726b.equals("0") && !TextUtils.isEmpty(this.f69727c);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessid", this.f69725a);
        jSONObject.put("token", this.f69726b);
        jSONObject.put(AppsFlyerProperties.CHANNEL, this.f69727c);
        return jSONObject;
    }
}
