package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f57090a;

    /* renamed from: b  reason: collision with root package name */
    public final c f57091b;

    /* renamed from: c  reason: collision with root package name */
    public final long f57092c;

    /* renamed from: d  reason: collision with root package name */
    public final List<StackTraceElement> f57093d;

    /* renamed from: e  reason: collision with root package name */
    public final String f57094e;

    /* renamed from: f  reason: collision with root package name */
    public final Thread f57095f;

    /* renamed from: g  reason: collision with root package name */
    public final c f57096g;

    /* renamed from: h  reason: collision with root package name */
    public final List<StackTraceElement> f57097h;

    public b(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        this.f57090a = coroutineContext;
        this.f57091b = debugCoroutineInfoImpl.d();
        this.f57092c = debugCoroutineInfoImpl.f57085b;
        this.f57093d = debugCoroutineInfoImpl.e();
        this.f57094e = debugCoroutineInfoImpl.g();
        this.f57095f = debugCoroutineInfoImpl.lastObservedThread;
        this.f57096g = debugCoroutineInfoImpl.f();
        this.f57097h = debugCoroutineInfoImpl.h();
    }
}
