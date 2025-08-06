package com.iproov.sdk.cameray;

import android.content.Context;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.p021new.Ccase;
import com.iproov.sdk.p021new.Cgoto;
import com.iproov.sdk.p025public.Cif;
import com.iproov.sdk.p035try.Cnew;
import java.util.Arrays;

/* renamed from: com.iproov.sdk.cameray.class  reason: invalid class name */
public class Cclass {

    /* renamed from: do  reason: not valid java name */
    private final Cif f60do;

    /* renamed from: for  reason: not valid java name */
    private final Cgoto f61for;

    /* renamed from: if  reason: not valid java name */
    private final Ctry.Cdo f62if;

    /* renamed from: new  reason: not valid java name */
    private final Cbreak[] f63new;

    public Cclass(Cif ifVar, Ctry.Cdo doVar, Cgoto gotoR, Cbreak... breakArr) {
        this.f60do = ifVar;
        this.f62if = doVar;
        this.f61for = gotoR;
        this.f63new = breakArr;
    }

    /* renamed from: do  reason: not valid java name */
    public Ctry m96do(Context context, boolean z11) throws CameraException {
        Celse elseR = Cthis.m198do();
        try {
            Ccatch catchR = elseR.m125do(context);
            if (catchR != null) {
                Cfinal finalR = elseR.m126do(context, m95do(this.f60do, catchR));
                Cbreak[] breakArr = this.f60do.m1296do() == null ? this.f63new : new Cbreak[]{this.f60do.m1296do()};
                if (finalR != null) {
                    Ccase caseR = finalR.m129do(breakArr);
                    if (caseR != null) {
                        return elseR.m127do(context, z11, caseR, this.f62if, new Cnew(), this.f61for);
                    }
                    throw new CameraException(context, "No cameras available for lensFacing: " + Arrays.toString(breakArr) + " from: " + finalR.toString());
                }
                throw new CameraException(context, "No cameras available");
            }
            throw new CameraException(context, "No cameras available");
        } catch (Ccase e11) {
            e11.printStackTrace();
            throw new CameraException(context, e11.getLocalizedMessage());
        }
    }

    /* renamed from: do  reason: not valid java name */
    private Cconst m95do(Cif ifVar, Ccatch catchR) {
        if (ifVar.m1299goto()) {
            return ifVar.m1300if();
        }
        return catchR.m94do(Ccatch.CAMERA2_LIMITED) ? Cconst.CAMERA2 : Cconst.CAMERA1;
    }
}
