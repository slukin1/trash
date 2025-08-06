package com.mob.commons.b;

import android.content.Context;
import com.mob.commons.b.h;
import com.mob.commons.s;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;

public class c extends h {
    public c(Context context) {
        super(context);
    }

    public h.b b() {
        Object invokeInstanceMethodNoThrow;
        h.b bVar = new h.b();
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(s.a("008KehZf)ecejdg)d2djdc"));
        if (!(systemServiceSafe == null || (invokeInstanceMethodNoThrow = ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, s.a("010(dkff)id=di+e+ghRd:didc"), null, new Object[0])) == null)) {
            bVar.f27087a = invokeInstanceMethodNoThrow.toString();
        }
        return bVar;
    }
}
