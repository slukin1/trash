package com.google.android.play.integrity.internal;

import java.util.Objects;

public final class aj implements ai {

    /* renamed from: a  reason: collision with root package name */
    private static final aj f66882a = new aj((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private final Object f66883b;

    private aj(Object obj) {
        this.f66883b = obj;
    }

    public static ai b(Object obj) {
        Objects.requireNonNull(obj, "instance cannot be null");
        return new aj(obj);
    }

    public final Object a() {
        return this.f66883b;
    }
}
