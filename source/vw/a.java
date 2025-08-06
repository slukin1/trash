package vw;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f26273e = c("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /* renamed from: f  reason: collision with root package name */
    public static final Random f26274f = new Random();

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f26275a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f26276b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26277c = a("multipart/form-data");

    /* renamed from: d  reason: collision with root package name */
    public final long f26278d;

    public a(List<b> list) {
        this.f26275a = list;
        byte[] b11 = b();
        this.f26276b = b11;
        this.f26278d = b.e(list, b11);
    }

    public static byte[] b() {
        int nextInt = f26274f.nextInt(11) + 30;
        byte[] bArr = new byte[nextInt];
        for (int i11 = 0; i11 < nextInt; i11++) {
            byte[] bArr2 = f26273e;
            bArr[i11] = bArr2[f26274f.nextInt(bArr2.length)];
        }
        return bArr;
    }

    public static byte[] c(String str) {
        if (str != null) {
            try {
                return str.getBytes(C.ASCII_NAME);
            } catch (UnsupportedEncodingException e11) {
                throw new RuntimeException(e11);
            }
        } else {
            throw new IllegalArgumentException("data may not be null");
        }
    }

    public final String a(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (!str.endsWith(";")) {
            sb2.append(";");
        }
        try {
            sb2.append(" boundary=");
            sb2.append(new String(this.f26276b, C.ASCII_NAME));
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public long d() {
        return this.f26278d;
    }

    public String e() {
        return this.f26277c;
    }

    public void f(OutputStream outputStream) throws IOException {
        b.m(outputStream, this.f26275a, this.f26276b);
    }
}
