package com.iproov.sdk.p010else;

import com.iproov.sdk.p003case.Cnew;

/* renamed from: com.iproov.sdk.else.do  reason: invalid class name and invalid package */
public final class Cdo {

    /* renamed from: do  reason: not valid java name */
    private char f510do;

    public Cdo(char c11) {
        this.f510do = c11;
    }

    /* renamed from: if  reason: not valid java name */
    private String m581if() {
        char c11 = this.f510do;
        if (c11 == '0') {
            return "⬛️";
        }
        if (c11 == '1') {
            return "⬜️";
        }
        if (c11 == 'b') {
            return "🟦";
        }
        if (c11 == 'c') {
            return "🎽";
        }
        if (c11 == 'g') {
            return "🟩";
        }
        if (c11 == 'm') {
            return "🟪";
        }
        if (c11 == 'r') {
            return "🟥";
        }
        if (c11 != 'y') {
            return null;
        }
        return "🟨";
    }

    /* renamed from: do  reason: not valid java name */
    public int m582do() {
        return Cnew.f170do.m241do(this.f510do);
    }

    public String toString() {
        return m581if() + this.f510do;
    }
}
