package com.huobi.otc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$styleable;

public class IndicatorPotView extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f79820b;

    /* renamed from: c  reason: collision with root package name */
    public int f79821c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f79822d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f79823e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f79824f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f79825g;

    /* renamed from: h  reason: collision with root package name */
    public float f79826h;

    public IndicatorPotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getCenterColor() {
        return this.f79821c;
    }

    public int getEdgeColor() {
        return this.f79820b;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float min = (float) Math.min(getWidth(), getHeight());
        this.f79823e.set(0.0f, 0.0f, min, min);
        this.f79823e.offset(this.f79822d.exactCenterX() - this.f79823e.centerX(), this.f79822d.exactCenterY() - this.f79823e.centerX());
        RectF rectF = this.f79824f;
        float f11 = this.f79826h;
        rectF.set(0.0f, 0.0f, min - f11, min - f11);
        this.f79824f.offset(this.f79822d.exactCenterX() - this.f79824f.centerX(), this.f79822d.exactCenterY() - this.f79824f.centerX());
        this.f79825g.setColor(this.f79820b);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f79823e, 0.0f, 360.0f, true, this.f79825g);
        this.f79825g.setColor(this.f79821c);
        canvas2.drawArc(this.f79824f, 0.0f, 360.0f, true, this.f79825g);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f79822d.set(0, 0, i11, i12);
    }

    public void setCenterColor(int i11) {
        this.f79821c = i11;
        invalidate();
    }

    public void setEdgeColor(int i11) {
        this.f79820b = i11;
    }

    public IndicatorPotView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79822d = new Rect();
        this.f79823e = new RectF();
        this.f79824f = new RectF();
        this.f79825g = new Paint();
        this.f79826h = (float) PixelUtils.a(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndicatorPotView, i11, 0);
        this.f79820b = obtainStyledAttributes.getColor(R$styleable.IndicatorPotView_edgeColor, -1);
        this.f79821c = obtainStyledAttributes.getColor(R$styleable.IndicatorPotView_centerColor, -7829368);
        obtainStyledAttributes.recycle();
        this.f79825g.setAntiAlias(true);
    }
}
