package com.appsflyer.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.iproov.sdk.bridge.OptionsBridge;

final class u {

    public static final class c {
        public static final u AFInAppEventParameterName = new u();
    }

    private static boolean AFInAppEventParameterName(Context context, String[] strArr) {
        for (String AFInAppEventParameterName : strArr) {
            if (aa.AFInAppEventParameterName(context, AFInAppEventParameterName)) {
                return true;
            }
        }
        return false;
    }

    public final Location valueOf(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Location lastKnownLocation = AFInAppEventParameterName(context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) ? locationManager.getLastKnownLocation(OptionsBridge.NETWORK_KEY) : null;
            Location lastKnownLocation2 = AFInAppEventParameterName(context, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) ? locationManager.getLastKnownLocation("gps") : null;
            if (lastKnownLocation2 == null && lastKnownLocation == null) {
                lastKnownLocation = null;
            } else if (lastKnownLocation2 != null || lastKnownLocation == null) {
                if ((lastKnownLocation == null && lastKnownLocation2 != null) || 60000 >= lastKnownLocation.getTime() - lastKnownLocation2.getTime()) {
                    lastKnownLocation = lastKnownLocation2;
                }
            }
            if (lastKnownLocation != null) {
                return lastKnownLocation;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
