package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f69825a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69826b = null;

    public void a(int i11) {
        this.f69825a = i11;
    }

    public void a(String str) {
        this.f69826b = str;
    }

    public JSONObject a() {
        if (this.f69826b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accountType", this.f69825a);
        jSONObject.put(Constants.FLAG_ACCOUNT, this.f69826b);
        return jSONObject;
    }
}
