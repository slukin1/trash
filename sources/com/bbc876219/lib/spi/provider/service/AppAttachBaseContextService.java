package com.bbc876219.lib.spi.provider.service;

import android.app.Application;
import androidx.annotation.Keep;

@Keep
public interface AppAttachBaseContextService {
    void attachBaseContext(Application application);

    boolean isRunInMainThread();
}
