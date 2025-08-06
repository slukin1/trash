package com.tencent.ugc.beauty.gpufilters;

import com.tencent.ugc.videobase.base.AIDetectListener;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;

public abstract class TXCGPUMotionBase extends TXCGPUImageFilter {

    public enum ScalableCosmeticType {
        FACE_SLIM,
        EYE_SCALE,
        FACE_V_SHAPE,
        FACE_SHORT,
        FACE_NARROW,
        CHIN_SCALE,
        NOSE_SLIM,
        FOREHEAD,
        EYE_DISTANCE,
        EYE_ANGLE,
        MOUTH_SHAPE,
        NOSE_WING,
        NOSE_POSITION,
        LIPS_THICKNESS,
        NATURE,
        CUTE,
        MELON,
        BASIC3,
        EYE_LIGHTEN,
        TOOTH_WHITEN,
        REMOVE_WRINKLES,
        REMOVE_POUNCH,
        REMOVE_SMILE_LINES
    }

    public abstract void setAIDetectListener(AIDetectListener aIDetectListener);

    public abstract void setHomeOrientation(int i11);

    public abstract void setMotionMute(boolean z11);

    public abstract void setMotionPath(String str);

    public abstract void setScalableCosmeticTypeLevel(ScalableCosmeticType scalableCosmeticType, int i11);

    public abstract void setTextureMirrored(boolean z11);
}
