package com.iproov.sdk.face.model;

import androidx.annotation.Keep;

@Keep
public class Pose {
    public final float pitch;
    public final float roll;
    public final float yaw;

    public Pose(float f11, float f12, float f13) {
        this.roll = f11;
        this.yaw = f12;
        this.pitch = f13;
    }

    public String toString() {
        return "roll " + this.roll + " pitch " + this.pitch + " yaw " + this.yaw;
    }
}
