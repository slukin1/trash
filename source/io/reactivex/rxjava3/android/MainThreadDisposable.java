package io.reactivex.rxjava3.android;

import android.os.Looper;
import e00.a;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable implements b {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f55419b = new AtomicBoolean();

    public abstract void a();

    public final void dispose() {
        if (!this.f55419b.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
        } else {
            g00.b.c().c(new a(this));
        }
    }

    public final boolean isDisposed() {
        return this.f55419b.get();
    }
}
