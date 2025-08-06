package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.final  reason: invalid class name and invalid package */
public class Cfinal extends Cdo {

    /* renamed from: for  reason: not valid java name */
    private final float f971for;

    /* renamed from: if  reason: not valid java name */
    private final int f972if = m1070do("threshold");

    /* renamed from: new  reason: not valid java name */
    private final int f973new = m1070do("uWindow");

    /* renamed from: try  reason: not valid java name */
    private final float[] f974try;

    public Cfinal(Context context, float f11, float[] fArr) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_sobel);
        this.f971for = f11;
        this.f974try = fArr;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1081for() {
        Cdo.m1063do(this.f972if, this.f971for);
        Cdo.m1067if(this.f973new, this.f974try);
    }
}
