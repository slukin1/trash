package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import org.json.JSONObject;

public class f extends Event {

    /* renamed from: a  reason: collision with root package name */
    public long f70032a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f70033b = 0;

    /* renamed from: l  reason: collision with root package name */
    public double f70034l = 0.0d;

    /* renamed from: m  reason: collision with root package name */
    public String f70035m;

    /* renamed from: n  reason: collision with root package name */
    public String f70036n;

    public f(Context context, String str, String str2, int i11, double d11, long j11) {
        super(context, i11, j11);
        this.f70036n = str;
        this.f70035m = str2;
        this.f70034l = d11;
    }

    public EventType getType() {
        return EventType.PAGE_VIEW;
    }

    public boolean onEncode(JSONObject jSONObject) {
        j.a(jSONObject, "pi", this.f70035m);
        j.a(jSONObject, "rf", this.f70036n);
        double d11 = this.f70034l;
        if (d11 > 0.0d) {
            jSONObject.put("du", d11);
        }
        long j11 = this.f70032a;
        if (j11 > 0) {
            j.a(jSONObject, "msgId", j11);
        }
        long j12 = this.f70033b;
        if (j12 <= 0) {
            return true;
        }
        j.a(jSONObject, MessageKey.MSG_BUSI_MSG_ID, j12);
        return true;
    }
}
