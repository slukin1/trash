package com.twitter.sdk.android.core.services.params;

import com.xiaomi.mipush.sdk.Constants;

public class Geocode {
    public final Distance distance;
    public final double latitude;
    public final double longitude;
    public final int radius;

    public enum Distance {
        MILES("mi"),
        KILOMETERS("km");
        
        public final String identifier;

        private Distance(String str) {
            this.identifier = str;
        }
    }

    public Geocode(double d11, double d12, int i11, Distance distance2) {
        this.latitude = d11;
        this.longitude = d12;
        this.radius = i11;
        this.distance = distance2;
    }

    public String toString() {
        return this.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.longitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.radius + this.distance.identifier;
    }
}
