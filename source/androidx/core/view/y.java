package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class y implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final View f8684b;

    /* renamed from: c  reason: collision with root package name */
    public ViewTreeObserver f8685c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f8686d;

    public y(View view, Runnable runnable) {
        this.f8684b = view;
        this.f8685c = view.getViewTreeObserver();
        this.f8686d = runnable;
    }

    public static y a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        y yVar = new y(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(yVar);
        view.addOnAttachStateChangeListener(yVar);
        return yVar;
    }

    public void b() {
        if (this.f8685c.isAlive()) {
            this.f8685c.removeOnPreDrawListener(this);
        } else {
            this.f8684b.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f8684b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f8686d.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f8685c = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
