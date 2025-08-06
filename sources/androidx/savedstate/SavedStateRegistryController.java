package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.r;

public final class SavedStateRegistryController {

    /* renamed from: d  reason: collision with root package name */
    public static final a f10939d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final c f10940a;

    /* renamed from: b  reason: collision with root package name */
    public final SavedStateRegistry f10941b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10942c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final SavedStateRegistryController a(c cVar) {
            return new SavedStateRegistryController(cVar, (r) null);
        }
    }

    public SavedStateRegistryController(c cVar) {
        this.f10940a = cVar;
        this.f10941b = new SavedStateRegistry();
    }

    public /* synthetic */ SavedStateRegistryController(c cVar, r rVar) {
        this(cVar);
    }

    public static final SavedStateRegistryController a(c cVar) {
        return f10939d.a(cVar);
    }

    public final SavedStateRegistry b() {
        return this.f10941b;
    }

    public final void c() {
        Lifecycle lifecycle = this.f10940a.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            lifecycle.a(new a(this.f10940a));
            this.f10941b.e(lifecycle);
            this.f10942c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void d(Bundle bundle) {
        if (!this.f10942c) {
            c();
        }
        Lifecycle lifecycle = this.f10940a.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f10941b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        this.f10941b.g(bundle);
    }
}
