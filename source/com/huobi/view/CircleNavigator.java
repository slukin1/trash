package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import p10.a;

public class CircleNavigator extends View implements a {
    private OnCircleClickListener mCircleClickListener;
    private int mCircleColor;
    private List<PointF> mCirclePoints = new ArrayList();
    private int mCircleSpacing;
    private int mCurrentIndex;
    private float mDownX;
    private float mDownY;
    private boolean mFollowTouch = true;
    private float mIndicatorX;
    private int mNormalColor;
    private Paint mPaint = new Paint(1);
    private int mRadius;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private int mStrokeWidth;
    private int mTotalCount;
    private int mTouchSlop;
    private boolean mTouchable;

    public interface OnCircleClickListener {
        void onClick(int i11);
    }

    public CircleNavigator(Context context) {
        super(context);
        init(context);
    }

    private void drawCircles(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mNormalColor);
        this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
        int size = this.mCirclePoints.size();
        for (int i11 = 0; i11 < size; i11++) {
            PointF pointF = this.mCirclePoints.get(i11);
            canvas.drawCircle(pointF.x, pointF.y, (float) this.mRadius, this.mPaint);
        }
    }

    private void drawIndicator(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mCircleColor);
        if (this.mCirclePoints.size() > 0) {
            canvas.drawCircle(this.mIndicatorX, (float) ((int) ((((float) getHeight()) / 2.0f) + 0.5f)), (float) this.mRadius, this.mPaint);
        }
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mRadius = UIUtil.a(context, 3.0d);
        this.mCircleSpacing = UIUtil.a(context, 8.0d);
        this.mStrokeWidth = UIUtil.a(context, 1.0d);
    }

    private int measureHeight(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.mRadius * 2) + (this.mStrokeWidth * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int measureWidth(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.mTotalCount;
            return (this.mStrokeWidth * 2) + (this.mRadius * i12 * 2) + ((i12 - 1) * this.mCircleSpacing) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            return 0;
        } else {
            return size;
        }
    }

    private void prepareCirclePoints() {
        this.mCirclePoints.clear();
        if (this.mTotalCount > 0) {
            int height = (int) ((((float) getHeight()) / 2.0f) + 0.5f);
            int i11 = this.mRadius;
            int i12 = (i11 * 2) + this.mCircleSpacing;
            int paddingLeft = i11 + ((int) ((((float) this.mStrokeWidth) / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i13 = 0; i13 < this.mTotalCount; i13++) {
                this.mCirclePoints.add(new PointF((float) paddingLeft, (float) height));
                paddingLeft += i12;
            }
            this.mIndicatorX = this.mCirclePoints.get(this.mCurrentIndex).x;
        }
    }

    public OnCircleClickListener getCircleClickListener() {
        return this.mCircleClickListener;
    }

    public int getCircleColor() {
        return this.mCircleColor;
    }

    public int getCircleCount() {
        return this.mTotalCount;
    }

    public int getCircleSpacing() {
        return this.mCircleSpacing;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public boolean isFollowTouch() {
        return this.mFollowTouch;
    }

    public boolean isTouchable() {
        return this.mTouchable;
    }

    public void notifyDataSetChanged() {
        prepareCirclePoints();
        invalidate();
    }

    public void onAttachToMagicIndicator() {
    }

    public void onDetachFromMagicIndicator() {
    }

    public void onDraw(Canvas canvas) {
        drawCircles(canvas);
        drawIndicator(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        prepareCirclePoints();
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(measureWidth(i11), measureHeight(i12));
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.mFollowTouch && !this.mCirclePoints.isEmpty()) {
            int min = Math.min(this.mCirclePoints.size() - 1, i11);
            int min2 = Math.min(this.mCirclePoints.size() - 1, i11 + 1);
            float f12 = this.mCirclePoints.get(min).x;
            this.mIndicatorX = f12 + ((this.mCirclePoints.get(min2).x - f12) * this.mStartInterpolator.getInterpolation(f11));
            invalidate();
        }
    }

    public void onPageSelected(int i11) {
        this.mCurrentIndex = i11;
        if (!this.mFollowTouch) {
            this.mIndicatorX = this.mCirclePoints.get(i11).x;
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.mCircleClickListener != null && Math.abs(x11 - this.mDownX) <= ((float) this.mTouchSlop) && Math.abs(y11 - this.mDownY) <= ((float) this.mTouchSlop)) {
                float f11 = Float.MAX_VALUE;
                int i11 = 0;
                for (int i12 = 0; i12 < this.mCirclePoints.size(); i12++) {
                    float abs = Math.abs(this.mCirclePoints.get(i12).x - x11);
                    if (abs < f11) {
                        i11 = i12;
                        f11 = abs;
                    }
                }
                this.mCircleClickListener.onClick(i11);
            }
        } else if (this.mTouchable) {
            this.mDownX = x11;
            this.mDownY = y11;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (!this.mTouchable) {
            this.mTouchable = true;
        }
        this.mCircleClickListener = onCircleClickListener;
    }

    public void setCircleColor(int i11) {
        this.mCircleColor = i11;
        invalidate();
    }

    public void setCircleCount(int i11) {
        this.mTotalCount = i11;
    }

    public void setCircleSpacing(int i11) {
        this.mCircleSpacing = i11;
        prepareCirclePoints();
        invalidate();
    }

    public void setFollowTouch(boolean z11) {
        this.mFollowTouch = z11;
    }

    public void setNormalColor(int i11) {
        this.mNormalColor = i11;
        invalidate();
    }

    public void setRadius(int i11) {
        this.mRadius = i11;
        prepareCirclePoints();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i11) {
        this.mStrokeWidth = i11;
        invalidate();
    }

    public void setTouchable(boolean z11) {
        this.mTouchable = z11;
    }
}
