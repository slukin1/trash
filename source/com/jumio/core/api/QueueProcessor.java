package com.jumio.core.api;

import com.jumio.commons.log.Log;
import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.Subscriber;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import d10.a;
import d10.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import jumio.core.g2;
import jumio.core.h;
import jumio.core.i;
import jumio.core.y1;
import kotlin.Unit;

public final class QueueProcessor implements Subscriber<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final l<a<Unit>, Unit> f39045a;

    /* renamed from: b  reason: collision with root package name */
    public final h f39046b;

    /* renamed from: c  reason: collision with root package name */
    public final i f39047c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentLinkedQueue<ApiCallDataModel<?>> f39048d = new ConcurrentLinkedQueue<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f39049e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f39050f;

    /* renamed from: g  reason: collision with root package name */
    public Future<?> f39051g;

    /* renamed from: h  reason: collision with root package name */
    public ApiCall<?> f39052h;

    public QueueProcessor(ExecutorService executorService, l<? super a<Unit>, Unit> lVar, h hVar, i iVar) {
        this.f39045a = lVar;
        this.f39046b = hVar;
        this.f39047c = iVar;
        this.f39050f = executorService;
    }

    public static final void a(long j11, QueueProcessor queueProcessor) {
        Thread.sleep(j11);
        queueProcessor.f39051g = null;
        queueProcessor.f39045a.invoke(new g2(queueProcessor));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f39049e
            monitor-enter(r0)
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r1 = r8.f39048d     // Catch:{ all -> 0x0070 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x006e
            java.util.concurrent.Future<?> r1 = r8.f39051g     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0010
            goto L_0x006e
        L_0x0010:
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r1 = r8.f39048d     // Catch:{ all -> 0x0070 }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x0070 }
            com.jumio.core.models.ApiCallDataModel r1 = (com.jumio.core.models.ApiCallDataModel) r1     // Catch:{ all -> 0x0070 }
            java.lang.Class r2 = r1.getCall()     // Catch:{ all -> 0x0070 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0070 }
            java.lang.Class<jumio.core.h> r5 = jumio.core.h.class
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0070 }
            java.lang.Class<com.jumio.core.models.ApiCallDataModel> r5 = com.jumio.core.models.ApiCallDataModel.class
            r7 = 1
            r4[r7] = r5     // Catch:{ all -> 0x0070 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x0070 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0070 }
            jumio.core.h r4 = r8.f39046b     // Catch:{ all -> 0x0070 }
            r3[r6] = r4     // Catch:{ all -> 0x0070 }
            r3[r7] = r1     // Catch:{ all -> 0x0070 }
            java.lang.Object r1 = r2.newInstance(r3)     // Catch:{ all -> 0x0070 }
            com.jumio.core.network.ApiCall r1 = (com.jumio.core.network.ApiCall) r1     // Catch:{ all -> 0x0070 }
            r8.f39052h = r1     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x006c
            java.lang.String r2 = "QueueProcessor"
            java.lang.Class r3 = r1.getClass()     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r4.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "proceed() starting "
            r4.append(r5)     // Catch:{ all -> 0x0070 }
            r4.append(r3)     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0070 }
            com.jumio.commons.log.Log.i((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0070 }
            r1.add(r8)     // Catch:{ all -> 0x0070 }
            java.util.concurrent.ExecutorService r1 = r8.f39050f     // Catch:{ all -> 0x0070 }
            com.jumio.core.network.ApiCall<?> r2 = r8.f39052h     // Catch:{ all -> 0x0070 }
            java.util.concurrent.Future r1 = r1.submit(r2)     // Catch:{ all -> 0x0070 }
            r8.f39051g = r1     // Catch:{ all -> 0x0070 }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0070 }
        L_0x006c:
            monitor-exit(r0)
            return
        L_0x006e:
            monitor-exit(r0)
            return
        L_0x0070:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.QueueProcessor.b():void");
    }

    public final void c() {
        synchronized (this.f39049e) {
            this.f39051g = this.f39050f.submit(new hw.a(250, this));
            Unit unit = Unit.f56620a;
        }
    }

    @InvokeOnUiThread(true)
    public void onError(Throwable th2) {
        ApiCall<?> a11 = a(false);
        if (a11 != null) {
            this.f39047c.onError(a11.getApiCallDataModel(), th2);
        }
    }

    @InvokeOnUiThread(true)
    public void onResult(Object obj) {
        ApiCall<?> a11 = a(true);
        if (a11 != null) {
            this.f39047c.onResult(a11.getApiCallDataModel(), obj);
            b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.jumio.core.network.ApiCall<?> a(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f39049e
            monitor-enter(r0)
            com.jumio.core.network.ApiCall<?> r1 = r4.f39052h     // Catch:{ all -> 0x003c }
            r2 = 0
            if (r1 == 0) goto L_0x003a
            java.util.concurrent.Future<?> r1 = r4.f39051g     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x000d
            goto L_0x003a
        L_0x000d:
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r1 = r4.f39048d     // Catch:{ all -> 0x003c }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x003c }
            com.jumio.core.models.ApiCallDataModel r1 = (com.jumio.core.models.ApiCallDataModel) r1     // Catch:{ all -> 0x003c }
            java.lang.Class r1 = r1.getCall()     // Catch:{ all -> 0x003c }
            com.jumio.core.network.ApiCall<?> r3 = r4.f39052h     // Catch:{ all -> 0x003c }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x003c }
            if (r1 != r3) goto L_0x0031
            if (r5 == 0) goto L_0x0029
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r5 = r4.f39048d     // Catch:{ all -> 0x003c }
            r5.poll()     // Catch:{ all -> 0x003c }
            goto L_0x002e
        L_0x0029:
            java.util.concurrent.ConcurrentLinkedQueue<com.jumio.core.models.ApiCallDataModel<?>> r5 = r4.f39048d     // Catch:{ all -> 0x003c }
            r5.peek()     // Catch:{ all -> 0x003c }
        L_0x002e:
            com.jumio.core.network.ApiCall<?> r5 = r4.f39052h     // Catch:{ all -> 0x003c }
            goto L_0x0032
        L_0x0031:
            r5 = r2
        L_0x0032:
            r4.f39051g = r2     // Catch:{ all -> 0x003c }
            r4.f39052h = r2     // Catch:{ all -> 0x003c }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x003c }
            monitor-exit(r0)
            return r5
        L_0x003a:
            monitor-exit(r0)
            return r2
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.QueueProcessor.a(boolean):com.jumio.core.network.ApiCall");
    }

    public final void a(ApiCallDataModel<?> apiCallDataModel) {
        synchronized (this.f39049e) {
            this.f39048d.add(apiCallDataModel);
            String simpleName = apiCallDataModel.getCall().getSimpleName();
            Log.i("QueueProcessor", "  item added! " + simpleName);
            if (this.f39051g == null) {
                b();
            } else {
                Log.i("QueueProcessor", "  don't proceed, a call is executing");
            }
            Unit unit = Unit.f56620a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:13|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.f39051g = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f39051g = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0020, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f39049e
            monitor-enter(r0)
            r1 = 0
            com.jumio.core.network.ApiCall<?> r2 = r4.f39052h     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x000b
            r2.remove(r4)     // Catch:{ Exception -> 0x0018 }
        L_0x000b:
            java.util.concurrent.Future<?> r2 = r4.f39051g     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x0013
            r3 = 1
            r2.cancel(r3)     // Catch:{ Exception -> 0x0018 }
        L_0x0013:
            r4.f39051g = r1     // Catch:{ all -> 0x0021 }
            goto L_0x001c
        L_0x0016:
            r2 = move-exception
            goto L_0x001e
        L_0x0018:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0016 }
            r4.f39051g = r1     // Catch:{ all -> 0x0021 }
        L_0x001c:
            monitor-exit(r0)
            return
        L_0x001e:
            r4.f39051g = r1     // Catch:{ all -> 0x0021 }
            throw r2     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.QueueProcessor.a():void");
    }

    public final void a(y1 y1Var, boolean z11) {
        synchronized (this.f39049e) {
            if (z11) {
                a();
            }
            y1Var.a(this.f39048d);
            Unit unit = Unit.f56620a;
        }
    }
}
