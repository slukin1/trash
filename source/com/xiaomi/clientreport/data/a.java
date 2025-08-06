package com.xiaomi.clientreport.data;

import com.sumsub.sentry.q;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bm;
import com.xiaomi.push.j;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public String clientInterfaceId;
    private String miuiVersion = j.a();

    /* renamed from: os  reason: collision with root package name */
    private String f51262os = bm.a();
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String str) {
        this.pkgName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.production);
            jSONObject.put("reportType", this.reportType);
            jSONObject.put("clientInterfaceId", this.clientInterfaceId);
            jSONObject.put(q.f30469g, this.f51262os);
            jSONObject.put("miuiVersion", this.miuiVersion);
            jSONObject.put("pkgName", this.pkgName);
            jSONObject.put("sdkVersion", this.sdkVersion);
            return jSONObject;
        } catch (JSONException e11) {
            b.a((Throwable) e11);
            return null;
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        if (json == null) {
            return "";
        }
        return json.toString();
    }
}
