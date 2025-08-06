package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

public class l extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f69768a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f69769b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f69770c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f69771d = 100;

    /* renamed from: e  reason: collision with root package name */
    public long f69772e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f69773f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f69774g = "";

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.f69768a);
        jSONObject.put("accessKey", this.f69769b);
        jSONObject.put(Constants.FLAG_TAG_OFFSET, this.f69770c);
        jSONObject.put("limit", this.f69771d);
        jSONObject.put("timestamp", this.f69772e);
        jSONObject.put("sdkVersion", this.f69773f);
        if (!TextUtils.isEmpty(this.f69774g)) {
            jSONObject.put(Constants.FLAG_TAG_QUERY_TYPE, this.f69774g);
        }
        return jSONObject;
    }

    public MessageType a() {
        return MessageType.QUERY_TAGS;
    }
}
