package com.iproov.sdk.p026return;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p015goto.Cif;
import com.iproov.sdk.p021new.Cfor;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.return.new  reason: invalid class name and invalid package */
public final class Cnew {

    /* renamed from: break  reason: not valid java name */
    public static final Cdo f1677break = new Cdo((r) null);

    /* renamed from: catch  reason: not valid java name */
    private static int f1678catch;

    /* renamed from: case  reason: not valid java name */
    private final int f1679case;

    /* renamed from: do  reason: not valid java name */
    private final Cfor f1680do;

    /* renamed from: else  reason: not valid java name */
    private final boolean f1681else;

    /* renamed from: for  reason: not valid java name */
    private final FaceFeature f1682for;

    /* renamed from: goto  reason: not valid java name */
    private final int f1683goto;

    /* renamed from: if  reason: not valid java name */
    private final Bitmap f1684if;

    /* renamed from: new  reason: not valid java name */
    private final RectF f1685new;

    /* renamed from: this  reason: not valid java name */
    private final int f1686this;

    /* renamed from: try  reason: not valid java name */
    private final Cif f1687try;

    /* renamed from: com.iproov.sdk.return.new$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    public Cnew(Cfor forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, Cif ifVar, int i11, boolean z11, int i12) {
        this.f1680do = forR;
        this.f1684if = bitmap;
        this.f1682for = faceFeature;
        this.f1685new = rectF;
        this.f1687try = ifVar;
        this.f1679case = i11;
        this.f1681else = z11;
        this.f1683goto = i12;
        int i13 = f1678catch;
        f1678catch = i13 + 1;
        this.f1686this = i13;
    }

    /* renamed from: case  reason: not valid java name */
    public final int m1646case() {
        return this.f1683goto;
    }

    /* renamed from: do  reason: not valid java name */
    public final Bitmap m1647do() {
        return this.f1684if;
    }

    /* renamed from: else  reason: not valid java name */
    public final int m1648else() {
        return this.f1686this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cnew)) {
            return false;
        }
        Cnew newR = (Cnew) obj;
        return x.b(this.f1680do, newR.f1680do) && x.b(this.f1684if, newR.f1684if) && x.b(this.f1682for, newR.f1682for) && x.b(this.f1685new, newR.f1685new) && this.f1687try == newR.f1687try && this.f1679case == newR.f1679case && this.f1681else == newR.f1681else && this.f1683goto == newR.f1683goto;
    }

    /* renamed from: for  reason: not valid java name */
    public final FaceFeature m1649for() {
        return this.f1682for;
    }

    /* renamed from: goto  reason: not valid java name */
    public final boolean m1650goto() {
        return this.f1681else;
    }

    public int hashCode() {
        int hashCode = ((this.f1680do.hashCode() * 31) + this.f1684if.hashCode()) * 31;
        FaceFeature faceFeature = this.f1682for;
        int hashCode2 = (((((((hashCode + (faceFeature == null ? 0 : faceFeature.hashCode())) * 31) + this.f1685new.hashCode()) * 31) + this.f1687try.hashCode()) * 31) + this.f1679case) * 31;
        boolean z11 = this.f1681else;
        if (z11) {
            z11 = true;
        }
        return ((hashCode2 + (z11 ? 1 : 0)) * 31) + this.f1683goto;
    }

    /* renamed from: if  reason: not valid java name */
    public final int m1651if() {
        return this.f1679case;
    }

    /* renamed from: new  reason: not valid java name */
    public final RectF m1652new() {
        return this.f1685new;
    }

    public String toString() {
        return "CandidateLivenessFrame(frame=" + this.f1680do + ", bitmap=" + this.f1684if + ", faceFeature=" + this.f1682for + ", faceProportionalRectF=" + this.f1685new + ", previewState=" + this.f1687try + ", checkpointNumber=" + this.f1679case + ", isLastCheckpoint=" + this.f1681else + ", frameNumber=" + this.f1683goto + ')';
    }

    /* renamed from: try  reason: not valid java name */
    public final Cfor m1653try() {
        return this.f1680do;
    }
}
