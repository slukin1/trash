package com.huobi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$styleable;

public class CouponCardView extends LinearLayout {
    public int centerCircleRadius;
    public int couponHeight;
    public int couponLeftWith;
    public int couponRightWith;
    public int couponWith;
    private Paint dottedLinePaint;
    public int dottedWidth;
    public int filletRadius;
    private int leftColor;
    private Paint mPaint;
    private int offsetWith;
    private Path path;
    private int rightColor;
    private Paint rightLinePaint;
    private int strokeColor;
    public int strokeWidth;

    public CouponCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void drawDottedLine(Canvas canvas) {
        this.dottedLinePaint.setColor(this.rightColor);
        int a11 = PixelUtils.a(3.0f);
        float f11 = (float) a11;
        this.dottedLinePaint.setPathEffect(new DashPathEffect(new float[]{f11, f11}, 0.0f));
        this.path.reset();
        this.path.moveTo((float) (this.couponLeftWith + (this.strokeWidth / 2)), (float) (this.centerCircleRadius + (this.offsetWith * 2)));
        Path path2 = this.path;
        int i11 = this.couponLeftWith;
        int i12 = this.strokeWidth;
        path2.lineTo((float) (i11 + (i12 / 2)), (float) (((this.couponHeight - this.centerCircleRadius) - i12) - this.offsetWith));
        canvas.drawPath(this.path, this.dottedLinePaint);
    }

    private void drawLeftView(Canvas canvas) {
        float f11 = ((float) this.offsetWith) / 2.0f;
        this.path.reset();
        this.path.moveTo((float) (this.couponLeftWith / 2), f11);
        this.path.lineTo((float) this.filletRadius, f11);
        int i11 = this.filletRadius;
        this.path.arcTo(new RectF(f11, f11, ((float) (i11 * 2)) + f11, ((float) (i11 * 2)) + f11), -90.0f, -90.0f);
        this.path.lineTo(f11, ((float) (this.couponHeight - this.filletRadius)) - f11);
        int i12 = this.couponHeight;
        int i13 = this.filletRadius;
        this.path.arcTo(new RectF(f11, ((float) (i12 - (i13 * 2))) - f11, ((float) (i13 * 2)) + f11, ((float) i12) - f11), -180.0f, -90.0f);
        this.path.lineTo(((float) (this.couponLeftWith - this.centerCircleRadius)) + f11, ((float) this.couponHeight) - f11);
        int i14 = this.couponLeftWith;
        int i15 = this.centerCircleRadius;
        int i16 = this.couponHeight;
        this.path.arcTo(new RectF(((float) (i14 - i15)) + f11, ((float) (i16 - i15)) - f11, ((float) (i14 + i15)) + f11, ((float) (i16 + i15)) - f11), -180.0f, 90.0f);
        this.path.lineTo(((float) this.couponLeftWith) + f11, ((float) this.centerCircleRadius) + f11);
        int i17 = this.couponLeftWith;
        int i18 = this.centerCircleRadius;
        this.path.arcTo(new RectF(((float) (i17 - i18)) + f11, ((float) (-i18)) + f11, ((float) (i17 + i18)) + f11, ((float) i18) + f11), 90.0f, 90.0f);
        this.path.lineTo((float) (this.couponLeftWith / 2), f11);
        this.path.close();
        canvas.drawPath(this.path, this.mPaint);
    }

