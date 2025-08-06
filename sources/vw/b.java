package vw;

import com.jumio.commons.log.LogUtils;
import com.kakao.util.helper.log.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f26279e = a.c(LogUtils.NEW_LINE);

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f26280f = a.c("\"");

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f26281g = a.c("--");

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f26282h = a.c("; charset=");

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f26283i = a.c("Content-Type: ");

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f26284j = a.c("Content-Disposition: form-data; name=");

    /* renamed from: k  reason: collision with root package name */
    public static final byte[] f26285k = a.c("Content-Transfer-Encoding: ");

    /* renamed from: a  reason: collision with root package name */
    public final String f26286a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26287b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26288c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26289d;

    public static long e(List<b> list, byte[] bArr) {
        if (list != null) {
            try {
                long j11 = 0;
                for (b f11 : list) {
                    long f12 = f11.f(bArr);
                    if (f12 < 0) {
                        return -1;
                    }
                    j11 += f12;
                }
                byte[] bArr2 = f26281g;
                return j11 + ((long) bArr2.length) + ((long) bArr.length) + ((long) bArr2.length) + ((long) f26279e.length);
            } catch (Exception e11) {
                a.f("An exception occurred while getting the length of the parts", e11);
                return 0;
            }
        } else {
            throw new IllegalArgumentException("Parts may not be null");
        }
    }

    public static void m(OutputStream outputStream, List<b> list, byte[] bArr) throws IOException {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Parts may not be null or empty");
        } else if (bArr == null || bArr.length <= 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        } else {
            for (b next : list) {
                next.n(outputStream, bArr);
                next.j(outputStream);
                next.h(outputStream);
                next.o(outputStream);
                next.l(outputStream);
                next.i(outputStream);
                next.k(outputStream);
            }
            byte[] bArr2 = f26281g;
            outputStream.write(bArr2);
            outputStream.write(bArr);
            outputStream.write(bArr2);
            outputStream.write(f26279e);
        }
    }

    public long a() {
        String str = this.f26287b;
        if (str == null) {
            return 0;
        }
        long length = ((long) f26279e.length) + 0 + ((long) f26283i.length) + ((long) a.c(str).length);
        String str2 = this.f26288c;
        return str2 != null ? length + ((long) f26282h.length) + ((long) a.c(str2).length) : length;
    }

    public long b() {
        String str = this.f26286a;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        long length = ((long) f26279e.length) + 0 + ((long) f26284j.length);
        byte[] bArr = f26280f;
        return length + ((long) bArr.length) + ((long) a.c(str).length) + ((long) bArr.length);
    }

    public long c() {
        return (long) f26279e.length;
    }

    public long d() {
        return (long) (f26279e.length * 2);
    }

    public long f(byte[] bArr) {
        long g11 = g();
        if (g11 < 0) {
            return -1;
        }
        return g11 + ((long) p(bArr)) + b() + a() + q() + d() + c();
    }

    public abstract long g();

    public void h(OutputStream outputStream) throws IOException {
        String str = this.f26287b;
        if (str != null) {
            outputStream.write(f26279e);
            outputStream.write(f26283i);
            outputStream.write(a.c(str));
            String str2 = this.f26288c;
            if (str2 != null) {
                outputStream.write(f26282h);
                outputStream.write(a.c(str2));
            }
        }
    }

    public abstract void i(OutputStream outputStream) throws IOException;

    public void j(OutputStream outputStream) throws IOException {
        String str = this.f26286a;
        if (str != null) {
            outputStream.write(f26279e);
            outputStream.write(f26284j);
            byte[] bArr = f26280f;
            outputStream.write(bArr);
            outputStream.write(a.c(str));
            outputStream.write(bArr);
        }
    }

    public void k(OutputStream outputStream) throws IOException {
        outputStream.write(f26279e);
    }

    public void l(OutputStream outputStream) throws IOException {
        byte[] bArr = f26279e;
        outputStream.write(bArr);
        outputStream.write(bArr);
    }

    public void n(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f26281g);
        outputStream.write(bArr);
    }

    public void o(OutputStream outputStream) throws IOException {
        String str = this.f26289d;
        if (str != null) {
            outputStream.write(f26279e);
            outputStream.write(f26285k);
            outputStream.write(a.c(str));
        }
    }

    public int p(byte[] bArr) {
        return f26281g.length + bArr.length;
    }

    public long q() {
        String str = this.f26289d;
        if (str != null) {
            return ((long) f26279e.length) + 0 + ((long) f26285k.length) + ((long) a.c(str).length);
        }
        return 0;
    }
}
