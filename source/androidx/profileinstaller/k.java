package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f10505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f10506c;

    public /* synthetic */ k(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f10505b = profileInstallerInitializer;
        this.f10506c = context;
    }

    public final void run() {
        this.f10505b.g(this.f10506c);
    }
}
