package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

public abstract class e0 {
    private i a(int i11) {
        String str;
        if (i11 != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private i b(int i11) {
        String str;
        if ((i11 & 4) != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private boolean e() {
        g1 b11 = s.c().b();
        if (TextUtils.isEmpty(b11.l())) {
            b11.h(o.a());
        }
        return !TextUtils.isEmpty(b11.l());
    }

    private String f() {
        g1 b11 = s.c().b();
        if (TextUtils.isEmpty(b11.i())) {
            b11.e(x0.c());
        }
        return b11.i();
    }

    public i a(Context context) {
        String c11 = c();
        if (!TextUtils.isEmpty(c11)) {
            return new i(d0.UDID, c11);
        }
        String a11 = a();
        if (!TextUtils.isEmpty(a11)) {
            return new i(d0.IMEI, a11);
        }
        boolean e11 = e();
        String b11 = b();
        return !TextUtils.isEmpty(b11) ? e11 ? new i(d0.SN, b11) : new i(d0.UDID, a(b11)) : e11 ? a(d()) : b(d());
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();
}
