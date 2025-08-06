package com.tencent.liteav.videoconsumer.decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public a f22381a = new a();

    /* renamed from: b  reason: collision with root package name */
    public int f22382b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f22383c;

    /* renamed from: d  reason: collision with root package name */
    private int f22384d;

    /* renamed from: e  reason: collision with root package name */
    private int f22385e;

    /* renamed from: f  reason: collision with root package name */
    private final OutputStream f22386f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f22387g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private int f22388h;

    public c(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.f22383c = inputStream;
        this.f22386f = outputStream;
        this.f22384d = inputStream.read();
        this.f22385e = inputStream.read();
    }

    private int c(boolean z11) throws IOException {
        if (this.f22382b == 8) {
            f();
            if (this.f22384d == -1) {
                return -1;
            }
        }
        int i11 = this.f22384d;
        int i12 = this.f22382b;
        int i13 = (i11 >> (7 - i12)) & 1;
        this.f22382b = i12 + 1;
        if (z11 && this.f22386f != null) {
            f(i13);
        }
        return i13;
    }

    private long e(int i11) throws IOException {
        if (i11 <= 64) {
            long j11 = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                j11 = (j11 << 1) | ((long) c(true));
            }
            return j11;
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    private void f() throws IOException {
        this.f22384d = this.f22385e;
        this.f22385e = this.f22383c.read();
        this.f22382b = 0;
    }

    private int g() throws IOException {
        int i11 = 0;
        while (c(true) == 0) {
            i11++;
        }
        if (i11 <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i11) - 1)) + e(i11));
    }

    private void h() throws IOException {
        int[] iArr = this.f22387g;
        this.f22386f.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    public final boolean a(boolean z11) throws IOException {
        return c(z11) == 1;
    }

    public final void b(int i11) throws IOException {
        a(i11);
    }

    public final void d() throws IOException {
        int i11 = 0;
        while (c(true) == 0) {
            i11++;
        }
        if (i11 > 0) {
            a(i11);
        }
    }

    public final long a() throws IOException {
        long e11 = e(8);
        String.valueOf(e11);
        return e11;
    }

    public final int b() throws IOException {
        int i11 = 0;
        while (c(false) == 0) {
            i11++;
        }
        if (i11 <= 0) {
            return 0;
        }
        if (i11 <= 64) {
            long j11 = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                j11 = (j11 << 1) | ((long) c(false));
            }
            return (int) (((long) ((1 << i11) - 1)) + j11);
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    public final void d(int i11) throws IOException {
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= 15) {
                break;
            }
            int i15 = (1 << i13) + i14;
            if (i11 < i15) {
                i12 = i13;
                break;
            } else {
                i13++;
                i14 = i15;
            }
        }
        a(0, i12);
        f(1);
        a((long) (i11 - i14), i12);
    }

    public final void e() throws IOException {
        f(1);
        a(0, 8 - this.f22388h);
        for (int i11 = this.f22388h; i11 < 8; i11++) {
            this.f22387g[i11] = 0;
        }
        this.f22388h = 0;
        h();
    }

    private void f(int i11) throws IOException {
        if (this.f22388h == 8) {
            this.f22388h = 0;
            h();
        }
        int[] iArr = this.f22387g;
        int i12 = this.f22388h;
        this.f22388h = i12 + 1;
        iArr[i12] = i11;
    }

    public final void a(int i11) throws IOException {
        if (i11 <= 64) {
            for (int i12 = 0; i12 < i11; i12++) {
                c(true);
            }
            return;
        }
        throw new IllegalArgumentException("Can not skip more then 64 bit");
    }

    public final void b(boolean z11) throws IOException {
        f(z11 ? 1 : 0);
    }

    private void a(long j11, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            f(((int) (j11 >> ((i11 - i12) - 1))) & 1);
        }
    }

    public final int c() throws IOException {
        int g11 = g();
        String.valueOf(g11);
        return g11;
    }

    public final void c(int i11) throws IOException {
        int[] iArr = new int[i11];
        int i12 = 8;
        int i13 = 8;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != 0) {
                int g11 = g();
                int i15 = g11 & 1;
                int i16 = ((g11 >> 1) + i15) * ((i15 << 1) - 1);
                String.valueOf(i16);
                i12 = ((i16 + i13) + 256) % 256;
            }
            if (i12 != 0) {
                i13 = i12;
            }
            iArr[i14] = i13;
            i13 = iArr[i14];
        }
    }
}
