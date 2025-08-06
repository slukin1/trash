package com.bbc876219.lib.spi.provider.service;

import androidx.annotation.Keep;

@Keep
public interface InsertMethodHookService {
    void hookAfter(Object obj, Object[] objArr);

    void hookBefore(Object obj, Object[] objArr);

    boolean isRunInMainThread();
}
