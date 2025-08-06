package com.tencent.liteav.beauty;

import android.graphics.Bitmap;

public interface TXBeautyManager {
    public static final int TXBeautyStyleNature = 1;
    public static final int TXBeautyStylePitu = 2;
    public static final int TXBeautyStyleSmooth = 0;

    void enableSharpnessEnhancement(boolean z11);

    void setBeautyLevel(float f11);

    void setBeautyStyle(int i11);

    int setChinLevel(float f11);

    int setEyeAngleLevel(float f11);

    int setEyeDistanceLevel(float f11);

    int setEyeLightenLevel(float f11);

    int setEyeScaleLevel(float f11);

    int setFaceBeautyLevel(float f11);

    int setFaceNarrowLevel(float f11);

    int setFaceShortLevel(float f11);

    int setFaceSlimLevel(float f11);

    int setFaceVLevel(float f11);

    void setFilter(Bitmap bitmap);

    void setFilterStrength(float f11);

    int setForeheadLevel(float f11);

    int setGreenScreenFile(String str);

    int setLipsThicknessLevel(float f11);

    void setMotionMute(boolean z11);

    void setMotionTmpl(String str);

    int setMouthShapeLevel(float f11);

    int setNosePositionLevel(float f11);

    int setNoseSlimLevel(float f11);

    int setNoseWingLevel(float f11);

    int setPounchRemoveLevel(float f11);

    void setRuddyLevel(float f11);

    int setSmileLinesRemoveLevel(float f11);

    int setToothWhitenLevel(float f11);

    void setWhitenessLevel(float f11);

    int setWrinkleRemoveLevel(float f11);
}
