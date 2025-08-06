package com.hbg.module.libkt.custom;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.r;

public final class CircleProgress extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f24651b;

    /* renamed from: c  reason: collision with root package name */
    public final RingViewAttr f24652c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f24653d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f24654e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f24655f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f24656g;

    /* renamed from: h  reason: collision with root package name */
    public ObjectAnimator f24657h;

    public CircleProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircleProgress(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final ObjectAnimator getObjectAnimator() {
        return this.f24657h;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f11 = (float) 2;
        canvas.drawCircle(((float) this.f24652c.d()) / f11, ((float) this.f24652c.d()) / f11, (((float) this.f24652c.d()) / f11) - ((float) (this.f24652c.e() / 2)), this.f24653d);
        canvas.drawArc(this.f24656g, -90.0f, ((float) this.f24651b) * 3.6f, false, this.f24655f);
        new ColorFilter();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(View.resolveSize(this.f24652c.d(), i11), View.resolveSize(this.f24652c.d(), i12));
    }

    public final void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f24657h = objectAnimator;
    }

    public void setPercent(int i11) {
        this.f24651b = i11;
        invalidate();
    }

    public CircleProgress(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        RingViewAttr ringViewAttr = new RingViewAttr(context, attributeSet);
        this.f24652c = ringViewAttr;
        Paint paint = new Paint();
        this.f24653d = paint;
        Paint paint2 = new Paint();
        this.f24654e = paint2;
        Paint paint3 = new Paint();
        this.f24655f = paint3;
        float f11 = (float) 2;
        this.f24656g = new RectF(((float) ringViewAttr.e()) / f11, ((float) ringViewAttr.e()) / f11, ((float) ringViewAttr.d()) - ((float) (ringViewAttr.e() / 2)), ((float) ringViewAttr.d()) - ((float) (ringViewAttr.e() / 2)));
        paint2.setColor(ringViewAttr.b());
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) ringViewAttr.e());
        paint3.setColor(ringViewAttr.c());
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth((float) ringViewAttr.e());
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth((float) ringViewAttr.e());
        paint.setColor(ringViewAttr.a());
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint3.setStrokeCap(Paint.Cap.ROUND);
    }
}
