package com.huobi.edgeengine.widget.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.huobi.R$styleable;
import com.xiaomi.mipush.sdk.Constants;
import gk.b;

public class LightingAnimationView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f44473b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f44474c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f44475d;

    /* renamed from: e  reason: collision with root package name */
    public int f44476e;

    /* renamed from: f  reason: collision with root package name */
    public final Path f44477f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f44478g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f44479h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f44480i;

    /* renamed from: j  reason: collision with root package name */
    public int f44481j;

    /* renamed from: k  reason: collision with root package name */
    public int f44482k;

    /* renamed from: l  reason: collision with root package name */
    public int f44483l;

    /* renamed from: m  reason: collision with root package name */
    public float f44484m;

    /* renamed from: n  reason: collision with root package name */
    public int f44485n;

    public LightingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(float f11, float f12, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f13 = floatValue + f12;
        this.f44473b.setShader(new LinearGradient(floatValue, f11 * floatValue, f13, f11 * f13, this.f44479h, this.f44480i, Shader.TileMode.CLAMP));
        invalidate();
    }

    public final void c(int i11, int i12, int i13, long j11) {
        this.f44474c.moveTo(0.0f, 0.0f);
        float f11 = (float) i11;
        this.f44474c.lineTo(f11, 0.0f);
        float f12 = (float) i12;
        this.f44474c.lineTo(f11, f12);
        this.f44474c.lineTo(0.0f, f12);
        this.f44474c.close();
        float f13 = this.f44484m;
        if (this.f44485n < 0) {
            this.f44485n = i11 / 3;
        }
        float f14 = (float) this.f44485n;
        ValueAnimator valueAnimator = this.f44475d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f15 = 2.0f * f14;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f - f15, f11 + f15});
        this.f44475d = ofFloat;
        ofFloat.setRepeatCount(i13);
        this.f44475d.setInterpolator(new LinearInterpolator());
        this.f44475d.setDuration(j11);
        this.f44475d.addUpdateListener(new b(this, f13, f14));
        this.f44475d.start();
    }

    public float getMk() {
        return this.f44484m;
    }

    public int getMw() {
        return this.f44485n;
    }

    public int getRadius() {
        return this.f44476e;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f44475d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f44475d = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f44477f.reset();
        if (this.f44476e < 0) {
            this.f44476e = getHeight() / 2;
        }
        this.f44478g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        Path path = this.f44477f;
        RectF rectF = this.f44478g;
        int i11 = this.f44476e;
        path.addRoundRect(rectF, (float) i11, (float) i11, Path.Direction.CW);
        canvas.clipPath(this.f44477f);
        canvas.drawPath(this.f44474c, this.f44473b);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (this.f44481j == 1) {
            c(size, size2, this.f44483l, (long) this.f44482k);
        }
    }

    public void setMk(float f11) {
        this.f44484m = f11;
    }

    public void setMw(int i11) {
        this.f44485n = i11;
    }

    public void setRadius(int i11) {
        this.f44476e = i11;
    }

    public LightingAnimationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44473b = new Paint();
        this.f44474c = new Path();
        this.f44475d = null;
        this.f44476e = -1;
        this.f44477f = new Path();
        this.f44478g = new RectF();
        this.f44479h = new int[]{FlexItem.MAX_SIZE, 1308622847, 1308622847, FlexItem.MAX_SIZE};
        this.f44480i = new float[]{0.0f, 0.4f, 0.5f, 1.0f};
        this.f44481j = 1;
        this.f44482k = 1600;
        this.f44483l = -1;
        this.f44484m = 0.45f;
        this.f44485n = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LightingAnimationView);
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(4);
            if (!(string == null || string2 == null)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String[] split2 = string2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int length = split.length;
                if (length == split2.length) {
                    this.f44479h = new int[length];
                    this.f44480i = new float[length];
                    for (int i12 = 0; i12 < length; i12++) {
                        this.f44479h[i12] = Color.parseColor(split[i12]);
                        this.f44480i[i12] = Float.parseFloat(split2[i12]);
                    }
                }
            }
            this.f44481j = obtainStyledAttributes.getInt(3, this.f44481j);
            int i13 = obtainStyledAttributes.getInt(6, this.f44483l);
            this.f44483l = i13;
            if (i13 < 0 && i13 != -1) {
                this.f44483l = -1;
            }
            this.f44482k = obtainStyledAttributes.getInt(1, this.f44482k);
            this.f44476e = obtainStyledAttributes.getDimensionPixelSize(5, this.f44476e);
            this.f44484m = obtainStyledAttributes.getFloat(2, this.f44484m);
            this.f44485n = obtainStyledAttributes.getDimensionPixelSize(7, this.f44485n);
            obtainStyledAttributes.recycle();
        }
    }
}
