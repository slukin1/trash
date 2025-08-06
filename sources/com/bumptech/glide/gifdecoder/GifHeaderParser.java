package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import l3.b;

public class GifHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f63650a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f63651b;

    /* renamed from: c  reason: collision with root package name */
    public GifHeader f63652c;

    /* renamed from: d  reason: collision with root package name */
    public int f63653d = 0;

    public void a() {
        this.f63651b = null;
        this.f63652c = null;
    }

    public final boolean b() {
        return this.f63652c.f63638b != 0;
    }

    public GifHeader c() {
        if (this.f63651b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f63652c;
        } else {
            k();
            if (!b()) {
                h();
                GifHeader gifHeader = this.f63652c;
                if (gifHeader.f63639c < 0) {
                    gifHeader.f63638b = 1;
                }
            }
            return this.f63652c;
        }
    }

    public final int d() {
        try {
            return this.f63651b.get() & 255;
        } catch (Exception unused) {
            this.f63652c.f63638b = 1;
            return 0;
        }
    }

    public final void e() {
        this.f63652c.f63640d.f66468a = n();
        this.f63652c.f63640d.f66469b = n();
        this.f63652c.f63640d.f66470c = n();
        this.f63652c.f63640d.f66471d = n();
        int d11 = d();
        boolean z11 = false;
        boolean z12 = (d11 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((d11 & 7) + 1));
        b bVar = this.f63652c.f63640d;
        if ((d11 & 64) != 0) {
            z11 = true;
        }
        bVar.f66472e = z11;
        if (z12) {
            bVar.f66478k = g(pow);
        } else {
            bVar.f66478k = null;
        }
        this.f63652c.f63640d.f66477j = this.f63651b.position();
        r();
        if (!b()) {
            GifHeader gifHeader = this.f63652c;
            gifHeader.f63639c++;
            gifHeader.f63641e.add(gifHeader.f63640d);
        }
    }

    public final void f() {
        int d11 = d();
        this.f63653d = d11;
        if (d11 > 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                try {
                    int i13 = this.f63653d;
                    if (i11 < i13) {
                        i12 = i13 - i11;
                        this.f63651b.get(this.f63650a, i11, i12);
                        i11 += i12;
                    } else {
                        return;
                    }
                } catch (Exception e11) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i11 + " count: " + i12 + " blockSize: " + this.f63653d, e11);
                    }
                    this.f63652c.f63638b = 1;
                    return;
                }
            }
        }
    }

    public final int[] g(int i11) {
        byte[] bArr = new byte[(i11 * 3)];
        int[] iArr = null;
        try {
            this.f63651b.get(bArr);
            iArr = new int[256];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11) {
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i15 + 1;
                int i17 = i12 + 1;
                iArr[i12] = ((bArr[i13] & 255) << 16) | -16777216 | ((bArr[i14] & 255) << 8) | (bArr[i15] & 255);
                i13 = i16;
                i12 = i17;
            }
        } catch (BufferUnderflowException e11) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e11);
            }
            this.f63652c.f63638b = 1;
        }
        return iArr;
    }

    public final void h() {
        i(Integer.MAX_VALUE);
    }

    public final void i(int i11) {
        boolean z11 = false;
        while (!z11 && !b() && this.f63652c.f63639c <= i11) {
            int d11 = d();
            if (d11 == 33) {
                int d12 = d();
                if (d12 == 1) {
                    q();
                } else if (d12 == 249) {
                    this.f63652c.f63640d = new b();
                    j();
                } else if (d12 == 254) {
                    q();
                } else if (d12 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i12 = 0; i12 < 11; i12++) {
                        sb2.append((char) this.f63650a[i12]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d11 == 44) {
                GifHeader gifHeader = this.f63652c;
                if (gifHeader.f63640d == null) {
                    gifHeader.f63640d = new b();
                }
                e();
            } else if (d11 != 59) {
                this.f63652c.f63638b = 1;
            } else {
                z11 = true;
            }
        }
    }

    public final void j() {
        d();
        int d11 = d();
        b bVar = this.f63652c.f63640d;
        int i11 = (d11 & 28) >> 2;
        bVar.f66474g = i11;
        boolean z11 = true;
        if (i11 == 0) {
            bVar.f66474g = 1;
        }
        if ((d11 & 1) == 0) {
            z11 = false;
        }
        bVar.f66473f = z11;
        int n11 = n();
        if (n11 < 2) {
            n11 = 10;
        }
        b bVar2 = this.f63652c.f63640d;
        bVar2.f66476i = n11 * 10;
        bVar2.f66475h = d();
        d();
    }

    public final void k() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < 6; i11++) {
            sb2.append((char) d());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f63652c.f63638b = 1;
            return;
        }
        l();
        if (this.f63652c.f63644h && !b()) {
            GifHeader gifHeader = this.f63652c;
            gifHeader.f63637a = g(gifHeader.f63645i);
            GifHeader gifHeader2 = this.f63652c;
            gifHeader2.f63648l = gifHeader2.f63637a[gifHeader2.f63646j];
        }
    }

    public final void l() {
        this.f63652c.f63642f = n();
        this.f63652c.f63643g = n();
        int d11 = d();
        GifHeader gifHeader = this.f63652c;
        gifHeader.f63644h = (d11 & 128) != 0;
        gifHeader.f63645i = (int) Math.pow(2.0d, (double) ((d11 & 7) + 1));
        this.f63652c.f63646j = d();
        this.f63652c.f63647k = d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r3 = this;
        L_0x0000:
            r3.f()
            byte[] r0 = r3.f63650a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.f63652c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f63649m = r0
        L_0x001b:
            int r0 = r3.f63653d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.m():void");
    }

    public final int n() {
        return this.f63651b.getShort();
    }

    public final void o() {
        this.f63651b = null;
        Arrays.fill(this.f63650a, (byte) 0);
        this.f63652c = new GifHeader();
        this.f63653d = 0;
    }

    public GifHeaderParser p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f63651b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f63651b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void q() {
        int d11;
        do {
            d11 = d();
            this.f63651b.position(Math.min(this.f63651b.position() + d11, this.f63651b.limit()));
        } while (d11 > 0);
    }

    public final void r() {
        d();
        q();
    }
}
