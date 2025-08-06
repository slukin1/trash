package nx;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import mx.a;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<String, Bitmap> f29158a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29159b;

    /* renamed from: c  reason: collision with root package name */
    public int f29160c;

    public b(int i11) {
        if (i11 > 0) {
            this.f29159b = i11;
            this.f29158a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final boolean a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f29160c += b(str, bitmap);
            Bitmap bitmap2 = (Bitmap) this.f29158a.put(str, bitmap);
            if (bitmap2 != null) {
                this.f29160c -= b(str, bitmap2);
            }
        }
        c(this.f29159b);
        return true;
    }

    public final int b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r4) {
        /*
            r3 = this;
        L_0x0000:
            monitor-enter(r3)
            int r0 = r3.f29160c     // Catch:{ all -> 0x006f }
            if (r0 < 0) goto L_0x0050
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f29158a     // Catch:{ all -> 0x006f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0011
            int r0 = r3.f29160c     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0050
        L_0x0011:
            int r0 = r3.f29160c     // Catch:{ all -> 0x006f }
            if (r0 <= r4) goto L_0x004e
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f29158a     // Catch:{ all -> 0x006f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x001e
            goto L_0x004e
        L_0x001e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f29158a     // Catch:{ all -> 0x006f }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x006f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x006f }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x006f }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0032
            monitor-exit(r3)     // Catch:{ all -> 0x006f }
            goto L_0x004f
        L_0x0032:
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x006f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x006f }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x006f }
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch:{ all -> 0x006f }
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f29158a     // Catch:{ all -> 0x006f }
            r2.remove(r1)     // Catch:{ all -> 0x006f }
            int r2 = r3.f29160c     // Catch:{ all -> 0x006f }
            int r0 = r3.b(r1, r0)     // Catch:{ all -> 0x006f }
            int r2 = r2 - r0
            r3.f29160c = r2     // Catch:{ all -> 0x006f }
            monitor-exit(r3)     // Catch:{ all -> 0x006f }
            goto L_0x0000
        L_0x004e:
            monitor-exit(r3)     // Catch:{ all -> 0x006f }
        L_0x004f:
            return
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r0.<init>()     // Catch:{ all -> 0x006f }
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x006f }
            r0.append(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006f }
            r4.<init>(r0)     // Catch:{ all -> 0x006f }
            throw r4     // Catch:{ all -> 0x006f }
        L_0x006f:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x006f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: nx.b.c(int):void");
    }

    public final Bitmap get(String str) {
        Bitmap bitmap;
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            bitmap = this.f29158a.get(str);
        }
        return bitmap;
    }

    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f29158a.keySet());
        }
        return hashSet;
    }

    public final Bitmap remove(String str) {
        Bitmap bitmap;
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            bitmap = (Bitmap) this.f29158a.remove(str);
            if (bitmap != null) {
                this.f29160c -= b(str, bitmap);
            }
        }
        return bitmap;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", new Object[]{Integer.valueOf(this.f29159b)});
    }
}
