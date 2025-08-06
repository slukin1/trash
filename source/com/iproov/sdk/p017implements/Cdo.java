package com.iproov.sdk.p017implements;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.AccelerateDecelerateInterpolator;
import d10.a;
import d10.l;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$FloatRef;

/* renamed from: com.iproov.sdk.implements.do  reason: invalid class name and invalid package */
public final class Cdo {

    /* renamed from: do  reason: not valid java name */
    public static final Cdo f930do = new Cdo();

    /* renamed from: com.iproov.sdk.implements.do$do  reason: invalid class name */
    public static final class Cdo extends AnimatorListenerAdapter {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ref$FloatRef f931do;

        public Cdo(Ref$FloatRef ref$FloatRef) {
            this.f931do = ref$FloatRef;
        }

        public void onAnimationRepeat(Animator animator) {
            this.f931do.element *= -1.0f;
        }
    }

    /* renamed from: com.iproov.sdk.implements.do$if  reason: invalid class name */
    public static final class Cif extends Lambda implements l<Float, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ float f932do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Ref$FloatRef f933for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ l<PointF, Unit> f934if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(float f11, l<? super PointF, Unit> lVar, Ref$FloatRef ref$FloatRef) {
            super(1);
            this.f932do = f11;
            this.f934if = lVar;
            this.f933for = ref$FloatRef;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m1000do(float f11) {
            float f12 = this.f932do;
            this.f934if.invoke(new PointF(((float) Math.sqrt((double) ((f12 * f12) - (f11 * f11)))) * this.f933for.element, f11));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1000do(((Number) obj).floatValue());
            return Unit.f56620a;
        }
    }

    private Cdo() {
    }

    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ ValueAnimator m991do(Cdo doVar, float f11, float f12, long j11, int i11, int i12, l lVar, int i13, Object obj) {
        return doVar.m996do(f11, f12, j11, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 1 : i12, (l<? super Float, Unit>) lVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public static final void m994for(l lVar, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        lVar.invoke(Integer.valueOf(((Integer) animatedValue).intValue()));
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public static final void m995if(l lVar, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        lVar.invoke(Float.valueOf(((Float) animatedValue).floatValue()));
    }

    /* renamed from: do  reason: not valid java name */
    public final ValueAnimator m996do(float f11, float f12, long j11, int i11, int i12, l<? super Float, Unit> lVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, f12});
        ofFloat.setDuration(j11);
        if (i11 > 0 || i11 == -1) {
            ofFloat.setRepeatCount(i11);
            ofFloat.setRepeatMode(i12);
        }
        ofFloat.addUpdateListener(new c(lVar));
        return ofFloat;
    }

    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ ValueAnimator m992do(Cdo doVar, int i11, int i12, long j11, int i13, int i14, l lVar, int i15, Object obj) {
        return doVar.m998do(i11, i12, j11, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 1 : i14, (l<? super Integer, Unit>) lVar);
    }

    /* renamed from: do  reason: not valid java name */
    public final ValueAnimator m998do(int i11, int i12, long j11, int i13, int i14, l<? super Integer, Unit> lVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setDuration(j11);
        if (i13 > 0 || i13 == -1) {
            ofInt.setRepeatCount(i13);
            ofInt.setRepeatMode(i14);
        }
        ofInt.addUpdateListener(new a(lVar));
        return ofInt;
    }

    /* renamed from: do  reason: not valid java name */
    public final ValueAnimator m999do(int i11, int i12, long j11, l<? super Integer, Unit> lVar) {
        ValueAnimator duration = ValueAnimator.ofArgb(new int[]{i11, i12}).setDuration(j11);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addUpdateListener(new b(lVar));
        return duration;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public static final void m993do(l lVar, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        lVar.invoke(Integer.valueOf(((Integer) animatedValue).intValue()));
    }

    /* renamed from: do  reason: not valid java name */
    public final ValueAnimator m997do(float f11, long j11, l<? super PointF, Unit> lVar, a<Unit> aVar) {
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = 1.0f;
        ValueAnimator valueAnimator = m996do(f11, f11 * -1.0f, j11, 2, 2, (l<? super Float, Unit>) new Cif(f11, lVar, ref$FloatRef));
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addListener(new Cdo(ref$FloatRef));
        return valueAnimator;
    }
}
