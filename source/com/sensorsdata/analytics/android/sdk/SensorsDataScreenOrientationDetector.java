package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.view.OrientationEventListener;

public class SensorsDataScreenOrientationDetector extends OrientationEventListener {
    private int mCurrentOrientation;

    public SensorsDataScreenOrientationDetector(Context context, int i11) {
        super(context, i11);
    }

    public String getOrientation() {
        int i11 = this.mCurrentOrientation;
        if (i11 == 0 || i11 == 180) {
            return "portrait";
        }
        if (i11 == 90 || i11 == 270) {
            return "landscape";
        }
        return null;
    }

    public void onOrientationChanged(int i11) {
        if (i11 != -1) {
            if (i11 < 45 || i11 > 315) {
                this.mCurrentOrientation = 0;
            } else if (i11 > 45 && i11 < 135) {
                this.mCurrentOrientation = 90;
            } else if (i11 > 135 && i11 < 225) {
                this.mCurrentOrientation = 180;
            } else if (i11 > 225 && i11 < 315) {
                this.mCurrentOrientation = 270;
            }
        }
    }
}
