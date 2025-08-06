package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.AudioExecutor;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f5590b;

    public /* synthetic */ a(Runnable runnable) {
        this.f5590b = runnable;
    }

    public final void run() {
        AudioExecutor.AnonymousClass1.lambda$newThread$0(this.f5590b);
    }
}
