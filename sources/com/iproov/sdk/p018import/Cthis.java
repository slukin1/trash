package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;

/* renamed from: com.iproov.sdk.import.this  reason: invalid class name and invalid package */
public class Cthis extends Cdo {

    /* renamed from: for  reason: not valid java name */
    private float f982for;

    /* renamed from: if  reason: not valid java name */
    private int f983if = m1070do("threshold");

    /* renamed from: new  reason: not valid java name */
    private int f984new = m1070do("uWindow");

    /* renamed from: try  reason: not valid java name */
    private float[] f985try;

    public Cthis(Context context, float f11, float[] fArr) {
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_inclusion);
        this.f982for = f11;
        this.f985try = fArr;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1089for() {
        Cdo.m1063do(this.f983if, this.f982for);
        Cdo.m1067if(this.f984new, this.f985try);
    }
}
