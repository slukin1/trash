package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.stat.b.a;
import com.tencent.android.tpush.stat.b.b;
import org.json.JSONObject;

public class h extends Event {

    /* renamed from: a  reason: collision with root package name */
    private a f70044a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f70045b = null;

    public h(Context context, int i11, JSONObject jSONObject, long j11) {
        super(context, i11, j11);
        this.f70044a = new a(context, j11);
        this.f70045b = jSONObject;
    }

    public EventType getType() {
        return EventType.SESSION_ENV;
    }

    public boolean onEncode(JSONObject jSONObject) {
        jSONObject.put("ut", 1);
        JSONObject jSONObject2 = this.f70045b;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (b.e(this.f70003k)) {
            jSONObject.put("ncts", 1);
        }
        this.f70044a.a(jSONObject, (Thread) null);
        return true;
    }
}
