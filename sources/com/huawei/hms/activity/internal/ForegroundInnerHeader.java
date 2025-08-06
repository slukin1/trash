package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ForegroundInnerHeader {

    /* renamed from: a  reason: collision with root package name */
    private int f37686a;

    /* renamed from: b  reason: collision with root package name */
    private String f37687b;

    /* renamed from: c  reason: collision with root package name */
    private String f37688c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f37686a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f37687b = JsonUtil.getStringValue(jSONObject, "action");
            this.f37688c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e11) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e11.getMessage());
        }
    }

    public String getAction() {
        return this.f37687b;
    }

    public int getApkVersion() {
        return this.f37686a;
    }

    public String getResponseCallbackKey() {
        return this.f37688c;
    }

    public void setAction(String str) {
        this.f37687b = str;
    }

    public void setApkVersion(int i11) {
        this.f37686a = i11;
    }

    public void setResponseCallbackKey(String str) {
        this.f37688c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f37686a);
            jSONObject.put("action", this.f37687b);
            jSONObject.put("responseCallbackKey", this.f37688c);
        } catch (JSONException e11) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e11.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f37686a + ", action:" + this.f37687b + ", responseCallbackKey:" + this.f37688c;
    }
}
