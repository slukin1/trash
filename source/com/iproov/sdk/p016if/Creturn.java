package com.iproov.sdk.p016if;

import com.iproov.sdk.p015goto.Cif;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: com.iproov.sdk.if.return  reason: invalid class name and invalid package */
public final class Creturn {

    /* renamed from: com.iproov.sdk.if.return$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f710do;

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ int[] f711if;

        static {
            int[] iArr = new int[Cpublic.values().length];
            iArr[Cpublic.HAS_TARGET.ordinal()] = 1;
            iArr[Cpublic.NO_TARGET.ordinal()] = 2;
            iArr[Cpublic.FINISHED.ordinal()] = 3;
            iArr[Cpublic.TOO_CLOSE.ordinal()] = 4;
            iArr[Cpublic.TOO_FAR.ordinal()] = 5;
            f710do = iArr;
            int[] iArr2 = new int[Cif.values().length];
            iArr2[Cif.FACE_PATH.ordinal()] = 1;
            iArr2[Cif.NO_FACE_PATH.ordinal()] = 2;
            iArr2[Cif.END_FACE_PATH.ordinal()] = 3;
            iArr2[Cif.TOO_CLOSE_FACE_PATH.ordinal()] = 4;
            iArr2[Cif.TOO_FAR_FACE_PATH.ordinal()] = 5;
            f711if = iArr2;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cif m817do(Cpublic publicR) {
        int i11 = Cdo.f710do[publicR.ordinal()];
        if (i11 == 1) {
            return Cif.FACE_PATH;
        }
        if (i11 == 2) {
            return Cif.NO_FACE_PATH;
        }
        if (i11 == 3) {
            return Cif.END_FACE_PATH;
        }
        if (i11 == 4) {
            return Cif.TOO_CLOSE_FACE_PATH;
        }
        if (i11 == 5) {
            return Cif.TOO_FAR_FACE_PATH;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: do  reason: not valid java name */
    public static final Cpublic m818do(Cif ifVar) {
        int i11 = Cdo.f711if[ifVar.ordinal()];
        if (i11 == 1) {
            return Cpublic.HAS_TARGET;
        }
        if (i11 == 2) {
            return Cpublic.NO_TARGET;
        }
        if (i11 == 3) {
            return Cpublic.FINISHED;
        }
        if (i11 == 4) {
            return Cpublic.TOO_CLOSE;
        }
        if (i11 != 5) {
            return Cpublic.NO_TARGET;
        }
        return Cpublic.TOO_FAR;
    }
}
