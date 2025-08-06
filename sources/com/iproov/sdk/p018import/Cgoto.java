package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.goto  reason: invalid class name and invalid package */
public class Cgoto extends Cdo {

    /* renamed from: for  reason: not valid java name */
    private final float f975for;

    /* renamed from: if  reason: not valid java name */
    private final int f976if = m1070do("h");

    public Cgoto(Context context, float f11) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_horizontal_blur);
        this.f975for = f11;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1083for() {
        Cdo.m1063do(this.f976if, this.f975for);
    }
}
