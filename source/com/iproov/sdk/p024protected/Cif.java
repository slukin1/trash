package com.iproov.sdk.p024protected;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.iproov.sdk.protected.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    private PointF f1120do = new PointF(0.0f, 0.0f);

    /* renamed from: for  reason: not valid java name */
    private final i f1121for = LazyKt__LazyJVMKt.a(new Cdo(this));

    /* renamed from: if  reason: not valid java name */
    private float f1122if = 1.0f;

    /* renamed from: com.iproov.sdk.protected.if$do  reason: invalid class name */
    public static final class Cdo extends Lambda implements a<PathMeasure> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cif f1123do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cif ifVar) {
            super(0);
            this.f1123do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final PathMeasure invoke() {
            return new PathMeasure(this.f1123do.m1280do(), true);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private final PathMeasure m1279if() {
        return (PathMeasure) this.f1121for.getValue();
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1281do(float f11, float f12) {
        PointF pointF = this.f1120do;
        pointF.x = f11;
        pointF.y = f12;
    }

    /* renamed from: for  reason: not valid java name */
    public final boolean m1283for() {
        return this.f1120do.length() == 0.0f;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m1284if(float f11) {
        this.f1122if = f11;
    }

    /* renamed from: do  reason: not valid java name */
    public final Path m1280do() {
        float f11 = this.f1122if;
        PointF pointF = this.f1120do;
        return m1278do(f11, pointF.x, pointF.y);
    }

    /* renamed from: do  reason: not valid java name */
    public final float[] m1282do(float f11) {
        float[] fArr = {0.0f, 0.0f};
        m1279if().getPosTan(f11 * m1279if().getLength(), fArr, (float[]) null);
        return fArr;
    }

    /* renamed from: do  reason: not valid java name */
    private final Path m1278do(float f11, float f12, float f13) {
        Path path = new Path();
        float f14 = (150.0f * f11) + f12;
        float f15 = f11 * 0.0f;
        float f16 = f15 + f13;
        path.moveTo(f14, f16);
        float f17 = (300.0f * f11) + f12;
        float f18 = (83.12f * f11) + f13;
        float f19 = (190.4f * f11) + f13;
        path.cubicTo((273.57f * f11) + f12, f16, f17, f18, f17, f19);
        float f21 = (400.0f * f11) + f13;
        path.cubicTo(f17, (295.52f * f11) + f13, (245.49f * f11) + f12, f21, f14, f21);
        float f22 = f15 + f12;
        path.cubicTo((54.51f * f11) + f12, f21, f22, (297.68f * f11) + f13, f22, f19);
        path.cubicTo(f22, f18, (26.43f * f11) + f12, f16, f14, f16);
        return path;
    }
}
