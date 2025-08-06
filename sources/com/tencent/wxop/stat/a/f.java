package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.c;
import org.json.JSONObject;

public final class f extends d {

    /* renamed from: bw  reason: collision with root package name */
    public static final com.tencent.wxop.stat.f f50951bw;

    static {
        com.tencent.wxop.stat.f fVar = new com.tencent.wxop.stat.f();
        f50951bw = fVar;
        fVar.s("A9VH9B8L4GX4");
    }

    public f(Context context) {
        super(context, 0, f50951bw);
    }

    public final e ac() {
        return e.NETWORK_DETECTOR;
    }

    public final boolean b(JSONObject jSONObject) {
        r.a(jSONObject, "actky", c.d(this.f50946bv));
        return true;
    }
}
