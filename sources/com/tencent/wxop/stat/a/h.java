package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class h extends d {
    public String aR;
    public String aS;
    public Long bI = null;

    public h(Context context, String str, String str2, int i11, Long l11, f fVar) {
        super(context, i11, fVar);
        this.aS = str;
        this.aR = str2;
        this.bI = l11;
    }

    public final e ac() {
        return e.PAGE_VIEW;
    }

    public final boolean b(JSONObject jSONObject) {
        r.a(jSONObject, "pi", this.aR);
        r.a(jSONObject, "rf", this.aS);
        Long l11 = this.bI;
        if (l11 == null) {
            return true;
        }
        jSONObject.put("du", l11);
        return true;
    }
}
