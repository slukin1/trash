package com.huobi.kyc.huaweiliveness.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import pro.huobi.R;

public class ProgressView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f74820b;

    /* renamed from: c  reason: collision with root package name */
    public int f74821c;

    /* renamed from: d  reason: collision with root package name */
    public int f74822d;

    /* renamed from: e  reason: collision with root package name */
    public int f74823e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f74824f;

    /* renamed from: g  reason: collision with root package name */
    public SweepGradient f74825g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f74826h;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue > ProgressView.this.f74823e + 5 || intValue < ProgressView.this.f74823e) {
                int unused = ProgressView.this.f74823e = intValue;
                ProgressView.this.f74826h.setRotate((float) (ProgressView.this.f74823e - 10), (float) ProgressView.this.f74821c, (float) ProgressView.this.f74822d);
                ProgressView.this.f74825g.setLocalMatrix(ProgressView.this.f74826h);
                ProgressView.this.invalidate();
            }
        }
    }

    public ProgressView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f74820b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f74820b.setAntiAlias(true);
        this.f74820b.setStrokeWidth(15.0f);
        this.f74820b.setStrokeCap(Paint.Cap.ROUND);
        SweepGradient sweepGradient = new SweepGradient((float) this.f74821c, (float) this.f74822d, new int[]{getResources().getColor(R.color.base_major_theme030), getResources().getColor(R.color.base_major_theme030), getResources().getColor(R.color.base_major_theme030), getResources().getColor(R.color.base_major_theme030)}, new float[]{0.0f, 0.3f, 0.8f, 1.0f});
        this.f74825g = sweepGradient;
        this.f74820b.setShader(sweepGradient);
    }

    public void g(int i11, int i12, int i13) {
        this.f74821c = i11;
        this.f74822d = i12;
        float strokeWidth = this.f74820b.getStrokeWidth() / 2.0f;
        this.f74824f = new RectF(((float) (i11 - i13)) - strokeWidth, ((float) (i12 - i13)) - strokeWidth, ((float) (i11 + i13)) + strokeWidth, ((float) (i12 + i13)) + strokeWidth);
        this.f74826h = new Matrix();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 360});
        ofInt.setRepeatCount(-1);
        ofInt.setDuration(1000);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new a());
        ofInt.start();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f74824f, (float) this.f74823e, 270.0f, false, this.f74820b);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
