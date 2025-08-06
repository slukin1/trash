package androidx.databinding;

import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class h<T> extends WeakReference<f> {

    /* renamed from: a  reason: collision with root package name */
    public final e<T> f8911a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8912b;

    /* renamed from: c  reason: collision with root package name */
    public T f8913c;

    public h(f fVar, int i11, e<T> eVar, ReferenceQueue<f> referenceQueue) {
        super(fVar, referenceQueue);
        this.f8912b = i11;
        this.f8911a = eVar;
    }

    public f a() {
        f fVar = (f) get();
        if (fVar == null) {
            e();
        }
        return fVar;
    }

    public T b() {
        return this.f8913c;
    }

    public void c(LifecycleOwner lifecycleOwner) {
        this.f8911a.a(lifecycleOwner);
    }

    public void d(T t11) {
        e();
        this.f8913c = t11;
        if (t11 != null) {
            this.f8911a.c(t11);
        }
    }

    public boolean e() {
        boolean z11;
        T t11 = this.f8913c;
        if (t11 != null) {
            this.f8911a.b(t11);
            z11 = true;
        } else {
            z11 = false;
        }
        this.f8913c = null;
        return z11;
    }
}
