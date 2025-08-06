package com.huobi.view.seekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$styleable;
import i6.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MultiColorSeekBar extends View {
    public static final int NONE = -1;

    /* renamed from: dx  reason: collision with root package name */
    public float f19106dx;
    /* access modifiers changed from: private */
    public boolean isAlwaysShowBubble;
    private boolean isAutoAdjustSectionMark;
    private boolean isFloatType;
    /* access modifiers changed from: private */
    public boolean isHideBubble;
    public boolean isRtl;
    private boolean isSeekBySection;
    private boolean isSeekStepSection;
    private boolean isShowProgressInFloat;
    private boolean isShowSectionMark;
    private boolean isShowSectionText;
    private boolean isShowThumbText;
    /* access modifiers changed from: private */
    public boolean isThumbOnDragging;
    private boolean isTouchToSeek;
    /* access modifiers changed from: private */
    public boolean isTouchToSeekAnimEnd;
    /* access modifiers changed from: private */
    public boolean isUserTouchToSeek;
    private long mAlwaysShowBubbleDelay;
    private List<Float> mAnchor;
    private long mAnimDuration;
    private float mBubbleCenterRawSolidX;
    public float mBubbleCenterRawSolidY;
    /* access modifiers changed from: private */
    public float mBubbleCenterRawX;
    /* access modifiers changed from: private */
    public int mBubbleColor;
    /* access modifiers changed from: private */
    public int mBubbleRadius;
    /* access modifiers changed from: private */
    public int mBubbleTextColor;
    /* access modifiers changed from: private */
    public int mBubbleTextSize;
    public MultiColorView mBubbleView;
    private int mCircleColor;
    private MultiConfigBuilder mConfigBuilder;
    private int[] mCurPoint;
    /* access modifiers changed from: private */
    public float mDanger;
    private int mDangerColor;
    private float mDelta;
    public WindowManager.LayoutParams mLayoutParams;
    private float mLeft;
    public float mMax;
    public float mMin;
    private int mOuterCirColor;
    private Paint mPaint;
    private int[] mPoint;
    private float mPreSecValue;
    private float mPreThumbCenterX;
    private int mPrecision;
    /* access modifiers changed from: private */
    public float mProgress;
    /* access modifiers changed from: private */
    public OnProgressChangedListener mProgressListener;
    private Rect mRectText;
    private float mRight;
    /* access modifiers changed from: private */
    public int mSecondTrackColor;
    private int mSecondTrackSize;
    public int mSectionCount;
    private float mSectionOffset;
    public SparseArray<String> mSectionTextArray;
    private int mSectionTextColor;
    private int mSectionTextInterval;
    private int mSectionTextPosition;
    private int mSectionTextSize;
    public float mSectionValue;
    private int mTextSpace;
    /* access modifiers changed from: private */
    public float mThumbCenterX;
    private int mThumbColor;
    private int mThumbRadius;
    private int mThumbRadiusOnDragging;
    private int mThumbTextColor;
    private int mThumbTextSize;
    private int mTrackColor;
    private float mTrackLength;
    private int mTrackSize;
    public WindowManager mWindowManager;
    /* access modifiers changed from: private */
    public boolean triggerBubbleShowing;
    private boolean triggerSeekBySection;
    private String unit;

    public interface CustomSectionTextArray {
        SparseArray<String> onCustomize(int i11, SparseArray<String> sparseArray);
    }

    public class MultiColorView extends View {
        private Paint mBubblePaint;
        private Path mBubblePath;
        private RectF mBubbleRectF;
        private String mProgressText;
        private Rect mRect;

        public MultiColorView(MultiColorSeekBar multiColorSeekBar, Context context) {
            this(multiColorSeekBar, context, (AttributeSet) null);
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.mBubblePath.reset();
            float dp2px = this.mBubbleRectF.bottom + ((float) MultiColorUtils.dp2px(3));
            float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
            float dp2px2 = this.mBubbleRectF.bottom - ((float) MultiColorUtils.dp2px(3));
            this.mBubblePath.moveTo(((float) getMeasuredWidth()) / 2.0f, dp2px);
            this.mBubblePath.lineTo(measuredWidth - ((float) MultiColorUtils.dp2px(6)), dp2px2);
            this.mBubblePath.lineTo(measuredWidth + ((float) MultiColorUtils.dp2px(6)), dp2px2);
            this.mBubblePath.close();
            if (MultiColorSeekBar.this.mProgress >= MultiColorSeekBar.this.mDanger) {
                this.mBubblePaint.setColor(MultiColorSeekBar.this.mBubbleColor);
            } else {
                this.mBubblePaint.setColor(MultiColorSeekBar.this.mSecondTrackColor);
            }
            CornerPathEffect cornerPathEffect = new CornerPathEffect((float) MultiColorUtils.dp2px(1));
            PathEffect pathEffect = this.mBubblePaint.getPathEffect();
            this.mBubblePaint.setPathEffect(cornerPathEffect);
            canvas.drawPath(this.mBubblePath, this.mBubblePaint);
            this.mBubblePaint.setPathEffect(pathEffect);
            canvas.drawRoundRect(this.mBubbleRectF, (float) MultiColorUtils.dp2px(4), (float) MultiColorUtils.dp2px(4), this.mBubblePaint);
            this.mBubblePaint.setTextSize((float) MultiColorSeekBar.this.mBubbleTextSize);
            if (MultiColorSeekBar.this.mProgress >= MultiColorSeekBar.this.mDanger) {
                this.mBubblePaint.setColor(MultiColorSeekBar.this.mBubbleTextColor);
            } else {
                this.mBubblePaint.setColor(getResources().getColor(R$color.color_FFFFFF));
            }
            Paint paint = this.mBubblePaint;
            String str = this.mProgressText;
            paint.getTextBounds(str, 0, str.length(), this.mRect);
            Paint.FontMetrics fontMetrics = this.mBubblePaint.getFontMetrics();
            float f11 = fontMetrics.descent;
            canvas.drawText(this.mProgressText, ((float) getMeasuredWidth()) / 2.0f, ((((float) MultiColorSeekBar.this.mBubbleRadius) * 1.95f) + ((f11 - fontMetrics.ascent) / 2.0f)) - f11, this.mBubblePaint);
        }

        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            setMeasuredDimension(MultiColorSeekBar.this.mBubbleRadius * 3, MultiColorSeekBar.this.mBubbleRadius * 3);
            this.mBubbleRectF.set((((float) getMeasuredWidth()) / 2.0f) - ((float) MultiColorSeekBar.this.mBubbleRadius), ((float) MultiColorSeekBar.this.mBubbleRadius) * 1.25f, (((float) getMeasuredWidth()) / 2.0f) + ((float) MultiColorSeekBar.this.mBubbleRadius), ((float) MultiColorSeekBar.this.mBubbleRadius) * 2.65f);
        }

        public void setProgressText(String str) {
            if (str != null && !this.mProgressText.equals(str)) {
                this.mProgressText = str;
                invalidate();
            }
        }

        public MultiColorView(MultiColorSeekBar multiColorSeekBar, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public MultiColorView(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
            this.mProgressText = "";
            Paint paint = new Paint();
            this.mBubblePaint = paint;
            paint.setAntiAlias(true);
            this.mBubblePaint.setTextAlign(Paint.Align.CENTER);
            this.mBubblePath = new Path();
            this.mBubbleRectF = new RectF();
            this.mRect = new Rect();
        }
    }

    public interface OnProgressChangedListener {
        void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11);

        void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11);

        void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11);
    }

    public static abstract class OnProgressChangedListenerAdapter implements OnProgressChangedListener {
        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextPosition {
        public static final int BELOW_SECTION_MARK = 2;
        public static final int BOTTOM_SIDES = 1;
        public static final int SIDES = 0;
    }

    public MultiColorSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void autoAdjustSection() {
        ValueAnimator valueAnimator;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i11 = 0;
        while (i11 <= this.mSectionCount) {
            float f13 = this.mSectionOffset;
            f12 = (((float) i11) * f13) + this.mLeft;
            float f14 = this.mThumbCenterX;
            if (f12 <= f14 && f14 - f12 <= f13) {
                break;
            }
            i11++;
        }
        boolean z11 = BigDecimal.valueOf((double) this.mThumbCenterX).setScale(1, 4).floatValue() == f12;
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimator2 = null;
        if (!z11) {
            float f15 = this.mThumbCenterX;
            float f16 = this.mSectionOffset;
            if (f15 - f12 <= f16 / 2.0f) {
                valueAnimator = ValueAnimator.ofFloat(new float[]{f15, f12});
            } else {
                valueAnimator = ValueAnimator.ofFloat(new float[]{f15, (((float) (i11 + 1)) * f16) + this.mLeft});
            }
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(new LinearInterpolator());
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = MultiColorSeekBar.this.mThumbCenterX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MultiColorSeekBar multiColorSeekBar = MultiColorSeekBar.this;
                    float unused2 = multiColorSeekBar.mProgress = multiColorSeekBar.calculateProgress();
                    if (MultiColorSeekBar.this.isHideBubble || MultiColorSeekBar.this.mBubbleView.getParent() == null) {
                        float unused3 = MultiColorSeekBar.this.processProgress();
                    } else {
                        MultiColorSeekBar multiColorSeekBar2 = MultiColorSeekBar.this;
                        float unused4 = multiColorSeekBar2.mBubbleCenterRawX = multiColorSeekBar2.calculateCenterRawXofBubbleView();
                        MultiColorSeekBar multiColorSeekBar3 = MultiColorSeekBar.this;
                        multiColorSeekBar3.mLayoutParams.x = (int) (multiColorSeekBar3.mBubbleCenterRawX + 0.5f);
                        MultiColorSeekBar multiColorSeekBar4 = MultiColorSeekBar.this;
                        multiColorSeekBar4.mWindowManager.updateViewLayout(multiColorSeekBar4.mBubbleView, multiColorSeekBar4.mLayoutParams);
                        MultiColorSeekBar multiColorSeekBar5 = MultiColorSeekBar.this;
                        multiColorSeekBar5.mBubbleView.setProgressText(multiColorSeekBar5.caculateProgressText());
                    }
                    MultiColorSeekBar.this.invalidate();
                    if (MultiColorSeekBar.this.mProgressListener != null) {
                        OnProgressChangedListener access$900 = MultiColorSeekBar.this.mProgressListener;
                        MultiColorSeekBar multiColorSeekBar6 = MultiColorSeekBar.this;
                        access$900.onProgressChanged(multiColorSeekBar6, multiColorSeekBar6.getProgress(), MultiColorSeekBar.this.getProgressFloat(), true);
                    }
                }
            });
        }
        if (!this.isHideBubble) {
            MultiColorView multiColorView = this.mBubbleView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            if (this.isAlwaysShowBubble) {
                f11 = 1.0f;
            }
            fArr[0] = f11;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(multiColorView, property, fArr);
            if (z11) {
                animatorSet.setDuration(this.mAnimDuration).play(ofFloat);
            } else {
                animatorSet.setDuration(this.mAnimDuration).playTogether(new Animator[]{valueAnimator2, ofFloat});
            }
        } else if (!z11) {
            animatorSet.setDuration(this.mAnimDuration).playTogether(new Animator[]{valueAnimator2});
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (!MultiColorSeekBar.this.isHideBubble && !MultiColorSeekBar.this.isAlwaysShowBubble) {
                    MultiColorSeekBar.this.hideBubble();
                }
                MultiColorSeekBar multiColorSeekBar = MultiColorSeekBar.this;
                float unused = multiColorSeekBar.mProgress = multiColorSeekBar.calculateProgress();
                boolean unused2 = MultiColorSeekBar.this.isThumbOnDragging = false;
                boolean unused3 = MultiColorSeekBar.this.isTouchToSeekAnimEnd = true;
                MultiColorSeekBar.this.invalidate();
            }

            public void onAnimationEnd(Animator animator) {
                if (!MultiColorSeekBar.this.isHideBubble && !MultiColorSeekBar.this.isAlwaysShowBubble) {
                    MultiColorSeekBar.this.hideBubble();
                }
                MultiColorSeekBar multiColorSeekBar = MultiColorSeekBar.this;
                float unused = multiColorSeekBar.mProgress = multiColorSeekBar.calculateProgress();
                boolean unused2 = MultiColorSeekBar.this.isThumbOnDragging = false;
                boolean unused3 = MultiColorSeekBar.this.isTouchToSeekAnimEnd = true;
                MultiColorSeekBar.this.invalidate();
                if (MultiColorSeekBar.this.mProgressListener != null) {
                    OnProgressChangedListener access$900 = MultiColorSeekBar.this.mProgressListener;
                    MultiColorSeekBar multiColorSeekBar2 = MultiColorSeekBar.this;
                    access$900.getProgressOnFinally(multiColorSeekBar2, multiColorSeekBar2.getProgress(), MultiColorSeekBar.this.getProgressFloat(), true);
                }
            }
        });
        animatorSet.start();
    }

    private float calThumbCxWhenSeekStepSection(float f11) {
        float f12 = this.mLeft;
        if (f11 <= f12) {
            return f12;
        }
        float f13 = this.mRight;
        if (f11 >= f13) {
            return f13;
        }
        float f14 = 0.0f;
        int i11 = 0;
        while (i11 <= this.mSectionCount) {
            float f15 = this.mSectionOffset;
            f14 = (((float) i11) * f15) + this.mLeft;
            if (f14 <= f11 && f11 - f14 <= f15) {
                break;
            }
            i11++;
        }
        float f16 = this.mSectionOffset;
        if (f11 - f14 <= f16 / 2.0f) {
            return f14;
        }
        return (((float) (i11 + 1)) * f16) + this.mLeft;
    }

    /* access modifiers changed from: private */
    public float calculateCenterRawXofBubbleView() {
        if (this.isRtl) {
            return this.mBubbleCenterRawSolidX - ((this.mTrackLength * (this.mProgress - this.mMin)) / this.mDelta);
        }
        return this.mBubbleCenterRawSolidX + ((this.mTrackLength * (this.mProgress - this.mMin)) / this.mDelta);
    }

    /* access modifiers changed from: private */
    public float calculateProgress() {
        float f11;
        float f12;
        if (this.isRtl) {
            f11 = ((this.mRight - this.mThumbCenterX) * this.mDelta) / this.mTrackLength;
            f12 = this.mMin;
        } else {
            f11 = ((this.mThumbCenterX - this.mLeft) * this.mDelta) / this.mTrackLength;
            f12 = this.mMin;
        }
        return f11 + f12;
    }

    private void calculateRadiusOfBubble() {
        String str;
        String str2;
        this.mPaint.setTextSize((float) this.mBubbleTextSize);
        if (this.isShowProgressInFloat) {
            str = float2String(this.isRtl ? this.mMax : this.mMin);
        } else if (this.isRtl) {
            str = this.isFloatType ? float2String(this.mMax) : String.valueOf((int) this.mMax);
        } else {
            str = this.isFloatType ? float2String(this.mMin) : String.valueOf((int) this.mMin);
        }
        this.mPaint.getTextBounds(str, 0, str.length(), this.mRectText);
        int width = (this.mRectText.width() + (this.mTextSpace * 2)) >> 1;
        if (this.isShowProgressInFloat) {
            str2 = float2String(this.isRtl ? this.mMin : this.mMax);
        } else if (this.isRtl) {
            str2 = this.isFloatType ? float2String(this.mMin) : String.valueOf((int) this.mMin);
        } else {
            str2 = this.isFloatType ? float2String(this.mMax) : String.valueOf((int) this.mMax);
        }
        this.mPaint.getTextBounds(str2, 0, str2.length(), this.mRectText);
        int dp2px = MultiColorUtils.dp2px(10);
        this.mBubbleRadius = dp2px;
        this.mBubbleRadius = Math.max(dp2px, Math.max(width, (this.mRectText.width() + (this.mTextSpace * 2)) >> 1)) + this.mTextSpace;
    }

    private String float2String(float f11) {
        return String.valueOf(formatFloat(f11));
    }

    private float formatFloat(float f11) {
        return BigDecimal.valueOf((double) f11).setScale(this.mPrecision, 4).floatValue();
    }

    /* access modifiers changed from: private */
    public void hideBubble() {
        MultiColorView multiColorView = this.mBubbleView;
        if (multiColorView != null) {
            multiColorView.setVisibility(8);
            if (this.mBubbleView.getParent() != null) {
                this.mWindowManager.removeViewImmediate(this.mBubbleView);
            }
        }
    }

    private boolean isThumbTouched(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float f11 = (this.mTrackLength / this.mDelta) * (this.mProgress - this.mMin);
        float f12 = this.isRtl ? this.mRight - f11 : this.mLeft + f11;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (((motionEvent.getX() - f12) * (motionEvent.getX() - f12)) + ((motionEvent.getY() - measuredHeight) * (motionEvent.getY() - measuredHeight)) <= (this.mLeft + ((float) MultiColorUtils.dp2px(8))) * (this.mLeft + ((float) MultiColorUtils.dp2px(8)))) {
            return true;
        }
        return false;
    }

    private boolean isTrackTouched(MotionEvent motionEvent) {
        return isEnabled() && motionEvent.getX() >= ((float) getPaddingLeft()) && motionEvent.getX() <= ((float) (getMeasuredWidth() - getPaddingRight())) && motionEvent.getY() >= ((float) getPaddingTop()) && motionEvent.getY() <= ((float) (getMeasuredHeight() - getPaddingBottom()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$0() {
        if (!this.isUserTouchToSeek) {
            this.isTouchToSeekAnimEnd = false;
            autoAdjustSection();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$1() {
        if (!this.isUserTouchToSeek) {
            this.mBubbleView.animate().setDuration(this.mAnimDuration).setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    if (!MultiColorSeekBar.this.isUserTouchToSeek) {
                        if (!MultiColorSeekBar.this.isAlwaysShowBubble) {
                            MultiColorSeekBar.this.hideBubble();
                        }
                        boolean unused = MultiColorSeekBar.this.isThumbOnDragging = false;
                        MultiColorSeekBar.this.invalidate();
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!MultiColorSeekBar.this.isUserTouchToSeek) {
                        if (!MultiColorSeekBar.this.isAlwaysShowBubble) {
                            MultiColorSeekBar.this.hideBubble();
                        }
                        boolean unused = MultiColorSeekBar.this.isThumbOnDragging = false;
                        MultiColorSeekBar.this.invalidate();
                    }
                }
            }).start();
        }
    }

    private void locatePositionInWindow() {
        locatePositionInWindow(false, 0, 0);
    }

    /* access modifiers changed from: private */
    public float processProgress() {
        float f11 = this.mProgress;
        if (!this.isSeekBySection || !this.triggerSeekBySection) {
            return f11;
        }
        float f12 = this.mSectionValue / 2.0f;
        if (this.isTouchToSeek) {
            if (f11 == this.mMin || f11 == this.mMax) {
                return f11;
            }
            for (int i11 = 0; i11 <= this.mSectionCount; i11++) {
                float f13 = this.mSectionValue;
                float f14 = ((float) i11) * f13;
                if (f14 < f11 && f14 + f13 >= f11) {
                    return f12 + f14 > f11 ? f14 : f14 + f13;
                }
            }
        }
        float f15 = this.mPreSecValue;
        if (f11 >= f15) {
            if (f11 < f12 + f15) {
                return f15;
            }
            float f16 = f15 + this.mSectionValue;
            this.mPreSecValue = f16;
            return f16;
        } else if (f11 >= f15 - f12) {
            return f15;
        } else {
            float f17 = f15 - this.mSectionValue;
            this.mPreSecValue = f17;
            return f17;
        }
    }

    /* access modifiers changed from: private */
    public void showBubble() {
        MultiColorView multiColorView = this.mBubbleView;
        if (multiColorView != null && multiColorView.getParent() == null) {
            WindowManager.LayoutParams layoutParams = this.mLayoutParams;
            layoutParams.x = (int) (this.mBubbleCenterRawX + 0.5f);
            layoutParams.y = (int) (this.mBubbleCenterRawSolidY + 0.5f);
            this.mBubbleView.setAlpha(0.0f);
            this.mBubbleView.setVisibility(0);
            this.mBubbleView.animate().alpha(1.0f).setDuration(this.isTouchToSeek ? 0 : this.mAnimDuration).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    MultiColorSeekBar multiColorSeekBar = MultiColorSeekBar.this;
                    multiColorSeekBar.mWindowManager.addView(multiColorSeekBar.mBubbleView, multiColorSeekBar.mLayoutParams);
                }
            }).start();
            this.mBubbleView.setProgressText(caculateProgressText());
        }
    }

    public float adjustBubbleCenterRawSolidY(float f11) {
        return f11;
    }

    public String caculateProgressText() {
        if (this.isShowProgressInFloat) {
            return String.valueOf(getProgressFloat());
        }
        if (getProgress() == 0) {
            return String.valueOf(getProgress());
        }
        return getProgress() + this.unit;
    }

    public float caculateSectionValue(float f11, int i11) {
        return f11 / ((float) i11);
    }

    public void config(MultiConfigBuilder multiConfigBuilder) {
        this.mMin = multiConfigBuilder.min;
        this.mMax = multiConfigBuilder.max;
        this.mProgress = multiConfigBuilder.progress;
        this.isFloatType = multiConfigBuilder.floatType;
        this.mTrackSize = multiConfigBuilder.trackSize;
        this.mSecondTrackSize = multiConfigBuilder.secondTrackSize;
        this.mThumbRadius = multiConfigBuilder.thumbRadius;
        this.mThumbRadiusOnDragging = multiConfigBuilder.thumbRadiusOnDragging;
        this.mTrackColor = multiConfigBuilder.trackColor;
        this.mSecondTrackColor = multiConfigBuilder.secondTrackColor;
        this.mThumbColor = multiConfigBuilder.thumbColor;
        this.mSectionCount = multiConfigBuilder.sectionCount;
        this.isShowSectionMark = multiConfigBuilder.showSectionMark;
        this.isAutoAdjustSectionMark = multiConfigBuilder.autoAdjustSectionMark;
        this.isShowSectionText = multiConfigBuilder.showSectionText;
        this.mSectionTextSize = multiConfigBuilder.sectionTextSize;
        this.mSectionTextColor = multiConfigBuilder.sectionTextColor;
        this.mSectionTextPosition = multiConfigBuilder.sectionTextPosition;
        this.mSectionTextInterval = multiConfigBuilder.sectionTextInterval;
        this.isShowThumbText = multiConfigBuilder.showThumbText;
        this.mThumbTextSize = multiConfigBuilder.thumbTextSize;
        this.mThumbTextColor = multiConfigBuilder.thumbTextColor;
        this.isShowProgressInFloat = multiConfigBuilder.showProgressInFloat;
        this.mAnimDuration = multiConfigBuilder.animDuration;
        this.isTouchToSeek = multiConfigBuilder.touchToSeek;
        this.isSeekStepSection = multiConfigBuilder.seekStepSection;
        this.isSeekBySection = multiConfigBuilder.seekBySection;
        this.mBubbleColor = multiConfigBuilder.bubbleColor;
        this.mBubbleTextSize = multiConfigBuilder.bubbleTextSize;
        this.mBubbleTextColor = multiConfigBuilder.bubbleTextColor;
        this.isAlwaysShowBubble = multiConfigBuilder.alwaysShowBubble;
        this.mAlwaysShowBubbleDelay = multiConfigBuilder.alwaysShowBubbleDelay;
        this.isHideBubble = multiConfigBuilder.hideBubble;
        this.isRtl = multiConfigBuilder.rtl;
        this.mDanger = multiConfigBuilder.danger;
        this.mDangerColor = multiConfigBuilder.dangerColor;
        this.mCircleColor = multiConfigBuilder.circleColor;
        this.mOuterCirColor = multiConfigBuilder.outercircleColor;
        this.mPrecision = multiConfigBuilder.precision;
        initConfigByPriority();
        calculateRadiusOfBubble();
        OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onProgressChanged(this, getProgress(), getProgressFloat(), false);
            this.mProgressListener.getProgressOnFinally(this, getProgress(), getProgressFloat(), false);
        }
        requestLayout();
    }

    public void correctOffsetWhenContainerOnScrolling() {
        if (!this.isHideBubble) {
            d.j("MultiColorSeekBar", "主动校准");
            locatePositionInWindow(false, 0, 0);
            if (this.mBubbleView.getParent() == null) {
                return;
            }
            if (this.isAlwaysShowBubble) {
                WindowManager.LayoutParams layoutParams = this.mLayoutParams;
                layoutParams.y = (int) (this.mBubbleCenterRawSolidY + 0.5f);
                this.mWindowManager.updateViewLayout(this.mBubbleView, layoutParams);
                return;
            }
            postInvalidate();
        }
    }

    public MultiConfigBuilder getConfigBuilder() {
        if (this.mConfigBuilder == null) {
            this.mConfigBuilder = new MultiConfigBuilder(this);
        }
        MultiConfigBuilder multiConfigBuilder = this.mConfigBuilder;
        multiConfigBuilder.min = this.mMin;
        multiConfigBuilder.max = this.mMax;
        multiConfigBuilder.progress = this.mProgress;
        multiConfigBuilder.floatType = this.isFloatType;
        multiConfigBuilder.trackSize = this.mTrackSize;
        multiConfigBuilder.secondTrackSize = this.mSecondTrackSize;
        multiConfigBuilder.thumbRadius = this.mThumbRadius;
        multiConfigBuilder.thumbRadiusOnDragging = this.mThumbRadiusOnDragging;
        multiConfigBuilder.trackColor = this.mTrackColor;
        multiConfigBuilder.secondTrackColor = this.mSecondTrackColor;
        multiConfigBuilder.thumbColor = this.mThumbColor;
        multiConfigBuilder.sectionCount = this.mSectionCount;
        multiConfigBuilder.showSectionMark = this.isShowSectionMark;
        multiConfigBuilder.autoAdjustSectionMark = this.isAutoAdjustSectionMark;
        multiConfigBuilder.showSectionText = this.isShowSectionText;
        multiConfigBuilder.sectionTextSize = this.mSectionTextSize;
        multiConfigBuilder.sectionTextColor = this.mSectionTextColor;
        multiConfigBuilder.sectionTextPosition = this.mSectionTextPosition;
        multiConfigBuilder.sectionTextInterval = this.mSectionTextInterval;
        multiConfigBuilder.showThumbText = this.isShowThumbText;
        multiConfigBuilder.thumbTextSize = this.mThumbTextSize;
        multiConfigBuilder.thumbTextColor = this.mThumbTextColor;
        multiConfigBuilder.showProgressInFloat = this.isShowProgressInFloat;
        multiConfigBuilder.animDuration = this.mAnimDuration;
        multiConfigBuilder.touchToSeek = this.isTouchToSeek;
        multiConfigBuilder.seekStepSection = this.isSeekStepSection;
        multiConfigBuilder.seekBySection = this.isSeekBySection;
        multiConfigBuilder.bubbleColor = this.mBubbleColor;
        multiConfigBuilder.bubbleTextSize = this.mBubbleTextSize;
        multiConfigBuilder.bubbleTextColor = this.mBubbleTextColor;
        multiConfigBuilder.alwaysShowBubble = this.isAlwaysShowBubble;
        multiConfigBuilder.alwaysShowBubbleDelay = this.mAlwaysShowBubbleDelay;
        multiConfigBuilder.hideBubble = this.isHideBubble;
        multiConfigBuilder.rtl = this.isRtl;
        multiConfigBuilder.danger = this.mDanger;
        multiConfigBuilder.dangerColor = this.mDangerColor;
        multiConfigBuilder.circleColor = this.mCircleColor;
        multiConfigBuilder.precision = this.mPrecision;
        return multiConfigBuilder;
    }

    public float getMax() {
        return this.mMax;
    }

    public float getMin() {
        return this.mMin;
    }

    public OnProgressChangedListener getOnProgressChangedListener() {
        return this.mProgressListener;
    }

    public int getProgress() {
        return Math.round(processProgress());
    }

    public float getProgressFloat() {
        return formatFloat(processProgress());
    }

    public void initConfigByPriority() {
        if (this.mMin == this.mMax) {
            this.mMin = 0.0f;
            this.mMax = 100.0f;
        }
        float f11 = this.mMin;
        float f12 = this.mMax;
        if (f11 > f12) {
            this.mMax = f11;
            this.mMin = f12;
        }
        float f13 = this.mProgress;
        float f14 = this.mMin;
        if (f13 < f14) {
            this.mProgress = f14;
        }
        float f15 = this.mProgress;
        float f16 = this.mMax;
        if (f15 > f16) {
            this.mProgress = f16;
        }
        int i11 = this.mSecondTrackSize;
        int i12 = this.mTrackSize;
        if (i11 < i12) {
            this.mSecondTrackSize = i12 + MultiColorUtils.dp2px(2);
        }
        int i13 = this.mThumbRadius;
        int i14 = this.mSecondTrackSize;
        if (i13 <= i14) {
            this.mThumbRadius = i14 + MultiColorUtils.dp2px(2);
        }
        int i15 = this.mThumbRadiusOnDragging;
        int i16 = this.mSecondTrackSize;
        if (i15 <= i16) {
            this.mThumbRadiusOnDragging = i16 * 2;
        }
        if (this.mSectionCount <= 0) {
            this.mSectionCount = 10;
        }
        float f17 = this.mMax - this.mMin;
        this.mDelta = f17;
        float caculateSectionValue = caculateSectionValue(f17, this.mSectionCount);
        this.mSectionValue = caculateSectionValue;
        if (caculateSectionValue < 1.0f) {
            this.isFloatType = true;
        }
        if (this.isFloatType) {
            this.isShowProgressInFloat = true;
        }
        int i17 = this.mSectionTextPosition;
        if (i17 != -1) {
            this.isShowSectionText = true;
        }
        if (this.isShowSectionText) {
            if (i17 == -1) {
                this.mSectionTextPosition = 0;
            }
            if (this.mSectionTextPosition == 2) {
                this.isShowSectionMark = true;
            }
        }
        if (this.mSectionTextInterval < 1) {
            this.mSectionTextInterval = 1;
        }
        initSectionTextArray();
        if (this.isSeekStepSection) {
            this.isSeekBySection = false;
            this.isAutoAdjustSectionMark = false;
        }
        if (this.isAutoAdjustSectionMark && !this.isShowSectionMark) {
            this.isAutoAdjustSectionMark = false;
        }
        if (this.isSeekBySection) {
            float f18 = this.mMin;
            this.mPreSecValue = f18;
            if (this.mProgress != f18) {
                this.mPreSecValue = this.mSectionValue;
            }
            this.isShowSectionMark = true;
            this.isAutoAdjustSectionMark = true;
        }
        if (this.isHideBubble) {
            this.isAlwaysShowBubble = false;
        }
        if (this.isAlwaysShowBubble) {
            setProgress(this.mProgress);
        }
        this.mThumbTextSize = (this.isFloatType || this.isSeekBySection || (this.isShowSectionText && this.mSectionTextPosition == 2)) ? this.mSectionTextSize : this.mThumbTextSize;
    }

    public void initSectionTextArray() {
        String str;
        int i11 = 0;
        boolean z11 = true;
        boolean z12 = this.mSectionTextPosition == 2;
        if (this.mSectionTextInterval <= 1 || this.mSectionCount % 2 != 0) {
            z11 = false;
        }
        while (true) {
            int i12 = this.mSectionCount;
            if (i11 <= i12) {
                boolean z13 = this.isRtl;
                float f11 = z13 ? this.mMax - (this.mSectionValue * ((float) i11)) : this.mMin + (this.mSectionValue * ((float) i11));
                if (z12) {
                    if (z11) {
                        if (i11 % this.mSectionTextInterval != 0) {
                            i11++;
                        } else {
                            f11 = z13 ? this.mMax - (this.mSectionValue * ((float) i11)) : this.mMin + (this.mSectionValue * ((float) i11));
                        }
                    }
                } else if (!(i11 == 0 || i11 == i12)) {
                    i11++;
                }
                int i13 = (int) f11;
                SparseArray<String> sparseArray = this.mSectionTextArray;
                if (this.isFloatType) {
                    str = float2String(f11);
                } else if (i13 == 0) {
                    str = String.valueOf(i13);
                } else {
                    str = i13 + this.unit;
                }
                sparseArray.put(i11, str);
                i11++;
            } else {
                return;
            }
        }
    }

    public void onDetachedFromWindow() {
        hideBubble();
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0319, code lost:
        if (r2 != r0.mMax) goto L_0x032c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            super.onDraw(r17)
            int r1 = r16.getPaddingLeft()
            float r1 = (float) r1
            int r2 = r16.getMeasuredWidth()
            int r3 = r16.getPaddingRight()
            int r2 = r2 - r3
            float r2 = (float) r2
            int r3 = r16.getPaddingTop()
            int r4 = r0.mThumbRadiusOnDragging
            int r3 = r3 + r4
            float r8 = (float) r3
            boolean r3 = r0.isShowSectionText
            r4 = 10
            java.lang.String r5 = "0123456789"
            r6 = 1073741824(0x40000000, float:2.0)
            r9 = 1
            r10 = 0
            if (r3 == 0) goto L_0x00ff
            android.graphics.Paint r3 = r0.mPaint
            int r11 = r0.mSectionTextColor
            r3.setColor(r11)
            android.graphics.Paint r3 = r0.mPaint
            int r11 = r0.mSectionTextSize
            float r11 = (float) r11
            r3.setTextSize(r11)
            android.graphics.Paint r3 = r0.mPaint
            android.graphics.Rect r11 = r0.mRectText
            r3.getTextBounds(r5, r10, r4, r11)
            int r3 = r0.mSectionTextPosition
            if (r3 != 0) goto L_0x00ac
            android.graphics.Rect r3 = r0.mRectText
            int r3 = r3.height()
            float r3 = (float) r3
            float r3 = r3 / r6
            float r3 = r3 + r8
            android.util.SparseArray<java.lang.String> r11 = r0.mSectionTextArray
            java.lang.Object r11 = r11.get(r10)
            java.lang.String r11 = (java.lang.String) r11
            android.graphics.Paint r12 = r0.mPaint
            int r13 = r11.length()
            android.graphics.Rect r14 = r0.mRectText
            r12.getTextBounds(r11, r10, r13, r14)
            android.graphics.Rect r12 = r0.mRectText
            int r12 = r12.width()
            float r12 = (float) r12
            float r12 = r12 / r6
            float r12 = r12 + r1
            android.graphics.Paint r13 = r0.mPaint
            r7.drawText(r11, r12, r3, r13)
            android.graphics.Rect r11 = r0.mRectText
            int r11 = r11.width()
            int r12 = r0.mTextSpace
            int r11 = r11 + r12
            float r11 = (float) r11
            float r1 = r1 + r11
            android.util.SparseArray<java.lang.String> r11 = r0.mSectionTextArray
            int r12 = r0.mSectionCount
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            android.graphics.Paint r12 = r0.mPaint
            int r13 = r11.length()
            android.graphics.Rect r14 = r0.mRectText
            r12.getTextBounds(r11, r10, r13, r14)
            android.graphics.Rect r12 = r0.mRectText
            int r12 = r12.width()
            float r12 = (float) r12
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            float r12 = r12 / r6
            float r12 = r2 - r12
            android.graphics.Paint r13 = r0.mPaint
            r7.drawText(r11, r12, r3, r13)
            android.graphics.Rect r3 = r0.mRectText
            int r3 = r3.width()
            int r11 = r0.mTextSpace
            int r3 = r3 + r11
            float r3 = (float) r3
            float r2 = r2 - r3
            goto L_0x010c
        L_0x00ac:
            if (r3 < r9) goto L_0x010c
            int r1 = r0.mThumbRadiusOnDragging
            float r1 = (float) r1
            float r1 = r1 + r8
            int r2 = r0.mTextSpace
            float r2 = (float) r2
            float r1 = r1 + r2
            android.util.SparseArray<java.lang.String> r2 = r0.mSectionTextArray
            java.lang.Object r2 = r2.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            android.graphics.Paint r3 = r0.mPaint
            int r11 = r2.length()
            android.graphics.Rect r12 = r0.mRectText
            r3.getTextBounds(r2, r10, r11, r12)
            android.graphics.Rect r3 = r0.mRectText
            int r3 = r3.height()
            float r3 = (float) r3
            float r1 = r1 + r3
            float r3 = r0.mLeft
            int r11 = r0.mSectionTextPosition
            if (r11 != r9) goto L_0x00dc
            android.graphics.Paint r11 = r0.mPaint
            r7.drawText(r2, r3, r1, r11)
        L_0x00dc:
            android.util.SparseArray<java.lang.String> r2 = r0.mSectionTextArray
            int r11 = r0.mSectionCount
            java.lang.Object r2 = r2.get(r11)
            java.lang.String r2 = (java.lang.String) r2
            android.graphics.Paint r11 = r0.mPaint
            int r12 = r2.length()
            android.graphics.Rect r13 = r0.mRectText
            r11.getTextBounds(r2, r10, r12, r13)
            float r11 = r0.mRight
            int r12 = r0.mSectionTextPosition
            if (r12 != r9) goto L_0x00fc
            android.graphics.Paint r12 = r0.mPaint
            r7.drawText(r2, r11, r1, r12)
        L_0x00fc:
            r1 = r3
            r2 = r11
            goto L_0x010c
        L_0x00ff:
            boolean r3 = r0.isShowThumbText
            if (r3 == 0) goto L_0x010c
            int r3 = r0.mSectionTextPosition
            r11 = -1
            if (r3 != r11) goto L_0x010c
            float r1 = r0.mLeft
            float r2 = r0.mRight
        L_0x010c:
            boolean r3 = r0.isShowSectionText
            if (r3 != 0) goto L_0x0114
            boolean r11 = r0.isShowThumbText
            if (r11 == 0) goto L_0x0118
        L_0x0114:
            int r11 = r0.mSectionTextPosition
            if (r11 != 0) goto L_0x011e
        L_0x0118:
            int r11 = r0.mThumbRadius
            float r12 = (float) r11
            float r1 = r1 + r12
            float r11 = (float) r11
            float r2 = r2 - r11
        L_0x011e:
            r11 = r1
            r12 = r2
            r13 = 2
            if (r3 == 0) goto L_0x0129
            int r1 = r0.mSectionTextPosition
            if (r1 != r13) goto L_0x0129
            r1 = r9
            goto L_0x012a
        L_0x0129:
            r1 = r10
        L_0x012a:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            boolean r3 = r0.isRtl
            if (r3 == 0) goto L_0x014f
            float r3 = r0.mProgress
            float r14 = r0.mDanger
            int r15 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r15 <= 0) goto L_0x0143
            float r2 = r0.mTrackLength
            float r15 = r0.mDelta
            float r2 = r2 / r15
            float r15 = r0.mMin
            float r14 = r14 - r15
            float r2 = r2 * r14
            float r2 = r12 - r2
        L_0x0143:
            float r14 = r0.mTrackLength
            float r15 = r0.mDelta
            float r14 = r14 / r15
            float r15 = r0.mMin
            float r3 = r3 - r15
            float r14 = r14 * r3
            float r3 = r12 - r14
            goto L_0x016c
        L_0x014f:
            float r3 = r0.mProgress
            float r14 = r0.mDanger
            int r15 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r15 <= 0) goto L_0x0161
            float r2 = r0.mTrackLength
            float r15 = r0.mDelta
            float r2 = r2 / r15
            float r15 = r0.mMin
            float r14 = r14 - r15
            float r2 = r2 * r14
            float r2 = r2 + r11
        L_0x0161:
            float r14 = r0.mTrackLength
            float r15 = r0.mDelta
            float r14 = r14 / r15
            float r15 = r0.mMin
            float r3 = r3 - r15
            float r14 = r14 * r3
            float r3 = r11 + r14
        L_0x016c:
            r14 = r2
            if (r1 != 0) goto L_0x0173
            boolean r2 = r0.isShowSectionMark
            if (r2 == 0) goto L_0x02a3
        L_0x0173:
            android.graphics.Paint r2 = r0.mPaint
            int r9 = r0.mSectionTextSize
            float r9 = (float) r9
            r2.setTextSize(r9)
            android.graphics.Paint r2 = r0.mPaint
            android.graphics.Rect r9 = r0.mRectText
            r2.getTextBounds(r5, r10, r4, r9)
            android.graphics.Rect r2 = r0.mRectText
            int r2 = r2.height()
            float r2 = (float) r2
            float r2 = r2 + r8
            int r9 = r0.mThumbRadiusOnDragging
            float r9 = (float) r9
            float r2 = r2 + r9
            int r9 = r0.mTextSpace
            float r9 = (float) r9
            float r2 = r2 + r9
            boolean r9 = r0.isRtl
            if (r9 == 0) goto L_0x01a9
            float r9 = r0.mRight
            float r4 = r0.mTrackLength
            float r10 = r0.mDelta
            float r4 = r4 / r10
            float r10 = r0.mProgress
            float r6 = r0.mMin
            float r10 = r10 - r6
            float r6 = java.lang.Math.abs(r10)
            float r4 = r4 * r6
            float r9 = r9 - r4
            goto L_0x01bc
        L_0x01a9:
            float r4 = r0.mLeft
            float r6 = r0.mTrackLength
            float r9 = r0.mDelta
            float r6 = r6 / r9
            float r9 = r0.mProgress
            float r10 = r0.mMin
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            float r6 = r6 * r9
            float r9 = r4 + r6
        L_0x01bc:
            java.util.List<java.lang.Float> r4 = r0.mAnchor
            r4.clear()
            r4 = 0
        L_0x01c2:
            int r6 = r0.mSectionCount
            if (r4 > r6) goto L_0x02a3
            float r6 = (float) r4
            float r10 = r0.mSectionOffset
            float r6 = r6 * r10
            float r6 = r6 + r11
            int r10 = r0.mOuterCirColor
            android.graphics.Paint r13 = r0.mPaint
            r13.setColor(r10)
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x01df
            int r13 = r0.mThumbRadius
            float r13 = (float) r13
            android.graphics.Paint r15 = r0.mPaint
            r7.drawCircle(r12, r8, r13, r15)
            goto L_0x01e7
        L_0x01df:
            int r13 = r0.mThumbRadius
            float r13 = (float) r13
            android.graphics.Paint r15 = r0.mPaint
            r7.drawCircle(r6, r8, r13, r15)
        L_0x01e7:
            boolean r13 = r0.isRtl
            if (r13 == 0) goto L_0x01f5
            int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r13 > 0) goto L_0x01f2
            int r13 = r0.mTrackColor
            goto L_0x0229
        L_0x01f2:
            int r13 = r0.mSecondTrackColor
            goto L_0x0229
        L_0x01f5:
            r13 = 0
            int r15 = (r14 > r13 ? 1 : (r14 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x0220
            int r13 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r13 > 0) goto L_0x0208
            int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r13 > 0) goto L_0x0205
            int r13 = r0.mSecondTrackColor
            goto L_0x0229
        L_0x0205:
            int r13 = r0.mTrackColor
            goto L_0x0229
        L_0x0208:
            int r13 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r13 > 0) goto L_0x0216
            int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r13 > 0) goto L_0x0213
            int r13 = r0.mDangerColor
            goto L_0x0229
        L_0x0213:
            int r13 = r0.mTrackColor
            goto L_0x0229
        L_0x0216:
            int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r13 > 0) goto L_0x021d
            int r13 = r0.mSecondTrackColor
            goto L_0x0229
        L_0x021d:
            int r13 = r0.mTrackColor
            goto L_0x0229
        L_0x0220:
            int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r13 > 0) goto L_0x0227
            int r13 = r0.mSecondTrackColor
            goto L_0x0229
        L_0x0227:
            int r13 = r0.mTrackColor
        L_0x0229:
            android.graphics.Paint r15 = r0.mPaint
            r15.setColor(r13)
            if (r10 <= 0) goto L_0x023f
            int r10 = r0.mThumbRadius
            r13 = 2
            int r15 = com.huobi.view.seekbar.MultiColorUtils.dp2px((int) r13)
            int r10 = r10 - r15
            float r10 = (float) r10
            android.graphics.Paint r15 = r0.mPaint
            r7.drawCircle(r12, r8, r10, r15)
            goto L_0x024d
        L_0x023f:
            r13 = 2
            int r10 = r0.mThumbRadius
            int r15 = com.huobi.view.seekbar.MultiColorUtils.dp2px((int) r13)
            int r10 = r10 - r15
            float r10 = (float) r10
            android.graphics.Paint r13 = r0.mPaint
            r7.drawCircle(r6, r8, r10, r13)
        L_0x024d:
            java.util.List<java.lang.Float> r10 = r0.mAnchor
            java.lang.Float r13 = java.lang.Float.valueOf(r6)
            r10.add(r13)
            if (r1 == 0) goto L_0x029c
            android.graphics.Paint r10 = r0.mPaint
            int r13 = r0.mSectionTextColor
            r10.setColor(r13)
            android.util.SparseArray<java.lang.String> r10 = r0.mSectionTextArray
            r13 = 0
            java.lang.Object r10 = r10.get(r4, r13)
            if (r10 == 0) goto L_0x029c
            int r10 = r0.mSectionCount
            if (r4 != r10) goto L_0x028c
            android.graphics.Paint r10 = r0.mPaint
            android.util.SparseArray<java.lang.String> r13 = r0.mSectionTextArray
            java.lang.Object r13 = r13.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            float r10 = r10.measureText(r13)
            android.util.SparseArray<java.lang.String> r13 = r0.mSectionTextArray
            java.lang.Object r13 = r13.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            r15 = 1073741824(0x40000000, float:2.0)
            float r10 = r10 / r15
            float r6 = r6 - r10
            android.graphics.Paint r10 = r0.mPaint
            r7.drawText(r13, r6, r2, r10)
            goto L_0x029e
        L_0x028c:
            r15 = 1073741824(0x40000000, float:2.0)
            android.util.SparseArray<java.lang.String> r10 = r0.mSectionTextArray
            java.lang.Object r10 = r10.get(r4)
            java.lang.String r10 = (java.lang.String) r10
            android.graphics.Paint r13 = r0.mPaint
            r7.drawText(r10, r6, r2, r13)
            goto L_0x029e
        L_0x029c:
            r15 = 1073741824(0x40000000, float:2.0)
        L_0x029e:
            int r4 = r4 + 1
            r13 = 2
            goto L_0x01c2
        L_0x02a3:
            boolean r1 = r0.isThumbOnDragging
            if (r1 == 0) goto L_0x02ab
            boolean r2 = r0.isAlwaysShowBubble
            if (r2 == 0) goto L_0x02cd
        L_0x02ab:
            boolean r2 = r0.isRtl
            if (r2 == 0) goto L_0x02bf
            float r2 = r0.mTrackLength
            float r3 = r0.mDelta
            float r2 = r2 / r3
            float r3 = r0.mProgress
            float r4 = r0.mMin
            float r3 = r3 - r4
            float r2 = r2 * r3
            float r2 = r12 - r2
            r0.mThumbCenterX = r2
            goto L_0x02cd
        L_0x02bf:
            float r2 = r0.mTrackLength
            float r3 = r0.mDelta
            float r2 = r2 / r3
            float r3 = r0.mProgress
            float r4 = r0.mMin
            float r3 = r3 - r4
            float r2 = r2 * r3
            float r2 = r2 + r11
            r0.mThumbCenterX = r2
        L_0x02cd:
            boolean r2 = r0.isShowThumbText
            if (r2 == 0) goto L_0x033c
            if (r1 != 0) goto L_0x033c
            boolean r1 = r0.isTouchToSeekAnimEnd
            if (r1 == 0) goto L_0x033c
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mThumbTextColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mThumbTextSize
            float r2 = (float) r2
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.mPaint
            android.graphics.Rect r2 = r0.mRectText
            r3 = 10
            r9 = 0
            r1.getTextBounds(r5, r9, r3, r2)
            android.graphics.Rect r1 = r0.mRectText
            int r1 = r1.height()
            float r1 = (float) r1
            float r1 = r1 + r8
            int r2 = r0.mThumbRadiusOnDragging
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r0.mTextSpace
            float r2 = (float) r2
            float r1 = r1 + r2
            boolean r2 = r0.isFloatType
            if (r2 != 0) goto L_0x032c
            boolean r2 = r0.isShowProgressInFloat
            if (r2 == 0) goto L_0x031c
            int r2 = r0.mSectionTextPosition
            r3 = 1
            if (r2 != r3) goto L_0x031c
            float r2 = r0.mProgress
            float r3 = r0.mMin
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x031c
            float r3 = r0.mMax
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x031c
            goto L_0x032c
        L_0x031c:
            int r2 = r16.getProgress()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            float r3 = r0.mThumbCenterX
            android.graphics.Paint r4 = r0.mPaint
            r7.drawText(r2, r3, r1, r4)
            goto L_0x033d
        L_0x032c:
            float r2 = r16.getProgressFloat()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            float r3 = r0.mThumbCenterX
            android.graphics.Paint r4 = r0.mPaint
            r7.drawText(r2, r3, r1, r4)
            goto L_0x033d
        L_0x033c:
            r9 = 0
        L_0x033d:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            boolean r1 = r0.isRtl
            if (r1 == 0) goto L_0x035d
            float r2 = r0.mThumbCenterX
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r3 = r8
            r4 = r11
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x03ba
        L_0x035d:
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x03ae
            r10 = r9
            r2 = 0
        L_0x0367:
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            int r1 = r1.size()
            if (r10 >= r1) goto L_0x03ba
            if (r10 != 0) goto L_0x0380
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            java.lang.Object r1 = r1.get(r10)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            int r2 = r0.mThumbRadius
            goto L_0x03a8
        L_0x0380:
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            java.lang.Object r1 = r1.get(r10)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            int r3 = r0.mThumbRadius
            float r3 = (float) r3
            float r4 = r1 - r3
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r3 = r8
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            java.lang.Object r1 = r1.get(r10)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            int r2 = r0.mThumbRadius
        L_0x03a8:
            float r2 = (float) r2
            float r1 = r1 + r2
            r2 = r1
            int r10 = r10 + 1
            goto L_0x0367
        L_0x03ae:
            float r2 = r0.mThumbCenterX
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r3 = r8
            r4 = r12
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x03ba:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            boolean r1 = r0.isRtl
            if (r1 == 0) goto L_0x03dc
            float r4 = r0.mThumbCenterX
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r12
            r3 = r8
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x03d9:
            r1 = 0
            goto L_0x06d8
        L_0x03dc:
            r1 = 0
            int r2 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r2 <= 0) goto L_0x0645
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0610
            float r10 = r0.mThumbCenterX
        L_0x03eb:
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            int r1 = r1.size()
            if (r9 >= r1) goto L_0x03d9
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            java.lang.Object r1 = r1.get(r9)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            java.util.List<java.lang.Float> r2 = r0.mAnchor
            java.lang.Object r2 = r2.get(r9)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            int r3 = r0.mThumbRadiusOnDragging
            float r3 = (float) r3
            float r12 = r2 - r3
            java.util.List<java.lang.Float> r2 = r0.mAnchor
            java.lang.Object r2 = r2.get(r9)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            int r3 = r0.mThumbRadiusOnDragging
            float r3 = (float) r3
            float r13 = r2 + r3
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x049d
            int r1 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0445
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r10
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0515
        L_0x0445:
            int r1 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x0481
            int r1 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0481
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r14
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r14
            r4 = r10
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0515
        L_0x0481:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r10
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0515
        L_0x049d:
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 != 0) goto L_0x0518
            int r1 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x04c0
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r12
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0515
        L_0x04c0:
            int r1 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x04fb
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 >= 0) goto L_0x04fb
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r14
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r14
            r4 = r12
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0515
        L_0x04fb:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r12
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x0515:
            r11 = r10
            goto L_0x060c
        L_0x0518:
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0593
            if (r2 <= 0) goto L_0x0593
            int r1 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x053d
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r12
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0597
        L_0x053d:
            int r1 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x0578
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 >= 0) goto L_0x0578
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r14
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r14
            r4 = r12
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0597
        L_0x0578:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r12
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x0597
        L_0x0593:
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x059a
        L_0x0597:
            r11 = r13
            goto L_0x060c
        L_0x059a:
            int r1 = (r14 > r13 ? 1 : (r14 == r13 ? 0 : -1))
            if (r1 >= 0) goto L_0x05b9
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r13
            r3 = r8
            r4 = r13
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x060c
        L_0x05b9:
            int r2 = (r14 > r13 ? 1 : (r14 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x05f2
            if (r1 >= 0) goto L_0x05f2
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r13
            r3 = r8
            r4 = r14
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r14
            r4 = r13
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x060c
        L_0x05f2:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r13
            r3 = r8
            r4 = r13
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x060c:
            int r9 = r9 + 1
            goto L_0x03eb
        L_0x0610:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r14
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mSecondTrackSize
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            float r4 = r0.mThumbCenterX
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r14
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x03d9
        L_0x0645:
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x06ca
            float r10 = r0.mThumbCenterX
        L_0x064f:
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            int r1 = r1.size()
            if (r9 >= r1) goto L_0x03d9
            java.util.List<java.lang.Float> r1 = r0.mAnchor
            java.lang.Object r1 = r1.get(r9)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            java.util.List<java.lang.Float> r2 = r0.mAnchor
            java.lang.Object r2 = r2.get(r9)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            int r3 = r0.mThumbRadius
            float r3 = (float) r3
            float r4 = r2 - r3
            java.util.List<java.lang.Float> r2 = r0.mAnchor
            java.lang.Object r2 = r2.get(r9)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            int r3 = r0.mThumbRadius
            float r3 = (float) r3
            float r12 = r2 + r3
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x0695
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r4 = r10
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x06a3
        L_0x0695:
            int r2 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r2 != 0) goto L_0x06a5
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x06a3:
            r11 = r10
            goto L_0x06c7
        L_0x06a5:
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x06b6
            if (r2 <= 0) goto L_0x06b6
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x06ba
        L_0x06b6:
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x06bc
        L_0x06ba:
            r11 = r12
            goto L_0x06c7
        L_0x06bc:
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r12
            r3 = r8
            r4 = r12
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x06c7:
            int r9 = r9 + 1
            goto L_0x064f
        L_0x06ca:
            float r4 = r0.mThumbCenterX
            android.graphics.Paint r6 = r0.mPaint
            r1 = r17
            r2 = r11
            r3 = r8
            r5 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
            goto L_0x03d9
        L_0x06d8:
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x06e4
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mDangerColor
            r1.setColor(r2)
            goto L_0x06eb
        L_0x06e4:
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mCircleColor
            r1.setColor(r2)
        L_0x06eb:
            float r1 = r0.mThumbCenterX
            int r2 = r0.mThumbRadiusOnDragging
            float r2 = (float) r2
            android.graphics.Paint r3 = r0.mPaint
            r7.drawCircle(r1, r8, r2, r3)
            android.graphics.Paint r1 = r0.mPaint
            int r2 = r0.mOuterCirColor
            r1.setColor(r2)
            float r1 = r0.mThumbCenterX
            int r2 = r0.mThumbRadiusOnDragging
            r3 = 2
            int r3 = com.huobi.view.seekbar.MultiColorUtils.dp2px((int) r3)
            int r2 = r2 - r3
            float r2 = (float) r2
            android.graphics.Paint r3 = r0.mPaint
            r7.drawCircle(r1, r8, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.seekbar.MultiColorSeekBar.onDraw(android.graphics.Canvas):void");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (!this.isHideBubble) {
            getLocationOnScreen(this.mCurPoint);
            int[] iArr = this.mCurPoint;
            int i15 = iArr[0];
            int[] iArr2 = this.mPoint;
            if (i15 != iArr2[0] || iArr[1] != iArr2[1]) {
                d.j("MultiColorSeekBar", "自动校准");
                int[] iArr3 = this.mCurPoint;
                locatePositionInWindow(true, iArr3[0], iArr3[1]);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int i13 = this.mThumbRadiusOnDragging * 2;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize((float) this.mThumbTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            i13 += this.mRectText.height();
        }
        if (this.isShowSectionText && this.mSectionTextPosition >= 1) {
            this.mPaint.setTextSize((float) this.mSectionTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            i13 = Math.max(i13, (this.mThumbRadiusOnDragging * 2) + this.mRectText.height());
        }
        setMeasuredDimension(View.resolveSize(MultiColorUtils.dp2px(180), i11), i13 + (this.mTextSpace * 2) + getPaddingTop());
        this.mLeft = (float) (getPaddingLeft() + this.mThumbRadiusOnDragging);
        this.mRight = (float) ((getMeasuredWidth() - getPaddingRight()) - this.mThumbRadiusOnDragging);
        if (this.isShowSectionText) {
            this.mPaint.setTextSize((float) this.mSectionTextSize);
            int i14 = this.mSectionTextPosition;
            if (i14 == 0) {
                String str = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str, 0, str.length(), this.mRectText);
                this.mLeft += (float) (this.mRectText.width() + this.mTextSpace);
                String str2 = this.mSectionTextArray.get(this.mSectionCount);
                this.mPaint.getTextBounds(str2, 0, str2.length(), this.mRectText);
                this.mRight -= (float) (this.mRectText.width() + this.mTextSpace);
            } else if (i14 >= 1) {
                String str3 = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str3, 0, str3.length(), this.mRectText);
                this.mLeft = ((float) getPaddingLeft()) + Math.max((float) this.mThumbRadiusOnDragging, ((float) this.mRectText.width()) / 2.0f);
                String str4 = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str4, 0, str4.length(), this.mRectText);
                this.mRight = ((float) (getMeasuredWidth() - getPaddingRight())) - Math.max((float) this.mThumbRadiusOnDragging, ((float) this.mRectText.width()) / 2.0f);
            }
        } else if (this.isShowThumbText && this.mSectionTextPosition == -1) {
            this.mPaint.setTextSize((float) this.mThumbTextSize);
            String str5 = this.mSectionTextArray.get(0);
            this.mPaint.getTextBounds(str5, 0, str5.length(), this.mRectText);
            this.mLeft = ((float) getPaddingLeft()) + Math.max((float) this.mThumbRadiusOnDragging, ((float) this.mRectText.width()) / 2.0f) + ((float) this.mTextSpace);
            String str6 = this.mSectionTextArray.get(this.mSectionCount);
            this.mPaint.getTextBounds(str6, 0, str6.length(), this.mRectText);
            this.mRight = (((float) (getMeasuredWidth() - getPaddingRight())) - Math.max((float) this.mThumbRadiusOnDragging, ((float) this.mRectText.width()) / 2.0f)) - ((float) this.mTextSpace);
        }
        float f11 = this.mRight - this.mLeft;
        this.mTrackLength = f11;
        this.mSectionOffset = (f11 * 1.0f) / ((float) this.mSectionCount);
        if (!this.isHideBubble) {
            this.mBubbleView.measure(i11, i12);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mProgress = bundle.getFloat("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            MultiColorView multiColorView = this.mBubbleView;
            if (multiColorView != null) {
                multiColorView.setProgressText(caculateProgressText());
            }
            setProgress(this.mProgress);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.mProgress);
        return bundle;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        post(new Runnable() {
            public void run() {
                MultiColorSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 != 4) goto L_0x01b3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0116
            if (r0 == r2) goto L_0x009a
            r3 = 2
            if (r0 == r3) goto L_0x0015
            r3 = 3
            if (r0 == r3) goto L_0x009a
            r3 = 4
            if (r0 == r3) goto L_0x009a
            goto L_0x01b3
        L_0x0015:
            r5.isUserTouchToSeek = r2
            boolean r0 = r5.isThumbOnDragging
            if (r0 == 0) goto L_0x01b3
            boolean r0 = r5.isSeekStepSection
            if (r0 == 0) goto L_0x0034
            float r0 = r6.getX()
            float r0 = r5.calThumbCxWhenSeekStepSection(r0)
            float r3 = r5.mPreThumbCenterX
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0032
            r5.mPreThumbCenterX = r0
            r5.mThumbCenterX = r0
            goto L_0x004f
        L_0x0032:
            r0 = r1
            goto L_0x0050
        L_0x0034:
            float r0 = r6.getX()
            float r3 = r5.f19106dx
            float r0 = r0 + r3
            r5.mThumbCenterX = r0
            float r3 = r5.mLeft
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0045
            r5.mThumbCenterX = r3
        L_0x0045:
            float r0 = r5.mThumbCenterX
            float r3 = r5.mRight
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            r5.mThumbCenterX = r3
        L_0x004f:
            r0 = r2
        L_0x0050:
            if (r0 == 0) goto L_0x01b3
            float r0 = r5.calculateProgress()
            r5.mProgress = r0
            boolean r0 = r5.isHideBubble
            if (r0 != 0) goto L_0x0083
            com.huobi.view.seekbar.MultiColorSeekBar$MultiColorView r0 = r5.mBubbleView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0083
            float r0 = r5.calculateCenterRawXofBubbleView()
            r5.mBubbleCenterRawX = r0
            android.view.WindowManager$LayoutParams r3 = r5.mLayoutParams
            r4 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r4
            int r0 = (int) r0
            r3.x = r0
            android.view.WindowManager r0 = r5.mWindowManager
            com.huobi.view.seekbar.MultiColorSeekBar$MultiColorView r4 = r5.mBubbleView
            r0.updateViewLayout(r4, r3)
            com.huobi.view.seekbar.MultiColorSeekBar$MultiColorView r0 = r5.mBubbleView
            java.lang.String r3 = r5.caculateProgressText()
            r0.setProgressText(r3)
            goto L_0x0086
        L_0x0083:
            r5.processProgress()
        L_0x0086:
            r5.invalidate()
            com.huobi.view.seekbar.MultiColorSeekBar$OnProgressChangedListener r0 = r5.mProgressListener
            if (r0 == 0) goto L_0x01b3
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.onProgressChanged(r5, r3, r4, r2)
            goto L_0x01b3
        L_0x009a:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            r5.isUserTouchToSeek = r1
            boolean r0 = r5.isAutoAdjustSectionMark
            if (r0 == 0) goto L_0x00ba
            boolean r0 = r5.isTouchToSeek
            if (r0 == 0) goto L_0x00b6
            com.huobi.view.seekbar.a r0 = new com.huobi.view.seekbar.a
            r0.<init>(r5)
            long r3 = r5.mAnimDuration
            r5.postDelayed(r0, r3)
            goto L_0x00f8
        L_0x00b6:
            r5.autoAdjustSection()
            goto L_0x00f8
        L_0x00ba:
            boolean r0 = r5.isThumbOnDragging
            if (r0 != 0) goto L_0x00c2
            boolean r0 = r5.isTouchToSeek
            if (r0 == 0) goto L_0x00f8
        L_0x00c2:
            boolean r0 = r5.isHideBubble
            if (r0 == 0) goto L_0x00ee
            android.view.ViewPropertyAnimator r0 = r5.animate()
            long r3 = r5.mAnimDuration
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r3)
            boolean r3 = r5.isThumbOnDragging
            if (r3 != 0) goto L_0x00db
            boolean r3 = r5.isTouchToSeek
            if (r3 == 0) goto L_0x00db
            r3 = 300(0x12c, double:1.48E-321)
            goto L_0x00dd
        L_0x00db:
            r3 = 0
        L_0x00dd:
            android.view.ViewPropertyAnimator r0 = r0.setStartDelay(r3)
            com.huobi.view.seekbar.MultiColorSeekBar$2 r3 = new com.huobi.view.seekbar.MultiColorSeekBar$2
            r3.<init>()
            android.view.ViewPropertyAnimator r0 = r0.setListener(r3)
            r0.start()
            goto L_0x00f8
        L_0x00ee:
            com.huobi.view.seekbar.b r0 = new com.huobi.view.seekbar.b
            r0.<init>(r5)
            long r3 = r5.mAnimDuration
            r5.postDelayed(r0, r3)
        L_0x00f8:
            com.huobi.view.seekbar.MultiColorSeekBar$OnProgressChangedListener r0 = r5.mProgressListener
            if (r0 == 0) goto L_0x01b3
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.onProgressChanged(r5, r3, r4, r2)
            com.huobi.view.seekbar.MultiColorSeekBar$OnProgressChangedListener r0 = r5.mProgressListener
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.getProgressOnActionUp(r5, r3, r4)
            goto L_0x01b3
        L_0x0116:
            r5.performClick()
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            r5.isUserTouchToSeek = r2
            r5.locatePositionInWindow()
            boolean r0 = r5.isThumbTouched(r6)
            r5.isThumbOnDragging = r0
            if (r0 == 0) goto L_0x014c
            boolean r0 = r5.isSeekBySection
            if (r0 == 0) goto L_0x0137
            boolean r0 = r5.triggerSeekBySection
            if (r0 != 0) goto L_0x0137
            r5.triggerSeekBySection = r2
        L_0x0137:
            boolean r0 = r5.isAlwaysShowBubble
            if (r0 == 0) goto L_0x0141
            boolean r0 = r5.triggerBubbleShowing
            if (r0 != 0) goto L_0x0141
            r5.triggerBubbleShowing = r2
        L_0x0141:
            boolean r0 = r5.isHideBubble
            if (r0 != 0) goto L_0x0148
            r5.showBubble()
        L_0x0148:
            r5.invalidate()
            goto L_0x01aa
        L_0x014c:
            boolean r0 = r5.isTouchToSeek
            if (r0 == 0) goto L_0x01aa
            boolean r0 = r5.isTrackTouched(r6)
            if (r0 == 0) goto L_0x01aa
            r5.isThumbOnDragging = r2
            boolean r0 = r5.isSeekBySection
            if (r0 == 0) goto L_0x0162
            boolean r0 = r5.triggerSeekBySection
            if (r0 != 0) goto L_0x0162
            r5.triggerSeekBySection = r2
        L_0x0162:
            boolean r0 = r5.isAlwaysShowBubble
            if (r0 == 0) goto L_0x016b
            r5.hideBubble()
            r5.triggerBubbleShowing = r2
        L_0x016b:
            boolean r0 = r5.isSeekStepSection
            if (r0 == 0) goto L_0x017c
            float r0 = r6.getX()
            float r0 = r5.calThumbCxWhenSeekStepSection(r0)
            r5.mPreThumbCenterX = r0
            r5.mThumbCenterX = r0
            goto L_0x0194
        L_0x017c:
            float r0 = r6.getX()
            r5.mThumbCenterX = r0
            float r3 = r5.mLeft
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x018a
            r5.mThumbCenterX = r3
        L_0x018a:
            float r0 = r5.mThumbCenterX
            float r3 = r5.mRight
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0194
            r5.mThumbCenterX = r3
        L_0x0194:
            float r0 = r5.calculateProgress()
            r5.mProgress = r0
            boolean r0 = r5.isHideBubble
            if (r0 != 0) goto L_0x01a7
            float r0 = r5.calculateCenterRawXofBubbleView()
            r5.mBubbleCenterRawX = r0
            r5.showBubble()
        L_0x01a7:
            r5.invalidate()
        L_0x01aa:
            float r0 = r5.mThumbCenterX
            float r3 = r6.getX()
            float r0 = r0 - r3
            r5.f19106dx = r0
        L_0x01b3:
            boolean r0 = r5.isThumbOnDragging
            if (r0 != 0) goto L_0x01c1
            boolean r0 = r5.isTouchToSeek
            if (r0 != 0) goto L_0x01c1
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x01c2
        L_0x01c1:
            r1 = r2
        L_0x01c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.seekbar.MultiColorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onVisibilityChanged(View view, int i11) {
        if (!this.isHideBubble && this.isAlwaysShowBubble) {
            if (i11 != 0) {
                hideBubble();
            } else if (this.triggerBubbleShowing) {
                showBubble();
            }
            super.onVisibilityChanged(view, i11);
        }
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setBubbleColor(int i11) {
        if (this.mBubbleColor != i11) {
            this.mBubbleColor = i11;
            MultiColorView multiColorView = this.mBubbleView;
            if (multiColorView != null) {
                multiColorView.invalidate();
            }
        }
    }

    public void setCustomSectionTextArray(CustomSectionTextArray customSectionTextArray) {
        this.mSectionTextArray = customSectionTextArray.onCustomize(this.mSectionCount, this.mSectionTextArray);
        for (int i11 = 0; i11 <= this.mSectionCount; i11++) {
            if (this.mSectionTextArray.get(i11) == null) {
                this.mSectionTextArray.put(i11, "");
            }
        }
        this.isShowThumbText = false;
        requestLayout();
        invalidate();
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.mProgressListener = onProgressChangedListener;
    }

    public void setProgress(float f11) {
        this.mProgress = f11;
        if (f11 > getMax()) {
            this.mProgress = getMax();
        } else if (f11 < getMin()) {
            this.mProgress = getMin();
        }
        OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onProgressChanged(this, getProgress(), getProgressFloat(), false);
            this.mProgressListener.getProgressOnFinally(this, getProgress(), getProgressFloat(), false);
        }
        if (!this.isHideBubble) {
            this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
        }
        if (this.isAlwaysShowBubble) {
            hideBubble();
            postDelayed(new Runnable() {
                public void run() {
                    MultiColorSeekBar.this.showBubble();
                    boolean unused = MultiColorSeekBar.this.triggerBubbleShowing = true;
                }
            }, this.mAlwaysShowBubbleDelay);
        }
        if (this.isSeekBySection) {
            this.triggerSeekBySection = false;
        }
        postInvalidate();
    }

    public void setSecondTrackColor(int i11) {
        if (this.mSecondTrackColor != i11) {
            this.mSecondTrackColor = i11;
            invalidate();
        }
    }

    public void setThumbColor(int i11) {
        if (this.mThumbColor != i11) {
            this.mThumbColor = i11;
            invalidate();
        }
    }

    public void setTrackColor(int i11) {
        if (this.mTrackColor != i11) {
            this.mTrackColor = i11;
            invalidate();
        }
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public MultiColorSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void locatePositionInWindow(boolean z11, int i11, int i12) {
        if (!this.isHideBubble) {
            if (z11) {
                int[] iArr = this.mPoint;
                iArr[0] = i11;
                iArr[1] = i12;
            } else {
                getLocationOnScreen(this.mPoint);
            }
            int[] iArr2 = this.mPoint;
            iArr2[1] = iArr2[1] - ViewUtil.g();
            this.mBubbleView.measure(0, 0);
            int measuredHeight = this.mBubbleView.getMeasuredHeight();
            int[] iArr3 = this.mPoint;
            iArr3[1] = (iArr3[1] - measuredHeight) + MultiColorUtils.dp2px(3);
            d.j("MultiColorSeekBar", "skip:" + z11 + " x:" + this.mPoint[0] + " y:" + this.mPoint[1]);
            ViewParent parent = getParent();
            if (parent instanceof View) {
                View view = (View) parent;
                if (view.getMeasuredWidth() > 0) {
                    int[] iArr4 = this.mPoint;
                    iArr4[0] = iArr4[0] % view.getMeasuredWidth();
                }
            }
            if (this.isRtl) {
                this.mBubbleCenterRawSolidX = (((float) this.mPoint[0]) + this.mRight) - (((float) this.mBubbleView.getMeasuredWidth()) / 2.0f);
            } else {
                this.mBubbleCenterRawSolidX = (((float) this.mPoint[0]) + this.mLeft) - (((float) this.mBubbleView.getMeasuredWidth()) / 2.0f);
            }
            this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
            float f11 = (float) this.mPoint[1];
            this.mBubbleCenterRawSolidY = f11;
            this.mBubbleCenterRawSolidY = adjustBubbleCenterRawSolidY(f11);
        }
    }

    public MultiColorSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mSectionTextPosition = -1;
        this.mSectionTextArray = new SparseArray<>();
        this.unit = "%";
        this.mPoint = new int[2];
        this.isTouchToSeekAnimEnd = true;
        this.mPrecision = 1;
        this.mCurPoint = new int[2];
        this.mAnchor = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MultiColorSeekBar, i11, 0);
        this.mMin = obtainStyledAttributes.getFloat(R$styleable.MultiColorSeekBar_msb_min, 0.0f);
        this.mMax = obtainStyledAttributes.getFloat(R$styleable.MultiColorSeekBar_msb_max, 100.0f);
        this.mDanger = obtainStyledAttributes.getFloat(R$styleable.MultiColorSeekBar_msb_danger, 100.1f);
        this.mDangerColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_danger_color, this.mSecondTrackColor);
        this.mCircleColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_circle_color, this.mSecondTrackColor);
        this.mProgress = obtainStyledAttributes.getFloat(R$styleable.MultiColorSeekBar_msb_progress, this.mMin);
        this.isFloatType = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_is_float_type, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_track_size, MultiColorUtils.dp2px(2));
        this.mTrackSize = dimensionPixelSize;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_second_track_size, dimensionPixelSize + MultiColorUtils.dp2px(2));
        this.mSecondTrackSize = dimensionPixelSize2;
        this.mThumbRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_thumb_radius, dimensionPixelSize2 + MultiColorUtils.dp2px(2));
        this.mThumbRadiusOnDragging = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_thumb_radius_on_dragging, this.mSecondTrackSize * 2);
        this.mSectionCount = obtainStyledAttributes.getInteger(R$styleable.MultiColorSeekBar_msb_section_count, 4);
        this.mTrackColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_track_color, ContextCompat.getColor(context, R$color.colorPrimary));
        int color = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_second_track_color, ContextCompat.getColor(context, R$color.colorAccent));
        this.mSecondTrackColor = color;
        this.mThumbColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_thumb_color, color);
        this.isShowSectionText = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_show_section_text, false);
        this.mSectionTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_section_text_size, MultiColorUtils.sp2px(14));
        this.mSectionTextColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_section_text_color, this.mTrackColor);
        this.isSeekStepSection = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_seek_step_section, false);
        this.isSeekBySection = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_seek_by_section, false);
        int integer = obtainStyledAttributes.getInteger(R$styleable.MultiColorSeekBar_msb_section_text_position, -1);
        if (integer == 0) {
            this.mSectionTextPosition = 0;
        } else if (integer == 1) {
            this.mSectionTextPosition = 1;
        } else if (integer == 2) {
            this.mSectionTextPosition = 2;
        } else {
            this.mSectionTextPosition = -1;
        }
        this.mSectionTextInterval = obtainStyledAttributes.getInteger(R$styleable.MultiColorSeekBar_msb_section_text_interval, 1);
        this.isShowThumbText = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_show_thumb_text, false);
        this.mThumbTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_thumb_text_size, MultiColorUtils.sp2px(14));
        this.mThumbTextColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_thumb_text_color, this.mSecondTrackColor);
        this.mBubbleColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_bubble_color, this.mSecondTrackColor);
        this.mBubbleTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MultiColorSeekBar_msb_bubble_text_size, MultiColorUtils.sp2px(14));
        this.mBubbleTextColor = obtainStyledAttributes.getColor(R$styleable.MultiColorSeekBar_msb_bubble_text_color, -1);
        this.isShowSectionMark = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_show_section_mark, false);
        this.isAutoAdjustSectionMark = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_auto_adjust_section_mark, false);
        this.isShowProgressInFloat = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_show_progress_in_float, false);
        int integer2 = obtainStyledAttributes.getInteger(R$styleable.MultiColorSeekBar_msb_anim_duration, -1);
        this.mAnimDuration = integer2 < 0 ? 200 : (long) integer2;
        this.isTouchToSeek = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_touch_to_seek, false);
        this.isAlwaysShowBubble = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_always_show_bubble, false);
        int integer3 = obtainStyledAttributes.getInteger(R$styleable.MultiColorSeekBar_msb_always_show_bubble_delay, 0);
        this.mAlwaysShowBubbleDelay = integer3 < 0 ? 0 : (long) integer3;
        this.isHideBubble = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_hide_bubble, false);
        this.isRtl = obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_msb_rtl, false);
        setEnabled(obtainStyledAttributes.getBoolean(R$styleable.MultiColorSeekBar_android_enabled, isEnabled()));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mRectText = new Rect();
        this.mTextSpace = MultiColorUtils.dp2px(2);
        initConfigByPriority();
        if (!this.isHideBubble) {
            this.mWindowManager = (WindowManager) context.getSystemService("window");
            MultiColorView multiColorView = new MultiColorView(this, context);
            this.mBubbleView = multiColorView;
            multiColorView.setProgressText(caculateProgressText());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams = layoutParams;
            layoutParams.gravity = BadgeDrawable.TOP_START;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.flags = 524328;
            if (MultiColorUtils.isMIUI() || Build.VERSION.SDK_INT >= 25) {
                this.mLayoutParams.type = 2;
            } else {
                this.mLayoutParams.type = 2005;
            }
            calculateRadiusOfBubble();
        }
    }
}
