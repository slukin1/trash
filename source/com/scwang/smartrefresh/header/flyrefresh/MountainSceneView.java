package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.huobi.view.roundimg.RoundedDrawable;
import com.scwang.smartrefresh.header.R$styleable;
import fy.a;

public class MountainSceneView extends View {
    public int A = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f29628b = Color.parseColor("#7ECEC9");

    /* renamed from: c  reason: collision with root package name */
    public int f29629c = Color.parseColor("#86DAD7");

    /* renamed from: d  reason: collision with root package name */
    public int f29630d = Color.parseColor("#3C929C");

    /* renamed from: e  reason: collision with root package name */
    public int f29631e = Color.parseColor("#3E5F73");

    /* renamed from: f  reason: collision with root package name */
    public int f29632f = Color.parseColor("#1F7177");

    /* renamed from: g  reason: collision with root package name */
    public int f29633g = Color.parseColor("#0C3E48");

    /* renamed from: h  reason: collision with root package name */
    public int f29634h = Color.parseColor("#34888F");

    /* renamed from: i  reason: collision with root package name */
    public int f29635i = Color.parseColor("#1B6169");

    /* renamed from: j  reason: collision with root package name */
    public int f29636j = Color.parseColor("#57B1AE");

    /* renamed from: k  reason: collision with root package name */
    public int f29637k = Color.parseColor("#62A4AD");

    /* renamed from: l  reason: collision with root package name */
    public Paint f29638l = new Paint();

    /* renamed from: m  reason: collision with root package name */
    public Paint f29639m = new Paint();

    /* renamed from: n  reason: collision with root package name */
    public Paint f29640n = new Paint();

    /* renamed from: o  reason: collision with root package name */
    public Paint f29641o = new Paint();

    /* renamed from: p  reason: collision with root package name */
    public Path f29642p = new Path();

    /* renamed from: q  reason: collision with root package name */
    public Path f29643q = new Path();

    /* renamed from: r  reason: collision with root package name */
    public Path f29644r = new Path();

    /* renamed from: s  reason: collision with root package name */
    public Path f29645s = new Path();

    /* renamed from: t  reason: collision with root package name */
    public Path f29646t = new Path();

    /* renamed from: u  reason: collision with root package name */
    public Matrix f29647u = new Matrix();

    /* renamed from: v  reason: collision with root package name */
    public float f29648v = 5.0f;

    /* renamed from: w  reason: collision with root package name */
    public float f29649w = 5.0f;

    /* renamed from: x  reason: collision with root package name */
    public float f29650x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    public float f29651y = 1.0f;

    /* renamed from: z  reason: collision with root package name */
    public float f29652z = Float.MAX_VALUE;

