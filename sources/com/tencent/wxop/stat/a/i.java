package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class i extends d {
    private d bJ;
    private JSONObject bK = null;

    public i(Context context, int i11, JSONObject jSONObject, f fVar) {
        super(context, i11, fVar);
        this.bJ = new d(context);
        this.bK = jSONObject;
    }

    public final e ac() {
        return e.SESSION_ENV;
    }

    public final boolean b(JSONObject jSONObject) {
        c cVar = this.f50941bp;
        if (cVar != null) {
            jSONObject.put("ut", cVar.as());
        }
        JSONObject jSONObject2 = this.bK;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (l.P(this.f50946bv)) {
            jSONObject.put("ncts", 1);
        }
        this.bJ.a(jSONObject, (Thread) null);
        return true;
    }
}
