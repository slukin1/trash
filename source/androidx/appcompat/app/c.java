package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class c implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f3925a;

    public /* synthetic */ c(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f3925a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f3925a.E0();
    }
}
