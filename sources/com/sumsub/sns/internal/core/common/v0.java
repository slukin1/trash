package com.sumsub.sns.internal.core.common;

import androidx.lifecycle.SavedStateHandle;
import com.sumsub.sns.internal.core.presentation.screen.base.a;

public final class v0 {
    public static final <T> a<T> a(SavedStateHandle savedStateHandle, String str) {
        Object f11 = savedStateHandle.f(str);
        if (f11 != null) {
            return new a<>(savedStateHandle, str, f11);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
