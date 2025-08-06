package com.huobi.account.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import pro.huobi.R;

public class SemicircleProgressView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final float f42007b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f42008c;

    /* renamed from: d  reason: collision with root package name */
    public int f42009d;

    /* renamed from: e  reason: collision with root package name */
    public int f42010e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f42011f;

    /* renamed from: g  reason: collision with root package name */
    public final int f42012g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f42013h;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f42014i;

    public SemicircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f42013h;
        rectF.left = this.f42007b;
        float f11 = this.f42007b;
        rectF.right = ((float) getWidth()) - f11;
        RectF rectF2 = this.f42013h;
        rectF2.top = f11 / 2.0f;
        rectF2.bottom = ((float) (getHeight() * 2)) - this.f42007b;
        canvas.drawArc(this.f42013h, 183.0f, 174.0f, false, this.f42008c);
        RectF rectF3 = this.f42014i;
        rectF3.left = this.f42007b;
        float f12 = this.f42007b;
        rectF3.right = ((float) getWidth()) - f12;
        RectF rectF4 = this.f42014i;
        rectF4.top = f12 / 2.0f;
        rectF4.bottom = ((float) (getHeight() * 2)) - this.f42007b;
        float f13 = (((float) this.f42010e) / ((float) this.f42009d)) * 174.0f;
        Log.d("SemicircleProgressView", "sweepAngle" + f13);
        canvas.drawArc(this.f42014i, 183.0f, f13, false, this.f42011f);
        Drawable f14 = ResourcesCompat.f(getResources(), R.drawable.ic_treasure_box_no_open, (Resources.Theme) null);
        if (f14 != null) {
            f14.setBounds((getWidth() / 2) - this.f42012g, getHeight() - ((int) ((((float) f14.getIntrinsicHeight()) / ((float) f14.getIntrinsicWidth())) * ((float) (this.f42012g * 2)))), (getWidth() / 2) + this.f42012g, getHeight());
            f14.draw(canvas);
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
    }

    public synchronized void setCurrentStep(int i11) {
        this.f42010e = i11;
        postInvalidate();
    }

    public synchronized void setMaxStep(int i11) {
        this.f42009d = i11;
    }

    public SemicircleProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42009d = 100;
        this.f42010e = 0;
        this.f42012g = PixelUtils.a(18.0f);
        this.f42013h = new RectF();
        this.f42014i = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SemicircleProgressView);
        int color = obtainStyledAttributes.getColor(2, getResources().getColor(R.color.baseColorPrimarySeparator));
        float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(3, PixelUtils.a(3.0f));
        this.f42007b = dimensionPixelSize;
        int color2 = obtainStyledAttributes.getColor(0, -359135);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, PixelUtils.a(3.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f42008c = paint;
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dimensionPixelSize);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f42011f = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(color2);
        paint2.setStrokeWidth((float) dimensionPixelSize2);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStyle(Paint.Style.STROKE);
    }
}
