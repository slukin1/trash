package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$styleable;

public class HIndicator extends View {
    private int mBgColor;
    private Paint mBgPaint;
    private RectF mBgRect;
    private int mIndicatorColor;
    private Paint mPaint;
    private float mProgress;
    private float mRadius;
    private float mRatio;
    private RectF mRect;
    private int mViewWidth;

    public HIndicator(Context context) {
        super(context);
        init();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$bindRecyclerView$0(RecyclerView recyclerView, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        setRatio((((float) recyclerView.computeHorizontalScrollExtent()) * 1.0f) / ((float) recyclerView.computeHorizontalScrollRange()));
    }

    public void bindRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                super.onScrolled(recyclerView, i11, i12);
                HIndicator.this.setProgress((((float) recyclerView.computeHorizontalScrollOffset()) * 1.0f) / ((float) (recyclerView.computeHorizontalScrollRange() - recyclerView.computeHorizontalScrollExtent())));
            }
        });
        recyclerView.addOnLayoutChangeListener(new e0(this, recyclerView));
    }

    public void init() {
        this.mBgPaint = new Paint(1);
        this.mBgRect = new RectF();
        this.mPaint = new Paint(1);
        this.mRect = new RectF();
        this.mBgColor = Color.parseColor("#e5e5e5");
        this.mIndicatorColor = Color.parseColor("#ff4646");
        this.mRadius = 0.5f;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            RectF rectF = this.mBgRect;
            float f11 = this.mRadius;
            canvas.drawRoundRect(rectF, f11, f11, this.mBgPaint);
        }
        int i11 = this.mViewWidth;
        float f12 = this.mRatio;
        float f13 = ((float) i11) * (1.0f - f12) * this.mProgress;
        RectF rectF2 = this.mBgRect;
        float f14 = rectF2.left + f13;
        this.mRect.set(f14, rectF2.top, (((float) i11) * f12) + f14, rectF2.bottom);
        if (canvas != null) {
            RectF rectF3 = this.mRect;
            float f15 = this.mRadius;
            canvas.drawRoundRect(rectF3, f15, f15, this.mPaint);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.mViewWidth = i11;
        float f11 = (float) i12;
        this.mBgRect.set(0.0f, 0.0f, ((float) i11) * 1.0f, 1.0f * f11);
        this.mRadius = f11 / 2.0f;
    }

    public void setBgColor(int i11) {
        this.mBgPaint.setColor(i11);
        invalidate();
    }

    public void setIndicatorColor(int i11) {
        this.mPaint.setColor(i11);
        invalidate();
    }

    public final void setProgress(float f11) {
        this.mProgress = f11;
        invalidate();
    }

    public void setRatio(float f11) {
        this.mRatio = f11;
    }

    public HIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HIndicator);
        this.mBgColor = obtainStyledAttributes.getColor(R$styleable.HIndicator_h_bgColor, this.mBgColor);
        this.mIndicatorColor = obtainStyledAttributes.getColor(R$styleable.HIndicator_h_indicatorColor, this.mIndicatorColor);
        obtainStyledAttributes.recycle();
        this.mBgPaint.setColor(this.mBgColor);
        this.mBgPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mIndicatorColor);
        this.mPaint.setStyle(Paint.Style.FILL);
    }
}
