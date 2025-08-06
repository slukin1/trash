package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::manager")
public class TXBeautyManagerImpl implements TXBeautyManager {
    private long mNativeBeautyManager = 0;

    public TXBeautyManagerImpl(long j11) {
        this.mNativeBeautyManager = j11;
    }

    private static native void nativeDestroy(long j11);

    private static native void nativeEnableSharpnessEnhancement(long j11, boolean z11);

    private static native void nativeSetBeautyLevel(long j11, float f11);

    private static native void nativeSetBeautyStyle(long j11, int i11);

    private static native int nativeSetChinLevel(long j11, float f11);

    private static native int nativeSetEyeAngleLevel(long j11, float f11);

    private static native int nativeSetEyeDistanceLevel(long j11, float f11);

    private static native int nativeSetEyeLightenLevel(long j11, float f11);

    private static native int nativeSetEyeScaleLevel(long j11, float f11);

    private static native int nativeSetFaceBeautyLevel(long j11, float f11);

    private static native int nativeSetFaceNarrowLevel(long j11, float f11);

    private static native int nativeSetFaceShortLevel(long j11, float f11);

    private static native int nativeSetFaceSlimLevel(long j11, float f11);

    private static native int nativeSetFaceVLevel(long j11, float f11);

    private static native void nativeSetFilter(long j11, Bitmap bitmap);

    private static native void nativeSetFilterStrength(long j11, float f11);

    private static native int nativeSetForeheadLevel(long j11, float f11);

    private static native int nativeSetGreenScreenFile(long j11, String str);

    private static native int nativeSetLipsThicknessLevel(long j11, float f11);

    private static native void nativeSetMotionMute(long j11, boolean z11);

    private static native void nativeSetMotionTmpl(long j11, String str);

    private static native int nativeSetMouthShapeLevel(long j11, float f11);

    private static native int nativeSetNosePositionLevel(long j11, float f11);

    private static native int nativeSetNoseSlimLevel(long j11, float f11);

    private static native int nativeSetNoseWingLevel(long j11, float f11);

    private static native int nativeSetPounchRemoveLevel(long j11, float f11);

    private static native void nativeSetRuddyLevel(long j11, float f11);

    private static native int nativeSetSmileLinesRemoveLevel(long j11, float f11);

    private static native int nativeSetToothWhitenLevel(long j11, float f11);

    private static native void nativeSetWhitenessLevel(long j11, float f11);

    private static native int nativeSetWrinkleRemoveLevel(long j11, float f11);

    public void clear() {
        this.mNativeBeautyManager = 0;
    }

    public void enableSharpnessEnhancement(boolean z11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeEnableSharpnessEnhancement(j11, z11);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeBeautyManager = 0;
        }
    }

    public void setBeautyLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetBeautyLevel(j11, f11);
        }
    }

    public void setBeautyStyle(int i11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetBeautyStyle(j11, i11);
        }
    }

    public int setChinLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetChinLevel(j11, f11);
        return 0;
    }

    public int setEyeAngleLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetEyeAngleLevel(j11, f11);
        return 0;
    }

    public int setEyeDistanceLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetEyeDistanceLevel(j11, f11);
        return 0;
    }

    public int setEyeLightenLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetEyeLightenLevel(j11, f11);
        return 0;
    }

    public int setEyeScaleLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetEyeScaleLevel(j11, f11);
        return 0;
    }

    public int setFaceBeautyLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetFaceBeautyLevel(j11, f11);
        return 0;
    }

    public int setFaceNarrowLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetFaceNarrowLevel(j11, f11);
        return 0;
    }

    public int setFaceShortLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetFaceShortLevel(j11, f11);
        return 0;
    }

    public int setFaceSlimLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetFaceSlimLevel(j11, f11);
        return 0;
    }

    public int setFaceVLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetFaceVLevel(j11, f11);
        return 0;
    }

    public void setFilter(Bitmap bitmap) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetFilter(j11, bitmap);
        }
    }

    public void setFilterStrength(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetFilterStrength(j11, f11);
        }
    }

    public int setForeheadLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetForeheadLevel(j11, f11);
        return 0;
    }

    public int setGreenScreenFile(String str) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetGreenScreenFile(j11, str);
        return 0;
    }

    public int setLipsThicknessLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetLipsThicknessLevel(j11, f11);
        return 0;
    }

    public void setMotionMute(boolean z11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetMotionMute(j11, z11);
        }
    }

    public void setMotionTmpl(String str) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetMotionTmpl(j11, str);
        }
    }

    public int setMouthShapeLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetMouthShapeLevel(j11, f11);
        return 0;
    }

    public int setNosePositionLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetNosePositionLevel(j11, f11);
        return 0;
    }

    public int setNoseSlimLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetNoseSlimLevel(j11, f11);
        return 0;
    }

    public int setNoseWingLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetNoseWingLevel(j11, f11);
        return 0;
    }

    public int setPounchRemoveLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetPounchRemoveLevel(j11, f11);
        return 0;
    }

    public void setRuddyLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetRuddyLevel(j11, f11);
        }
    }

    public int setSmileLinesRemoveLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetSmileLinesRemoveLevel(j11, f11);
        return 0;
    }

    public int setToothWhitenLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetToothWhitenLevel(j11, f11);
        return 0;
    }

    public void setWhitenessLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 != 0) {
            nativeSetWhitenessLevel(j11, f11);
        }
    }

    public int setWrinkleRemoveLevel(float f11) {
        long j11 = this.mNativeBeautyManager;
        if (j11 == 0) {
            return 0;
        }
        nativeSetWrinkleRemoveLevel(j11, f11);
        return 0;
    }
}
