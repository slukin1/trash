package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class l implements Choreographer.FrameCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f10507b;

    public /* synthetic */ l(Runnable runnable) {
        this.f10507b = runnable;
    }

    public final void doFrame(long j11) {
        this.f10507b.run();
    }
}
