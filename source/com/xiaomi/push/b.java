package com.xiaomi.push;

import com.google.common.base.Ascii;
import java.io.InputStream;
import java.util.Vector;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f51415a;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f2551a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f2552a;

    /* renamed from: b  reason: collision with root package name */
    private int f51416b;

    /* renamed from: c  reason: collision with root package name */
    private int f51417c;

    /* renamed from: d  reason: collision with root package name */
    private int f51418d;

    /* renamed from: e  reason: collision with root package name */
    private int f51419e;

    /* renamed from: f  reason: collision with root package name */
    private int f51420f;

    /* renamed from: g  reason: collision with root package name */
    private int f51421g;

    /* renamed from: h  reason: collision with root package name */
    private int f51422h;

    /* renamed from: i  reason: collision with root package name */
    private int f51423i;

    private b(byte[] bArr, int i11, int i12) {
        this.f51420f = Integer.MAX_VALUE;
        this.f51422h = 64;
        this.f51423i = 67108864;
        this.f2552a = bArr;
        this.f51415a = i12 + i11;
        this.f51417c = i11;
        this.f2551a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m2428b() {
        return c();
    }

    public int c() {
        return d();
    }

    public int d() {
        int i11;
        byte a11 = a();
        if (a11 >= 0) {
            return a11;
        }
        byte b11 = a11 & Ascii.DEL;
        byte a12 = a();
        if (a12 >= 0) {
            i11 = a12 << 7;
        } else {
            b11 |= (a12 & Ascii.DEL) << 7;
            byte a13 = a();
            if (a13 >= 0) {
                i11 = a13 << 14;
            } else {
                b11 |= (a13 & Ascii.DEL) << 14;
                byte a14 = a();
                if (a14 >= 0) {
                    i11 = a14 << 21;
                } else {
                    byte b12 = b11 | ((a14 & Ascii.DEL) << 21);
                    byte a15 = a();
                    byte b13 = b12 | (a15 << 28);
                    if (a15 >= 0) {
                        return b13;
                    }
                    for (int i12 = 0; i12 < 5; i12++) {
                        if (a() >= 0) {
                            return b13;
                        }
                    }
                    throw d.c();
                }
            }
        }
        return b11 | i11;
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << Ascii.CAN);
    }

    public static b a(byte[] bArr, int i11, int i12) {
        return new b(bArr, i11, i12);
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m2427b() {
        return d();
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m2430c() {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte a11 = a();
            j11 |= ((long) (a11 & Ascii.DEL)) << i11;
            if ((a11 & 128) == 0) {
                return j11;
            }
        }
        throw d.c();
    }

    private void b() {
        int i11 = this.f51415a + this.f51416b;
        this.f51415a = i11;
        int i12 = this.f51419e + i11;
        int i13 = this.f51420f;
        if (i12 > i13) {
            int i14 = i12 - i13;
            this.f51416b = i14;
            this.f51415a = i11 - i14;
            return;
        }
        this.f51416b = 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m2418a() {
        if (b()) {
            this.f51418d = 0;
            return 0;
        }
        int d11 = d();
        this.f51418d = d11;
        if (d11 != 0) {
            return d11;
        }
        throw d.d();
    }

    public void c(int i11) {
        if (i11 >= 0) {
            int i12 = this.f51419e;
            int i13 = this.f51417c;
            int i14 = i12 + i13 + i11;
            int i15 = this.f51420f;
            if (i14 <= i15) {
                int i16 = this.f51415a;
                if (i11 <= i16 - i13) {
                    this.f51417c = i13 + i11;
                    return;
                }
                int i17 = i16 - i13;
                this.f51419e = i12 + i16;
                this.f51417c = 0;
                this.f51415a = 0;
                while (i17 < i11) {
                    InputStream inputStream = this.f2551a;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i11 - i17));
                    if (skip > 0) {
                        i17 += skip;
                        this.f51419e += skip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i15 - i12) - i13);
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2423a(int i11) {
        if (this.f51418d != i11) {
            throw d.e();
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m2431d() {
        byte a11 = a();
        byte a12 = a();
        return ((((long) a12) & 255) << 8) | (((long) a11) & 255) | ((((long) a()) & 255) << 16) | ((((long) a()) & 255) << 24) | ((((long) a()) & 255) << 32) | ((((long) a()) & 255) << 40) | ((((long) a()) & 255) << 48) | ((((long) a()) & 255) << 56);
    }

    private b(InputStream inputStream) {
        this.f51420f = Integer.MAX_VALUE;
        this.f51422h = 64;
        this.f51423i = 67108864;
        this.f2552a = new byte[4096];
        this.f51415a = 0;
        this.f51417c = 0;
        this.f2551a = inputStream;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2425a(int i11) {
        int a11 = f.a(i11);
        if (a11 == 0) {
            b();
            return true;
        } else if (a11 == 1) {
            d();
            return true;
        } else if (a11 == 2) {
            c(d());
            return true;
        } else if (a11 == 3) {
            a();
            a(f.a(f.b(i11), 4));
            return true;
        } else if (a11 == 4) {
            return false;
        } else {
            if (a11 == 5) {
                e();
                return true;
            }
            throw d.f();
        }
    }

    public void b(int i11) {
        this.f51420f = i11;
        b();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2429b() {
        return this.f51417c == this.f51415a && !a(false);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a  reason: collision with other method in class */
    public void m2422a() {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.a()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.a((int) r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.m2422a():void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2419a() {
        return c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2424a() {
        return d() != 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2421a() {
        int d11 = d();
        int i11 = this.f51415a;
        int i12 = this.f51417c;
        if (d11 > i11 - i12 || d11 <= 0) {
            return new String(a(d11), "UTF-8");
        }
        String str = new String(this.f2552a, i12, d11, "UTF-8");
        this.f51417c += d11;
        return str;
    }

    public void a(e eVar) {
        int d11 = d();
        if (this.f51421g < this.f51422h) {
            int a11 = a(d11);
            this.f51421g++;
            eVar.a(this);
            a(0);
            this.f51421g--;
            b(a11);
            return;
        }
        throw d.g();
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m2420a() {
        int d11 = d();
        int i11 = this.f51415a;
        int i12 = this.f51417c;
        if (d11 > i11 - i12 || d11 <= 0) {
            return a.a(a(d11));
        }
        a a11 = a.a(this.f2552a, i12, d11);
        this.f51417c += d11;
        return a11;
    }

    public int a(int i11) {
        if (i11 >= 0) {
            int i12 = i11 + this.f51419e + this.f51417c;
            int i13 = this.f51420f;
            if (i12 <= i13) {
                this.f51420f = i12;
                b();
                return i13;
            }
            throw d.a();
        }
        throw d.b();
    }

    private boolean a(boolean z11) {
        int i11 = this.f51417c;
        int i12 = this.f51415a;
        if (i11 >= i12) {
            int i13 = this.f51419e;
            if (i13 + i12 != this.f51420f) {
                this.f51419e = i13 + i12;
                this.f51417c = 0;
                InputStream inputStream = this.f2551a;
                int read = inputStream == null ? -1 : inputStream.read(this.f2552a);
                this.f51415a = read;
                if (read == 0 || read < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f51415a + "\nThe InputStream implementation is buggy.");
                } else if (read == -1) {
                    this.f51415a = 0;
                    if (!z11) {
                        return false;
                    }
                    throw d.a();
                } else {
                    b();
                    int i14 = this.f51419e + this.f51415a + this.f51416b;
                    if (i14 <= this.f51423i && i14 >= 0) {
                        return true;
                    }
                    throw d.h();
                }
            } else if (!z11) {
                return false;
            } else {
                throw d.a();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    public byte a() {
        if (this.f51417c == this.f51415a) {
            a(true);
        }
        byte[] bArr = this.f2552a;
        int i11 = this.f51417c;
        this.f51417c = i11 + 1;
        return bArr[i11];
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2426a(int i11) {
        int i12;
        if (i11 >= 0) {
            int i13 = this.f51419e;
            int i14 = this.f51417c;
            int i15 = i13 + i14 + i11;
            int i16 = this.f51420f;
            if (i15 <= i16) {
                int i17 = this.f51415a;
                if (i11 <= i17 - i14) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(this.f2552a, i14, bArr, 0, i11);
                    this.f51417c += i11;
                    return bArr;
                } else if (i11 < 4096) {
                    byte[] bArr2 = new byte[i11];
                    int i18 = i17 - i14;
                    System.arraycopy(this.f2552a, i14, bArr2, 0, i18);
                    this.f51417c = this.f51415a;
                    a(true);
                    while (true) {
                        int i19 = i11 - i18;
                        int i21 = this.f51415a;
                        if (i19 > i21) {
                            System.arraycopy(this.f2552a, 0, bArr2, i18, i21);
                            int i22 = this.f51415a;
                            i18 += i22;
                            this.f51417c = i22;
                            a(true);
                        } else {
                            System.arraycopy(this.f2552a, 0, bArr2, i18, i19);
                            this.f51417c = i19;
                            return bArr2;
                        }
                    }
                } else {
                    this.f51419e = i13 + i17;
                    this.f51417c = 0;
                    this.f51415a = 0;
                    int i23 = i17 - i14;
                    int i24 = i11 - i23;
                    Vector vector = new Vector();
                    while (i24 > 0) {
                        int min = Math.min(i24, 4096);
                        byte[] bArr3 = new byte[min];
                        int i25 = 0;
                        while (i25 < min) {
                            InputStream inputStream = this.f2551a;
                            if (inputStream == null) {
                                i12 = -1;
                            } else {
                                i12 = inputStream.read(bArr3, i25, min - i25);
                            }
                            if (i12 != -1) {
                                this.f51419e += i12;
                                i25 += i12;
                            } else {
                                throw d.a();
                            }
                        }
                        i24 -= min;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i11];
                    System.arraycopy(this.f2552a, i14, bArr4, 0, i23);
                    for (int i26 = 0; i26 < vector.size(); i26++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i26);
                        System.arraycopy(bArr5, 0, bArr4, i23, bArr5.length);
                        i23 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i16 - i13) - i14);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }
}
