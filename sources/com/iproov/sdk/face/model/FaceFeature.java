package com.iproov.sdk.face.model;

import android.graphics.RectF;
import androidx.annotation.Keep;

@Keep
public class FaceFeature {
    private final RectF faceBounds;
    private final double normalizedSize;
    private final Pose pose;

    public FaceFeature(double d11, RectF rectF, Pose pose2) {
        this.normalizedSize = d11;
        this.faceBounds = rectF;
        this.pose = pose2;
    }

    public RectF getFaceBounds() {
        return this.faceBounds;
    }

    public double getNormalizedSize() {
        return this.normalizedSize;
    }

    public Pose getPose() {
        return this.pose;
    }

    public String toString() {
        return "Face[" + this.normalizedSize + "] " + this.faceBounds.toString() + " pose " + this.pose;
    }
}
