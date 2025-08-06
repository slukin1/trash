package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

public class ProgressDrawable extends Drawable implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    public int f29917b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f29918c;

    /* renamed from: d  reason: collision with root package name */
    public Path f29919d = new Path();

    /* renamed from: e  reason: collision with root package name */
    public Paint f29920e;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = ProgressDrawable.this.f29917b = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
            ProgressDrawable.this.invalidateSelf();
        }
    }

    public ProgressDrawable() {
        Paint paint = new Paint();
        this.f29920e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f29920e.setAntiAlias(true);
        this.f29920e.setColor(-5592406);
        d();
    }

    public int b() {
        return getBounds().height();
    }

    public void c(int i11) {
        this.f29920e.setColor(i11);
    }

    public final void d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{30, 3600});
        this.f29918c = ofInt;
        ofInt.addUpdateListener(new a());
        this.f29918c.setDuration(10000);
        this.f29918c.setInterpolator(new LinearInterpolator());
        this.f29918c.setRepeatCount(-1);
        this.f29918c.setRepeatMode(1);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.save();
        float f11 = (float) (width / 2);
        int i11 = height / 2;
        float f12 = (float) i11;
        canvas.rotate((float) this.f29917b, f11, f12);
        int max = Math.max(1, width / 20);
        for (int i12 = 0; i12 < 12; i12++) {
            this.f29919d.reset();
            float f13 = (float) (width - max);
            float f14 = (float) max;
            this.f29919d.addCircle(f13, f12, f14, Path.Direction.CW);
            float f15 = (float) (width - (max * 5));
            this.f29919d.addRect(f15, (float) (i11 - max), f13, (float) (i11 + max), Path.Direction.CW);
            this.f29919d.addCircle(f15, f12, f14, Path.Direction.CW);
            this.f29920e.setAlpha((i12 + 5) * 17);
            canvas.rotate(30.0f, f11, f12);
            canvas.drawPath(this.f29919d, this.f29920e);
        }
        canvas.restore();
    }

    public int e() {
        return getBounds().width();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f29918c.isRunning();
    }

    public void setAlpha(int i11) {
        this.f29920e.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f29920e.setColorFilter(colorFilter);
    }

    public void start() {
        if (!this.f29918c.isRunning()) {
            this.f29918c.start();
        }
    }

    public void stop() {
        if (this.f29918c.isRunning()) {
            this.f29918c.cancel();
        }
    }
}
