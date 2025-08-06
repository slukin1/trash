package com.huobi.view.bubbleseekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$styleable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;

public class BubbleSeekBar extends View implements GestureDetector.OnGestureListener {
    public static final int NONE = -1;
    /* access modifiers changed from: private */
    public int bubbleBackgroundColor;
    /* access modifiers changed from: private */
    public int bubbleViewHeight;

    /* renamed from: dx  reason: collision with root package name */
    public float f19003dx;
    /* access modifiers changed from: private */
    public boolean isAlwaysShowBubble;
    private boolean isAutoAdjustSectionMark;
    private boolean isFloatType;
    /* access modifiers changed from: private */
    public boolean isHideBubble;
    private boolean isRtl;
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
    private long mAlwaysShowBubbleDelay;
    /* access modifiers changed from: private */
    public long mAnimDuration;
    private float mBubbleCenterRawSolidX;
    private float mBubbleCenterRawSolidY;
    /* access modifiers changed from: private */
    public float mBubbleCenterRawX;
    /* access modifiers changed from: private */
    public int mBubbleColor;
    /* access modifiers changed from: private */
    public int mBubbleTextColor;
    /* access modifiers changed from: private */
    public int mBubbleTextSize;
    /* access modifiers changed from: private */
    public BubbleView mBubbleView;
    private BubbleConfigBuilder mConfigBuilder;
    private float mDelta;
    /* access modifiers changed from: private */
    public WindowManager.LayoutParams mLayoutParams;
    private float mLeft;
    private float mMax;
    private float mMin;
    private GestureDetector mOnGestureListener;
    private Paint mPaint;
    private int[] mPoint;
    private float mPreSecValue;
    private float mPreThumbCenterX;
    /* access modifiers changed from: private */
    public float mProgress;
    /* access modifiers changed from: private */
    public OnProgressChangedListener mProgressListener;
    private Rect mRectText;
    private float mRight;
    private int mSecondTrackColor;
    private int mSecondTrackSize;
    private int mSectionCount;
    private float mSectionOffset;
    private SparseArray<String> mSectionTextArray;
    private int mSectionTextColor;
    private int mSectionTextInterval;
    private int mSectionTextPosition;
    private int mSectionTextSize;
    private float mSectionValue;
    private int mTextSpace;
    private Bitmap mThumbBitmap;
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
    /* access modifiers changed from: private */
    public WindowManager mWindowManager;
    /* access modifiers changed from: private */
    public boolean triggerBubbleShowing;
    private boolean triggerSeekBySection;

    public class BubbleView extends View {
        private Paint mBubblePaint;
        private Path mBubblePath;
        private Paint mBubbleTextPaint;
        private String mProgressText;
        private Rect mRect;
        private float rectRadius;
        private float textWidth;
        private float triangleBase;
        private float triangleHeight;
        private float triangleRadius;

        public BubbleView(BubbleSeekBar bubbleSeekBar, Context context) {
            this(bubbleSeekBar, context, (AttributeSet) null);
        }

        public float getTotalWidth() {
            return ((float) (getPaddingLeft() + getPaddingRight())) + this.textWidth;
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
            float unused = bubbleSeekBar.mBubbleCenterRawX = bubbleSeekBar.calculateCenterRawXofBubbleView();
            float access$1900 = BubbleSeekBar.this.mBubbleCenterRawX;
            this.mBubblePath.reset();
            this.mBubblePath.reset();
            float totalWidth = getTotalWidth() / 2.0f;
            float f11 = access$1900 - totalWidth;
            float f12 = totalWidth + access$1900;
            float measuredHeight = (float) (getMeasuredHeight() - 2);
            float f13 = this.triangleBase;
            float f14 = measuredHeight - this.triangleHeight;
            this.mBubblePath.moveTo(access$1900 - (f13 / 2.0f), f14);
            this.mBubblePath.lineTo(this.rectRadius + f11, f14);
            Path path = this.mBubblePath;
            float f15 = this.rectRadius;
            path.arcTo(new RectF(f11, f14 - f15, f15 + f11, f14), 90.0f, 90.0f, false);
            this.mBubblePath.lineTo(f11, this.rectRadius + 10.0f);
            Path path2 = this.mBubblePath;
            float f16 = this.rectRadius;
            path2.arcTo(new RectF(f11, 10.0f, f11 + f16, f16 + 10.0f), 180.0f, 90.0f, false);
            this.mBubblePath.lineTo(f12 - this.rectRadius, 10.0f);
            Path path3 = this.mBubblePath;
            float f17 = this.rectRadius;
            path3.arcTo(new RectF(f12 - f17, 10.0f, f12, f17 + 10.0f), 270.0f, 90.0f, false);
            this.mBubblePath.lineTo(f12, f14 - this.rectRadius);
            Path path4 = this.mBubblePath;
            float f18 = this.rectRadius;
            path4.arcTo(new RectF(f12 - f18, f14 - f18, f12, f14), 0.0f, 90.0f, false);
            this.mBubblePath.lineTo((f13 / 2.0f) + access$1900, f14);
            double sin = ((double) this.triangleRadius) * Math.sin(45.0d);
            this.mBubblePath.lineTo((float) ((int) (((double) access$1900) + sin)), (float) ((int) (((double) (measuredHeight - this.triangleRadius)) + sin)));
            Path path5 = this.mBubblePath;
            float f19 = this.triangleRadius;
            path5.arcTo(new RectF(access$1900 - f19, measuredHeight - (f19 * 2.0f), f19 + access$1900, measuredHeight), 45.0f, 90.0f, false);
            this.mBubblePath.close();
            this.mBubblePaint.setShadowLayer(15.0f, 0.0f, 0.0f, BubbleSeekBar.this.mBubbleColor);
            this.mBubblePaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mBubblePaint.setColor(BubbleSeekBar.this.bubbleBackgroundColor);
            canvas.drawPath(this.mBubblePath, this.mBubblePaint);
            this.mBubblePaint.clearShadowLayer();
            this.mBubblePaint.setStyle(Paint.Style.STROKE);
            this.mBubblePaint.setColor(Color.parseColor("#80C5CFD5"));
            canvas.drawPath(this.mBubblePath, this.mBubblePaint);
            Paint.FontMetrics fontMetrics = this.mBubbleTextPaint.getFontMetrics();
            canvas.drawText(this.mProgressText, access$1900, (((measuredHeight + 10.0f) - ((float) (BubbleSeekBar.this.bubbleViewHeight >> 1))) + (((-fontMetrics.ascent) - fontMetrics.descent) / 2.0f)) - 5.0f, this.mBubbleTextPaint);
        }

        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
        }

