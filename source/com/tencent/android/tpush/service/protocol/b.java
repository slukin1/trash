package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f69697a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69698b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f69699c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f69700d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f69701e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f69702f = "";

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.f69697a);
        jSONObject.put("accessKey", this.f69698b);
        jSONObject.put("attributes", new JSONObject(this.f69699c));
        jSONObject.put(Constants.FLAG_ACCOUNT_OP_TYPE, this.f69700d);
        jSONObject.put("timestamp", this.f69701e);
        jSONObject.put("sdkVersion", this.f69702f);
        return jSONObject;
    }

    public MessageType a() {
        return MessageType.ATTRIBUTE_INFO;
    }
}
