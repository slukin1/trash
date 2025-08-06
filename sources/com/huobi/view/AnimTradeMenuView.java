package com.huobi.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.hbg.lib.widgets.R$color;

public class AnimTradeMenuView extends View implements Animator.AnimatorListener, Runnable {
    private static final int ANIMATE_COUNT = 5;
    private static final long APPEND_DURATION = 0;
    private static final float CENTER_LINE_RATE = 0.6f;
    private static final float CORNER_R_RATE = 0.04f;
    private static final long DELAY_TIME = 1000;
    private static final int DOUBLE = 2;
    private static final long END_DURATION = 300;
    private static final float FLOAT_1 = 1.0f;
    private static final float FLOAT_SUM_RATE = 0.9f;
    private static final float INTERPOLATOR_RATE = 0.8f;
    private static final float LINE_HEIGHT_PERCENT = 0.12f;
    private static final float LINE_LEFT_MOVE_PERCENT = 0.35f;
    private static final float PADDING_RATE = 0.1f;
    private static final long START_DELAY_TIME = 33;
    private static final long START_DURATION = 350;
    private static final float TRANSLATION_WIDTH = 20.0f;
    private static final float TRIANGLE_HEIGHT_PERCENT = 0.35f;
    private static final float TRIANGLE_HEIGHT_RATE = 0.6f;
    private static final float TRIANGLE_WIDTH_PERCENT = 0.2f;
    private static final float TRIANGLE_WIDTH_RATE = 0.5f;
    private static final long VIEW_DURATION = 1070;
    private boolean animate;
    private boolean isRunning;
    private boolean isStoped;
    private Interpolator mAccelerateInterpolator = new AccelerateInterpolator();
    private final AnimatorSet mAnimatorSet = new AnimatorSet();
    private Callback mCallback;
    private final Path mCenterLeftPath = new Path();
    private RectF mCenterRightLineRectF = new RectF();
    private final Path mCenterRightPath = new Path();
    private int mColor;
    private float mCornerR;
    private Interpolator mDecelerateInterpolator = new DecelerateInterpolator(0.8f);
    private final Path mDownLinePath = new Path();
    private RectF mDownLineRectF = new RectF();
    private int mHeight;
    private float mPadding;
    private final Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private float mRate;
    private float mRate2;
    private int mRepeatCount;
    private float mStartRate;
    private final Path mTrianglePath = new Path();
    private final Path mUpLinePath = new Path();
    private RectF mUpLineRectF = new RectF();
    private int mWidth;

    public interface Callback {
        void onAnimFinish();
    }

