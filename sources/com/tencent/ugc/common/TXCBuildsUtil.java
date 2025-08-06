package com.tencent.ugc.common;

import android.content.Context;
import com.tencent.ugc.beauty.gpufilters.TXCGPUMotionBase;
import com.tencent.ugc.videobase.base.AIDetectListener;

public class TXCBuildsUtil {
    public static final int BUILDTYPE = 0;
    public static final int BUILD_NORMAL = 0;
    public static final int BUILD_PITU = 1;
    public static volatile boolean _PituInit;

    public static TXCGPUMotionBase createMotionFilter(Context context) {
        return new TXCGPUMotionBase() {
            public final boolean canBeSkipped() {
                return true;
            }

            public final void setAIDetectListener(AIDetectListener aIDetectListener) {
            }

            public final void setHomeOrientation(int i11) {
            }

            public final void setMotionMute(boolean z11) {
            }

            public final void setMotionPath(String str) {
            }

            public final void setScalableCosmeticTypeLevel(TXCGPUMotionBase.ScalableCosmeticType scalableCosmeticType, int i11) {
            }

            public final void setTextureMirrored(boolean z11) {
            }
        };
    }

    public static String getPituSDKVersion() {
        return "";
    }

    public static boolean initMotionSdk(Context context) {
        return false;
    }
}
