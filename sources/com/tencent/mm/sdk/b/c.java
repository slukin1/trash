package com.tencent.mm.sdk.b;

import java.util.LinkedHashMap;
import java.util.Objects;

public final class c<K, V> {
    private int A;
    private int B;
    private int C;
    private int D;
    private int size;

    /* renamed from: u  reason: collision with root package name */
    private final LinkedHashMap<K, V> f22735u;

    /* renamed from: v  reason: collision with root package name */
    private int f22736v;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        throw new java.lang.IllegalStateException(com.tencent.mm.sdk.b.c.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trimToSize(int r3) {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            int r0 = r2.size     // Catch:{ all -> 0x0067 }
            if (r0 < 0) goto L_0x004a
            java.util.LinkedHashMap<K, V> r0 = r2.f22735u     // Catch:{ all -> 0x0067 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0011
            int r0 = r2.size     // Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x004a
        L_0x0011:
            int r0 = r2.size     // Catch:{ all -> 0x0067 }
            if (r0 <= r3) goto L_0x0048
            java.util.LinkedHashMap<K, V> r0 = r2.f22735u     // Catch:{ all -> 0x0067 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x001e
            goto L_0x0048
        L_0x001e:
            java.util.LinkedHashMap<K, V> r0 = r2.f22735u     // Catch:{ all -> 0x0067 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0067 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0067 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0067 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0067 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0067 }
            r0.getValue()     // Catch:{ all -> 0x0067 }
            java.util.LinkedHashMap<K, V> r0 = r2.f22735u     // Catch:{ all -> 0x0067 }
            r0.remove(r1)     // Catch:{ all -> 0x0067 }
            int r0 = r2.size     // Catch:{ all -> 0x0067 }
            int r0 = r0 + -1
            r2.size = r0     // Catch:{ all -> 0x0067 }
            int r0 = r2.B     // Catch:{ all -> 0x0067 }
            int r0 = r0 + 1
            r2.B = r0     // Catch:{ all -> 0x0067 }
            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
            goto L_0x0000
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
            return
        L_0x004a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r0.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.Class<com.tencent.mm.sdk.b.c> r1 = com.tencent.mm.sdk.b.c.class
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0067 }
            r0.append(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0067 }
            r3.<init>(r0)     // Catch:{ all -> 0x0067 }
            throw r3     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.b.c.trimToSize(int):void");
    }

    public final synchronized boolean a(K k11) {
        return this.f22735u.containsKey(k11);
    }

    public final V get(K k11) {
        Objects.requireNonNull(k11, "key == null");
        synchronized (this) {
            V v11 = this.f22735u.get(k11);
            if (v11 != null) {
                this.C++;
                return v11;
            }
            this.D++;
            return null;
        }
    }

    public final V put(K k11, V v11) {
        V put;
        if (k11 == null || v11 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.A++;
            this.size++;
            put = this.f22735u.put(k11, v11);
            if (put != null) {
                this.size--;
            }
        }
        trimToSize(this.f22736v);
        return put;
    }

    public final synchronized String toString() {
        int i11;
        int i12;
        i11 = this.C;
        i12 = this.D + i11;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f22736v), Integer.valueOf(this.C), Integer.valueOf(this.D), Integer.valueOf(i12 != 0 ? (i11 * 100) / i12 : 0)});
    }
}
