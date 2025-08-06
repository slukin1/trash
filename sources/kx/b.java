package kx;

import android.graphics.Bitmap;
import ix.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kx.a;
import vx.b;
import vx.c;

public class b implements a {

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.CompressFormat f29126g = Bitmap.CompressFormat.PNG;

    /* renamed from: a  reason: collision with root package name */
    public a f29127a;

    /* renamed from: b  reason: collision with root package name */
    public File f29128b;

    /* renamed from: c  reason: collision with root package name */
    public final lx.a f29129c;

    /* renamed from: d  reason: collision with root package name */
    public int f29130d = 32768;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap.CompressFormat f29131e = f29126g;

    /* renamed from: f  reason: collision with root package name */
    public int f29132f = 100;

    public b(File file, File file2, lx.a aVar, long j11, int i11) throws IOException {
        if (file != null) {
            int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i12 < 0) {
                throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
            } else if (i11 < 0) {
                throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
            } else if (aVar != null) {
                long j12 = i12 == 0 ? Long.MAX_VALUE : j11;
                i11 = i11 == 0 ? Integer.MAX_VALUE : i11;
                this.f29128b = file2;
                this.f29129c = aVar;
                d(file, file2, j12, i11);
            } else {
                throw new IllegalArgumentException("fileNameGenerator argument must be not null");
            }
        } else {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
    }

    public boolean a(String str, InputStream inputStream, b.a aVar) throws IOException {
        a.c t11 = this.f29127a.t(c(str));
        if (t11 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(t11.f(0), this.f29130d);
        try {
            boolean b11 = vx.b.b(inputStream, bufferedOutputStream, aVar, this.f29130d);
            vx.b.a(bufferedOutputStream);
            if (b11) {
                t11.e();
            } else {
                t11.a();
            }
            return b11;
        } catch (Throwable th2) {
            vx.b.a(bufferedOutputStream);
            t11.a();
            throw th2;
        }
    }

    public boolean b(String str, Bitmap bitmap) throws IOException {
        a.c t11 = this.f29127a.t(c(str));
        if (t11 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(t11.f(0), this.f29130d);
        try {
            boolean compress = bitmap.compress(this.f29131e, this.f29132f, bufferedOutputStream);
            if (compress) {
                t11.e();
            } else {
                t11.a();
            }
            return compress;
        } finally {
            vx.b.a(bufferedOutputStream);
        }
    }

    public final String c(String str) {
        return this.f29129c.a(str);
    }

    public final void d(File file, File file2, long j11, int i11) throws IOException {
        try {
            this.f29127a = a.x(file, 1, 1, j11, i11);
        } catch (IOException e11) {
            c.c(e11);
            if (file2 != null) {
                d(file2, (File) null, j11, i11);
            }
            if (this.f29127a == null) {
                throw e11;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            kx.a r1 = r3.f29127a     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            java.lang.String r4 = r3.c(r4)     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            kx.a$e r4 = r1.v(r4)     // Catch:{ IOException -> 0x0020, all -> 0x001b }
            if (r4 != 0) goto L_0x000e
            goto L_0x0013
        L_0x000e:
            r1 = 0
            java.io.File r0 = r4.a(r1)     // Catch:{ IOException -> 0x0019 }
        L_0x0013:
            if (r4 == 0) goto L_0x0018
            r4.close()
        L_0x0018:
            return r0
        L_0x0019:
            r1 = move-exception
            goto L_0x0022
        L_0x001b:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x002c
        L_0x0020:
            r1 = move-exception
            r4 = r0
        L_0x0022:
            vx.c.c(r1)     // Catch:{ all -> 0x002b }
            if (r4 == 0) goto L_0x002a
            r4.close()
        L_0x002a:
            return r0
        L_0x002b:
            r0 = move-exception
        L_0x002c:
            if (r4 == 0) goto L_0x0031
            r4.close()
        L_0x0031:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.b.get(java.lang.String):java.io.File");
    }
}
