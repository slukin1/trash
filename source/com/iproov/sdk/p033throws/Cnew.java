package com.iproov.sdk.p033throws;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p015goto.Cdo;
import com.iproov.sdk.p015goto.Cif;
import com.iproov.sdk.p021new.Cgoto;
import com.iproov.sdk.p021new.Cthis;
import com.iproov.sdk.p033throws.Cfor;
import java.util.Objects;

/* renamed from: com.iproov.sdk.throws.new  reason: invalid class name and invalid package */
public class Cnew implements Cfor {

    /* renamed from: case  reason: not valid java name */
    private boolean f2072case = false;

    /* renamed from: do  reason: not valid java name */
    private final Cfor.Cdo f2073do;

    /* renamed from: else  reason: not valid java name */
    private long f2074else = 0;

    /* renamed from: for  reason: not valid java name */
    private final Cconst f2075for;

    /* renamed from: if  reason: not valid java name */
    private final Ctry f2076if;

    /* renamed from: new  reason: not valid java name */
    private Bitmap f2077new;

    /* renamed from: try  reason: not valid java name */
    private boolean f2078try = false;

    public Cnew(Context context, Cconst constR, Celse elseR, Cfor.Cdo doVar, Cgoto gotoR) {
        this.f2076if = new Ctry(context, elseR, gotoR);
        this.f2075for = constR;
        this.f2073do = doVar;
        Objects.toString(constR);
    }

    /* renamed from: for  reason: not valid java name */
    private Cdo m1983for(Bitmap bitmap, FaceFeature faceFeature) throws Ccase {
        long currentTimeMillis = System.currentTimeMillis() - this.f2074else;
        if (this.f2078try) {
            Cdo doVar = m1984if(bitmap, faceFeature);
            if (faceFeature == null) {
                this.f2073do.m1974do(false);
            } else if (m1986if(currentTimeMillis)) {
                this.f2072case = true;
                this.f2073do.m1974do(false);
            }
            return doVar;
        } else if (faceFeature == null && !this.f2072case && !m1982do(currentTimeMillis)) {
            return null;
        } else {
            this.f2072case = false;
            this.f2073do.m1973case();
            return null;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private Cdo m1984if(Bitmap bitmap, FaceFeature faceFeature) throws Ccase {
        if (faceFeature == null) {
            this.f2076if.m2023do((Double) null);
            this.f2076if.m2022do((Cif) null);
            this.f2077new = null;
        } else {
            RectF faceBounds = faceFeature.getFaceBounds();
            float f11 = faceBounds.right;
            float f12 = faceBounds.left;
            float f13 = f11 - f12;
            int i11 = (int) ((((double) f13) * 0.6d) / 2.0d);
            float f14 = faceBounds.bottom;
            float f15 = faceBounds.top;
            float f16 = f14 - f15;
            Bitmap bitmap2 = Cgoto.m1977do(bitmap, ((int) f12) + i11, ((int) f15) + i11, ((int) f13) - (i11 * 2), ((int) f16) - (((int) ((((double) f16) * 0.4d) / 2.0d)) * 2));
            this.f2077new = bitmap2;
            Cif ifVar = new Cif(bitmap2);
            this.f2076if.m2023do(Double.valueOf(faceFeature.getNormalizedSize()));
            this.f2076if.m2022do(ifVar);
        }
        Cthis thisR = this.f2076if.m2020do(m1981do());
        m1990do(thisR);
        Cif ifVar2 = Cif.READY;
        if (faceFeature == null) {
            ifVar2 = Cif.NO_FACE;
        } else if (this.f2076if.m2019const()) {
            ifVar2 = Cif.TOO_BRIGHT;
        } else if (this.f2076if.m2028super()) {
            ifVar2 = Cif.TOO_FAR;
        } else if (this.f2076if.m2026final()) {
            ifVar2 = Cif.TOO_CLOSE;
        }
        return new Cdo(ifVar2, thisR);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1989do(Cthis thisR) {
        this.f2076if.m2021do(thisR);
    }

    /* renamed from: goto  reason: not valid java name */
    public Bitmap m1993goto() {
        return this.f2077new;
    }

    /* renamed from: new  reason: not valid java name */
    public final double m1994new() {
        return this.f2076if.m2017break();
    }

    /* renamed from: do  reason: not valid java name */
    public void m1988do(float f11) {
        this.f2076if.m2024do(Float.valueOf(f11));
    }

    /* renamed from: do  reason: not valid java name */
    public Cdo m1987do(Bitmap bitmap, FaceFeature faceFeature) throws Ccase {
        return m1981do() ? m1983for(bitmap, faceFeature) : m1984if(bitmap, faceFeature);
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m1981do() {
        return this.f2075for == Cconst.CAMERA1;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1991do(boolean z11) {
        if (m1981do()) {
            this.f2078try = z11;
            this.f2074else = System.currentTimeMillis();
            if (z11) {
                m1985if();
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m1982do(long j11) throws Ccase {
        return this.f2076if.m2025do(j11);
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized void m1990do(Cthis thisR) {
        thisR.f38881a = this.f2075for != Cconst.CAMERA1;
    }

    /* renamed from: for  reason: not valid java name */
    public String m1992for() {
        return this.f2076if.m2018case();
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m1986if(long j11) throws Ccase {
        return this.f2076if.m2027if(j11);
    }

    /* renamed from: if  reason: not valid java name */
    private void m1985if() {
        this.f2076if.m2029throw();
    }
}
