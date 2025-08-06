package com.xiaomi.push;

public enum gu {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f2988a;

    private gu(int i11) {
        this.f2988a = i11;
    }

    public int a() {
        return this.f2988a;
    }

    public static gu a(int i11) {
        if (i11 == 0) {
            return RegIdExpired;
        }
        if (i11 == 1) {
            return PackageUnregistered;
        }
        if (i11 != 2) {
            return null;
        }
        return Init;
    }
}
