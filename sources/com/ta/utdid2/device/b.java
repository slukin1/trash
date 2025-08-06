package com.ta.utdid2.device;

import android.content.Context;
import com.ta.a.e.h;
import org.json.JSONException;
import org.json.JSONObject;
import py.a;
import ty.d;

class b {

    /* renamed from: e  reason: collision with root package name */
    public int f40377e = -1;

    public static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                bVar.f40377e = jSONObject2.getInt("code");
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("utdid")) {
                String string = jSONObject.getString("utdid");
                if (c.c(string)) {
                    Context f11 = a.c().f();
                    d.c(string);
                    d.b(f11, string);
                    d.f(string);
                }
            }
            h.e("BizResponse", "content", str);
        } catch (JSONException e11) {
            h.e("", e11.toString());
        }
        return bVar;
    }

    public static boolean b(int i11) {
        return i11 >= 0 && i11 != 10012;
    }
}
