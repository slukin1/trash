package p3;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class e {

    /* renamed from: f  reason: collision with root package name */
    public static final a f66550f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final a f66551a;

    /* renamed from: b  reason: collision with root package name */
    public final d f66552b;

    /* renamed from: c  reason: collision with root package name */
    public final b f66553c;

    /* renamed from: d  reason: collision with root package name */
    public final ContentResolver f66554d;

    /* renamed from: e  reason: collision with root package name */
    public final List<ImageHeaderParser> f66555e;

    public e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f66550f, dVar, bVar, contentResolver);
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f66554d.openInputStream(uri);
            int b11 = a.b(this.f66555e, openInputStream, this.f66553c);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return b11;
        } catch (IOException | NullPointerException e11) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e11);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002d A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            p3.d r2 = r6.f66552b     // Catch:{ SecurityException -> 0x0024, all -> 0x0022 }
            android.database.Cursor r2 = r2.a(r7)     // Catch:{ SecurityException -> 0x0024, all -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.moveToFirst()     // Catch:{ SecurityException -> 0x001a }
            if (r3 == 0) goto L_0x001c
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch:{ SecurityException -> 0x001a }
            r2.close()
            return r7
        L_0x001a:
            r3 = move-exception
            goto L_0x0026
        L_0x001c:
            if (r2 == 0) goto L_0x0021
            r2.close()
        L_0x0021:
            return r1
        L_0x0022:
            r7 = move-exception
            goto L_0x0049
        L_0x0024:
            r3 = move-exception
            r2 = r1
        L_0x0026:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x0041
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r4.<init>()     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch:{ all -> 0x0047 }
            r4.append(r7)     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0047 }
            android.util.Log.d(r0, r7, r3)     // Catch:{ all -> 0x0047 }
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()
        L_0x0046:
            return r1
        L_0x0047:
            r7 = move-exception
            r1 = r2
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()
        L_0x004e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.e.b(android.net.Uri):java.lang.String");
    }

    public final boolean c(File file) {
        return this.f66551a.a(file) && 0 < this.f66551a.c(file);
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b11 = b(uri);
        if (TextUtils.isEmpty(b11)) {
            return null;
        }
        File b12 = this.f66551a.b(b11);
        if (!c(b12)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b12);
        try {
            return this.f66554d.openInputStream(fromFile);
        } catch (NullPointerException e11) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e11));
        }
    }

    public e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f66551a = aVar;
        this.f66552b = dVar;
        this.f66553c = bVar;
        this.f66554d = contentResolver;
        this.f66555e = list;
    }
}
