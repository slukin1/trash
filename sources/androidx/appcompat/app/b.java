package androidx.appcompat.app;

import android.content.Context;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f3924b;

    public /* synthetic */ b(Context context) {
        this.f3924b = context;
    }

    public final void run() {
        AppCompatDelegate.w(this.f3924b);
    }
}
