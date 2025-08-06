package com.qihoo.stat;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public class i {

    /* renamed from: h  reason: collision with root package name */
    public static String f28771h = "EventBean";

    /* renamed from: a  reason: collision with root package name */
    public String f28772a = "";

    /* renamed from: b  reason: collision with root package name */
    public long f28773b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f28774c = "";

    /* renamed from: d  reason: collision with root package name */
    public long f28775d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f28776e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f28777f = -1;

    /* renamed from: g  reason: collision with root package name */
    public Map f28778g = null;

    public JSONObject a() {
        JSONObject jSONObject;
        Exception e11;
        Error e12;
        try {
            if (TextUtils.isEmpty(this.f28772a)) {
                return null;
            }
            if (TextUtils.isEmpty(this.f28774c)) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("qhId", this.f28772a);
                    if (this.f28776e > 0) {
                        jSONObject.put("qhBegin", this.f28775d);
                        jSONObject.put("qhEnd", this.f28776e);
                        jSONObject.put("qhDuration", this.f28777f);
                    } else {
                        long j11 = this.f28775d;
                        if (j11 > 0) {
                            jSONObject.put("qhBegin", j11);
                        } else {
                            jSONObject.put("qhTs", this.f28773b);
                        }
                    }
                    Map map = this.f28778g;
                    if (map != null) {
                        for (Map.Entry entry : map.entrySet()) {
                            String str = (String) entry.getKey();
                            String str2 = (String) entry.getValue();
                            if (!"qhId".equals(str) && !"qhTs".equals(str)) {
                                jSONObject.put(str, str2);
                            }
                        }
                    }
                } catch (Exception e13) {
                    e11 = e13;
                    g0.b(f28771h, e11);
                    return jSONObject;
                } catch (Error e14) {
                    e12 = e14;
                    g0.a(f28771h, e12);
                    return jSONObject;
                }
                return jSONObject;
            } else if (!"end".equals(this.f28774c) && !"begin".equals(this.f28774c)) {
                return null;
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("qhId", this.f28772a);
                    jSONObject2.put("qhBegin", this.f28775d);
                    if ("end".equals(this.f28774c)) {
                        jSONObject2.put("qhEnd", this.f28776e);
                        jSONObject2.put("qhDuration", this.f28777f);
                    }
                    Map map2 = this.f28778g;
                    if (map2 != null) {
                        for (Map.Entry entry2 : map2.entrySet()) {
                            String str3 = (String) entry2.getKey();
                            String str4 = (String) entry2.getValue();
                            if (!"qhId".equals(str3) && !"qhBegin".equals(str3) && !"qhEnd".equals(str3) && !"qhDuration".equals(str3)) {
                                jSONObject2.put(str3, str4);
                            }
                        }
                    }
                    return jSONObject2;
                } catch (Exception e15) {
                    e11 = e15;
                    jSONObject = jSONObject2;
                    g0.b(f28771h, e11);
                    return jSONObject;
                } catch (Error e16) {
                    e12 = e16;
                    jSONObject = jSONObject2;
                    g0.a(f28771h, e12);
                    return jSONObject;
                }
            }
        } catch (Exception e17) {
            e11 = e17;
            jSONObject = null;
            g0.b(f28771h, e11);
            return jSONObject;
        } catch (Error e18) {
            e12 = e18;
            jSONObject = null;
            g0.a(f28771h, e12);
            return jSONObject;
        }
    }
}
