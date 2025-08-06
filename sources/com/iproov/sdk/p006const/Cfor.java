package com.iproov.sdk.p006const;

import com.iproov.sdk.face.model.Pose;
import com.iproov.sdk.p015goto.Cif;

/* renamed from: com.iproov.sdk.const.for  reason: invalid class name and invalid package */
public class Cfor {

    /* renamed from: do  reason: not valid java name */
    private final Float f220do;

    /* renamed from: for  reason: not valid java name */
    private final Float f221for;

    /* renamed from: if  reason: not valid java name */
    private final Float f222if;

    public Cfor(Float f11, Float f12, Float f13) {
        this.f220do = f11;
        this.f222if = f12;
        this.f221for = f13;
    }

    /* renamed from: do  reason: not valid java name */
    public Cif m290do(Pose pose) {
        Float f11 = this.f220do;
        if (f11 != null) {
            if (pose.roll > f11.floatValue()) {
                return Cif.ROLL_TOO_HIGH;
            }
            if ((-pose.roll) > this.f220do.floatValue()) {
                return Cif.ROLL_TOO_LOW;
            }
        }
        Float f12 = this.f222if;
        if (f12 != null) {
            if (pose.yaw > f12.floatValue()) {
                return Cif.YAW_TOO_HIGH;
            }
            if ((-pose.yaw) > this.f222if.floatValue()) {
                return Cif.YAW_TOO_LOW;
            }
        }
        Float f13 = this.f221for;
        if (f13 == null) {
            return null;
        }
        if (pose.pitch > f13.floatValue()) {
            return Cif.PITCH_TOO_HIGH;
        }
        if ((-pose.pitch) > this.f221for.floatValue()) {
            return Cif.PITCH_TOO_LOW;
        }
        return null;
    }
}
