package com.tencent.liteav.base.util;

import java.lang.ref.WeakReference;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<T> f21526a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final C0169a<T> f21527b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<T> f21528c = new WeakReference<>((Object) null);

    /* renamed from: com.tencent.liteav.base.util.a$a  reason: collision with other inner class name */
    public interface C0169a<T> {
        T a();
    }

    public a(C0169a<T> aVar) {
        this.f21527b = aVar;
    }

    private T b() {
        T t11 = this.f21528c.get();
        if (t11 == null) {
            synchronized (this) {
                t11 = this.f21528c.get();
                if (t11 == null) {
                    t11 = this.f21527b.a();
                    this.f21528c = new WeakReference<>(t11);
                }
            }
        }
        return t11;
    }

    public final T a() {
        T t11 = this.f21526a.get();
        if (t11 != null) {
            return t11;
        }
        T b11 = b();
        this.f21526a.set(b11);
        return b11;
    }
}
