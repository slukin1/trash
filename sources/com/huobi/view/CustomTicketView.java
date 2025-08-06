package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import pro.huobi.R;

public class CustomTicketView extends RelativeLayout {
    public static final int ALREDUSEMODE = 2;
    public static final int AVAIABLEMODE = 3;
    public static final int OVERDUEMODE = 1;
    private int circleNum;
    private String mAlreadyUseText;
    private int mAngdeg;
    private float mBigCircleRadius = 140.0f;
    private float mCenterX;
    private float mCenterY;
    private Context mContext;
    private float mDottedHeight;
    private float mGap = 8.0f;
    private String mOverdueText;
    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;
    private float mRemain;
    private float mSmallCircleRadius = 90.0f;
    private float mStarRadius;
    private float mTextSize;
    private int mTicketMode;
    private String mUseDateText;
    private float radius = 10.0f;

    public CustomTicketView(Context context) {
        super(context);
        init(context);
    }

    private void drawBigCircle(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(30.0f);
        this.mPaint.setColor(ContextCompat.getColor(this.mContext, R.color.bg_all));
        this.mPaint.setFlags(1);
        canvas.drawCircle(this.mCenterX, this.mCenterY, this.mBigCircleRadius, this.mPaint);
    }

    private void drawLeftBoundCircle(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setColor(ContextCompat.getColor(this.mContext, R.color.bg_all));
        this.mPaint.setFlags(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0.0f, this.mDottedHeight, this.radius, this.mPaint);
    }

