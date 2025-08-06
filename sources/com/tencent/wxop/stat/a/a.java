package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.e;
import com.tencent.wxop.stat.f;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d {

    /* renamed from: bj  reason: collision with root package name */
    public b f50929bj;

    /* renamed from: bk  reason: collision with root package name */
    private long f50930bk = -1;

    public a(Context context, int i11, String str, f fVar) {
        super(context, i11, fVar);
        b bVar = new b();
        this.f50929bj = bVar;
        bVar.f50931a = str;
    }

    public final b ab() {
        return this.f50929bj;
    }

    public final e ac() {
        return e.CUSTOM;
    }

    public final boolean b(JSONObject jSONObject) {
        Properties p11;
        jSONObject.put("ei", this.f50929bj.f50931a);
        long j11 = this.f50930bk;
        if (j11 > 0) {
            jSONObject.put("du", j11);
        }
        b bVar = this.f50929bj;
        JSONArray jSONArray = bVar.f50932bl;
        if (jSONArray == null) {
            String str = bVar.f50931a;
            if (!(str == null || (p11 = e.p(str)) == null || p11.size() <= 0)) {
                JSONObject jSONObject2 = this.f50929bj.f50933bm;
                if (jSONObject2 == null || jSONObject2.length() == 0) {
                    this.f50929bj.f50933bm = new JSONObject(p11);
                } else {
                    for (Map.Entry entry : p11.entrySet()) {
                        try {
                            this.f50929bj.f50933bm.put(entry.getKey().toString(), entry.getValue());
                        } catch (JSONException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
            }
            jSONObject.put("kv", this.f50929bj.f50933bm);
            return true;
        }
        jSONObject.put("ar", jSONArray);
        return true;
    }
}
