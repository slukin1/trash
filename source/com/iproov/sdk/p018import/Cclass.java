package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.class  reason: invalid class name and invalid package */
public class Cclass extends Cdo {

    /* renamed from: for  reason: not valid java name */
    private final float[] f963for;

    /* renamed from: if  reason: not valid java name */
    private final int f964if = m1070do("blend");

    public Cclass(Context context, float f11) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_crop, R.raw.fragment_shade);
        this.f963for = new float[]{1.0f, 1.0f, 1.0f, f11};
    }

    /* renamed from: new  reason: not valid java name */
    private void m1058new() {
        Cdo.m1068new(this.f964if, this.f963for);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1059do(float f11) {
        this.f963for[3] = f11;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1060for() {
        m1058new();
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m1061if() {
        return true;
    }
}