    private void drawRightBoundCircle(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setColor(ContextCompat.getColor(this.mContext, R.color.bg_all));
        this.mPaint.setFlags(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) getWidth(), this.mDottedHeight, this.radius, this.mPaint);
    }

    private void drawSmallCircle(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(15.0f);
        this.mPaint.setColor(ContextCompat.getColor(this.mContext, R.color.bg_all));
        this.mPaint.setFlags(1);
        RectF rectF = this.mRectF;
        float f11 = this.mCenterX;
        float f12 = this.mSmallCircleRadius;
        float f13 = this.mCenterY;
        rectF.set(f11 - f12, f13 - f12, f11 + f12, f13 + f12);
        canvas.drawArc(this.mRectF, -45.0f, 270.0f, false, this.mPaint);
    }

    private void drawStar(Canvas canvas) {
        Canvas canvas2 = canvas;
        this.mPaint.reset();
        this.mPaint.setColor(ContextCompat.getColor(this.mContext, R.color.bg_all));
        this.mPaint.setFlags(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(15.0f);
        this.mPath.reset();
        float f11 = this.mCenterX;
        float f12 = this.mRectF.top;
        this.mPath.moveTo(f11 - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))), f12 - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.lineTo(((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))) + f11, f12 - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.lineTo(f11 - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(36.0d)))), ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(36.0d)))) + f12);
        this.mPath.lineTo(f11, f12 - this.mStarRadius);
        this.mPath.lineTo(((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(36.0d)))) + f11, ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(36.0d)))) + f12);
        this.mPath.lineTo(f11 - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))), f12 - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.close();
        canvas2.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        RectF rectF = this.mRectF;
        float f13 = (rectF.bottom - rectF.top) / 2.0f;
        double d11 = (double) f13;
        float sin = this.mCenterX - ((float) (Math.sin(Math.toRadians((double) this.mAngdeg)) * d11));
        float cos = (this.mRectF.top + f13) - ((float) (Math.cos(Math.toRadians((double) this.mAngdeg)) * d11));
        this.mPath.moveTo(sin - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))), cos - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.lineTo(((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))) + sin, cos - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.lineTo(sin - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(36.0d)))), ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(36.0d)))) + cos);
        this.mPath.lineTo(sin, cos - this.mStarRadius);
        this.mPath.lineTo(((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(36.0d)))) + sin, ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(36.0d)))) + cos);
        this.mPath.lineTo(sin - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))), cos - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.close();
        canvas2.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        float sin2 = this.mCenterX + ((float) (Math.sin(Math.toRadians((double) this.mAngdeg)) * d11));
        float cos2 = (this.mRectF.top + f13) - ((float) (d11 * Math.cos(Math.toRadians((double) this.mAngdeg))));
        this.mPath.moveTo(sin2 - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))), cos2 - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.lineTo(((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))) + sin2, cos2 - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.lineTo(sin2 - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(36.0d)))), ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(36.0d)))) + cos2);
        this.mPath.lineTo(sin2, cos2 - this.mStarRadius);
        this.mPath.lineTo(((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(36.0d)))) + sin2, ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(36.0d)))) + cos2);
        this.mPath.lineTo(sin2 - ((float) (((double) this.mStarRadius) * Math.sin(Math.toRadians(72.0d)))), cos2 - ((float) (((double) this.mStarRadius) * Math.cos(Math.toRadians(72.0d)))));
        this.mPath.close();
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    private void drawText(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setColor(ContextCompat.getColor(this.mContext, R.color.color_cccccc));
        this.mPaint.setFlags(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setTextSize(this.mTextSize);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        int i11 = this.mTicketMode;
        if (i11 == 1) {
            if (!TextUtils.isEmpty(this.mOverdueText)) {
                canvas.drawText(this.mOverdueText, this.mCenterX, this.mCenterY + 10.0f, this.mPaint);
            }
        } else if (i11 == 2) {
            if (!TextUtils.isEmpty(this.mUseDateText)) {
                canvas.drawText(this.mUseDateText, this.mCenterX, this.mCenterY - 20.0f, this.mPaint);
            }
            if (!TextUtils.isEmpty(this.mAlreadyUseText)) {
                canvas.drawText(this.mAlreadyUseText, this.mCenterX, this.mCenterY + 35.0f, this.mPaint);
            }
        }
    }

    private void drawTopCircleBorder(Canvas canvas) {
        for (int i11 = 0; i11 < this.circleNum; i11++) {
            float f11 = this.mGap;
            float f12 = this.radius;
            canvas.drawCircle(f11 + f12 + (this.mRemain / 2.0f) + ((f11 + (2.0f * f12)) * ((float) i11)), 0.0f, f12, this.mPaint);
        }
    }

    private void init(Context context) {
        setWillNotDraw(false);
        this.mContext = context;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(ContextCompat.getColor(context, R.color.bg_all));
        this.mPaint.setFlags(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mRectF = new RectF();
        this.mTextSize = (float) PixelUtils.a(14.0f);
        this.mAngdeg = 24;
        this.mPath = new Path();
        this.mOverdueText = this.mContext.getResources().getString(R.string.overdue);
        this.mAlreadyUseText = this.mContext.getResources().getString(R.string.already_use);
        this.mStarRadius = (float) PixelUtils.a(7.0f);
    }

    public int getTicketMode() {
        return this.mTicketMode;
    }

    public String getUseDateText() {
        return this.mUseDateText;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTopCircleBorder(canvas);
        if (this.mTicketMode != 3) {
            canvas.save();
            canvas.rotate(-30.0f, this.mCenterX, this.mCenterY);
            drawBigCircle(canvas);
            drawSmallCircle(canvas);
            drawStar(canvas);
            drawText(canvas);
            canvas.restore();
        }
        drawLeftBoundCircle(canvas);
        drawRightBoundCircle(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        View childAt = getChildAt(1);
        if (childAt != null) {
            this.mDottedHeight = (float) childAt.getTop();
        }
        this.mCenterY = (this.mDottedHeight / 2.0f) - 20.0f;
        float f11 = this.mCenterY;
        this.mCenterX = ((float) getMeasuredWidth()) - f11;
        float f12 = f11 + 35.0f;
        this.mBigCircleRadius = f12;
        this.mSmallCircleRadius = (f12 * 2.0f) / 3.0f;
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.mRemain == 0.0f) {
            float f11 = this.mGap;
            this.mRemain = ((float) ((int) (((float) i11) - f11))) % ((this.radius * 2.0f) + f11);
        }
        float f12 = this.mGap;
        this.circleNum = (int) ((((float) i11) - f12) / ((this.radius * 2.0f) + f12));
    }

    public void setTicketMode(int i11) {
        this.mTicketMode = i11;
    }

    public void setUseDateText(String str) {
        this.mUseDateText = str;
    }

    public CustomTicketView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CustomTicketView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
