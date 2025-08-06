package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private static String f50952a;
    private String aR = null;
    private String aS = null;

    public g(Context context, int i11, f fVar) {
        super(context, i11, fVar);
        this.aR = com.tencent.wxop.stat.g.r(context).b();
        if (f50952a == null) {
            f50952a = l.C(context);
        }
    }

    public final e ac() {
        return e.NETWORK_MONITOR;
    }

    public final void b(String str) {
        this.aS = str;
    }

    public final boolean b(JSONObject jSONObject) {
        r.a(jSONObject, "op", f50952a);
        r.a(jSONObject, "cn", this.aR);
        jSONObject.put("sp", this.aS);
        return true;
    }
}
