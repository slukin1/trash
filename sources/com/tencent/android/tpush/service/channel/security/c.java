package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class c extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f69672a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private int f69673b;

    /* renamed from: c  reason: collision with root package name */
    private int f69674c;

    public c(OutputStream outputStream) {
        super(outputStream);
    }

    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (((double) bArr.length) * 1.37d));
        c cVar = new c(byteArrayOutputStream);
        try {
            cVar.write(bArr);
            cVar.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toString("UTF-8");
        } catch (IOException unused) {
            return null;
        }
    }

    public void close() {
        int i11 = this.f69673b;
        if (i11 % 3 == 1) {
            this.out.write(f69672a[(this.f69674c << 4) & 63]);
            this.out.write(61);
            this.out.write(61);
        } else if (i11 % 3 == 2) {
            this.out.write(f69672a[(this.f69674c << 2) & 63]);
            this.out.write(61);
        }
        super.close();
    }

    public void write(int i11) {
        if (i11 < 0) {
            i11 += 256;
        }
        int i12 = this.f69673b;
        if (i12 % 3 == 0) {
            this.f69674c = i11 & 3;
            this.out.write(f69672a[i11 >> 2]);
        } else if (i12 % 3 == 1) {
            this.f69674c = i11 & 15;
            this.out.write(f69672a[((this.f69674c << 4) + (i11 >> 4)) & 63]);
        } else if (i12 % 3 == 2) {
            OutputStream outputStream = this.out;
            char[] cArr = f69672a;
            outputStream.write(cArr[((this.f69674c << 2) + (i11 >> 6)) & 63]);
            this.out.write(cArr[i11 & 63]);
            this.f69674c = 0;
        }
        int i13 = this.f69673b + 1;
        this.f69673b = i13;
        if (i13 % 57 == 0) {
            this.out.write(10);
        }
    }

    public void write(byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            write(bArr[i11 + i13]);
        }
    }
}
