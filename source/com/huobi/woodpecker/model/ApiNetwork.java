package com.huobi.woodpecker.model;

import android.text.TextUtils;
import com.huobi.woodpecker.model.base.IRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiNetwork implements IRecord {

    /* renamed from: ip  reason: collision with root package name */
    private String f21133ip;
    private String isp;

    /* renamed from: nt  reason: collision with root package name */
    private String f21134nt;

    public String getIp() {
        return this.f21133ip;
    }

    public String getIsp() {
        return this.isp;
    }

    public String getNt() {
        return this.f21134nt;
    }

    public void setIp(String str) {
        this.f21133ip = str;
    }

    public void setIsp(String str) {
        this.isp = str;
    }

    public void setNt(String str) {
        this.f21134nt = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", this.f21133ip);
            jSONObject.put("nt", this.f21134nt);
            if (!TextUtils.isEmpty(this.isp)) {
                jSONObject.put("isp", this.isp);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public String toString() {
        return toJsonString();
    }
}
