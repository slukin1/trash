package com.hbg.component.kline.render.buffer;

import com.hbg.component.kline.render.buffer.DataBuffer;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

public class DataBufferManager {

    /* renamed from: a  reason: collision with root package name */
    public static List<SoftReference<DataBuffer.a>> f67306a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public static List<SoftReference<DataBuffer.a>> f67307b = new LinkedList();

    public static boolean b(SoftReference<DataBuffer.a> softReference) {
        return (softReference == null || softReference.get() == null) ? false : true;
    }

    public static /* synthetic */ int c(SoftReference softReference, SoftReference softReference2) {
        if (b(softReference) && b(softReference2)) {
            return ((DataBuffer.a) softReference.get()).f67302d - ((DataBuffer.a) softReference2.get()).f67302d;
        }
        if (!b(softReference)) {
            f67307b.remove(softReference);
        }
        if (b(softReference2)) {
            return 0;
        }
        f67307b.remove(softReference2);
        return 0;
    }

    public static synchronized <T extends DataBuffer.a> T d(int i11, DataBuffer.BufferType bufferType, Class<? extends DataBuffer.a> cls) {
        T t11;
        Class<DataBuffer.b> cls2 = DataBuffer.b.class;
        Class<DataBuffer.c> cls3 = DataBuffer.c.class;
        synchronized (DataBufferManager.class) {
            for (SoftReference next : f67307b) {
                if ((cls == cls3 || cls == cls2) && next != null && (t11 = (DataBuffer.a) next.get()) != null && t11.c() == i11) {
                    ((DataBuffer.a) next.get()).b(bufferType);
                    f67306a.add(next);
                    f67307b.remove(next);
                    return t11;
                }
            }
            if (cls == cls3) {
                T cVar = new DataBuffer.c(i11);
                cVar.b(bufferType);
                f67306a.add(new SoftReference(cVar));
                return cVar;
            } else if (cls != cls2) {
                return null;
            } else {
                T bVar = new DataBuffer.b(i11);
                bVar.b(bufferType);
                f67306a.add(new SoftReference(bVar));
                return bVar;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void e(com.hbg.component.kline.render.buffer.DataBuffer.a r4) {
        /*
            java.lang.Class<com.hbg.component.kline.render.buffer.DataBufferManager> r0 = com.hbg.component.kline.render.buffer.DataBufferManager.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x008b
            r4.a()     // Catch:{ all -> 0x0088 }
            int r1 = r4.f67302d     // Catch:{ all -> 0x0088 }
            int r1 = r1 + 1
            r4.f67302d = r1     // Catch:{ all -> 0x0088 }
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r1 = f67306a     // Catch:{ all -> 0x0088 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0088 }
        L_0x0014:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0088 }
            java.lang.ref.SoftReference r2 = (java.lang.ref.SoftReference) r2     // Catch:{ all -> 0x0088 }
            boolean r3 = b(r2)     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x0030
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0088 }
            if (r2 != r4) goto L_0x0014
            r1.remove()     // Catch:{ all -> 0x0088 }
            goto L_0x0014
        L_0x0030:
            r1.remove()     // Catch:{ all -> 0x0088 }
            goto L_0x0014
        L_0x0034:
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r1 = f67307b     // Catch:{ all -> 0x0088 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0088 }
        L_0x003a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0088 }
            java.lang.ref.SoftReference r2 = (java.lang.ref.SoftReference) r2     // Catch:{ all -> 0x0088 }
            boolean r3 = b(r2)     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x0054
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0088 }
            if (r2 != r4) goto L_0x003a
            monitor-exit(r0)
            return
        L_0x0054:
            r1.remove()     // Catch:{ all -> 0x0088 }
            goto L_0x003a
        L_0x0058:
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r1 = f67307b     // Catch:{ all -> 0x0088 }
            java.lang.ref.SoftReference r2 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x0088 }
            r2.<init>(r4)     // Catch:{ all -> 0x0088 }
            r1.add(r2)     // Catch:{ all -> 0x0088 }
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r4 = f67307b     // Catch:{ all -> 0x0088 }
            t5.a r1 = t5.a.f29296b     // Catch:{ all -> 0x0088 }
            java.util.Collections.sort(r4, r1)     // Catch:{ all -> 0x0088 }
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r4 = f67307b     // Catch:{ all -> 0x0088 }
            int r4 = r4.size()     // Catch:{ all -> 0x0088 }
            r1 = 20
            if (r4 <= r1) goto L_0x008b
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r4 = f67307b     // Catch:{ all -> 0x0088 }
            int r4 = r4.size()     // Catch:{ all -> 0x0088 }
            int r4 = r4 - r1
            if (r4 <= 0) goto L_0x008b
            r1 = 0
            r2 = r1
        L_0x007e:
            if (r2 >= r4) goto L_0x008b
            java.util.List<java.lang.ref.SoftReference<com.hbg.component.kline.render.buffer.DataBuffer$a>> r3 = f67307b     // Catch:{ all -> 0x0088 }
            r3.remove(r1)     // Catch:{ all -> 0x0088 }
            int r2 = r2 + 1
            goto L_0x007e
        L_0x0088:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x008b:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.component.kline.render.buffer.DataBufferManager.e(com.hbg.component.kline.render.buffer.DataBuffer$a):void");
    }
}
