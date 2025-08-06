package com.xiaomi.push;

public class ie {

    /* renamed from: a  reason: collision with root package name */
    private static int f52357a = Integer.MAX_VALUE;

    public static void a(ib ibVar, byte b11) {
        a(ibVar, b11, f52357a);
    }

    public static void a(ib ibVar, byte b11, int i11) {
        if (i11 > 0) {
            int i12 = 0;
            switch (b11) {
                case 2:
                    ibVar.a();
                    return;
                case 3:
                    ibVar.a();
                    return;
                case 4:
                    ibVar.a();
                    return;
                case 6:
                    ibVar.a();
                    return;
                case 8:
                    ibVar.a();
                    return;
                case 10:
                    ibVar.a();
                    return;
                case 11:
                    ibVar.a();
                    return;
                case 12:
                    ibVar.a();
                    while (true) {
                        byte b12 = ibVar.a().f52345a;
                        if (b12 == 0) {
                            ibVar.f();
                            return;
                        } else {
                            a(ibVar, b12, i11 - 1);
                            ibVar.g();
                        }
                    }
                case 13:
                    ia a11 = ibVar.a();
                    while (i12 < a11.f3247a) {
                        int i13 = i11 - 1;
                        a(ibVar, a11.f52353a, i13);
                        a(ibVar, a11.f52354b, i13);
                        i12++;
                    }
                    ibVar.h();
                    return;
                case 14:
                    Cif a12 = ibVar.a();
                    while (i12 < a12.f3248a) {
                        a(ibVar, a12.f52358a, i11 - 1);
                        i12++;
                    }
                    ibVar.j();
                    return;
                case 15:
                    hz a13 = ibVar.a();
                    while (i12 < a13.f3244a) {
                        a(ibVar, a13.f52346a, i11 - 1);
                        i12++;
                    }
                    ibVar.i();
                    return;
                default:
                    return;
            }
        } else {
            throw new hv("Maximum skip depth exceeded");
        }
    }
}
