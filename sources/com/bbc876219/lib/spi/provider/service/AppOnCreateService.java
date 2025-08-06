package com.bbc876219.lib.spi.provider.service;

import androidx.annotation.Keep;

@Keep
public interface AppOnCreateService {
    boolean isRunInMainThread();

    void onCreate();
}
