package com.tencent.ugc;

import com.sumsub.sns.internal.ml.autocapture.a;

public class UGCTransitionRules {
    public static final int DEFAULT_IMAGE_HEIGHT = 1280;
    public static final int DEFAULT_IMAGE_WIDTH = 720;

    public static long getMotionDurationMs(int i11) {
        switch (i11) {
            case 3:
                return 1000;
            case 4:
            case 5:
                return 2500;
            case 6:
                return a.f34923p;
            default:
                return 500;
        }
    }

    public static long getStayDurationMs(int i11) {
        switch (i11) {
            case 3:
            case 6:
                return a.f34923p;
            case 4:
            case 5:
                return 100;
            default:
                return 1000;
        }
    }
}
