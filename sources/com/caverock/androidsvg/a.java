package com.caverock.androidsvg;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f64616a;

    /* renamed from: b  reason: collision with root package name */
    public long f64617b;

    public a(long j11, int i11) {
        this.f64617b = j11;
        this.f64616a = i11;
    }

    public static a b(String str, int i11, int i12) {
        long j11;
        int i13;
        if (i11 >= i12) {
            return null;
        }
        long j12 = 0;
        int i14 = i11;
        while (i14 < i12) {
            char charAt = str.charAt(i14);
            if (charAt < '0' || charAt > '9') {
                if (charAt < 'A' || charAt > 'F') {
                    if (charAt < 'a' || charAt > 'f') {
                        break;
                    }
                    j11 = j12 * 16;
                    i13 = charAt - 'a';
                } else {
                    j11 = j12 * 16;
                    i13 = charAt - 'A';
                }
                j12 = j11 + ((long) i13) + 10;
            } else {
                j12 = (j12 * 16) + ((long) (charAt - '0'));
            }
            if (j12 > 4294967295L) {
                return null;
            }
            i14++;
        }
        if (i14 == i11) {
            return null;
        }
        return new a(j12, i14);
    }

    public static a c(String str, int i11, int i12, boolean z11) {
        if (i11 >= i12) {
            return null;
        }
        boolean z12 = false;
        if (z11) {
            char charAt = str.charAt(i11);
            if (charAt != '+') {
                if (charAt == '-') {
                    z12 = true;
                }
            }
            i11++;
        }
        long j11 = 0;
        int i13 = i11;
        while (i13 < i12) {
            char charAt2 = str.charAt(i13);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            if (z12) {
                j11 = (j11 * 10) - ((long) (charAt2 - '0'));
                if (j11 < -2147483648L) {
                    return null;
                }
            } else {
                j11 = (j11 * 10) + ((long) (charAt2 - '0'));
                if (j11 > 2147483647L) {
                    return null;
                }
            }
            i13++;
        }
        if (i13 == i11) {
            return null;
        }
        return new a(j11, i13);
    }

    public int a() {
        return this.f64616a;
    }

    public int d() {
        return (int) this.f64617b;
    }
}
