package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public interface Function<F, T> {
    @CanIgnoreReturnValue
    T apply(F f11);

    boolean equals(Object obj);
}
