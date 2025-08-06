package com.xiaomi.push;

public class y {

    /* renamed from: a  reason: collision with root package name */
    private static int f52621a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f3453a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f3454a = false;

    static {
        String str = ab.f51354a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f3453a = str;
        f52621a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            f52621a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            f52621a = 3;
        } else {
            f52621a = 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3070a() {
        return f52621a == 2;
    }

    public static boolean b() {
        return f52621a == 3;
    }

    public static int a() {
        return f52621a;
    }

    public static void a(int i11) {
        f52621a = i11;
    }
}
