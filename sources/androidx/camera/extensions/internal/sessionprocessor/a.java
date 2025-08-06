package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5771a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final LongSparseArray<TotalCaptureResult> f5772b = new LongSparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public Map<TotalCaptureResult, Integer> f5773c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<b> f5774d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public C0008a f5775e;

    /* renamed from: androidx.camera.extensions.internal.sessionprocessor.a$a  reason: collision with other inner class name */
    public interface C0008a {
        void a(b bVar, TotalCaptureResult totalCaptureResult, int i11);
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        b(totalCaptureResult, 0);
    }

    public void b(TotalCaptureResult totalCaptureResult, int i11) {
        synchronized (this.f5771a) {
            long e11 = e(totalCaptureResult);
            if (e11 != -1) {
                this.f5772b.put(e11, totalCaptureResult);
                this.f5773c.put(totalCaptureResult, Integer.valueOf(i11));
                g();
            }
        }
    }

    public void c() {
        synchronized (this.f5771a) {
            this.f5772b.clear();
            for (int i11 = 0; i11 < this.f5774d.size(); i11++) {
                this.f5774d.get(this.f5774d.keyAt(i11)).a();
            }
            this.f5774d.clear();
            this.f5773c.clear();
        }
    }

    public void d() {
        synchronized (this.f5771a) {
            this.f5775e = null;
        }
    }

    public final long e(TotalCaptureResult totalCaptureResult) {
        Long l11 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l11 != null) {
            return l11.longValue();
        }
        return -1;
    }

    public void f(b bVar) {
        synchronized (this.f5771a) {
            this.f5774d.put(bVar.get().getTimestamp(), bVar);
        }
        g();
    }

    public final void g() {
        b bVar;
        TotalCaptureResult totalCaptureResult;
        synchronized (this.f5771a) {
            bVar = null;
            totalCaptureResult = null;
            for (int size = this.f5772b.size() - 1; size >= 0; size--) {
                TotalCaptureResult valueAt = this.f5772b.valueAt(size);
                long e11 = e(valueAt);
                b bVar2 = this.f5774d.get(e11);
                if (bVar2 != null) {
                    this.f5774d.remove(e11);
                    this.f5772b.removeAt(size);
                    totalCaptureResult = valueAt;
                    bVar = bVar2;
                }
            }
            i();
        }
        if (bVar != null && totalCaptureResult != null) {
            h(bVar, totalCaptureResult);
        }
    }

    public final void h(b bVar, TotalCaptureResult totalCaptureResult) {
        C0008a aVar;
        Integer num;
        synchronized (this.f5771a) {
            aVar = this.f5775e;
            num = null;
            if (aVar != null) {
                num = this.f5773c.get(totalCaptureResult);
            } else {
                bVar.a();
                aVar = null;
            }
        }
        if (aVar != null) {
            aVar.a(bVar, totalCaptureResult, num.intValue());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f5771a
            monitor-enter(r0)
            android.util.LongSparseArray<androidx.camera.extensions.internal.sessionprocessor.b> r1 = r10.f5774d     // Catch:{ all -> 0x008e }
            int r1 = r1.size()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008c
            android.util.LongSparseArray<android.hardware.camera2.TotalCaptureResult> r1 = r10.f5772b     // Catch:{ all -> 0x008e }
            int r1 = r1.size()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0015
            goto L_0x008c
        L_0x0015:
            android.util.LongSparseArray<androidx.camera.extensions.internal.sessionprocessor.b> r1 = r10.f5774d     // Catch:{ all -> 0x008e }
            r2 = 0
            long r3 = r1.keyAt(r2)     // Catch:{ all -> 0x008e }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x008e }
            android.util.LongSparseArray<android.hardware.camera2.TotalCaptureResult> r3 = r10.f5772b     // Catch:{ all -> 0x008e }
            long r3 = r3.keyAt(r2)     // Catch:{ all -> 0x008e }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x008e }
            boolean r4 = r3.equals(r1)     // Catch:{ all -> 0x008e }
            r5 = 1
            if (r4 != 0) goto L_0x0032
            r2 = r5
        L_0x0032:
            androidx.core.util.h.a(r2)     // Catch:{ all -> 0x008e }
            long r6 = r3.longValue()     // Catch:{ all -> 0x008e }
            long r8 = r1.longValue()     // Catch:{ all -> 0x008e }
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x006b
            android.util.LongSparseArray<androidx.camera.extensions.internal.sessionprocessor.b> r1 = r10.f5774d     // Catch:{ all -> 0x008e }
            int r1 = r1.size()     // Catch:{ all -> 0x008e }
            int r1 = r1 - r5
        L_0x0048:
            if (r1 < 0) goto L_0x008a
            android.util.LongSparseArray<androidx.camera.extensions.internal.sessionprocessor.b> r2 = r10.f5774d     // Catch:{ all -> 0x008e }
            long r4 = r2.keyAt(r1)     // Catch:{ all -> 0x008e }
            long r6 = r3.longValue()     // Catch:{ all -> 0x008e }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0068
            android.util.LongSparseArray<androidx.camera.extensions.internal.sessionprocessor.b> r2 = r10.f5774d     // Catch:{ all -> 0x008e }
            java.lang.Object r2 = r2.valueAt(r1)     // Catch:{ all -> 0x008e }
            androidx.camera.extensions.internal.sessionprocessor.b r2 = (androidx.camera.extensions.internal.sessionprocessor.b) r2     // Catch:{ all -> 0x008e }
            r2.a()     // Catch:{ all -> 0x008e }
            android.util.LongSparseArray<androidx.camera.extensions.internal.sessionprocessor.b> r2 = r10.f5774d     // Catch:{ all -> 0x008e }
            r2.removeAt(r1)     // Catch:{ all -> 0x008e }
        L_0x0068:
            int r1 = r1 + -1
            goto L_0x0048
        L_0x006b:
            android.util.LongSparseArray<android.hardware.camera2.TotalCaptureResult> r2 = r10.f5772b     // Catch:{ all -> 0x008e }
            int r2 = r2.size()     // Catch:{ all -> 0x008e }
            int r2 = r2 - r5
        L_0x0072:
            if (r2 < 0) goto L_0x008a
            android.util.LongSparseArray<android.hardware.camera2.TotalCaptureResult> r3 = r10.f5772b     // Catch:{ all -> 0x008e }
            long r3 = r3.keyAt(r2)     // Catch:{ all -> 0x008e }
            long r5 = r1.longValue()     // Catch:{ all -> 0x008e }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0087
            android.util.LongSparseArray<android.hardware.camera2.TotalCaptureResult> r3 = r10.f5772b     // Catch:{ all -> 0x008e }
            r3.removeAt(r2)     // Catch:{ all -> 0x008e }
        L_0x0087:
            int r2 = r2 + -1
            goto L_0x0072
        L_0x008a:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return
        L_0x008e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.a.i():void");
    }

    public void j(C0008a aVar) {
        synchronized (this.f5771a) {
            this.f5775e = aVar;
        }
    }
}
