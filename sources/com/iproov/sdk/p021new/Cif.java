package com.iproov.sdk.p021new;

import com.iproov.sdk.cameray.Cbreak;
import com.iproov.sdk.cameray.Cconst;

/* renamed from: com.iproov.sdk.new.if  reason: invalid class name and invalid package */
public class Cif implements Ccase {

    /* renamed from: do  reason: not valid java name */
    private final int f1060do;

    /* renamed from: for  reason: not valid java name */
    private final Cbreak f1061for;

    /* renamed from: if  reason: not valid java name */
    private final String f1062if;

    public Cif(int i11, Cbreak breakR, String str) {
        this.f1060do = i11;
        this.f1061for = breakR;
        this.f1062if = str;
    }

    /* renamed from: do  reason: not valid java name */
    public Cconst m1201do() {
        return Cconst.CAMERA2;
    }

    /* renamed from: for  reason: not valid java name */
    public String m1202for() {
        return this.f1062if;
    }

    /* renamed from: if  reason: not valid java name */
    public Cbreak m1203if() {
        return this.f1061for;
    }

    /* renamed from: new  reason: not valid java name */
    public int m1204new() {
        return this.f1060do;
    }

    public String toString() {
        return "Camera2Spec{id='" + this.f1062if + '\'' + ", cameraLensFacing=" + this.f1061for + '}';
    }
}
