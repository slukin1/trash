package jx;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import vx.b;

public abstract class a implements ix.a {

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.CompressFormat f29074g = Bitmap.CompressFormat.PNG;

    /* renamed from: a  reason: collision with root package name */
    public final File f29075a;

    /* renamed from: b  reason: collision with root package name */
    public final File f29076b;

    /* renamed from: c  reason: collision with root package name */
    public final lx.a f29077c;

    /* renamed from: d  reason: collision with root package name */
    public int f29078d = 32768;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap.CompressFormat f29079e = f29074g;

    /* renamed from: f  reason: collision with root package name */
    public int f29080f = 100;

    public a(File file, File file2, lx.a aVar) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (aVar != null) {
            this.f29075a = file;
            this.f29076b = file2;
            this.f29077c = aVar;
        } else {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r6, java.io.InputStream r7, vx.b.a r8) throws java.io.IOException {
        /*
            r5 = this;
            java.io.File r6 = r5.c(r6)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r6.getAbsolutePath()
            r1.append(r2)
            java.lang.String r2 = ".tmp"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x004b }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x004b }
            r3.<init>(r0)     // Catch:{ all -> 0x004b }
            int r4 = r5.f29078d     // Catch:{ all -> 0x004b }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x004b }
            int r3 = r5.f29078d     // Catch:{ all -> 0x0046 }
            boolean r7 = vx.b.b(r7, r2, r8, r3)     // Catch:{ all -> 0x0046 }
            vx.b.a(r2)     // Catch:{ all -> 0x0044 }
            if (r7 == 0) goto L_0x003d
            boolean r6 = r0.renameTo(r6)
            if (r6 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = r7
        L_0x003e:
            if (r1 != 0) goto L_0x0043
            r0.delete()
        L_0x0043:
            return r1
        L_0x0044:
            r8 = move-exception
            goto L_0x004d
        L_0x0046:
            r7 = move-exception
            vx.b.a(r2)     // Catch:{ all -> 0x004b }
            throw r7     // Catch:{ all -> 0x004b }
        L_0x004b:
            r8 = move-exception
            r7 = r1
        L_0x004d:
            if (r7 == 0) goto L_0x0056
            boolean r6 = r0.renameTo(r6)
            if (r6 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r1 = r7
        L_0x0057:
            if (r1 != 0) goto L_0x005c
            r0.delete()
        L_0x005c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: jx.a.a(java.lang.String, java.io.InputStream, vx.b$a):boolean");
    }

    public boolean b(String str, Bitmap bitmap) throws IOException {
        File c11 = c(str);
        File file = new File(c11.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f29078d);
        try {
            boolean compress = bitmap.compress(this.f29079e, this.f29080f, bufferedOutputStream);
            b.a(bufferedOutputStream);
            if (compress && !file.renameTo(c11)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th2) {
            b.a(bufferedOutputStream);
            file.delete();
            throw th2;
        }
    }

    public File c(String str) {
        File file;
        String a11 = this.f29077c.a(str);
        File file2 = this.f29075a;
        if (!file2.exists() && !this.f29075a.mkdirs() && (file = this.f29076b) != null && (file.exists() || this.f29076b.mkdirs())) {
            file2 = this.f29076b;
        }
        return new File(file2, a11);
    }

    public File get(String str) {
        return c(str);
    }
}
