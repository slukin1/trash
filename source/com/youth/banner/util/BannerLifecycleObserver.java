package com.youth.banner.util;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.u;

public interface BannerLifecycleObserver extends u {
    void onDestroy(LifecycleOwner lifecycleOwner);

    void onStart(LifecycleOwner lifecycleOwner);

    void onStop(LifecycleOwner lifecycleOwner);
}
