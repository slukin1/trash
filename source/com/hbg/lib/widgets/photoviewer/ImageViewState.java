package com.hbg.lib.widgets.photoviewer;

import android.graphics.PointF;
import java.io.Serializable;

public class ImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f11, PointF pointF, int i11) {
        this.scale = f11;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i11;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
