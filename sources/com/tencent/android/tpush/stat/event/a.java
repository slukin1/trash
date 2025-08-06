package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.stat.b.d;
import org.json.JSONObject;

public class a extends f {

    /* renamed from: o  reason: collision with root package name */
    private static int f70005o;

    public a(Context context, int i11, double d11, long j11) {
        super(context, (String) null, (String) null, i11, d11, j11);
        if (f70005o == 0) {
            int a11 = d.a(context, "back_ev_index", 0);
            f70005o = a11;
            if (a11 > 2147383647) {
                f70005o = 0;
            }
        }
        int i12 = f70005o + 1;
        f70005o = i12;
        d.b(context, "back_ev_index", i12);
    }

    public EventType getType() {
        return EventType.BACKGROUND;
    }

    public boolean onEncode(JSONObject jSONObject) {
        jSONObject.put("bc", f70005o);
        jSONObject.put("ft", 1);
        return super.onEncode(jSONObject);
    }
}
