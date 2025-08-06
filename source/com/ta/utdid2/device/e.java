package com.ta.utdid2.device;

import vy.a;
import vy.b;
import vy.f;

class e {
    public String g(String str) {
        return a.e(str);
    }

    public String h(String str) {
        String e11 = a.e(str);
        if (!f.c(e11)) {
            try {
                return new String(b.a(e11, 0));
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
