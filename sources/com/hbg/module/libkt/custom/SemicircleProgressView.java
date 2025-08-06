package com.hbg.module.libkt.custom;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.hbg.module.libkt.R$styleable;
import com.hbg.module.libkt.base.ext.c;
import com.huobi.view.roundimg.RoundedDrawable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import ke.e;
import ke.g;
import kotlin.jvm.internal.r;

public final class SemicircleProgressView extends View {
    public String A;
    public int B;
    public int C;
    public float D;
    public float E;
    public float F;
    public ValueAnimator G;
    public double H;
    public double I;
    public float J;
    public float K;
    public final Float[] L;
    public g M;

    /* renamed from: b  reason: collision with root package name */
    public final int f24732b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24733c;

    /* renamed from: d  reason: collision with root package name */
    public final double f24734d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24735e;

    /* renamed from: f  reason: collision with root package name */
    public final int f24736f;

    /* renamed from: g  reason: collision with root package name */
    public final int f24737g;

    /* renamed from: h  reason: collision with root package name */
    public final float f24738h;

    /* renamed from: i  reason: collision with root package name */
    public int f24739i;

    /* renamed from: j  reason: collision with root package name */
    public int f24740j;

    /* renamed from: k  reason: collision with root package name */
    public final Paint f24741k;

    /* renamed from: l  reason: collision with root package name */
    public int f24742l;

    /* renamed from: m  reason: collision with root package name */
    public final Paint f24743m;

    /* renamed from: n  reason: collision with root package name */
    public int f24744n;

    /* renamed from: o  reason: collision with root package name */
    public final Paint f24745o;

    /* renamed from: p  reason: collision with root package name */
    public final Paint f24746p;

    /* renamed from: q  reason: collision with root package name */
    public final Paint f24747q;

    /* renamed from: r  reason: collision with root package name */
    public final Paint f24748r;

    /* renamed from: s  reason: collision with root package name */
    public final Paint f24749s;

    /* renamed from: t  reason: collision with root package name */
    public final DashPathEffect f24750t;

    /* renamed from: u  reason: collision with root package name */
    public String f24751u;

    /* renamed from: v  reason: collision with root package name */
    public int f24752v;

    /* renamed from: w  reason: collision with root package name */
    public float f24753w;

    /* renamed from: x  reason: collision with root package name */
    public String f24754x;

    /* renamed from: y  reason: collision with root package name */
    public int f24755y;

    /* renamed from: z  reason: collision with root package name */
    public float f24756z;

    public SemicircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SemicircleProgressView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void f(SemicircleProgressView semicircleProgressView, ValueAnimator valueAnimator) {
        semicircleProgressView.K = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        semicircleProgressView.postInvalidate();
    }

