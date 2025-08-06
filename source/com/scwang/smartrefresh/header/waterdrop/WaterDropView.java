package com.scwang.smartrefresh.header.waterdrop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class WaterDropView extends View {

    /* renamed from: h  reason: collision with root package name */
    public static int f29689h = 2;

    /* renamed from: b  reason: collision with root package name */
    public Circle f29690b;

    /* renamed from: c  reason: collision with root package name */
    public Circle f29691c;

    /* renamed from: d  reason: collision with root package name */
    public Path f29692d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f29693e;

    /* renamed from: f  reason: collision with root package name */
    public int f29694f;

    /* renamed from: g  reason: collision with root package name */
    public int f29695g;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        b(context, (AttributeSet) null);
    }

    private double getAngle() {
        Circle circle = this.f29691c;
        float f11 = circle.f29688c;
        Circle circle2 = this.f29690b;
        float f12 = circle2.f29688c;
        if (f11 <= f12) {
            return Math.asin((double) ((f12 - f11) / (circle.f29687b - circle2.f29687b)));
        }
        throw new IllegalStateException("bottomCircle's radius must be less than the topCircle's");
    }

    public Animator a() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.001f}).setDuration(180);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new a());
        return duration;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.f29690b = new Circle();
        this.f29691c = new Circle();
        this.f29692d = new Path();
        Paint paint = new Paint();
        this.f29693e = paint;
        paint.setColor(-7829368);
        this.f29693e.setAntiAlias(true);
        this.f29693e.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.f29693e;
        int b11 = DensityUtil.b(1.0f);
        f29689h = b11;
        paint2.setStrokeWidth((float) b11);
        Paint paint3 = this.f29693e;
        int i11 = f29689h;
        paint3.setShadowLayer((float) i11, (float) (i11 / 2), (float) i11, -1728053248);
        setLayerType(1, (Paint) null);
        int i12 = f29689h * 4;
        setPadding(i12, i12, i12, i12);
        int b12 = DensityUtil.b(20.0f);
        this.f29694f = b12;
        this.f29695g = b12 / 5;
        Circle circle = this.f29690b;
        circle.f29688c = (float) b12;
        Circle circle2 = this.f29691c;
        circle2.f29688c = (float) b12;
        int i13 = f29689h;
        circle.f29686a = (float) (i13 + b12);
        circle.f29687b = (float) (i13 + b12);
        circle2.f29686a = (float) (i13 + b12);
        circle2.f29687b = (float) (i13 + b12);
    }

    public final void c() {
        this.f29692d.reset();
        Path path = this.f29692d;
        Circle circle = this.f29690b;
        path.addCircle(circle.f29686a, circle.f29687b, circle.f29688c, Path.Direction.CCW);
        if (this.f29691c.f29687b > this.f29690b.f29687b + ((float) DensityUtil.b(1.0f))) {
            Path path2 = this.f29692d;
            Circle circle2 = this.f29691c;
            path2.addCircle(circle2.f29686a, circle2.f29687b, circle2.f29688c, Path.Direction.CCW);
            double angle = getAngle();
            Circle circle3 = this.f29690b;
            float cos = (float) (((double) circle3.f29686a) - (((double) circle3.f29688c) * Math.cos(angle)));
            Circle circle4 = this.f29690b;
            float sin = (float) (((double) circle4.f29687b) + (((double) circle4.f29688c) * Math.sin(angle)));
            Circle circle5 = this.f29690b;
            float cos2 = (float) (((double) circle5.f29686a) + (((double) circle5.f29688c) * Math.cos(angle)));
            Circle circle6 = this.f29691c;
            float cos3 = (float) (((double) circle6.f29686a) - (((double) circle6.f29688c) * Math.cos(angle)));
            Circle circle7 = this.f29691c;
            float sin2 = (float) (((double) circle7.f29687b) + (((double) circle7.f29688c) * Math.sin(angle)));
            Circle circle8 = this.f29691c;
            float cos4 = (float) (((double) circle8.f29686a) + (((double) circle8.f29688c) * Math.cos(angle)));
            Path path3 = this.f29692d;
            Circle circle9 = this.f29690b;
            path3.moveTo(circle9.f29686a, circle9.f29687b);
            this.f29692d.lineTo(cos, sin);
            Path path4 = this.f29692d;
            Circle circle10 = this.f29691c;
            path4.quadTo(circle10.f29686a - circle10.f29688c, (circle10.f29687b + this.f29690b.f29687b) / 2.0f, cos3, sin2);
            this.f29692d.lineTo(cos4, sin2);
            Path path5 = this.f29692d;
            Circle circle11 = this.f29691c;
            path5.quadTo(circle11.f29686a + circle11.f29688c, (circle11.f29687b + sin) / 2.0f, cos2, sin);
        }
        this.f29692d.close();
    }

    public void d(float f11) {
        int i11 = this.f29694f;
        float f12 = f11 * 4.0f * ((float) i11);
        Circle circle = this.f29690b;
        circle.f29688c = (float) (((double) i11) - ((((double) f11) * 0.25d) * ((double) i11)));
        Circle circle2 = this.f29691c;
        circle2.f29688c = (((float) (this.f29695g - i11)) * f11) + ((float) i11);
        circle2.f29687b = circle.f29687b + f12;
    }

    public void e(int i11) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i12 = this.f29694f;
        float f11 = (float) ((i12 * 2) + paddingTop + paddingBottom);
        float f12 = (float) i11;
        if (f12 < f11) {
            Circle circle = this.f29690b;
            circle.f29688c = (float) i12;
            Circle circle2 = this.f29691c;
            circle2.f29688c = (float) i12;
            circle2.f29687b = circle.f29687b;
            return;
        }
        float pow = (float) (((double) ((float) (i12 - this.f29695g))) * (1.0d - Math.pow(100.0d, (double) ((-Math.max(0.0f, f12 - f11)) / ((float) DensityUtil.b(200.0f))))));
        Circle circle3 = this.f29690b;
        int i13 = this.f29694f;
        circle3.f29688c = ((float) i13) - (pow / 4.0f);
        Circle circle4 = this.f29691c;
        float f13 = ((float) i13) - pow;
        circle4.f29688c = f13;
        circle4.f29687b = ((float) ((i11 - paddingTop) - paddingBottom)) - f13;
    }

    public void f(int i11, int i12) {
    }

    public Circle getBottomCircle() {
        return this.f29691c;
    }

    public int getIndicatorColor() {
        return this.f29693e.getColor();
    }

    public int getMaxCircleRadius() {
        return this.f29694f;
    }

    public Circle getTopCircle() {
        return this.f29690b;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f11 = (float) height;
        float f12 = this.f29690b.f29688c;
        float f13 = (float) paddingTop;
        float f14 = (float) paddingBottom;
        if (f11 <= (f12 * 2.0f) + f13 + f14) {
            canvas.translate((float) paddingLeft, (f11 - (f12 * 2.0f)) - f14);
            Circle circle = this.f29690b;
            canvas.drawCircle(circle.f29686a, circle.f29687b, circle.f29688c, this.f29693e);
        } else {
            canvas.translate((float) paddingLeft, f13);
            c();
            canvas.drawPath(this.f29692d, this.f29693e);
        }
        canvas.restore();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        e(getHeight());
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.f29694f;
        int i14 = f29689h;
        Circle circle = this.f29691c;
        setMeasuredDimension(((i13 + i14) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil((double) (circle.f29687b + circle.f29688c + ((float) (i14 * 2))))) + getPaddingTop() + getPaddingBottom(), i12));
    }

    public void setIndicatorColor(int i11) {
        this.f29693e.setColor(i11);
    }

    public WaterDropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public WaterDropView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context, attributeSet);
    }
}
