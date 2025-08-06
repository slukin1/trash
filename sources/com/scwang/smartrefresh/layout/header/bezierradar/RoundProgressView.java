package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class RoundProgressView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f29900b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f29901c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f29902d;

    /* renamed from: e  reason: collision with root package name */
    public int f29903e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f29904f = 270;

    /* renamed from: g  reason: collision with root package name */
    public int f29905g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f29906h = 0;

    /* renamed from: i  reason: collision with root package name */
    public RectF f29907i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = RoundProgressView.this.f29903e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RoundProgressView.this.postInvalidate();
        }
    }

    public RoundProgressView(Context context) {
        super(context);
        b();
    }

    public final void b() {
        this.f29900b = new Paint();
        this.f29901c = new Paint();
        this.f29900b.setAntiAlias(true);
        this.f29901c.setAntiAlias(true);
        this.f29900b.setColor(-1);
        this.f29901c.setColor(1426063360);
        DensityUtil densityUtil = new DensityUtil();
        this.f29905g = densityUtil.a(20.0f);
        this.f29906h = densityUtil.a(7.0f);
        this.f29900b.setStrokeWidth((float) densityUtil.a(3.0f));
        this.f29901c.setStrokeWidth((float) densityUtil.a(3.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 360});
        this.f29902d = ofInt;
        ofInt.setDuration(720);
        this.f29902d.setRepeatCount(-1);
        this.f29902d.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void c() {
        ValueAnimator valueAnimator = this.f29902d;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void d() {
        ValueAnimator valueAnimator = this.f29902d;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f29902d.cancel();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f29902d.addUpdateListener(new a());
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29902d.removeAllUpdateListeners();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.f29904f = 0;
            this.f29903e = 270;
        }
        this.f29900b.setStyle(Paint.Style.FILL);
        int i11 = width / 2;
        float f11 = (float) i11;
        int i12 = height / 2;
        float f12 = (float) i12;
        canvas.drawCircle(f11, f12, (float) this.f29905g, this.f29900b);
        this.f29900b.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f11, f12, (float) (this.f29905g + this.f29906h), this.f29900b);
        this.f29901c.setStyle(Paint.Style.FILL);
        RectF rectF = this.f29907i;
        int i13 = this.f29905g;
        rectF.set((float) (i11 - i13), (float) (i12 - i13), (float) (i11 + i13), (float) (i13 + i12));
        canvas.drawArc(this.f29907i, (float) this.f29904f, (float) this.f29903e, true, this.f29901c);
        this.f29905g += this.f29906h;
        this.f29901c.setStyle(Paint.Style.STROKE);
        RectF rectF2 = this.f29907i;
        int i14 = this.f29905g;
        rectF2.set((float) (i11 - i14), (float) (i12 - i14), (float) (i11 + i14), (float) (i12 + i14));
        canvas.drawArc(this.f29907i, (float) this.f29904f, (float) this.f29903e, false, this.f29901c);
        this.f29905g -= this.f29906h;
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void setBackColor(int i11) {
        this.f29901c.setColor((i11 & FlexItem.MAX_SIZE) | 1426063360);
    }

    public void setFrontColor(int i11) {
        this.f29900b.setColor(i11);
    }
}