    private void drawRightView(Canvas canvas) {
        int i11 = this.strokeWidth;
        float f11 = ((float) i11) / 2.0f;
        this.path.reset();
        float f12 = (float) i11;
        this.path.moveTo((float) (this.couponLeftWith + (this.couponRightWith / 2) + i11), f12);
        this.path.lineTo((float) (this.couponLeftWith + this.centerCircleRadius + (i11 * 2)), f12);
        int i12 = this.couponLeftWith;
        int i13 = this.centerCircleRadius;
        this.path.arcTo(new RectF(((float) (i12 - i13)) + (f11 / 2.0f), (float) ((-i13) + i11), ((float) (i12 + i13)) + f11, (float) (i13 + i11)), 0.0f, 90.0f);
        canvas.drawPath(this.path, this.mPaint);
        this.path.reset();
        this.path.moveTo(((float) (this.couponLeftWith + i11)) - f11, ((float) ((this.couponHeight - this.centerCircleRadius) - i11)) - f11);
        int i14 = this.couponLeftWith;
        int i15 = this.centerCircleRadius;
        int i16 = this.couponHeight;
        this.path.arcTo(new RectF(((float) ((i14 - i15) + i11)) - f11, (float) ((i16 - i15) - i11), ((float) ((i14 + i15) + i11)) - f11, (float) ((i16 + i15) - i11)), -90.0f, 90.0f);
        this.path.lineTo((float) ((this.couponWith - this.filletRadius) - i11), (float) (this.couponHeight - i11));
        int i17 = this.couponWith;
        int i18 = this.filletRadius;
        int i19 = this.couponHeight;
        this.path.arcTo(new RectF((float) ((i17 - (i18 * 2)) - i11), (float) ((i19 - (i18 * 2)) - i11), (float) (i17 - i11), (float) (i19 - i11)), 90.0f, -90.0f);
        this.path.lineTo((float) (this.couponWith - i11), (float) (this.filletRadius + i11));
        int i21 = this.couponWith;
        int i22 = this.filletRadius;
        this.path.arcTo(new RectF((float) ((i21 - (i22 * 2)) - i11), f12, (float) (i21 - i11), (float) ((i22 * 2) + i11)), 0.0f, -90.0f);
        this.path.lineTo((float) (this.couponLeftWith + (this.couponRightWith / 2) + i11), f12);
        canvas.drawPath(this.path, this.mPaint);
    }

    private void init() {
        setBackgroundColor(0);
        this.mPaint = new Paint(1);
        this.path = new Path();
    }

    private void initPaint() {
        this.offsetWith = this.strokeWidth;
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.leftColor);
        this.mPaint.setStrokeWidth((float) this.strokeWidth);
        this.mPaint.setDither(true);
        Paint paint = new Paint(1);
        this.dottedLinePaint = paint;
        paint.setColor(this.leftColor);
        this.dottedLinePaint.setStyle(Paint.Style.STROKE);
        this.dottedLinePaint.setStrokeWidth(((float) this.strokeWidth) + (((float) this.offsetWith) / 2.0f));
        Paint paint2 = new Paint(1);
        this.rightLinePaint = paint2;
        paint2.setColor(this.rightColor);
        this.rightLinePaint.setStyle(Paint.Style.FILL);
        this.rightLinePaint.setStrokeWidth((float) this.dottedWidth);
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        drawRightView(canvas);
        this.mPaint.setColor(this.leftColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        drawLeftView(canvas);
        drawDottedLine(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        int childCount = getChildCount();
        if (childCount >= 2) {
            int i15 = 0;
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i15 += measuredWidth;
                if (i16 == 0) {
                    this.couponLeftWith = measuredWidth;
                } else {
                    this.couponRightWith = measuredWidth;
                }
                this.couponWith = i15;
                this.couponHeight = measuredHeight;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public void setCenterCircleRadius(int i11) {
        this.centerCircleRadius = i11;
    }

    public void setDottedWidth(int i11) {
        this.dottedWidth = i11;
    }

    public void setFilletRadius(int i11) {
        this.filletRadius = i11;
    }

    public void setLeftColor(int i11) {
        this.leftColor = i11;
    }

    public void setRightColor(int i11) {
        this.rightColor = i11;
    }

    public void setStrokeColor(int i11) {
        this.strokeColor = i11;
    }

    public void setStrokeWidth(int i11) {
        this.strokeWidth = i11 + (i11 / 2);
    }

    public CouponCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CouponCardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.strokeWidth = 2;
        this.dottedWidth = 2;
        this.filletRadius = 20;
        this.centerCircleRadius = 20;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.couponCardView, i11, 0);
        this.leftColor = obtainStyledAttributes.getInt(R$styleable.couponCardView_leftColor, -16776961);
        this.rightColor = obtainStyledAttributes.getInt(R$styleable.couponCardView_rightColor, -1);
        this.strokeColor = obtainStyledAttributes.getInt(R$styleable.couponCardView_strokeColor, -65536);
        int dimension = (int) obtainStyledAttributes.getDimension(R$styleable.couponCardView_strokeWidth, 2.0f);
        this.strokeWidth = dimension;
        this.strokeWidth = dimension + (dimension / 2);
        this.dottedWidth = (int) obtainStyledAttributes.getDimension(R$styleable.couponCardView_dottedWidth, 2.0f);
        this.filletRadius = (int) obtainStyledAttributes.getDimension(R$styleable.couponCardView_corners, 0.0f);
        this.centerCircleRadius = (int) obtainStyledAttributes.getDimension(R$styleable.couponCardView_radius, 20.0f);
        obtainStyledAttributes.recycle();
        init();
    }
}