    public MountainSceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public final void a(Canvas canvas, float f11, float f12, float f13, int i11, int i12) {
        canvas.save();
        canvas.translate(f12 - ((100.0f * f11) / 2.0f), f13 - (200.0f * f11));
        canvas.scale(f11, f11);
        this.f29640n.setColor(i12);
        canvas.drawPath(this.f29646t, this.f29640n);
        this.f29639m.setColor(i11);
        canvas.drawPath(this.f29645s, this.f29639m);
        this.f29641o.setColor(i11);
        canvas.drawPath(this.f29646t, this.f29641o);
        canvas.restore();
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.f29638l.setAntiAlias(true);
        this.f29638l.setStyle(Paint.Style.FILL);
        this.f29639m.setAntiAlias(true);
        this.f29640n.setAntiAlias(true);
        this.f29641o.setAntiAlias(true);
        this.f29641o.setStyle(Paint.Style.STROKE);
        this.f29641o.setStrokeWidth(2.0f);
        this.f29641o.setStrokeJoin(Paint.Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MountainSceneView);
        int i11 = R$styleable.MountainSceneView_msvPrimaryColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            setPrimaryColor(obtainStyledAttributes.getColor(i11, RoundedDrawable.DEFAULT_BORDER_COLOR));
        }
        this.A = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MountainSceneView_msvViewportHeight, 0);
        obtainStyledAttributes.recycle();
        c(this.f29650x, 180);
        e(this.f29650x, true);
    }

    public final void c(float f11, int i11) {
        this.f29647u.reset();
        this.f29647u.setScale(this.f29648v, this.f29649w);
        float f12 = 10.0f * f11;
        this.f29642p.reset();
        this.f29642p.moveTo(0.0f, 95.0f + f12);
        this.f29642p.lineTo(55.0f, 74.0f + f12);
        this.f29642p.lineTo(146.0f, f12 + 104.0f);
        this.f29642p.lineTo(227.0f, 72.0f + f12);
        this.f29642p.lineTo(240.0f, f12 + 80.0f);
        this.f29642p.lineTo(240.0f, 180.0f);
        this.f29642p.lineTo(0.0f, 180.0f);
        this.f29642p.close();
        this.f29642p.transform(this.f29647u);
        float f13 = 20.0f * f11;
        this.f29643q.reset();
        this.f29643q.moveTo(0.0f, 103.0f + f13);
        this.f29643q.lineTo(67.0f, 90.0f + f13);
        this.f29643q.lineTo(165.0f, 115.0f + f13);
        this.f29643q.lineTo(221.0f, 87.0f + f13);
        this.f29643q.lineTo(240.0f, f13 + 100.0f);
        this.f29643q.lineTo(240.0f, 180.0f);
        this.f29643q.lineTo(0.0f, 180.0f);
        this.f29643q.close();
        this.f29643q.transform(this.f29647u);
        float f14 = f11 * 30.0f;
        this.f29644r.reset();
        this.f29644r.moveTo(0.0f, 114.0f + f14);
        this.f29644r.cubicTo(30.0f, f14 + 106.0f, 196.0f, f14 + 97.0f, 240.0f, f14 + 104.0f);
        float f15 = (float) i11;
        this.f29644r.lineTo(240.0f, f15 / this.f29649w);
        this.f29644r.lineTo(0.0f, f15 / this.f29649w);
        this.f29644r.close();
        this.f29644r.transform(this.f29647u);
    }

    public void d(float f11) {
        this.f29651y = f11;
        float max = Math.max(0.0f, f11);
        this.f29650x = Math.max(0.0f, this.f29651y);
        int measuredHeight = getMeasuredHeight();
        float f12 = this.f29650x;
        if (measuredHeight <= 0) {
            measuredHeight = 180;
        }
        c(f12, measuredHeight);
        e(max, false);
    }

    public final void e(float f11, boolean z11) {
        int i11;
        if (f11 != this.f29652z || z11) {
            Interpolator a11 = a.a(0.8f, -0.5f * f11);
            float f12 = f11 * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i12 = 0;
            float f13 = 0.0f;
            float f14 = 200.0f;
            while (true) {
                if (i12 > 25) {
                    break;
                }
                fArr[i12] = (a11.getInterpolation(f13) * f12) + 50.0f;
                fArr2[i12] = f14;
                f14 -= 0.5f;
                f13 += 0.04f;
                i12++;
            }
            this.f29645s.reset();
            this.f29645s.moveTo(45.0f, 200.0f);
            int i13 = (int) (((float) 17) * 0.5f);
            float f15 = (float) (17 - i13);
            for (int i14 = 0; i14 < 17; i14++) {
                if (i14 < i13) {
                    this.f29645s.lineTo(fArr[i14] - 5.0f, fArr2[i14]);
                } else {
                    this.f29645s.lineTo(fArr[i14] - ((((float) (17 - i14)) * 5.0f) / f15), fArr2[i14]);
                }
            }
            for (int i15 = 16; i15 >= 0; i15--) {
                if (i15 < i13) {
                    this.f29645s.lineTo(fArr[i15] + 5.0f, fArr2[i15]);
                } else {
                    this.f29645s.lineTo(fArr[i15] + ((((float) (17 - i15)) * 5.0f) / f15), fArr2[i15]);
                }
            }
            this.f29645s.close();
            this.f29646t.reset();
            float f16 = (float) 15;
            this.f29646t.moveTo(fArr[10] - 20.0f, fArr2[10]);
            this.f29646t.addArc(new RectF(fArr[10] - 20.0f, fArr2[10] - 20.0f, fArr[10] + 20.0f, fArr2[10] + 20.0f), 0.0f, 180.0f);
            for (int i16 = 10; i16 <= 25; i16++) {
                float f17 = ((float) (i16 - 10)) / f16;
                this.f29646t.lineTo((fArr[i16] - 20.0f) + (f17 * f17 * 20.0f), fArr2[i16]);
            }
            for (i11 = 25; i11 >= 10; i11--) {
                float f18 = ((float) (i11 - 10)) / f16;
                this.f29646t.lineTo((fArr[i11] + 20.0f) - ((f18 * f18) * 20.0f), fArr2[i11]);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f29628b);
        this.f29638l.setColor(this.f29629c);
        canvas.drawPath(this.f29642p, this.f29638l);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, (float) (getWidth() / 2), 0.0f);
        float f11 = this.f29648v;
        a(canvas, f11 * 0.12f, f11 * 180.0f, ((this.f29650x * 20.0f) + 93.0f) * this.f29649w, this.f29637k, this.f29636j);
        float f12 = this.f29648v;
        a(canvas, f12 * 0.1f, f12 * 200.0f, ((this.f29650x * 20.0f) + 96.0f) * this.f29649w, this.f29637k, this.f29636j);
        canvas.restore();
        this.f29638l.setColor(this.f29630d);
        canvas.drawPath(this.f29643q, this.f29638l);
        float f13 = this.f29648v;
        a(canvas, f13 * 0.2f, f13 * 160.0f, ((this.f29650x * 30.0f) + 105.0f) * this.f29649w, this.f29633g, this.f29632f);
        float f14 = this.f29648v;
        a(canvas, f14 * 0.14f, f14 * 180.0f, ((this.f29650x * 30.0f) + 105.0f) * this.f29649w, this.f29635i, this.f29634h);
        float f15 = this.f29648v;
        a(canvas, f15 * 0.16f, f15 * 140.0f, ((this.f29650x * 30.0f) + 105.0f) * this.f29649w, this.f29635i, this.f29634h);
        this.f29638l.setColor(this.f29631e);
        canvas.drawPath(this.f29644r, this.f29638l);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f29648v = (((float) measuredWidth) * 1.0f) / 240.0f;
        int i13 = this.A;
        if (i13 <= 0) {
            i13 = measuredHeight;
        }
        this.f29649w = (((float) i13) * 1.0f) / 180.0f;
        c(this.f29650x, measuredHeight);
        e(this.f29650x, true);
    }

    public void setPrimaryColor(int i11) {
        this.f29628b = i11;
        this.f29629c = iy.a.b(-1711276033, i11);
        this.f29630d = iy.a.b(-1724083556, i11);
        this.f29631e = iy.a.b(-868327565, i11);
        this.f29632f = iy.a.b(1428124023, i11);
        this.f29633g = iy.a.b(-871612856, i11);
        this.f29634h = iy.a.b(1429506191, i11);
        this.f29635i = iy.a.b(-870620823, i11);
        this.f29636j = iy.a.b(1431810478, i11);
        this.f29637k = iy.a.b(-865950547, i11);
    }

    public MountainSceneView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context, attributeSet);
    }
}
