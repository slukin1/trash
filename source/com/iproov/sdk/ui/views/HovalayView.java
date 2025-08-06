package com.iproov.sdk.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import com.iproov.sdk.R;
import com.iproov.sdk.p017implements.Cwhile;
import d10.a;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003#$%B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010 B+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/iproov/sdk/ui/views/HovalayView;", "Landroid/view/ViewGroup;", "", "getMinimumTopSpaceForHovalInPixels", "", "getStatusBarHeight", "color", "", "setHovalColor", "", "portrait", "setPortraitMode", "setForegroundGColor", "setSurroundColor", "getHovalScaleFactor", "setHovalEndColor", "Landroid/graphics/Rect;", "break", "Landroid/graphics/Rect;", "getScreenRect", "()Landroid/graphics/Rect;", "setScreenRect", "(Landroid/graphics/Rect;)V", "screenRect", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "do", "if", "for", "iproov_release"}, k = 1, mv = {1, 5, 1})
public final class HovalayView extends ViewGroup {

    /* renamed from: abstract  reason: not valid java name */
    private boolean f2305abstract;

    /* renamed from: break  reason: not valid java name */
    private Rect f2306break;
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public com.iproov.sdk.p024protected.Cif f2307case;
    /* access modifiers changed from: private */

    /* renamed from: catch  reason: not valid java name */
    public int f2308catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public int f2309class;

    /* renamed from: const  reason: not valid java name */
    private final int f2310const;

    /* renamed from: continue  reason: not valid java name */
    private final Paint f2311continue;

    /* renamed from: default  reason: not valid java name */
    private float[] f2312default;

    /* renamed from: do  reason: not valid java name */
    private RectF f2313do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public Path f2314else;

    /* renamed from: extends  reason: not valid java name */
    private float[] f2315extends;

    /* renamed from: final  reason: not valid java name */
    private final int f2316final;

    /* renamed from: finally  reason: not valid java name */
    private float f2317finally;

    /* renamed from: for  reason: not valid java name */
    private boolean f2318for = true;

    /* renamed from: goto  reason: not valid java name */
    private Path f2319goto;

    /* renamed from: if  reason: not valid java name */
    private Rect f2320if;
    /* access modifiers changed from: private */

    /* renamed from: import  reason: not valid java name */
    public final Paint f2321import;

    /* renamed from: native  reason: not valid java name */
    private final Paint f2322native;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public com.iproov.sdk.p024protected.Cif f2323new = new com.iproov.sdk.p024protected.Cif();

    /* renamed from: package  reason: not valid java name */
    private Cif f2324package;

    /* renamed from: private  reason: not valid java name */
    private Cfor f2325private;

    /* renamed from: public  reason: not valid java name */
    private final Paint f2326public;
    /* access modifiers changed from: private */

    /* renamed from: return  reason: not valid java name */
    public boolean f2327return;
    /* access modifiers changed from: private */

    /* renamed from: static  reason: not valid java name */
    public boolean f2328static;
    /* access modifiers changed from: private */

    /* renamed from: super  reason: not valid java name */
    public final Paint f2329super;

    /* renamed from: switch  reason: not valid java name */
    private float f2330switch;

    /* renamed from: this  reason: not valid java name */
    private final Rect f2331this;

    /* renamed from: throw  reason: not valid java name */
    private final Paint f2332throw;

    /* renamed from: throws  reason: not valid java name */
    private float f2333throws;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public com.iproov.sdk.p024protected.Cif f2334try;
    /* access modifiers changed from: private */

    /* renamed from: while  reason: not valid java name */
    public final Paint f2335while;

    /* renamed from: com.iproov.sdk.ui.views.HovalayView$case  reason: invalid class name */
    public static final class Ccase extends AnimatorListenerAdapter {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ HovalayView f2336do;

