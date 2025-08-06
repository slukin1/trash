package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import d10.a;

public final /* synthetic */ class p implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f3685a;

    public /* synthetic */ p(a aVar) {
        this.f3685a = aVar;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.a.c(this.f3685a);
    }
}
