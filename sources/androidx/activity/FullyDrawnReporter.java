package androidx.activity;

import d10.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;

public final class FullyDrawnReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3632a;

    /* renamed from: b  reason: collision with root package name */
    public final a<Unit> f3633b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3634c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f3635d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3636e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3637f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a<Unit>> f3638g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f3639h = new l(this);

    public FullyDrawnReporter(Executor executor, a<Unit> aVar) {
        this.f3632a = executor;
        this.f3633b = aVar;
    }

    public static final void g(FullyDrawnReporter fullyDrawnReporter) {
        synchronized (fullyDrawnReporter.f3634c) {
            fullyDrawnReporter.f3636e = false;
            if (fullyDrawnReporter.f3635d == 0 && !fullyDrawnReporter.f3637f) {
                fullyDrawnReporter.f3633b.invoke();
                fullyDrawnReporter.c();
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void b() {
        synchronized (this.f3634c) {
            if (!this.f3637f) {
                this.f3635d++;
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void c() {
        synchronized (this.f3634c) {
            this.f3637f = true;
            for (a invoke : this.f3638g) {
                invoke.invoke();
            }
            this.f3638g.clear();
            Unit unit = Unit.f56620a;
        }
    }

    public final boolean d() {
        boolean z11;
        synchronized (this.f3634c) {
            z11 = this.f3637f;
        }
        return z11;
    }

    public final void e() {
        if (!this.f3636e && this.f3635d == 0) {
            this.f3636e = true;
            this.f3632a.execute(this.f3639h);
        }
    }

    public final void f() {
        int i11;
        synchronized (this.f3634c) {
            if (!this.f3637f && (i11 = this.f3635d) > 0) {
                this.f3635d = i11 - 1;
                e();
            }
            Unit unit = Unit.f56620a;
        }
    }
}
