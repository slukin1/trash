package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I i11) throws Exception;
}
