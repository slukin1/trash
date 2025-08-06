package kotlinx.coroutines.internal;

import d10.l;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class j0 extends CtorCache {

    /* renamed from: a  reason: collision with root package name */
    public static final j0 f57320a = new j0();

    /* renamed from: b  reason: collision with root package name */
    public static final ReentrantReadWriteLock f57321b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    public static final WeakHashMap<Class<? extends Throwable>, l<Throwable, Throwable>> f57322c = new WeakHashMap<>();

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public d10.l<java.lang.Throwable, java.lang.Throwable> a(java.lang.Class<? extends java.lang.Throwable> r7) {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f57321b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            r1.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, d10.l<java.lang.Throwable, java.lang.Throwable>> r2 = f57322c     // Catch:{ all -> 0x006e }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x006e }
            d10.l r2 = (d10.l) r2     // Catch:{ all -> 0x006e }
            r1.unlock()
            if (r2 == 0) goto L_0x0017
            return r2
        L_0x0017:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0027
            int r2 = r0.getReadHoldCount()
            goto L_0x0028
        L_0x0027:
            r2 = r3
        L_0x0028:
            r4 = r3
        L_0x0029:
            if (r4 >= r2) goto L_0x0031
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0031:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, d10.l<java.lang.Throwable, java.lang.Throwable>> r4 = f57322c     // Catch:{ all -> 0x0061 }
            java.lang.Object r5 = r4.get(r7)     // Catch:{ all -> 0x0061 }
            d10.l r5 = (d10.l) r5     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x004e
        L_0x0042:
            if (r3 >= r2) goto L_0x004a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0042
        L_0x004a:
            r0.unlock()
            return r5
        L_0x004e:
            d10.l r5 = kotlinx.coroutines.internal.ExceptionsConstructorKt.b(r7)     // Catch:{ all -> 0x0061 }
            r4.put(r7, r5)     // Catch:{ all -> 0x0061 }
        L_0x0055:
            if (r3 >= r2) goto L_0x005d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0055
        L_0x005d:
            r0.unlock()
            return r5
        L_0x0061:
            r7 = move-exception
        L_0x0062:
            if (r3 >= r2) goto L_0x006a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0062
        L_0x006a:
            r0.unlock()
            throw r7
        L_0x006e:
            r7 = move-exception
            r1.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.j0.a(java.lang.Class):d10.l");
    }
}
