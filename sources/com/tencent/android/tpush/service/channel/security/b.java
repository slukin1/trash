package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f69668a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f69669b = new int[128];

    /* renamed from: c  reason: collision with root package name */
    private int f69670c;

    /* renamed from: d  reason: collision with root package name */
    private int f69671d;

    static {
        for (int i11 = 0; i11 < 64; i11++) {
            f69669b[f69668a[i11]] = i11;
        }
    }

    public b(InputStream inputStream) {
        super(inputStream);
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable unused) {
        }
        b bVar = new b(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (((double) bArr.length) * 0.67d));
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = bVar.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    bVar.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public int read() {
        int read;
        do {
            read = this.in.read();
            if (read == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) read));
        int i11 = this.f69670c + 1;
        this.f69670c = i11;
        if (read == 61) {
            return -1;
        }
        int i12 = f69669b[read];
        int i13 = (i11 - 1) % 4;
        if (i13 == 0) {
            this.f69671d = i12 & 63;
            return read();
        } else if (i13 == 1) {
            int i14 = ((this.f69671d << 2) + (i12 >> 4)) & 255;
            this.f69671d = i12 & 15;
            return i14;
        } else if (i13 == 2) {
            int i15 = ((this.f69671d << 4) + (i12 >> 2)) & 255;
            this.f69671d = i12 & 3;
            return i15;
        } else if (i13 == 3) {
            return ((this.f69671d << 6) + i12) & 255;
        } else {
            return -1;
        }
    }

    public int read(byte[] bArr, int i11, int i12) {
        if (bArr.length >= (i12 + i11) - 1) {
            int i13 = 0;
            while (i13 < i12) {
                int read = read();
                if (read == -1 && i13 == 0) {
                    return -1;
                }
                if (read == -1) {
                    break;
                }
                bArr[i11 + i13] = (byte) read;
                i13++;
            }
            return i13;
        }
        throw new IOException("The input buffer is too small: " + i12 + " bytes requested starting at offset " + i11 + " while the buffer  is only " + bArr.length + " bytes long.");
    }
}
