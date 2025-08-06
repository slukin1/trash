package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(T t11);

    boolean equals(Object obj);
}
