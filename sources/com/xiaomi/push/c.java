package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f51475a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f2588a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f2589a;

    /* renamed from: b  reason: collision with root package name */
    private int f51476b;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(byte[] bArr, int i11, int i12) {
        this.f2588a = null;
        this.f2589a = bArr;
        this.f51476b = i11;
        this.f51475a = i11 + i12;
    }

    public static int a(boolean z11) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static int c(long j11) {
        if ((-128 & j11) == 0) {
            return 1;
        }
        if ((-16384 & j11) == 0) {
            return 2;
        }
        if ((-2097152 & j11) == 0) {
            return 3;
        }
        if ((-268435456 & j11) == 0) {
            return 4;
        }
        if ((-34359738368L & j11) == 0) {
            return 5;
        }
        if ((-4398046511104L & j11) == 0) {
            return 6;
        }
        if ((-562949953421312L & j11) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j11) == 0) {
            return 8;
        }
        return (j11 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() {
        OutputStream outputStream = this.f2588a;
        if (outputStream != null) {
            outputStream.write(this.f2589a, 0, this.f51476b);
            this.f51476b = 0;
            return;
        }
        throw new a();
    }

    public static int d(int i11) {
        if ((i11 & -128) == 0) {
            return 1;
        }
        if ((i11 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i11) == 0) {
            return 3;
        }
        return (i11 & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2467b(int i11, long j11) {
        c(i11, 0);
        b(j11);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m2471d(int i11) {
        while ((i11 & -128) != 0) {
            c((i11 & 127) | 128);
            i11 >>>= 7;
        }
        c(i11);
    }

    public static c a(OutputStream outputStream, int i11) {
        return new c(outputStream, new byte[i11]);
    }

    public static c a(byte[] bArr, int i11, int i12) {
        return new c(bArr, i11, i12);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2466b(int i11, int i12) {
        c(i11, 0);
        b(i12);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2454a(int i11, long j11) {
        c(i11, 0);
        a(j11);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2468b(long j11) {
        c(j11);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m2469c(int i11) {
        a((byte) i11);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f2588a = outputStream;
        this.f2589a = bArr;
        this.f51476b = 0;
        this.f51475a = bArr.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2453a(int i11, int i12) {
        c(i11, 0);
        a(i12);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2465b(int i11) {
        d(i11);
    }

    public void c(int i11, int i12) {
        d(f.a(i11, i12));
    }

    public static int b(int i11, long j11) {
        return c(i11) + b(j11);
    }

    public static int c(int i11) {
        return d(f.a(i11, 0));
    }

    public static int b(int i11, int i12) {
        return c(i11) + b(i12);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2458a(int i11, boolean z11) {
        c(i11, 0);
        a(z11);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m2470c(long j11) {
        while ((-128 & j11) != 0) {
            c((((int) j11) & 127) | 128);
            j11 >>>= 7;
        }
        c((int) j11);
    }

    public static int b(long j11) {
        return c(j11);
    }

    public static int b(int i11) {
        return d(i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2457a(int i11, String str) {
        c(i11, 2);
        a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2456a(int i11, e eVar) {
        c(i11, 2);
        a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2455a(int i11, a aVar) {
        c(i11, 2);
        a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2459a(long j11) {
        c(j11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2452a(int i11) {
        if (i11 >= 0) {
            d(i11);
        } else {
            c((long) i11);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2463a(boolean z11) {
        c(z11 ? 1 : 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2462a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2461a(e eVar) {
        d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2460a(a aVar) {
        byte[] a11 = aVar.a();
        d(a11.length);
        a(a11);
    }

    public static int a(int i11, long j11) {
        return c(i11) + a(j11);
    }

    public static int a(int i11, int i12) {
        return c(i11) + a(i12);
    }

    public static int a(int i11, boolean z11) {
        return c(i11) + a(z11);
    }

    public static int a(int i11, String str) {
        return c(i11) + a(str);
    }

    public static int a(int i11, e eVar) {
        return c(i11) + a(eVar);
    }

    public static int a(int i11, a aVar) {
        return c(i11) + a(aVar);
    }

    public static int a(long j11) {
        return c(j11);
    }

    public static int a(int i11) {
        if (i11 >= 0) {
            return d(i11);
        }
        return 10;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int b11 = eVar.b();
        return d(b11) + b11;
    }

    public static int a(a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2451a() {
        if (this.f2588a != null) {
            c();
        }
    }

    public int a() {
        if (this.f2588a == null) {
            return this.f51475a - this.f51476b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b11) {
        if (this.f51476b == this.f51475a) {
            c();
        }
        byte[] bArr = this.f2589a;
        int i11 = this.f51476b;
        this.f51476b = i11 + 1;
        bArr[i11] = b11;
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2464a(byte[] bArr, int i11, int i12) {
        int i13 = this.f51475a;
        int i14 = this.f51476b;
        if (i13 - i14 >= i12) {
            System.arraycopy(bArr, i11, this.f2589a, i14, i12);
            this.f51476b += i12;
            return;
        }
        int i15 = i13 - i14;
        System.arraycopy(bArr, i11, this.f2589a, i14, i15);
        int i16 = i11 + i15;
        int i17 = i12 - i15;
        this.f51476b = this.f51475a;
        c();
        if (i17 <= this.f51475a) {
            System.arraycopy(bArr, i16, this.f2589a, 0, i17);
            this.f51476b = i17;
            return;
        }
        this.f2588a.write(bArr, i16, i17);
    }
}
