package com.tencent.liteav.base.util;

import android.text.TextUtils;
import java.util.concurrent.Callable;

public final class s<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f21569a;

    /* renamed from: b  reason: collision with root package name */
    private Callable<T> f21570b;

    public s(Callable<T> callable) {
        this.f21570b = callable;
    }

    public final void a(T t11) {
        synchronized (this) {
            this.f21569a = t11;
        }
    }

    public final T a() {
        T t11 = this.f21569a;
        if (t11 instanceof String) {
            if (!TextUtils.isEmpty((CharSequence) t11)) {
                return this.f21569a;
            }
        } else if (t11 != null) {
            return t11;
        }
        synchronized (this) {
            T t12 = this.f21569a;
            if (t12 instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) t12)) {
                    T t13 = this.f21569a;
                    return t13;
                }
            } else if (t12 != null) {
                return t12;
            }
            try {
                this.f21569a = this.f21570b.call();
            } catch (Exception e11) {
                e11.printStackTrace();
                LiteavLog.e("Stash", "Get value failed. msg:" + e11.getMessage());
            }
            T t14 = this.f21569a;
            return t14;
        }
    }
}
