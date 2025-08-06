package com.squareup.wire;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSink f30202a;

    public d(BufferedSink bufferedSink) {
        this.f30202a = bufferedSink;
    }

    public static int a(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long b(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static int c(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    public static long d(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int e(int i11) {
        if (i11 >= 0) {
            return i(i11);
        }
        return 10;
    }

    public static int f(int i11, FieldEncoding fieldEncoding) {
        return (i11 << 3) | fieldEncoding.value;
    }

    public static int g(int i11) {
        return i(f(i11, FieldEncoding.VARINT));
    }

    public static int h(String str) {
        int i11;
        int length = str.length();
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            char charAt = str.charAt(i12);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i13 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i13 += 3;
                } else if (charAt <= 56319 && (i11 = i12 + 1) < length && str.charAt(i11) >= 56320 && str.charAt(i11) <= 57343) {
                    i13 += 4;
                    i12 = i11;
                }
                i12++;
            }
            i13++;
            i12++;
        }
        return i13;
    }

    public static int i(int i11) {
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

    public static int j(long j11) {
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

    public void k(ByteString byteString) throws IOException {
        this.f30202a.write(byteString);
    }

    public void l(int i11) throws IOException {
        this.f30202a.writeIntLe(i11);
    }

    public void m(long j11) throws IOException {
        this.f30202a.writeLongLe(j11);
    }

    public void n(int i11) throws IOException {
        if (i11 >= 0) {
            q(i11);
        } else {
            r((long) i11);
        }
    }

    public void o(String str) throws IOException {
        this.f30202a.writeUtf8(str);
    }

    public void p(int i11, FieldEncoding fieldEncoding) throws IOException {
        q(f(i11, fieldEncoding));
    }

    public void q(int i11) throws IOException {
        while ((i11 & -128) != 0) {
            this.f30202a.writeByte((i11 & 127) | 128);
            i11 >>>= 7;
        }
        this.f30202a.writeByte(i11);
    }

    public void r(long j11) throws IOException {
        while ((-128 & j11) != 0) {
            this.f30202a.writeByte((((int) j11) & 127) | 128);
            j11 >>>= 7;
        }
        this.f30202a.writeByte((int) j11);
    }
}
