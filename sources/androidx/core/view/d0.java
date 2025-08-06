package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.c0;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class d0 implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f8588a;

    public /* synthetic */ d0(AtomicBoolean atomicBoolean) {
        this.f8588a = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i11) {
        c0.b.f(this.f8588a, windowInsetsController, i11);
    }
}
