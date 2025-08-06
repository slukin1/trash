package com.bbc876219.lib.spi.provider.service;

import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;

@Keep
public interface HomeActivityAttachBaseContextService {
    void attachBaseContext(FragmentActivity fragmentActivity);

    boolean isRunInMainThread();
}
