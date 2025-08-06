package com.iproov.sdk.p021new;

import com.iproov.sdk.cameray.Cbreak;
import com.iproov.sdk.cameray.Cconst;

/* renamed from: com.iproov.sdk.new.do  reason: invalid class name and invalid package */
public class Cdo implements Ccase {

    /* renamed from: do  reason: not valid java name */
    private final int f1058do;

    /* renamed from: if  reason: not valid java name */
    private final Cbreak f1059if;

    public Cdo(int i11, Cbreak breakR) {
        this.f1058do = i11;
        this.f1059if = breakR;
    }

    /* renamed from: do  reason: not valid java name */
    public Cconst m1185do() {
        return Cconst.CAMERA1;
    }

    /* renamed from: for  reason: not valid java name */
    public String m1186for() {
        return "" + m1188new();
    }

    /* renamed from: if  reason: not valid java name */
    public Cbreak m1187if() {
        return this.f1059if;
    }

    /* renamed from: new  reason: not valid java name */
    public int m1188new() {
        return this.f1058do;
    }

    public String toString() {
        return "Camera1Spec{index=" + this.f1058do + ", cameraLensFacing=" + this.f1059if + '}';
    }
}