        public Ccase(HovalayView hovalayView) {
            this.f2336do = hovalayView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2336do.f2327return = false;
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.HovalayView$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.HovalayView$for  reason: invalid class name */
    public final class Cfor {
        /* access modifiers changed from: private */

        /* renamed from: do  reason: not valid java name */
        public AnimatorSet f2337do;

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$for$do  reason: invalid class name */
        public static final class Cdo extends AnimatorListenerAdapter {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ a<Unit> f2339do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ HovalayView f2340if;

            public Cdo(a<Unit> aVar, HovalayView hovalayView) {
                this.f2339do = aVar;
                this.f2340if = hovalayView;
            }

            public void onAnimationStart(Animator animator) {
                this.f2339do.invoke();
                this.f2340if.f2329super.setStyle(Paint.Style.FILL_AND_STROKE);
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$for$if  reason: invalid class name */
        public static final class Cif extends com.iproov.sdk.p024protected.Cdo {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cfor f2341do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Runnable f2342if;

            public Cif(Cfor forR, Runnable runnable) {
                this.f2341do = forR;
                this.f2342if = runnable;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f2341do.f2337do = null;
                this.f2342if.run();
            }
        }

        public Cfor() {
        }

        /* renamed from: if  reason: not valid java name */
        private final ValueAnimator m2188if() {
            ValueAnimator duration = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(HovalayView.this.f2308catch), Integer.valueOf(HovalayView.this.f2309class)}).setDuration(200);
            duration.addUpdateListener(new b(HovalayView.this));
            return duration;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2191do(a<Unit> aVar, Runnable runnable, int i11, int i12) {
            if (this.f2337do == null) {
                AnimatorSet animatorSet = m2184do(aVar, (long) i11, (long) i12);
                this.f2337do = animatorSet;
                if (!(runnable == null || animatorSet == null)) {
                    animatorSet.addListener(new Cif(this, runnable));
                }
                AnimatorSet animatorSet2 = this.f2337do;
                if (animatorSet2 != null) {
                    animatorSet2.start();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: if  reason: not valid java name */
        public static final void m2189if(HovalayView hovalayView, ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Float f11 = animatedValue instanceof Float ? (Float) animatedValue : null;
            if (f11 != null) {
                float floatValue = f11.floatValue();
                hovalayView.f2323new.m1281do((300.0f - (floatValue * 300.0f)) / 2.0f, (400.0f - (floatValue * 400.0f)) / 2.0f);
                hovalayView.f2323new.m1284if(floatValue);
                hovalayView.invalidate();
            }
        }

        /* renamed from: do  reason: not valid java name */
        private final AnimatorSet m2184do(a<Unit> aVar, long j11, long j12) {
            ValueAnimator valueAnimator = m2188if();
            ValueAnimator valueAnimator2 = m2185do(aVar, j11);
            ValueAnimator valueAnimator3 = HovalayView.this.m2155do(j11);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(j12);
            animatorSet.play(valueAnimator).before(valueAnimator2);
            animatorSet.play(valueAnimator2).with(valueAnimator3);
            return animatorSet;
        }

        /* access modifiers changed from: private */
        /* renamed from: do  reason: not valid java name */
        public static final void m2187do(HovalayView hovalayView, ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
            if (num != null) {
                hovalayView.setHovalColor(num.intValue());
            }
        }

        /* renamed from: do  reason: not valid java name */
        private final ValueAnimator m2185do(a<Unit> aVar, long j11) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 2.0f}).setDuration(j11);
            duration.setInterpolator(new AccelerateInterpolator());
            duration.addListener(new Cdo(aVar, HovalayView.this));
            duration.addUpdateListener(new a(HovalayView.this));
            return duration;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2190do() {
            AnimatorSet animatorSet = this.f2337do;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.HovalayView$if  reason: invalid class name */
    public final class Cif {

        /* renamed from: case  reason: not valid java name */
        private Animator f2343case;
        /* access modifiers changed from: private */

        /* renamed from: do  reason: not valid java name */
        public boolean f2344do;

        /* renamed from: for  reason: not valid java name */
        private ValueAnimator f2346for;

        /* renamed from: if  reason: not valid java name */
        private final AnimatorSet f2347if = m2204try();
        /* access modifiers changed from: private */

        /* renamed from: new  reason: not valid java name */
        public final Animator f2348new = m2203new();

        /* renamed from: try  reason: not valid java name */
        private boolean f2349try;

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$case  reason: invalid class name */
        public static final class Ccase extends Lambda implements a<Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cif f2350do;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ccase(Cif ifVar) {
                super(0);
                this.f2350do = ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2209do() {
                this.f2350do.m2202if();
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2209do();
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$do  reason: invalid class name */
        public /* synthetic */ class Cdo {

            /* renamed from: do  reason: not valid java name */
            public static final /* synthetic */ int[] f2351do;

            static {
                int[] iArr = new int[com.iproov.sdk.p015goto.Cif.values().length];
                iArr[com.iproov.sdk.p015goto.Cif.READY.ordinal()] = 1;
                f2351do = iArr;
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$else  reason: invalid class name */
        public static final class Celse extends Lambda implements l<Float, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ HovalayView f2352do;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Celse(HovalayView hovalayView) {
                super(1);
                this.f2352do = hovalayView;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2210do(float f11) {
                this.f2352do.m2178do(f11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2210do(((Number) obj).floatValue());
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$for  reason: invalid class name */
        public static final class Cfor extends Lambda implements l<Integer, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ HovalayView f2353do;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cfor(HovalayView hovalayView) {
                super(1);
                this.f2353do = hovalayView;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2211do(int i11) {
                this.f2353do.f2335while.setAlpha(i11);
                this.f2353do.f2321import.setAlpha(i11);
                this.f2353do.invalidate();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2211do(((Number) obj).intValue());
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$goto  reason: invalid class name */
        public static final class Cgoto extends Lambda implements l<Integer, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ HovalayView f2354do;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cgoto(HovalayView hovalayView) {
                super(1);
                this.f2354do = hovalayView;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2212do(int i11) {
                this.f2354do.setHovalColor(i11);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2212do(((Number) obj).intValue());
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$if  reason: invalid class name */
        public static final class Cif extends AnimatorListenerAdapter {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ HovalayView f2355do;

            public Cif(HovalayView hovalayView) {
                this.f2355do = hovalayView;
            }

            public void onAnimationEnd(Animator animator) {
                this.f2355do.f2328static = false;
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$new  reason: invalid class name */
        public static final class Cnew extends AnimatorListenerAdapter {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cif f2356do;

            public Cnew(Cif ifVar) {
                this.f2356do = ifVar;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.f2356do.f2344do) {
                    this.f2356do.f2348new.start();
                    this.f2356do.f2344do = true;
                }
            }
        }

        /* renamed from: com.iproov.sdk.ui.views.HovalayView$if$try  reason: invalid class name */
        public static final class Ctry extends Lambda implements l<PointF, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ HovalayView f2357do;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ctry(HovalayView hovalayView) {
                super(1);
                this.f2357do = hovalayView;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2213do(PointF pointF) {
                this.f2357do.f2307case.m1281do(-pointF.x, pointF.y);
                this.f2357do.f2334try.m1281do(pointF.x, -pointF.y);
                this.f2357do.invalidate();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2213do((PointF) obj);
                return Unit.f56620a;
            }
        }

        public Cif() {
        }

        /* renamed from: break  reason: not valid java name */
        private final void m2192break() {
            this.f2346for = m2195do(true);
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator valueAnimator = null;
            if (!this.f2344do) {
                AnimatorSet.Builder play = animatorSet.play(this.f2348new);
                ValueAnimator valueAnimator2 = this.f2346for;
                if (valueAnimator2 != null) {
                    valueAnimator = valueAnimator2;
                }
                play.with(valueAnimator);
            } else {
                ValueAnimator valueAnimator3 = this.f2346for;
                if (valueAnimator3 != null) {
                    valueAnimator = valueAnimator3;
                }
                animatorSet.play(valueAnimator);
            }
            animatorSet.start();
            this.f2349try = true;
        }

        /* renamed from: case  reason: not valid java name */
        private final ValueAnimator m2193case() {
            return com.iproov.sdk.p017implements.Cdo.f930do.m997do(6.0f, 2000, (l<? super PointF, Unit>) new Ctry(HovalayView.this), (a<Unit>) new Ccase(this));
        }

        /* renamed from: else  reason: not valid java name */
        private final ValueAnimator m2198else() {
            return com.iproov.sdk.p017implements.Cdo.f930do.m996do(0.0f, 255.0f, 2000, 2, 2, (l<? super Float, Unit>) new Celse(HovalayView.this));
        }

        /* renamed from: goto  reason: not valid java name */
        private final void m2200goto() {
            if (this.f2349try) {
                this.f2349try = false;
                ValueAnimator valueAnimator = this.f2346for;
                ValueAnimator valueAnimator2 = null;
                if (valueAnimator == null) {
                    valueAnimator = null;
                }
                valueAnimator.end();
                ValueAnimator valueAnimator3 = m2195do(false);
                this.f2346for = valueAnimator3;
                if (valueAnimator3 != null) {
                    valueAnimator2 = valueAnimator3;
                }
                valueAnimator2.start();
            }
        }

        /* renamed from: new  reason: not valid java name */
        private final Animator m2203new() {
            ValueAnimator valueAnimator = com.iproov.sdk.p017implements.Cdo.m992do(com.iproov.sdk.p017implements.Cdo.f930do, 180, 0, 200, 0, 0, (l) new Cfor(HovalayView.this), 24, (Object) null);
            valueAnimator.addListener(new Cif(HovalayView.this));
            return valueAnimator;
        }

        /* renamed from: try  reason: not valid java name */
        private final AnimatorSet m2204try() {
            ValueAnimator valueAnimator = m2193case();
            ValueAnimator valueAnimator2 = m2198else();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(valueAnimator).with(valueAnimator2);
            animatorSet.addListener(new Cnew(this));
            HovalayView.this.f2328static = true;
            return animatorSet;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2205do() {
        }

        /* renamed from: this  reason: not valid java name */
        public final void m2208this() {
            this.f2347if.start();
        }

        /* access modifiers changed from: private */
        /* renamed from: if  reason: not valid java name */
        public final void m2202if() {
            m2203new().start();
        }

        /* renamed from: for  reason: not valid java name */
        public final void m2207for() {
            if (!HovalayView.this.f2334try.m1283for() || !HovalayView.this.f2307case.m1283for()) {
                Animator animator = this.f2343case;
                boolean z11 = true;
                if (animator == null || !animator.isRunning()) {
                    z11 = false;
                }
                if (!z11) {
                    this.f2347if.end();
                    return;
                }
                return;
            }
            m2194do(HovalayView.this.f2329super.getColor(), HovalayView.this.f2309class).start();
        }

        /* renamed from: do  reason: not valid java name */
        private final ValueAnimator m2195do(boolean z11) {
            return m2194do(HovalayView.this.f2329super.getColor(), z11 ? HovalayView.this.f2309class : HovalayView.this.f2308catch);
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2206do(com.iproov.sdk.p015goto.Cif ifVar) {
            if (Cdo.f2351do[ifVar.ordinal()] == 1) {
                m2192break();
            } else {
                m2200goto();
            }
        }

        /* renamed from: do  reason: not valid java name */
        private final ValueAnimator m2194do(int i11, int i12) {
            return com.iproov.sdk.p017implements.Cdo.f930do.m999do(i11, i12, 200, (l<? super Integer, Unit>) new Cgoto(HovalayView.this));
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.HovalayView$new  reason: invalid class name */
    public static final class Cnew extends Lambda implements l<Float, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ HovalayView f2358do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(HovalayView hovalayView) {
            super(1);
            this.f2358do = hovalayView;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2214do(float f11) {
            float[] fArr = this.f2358do.f2323new.m1282do(f11);
            this.f2358do.f2314else.lineTo(fArr[0], fArr[1]);
            this.f2358do.invalidate();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2214do(((Number) obj).floatValue());
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.HovalayView$try  reason: invalid class name */
    public static final class Ctry extends Lambda implements l<Float, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ HovalayView f2359do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(HovalayView hovalayView) {
            super(1);
            this.f2359do = hovalayView;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2215do(float f11) {
            this.f2359do.setAlpha(f11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2215do(((Number) obj).floatValue());
            return Unit.f56620a;
        }
    }

    static {
        new Cdo((r) null);
    }

    public HovalayView(Context context) {
        super(context);
        com.iproov.sdk.p024protected.Cif ifVar = new com.iproov.sdk.p024protected.Cif();
        ifVar.m1281do(0.0f, -6.0f);
        Unit unit = Unit.f56620a;
        this.f2334try = ifVar;
        com.iproov.sdk.p024protected.Cif ifVar2 = new com.iproov.sdk.p024protected.Cif();
        ifVar2.m1281do(0.0f, 6.0f);
        this.f2307case = ifVar2;
        Path path = new Path();
        path.moveTo(150.0f, 0.0f);
        this.f2314else = path;
        this.f2319goto = this.f2323new.m1280do();
        this.f2331this = new Rect(0, 0, 300, 400);
        this.f2308catch = -1;
        this.f2309class = Color.parseColor("#01AC41");
        this.f2310const = Color.parseColor("#1703fc");
        this.f2316final = Color.parseColor("#9c0e0e");
        this.f2329super = new Paint();
        this.f2332throw = new Paint();
        this.f2335while = new Paint();
        this.f2321import = new Paint();
        this.f2322native = new Paint();
        this.f2326public = new Paint();
        this.f2312default = new float[3];
        this.f2315extends = new float[3];
        this.f2305abstract = true;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f2311continue = paint;
        m2168if();
    }

    /* renamed from: break  reason: not valid java name */
    private final void m2152break() {
        this.f2335while.setColor(Color.HSVToColor(this.f2312default));
        this.f2335while.setAlpha(180);
    }

    private final float getMinimumTopSpaceForHovalInPixels() {
        return ((float) getResources().getDimensionPixelSize(R.dimen.iproov__app_bar_size)) + (getResources().getDisplayMetrics().density * 12.0f) + ((float) getStatusBarHeight());
    }

    private final int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public final void setHovalColor(int i11) {
        this.f2329super.setColor(i11);
        invalidate();
    }

    public final float getHovalScaleFactor() {
        Rect rect = this.f2320if;
        if (rect == null) {
            return 0.9f;
        }
        return ((float) rect.width()) / ((float) getWidth());
    }

    public final Rect getScreenRect() {
        return this.f2306break;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2318for) {
            canvas.save();
            m2159do(canvas, this.f2331this, this.f2320if);
            if (this.f2327return) {
                canvas.drawPath(this.f2319goto, this.f2322native);
                canvas.drawPath(this.f2314else, this.f2326public);
            } else {
                canvas.restore();
                canvas.save();
                canvas.drawRect(this.f2306break, this.f2311continue);
                m2159do(canvas, this.f2331this, this.f2320if);
                if (this.f2328static) {
                    canvas.drawPath(this.f2334try.m1280do(), this.f2335while);
                    canvas.drawPath(this.f2307case.m1280do(), this.f2321import);
                }
                canvas.drawPath(this.f2323new.m1280do(), this.f2329super);
            }
            canvas.drawPath(this.f2319goto, this.f2332throw);
            canvas.restore();
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i15 = 0;
            while (true) {
                int i16 = i15 + 1;
                getChildAt(i15).layout(0, 0, getWidth(), getHeight());
                if (i16 >= childCount) {
                    break;
                }
                i15 = i16;
            }
        }
        if (this.f2306break == null) {
            this.f2306break = new Rect(0, 0, getWidth(), getHeight());
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        m2165for();
    }

    public final void setForegroundGColor(int i11) {
        this.f2308catch = i11;
        this.f2329super.setColor(i11);
        this.f2329super.setAlpha(255);
        invalidate();
    }

    public final void setHovalEndColor(int i11) {
        this.f2309class = i11;
    }

    public final void setPortraitMode(boolean z11) {
        this.f2305abstract = z11;
    }

    public final void setScreenRect(Rect rect) {
        this.f2306break = rect;
    }

    public final void setSurroundColor(int i11) {
        this.f2311continue.setColor(i11);
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    private final void m2165for() {
        this.f2313do = Cwhile.m1047do(getWidth(), getHeight());
        if (this.f2305abstract) {
            float minimumTopSpaceForHovalInPixels = getMinimumTopSpaceForHovalInPixels();
            if (this.f2313do.top < minimumTopSpaceForHovalInPixels) {
                this.f2313do = Cwhile.m1048do(this.f2313do, minimumTopSpaceForHovalInPixels - this.f2313do.top);
            }
        }
        this.f2320if = new Rect((int) this.f2313do.left, (int) this.f2313do.top, (int) this.f2313do.right, (int) this.f2313do.bottom);
    }

    /* renamed from: new  reason: not valid java name */
    private final void m2171new() {
        Paint paint = this.f2322native;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(12.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#7cFFFFFF"));
        Paint paint2 = this.f2326public;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(12.0f);
        paint2.setStrokeCap(Paint.Cap.SQUARE);
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
    }

    /* renamed from: this  reason: not valid java name */
    private final void m2173this() {
        this.f2321import.setColor(Color.HSVToColor(this.f2315extends));
        this.f2321import.setAlpha(180);
    }

    /* renamed from: try  reason: not valid java name */
    private final void m2175try() {
        this.f2329super.setStyle(Paint.Style.STROKE);
        this.f2329super.setStrokeWidth(12.0f);
        this.f2329super.setStrokeCap(Paint.Cap.SQUARE);
        this.f2329super.setAntiAlias(true);
        this.f2329super.setColor(this.f2308catch);
    }

    /* renamed from: case  reason: not valid java name */
    public final void m2176case() {
        this.f2317finally = 0.0f;
        this.f2327return = true;
        setHovalColor(-1);
    }

    /* renamed from: else  reason: not valid java name */
    public final void m2182else() {
        Cif ifVar = new Cif();
        this.f2324package = ifVar;
        ifVar.m2208this();
    }

    /* renamed from: goto  reason: not valid java name */
    public final void m2183goto() {
        Cfor forR = this.f2325private;
        if (forR != null) {
            forR.m2190do();
        }
        Cif ifVar = this.f2324package;
        if (ifVar != null) {
            ifVar.m2205do();
        }
    }

    /* renamed from: if  reason: not valid java name */
    private final void m2168if() {
        setAlpha(1.0f);
        setWillNotDraw(false);
        m2175try();
        m2171new();
        m2160do(this.f2335while, this.f2310const);
        m2160do(this.f2321import, this.f2316final);
        m2158do(this.f2310const, this.f2312default);
        m2158do(this.f2316final, this.f2315extends);
        this.f2330switch = ArraysKt___ArraysKt.H(this.f2312default);
        this.f2333throws = ArraysKt___ArraysKt.H(this.f2315extends);
        this.f2332throw.setStyle(Paint.Style.FILL);
        this.f2332throw.setAntiAlias(true);
        this.f2332throw.setColor(0);
        this.f2332throw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        invalidate();
    }

    /* renamed from: do  reason: not valid java name */
    private final void m2158do(int i11, float[] fArr) {
        Color.RGBToHSV(Color.red(i11), Color.green(i11), Color.blue(i11), fArr);
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2179do(float f11, long j11) {
        ValueAnimator valueAnimator = m2154do(this.f2317finally, f11, j11);
        if (f11 == 1.0f) {
            valueAnimator.addListener(new Ccase(this));
        }
        this.f2317finally = f11;
        valueAnimator.start();
    }

    /* renamed from: do  reason: not valid java name */
    private final ValueAnimator m2154do(float f11, float f12, long j11) {
        return com.iproov.sdk.p017implements.Cdo.m991do(com.iproov.sdk.p017implements.Cdo.f930do, f11, f12, j11, 0, 0, (l) new Cnew(this), 24, (Object) null);
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2177do() {
        Cif ifVar = this.f2324package;
        if (ifVar != null) {
            ifVar.m2207for();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2181do(a<Unit> aVar, Runnable runnable, int i11, int i12) {
        if (this.f2325private == null) {
            Cfor forR = new Cfor();
            this.f2325private = forR;
            forR.m2191do(aVar, runnable, i11, i12);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private final void m2160do(Paint paint, int i11) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(12.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setColor(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final ValueAnimator m2155do(long j11) {
        return com.iproov.sdk.p017implements.Cdo.m991do(com.iproov.sdk.p017implements.Cdo.f930do, 1.0f, 0.0f, j11, 0, 0, (l) new Ctry(this), 24, (Object) null);
    }

    /* renamed from: do  reason: not valid java name */
    private final void m2159do(Canvas canvas, Rect rect, Rect rect2) {
        float width = (((float) rect2.width()) * 1.0f) / ((float) rect.width());
        canvas.translate((((float) (rect2.width() / 2)) - (((float) (rect.width() / 2)) * width)) + ((float) rect2.left), (((float) (rect2.height() / 2)) - (((float) (rect.height() / 2)) * ((((float) rect2.height()) * 1.0f) / ((float) rect.height())))) + ((float) rect2.top));
        canvas.scale(width, width);
    }

    public HovalayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.iproov.sdk.p024protected.Cif ifVar = new com.iproov.sdk.p024protected.Cif();
        ifVar.m1281do(0.0f, -6.0f);
        Unit unit = Unit.f56620a;
        this.f2334try = ifVar;
        com.iproov.sdk.p024protected.Cif ifVar2 = new com.iproov.sdk.p024protected.Cif();
        ifVar2.m1281do(0.0f, 6.0f);
        this.f2307case = ifVar2;
        Path path = new Path();
        path.moveTo(150.0f, 0.0f);
        this.f2314else = path;
        this.f2319goto = this.f2323new.m1280do();
        this.f2331this = new Rect(0, 0, 300, 400);
        this.f2308catch = -1;
        this.f2309class = Color.parseColor("#01AC41");
        this.f2310const = Color.parseColor("#1703fc");
        this.f2316final = Color.parseColor("#9c0e0e");
        this.f2329super = new Paint();
        this.f2332throw = new Paint();
        this.f2335while = new Paint();
        this.f2321import = new Paint();
        this.f2322native = new Paint();
        this.f2326public = new Paint();
        this.f2312default = new float[3];
        this.f2315extends = new float[3];
        this.f2305abstract = true;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f2311continue = paint;
        m2168if();
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2178do(float f11) {
        float[] fArr = this.f2315extends;
        float f12 = (this.f2333throws + f11) % 360.0f;
        float f13 = (float) 0.0d;
        if (!(f12 == f13 || Math.signum(f12) == Math.signum(360.0f))) {
            f12 += 360.0f;
        }
        fArr[0] = f12;
        float[] fArr2 = this.f2312default;
        float f14 = (this.f2330switch + f11) % 360.0f;
        if (!(f14 == f13 || Math.signum(f14) == Math.signum(360.0f))) {
            f14 += 360.0f;
        }
        fArr2[0] = f14;
        m2152break();
        m2173this();
        invalidate();
    }

    /* renamed from: do  reason: not valid java name */
    public final void m2180do(com.iproov.sdk.p015goto.Cif ifVar) {
        Cif ifVar2 = this.f2324package;
        if (ifVar2 != null) {
            ifVar2.m2206do(ifVar);
        }
    }

    public HovalayView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        com.iproov.sdk.p024protected.Cif ifVar = new com.iproov.sdk.p024protected.Cif();
        ifVar.m1281do(0.0f, -6.0f);
        Unit unit = Unit.f56620a;
        this.f2334try = ifVar;
        com.iproov.sdk.p024protected.Cif ifVar2 = new com.iproov.sdk.p024protected.Cif();
        ifVar2.m1281do(0.0f, 6.0f);
        this.f2307case = ifVar2;
        Path path = new Path();
        path.moveTo(150.0f, 0.0f);
        this.f2314else = path;
        this.f2319goto = this.f2323new.m1280do();
        this.f2331this = new Rect(0, 0, 300, 400);
        this.f2308catch = -1;
        this.f2309class = Color.parseColor("#01AC41");
        this.f2310const = Color.parseColor("#1703fc");
        this.f2316final = Color.parseColor("#9c0e0e");
        this.f2329super = new Paint();
        this.f2332throw = new Paint();
        this.f2335while = new Paint();
        this.f2321import = new Paint();
        this.f2322native = new Paint();
        this.f2326public = new Paint();
        this.f2312default = new float[3];
        this.f2315extends = new float[3];
        this.f2305abstract = true;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f2311continue = paint;
        m2168if();
    }

    public HovalayView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        com.iproov.sdk.p024protected.Cif ifVar = new com.iproov.sdk.p024protected.Cif();
        ifVar.m1281do(0.0f, -6.0f);
        Unit unit = Unit.f56620a;
        this.f2334try = ifVar;
        com.iproov.sdk.p024protected.Cif ifVar2 = new com.iproov.sdk.p024protected.Cif();
        ifVar2.m1281do(0.0f, 6.0f);
        this.f2307case = ifVar2;
        Path path = new Path();
        path.moveTo(150.0f, 0.0f);
        this.f2314else = path;
        this.f2319goto = this.f2323new.m1280do();
        this.f2331this = new Rect(0, 0, 300, 400);
        this.f2308catch = -1;
        this.f2309class = Color.parseColor("#01AC41");
        this.f2310const = Color.parseColor("#1703fc");
        this.f2316final = Color.parseColor("#9c0e0e");
        this.f2329super = new Paint();
        this.f2332throw = new Paint();
        this.f2335while = new Paint();
        this.f2321import = new Paint();
        this.f2322native = new Paint();
        this.f2326public = new Paint();
        this.f2312default = new float[3];
        this.f2315extends = new float[3];
        this.f2305abstract = true;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f2311continue = paint;
        m2168if();
    }
}
