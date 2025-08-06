package com.jumio.core.interfaces;

import android.content.Context;

public interface DeviceUtilInterface {
    boolean areAnimationsEnabled(Context context);

    boolean isDarkModeActive(Context context);

    boolean isDebug(Context context);

    boolean isSupportedPlatform(Context context, boolean z11);
}
