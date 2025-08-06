package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.case  reason: invalid class name and invalid package */
public class Ccase extends Cdo {

    /* renamed from: for  reason: not valid java name */
    private final int f957for = m1070do("lineRGB");

    /* renamed from: if  reason: not valid java name */
    private final int f958if = m1070do("nextRGB");

    /* renamed from: new  reason: not valid java name */
    private float[] f959new;

    /* renamed from: try  reason: not valid java name */
    private float[] f960try;

    public Ccase(Context context, float[] fArr, float[] fArr2) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_flashing);
        this.f959new = fArr;
        this.f960try = fArr2;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1053do(float[] fArr) {
        this.f960try = fArr;
        Cdo.m1066for(this.f957for, fArr);
    }

    /* renamed from: for  reason: not valid java name */
    public void m1054for() {
        m1053do(this.f960try);
        m1055if(this.f959new);
    }

    /* renamed from: if  reason: not valid java name */
    public void m1055if(float[] fArr) {
        this.f959new = fArr;
        Cdo.m1066for(this.f958if, fArr);
    }
}
