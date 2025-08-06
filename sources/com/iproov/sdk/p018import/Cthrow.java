package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.throw  reason: invalid class name and invalid package */
public class Cthrow extends Cdo {

    /* renamed from: case  reason: not valid java name */
    private final float f986case;

    /* renamed from: else  reason: not valid java name */
    private final float f987else;

    /* renamed from: for  reason: not valid java name */
    private final int f988for = m1070do("lowerThreshold");

    /* renamed from: goto  reason: not valid java name */
    private final float f989goto;

    /* renamed from: if  reason: not valid java name */
    private final int f990if = m1070do("upperThreshold");

    /* renamed from: new  reason: not valid java name */
    private final int f991new = m1070do("texelHeight");

    /* renamed from: this  reason: not valid java name */
    private final float f992this;

    /* renamed from: try  reason: not valid java name */
    private final int f993try = m1070do("texelWidth");

    public Cthrow(Context context, float f11, float f12, float f13, float f14) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_supression);
        this.f986case = f11;
        this.f987else = f12;
        this.f992this = f13;
        this.f989goto = f14;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1090for() {
        Cdo.m1063do(this.f990if, this.f986case);
        Cdo.m1063do(this.f988for, this.f987else);
        Cdo.m1063do(this.f991new, this.f989goto);
        Cdo.m1063do(this.f993try, this.f992this);
    }
}
