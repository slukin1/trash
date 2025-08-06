package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import com.iproov.sdk.p029super.Cif;
import com.iproov.sdk.p032throw.Cdo;

/* renamed from: com.iproov.sdk.import.try  reason: invalid class name and invalid package */
public class Ctry extends Cdo {

    /* renamed from: case  reason: not valid java name */
    private static final float[] f994case = {0.1f, 0.1f};

    /* renamed from: else  reason: not valid java name */
    private static final float[] f995else = {3.0f, 3.0f};

    /* renamed from: for  reason: not valid java name */
    private final int f996for;

    /* renamed from: if  reason: not valid java name */
    private final int f997if;

    /* renamed from: new  reason: not valid java name */
    private final float[] f998new = {0.0f, 0.0f};

    /* renamed from: try  reason: not valid java name */
    private final Cdo f999try;

    public Ctry(Context context) {
        Cdo doVar = new Cdo(1000, 1200, f994case, f995else);
        this.f999try = doVar;
        this.f966do = Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_fade);
        this.f997if = m1070do(TtmlNode.TAG_P);
        this.f996for = m1070do("q");
        doVar.m1900if();
    }

    /* renamed from: do  reason: not valid java name */
    public void m1091do(float f11, float f12) {
        float[] fArr = this.f998new;
        fArr[0] = f11;
        fArr[1] = f12;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1092for() {
        float[] fArr = this.f999try.m1898do();
        Cdo.m1067if(this.f997if, this.f998new);
        Cdo.m1067if(this.f996for, fArr);
    }

    /* renamed from: new  reason: not valid java name */
    public void m1093new() {
        this.f999try.m1899for();
    }
}
