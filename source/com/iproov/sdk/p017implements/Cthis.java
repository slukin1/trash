package com.iproov.sdk.p017implements;

import com.tencent.android.tpush.common.MessageKey;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.implements.this  reason: invalid class name and invalid package */
public final class Cthis {

    /* renamed from: do  reason: not valid java name */
    private final double f947do;

    /* renamed from: for  reason: not valid java name */
    private final double f948for;

    /* renamed from: if  reason: not valid java name */
    private final double f949if;

    public Cthis(double d11, double d12, double d13, int i11) {
        this.f947do = d11;
        this.f949if = d12;
        this.f948for = d13;
    }

    /* renamed from: do  reason: not valid java name */
    public final double m1040do() {
        return this.f947do;
    }

    /* renamed from: if  reason: not valid java name */
    public final JSONObject m1041if() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("avg", this.f947do);
        jSONObject.put(MessageKey.MSG_ACCEPT_TIME_MIN, this.f949if);
        jSONObject.put("max", this.f948for);
        return jSONObject;
    }
}
