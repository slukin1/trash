package com.xiaomi.push;

import android.content.Context;

class an {

    /* renamed from: a  reason: collision with root package name */
    public static int f51385a;

    public static aj a(Context context) {
        if (j.a()) {
            f51385a = 1;
            return new am(context);
        } else if (ai.a(context)) {
            f51385a = 2;
            return new ai(context);
        } else if (ap.a(context)) {
            f51385a = 4;
            return new ap(context);
        } else if (ar.a(context)) {
            f51385a = 5;
            return new ar(context);
        } else if (al.a(context)) {
            f51385a = 3;
            return new ak(context);
        } else {
            f51385a = 0;
            return new aq();
        }
    }
}
