package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import i6.d;
import java.math.BigDecimal;
import pro.huobi.R;

public class TradeSeekBar extends View {

    /* renamed from: dx  reason: collision with root package name */
    public float f18988dx;
    private boolean isFloatType;
    private boolean isSeekBySection;
    private boolean isShowProgressInFloat;
    private boolean isThumbOnDragging;
    private boolean isTouchToSeek;
    private int mBigCircleBorderRadius;
    private int mBigCircleRadius;
    private int mBorderColor;
    private int mBorderSize;
    private float mDelta;
    private float mLeft;
    private float mLineWidth;
    private float mMax;
    private float mMin;
    private Paint mPaint;
    private int[] mPoint;
    private float mPreSecValue;
    private float mProgress;
    private OnProgressChangedListener mProgressListener;
    private float mRight;
    private int mScaledTouchSlop;
    private int mSectionCount;
    private float mSectionOffset;
    private float mSectionValue;
    private int mThumbBigColor;
    private float mThumbCenterX;
    private int mThumbShadowRadius;
    private int mThumbSmallColor;
    private int mTrackBigCircleRadius;
    private int mTrackCircleRadius;
    private int mTrackColor;
    private float mTrackLength;
    private int mTrackSmallCircleRadius;
    private int mTrackWhiteColor;
    private boolean triggerSeekBySection;

    public interface OnProgressChangedListener {
        void onProgressChanged(TradeSeekBar tradeSeekBar, int i11, boolean z11);

        void onStartTrackingTouch(TradeSeekBar tradeSeekBar);

        void onStopTrackingTouch(TradeSeekBar tradeSeekBar);
    }

    public TradeSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private String float2String(float f11) {
        return String.valueOf(formatFloat(f11));
    }

    private float formatFloat(float f11) {
        return BigDecimal.valueOf((double) f11).setScale(1, 4).floatValue();
    }

    private String getMaxText() {
        return this.isFloatType ? float2String(this.mMax) : String.valueOf((int) this.mMax);
    }

    private String getMinText() {
        return this.isFloatType ? float2String(this.mMin) : String.valueOf((int) this.mMin);
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
        if (this.mSectionCount <= 0) {
            this.mSectionCount = 10;
        }
        float f17 = f16 - f14;
        this.mDelta = f17;
        float f18 = f17 / ((float) this.mSectionCount);
        this.mSectionValue = f18;
        if (f18 < 1.0f) {
            this.isFloatType = true;
        }
        if (this.isFloatType) {
            this.isShowProgressInFloat = true;
        }
        if (this.isSeekBySection) {
            this.mPreSecValue = f14;
            if (this.mProgress != f14) {
                this.mPreSecValue = f18;
            }
            this.isTouchToSeek = false;
        }
    }

    private boolean isThumbTouched(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float f11 = ((this.mTrackLength / this.mDelta) * (this.mProgress - this.mMin)) + this.mLeft;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (((motionEvent.getX() - f11) * (motionEvent.getX() - f11)) + ((motionEvent.getY() - measuredHeight) * (motionEvent.getY() - measuredHeight)) <= (this.mLeft + ((float) PixelUtils.a(8.0f))) * (this.mLeft + ((float) PixelUtils.a(8.0f)))) {
            return true;
        }
        return false;
    }

    private boolean isTrackTouched(MotionEvent motionEvent) {
        if (isEnabled() && motionEvent.getX() >= ((float) getPaddingLeft()) && motionEvent.getX() <= ((float) (getMeasuredWidth() - getPaddingRight())) && motionEvent.getY() >= ((float) getPaddingTop()) && motionEvent.getY() <= ((float) (getPaddingTop() + (this.mBigCircleBorderRadius * 2)))) {
            return true;
        }
        return false;
    }

    private void locatePositionOnScreen() {
        getLocationOnScreen(this.mPoint);
    }

    public void correctOffsetWhenContainerOnScrolling() {
        locatePositionOnScreen();
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
        if (!this.isSeekBySection || !this.triggerSeekBySection) {
            return Math.round(this.mProgress);
        }
        float f11 = this.mSectionValue;
        float f12 = f11 / 2.0f;
        float f13 = this.mProgress;
        float f14 = this.mPreSecValue;
        if (f13 >= f14) {
            if (f13 < f12 + f14) {
                return Math.round(f14);
            }
            float f15 = f14 + f11;
            this.mPreSecValue = f15;
            return Math.round(f15);
        } else if (f13 >= f14 - f12) {
            return Math.round(f14);
        } else {
            float f16 = f14 - f11;
            this.mPreSecValue = f16;
            return Math.round(f16);
        }
    }

