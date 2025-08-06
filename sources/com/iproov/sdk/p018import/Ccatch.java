package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.catch  reason: invalid class name and invalid package */
public class Ccatch extends Cdo {

    /* renamed from: for  reason: not valid java name */
    private Float f961for;

    /* renamed from: if  reason: not valid java name */
    private final int f962if = m1070do("y");

    public Ccatch(Context context) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_scanner);
    }

    /* renamed from: do  reason: not valid java name */
    private void m1056do(float f11) {
        Float valueOf = Float.valueOf(f11);
        this.f961for = valueOf;
        Cdo.m1063do(this.f962if, 1.0f - valueOf.floatValue());
    }

    /* renamed from: for  reason: not valid java name */
    public void m1057for() {
        if (this.f961for == null) {
            m1056do(-1.0f);
        }
    }
}
