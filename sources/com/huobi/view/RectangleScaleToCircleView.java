package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

public class RectangleScaleToCircleView extends View {
    public static final int CIRCLE_MIN_RADIUS_DEFAULT = 5;
    public IAnimationPlayState mCallback;
    public Point mCircleCenterPoint;
    private int mFillColor;
    private float mMinRadius;
    private Paint mPaint;
    private float mRadius;
    private int mRadiusStepValue;

    public interface IAnimationPlayState {
        void onPlayEnd();
    }

    public RectangleScaleToCircleView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void drawMaskCircle(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f11 = this.mRadius;
        if (f11 == -1.0f) {
            this.mRadius = ((float) width) / 2.0f;
        } else {
            float f12 = this.mMinRadius;
            if (f11 > f12) {
                float f13 = f11 - ((float) this.mRadiusStepValue);
                this.mRadius = f13;
                if (f13 < f12) {
                    this.mRadius = f12;
                }
            }
        }
        this.mPaint.setColor(0);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setAntiAlias(true);
        canvas.drawPaint(this.mPaint);
        Path path = new Path();
        Point point = this.mCircleCenterPoint;
        path.addCircle((float) point.x, (float) point.y, this.mRadius, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        this.mPaint.setColor(this.mFillColor);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.mPaint);
        if (this.mRadius > this.mMinRadius) {
            invalidate();
            return;
        }
        this.mPaint = null;
        IAnimationPlayState iAnimationPlayState = this.mCallback;
        if (iAnimationPlayState != null) {
            iAnimationPlayState.onPlayEnd();
            this.mCallback = null;
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.mPaint != null) {
            drawMaskCircle(canvas);
        }
    }

    public void setCircleCenterPoint(Point point) {
        this.mCircleCenterPoint = point;
    }

    public void setCircleMinRadius(float f11) {
        if (f11 > 0.0f) {
            this.mMinRadius = f11;
        } else {
            this.mMinRadius = 5.0f;
        }
    }

    public void setCircleRadiusStepValue(int i11) {
        this.mRadiusStepValue = i11;
    }

    public void setMaskColor(int i11) {
        this.mFillColor = i11;
    }

    public void startAnimation(IAnimationPlayState iAnimationPlayState) {
        this.mCallback = iAnimationPlayState;
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        invalidate();
    }

    public RectangleScaleToCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleScaleToCircleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mRadius = -1.0f;
        this.mMinRadius = 5.0f;
        this.mRadiusStepValue = 0;
    }
}
