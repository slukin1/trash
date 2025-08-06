package com.iproov.sdk.p016if;

import com.iproov.sdk.p015goto.Cif;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: com.iproov.sdk.if.super  reason: invalid class name and invalid package */
public final class Csuper {

    /* renamed from: com.iproov.sdk.if.super$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f723do;

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ int[] f724if;

        static {
            int[] iArr = new int[Cfinal.values().length];
            iArr[Cfinal.NO_TARGET.ordinal()] = 1;
            iArr[Cfinal.TOO_FAR.ordinal()] = 2;
            iArr[Cfinal.TOO_CLOSE.ordinal()] = 3;
            iArr[Cfinal.TOO_BRIGHT.ordinal()] = 4;
            iArr[Cfinal.ROLL_TOO_HIGH.ordinal()] = 5;
            iArr[Cfinal.ROLL_TOO_LOW.ordinal()] = 6;
            iArr[Cfinal.YAW_TOO_HIGH.ordinal()] = 7;
            iArr[Cfinal.YAW_TOO_LOW.ordinal()] = 8;
            iArr[Cfinal.PITCH_TOO_HIGH.ordinal()] = 9;
            iArr[Cfinal.PITCH_TOO_LOW.ordinal()] = 10;
            iArr[Cfinal.READY.ordinal()] = 11;
            f723do = iArr;
            int[] iArr2 = new int[Cif.values().length];
            iArr2[Cif.TOO_FAR.ordinal()] = 1;
            iArr2[Cif.TOO_CLOSE.ordinal()] = 2;
            iArr2[Cif.TOO_BRIGHT.ordinal()] = 3;
            iArr2[Cif.ROLL_TOO_HIGH.ordinal()] = 4;
            iArr2[Cif.ROLL_TOO_LOW.ordinal()] = 5;
            iArr2[Cif.YAW_TOO_HIGH.ordinal()] = 6;
            iArr2[Cif.YAW_TOO_LOW.ordinal()] = 7;
            iArr2[Cif.PITCH_TOO_HIGH.ordinal()] = 8;
            iArr2[Cif.PITCH_TOO_LOW.ordinal()] = 9;
            iArr2[Cif.READY.ordinal()] = 10;
            f724if = iArr2;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cif m829do(Cfinal finalR) {
        switch (Cdo.f723do[finalR.ordinal()]) {
            case 1:
                return Cif.NO_FACE;
            case 2:
                return Cif.TOO_FAR;
            case 3:
                return Cif.TOO_CLOSE;
            case 4:
                return Cif.TOO_BRIGHT;
            case 5:
                return Cif.ROLL_TOO_HIGH;
            case 6:
                return Cif.ROLL_TOO_LOW;
            case 7:
                return Cif.YAW_TOO_HIGH;
            case 8:
                return Cif.YAW_TOO_LOW;
            case 9:
                return Cif.PITCH_TOO_HIGH;
            case 10:
                return Cif.PITCH_TOO_LOW;
            case 11:
                return Cif.READY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cfinal m830do(Cif ifVar) {
        switch (Cdo.f724if[ifVar.ordinal()]) {
            case 1:
                return Cfinal.TOO_FAR;
            case 2:
                return Cfinal.TOO_CLOSE;
            case 3:
                return Cfinal.TOO_BRIGHT;
            case 4:
                return Cfinal.ROLL_TOO_HIGH;
            case 5:
                return Cfinal.ROLL_TOO_LOW;
            case 6:
                return Cfinal.YAW_TOO_HIGH;
            case 7:
                return Cfinal.YAW_TOO_LOW;
            case 8:
                return Cfinal.PITCH_TOO_HIGH;
            case 9:
                return Cfinal.PITCH_TOO_LOW;
            case 10:
                return Cfinal.READY;
            default:
                return Cfinal.NO_TARGET;
        }
    }
}
