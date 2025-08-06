package com.iproov.sdk.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import d10.a;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/iproov/sdk/ui/views/ShimmeringImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "scale", "", "setGradient", "Landroid/animation/ValueAnimator;", "new", "Lkotlin/i;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "do", "iproov_release"}, k = 1, mv = {1, 5, 1})
public final class ShimmeringImageView extends AppCompatImageView {

    /* renamed from: do  reason: not valid java name */
    private final Paint f2368do;

    /* renamed from: for  reason: not valid java name */
    private int f2369for;

    /* renamed from: if  reason: not valid java name */
    private final int f2370if;

    /* renamed from: new  reason: not valid java name */
    private final i f2371new;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public boolean f2372try;

    /* renamed from: com.iproov.sdk.ui.views.ShimmeringImageView$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.ShimmeringImageView$for  reason: invalid class name */
    public static final class Cfor extends AnimatorListenerAdapter {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ ShimmeringImageView f2373do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ ValueAnimator f2374if;

        public Cfor(ShimmeringImageView shimmeringImageView, ValueAnimator valueAnimator) {
            this.f2373do = shimmeringImageView;
            this.f2374if = valueAnimator;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2373do.f2372try) {
                this.f2374if.setStartDelay(2000);
                this.f2374if.start();
            }
        }
    }

    /* renamed from: com.iproov.sdk.ui.views.ShimmeringImageView$if  reason: invalid class name */
    public static final class Cif extends Lambda implements a<ValueAnimator> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ ShimmeringImageView f2375do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(ShimmeringImageView shimmeringImageView) {
            super(0);
            this.f2375do = shimmeringImageView;
        }

        /* renamed from: do  reason: not valid java name */
        public final ValueAnimator invoke() {
            return this.f2375do.m2223do();
        }
    }

    static {
        new Cdo((r) null);
    }

    public ShimmeringImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f2368do = paint;
        this.f2370if = -1;
        this.f2369for = -3355444;
        this.f2371new = LazyKt__LazyJVMKt.a(new Cif(this));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-3355444);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
    }

    private final ValueAnimator getAnimator() {
        return (ValueAnimator) this.f2371new.getValue();
    }

    private final void setGradient(float f11) {
        float width = ((float) getWidth()) * f11;
        Paint paint = this.f2368do;
        float f12 = width + 0.0f;
        float height = ((float) getHeight()) * 0.5f;
        float width2 = (((float) getWidth()) * 0.2f) + width;
        float height2 = ((float) getHeight()) * 0.5f;
        int i11 = this.f2369for;
        float f13 = height;
        float f14 = width2;
        paint.setShader(new LinearGradient(f12, f13, f14, height2, new int[]{i11, this.f2370if, i11}, (float[]) null, Shader.TileMode.CLAMP));
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public final void m2227for() {
        this.f2372try = false;
        getAnimator().removeAllListeners();
        getAnimator().cancel();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2372try) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f2368do);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13 = getContext().getResources().getDisplayMetrics().widthPixels / 3;
        int i14 = (int) (((float) i13) / 3.390625f);
        setMeasuredDimension(i13, i14);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = i14;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final ValueAnimator m2223do() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{-0.2f, 1.2f}).setDuration(2000);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addUpdateListener(new c(this));
        duration.addListener(new Cfor(this, duration));
        return duration;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m2228if() {
        if (!this.f2372try) {
            getAnimator().start();
            this.f2372try = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public static final void m2225do(ShimmeringImageView shimmeringImageView, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        shimmeringImageView.setGradient(((Float) animatedValue).floatValue());
    }

    public ShimmeringImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmeringImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }
}
