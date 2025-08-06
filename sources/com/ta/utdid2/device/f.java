package com.ta.utdid2.device;

import com.ta.a.d.a;
import com.ta.a.e.h;

public class f {
    public static boolean a(a aVar) {
        String str = "";
        try {
            str = new String(aVar.f40360d, "UTF-8");
        } catch (Exception e11) {
            h.e(str, e11);
        }
        if (a.a(str, aVar.f40359c)) {
            return b.b(b.a(str).f40377e);
        }
        return false;
    }
}