    public float getProgressFloat() {
        return formatFloat(this.mProgress);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int i11 = this.mBigCircleBorderRadius;
        int i12 = this.mThumbShadowRadius;
        float f11 = (float) (paddingTop + i11 + i12);
        float paddingLeft = ((float) getPaddingLeft()) + ((float) i11) + ((float) i12);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingRight())) - ((float) i11)) - ((float) i12);
        if (!this.isThumbOnDragging) {
            this.mThumbCenterX = ((this.mTrackLength / this.mDelta) * (this.mProgress - this.mMin)) + paddingLeft;
        }
        this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.global_divider_color));
        this.mPaint.setStrokeWidth((float) this.mBorderSize);
        this.mPaint.setStyle(Paint.Style.FILL);
        float f12 = this.mThumbCenterX;
        float f13 = this.mLineWidth;
        canvas.drawRect(f12, f11 - (f13 / 2.0f), measuredWidth, f11 + (f13 / 2.0f), this.mPaint);
        this.mPaint.setColor(this.mThumbSmallColor);
        this.mPaint.setStrokeWidth((float) this.mBorderSize);
        float f14 = this.mLineWidth;
        canvas.drawRect(paddingLeft, f11 - (f14 / 2.0f), this.mThumbCenterX, f11 + (f14 / 2.0f), this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth((float) this.mBorderSize);
        float abs = ((this.mTrackLength / this.mDelta) * Math.abs(this.mProgress - this.mMin)) + this.mLeft;
        for (int i13 = 0; i13 <= this.mSectionCount; i13++) {
            float f15 = (((float) i13) * this.mSectionOffset) + paddingLeft;
            this.mPaint.setStrokeWidth((float) this.mBorderSize);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mTrackWhiteColor);
            canvas.drawCircle(f15, f11, (float) this.mTrackBigCircleRadius, this.mPaint);
            if (f15 <= abs) {
                this.mPaint.setColor(this.mThumbSmallColor);
                canvas.drawCircle(f15, f11, (float) this.mTrackCircleRadius, this.mPaint);
                this.mPaint.setColor(this.mTrackWhiteColor);
                canvas.drawCircle(f15, f11, (float) this.mTrackSmallCircleRadius, this.mPaint);
            } else {
                this.mPaint.setColor(this.mTrackColor);
                canvas.drawCircle(f15, f11, (float) this.mTrackCircleRadius, this.mPaint);
            }
        }
        this.mPaint.setColor(this.mBorderColor);
        this.mPaint.setShadowLayer((float) this.mThumbShadowRadius, 0.0f, 0.0f, ContextCompat.getColor(getContext(), R.color.trade_seekbar_thumb_shadow_color));
        canvas.drawCircle(this.mThumbCenterX, f11, (float) this.mBigCircleBorderRadius, this.mPaint);
        this.mPaint.setColor(this.mThumbBigColor);
        this.mPaint.clearShadowLayer();
        canvas.drawCircle(this.mThumbCenterX, f11, (float) this.mBigCircleRadius, this.mPaint);
        this.mPaint.setColor(this.mThumbSmallColor);
        canvas.drawCircle(this.mThumbCenterX, f11, (float) this.mTrackCircleRadius, this.mPaint);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), (this.mBigCircleBorderRadius + this.mThumbShadowRadius) * 2);
        this.mLeft = (float) (getPaddingLeft() + this.mBigCircleBorderRadius + this.mThumbShadowRadius);
        float measuredWidth = (float) (((getMeasuredWidth() - getPaddingRight()) - this.mBigCircleBorderRadius) - this.mThumbShadowRadius);
        this.mRight = measuredWidth;
        float f11 = measuredWidth - this.mLeft;
        this.mTrackLength = f11;
        this.mSectionOffset = (f11 * 1.0f) / ((float) this.mSectionCount);
        locatePositionOnScreen();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mProgress = bundle.getFloat("progress");
            d.b("onRestoreInstanceState===" + this.mProgress);
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
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

    public void onStartTrackingTouch() {
        this.isThumbOnDragging = true;
        OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onStartTrackingTouch(this);
        }
    }

    public void onStopTrackingTouch() {
        this.isThumbOnDragging = false;
        OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onStopTrackingTouch(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            boolean isThumbTouched = isThumbTouched(motionEvent);
            this.isThumbOnDragging = isThumbTouched;
            if (isThumbTouched) {
                if (this.isSeekBySection && !this.triggerSeekBySection) {
                    this.triggerSeekBySection = true;
                }
                invalidate();
            } else if (this.isTouchToSeek && isTrackTouched(motionEvent)) {
                float x11 = motionEvent.getX();
                this.mThumbCenterX = x11;
                float f11 = this.mLeft;
                if (x11 < f11) {
                    this.mThumbCenterX = f11;
                }
                float f12 = this.mThumbCenterX;
                float f13 = this.mRight;
                if (f12 > f13) {
                    this.mThumbCenterX = f13;
                }
                this.mProgress = (((this.mThumbCenterX - f11) * this.mDelta) / this.mTrackLength) + this.mMin;
                d.b("onTouchEvent===ACTION_DOWN" + this.mProgress);
                invalidate();
            }
            onStartTrackingTouch();
            this.f18988dx = this.mThumbCenterX - motionEvent.getX();
        } else if (actionMasked == 1) {
            if (this.isThumbOnDragging) {
                OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
                if (onProgressChangedListener != null) {
                    onProgressChangedListener.onProgressChanged(this, getProgress(), true);
                }
                onStopTrackingTouch();
            } else {
                onStartTrackingTouch();
                OnProgressChangedListener onProgressChangedListener2 = this.mProgressListener;
                if (onProgressChangedListener2 != null) {
                    onProgressChangedListener2.onProgressChanged(this, getProgress(), true);
                }
                onStopTrackingTouch();
            }
            invalidate();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.isThumbOnDragging) {
                    onStopTrackingTouch();
                }
                invalidate();
            }
        } else if (this.isThumbOnDragging) {
            float x12 = motionEvent.getX() + this.f18988dx;
            this.mThumbCenterX = x12;
            float f14 = this.mLeft;
            if (x12 < f14) {
                this.mThumbCenterX = f14;
            }
            float f15 = this.mThumbCenterX;
            float f16 = this.mRight;
            if (f15 > f16) {
                this.mThumbCenterX = f16;
            }
            this.mProgress = (((this.mThumbCenterX - f14) * this.mDelta) / this.mTrackLength) + this.mMin;
            d.b("onTouchEvent===ACTION_MOVE" + this.mProgress);
            invalidate();
            OnProgressChangedListener onProgressChangedListener3 = this.mProgressListener;
            if (onProgressChangedListener3 != null) {
                onProgressChangedListener3.onProgressChanged(this, getProgress(), true);
            }
        } else if (Math.abs(motionEvent.getX() - this.mThumbCenterX) > ((float) this.mScaledTouchSlop)) {
            setPressed(true);
            onStartTrackingTouch();
            OnProgressChangedListener onProgressChangedListener4 = this.mProgressListener;
            if (onProgressChangedListener4 != null) {
                onProgressChangedListener4.onProgressChanged(this, getProgress(), true);
            }
        }
        if (this.isThumbOnDragging || this.isTouchToSeek || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.mProgressListener = onProgressChangedListener;
    }

    public void setProgress(float f11) {
        if (f11 != this.mProgress) {
            float f12 = this.mMax;
            if (f11 > f12) {
                f11 = f12;
            }
            float f13 = this.mMin;
            if (f11 < f13) {
                f11 = f13;
            }
            this.mProgress = f11;
            d.b("setProgress===" + this.mProgress);
            OnProgressChangedListener onProgressChangedListener = this.mProgressListener;
            if (onProgressChangedListener != null) {
                onProgressChangedListener.onProgressChanged(this, getProgress(), false);
            }
            postInvalidate();
        }
    }

    public void setSecondTrackColor(int i11) {
        this.mThumbSmallColor = i11;
        postInvalidate();
    }

    public TradeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TradeSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mPoint = new int[2];
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BubbleSeekBar, i11, 0);
        this.mMin = obtainStyledAttributes.getFloat(11, 0.0f);
        this.mMax = obtainStyledAttributes.getFloat(10, 100.0f);
        this.mProgress = obtainStyledAttributes.getFloat(12, this.mMin);
        this.isFloatType = obtainStyledAttributes.getBoolean(9, false);
        this.mBorderSize = PixelUtils.a(0.5f);
        this.mLineWidth = (float) PixelUtils.a(3.0f);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(28, PixelUtils.a(6.0f));
        this.mTrackCircleRadius = dimensionPixelSize;
        this.mTrackBigCircleRadius = dimensionPixelSize + PixelUtils.a(2.0f);
        this.mTrackSmallCircleRadius = PixelUtils.a(4.0f);
        this.mSectionCount = obtainStyledAttributes.getInteger(16, 10);
        int a11 = this.mTrackCircleRadius + PixelUtils.a(5.0f);
        this.mBigCircleRadius = a11;
        this.mBigCircleBorderRadius = a11 + this.mBorderSize;
        this.mThumbShadowRadius = PixelUtils.a(1.0f);
        this.mTrackColor = obtainStyledAttributes.getColor(33, ContextCompat.getColor(context, R.color.trade_seekbar_track_color));
        this.mThumbSmallColor = obtainStyledAttributes.getColor(14, ContextCompat.getColor(context, R.color.color_rise));
        this.isSeekBySection = obtainStyledAttributes.getBoolean(21, false);
        this.isShowProgressInFloat = obtainStyledAttributes.getBoolean(23, false);
        this.isTouchToSeek = obtainStyledAttributes.getBoolean(32, false);
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mThumbBigColor = ContextCompat.getColor(getContext(), R.color.trade_thumb_big_circle_color);
        this.mTrackWhiteColor = ContextCompat.getColor(getContext(), R.color.trade_seekbar_big_circle_color);
        this.mBorderColor = ContextCompat.getColor(getContext(), R.color.global_divider_color);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        initConfigByPriority();
    }
}
