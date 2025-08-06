package androidx.lifecycle;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.r;

public abstract class ComputableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f9876a;

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<T> f9877b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<T> f9878c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f9879d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f9880e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f9881f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f9882g;

    public static final class a extends LiveData<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ComputableLiveData<T> f9883a;

        public a(ComputableLiveData<T> computableLiveData) {
            this.f9883a = computableLiveData;
        }

        public void onActive() {
            this.f9883a.d().execute(this.f9883a.f9881f);
        }
    }

    public ComputableLiveData() {
        this((Executor) null, 1, (r) null);
    }

    public ComputableLiveData(Executor executor) {
        this.f9876a = executor;
        a aVar = new a(this);
        this.f9877b = aVar;
        this.f9878c = aVar;
        this.f9879d = new AtomicBoolean(true);
        this.f9880e = new AtomicBoolean(false);
        this.f9881f = new f(this);
        this.f9882g = new g(this);
    }

    public static final void f(ComputableLiveData computableLiveData) {
        boolean hasActiveObservers = computableLiveData.e().hasActiveObservers();
        if (computableLiveData.f9879d.compareAndSet(false, true) && hasActiveObservers) {
            computableLiveData.f9876a.execute(computableLiveData.f9881f);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void g(androidx.lifecycle.ComputableLiveData r5) {
        /*
        L_0x0000:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f9880e
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0031
            r0 = 0
            r3 = r1
        L_0x000c:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.f9879d     // Catch:{ all -> 0x002a }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x001a
            java.lang.Object r0 = r5.c()     // Catch:{ all -> 0x002a }
            r3 = r2
            goto L_0x000c
        L_0x001a:
            if (r3 == 0) goto L_0x0023
            androidx.lifecycle.LiveData r2 = r5.e()     // Catch:{ all -> 0x002a }
            r2.postValue(r0)     // Catch:{ all -> 0x002a }
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f9880e
            r0.set(r1)
            r1 = r3
            goto L_0x0031
        L_0x002a:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.f9880e
            r5.set(r1)
            throw r0
        L_0x0031:
            if (r1 == 0) goto L_0x003b
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f9879d
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0000
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.g(androidx.lifecycle.ComputableLiveData):void");
    }

    public abstract T c();

    public final Executor d() {
        return this.f9876a;
    }

    public LiveData<T> e() {
        return this.f9878c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComputableLiveData(Executor executor, int i11, r rVar) {
        this((i11 & 1) != 0 ? i.a.d() : executor);
    }
}
