package com.xiaomi.push;

public enum gm {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f2928a;

    private gm(int i11) {
        this.f2928a = i11;
    }

    public int a() {
        return this.f2928a;
    }

    public static gm a(int i11) {
        if (i11 == 1) {
            return MISC_CONFIG;
        }
        if (i11 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
