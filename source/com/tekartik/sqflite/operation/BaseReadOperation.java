package com.tekartik.sqflite.operation;

import java.util.List;
import xy.b;
import yy.d;

public abstract class BaseReadOperation implements d {
    public b b() {
        return new b(g(), h());
    }

    public Boolean c() {
        return e("inTransaction");
    }

    public boolean d() {
        return Boolean.TRUE.equals(a("noResult"));
    }

    public final Boolean e(String str) {
        Object a11 = a(str);
        if (a11 instanceof Boolean) {
            return (Boolean) a11;
        }
        return null;
    }

    public boolean f() {
        return Boolean.TRUE.equals(a("continueOnError"));
    }

    public final String g() {
        return (String) a("sql");
    }

    public final List<Object> h() {
        return (List) a("arguments");
    }
}
