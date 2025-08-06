package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.g;
import org.json.JSONObject;

public final class d {

    /* renamed from: cw  reason: collision with root package name */
    public static e f50999cw;

    /* renamed from: cx  reason: collision with root package name */
    private static b f51000cx = l.av();

    /* renamed from: cz  reason: collision with root package name */
    private static JSONObject f51001cz = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    public String f51002c = null;

    /* renamed from: cy  reason: collision with root package name */
    public Integer f51003cy = null;

    public d(Context context) {
        try {
            u(context);
            this.f51003cy = l.F(context.getApplicationContext());
            this.f51002c = g.r(context).b();
        } catch (Throwable th2) {
            f51000cx.b(th2);
        }
    }

    private static synchronized e u(Context context) {
        e eVar;
        synchronized (d.class) {
            if (f50999cw == null) {
                f50999cw = new e(context.getApplicationContext(), (byte) 0);
            }
            eVar = f50999cw;
        }
        return eVar;
    }

    public final void a(JSONObject jSONObject, Thread thread) {
        String str;
        Object obj;
        JSONObject jSONObject2 = new JSONObject();
        try {
            e eVar = f50999cw;
            if (eVar != null) {
                eVar.a(jSONObject2, thread);
            }
            r.a(jSONObject2, "cn", this.f51002c);
            Integer num = this.f51003cy;
            if (num != null) {
                jSONObject2.put("tn", num);
            }
            if (thread == null) {
                str = "ev";
                obj = jSONObject2;
            } else {
                str = "errkv";
                obj = jSONObject2.toString();
            }
            jSONObject.put(str, obj);
            JSONObject jSONObject3 = f51001cz;
            if (jSONObject3 != null && jSONObject3.length() > 0) {
                jSONObject.put("eva", f51001cz);
            }
        } catch (Throwable th2) {
            f51000cx.b(th2);
        }
    }
}
