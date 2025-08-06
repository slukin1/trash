package com.iproov.sdk.cameray;

import androidx.annotation.Keep;

@Keep
public enum Orientation {
    PORTRAIT(0, true),
    LANDSCAPE(90, false),
    REVERSE_PORTRAIT(180, true),
    REVERSE_LANDSCAPE(270, false);
    
    public final int angleDegrees;
    private boolean isPortrait;

    private Orientation(int i11, boolean z11) {
        this.angleDegrees = i11;
        this.isPortrait = z11;
    }

    public static Orientation findByDegrees(int i11) {
        for (Orientation orientation : values()) {
            if (orientation.angleDegrees == i11) {
                return orientation;
            }
        }
        return null;
    }

    public boolean isPortrait() {
        return this.isPortrait;
    }
}
