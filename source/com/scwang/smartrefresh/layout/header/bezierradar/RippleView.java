package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RippleView extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f29891b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f29892c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f29893d;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = RippleView.this.f29891b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RippleView.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
        }
    }

    public RippleView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f29892c = paint;
        paint.setAntiAlias(true);
        this.f29892c.setColor(-1);
        this.f29892c.setStyle(Paint.Style.FILL);
    }

    public void b() {
        if (this.f29893d == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, (int) Math.sqrt(Math.pow((double) getHeight(), 2.0d) + Math.pow((double) getWidth(), 2.0d))});
            this.f29893d = ofInt;
            ofInt.setDuration(400);
            this.f29893d.addUpdateListener(new a());
            this.f29893d.addListener(new b());
        }
        this.f29893d.start();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.f29891b, this.f29892c);
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void setFrontColor(int i11) {
        this.f29892c.setColor(i11);
    }
}
