package com.tencent.android.tpush;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XGServerInfo {
    public static final String TAG_IP = "ip";
    public static final String TAG_PORT = "port";
    public static final String TAG_PROXY_IP = "p_ip";
    public static final String TAG_PROXY_PORT = "p_port";

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f68088a = new JSONArray();

    public XGServerInfo() {
    }

    private void a(String str, int i11, String str2, int i12) {
        if (!TextUtils.isEmpty(str) && i11 > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", str);
                jSONObject.put(TAG_PORT, i11);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(TAG_PROXY_IP, i12);
                    jSONObject.put(TAG_PROXY_PORT, i12);
                }
                this.f68088a.put(jSONObject);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }

    public XGServerInfo addServerIp(String str, int i11) {
        a(str, i11, (String) null, 0);
        return this;
    }

    public JSONArray getIpArray() {
        return this.f68088a;
    }

    public boolean isEmpty() {
        JSONArray jSONArray = this.f68088a;
        return jSONArray != null && jSONArray.length() > 0;
    }

    public void reset() {
        this.f68088a = new JSONArray();
    }

    public XGServerInfo addServerIp(String str, int i11, String str2, int i12) {
        a(str, i11, str2, i12);
        return this;
    }

    public XGServerInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f68088a = new JSONArray(str);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }
}
