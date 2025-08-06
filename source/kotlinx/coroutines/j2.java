package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class j2 implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f57360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57361c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f57362d;

    public /* synthetic */ j2(int i11, String str, AtomicInteger atomicInteger) {
        this.f57360b = i11;
        this.f57361c = str;
        this.f57362d = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return k2.c(this.f57360b, this.f57361c, this.f57362d, runnable);
    }
}