    public final void b() {
        double d11 = this.H;
        boolean z11 = true;
        if (d11 > 0.0d) {
            double d12 = this.I;
            if (d12 >= 0.0d && d12 <= d11) {
                this.K = 0.0f;
                this.F = this.E / ((float) 2);
                float f11 = (float) ((d12 * ((double) 1.0f)) / d11);
                this.J = f11;
                if (f11 != 0.0f) {
                    z11 = false;
                }
                if (!z11) {
                    e();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("当前进度必须大于等于0并且小于等于最大进度.".toString());
        }
        throw new IllegalArgumentException("最大进度必须大于0.".toString());
    }

    public final void c() {
        this.f24741k.setStyle(Paint.Style.STROKE);
        this.f24741k.setStrokeWidth(c.e(Float.valueOf(8.0f)));
        this.f24741k.setColor(this.f24742l);
        this.f24741k.setStrokeCap(Paint.Cap.BUTT);
        this.f24743m.setStyle(Paint.Style.STROKE);
        this.f24743m.setStrokeWidth(this.E);
        this.f24743m.setColor(this.f24744n);
        this.f24743m.setStrokeCap(Paint.Cap.BUTT);
        this.f24745o.setColor(this.f24752v);
        this.f24745o.setTextSize(this.f24753w);
        this.f24746p.setColor(this.f24755y);
        this.f24746p.setTextSize(this.f24756z);
        this.f24746p.setFakeBoldText(true);
        this.f24747q.setStyle(Paint.Style.FILL);
        this.f24747q.setColor(this.B);
        this.f24748r.setColor(this.C);
        this.f24748r.setTextSize(this.D);
        this.f24749s.setStyle(Paint.Style.STROKE);
        this.f24749s.setPathEffect(this.f24750t);
        this.f24749s.setStrokeWidth(c.e(Float.valueOf(1.0f)));
    }

    public final void d(double d11, double d12, double d13, String str) {
        this.H = d11;
        this.I = d12;
        this.f24754x = g(d13);
        this.A = str;
        b();
    }

    public final void e() {
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator != null) {
            boolean z11 = true;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                z11 = false;
            }
            if (z11) {
                return;
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.G = ofFloat;
        if (ofFloat != null) {
            ofFloat.addUpdateListener(new e(this));
        }
        ValueAnimator valueAnimator2 = this.G;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(100);
        }
        ValueAnimator valueAnimator3 = this.G;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    public final String g(double d11) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d11);
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        float f11 = this.F;
        float f12 = ((float) this.f24739i) - f11;
        float f13 = f11;
        float f14 = f12;
        float f15 = f12;
        canvas.drawArc(f11, f13, f14, f15, 180.0f, 180.0f, false, this.f24741k);
        canvas.drawArc(f11, f13, f14, f15, 180.0f, this.K * this.J * ((float) 180), false, this.f24743m);
        float measureText = this.f24745o.measureText(this.f24751u);
        float f16 = (float) 2;
        canvas.drawText(this.f24751u, (((float) this.f24739i) - measureText) / f16, (((float) this.f24740j) * 4.0f) / 9.0f, this.f24745o);
        float f17 = (float) 10;
        this.L[0] = Float.valueOf(((((float) this.f24739i) - measureText) / f16) - f17);
        this.L[1] = Float.valueOf(((((float) this.f24739i) - measureText) / f16) + measureText + f17);
        Float[] fArr = this.L;
        Float valueOf = Float.valueOf(10.0f);
        fArr[2] = Float.valueOf(((((float) this.f24740j) * 4.0f) / 9.0f) - ((float) c.d(valueOf)));
        this.L[3] = Float.valueOf(((((float) this.f24740j) * 4.0f) / 9.0f) + ((float) c.f(Float.valueOf(12.0f))) + ((float) c.d(valueOf)));
        Float valueOf2 = Float.valueOf(3.0f);
        float f18 = (float) c.f(valueOf2);
        canvas.drawLine((((float) this.f24739i) - measureText) / f16, f18 + ((((float) this.f24740j) * 4.0f) / 9.0f), ((((float) this.f24739i) - measureText) / f16) + measureText, ((((float) this.f24740j) * 4.0f) / 9.0f) + ((float) c.f(valueOf2)), this.f24749s);
        Paint.FontMetrics fontMetrics = this.f24746p.getFontMetrics();
        canvas.drawText(this.f24754x, (((float) this.f24739i) - this.f24746p.measureText(this.f24754x)) / f16, (((float) this.f24740j) * 3.0f) / 4.0f, this.f24746p);
        float measureText2 = this.f24748r.measureText(this.A);
        float d11 = ((((((float) this.f24740j) * 3.0f) / 4.0f) + fontMetrics.bottom) - fontMetrics.leading) + ((float) c.d(valueOf));
        Float valueOf3 = Float.valueOf(19.0f);
        canvas.drawRoundRect(new RectF(((float) (this.f24739i / 2)) - c.e(valueOf3), d11 - c.e(valueOf), ((float) (this.f24739i / 2)) + c.e(valueOf3), (fontMetrics.bottom + d11) - fontMetrics.leading), 50.0f, 50.0f, this.f24747q);
        canvas.drawText(this.A, (((float) this.f24739i) - measureText2) / f16, d11 + c.e(Float.valueOf(3.5f)), this.f24748r);
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(this.f24732b, this.f24733c);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(this.f24732b, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, this.f24733c);
        } else {
            super.onMeasure(i11, i12);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f24739i = i11;
        this.f24740j = i12;
        b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        float f11 = 0.0f;
        float x11 = motionEvent != null ? motionEvent.getX() : 0.0f;
        if (motionEvent != null) {
            f11 = motionEvent.getY();
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 1 && this.L[0].floatValue() <= x11 && this.L[1].floatValue() >= x11 && this.L[2].floatValue() <= f11 && this.L[3].floatValue() >= f11 && (gVar = this.M) != null) {
            gVar.a(6);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnTextClickListener(g gVar) {
        this.M = gVar;
    }

    public SemicircleProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int d11 = c.d(Float.valueOf(237.0f));
        this.f24732b = d11;
        int d12 = c.d(Float.valueOf(121.0f));
        this.f24733c = d12;
        this.f24734d = 100.0d;
        this.f24735e = -7829368;
        this.f24736f = -65536;
        this.f24737g = RoundedDrawable.DEFAULT_BORDER_COLOR;
        float e11 = c.e(Float.valueOf(15.0f));
        this.f24738h = e11;
        this.f24739i = d11;
        this.f24740j = d12;
        this.f24741k = new Paint(1);
        this.f24742l = -7829368;
        this.f24743m = new Paint(1);
        this.f24744n = -65536;
        this.f24745o = new Paint(1);
        this.f24746p = new Paint(1);
        this.f24747q = new Paint(1);
        this.f24748r = new Paint(1);
        this.f24749s = new Paint();
        Float valueOf = Float.valueOf(3.0f);
        this.f24750t = new DashPathEffect(new float[]{c.e(valueOf), c.e(valueOf)}, 0.0f);
        String str = "";
        this.f24751u = str;
        this.f24752v = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f24753w = e11;
        this.f24754x = str;
        this.f24755y = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f24756z = e11;
        this.A = str;
        this.B = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.C = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.D = e11;
        Float valueOf2 = Float.valueOf(12.0f);
        float e12 = c.e(valueOf2);
        this.E = e12;
        this.F = e12 / ((float) 2);
        this.H = 100.0d;
        Float[] fArr = new Float[4];
        for (int i12 = 0; i12 < 4; i12++) {
            fArr[i12] = Float.valueOf(0.0f);
        }
        this.L = fArr;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SemicircleProgressView);
        this.f24742l = obtainStyledAttributes.getColor(R$styleable.SemicircleProgressView_semicircle_pv_bg_color, this.f24735e);
        this.f24744n = obtainStyledAttributes.getColor(R$styleable.SemicircleProgressView_semicircle_pv_color, this.f24736f);
        this.B = obtainStyledAttributes.getColor(R$styleable.SemicircleProgressView_semicircle_pv_rate_bg_color, this.f24737g);
        this.C = obtainStyledAttributes.getColor(R$styleable.SemicircleProgressView_semicircle_pv_rate_text_color, this.f24737g);
        this.D = obtainStyledAttributes.getDimension(R$styleable.SemicircleProgressView_semicircle_pv_rate_text_size, this.f24738h);
        this.f24755y = obtainStyledAttributes.getColor(R$styleable.SemicircleProgressView_semicircle_pv_score_text_color, this.f24737g);
        this.f24756z = obtainStyledAttributes.getDimension(R$styleable.SemicircleProgressView_semicircle_pv_score_text_size, this.f24738h);
        String string = obtainStyledAttributes.getString(R$styleable.SemicircleProgressView_semicircle_pv_title_text);
        this.f24751u = string != null ? string : str;
        this.f24752v = obtainStyledAttributes.getColor(R$styleable.SemicircleProgressView_semicircle_pv_title_text_color, this.f24737g);
        this.f24753w = obtainStyledAttributes.getDimension(R$styleable.SemicircleProgressView_semicircle_pv_title_text_size, this.f24738h);
        this.E = obtainStyledAttributes.getDimension(R$styleable.SemicircleProgressView_semicircle_pv_width, c.e(valueOf2));
        this.f24749s.setColor(obtainStyledAttributes.getColor(com.hbg.lib.widgets.R$styleable.SemicircleProgressView_semicircle_pv_dash_color, Color.rgb(230, 231, 232)));
        obtainStyledAttributes.recycle();
        c();
    }
}
