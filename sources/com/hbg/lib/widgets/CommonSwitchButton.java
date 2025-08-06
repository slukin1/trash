package com.hbg.lib.widgets;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;

public class CommonSwitchButton extends View implements Checkable, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71212b;

    /* renamed from: c  reason: collision with root package name */
    public Path f71213c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f71214d;

    /* renamed from: e  reason: collision with root package name */
    public int f71215e;

    /* renamed from: f  reason: collision with root package name */
    public int f71216f;

    /* renamed from: g  reason: collision with root package name */
    public int f71217g;

    /* renamed from: h  reason: collision with root package name */
    public float f71218h;

    /* renamed from: i  reason: collision with root package name */
    public float f71219i;

    /* renamed from: j  reason: collision with root package name */
    public float f71220j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71221k;

    /* renamed from: l  reason: collision with root package name */
    public int f71222l;

    /* renamed from: m  reason: collision with root package name */
    public int f71223m;

    /* renamed from: n  reason: collision with root package name */
    public int f71224n;

    /* renamed from: o  reason: collision with root package name */
    public int f71225o;

    /* renamed from: p  reason: collision with root package name */
    public int f71226p;

    /* renamed from: q  reason: collision with root package name */
    public int f71227q;

    /* renamed from: r  reason: collision with root package name */
    public int f71228r;

    /* renamed from: s  reason: collision with root package name */
    public float f71229s;

    /* renamed from: t  reason: collision with root package name */
    public final ArgbEvaluator f71230t;

    /* renamed from: u  reason: collision with root package name */
    public ValueAnimator f71231u;

    public CommonSwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.f71212b.setAntiAlias(true);
        this.f71212b.setStrokeWidth(1.0f);
        this.f71212b.setStyle(Paint.Style.FILL);
        this.f71212b.setColor(this.f71224n);
        this.f71214d.setAntiAlias(true);
        this.f71214d.setStrokeWidth(1.0f);
        this.f71214d.setStyle(Paint.Style.FILL);
        setChecked(this.f71221k);
    }

    public void b(boolean z11, boolean z12) {
        this.f71221k = z11;
        int i11 = this.f71222l;
        if (i11 == 0 && this.f71223m == 0) {
            float f11 = 1.0f;
            if (z12) {
                if (!z11) {
                    f11 = 0.0f;
                }
                c(f11);
                return;
            }
            if (!z11) {
                f11 = 0.0f;
            }
            this.f71220j = f11;
            invalidate();
        } else if (z11) {
            setBackgroundResource(i11);
        } else {
            setBackgroundResource(this.f71223m);
        }
    }

    public final void c(float f11) {
        ValueAnimator valueAnimator = this.f71231u;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f71231u.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f71220j, f11});
        this.f71231u = ofFloat;
        ofFloat.setDuration(170);
        this.f71231u.setInterpolator(new LinearInterpolator());
        this.f71231u.addUpdateListener(this);
        this.f71231u.start();
    }

    public int getBallCheckedColor() {
        return this.f71226p;
    }

    public float getBallRadius() {
        return this.f71219i;
    }

    public int getBallUnCheckedColor() {
        return this.f71227q;
    }

    public int getBgHeight() {
        return this.f71228r;
    }

    public int getCheckedBgColor() {
        return this.f71225o;
    }

    public int getCheckedBgResId() {
        return this.f71222l;
    }

    public float getCornerRadius() {
        return this.f71229s;
    }

    public int getUnCheckedBgColor() {
        return this.f71224n;
    }

    public int getUnCheckedBgResId() {
        return this.f71223m;
    }

    public boolean isChecked() {
        return this.f71221k;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f71220j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f71222l == 0 && this.f71223m == 0) {
            if (this.f71215e == 0) {
                this.f71215e = getWidth();
            }
            if (this.f71216f == 0) {
                this.f71216f = getHeight();
            }
            if (this.f71217g == 0) {
                this.f71217g = this.f71216f / 2;
            }
            if (this.f71218h == 0.0f) {
                this.f71218h = (float) (this.f71215e - (this.f71217g * 2));
            }
            if (this.f71213c == null) {
                this.f71213c = new Path();
                int i11 = 0;
                int height = getHeight();
                int i12 = this.f71228r;
                if (i12 > 0) {
                    int i13 = this.f71216f;
                    int i14 = (i13 - i12) / 2;
                    int i15 = i14;
                    height = i13 - i14;
                    i11 = i15;
                }
                if (this.f71229s <= 0.0f) {
                    this.f71229s = (float) this.f71217g;
                }
                Path path = this.f71213c;
                RectF rectF = new RectF(0.0f, (float) i11, (float) this.f71215e, (float) height);
                float f11 = this.f71229s;
                path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
            }
            this.f71212b.setColor(((Integer) this.f71230t.evaluate(this.f71220j, Integer.valueOf(this.f71224n), Integer.valueOf(this.f71225o))).intValue());
            canvas.drawPath(this.f71213c, this.f71212b);
            float min = Math.min(Math.max(this.f71218h * this.f71220j, 0.0f), this.f71218h);
            this.f71214d.setColor(((Integer) this.f71230t.evaluate(this.f71220j, Integer.valueOf(this.f71227q), Integer.valueOf(this.f71226p))).intValue());
            int i16 = this.f71217g;
            float max = Math.max(((float) i16) + min, (float) i16);
            if (this.f71219i == 0.0f) {
                this.f71219i = (float) this.f71217g;
            }
            canvas.drawCircle(max, (float) this.f71217g, this.f71219i, this.f71214d);
        }
    }

    public void setBallCheckedColor(int i11) {
        this.f71226p = i11;
    }

    public void setBallRadius(float f11) {
        this.f71219i = f11;
    }

    public void setBallUnCheckedColor(int i11) {
        this.f71227q = i11;
    }

    public void setBgHeight(int i11) {
        this.f71228r = i11;
    }

    public void setChecked(boolean z11) {
        b(z11, false);
    }

    public void setCheckedBgColor(int i11) {
        this.f71225o = i11;
    }

    public void setCheckedBgResId(int i11) {
        this.f71222l = i11;
    }

    public void setCornerRadius(float f11) {
        this.f71229s = f11;
    }

    public void setUnCheckedBgColor(int i11) {
        this.f71224n = i11;
    }

    public void setUnCheckedBgResId(int i11) {
        this.f71223m = i11;
    }

    public void toggle() {
        setChecked(!this.f71221k);
    }

    public CommonSwitchButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71212b = new Paint();
        this.f71214d = new Paint();
        this.f71220j = 0.0f;
        this.f71224n = -2171170;
        this.f71225o = -3809281;
        this.f71226p = -14786089;
        this.f71227q = -1052689;
        this.f71230t = new ArgbEvaluator();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonSwitchButton, i11, 0);
            this.f71221k = obtainStyledAttributes.getBoolean(R$styleable.CommonSwitchButton_is_checked, this.f71221k);
            this.f71222l = obtainStyledAttributes.getResourceId(R$styleable.CommonSwitchButton_checked_bg_res, this.f71222l);
            this.f71223m = obtainStyledAttributes.getResourceId(R$styleable.CommonSwitchButton_unchecked_bg_res, 0);
            this.f71219i = (float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonSwitchButton_ball_radius, 0);
            this.f71224n = obtainStyledAttributes.getColor(R$styleable.CommonSwitchButton_unCheckedBackgroundColor, -2171170);
            this.f71225o = obtainStyledAttributes.getColor(R$styleable.CommonSwitchButton_checkedBackgroundColor, -3809281);
            this.f71226p = obtainStyledAttributes.getColor(R$styleable.CommonSwitchButton_ballCheckedColor, -14786089);
            this.f71227q = obtainStyledAttributes.getColor(R$styleable.CommonSwitchButton_ballUnCheckedColor, -1052689);
            this.f71228r = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonSwitchButton_bg_height, 0);
            this.f71229s = (float) obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonSwitchButton_corner_radius, 0);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }
}
