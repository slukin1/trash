package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class g0 implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f4570a;

    public /* synthetic */ g0(Runnable runnable) {
        this.f4570a = runnable;
    }

    public final void onBackInvoked() {
        this.f4570a.run();
    }
}
