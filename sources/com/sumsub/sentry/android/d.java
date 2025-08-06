package com.sumsub.sentry.android;

import com.sumsub.sentry.Device;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f30274a = new d();

    public final Device.DeviceOrientation a(int i11) {
        if (i11 == 1) {
            return Device.DeviceOrientation.PORTRAIT;
        }
        if (i11 != 2) {
            return null;
        }
        return Device.DeviceOrientation.LANDSCAPE;
    }
}
