package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h1 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    private List<b1> f38176a;

    /* renamed from: b  reason: collision with root package name */
    private k0 f38177b;

    /* renamed from: c  reason: collision with root package name */
    private t0 f38178c;

    /* renamed from: d  reason: collision with root package name */
    private o1 f38179d;

    /* renamed from: e  reason: collision with root package name */
    private String f38180e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f38181f;

    public h1(String str) {
        this.f38181f = str;
    }

    public JSONObject a() {
        String str;
        List<b1> list = this.f38176a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f38177b == null || this.f38178c == null || this.f38179d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f38177b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a11 = this.f38179d.a();
            a11.put("properties", this.f38178c.a());
            try {
                a11.put("events_global_properties", new JSONObject(this.f38180e));
            } catch (JSONException unused) {
                a11.put("events_global_properties", this.f38180e);
            }
            jSONObject2.put("events_common", a11);
            JSONArray jSONArray = new JSONArray();
            for (b1 a12 : this.f38176a) {
                JSONObject a13 = a12.a();
                if (a13 != null) {
                    jSONArray.put(a13);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(DbParams.TABLE_EVENTS, jSONArray);
            try {
                String a14 = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f38181f);
                if (TextUtils.isEmpty(a14)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a14);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f38177b = k0Var;
    }

    public void a(l lVar) {
        this.f38179d = lVar;
    }

    public void a(t0 t0Var) {
        this.f38178c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f38180e = str;
        }
    }

    public void a(List<b1> list) {
        this.f38176a = list;
    }
}