        public void setProgressText(String str) {
            if (str != null && !this.mProgressText.equals(str)) {
                String str2 = str + "%";
                this.mProgressText = str2;
                this.textWidth = this.mBubbleTextPaint.measureText(str2);
                invalidate();
            }
        }

        public BubbleView(BubbleSeekBar bubbleSeekBar, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public BubbleView(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
            this.mProgressText = "0";
            this.triangleBase = 30.0f;
            this.triangleHeight = 15.0f;
            this.triangleRadius = 3.0f;
            this.rectRadius = (float) PixelUtils.a(6.0f);
            Paint paint = new Paint();
            this.mBubblePaint = paint;
            paint.setStrokeWidth(BubbleSeekBar.this.getResources().getDimension(R$dimen.dimen_1));
            this.mBubblePaint.setAntiAlias(true);
            Paint paint2 = new Paint(1);
            this.mBubbleTextPaint = paint2;
            paint2.setTextAlign(Paint.Align.CENTER);
            this.mBubbleTextPaint.setTextSize((float) BubbleSeekBar.this.mBubbleTextSize);
            this.mBubbleTextPaint.setColor(BubbleSeekBar.this.mBubbleTextColor);
            this.mBubblePath = new Path();
            this.mRect = new Rect();
        }
    }

    public interface CustomSectionTextArray {
        SparseArray<String> onCustomize(int i11, SparseArray<String> sparseArray);
    }

    public interface OnProgressChangedListener {
        void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11);

