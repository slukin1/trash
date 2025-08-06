package com.huobi.woodpecker.model;

import com.huobi.woodpecker.model.base.IRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class OpPath implements IRecord {

    /* renamed from: o  reason: collision with root package name */
    public String f21143o;

    /* renamed from: t  reason: collision with root package name */
    public String f21144t;

    public OpPath(String str, String str2) {
        this.f21144t = str;
        this.f21143o = str2;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.f21144t);
            jSONObject.put("o", this.f21143o);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }
}
