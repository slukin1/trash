package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.dynamicanimation.animation.c;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import j1.a;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final a<DeterminateDrawable> INDICATOR_LENGTH_IN_LEVEL = new a<DeterminateDrawable>("indicatorLevel") {
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.getIndicatorFraction() * 10000.0f;
        }

        public void setValue(DeterminateDrawable determinateDrawable, float f11) {
            determinateDrawable.setIndicatorFraction(f11 / 10000.0f);
        }
    };
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private DrawingDelegate<S> drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange = false;
    private final c springAnimator;
    private final SpringForce springForce;

    public DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate2) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(drawingDelegate2);
        SpringForce springForce2 = new SpringForce();
        this.springForce = springForce2;
        springForce2.d(1.0f);
        springForce2.f(SPRING_FORCE_STIFFNESS);
        c cVar = new c(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimator = cVar;
        cVar.u(springForce2);
        setGrowFraction(1.0f);
    }

    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    /* access modifiers changed from: private */
    public float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    /* access modifiers changed from: private */
    public void setIndicatorFraction(float f11) {
        this.indicatorFraction = f11;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getGrowFraction());
            this.drawingDelegate.fillTrack(canvas, this.paint);
            Canvas canvas2 = canvas;
            this.drawingDelegate.fillIndicator(canvas2, this.paint, 0.0f, getIndicatorFraction(), MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], getAlpha()));
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public void jumpToCurrentState() {
        this.springAnimator.c();
        setIndicatorFraction(((float) getLevel()) / 10000.0f);
    }

    public boolean onLevelChange(int i11) {
        if (this.skipAnimationOnLevelChange) {
            this.springAnimator.c();
            setIndicatorFraction(((float) i11) / 10000.0f);
            return true;
        }
        this.springAnimator.l(getIndicatorFraction() * 10000.0f);
        this.springAnimator.p((float) i11);
        return true;
    }

    public /* bridge */ /* synthetic */ void registerAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        super.registerAnimationCallback(animatable2Compat$AnimationCallback);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i11) {
        super.setAlpha(i11);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public void setDrawingDelegate(DrawingDelegate<S> drawingDelegate2) {
        this.drawingDelegate = drawingDelegate2;
        drawingDelegate2.registerDrawable(this);
    }

    public void setLevelByFraction(float f11) {
        setLevel((int) (f11 * 10000.0f));
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12);
    }

    public boolean setVisibleInternal(boolean z11, boolean z12, boolean z13) {
        boolean visibleInternal = super.setVisibleInternal(z11, z12, z13);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            this.springForce.f(SPRING_FORCE_STIFFNESS / systemAnimatorDurationScale);
        }
        return visibleInternal;
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        return super.unregisterAnimationCallback(animatable2Compat$AnimationCallback);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z11, boolean z12, boolean z13) {
        return super.setVisible(z11, z12, z13);
    }
}
