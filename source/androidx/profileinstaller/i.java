package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f10503b;

    public /* synthetic */ i(Context context) {
        this.f10503b = context;
    }

    public final void run() {
        ProfileInstallerInitializer.j(this.f10503b);
    }
}