    public AnimTradeMenuView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        int color = getResources().getColor(R$color.global_main_text_color);
        this.mColor = color;
        this.mPaint.setColor(color);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(350);
        duration.addUpdateListener(new b(this));
        duration.setInterpolator(new DecelerateInterpolator());
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        duration2.addUpdateListener(new c(this));
        duration2.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{duration, duration2});
        ValueAnimator duration3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(350);
        duration3.addUpdateListener(new e(this));
        duration3.setInterpolator(new DecelerateInterpolator());
        ValueAnimator duration4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        duration4.addUpdateListener(new d(this));
        duration4.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(new Animator[]{duration3, duration4});
        animatorSet2.setStartDelay(START_DELAY_TIME);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, new float[]{0.0f, TRANSLATION_WIDTH}).setDuration(350);
        duration5.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, new float[]{TRANSLATION_WIDTH, 0.0f}).setDuration(VIEW_DURATION);
        duration6.setInterpolator(new BounceInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(new Animator[]{duration5, duration6});
        this.mAnimatorSet.playTogether(new Animator[]{animatorSet, animatorSet3, animatorSet2});
        this.mAnimatorSet.addListener(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mRate = floatValue;
        this.mStartRate = floatValue;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(ValueAnimator valueAnimator) {
        this.mRate = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(ValueAnimator valueAnimator) {
        this.mRate2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(ValueAnimator valueAnimator) {
        this.mRate2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    private void resetData() {
        this.mRate = 0.0f;
        this.mRate2 = 0.0f;
        this.mStartRate = 0.0f;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void onAnimationCancel(Animator animator) {
        this.animate = false;
        this.isRunning = false;
        resetData();
        invalidate();
    }

    public void onAnimationEnd(Animator animator) {
        Callback callback;
        this.animate = false;
        this.isRunning = false;
        resetData();
        invalidate();
        removeCallbacks(this);
        if (this.mRepeatCount > 0) {
            postDelayed(this, 1000);
        } else if (!this.isStoped && (callback = this.mCallback) != null) {
            callback.onAnimFinish();
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.animate = true;
        this.isRunning = true;
        this.mRepeatCount--;
        invalidate();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void onDraw(Canvas canvas) {
        float f11;
        float f12;
        float f13;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        if (isInEditMode() || !(this.mWidth == 0 || this.mHeight == 0)) {
            int i11 = this.mHeight;
            float f14 = ((float) i11) * 0.12f;
            float f15 = f14 / 2.0f;
            int i12 = this.mWidth;
            int i13 = i12 / 2;
            int i14 = i11 / 2;
            float f16 = ((float) i12) * 0.35f;
            float f17 = ((float) i12) * 0.2f;
            float f18 = ((float) i11) * 0.35f;
            float f19 = this.mStartRate;
            float f21 = f19 == 0.0f ? 1.0f : f19;
            float interpolation = this.mAccelerateInterpolator.getInterpolation(f19);
            int i15 = this.mWidth;
            this.mCornerR = ((float) i15) * CORNER_R_RATE;
            float f22 = ((float) i15) * 0.1f;
            this.mPadding = f22;
            float f23 = (((float) i15) - (f22 * 2.0f)) * 0.6f;
            this.mUpLinePath.reset();
            RectF rectF = this.mUpLineRectF;
            float f24 = this.mPadding;
            rectF.set((this.mRate * f16) + f24, f24, ((float) this.mWidth) - f24, f24 + f14);
            Path path = this.mUpLinePath;
            RectF rectF2 = this.mUpLineRectF;
            float f25 = this.mCornerR;
            path.addRoundRect(rectF2, f25, f25, Path.Direction.CW);
            this.mUpLinePath.close();
            this.mTrianglePath.reset();
            float f26 = (float) i14;
            float f27 = f18 / 2.0f;
            float f28 = ((0.39999998f * f21) + 0.6f) * f27;
            this.mTrianglePath.moveTo(this.mPadding, f26 - f28);
            this.mTrianglePath.lineTo(this.mPadding + (((f21 * 0.5f) + 0.5f) * f17), f26);
            this.mTrianglePath.lineTo(this.mPadding, f28 + f26);
            this.mTrianglePath.close();
            if (!this.isStoped) {
                this.mCenterLeftPath.reset();
                float f29 = this.mPadding;
                int i16 = this.mWidth;
                float f31 = (((((float) i16) - f23) - (f29 * 2.0f)) * interpolation) + f29;
                float f32 = (f27 - f15) * (1.0f - interpolation);
                float f33 = (f26 - f15) - f32;
                f13 = f14;
                float f34 = f29 + f17 + (((((float) i16) - f29) - (f29 + f17)) * interpolation);
                float f35 = f15 * interpolation;
                f12 = f16;
                float f36 = f26 - f35;
                f11 = f21;
                float f37 = f29 + f17 + (((((float) i16) - f29) - (f17 + f29)) * interpolation);
                float f38 = f35 + f26;
                float f39 = f29 + (((((float) i16) - f23) - (2.0f * f29)) * interpolation);
                float f40 = f26 + f15 + f32;
                if (interpolation < FLOAT_SUM_RATE) {
                    this.mCenterLeftPath.moveTo(f31, f33);
                    this.mCenterLeftPath.lineTo(f34, f36);
                    this.mCenterLeftPath.lineTo(f37, f38);
                    this.mCenterLeftPath.lineTo(f39, f40);
                } else {
                    this.mCenterRightLineRectF.set(f31, f33, f34, f40);
                    Path path2 = this.mCenterLeftPath;
                    RectF rectF3 = this.mCenterRightLineRectF;
                    float f41 = this.mCornerR;
                    path2.addRoundRect(rectF3, f41 * interpolation, f41 * interpolation, Path.Direction.CW);
                }
                this.mCenterLeftPath.close();
                canvas2.drawPath(this.mCenterLeftPath, this.mPaint);
            } else {
                f13 = f14;
                f12 = f16;
                f11 = f21;
            }
            this.mCenterRightPath.reset();
            float f42 = f11 != 1.0f ? f23 * f11 : 0.0f;
            RectF rectF4 = this.mCenterRightLineRectF;
            int i17 = this.mWidth;
            float f43 = this.mPadding;
            rectF4.set(((((float) i17) - f23) - f43) + f42, f26 - f15, ((float) i17) - f43, f26 + f15);
            Path path3 = this.mCenterRightPath;
            RectF rectF5 = this.mCenterRightLineRectF;
            float f44 = this.mCornerR;
            path3.addRoundRect(rectF5, f44, f44, Path.Direction.CW);
            this.mCenterRightPath.close();
            this.mDownLinePath.reset();
            int i18 = this.mHeight;
            float f45 = this.mPadding;
            this.mDownLineRectF.set(this.mPadding + (f12 * this.mDecelerateInterpolator.getInterpolation(this.mRate2)), (((float) i18) - f13) - f45, ((float) this.mWidth) - f45, ((float) i18) - f45);
            Path path4 = this.mDownLinePath;
            RectF rectF6 = this.mDownLineRectF;
            float f46 = this.mCornerR;
            path4.addRoundRect(rectF6, f46, f46, Path.Direction.CW);
            this.mDownLinePath.close();
            this.mPath.reset();
            this.mPath.addPath(this.mUpLinePath);
            this.mPath.addPath(this.mTrianglePath);
            this.mPath.addPath(this.mCenterRightPath);
            this.mPath.addPath(this.mDownLinePath);
            canvas2.drawPath(this.mPath, this.mPaint);
            if (this.animate) {
                invalidate();
                return;
            }
            return;
        }
        invalidate();
    }

    public void reset() {
        this.mRepeatCount = 1;
        if (this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.cancel();
        }
        this.animate = false;
        resetData();
        removeCallbacks(this);
        invalidate();
    }

    public void run() {
        this.mAnimatorSet.start();
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setColor(int i11) {
        this.mColor = i11;
        invalidate();
    }

    public void startAnim() {
        startAnim(5);
    }

    public void stopAnim() {
        this.mRepeatCount = 0;
        if (this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.cancel();
        }
        this.isStoped = true;
        this.animate = false;
        resetData();
        removeCallbacks(this);
        invalidate();
    }

    public void startAnim(int i11) {
        resetData();
        this.isStoped = false;
        this.mRepeatCount = i11;
        if (this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.cancel();
        }
        this.mAnimatorSet.start();
    }

    public AnimTradeMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AnimTradeMenuView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
