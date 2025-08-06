package com.sumsub.sns.internal.geo.domain;

import android.location.Location;
import android.os.Build;

public final class a {
    public static final boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return location.isMock();
        }
        return location.isFromMockProvider();
    }
}
