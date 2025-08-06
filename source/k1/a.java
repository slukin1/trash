package k1;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56543b;

    public /* synthetic */ a(String str) {
        this.f56543b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return b.c(this.f56543b, runnable);
    }
}