        void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11);

        void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11);
    }

    public static abstract class OnProgressChangedListenerAdapter implements OnProgressChangedListener {
        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextPosition {
        public static final int BELOW_SECTION_MARK = 2;
        public static final int BOTTOM_SIDES = 1;
        public static final int SIDES = 0;
    }

    public BubbleSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void autoAdjustSection() {
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
                    float unused = BubbleSeekBar.this.mThumbCenterX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                    float unused2 = bubbleSeekBar.mProgress = bubbleSeekBar.calculateProgress();
                    if (BubbleSeekBar.this.isHideBubble || BubbleSeekBar.this.mBubbleView.getParent() == null) {
                        float unused3 = BubbleSeekBar.this.processProgress();
                    } else {
                        BubbleSeekBar.this.mWindowManager.updateViewLayout(BubbleSeekBar.this.mBubbleView, BubbleSeekBar.this.mLayoutParams);
                    }
                    BubbleSeekBar.this.invalidate();
                    if (BubbleSeekBar.this.mProgressListener != null) {
                        OnProgressChangedListener access$1400 = BubbleSeekBar.this.mProgressListener;
                        BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                        access$1400.onProgressChanged(bubbleSeekBar2, bubbleSeekBar2.getProgress(), BubbleSeekBar.this.getProgressFloat(), true);
                    }
                }
            });
        }
        if (!this.isHideBubble) {
            BubbleView bubbleView = this.mBubbleView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            if (this.isAlwaysShowBubble) {
                f11 = 1.0f;
            }
            fArr[0] = f11;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bubbleView, property, fArr);
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
                if (!BubbleSeekBar.this.isHideBubble && !BubbleSeekBar.this.isAlwaysShowBubble) {
                    BubbleSeekBar.this.hideBubble();
                }
                BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                float unused = bubbleSeekBar.mProgress = bubbleSeekBar.calculateProgress();
                boolean unused2 = BubbleSeekBar.this.isThumbOnDragging = false;
                boolean unused3 = BubbleSeekBar.this.isTouchToSeekAnimEnd = true;
                BubbleSeekBar.this.invalidate();
            }

            public void onAnimationEnd(Animator animator) {
                if (!BubbleSeekBar.this.isHideBubble && !BubbleSeekBar.this.isAlwaysShowBubble) {
                    BubbleSeekBar.this.hideBubble();
                }
                BubbleSeekBar bubbleSeekBar = BubbleSeekBar.this;
                float unused = bubbleSeekBar.mProgress = bubbleSeekBar.calculateProgress();
                boolean unused2 = BubbleSeekBar.this.isThumbOnDragging = false;
                boolean unused3 = BubbleSeekBar.this.isTouchToSeekAnimEnd = true;
                BubbleSeekBar.this.invalidate();
                if (BubbleSeekBar.this.mProgressListener != null) {
                    OnProgressChangedListener access$1400 = BubbleSeekBar.this.mProgressListener;
                    BubbleSeekBar bubbleSeekBar2 = BubbleSeekBar.this;
                    access$1400.getProgressOnFinally(bubbleSeekBar2, bubbleSeekBar2.getProgress(), BubbleSeekBar.this.getProgressFloat(), true);
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
        this.mPaint.setTextSize((float) this.mBubbleTextSize);
    }

    private Bitmap decodeBitmap(int i11) {
        return ((BitmapDrawable) getResources().getDrawable(i11)).getBitmap();
    }

    private String float2String(float f11) {
        return String.valueOf(formatFloat(f11));
    }

    private float formatFloat(float f11) {
        return BigDecimal.valueOf((double) f11).setScale(1, 4).floatValue();
    }

    /* access modifiers changed from: private */
    public void hideBubble() {
        BubbleView bubbleView = this.mBubbleView;
        if (bubbleView != null) {
            bubbleView.setVisibility(8);
            if (this.mBubbleView.getParent() != null) {
                this.mWindowManager.removeViewImmediate(this.mBubbleView);
            }
        }
    }

    private void initConfigByPriority() {
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
            this.mSecondTrackSize = i12 + PixelUtils.a(2.0f);
        }
        int i13 = this.mThumbRadius;
        int i14 = this.mSecondTrackSize;
        if (i13 <= i14) {
            this.mThumbRadius = i14 + PixelUtils.a(2.0f);
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
        float f18 = f17 / ((float) this.mSectionCount);
        this.mSectionValue = f18;
        if (f18 < 1.0f) {
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
            float f19 = this.mMin;
            this.mPreSecValue = f19;
            if (this.mProgress != f19) {
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
        this.mThumbBitmap = decodeBitmap(R$drawable.trade_slider_buy);
    }

    private void initSectionTextArray() {
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
                SparseArray<String> sparseArray = this.mSectionTextArray;
                if (this.isFloatType) {
                    str = float2String(f11);
                } else {
                    str = ((int) f11) + "";
                }
                sparseArray.put(i11, str);
                i11++;
            } else {
                return;
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
        if (((motionEvent.getX() - f12) * (motionEvent.getX() - f12)) + ((motionEvent.getY() - measuredHeight) * (motionEvent.getY() - measuredHeight)) <= (this.mLeft + ((float) PixelUtils.a(8.0f))) * (this.mLeft + ((float) PixelUtils.a(8.0f)))) {
            return true;
        }
        return false;
    }

    private boolean isTrackTouched(MotionEvent motionEvent) {
        return isEnabled() && motionEvent.getX() >= ((float) getPaddingLeft()) && motionEvent.getX() <= ((float) (getMeasuredWidth() - getPaddingRight())) && motionEvent.getY() >= ((float) getPaddingTop()) && motionEvent.getY() <= ((float) (getMeasuredHeight() - getPaddingBottom()));
    }

    private void locatePositionOnScreen() {
        Window window;
        getLocationOnScreen(this.mPoint);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof View)) {
            View view = (View) parent;
            if (view.getMeasuredWidth() > 0) {
                int[] iArr = this.mPoint;
                iArr[0] = iArr[0] % view.getMeasuredWidth();
            }
        }
        if (this.isRtl) {
            this.mBubbleCenterRawSolidX = ((float) this.mPoint[0]) + this.mRight;
        } else {
            this.mBubbleCenterRawSolidX = ((float) this.mPoint[0]) + this.mLeft;
        }
        this.mBubbleCenterRawX = calculateCenterRawXofBubbleView();
        float f11 = (float) this.mPoint[1];
        this.mBubbleCenterRawSolidY = f11;
        this.mBubbleCenterRawSolidY = f11 - ((float) PixelUtils.a(24.0f));
        Context context = getContext();
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && (window.getAttributes().flags & 1024) != 0) {
            Resources system = Resources.getSystem();
            this.mBubbleCenterRawSolidY += (float) system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
        }
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
        BubbleView bubbleView = this.mBubbleView;
        if (bubbleView != null && bubbleView.getParent() == null) {
            locatePositionOnScreen();
            this.mBubbleView.setProgressText(String.valueOf(getProgress()));
            this.mLayoutParams.x = (int) ((this.mBubbleCenterRawX + 0.5f) - ((float) (this.mBubbleView.getMeasuredWidth() / 2)));
            this.mLayoutParams.y = (((int) (this.mBubbleCenterRawSolidY + 0.5f)) - this.bubbleViewHeight) - 25;
            this.mBubbleView.setAlpha(0.0f);
            this.mBubbleView.setVisibility(0);
            this.mBubbleView.animate().alpha(1.0f).setDuration(this.isTouchToSeek ? 0 : this.mAnimDuration).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BubbleSeekBar.this.mWindowManager.addView(BubbleSeekBar.this.mBubbleView, BubbleSeekBar.this.mLayoutParams);
                }
            }).start();
            this.mBubbleView.setProgressText(String.valueOf(getProgress()));
        }
    }

    public void config(BubbleConfigBuilder bubbleConfigBuilder) {
        this.mMin = bubbleConfigBuilder.min;
        this.mMax = bubbleConfigBuilder.max;
        this.mProgress = bubbleConfigBuilder.progress;
        this.isFloatType = bubbleConfigBuilder.floatType;
        this.mTrackSize = bubbleConfigBuilder.trackSize;
        this.mSecondTrackSize = bubbleConfigBuilder.secondTrackSize;
        this.mThumbRadius = bubbleConfigBuilder.thumbRadius;
        this.mThumbRadiusOnDragging = bubbleConfigBuilder.thumbRadiusOnDragging;
        this.mTrackColor = bubbleConfigBuilder.trackColor;
        this.mSecondTrackColor = bubbleConfigBuilder.secondTrackColor;
        this.mThumbColor = bubbleConfigBuilder.thumbColor;
        this.mSectionCount = bubbleConfigBuilder.sectionCount;
        this.isShowSectionMark = bubbleConfigBuilder.showSectionMark;
        this.isAutoAdjustSectionMark = bubbleConfigBuilder.autoAdjustSectionMark;
        this.isShowSectionText = bubbleConfigBuilder.showSectionText;
        this.mSectionTextSize = bubbleConfigBuilder.sectionTextSize;
        this.mSectionTextColor = bubbleConfigBuilder.sectionTextColor;
        this.mSectionTextPosition = bubbleConfigBuilder.sectionTextPosition;
        this.mSectionTextInterval = bubbleConfigBuilder.sectionTextInterval;
        this.isShowThumbText = bubbleConfigBuilder.showThumbText;
        this.mThumbTextSize = bubbleConfigBuilder.thumbTextSize;
        this.mThumbTextColor = bubbleConfigBuilder.thumbTextColor;
        this.isShowProgressInFloat = bubbleConfigBuilder.showProgressInFloat;
        this.mAnimDuration = bubbleConfigBuilder.animDuration;
        this.isTouchToSeek = bubbleConfigBuilder.touchToSeek;
        this.isSeekStepSection = bubbleConfigBuilder.seekStepSection;
        this.isSeekBySection = bubbleConfigBuilder.seekBySection;
        this.mBubbleColor = bubbleConfigBuilder.bubbleColor;
        this.mBubbleTextSize = bubbleConfigBuilder.bubbleTextSize;
        this.mBubbleTextColor = bubbleConfigBuilder.bubbleTextColor;
        this.isAlwaysShowBubble = bubbleConfigBuilder.alwaysShowBubble;
        this.mAlwaysShowBubbleDelay = bubbleConfigBuilder.alwaysShowBubbleDelay;
        this.isHideBubble = bubbleConfigBuilder.hideBubble;
        this.isRtl = bubbleConfigBuilder.rtl;
        initConfigByPriority();
        calculateRadiusOfBubble();
        OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onProgressChanged(this, getProgress(), getProgressFloat(), false);
            this.mProgressListener.getProgressOnFinally(this, getProgress(), getProgressFloat(), false);
        }
        this.mConfigBuilder = null;
        requestLayout();
    }

    public void correctOffsetWhenContainerOnScrolling() {
        if (!this.isHideBubble) {
            locatePositionOnScreen();
            if (this.mBubbleView.getParent() == null) {
                return;
            }
            if (this.isAlwaysShowBubble) {
                locatePositionOnScreen();
                WindowManager.LayoutParams layoutParams = this.mLayoutParams;
                layoutParams.y = ((int) (this.mBubbleCenterRawSolidY + 0.5f)) - this.bubbleViewHeight;
                this.mWindowManager.updateViewLayout(this.mBubbleView, layoutParams);
                return;
            }
            postInvalidate();
        }
    }

    public BubbleConfigBuilder getConfigBuilder() {
        if (this.mConfigBuilder == null) {
            this.mConfigBuilder = new BubbleConfigBuilder(this);
        }
        BubbleConfigBuilder bubbleConfigBuilder = this.mConfigBuilder;
        bubbleConfigBuilder.min = this.mMin;
        bubbleConfigBuilder.max = this.mMax;
        bubbleConfigBuilder.progress = this.mProgress;
        bubbleConfigBuilder.floatType = this.isFloatType;
        bubbleConfigBuilder.trackSize = this.mTrackSize;
        bubbleConfigBuilder.secondTrackSize = this.mSecondTrackSize;
        bubbleConfigBuilder.thumbRadius = this.mThumbRadius;
        bubbleConfigBuilder.thumbRadiusOnDragging = this.mThumbRadiusOnDragging;
        bubbleConfigBuilder.trackColor = this.mTrackColor;
        bubbleConfigBuilder.secondTrackColor = this.mSecondTrackColor;
        bubbleConfigBuilder.thumbColor = this.mThumbColor;
        bubbleConfigBuilder.sectionCount = this.mSectionCount;
        bubbleConfigBuilder.showSectionMark = this.isShowSectionMark;
        bubbleConfigBuilder.autoAdjustSectionMark = this.isAutoAdjustSectionMark;
        bubbleConfigBuilder.showSectionText = this.isShowSectionText;
        bubbleConfigBuilder.sectionTextSize = this.mSectionTextSize;
        bubbleConfigBuilder.sectionTextColor = this.mSectionTextColor;
        bubbleConfigBuilder.sectionTextPosition = this.mSectionTextPosition;
        bubbleConfigBuilder.sectionTextInterval = this.mSectionTextInterval;
        bubbleConfigBuilder.showThumbText = this.isShowThumbText;
        bubbleConfigBuilder.thumbTextSize = this.mThumbTextSize;
        bubbleConfigBuilder.thumbTextColor = this.mThumbTextColor;
        bubbleConfigBuilder.showProgressInFloat = this.isShowProgressInFloat;
        bubbleConfigBuilder.animDuration = this.mAnimDuration;
        bubbleConfigBuilder.touchToSeek = this.isTouchToSeek;
        bubbleConfigBuilder.seekStepSection = this.isSeekStepSection;
        bubbleConfigBuilder.seekBySection = this.isSeekBySection;
        bubbleConfigBuilder.bubbleColor = this.mBubbleColor;
        bubbleConfigBuilder.bubbleTextSize = this.mBubbleTextSize;
        bubbleConfigBuilder.bubbleTextColor = this.mBubbleTextColor;
        bubbleConfigBuilder.alwaysShowBubble = this.isAlwaysShowBubble;
        bubbleConfigBuilder.alwaysShowBubbleDelay = this.mAlwaysShowBubbleDelay;
        bubbleConfigBuilder.hideBubble = this.isHideBubble;
        bubbleConfigBuilder.rtl = this.isRtl;
        return bubbleConfigBuilder;
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

    public boolean isThumbOnDragging() {
        return this.isThumbOnDragging;
    }

    public void onDetachedFromWindow() {
        hideBubble();
        super.onDetachedFromWindow();
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onDraw(Canvas canvas) {
        float f11;
        super.onDraw(canvas);
        float paddingLeft = (float) getPaddingLeft();
        float measuredWidth = (float) (getMeasuredWidth() - getPaddingRight());
        float paddingTop = (float) (getPaddingTop() + (this.mThumbBitmap.getHeight() / 2));
        if (this.isShowSectionText) {
            this.mPaint.setColor(this.mSectionTextColor);
            this.mPaint.setTextSize((float) this.mSectionTextSize);
            this.mPaint.getTextBounds("0123456789", 0, 10, this.mRectText);
            int i11 = this.mSectionTextPosition;
            if (i11 == 0) {
                float height = (((float) this.mRectText.height()) / 2.0f) + paddingTop;
                String str = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str, 0, str.length(), this.mRectText);
                canvas.drawText(str, (((float) this.mRectText.width()) / 2.0f) + paddingLeft, height, this.mPaint);
                paddingLeft += (float) (this.mRectText.width() + this.mTextSpace);
                String str2 = this.mSectionTextArray.get(this.mSectionCount);
                this.mPaint.getTextBounds(str2, 0, str2.length(), this.mRectText);
                canvas.drawText(str2, measuredWidth - ((((float) this.mRectText.width()) + 0.5f) / 2.0f), height, this.mPaint);
                measuredWidth -= (float) (this.mRectText.width() + this.mTextSpace);
            } else if (i11 >= 1) {
                float f12 = ((float) this.mThumbRadiusOnDragging) + paddingTop + ((float) this.mTextSpace);
                String str3 = this.mSectionTextArray.get(0);
                this.mPaint.getTextBounds(str3, 0, str3.length(), this.mRectText);
                float height2 = f12 + ((float) this.mRectText.height());
                float f13 = this.mLeft;
                if (this.mSectionTextPosition == 1) {
                    canvas.drawText(str3, f13, height2, this.mPaint);
                }
                String str4 = this.mSectionTextArray.get(this.mSectionCount);
                this.mPaint.getTextBounds(str4, 0, str4.length(), this.mRectText);
                float f14 = this.mRight;
                if (this.mSectionTextPosition == 1) {
                    canvas.drawText(str4, f14, height2, this.mPaint);
                }
                paddingLeft = f13;
                measuredWidth = f14;
            }
        } else if (this.isShowThumbText && this.mSectionTextPosition == -1) {
            paddingLeft = this.mLeft;
            measuredWidth = this.mRight;
        }
        if ((!this.isShowSectionText && !this.isShowThumbText) || this.mSectionTextPosition == 0) {
            paddingLeft += (float) (this.mThumbBitmap.getWidth() / 2);
            measuredWidth -= (float) (this.mThumbBitmap.getWidth() / 2);
        }
        float f15 = measuredWidth;
        boolean z11 = this.isShowSectionText && this.mSectionTextPosition == 2;
        if (!this.isThumbOnDragging || this.isAlwaysShowBubble) {
            if (this.isRtl) {
                this.mThumbCenterX = f15 - ((this.mTrackLength / this.mDelta) * (this.mProgress - this.mMin));
            } else {
                this.mThumbCenterX = ((this.mTrackLength / this.mDelta) * (this.mProgress - this.mMin)) + paddingLeft;
            }
        }
        this.mPaint.setColor(this.mTrackColor);
        this.mPaint.setStrokeWidth((float) this.mTrackSize);
        this.mPaint.setStyle(Paint.Style.FILL);
        float f16 = paddingTop;
        float f17 = paddingTop;
        canvas.drawLine(this.mThumbCenterX, f16, f15, f17, this.mPaint);
        this.mPaint.setColor(this.mSecondTrackColor);
        this.mPaint.setStrokeWidth((float) this.mTrackSize);
        canvas.drawLine(paddingLeft, f16, this.mThumbCenterX, f17, this.mPaint);
        if (z11 || this.isShowSectionMark) {
            this.mRectText.height();
            PixelUtils.a(2.0f);
            if (this.isRtl) {
                f11 = this.mRight - ((this.mTrackLength / this.mDelta) * Math.abs(this.mProgress - this.mMin));
            } else {
                f11 = this.mLeft + ((this.mTrackLength / this.mDelta) * Math.abs(this.mProgress - this.mMin));
            }
            for (int i12 = 0; i12 <= this.mSectionCount; i12++) {
                float f18 = (((float) i12) * this.mSectionOffset) + paddingLeft;
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(ContextCompat.getColor(getContext(), R$color.baseColorContentBackground));
                canvas.drawRect(new RectF(f18 - ((float) PixelUtils.a(5.5f)), paddingTop - ((float) PixelUtils.a(8.5f)), ((float) PixelUtils.a(5.5f)) + f18, ((float) PixelUtils.a(8.5f)) + paddingTop), this.mPaint);
                if (this.isRtl) {
                    this.mPaint.setColor(f18 <= f11 ? this.mTrackColor : this.mSecondTrackColor);
                } else {
                    this.mPaint.setColor(f18 <= f11 ? this.mSecondTrackColor : this.mTrackColor);
                }
                if (f18 <= f11) {
                    canvas.drawRoundRect(new RectF(f18 - ((float) PixelUtils.a(3.5f)), paddingTop - ((float) PixelUtils.a(6.0f)), f18 + ((float) PixelUtils.a(3.5f)), ((float) PixelUtils.a(6.0f)) + paddingTop), (float) PixelUtils.a(1.5f), (float) PixelUtils.a(1.5f), this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(f18 - ((float) PixelUtils.a(3.5f)), paddingTop - ((float) PixelUtils.a(6.0f)), f18 + ((float) PixelUtils.a(3.5f)), ((float) PixelUtils.a(6.0f)) + paddingTop), (float) PixelUtils.a(1.5f), (float) PixelUtils.a(1.5f), this.mPaint);
                }
            }
        }
        Bitmap bitmap = this.mThumbBitmap;
        canvas.drawBitmap(bitmap, this.mThumbCenterX - ((float) (bitmap.getWidth() / 2)), paddingTop - ((float) (this.mThumbBitmap.getHeight() / 2)), this.mPaint);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        return true;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (!this.isHideBubble) {
            locatePositionOnScreen();
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.isAutoAdjustSectionMark = false;
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int height = this.mThumbBitmap.getHeight() / 2;
        this.mThumbRadiusOnDragging = height;
        int i13 = height * 2;
        if (this.isShowThumbText) {
            this.mPaint.setTextSize((float) this.mThumbTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            i13 += this.mRectText.height();
        }
        this.mThumbRadiusOnDragging = this.mThumbBitmap.getWidth() / 2;
        if (this.isShowSectionText && this.mSectionTextPosition >= 1) {
            this.mPaint.setTextSize((float) this.mSectionTextSize);
            this.mPaint.getTextBounds("j", 0, 1, this.mRectText);
            i13 = Math.max(i13, (this.mThumbRadiusOnDragging * 2) + this.mRectText.height());
        }
        setMeasuredDimension(View.resolveSize(PixelUtils.a(180.0f), i11), i13);
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
                this.mLeft = ((float) getPaddingLeft()) + Math.max((float) this.mThumbRadiusOnDragging, ((float) this.mRectText.width()) / 2.0f) + ((float) this.mTextSpace);
                String str4 = this.mSectionTextArray.get(this.mSectionCount);
                this.mPaint.getTextBounds(str4, 0, str4.length(), this.mRectText);
                this.mRight = (((float) (getMeasuredWidth() - getPaddingRight())) - Math.max((float) this.mThumbRadiusOnDragging, ((float) this.mRectText.width()) / 2.0f)) - ((float) this.mTextSpace);
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
            BubbleView bubbleView = this.mBubbleView;
            if (bubbleView != null) {
                bubbleView.setProgressText(String.valueOf(getProgress()));
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

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        this.isAutoAdjustSectionMark = false;
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.isAutoAdjustSectionMark = true;
        return true;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        post(new Runnable() {
            public void run() {
                BubbleSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r0 != 3) goto L_0x01a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.GestureDetector r0 = r5.mOnGestureListener
            r0.onTouchEvent(r6)
            int r0 = r6.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x010c
            if (r0 == r2) goto L_0x0092
            r3 = 2
            if (r0 == r3) goto L_0x0017
            r3 = 3
            if (r0 == r3) goto L_0x0092
            goto L_0x01a4
        L_0x0017:
            boolean r0 = r5.isThumbOnDragging
            if (r0 == 0) goto L_0x01a4
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
            float r3 = r5.f19003dx
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
            if (r0 == 0) goto L_0x01a4
            float r0 = r5.calculateProgress()
            r5.mProgress = r0
            boolean r0 = r5.isHideBubble
            if (r0 != 0) goto L_0x007b
            com.huobi.view.bubbleseekbar.BubbleSeekBar$BubbleView r0 = r5.mBubbleView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x007b
            com.huobi.view.bubbleseekbar.BubbleSeekBar$BubbleView r0 = r5.mBubbleView
            int r3 = r5.getProgress()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setProgressText(r3)
            android.view.WindowManager r0 = r5.mWindowManager
            com.huobi.view.bubbleseekbar.BubbleSeekBar$BubbleView r3 = r5.mBubbleView
            android.view.WindowManager$LayoutParams r4 = r5.mLayoutParams
            r0.updateViewLayout(r3, r4)
            goto L_0x007e
        L_0x007b:
            r5.processProgress()
        L_0x007e:
            r5.invalidate()
            com.huobi.view.bubbleseekbar.BubbleSeekBar$OnProgressChangedListener r0 = r5.mProgressListener
            if (r0 == 0) goto L_0x01a4
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.onProgressChanged(r5, r3, r4, r2)
            goto L_0x01a4
        L_0x0092:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            boolean r0 = r5.isAutoAdjustSectionMark
            if (r0 == 0) goto L_0x00b0
            boolean r0 = r5.isTouchToSeek
            if (r0 == 0) goto L_0x00ac
            com.huobi.view.bubbleseekbar.BubbleSeekBar$2 r0 = new com.huobi.view.bubbleseekbar.BubbleSeekBar$2
            r0.<init>()
            long r3 = r5.mAnimDuration
            r5.postDelayed(r0, r3)
            goto L_0x00ee
        L_0x00ac:
            r5.autoAdjustSection()
            goto L_0x00ee
        L_0x00b0:
            boolean r0 = r5.isThumbOnDragging
            if (r0 != 0) goto L_0x00b8
            boolean r0 = r5.isTouchToSeek
            if (r0 == 0) goto L_0x00ee
        L_0x00b8:
            boolean r0 = r5.isHideBubble
            if (r0 == 0) goto L_0x00e4
            android.view.ViewPropertyAnimator r0 = r5.animate()
            long r3 = r5.mAnimDuration
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r3)
            boolean r3 = r5.isThumbOnDragging
            if (r3 != 0) goto L_0x00d1
            boolean r3 = r5.isTouchToSeek
            if (r3 == 0) goto L_0x00d1
            r3 = 300(0x12c, double:1.48E-321)
            goto L_0x00d3
        L_0x00d1:
            r3 = 0
        L_0x00d3:
            android.view.ViewPropertyAnimator r0 = r0.setStartDelay(r3)
            com.huobi.view.bubbleseekbar.BubbleSeekBar$3 r3 = new com.huobi.view.bubbleseekbar.BubbleSeekBar$3
            r3.<init>()
            android.view.ViewPropertyAnimator r0 = r0.setListener(r3)
            r0.start()
            goto L_0x00ee
        L_0x00e4:
            com.huobi.view.bubbleseekbar.BubbleSeekBar$4 r0 = new com.huobi.view.bubbleseekbar.BubbleSeekBar$4
            r0.<init>()
            long r3 = r5.mAnimDuration
            r5.postDelayed(r0, r3)
        L_0x00ee:
            com.huobi.view.bubbleseekbar.BubbleSeekBar$OnProgressChangedListener r0 = r5.mProgressListener
            if (r0 == 0) goto L_0x01a4
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.onProgressChanged(r5, r3, r4, r2)
            com.huobi.view.bubbleseekbar.BubbleSeekBar$OnProgressChangedListener r0 = r5.mProgressListener
            int r3 = r5.getProgress()
            float r4 = r5.getProgressFloat()
            r0.getProgressOnActionUp(r5, r3, r4)
            goto L_0x01a4
        L_0x010c:
            r5.performClick()
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            boolean r0 = r5.isThumbTouched(r6)
            r5.isThumbOnDragging = r0
            if (r0 == 0) goto L_0x013d
            boolean r0 = r5.isSeekBySection
            if (r0 == 0) goto L_0x0128
            boolean r0 = r5.triggerSeekBySection
            if (r0 != 0) goto L_0x0128
            r5.triggerSeekBySection = r2
        L_0x0128:
            boolean r0 = r5.isAlwaysShowBubble
            if (r0 == 0) goto L_0x0132
            boolean r0 = r5.triggerBubbleShowing
            if (r0 != 0) goto L_0x0132
            r5.triggerBubbleShowing = r2
        L_0x0132:
            boolean r0 = r5.isHideBubble
            if (r0 != 0) goto L_0x0139
            r5.showBubble()
        L_0x0139:
            r5.invalidate()
            goto L_0x019b
        L_0x013d:
            boolean r0 = r5.isTouchToSeek
            if (r0 == 0) goto L_0x019b
            boolean r0 = r5.isTrackTouched(r6)
            if (r0 == 0) goto L_0x019b
            r5.isThumbOnDragging = r2
            boolean r0 = r5.isSeekBySection
            if (r0 == 0) goto L_0x0153
            boolean r0 = r5.triggerSeekBySection
            if (r0 != 0) goto L_0x0153
            r5.triggerSeekBySection = r2
        L_0x0153:
            boolean r0 = r5.isAlwaysShowBubble
            if (r0 == 0) goto L_0x015c
            r5.hideBubble()
            r5.triggerBubbleShowing = r2
        L_0x015c:
            boolean r0 = r5.isSeekStepSection
            if (r0 == 0) goto L_0x016d
            float r0 = r6.getX()
            float r0 = r5.calThumbCxWhenSeekStepSection(r0)
            r5.mPreThumbCenterX = r0
            r5.mThumbCenterX = r0
            goto L_0x0185
        L_0x016d:
            float r0 = r6.getX()
            r5.mThumbCenterX = r0
            float r3 = r5.mLeft
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x017b
            r5.mThumbCenterX = r3
        L_0x017b:
            float r0 = r5.mThumbCenterX
            float r3 = r5.mRight
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0185
            r5.mThumbCenterX = r3
        L_0x0185:
            float r0 = r5.calculateProgress()
            r5.mProgress = r0
            boolean r0 = r5.isHideBubble
            if (r0 != 0) goto L_0x0198
            float r0 = r5.calculateCenterRawXofBubbleView()
            r5.mBubbleCenterRawX = r0
            r5.showBubble()
        L_0x0198:
            r5.invalidate()
        L_0x019b:
            float r0 = r5.mThumbCenterX
            float r3 = r6.getX()
            float r0 = r0 - r3
            r5.f19003dx = r0
        L_0x01a4:
            boolean r0 = r5.isThumbOnDragging
            if (r0 != 0) goto L_0x01b2
            boolean r0 = r5.isTouchToSeek
            if (r0 != 0) goto L_0x01b2
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x01b3
        L_0x01b2:
            r1 = r2
        L_0x01b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.bubbleseekbar.BubbleSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
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
            BubbleView bubbleView = this.mBubbleView;
            if (bubbleView != null) {
                bubbleView.invalidate();
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
        float f12 = this.mMin;
        if (f11 < f12) {
            this.mProgress = f12;
        }
        float f13 = this.mProgress;
        float f14 = this.mMax;
        if (f13 > f14) {
            this.mProgress = f14;
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
                    BubbleSeekBar.this.showBubble();
                    boolean unused = BubbleSeekBar.this.triggerBubbleShowing = true;
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

    public void setThumbBitmap(int i11) {
        this.mThumbBitmap = decodeBitmap(i11);
        invalidate();
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

    public BubbleSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mSectionTextPosition = -1;
        this.mSectionTextArray = new SparseArray<>();
        this.mPoint = new int[2];
        this.isTouchToSeekAnimEnd = true;
        this.bubbleViewHeight = 110;
        this.mOnGestureListener = new GestureDetector(getContext(), this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BubbleSeekBar, i11, 0);
        this.mMin = obtainStyledAttributes.getFloat(R$styleable.BubbleSeekBar_bsb_min, 0.0f);
        this.mMax = obtainStyledAttributes.getFloat(R$styleable.BubbleSeekBar_bsb_max, 100.0f);
        this.mProgress = obtainStyledAttributes.getFloat(R$styleable.BubbleSeekBar_bsb_progress, this.mMin);
        this.isFloatType = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_is_float_type, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_track_size, PixelUtils.a(2.0f));
        this.mTrackSize = dimensionPixelSize;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_second_track_size, dimensionPixelSize + PixelUtils.a(2.0f));
        this.mSecondTrackSize = dimensionPixelSize2;
        this.mThumbRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_thumb_radius, dimensionPixelSize2 + PixelUtils.a(2.0f));
        this.mThumbRadiusOnDragging = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_thumb_radius_on_dragging, this.mSecondTrackSize * 2);
        this.mSectionCount = obtainStyledAttributes.getInteger(R$styleable.BubbleSeekBar_bsb_section_count, 10);
        this.mTrackColor = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_track_color, ContextCompat.getColor(context, R$color.colorPrimary));
        int color = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_second_track_color, ContextCompat.getColor(context, R$color.colorAccent));
        this.mSecondTrackColor = color;
        this.mThumbColor = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_thumb_color, color);
        this.isShowSectionText = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_show_section_text, false);
        this.mSectionTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_section_text_size, PixelUtils.j(14.0f));
        this.mSectionTextColor = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_section_text_color, this.mTrackColor);
        this.isSeekStepSection = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_seek_step_section, false);
        this.isSeekBySection = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_seek_by_section, false);
        int integer = obtainStyledAttributes.getInteger(R$styleable.BubbleSeekBar_bsb_section_text_position, -1);
        if (integer == 0) {
            this.mSectionTextPosition = 0;
        } else if (integer == 1) {
            this.mSectionTextPosition = 1;
        } else if (integer == 2) {
            this.mSectionTextPosition = 2;
        } else {
            this.mSectionTextPosition = -1;
        }
        this.mSectionTextInterval = obtainStyledAttributes.getInteger(R$styleable.BubbleSeekBar_bsb_section_text_interval, 1);
        this.isShowThumbText = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_show_thumb_text, false);
        this.mThumbTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_thumb_text_size, PixelUtils.j(14.0f));
        this.mThumbTextColor = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_thumb_text_color, this.mSecondTrackColor);
        this.mBubbleColor = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_bubble_color, ContextCompat.getColor(context, R$color.trade_progress_pop));
        this.mBubbleTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BubbleSeekBar_bsb_bubble_text_size, getResources().getDimensionPixelOffset(R$dimen.global_text_size_16));
        this.mBubbleTextColor = obtainStyledAttributes.getColor(R$styleable.BubbleSeekBar_bsb_bubble_text_color, ContextCompat.getColor(context, R$color.baseColorPrimaryText));
        this.isShowSectionMark = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_show_section_mark, false);
        this.isAutoAdjustSectionMark = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_auto_adjust_section_mark, false);
        this.isShowProgressInFloat = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_show_progress_in_float, true);
        int integer2 = obtainStyledAttributes.getInteger(R$styleable.BubbleSeekBar_bsb_anim_duration, -1);
        this.mAnimDuration = integer2 < 0 ? 200 : (long) integer2;
        this.isTouchToSeek = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_touch_to_seek, false);
        this.isAlwaysShowBubble = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_always_show_bubble, false);
        int integer3 = obtainStyledAttributes.getInteger(R$styleable.BubbleSeekBar_bsb_always_show_bubble_delay, 0);
        this.mAlwaysShowBubbleDelay = integer3 < 0 ? 0 : (long) integer3;
        this.isHideBubble = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_hide_bubble, false);
        this.isRtl = obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_bsb_rtl, false);
        setEnabled(obtainStyledAttributes.getBoolean(R$styleable.BubbleSeekBar_android_enabled, isEnabled()));
        obtainStyledAttributes.recycle();
        this.bubbleBackgroundColor = ContextCompat.getColor(context, R$color.baseColorContentBackground);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mRectText = new Rect();
        this.mTextSpace = PixelUtils.a(2.0f);
        initConfigByPriority();
        if (!this.isHideBubble) {
            this.mWindowManager = (WindowManager) context.getSystemService("window");
            BubbleView bubbleView = new BubbleView(this, context);
            this.mBubbleView = bubbleView;
            bubbleView.setProgressText(String.valueOf(getProgress()));
            this.mBubbleView.setPadding(PixelUtils.a(10.0f), 0, PixelUtils.a(10.0f), 0);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams = layoutParams;
            layoutParams.gravity = BadgeDrawable.TOP_START;
            layoutParams.width = -1;
            layoutParams.height = this.bubbleViewHeight;
            layoutParams.format = -3;
            layoutParams.flags = 524328;
            if (BubbleUtils.isMIUI() || Build.VERSION.SDK_INT >= 25) {
                this.mLayoutParams.type = 2;
            } else {
                this.mLayoutParams.type = 2005;
            }
            calculateRadiusOfBubble();
        }
    }
}
