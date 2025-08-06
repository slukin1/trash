package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.f.b;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f38084a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f38085b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f38086c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f38084a = grsBaseInfo;
        this.f38085b = context;
    }

    private String e() {
        Set<String> b11 = b.a(this.f38085b.getPackageName()).b();
        if (b11.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : b11) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : this.f38086c) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f38085b;
    }

    public void a(String str) {
        this.f38086c.add(str);
    }

    public GrsBaseInfo b() {
        return this.f38084a;
    }

    public String c() {
        return this.f38086c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f38086c;
    }
}
