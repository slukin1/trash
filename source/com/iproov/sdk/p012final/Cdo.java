package com.iproov.sdk.p012final;

import android.opengl.GLES20;
import com.iproov.sdk.p029super.Cfor;

/* renamed from: com.iproov.sdk.final.do  reason: invalid class name and invalid package */
public class Cdo extends Cfor {

    /* renamed from: case  reason: not valid java name */
    private Cif f529case;

    public Cdo(int i11, int i12, int i13, Cif ifVar) {
        super(i11, i12, i13);
        this.f529case = ifVar;
    }

    /* renamed from: if  reason: not valid java name */
    public void m614if() {
        Cif ifVar = this.f529case;
        GLES20.glViewport(ifVar.f531for, ifVar.f533new, ifVar.f530do, ifVar.f532if);
    }
}
