package com.sumsub.sns.internal.core.presentation.screen.base;

import androidx.lifecycle.SavedStateHandle;
import kotlin.reflect.l;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final SavedStateHandle f33880a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33881b;

    /* renamed from: c  reason: collision with root package name */
    public final T f33882c;

    public a(SavedStateHandle savedStateHandle, String str, T t11) {
        this.f33880a = savedStateHandle;
        this.f33881b = str;
        this.f33882c = t11;
    }

    public final T a(Object obj, l<?> lVar) {
        T f11 = this.f33880a.f(this.f33881b);
        return f11 == null ? this.f33882c : f11;
    }

    public final void a(Object obj, l<?> lVar, T t11) {
        this.f33880a.k(this.f33881b, t11);
    }
}
