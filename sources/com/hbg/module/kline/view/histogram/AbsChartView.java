package com.hbg.module.kline.view.histogram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.hbg.module.kline.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import ge.b;
import ge.c;
import ge.d;
import ge.e;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsChartView extends View {
    public float A;
    public int B;
    public int C;
    public float D;
    public int E;
    public float F;
    public float G;
    public float H;
    public int I;
    public float J;
    public Drawable K;
    public Drawable L;
    public VelocityTracker M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;

    /* renamed from: b  reason: collision with root package name */
    public d f24401b;

    /* renamed from: c  reason: collision with root package name */
    public c f24402c;

    /* renamed from: d  reason: collision with root package name */
    public e f24403d;

    /* renamed from: e  reason: collision with root package name */
    public b f24404e;

    /* renamed from: f  reason: collision with root package name */
    public List<ge.a> f24405f;

    /* renamed from: g  reason: collision with root package name */
    public a f24406g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f24407h;

    /* renamed from: i  reason: collision with root package name */
    public float f24408i;

    /* renamed from: j  reason: collision with root package name */
    public float f24409j;

    /* renamed from: k  reason: collision with root package name */
    public float f24410k;

    /* renamed from: l  reason: collision with root package name */
    public float f24411l;

    /* renamed from: m  reason: collision with root package name */
    public float f24412m;

    /* renamed from: n  reason: collision with root package name */
    public float f24413n;

    /* renamed from: o  reason: collision with root package name */
    public float f24414o;

    /* renamed from: p  reason: collision with root package name */
    public int f24415p;

    /* renamed from: q  reason: collision with root package name */
    public float f24416q;

    /* renamed from: r  reason: collision with root package name */
    public float f24417r;

    /* renamed from: s  reason: collision with root package name */
    public float f24418s;

    /* renamed from: t  reason: collision with root package name */
    public int f24419t;

    /* renamed from: u  reason: collision with root package name */
    public int f24420u;

    /* renamed from: v  reason: collision with root package name */
    public float f24421v;

    /* renamed from: w  reason: collision with root package name */
    public float f24422w;

    /* renamed from: x  reason: collision with root package name */
    public int f24423x;

    /* renamed from: y  reason: collision with root package name */
    public int f24424y;

    /* renamed from: z  reason: collision with root package name */
    public int f24425z;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Paint f24426a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f24427b;

        /* renamed from: c  reason: collision with root package name */
        public Paint f24428c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f24429d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f24430e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f24431f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f24432g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f24433h;

        public a() {
            Paint m11 = AbsChartView.this.m(AbsChartView.this.C);
            this.f24432g = m11;
            m11.setStyle(Paint.Style.STROKE);
            this.f24432g.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f, 4.0f, 4.0f}, 2.0f));
            Paint m12 = AbsChartView.this.m(AbsChartView.this.f24415p);
            this.f24426a = m12;
            m12.setStrokeWidth(AbsChartView.this.f24416q);
            Paint m13 = AbsChartView.this.m(AbsChartView.this.f24420u);
            this.f24427b = m13;
            m13.setTextSize(AbsChartView.this.f24421v);
            Paint m14 = AbsChartView.this.m(AbsChartView.this.f24419t);
            this.f24428c = m14;
            m14.setTextSize(AbsChartView.this.f24422w);
            Paint m15 = AbsChartView.this.m(AbsChartView.this.f24425z);
            this.f24429d = m15;
            m15.setStrokeWidth(2.0f);
            Paint m16 = AbsChartView.this.m(AbsChartView.this.f24423x);
            this.f24430e = m16;
            m16.setTextSize(AbsChartView.this.A);
            this.f24431f = AbsChartView.this.m(AbsChartView.this.f24424y);
            Paint m17 = AbsChartView.this.m(AbsChartView.this.I);
            this.f24433h = m17;
            m17.setStrokeWidth(AbsChartView.this.H);
            this.f24433h.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f, 8.0f, 8.0f}, 2.0f));
        }
    }

    public AbsChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float getYMaxTextHeight() {
        String y11 = y(getMinValue());
        this.f24406g.f24428c.getTextBounds(y11, 0, y11.length(), this.f24407h);
        return (float) this.f24407h.height();
    }

    private float getYMaxTextLength() {
        String y11 = y(getMaxValue());
        String y12 = y(getMinValue());
        this.f24406g.f24428c.getTextBounds(y11, 0, y11.length(), this.f24407h);
        float width = (float) this.f24407h.width();
        this.f24406g.f24428c.getTextBounds(y12, 0, y12.length(), this.f24407h);
        float width2 = (float) this.f24407h.width();
        return width > width2 ? width : width2;
    }

    public static float n(Context context, float f11) {
        return f11 * context.getResources().getDisplayMetrics().density;
    }

    public final void A() {
        float f11 = 2.14748365E9f;
        float f12 = -2.14748365E9f;
        for (ge.a aVar : this.f24405f) {
            float f13 = aVar.f25271b;
            if (f13 > f12) {
                f12 = f13;
            }
            if (f13 < f11) {
                f11 = f13;
            }
        }
        this.f24408i = f12;
        this.f24409j = f11;
    }

    public final void B(Context context) {
        float n11 = n(context, 10.0f);
        float n12 = n(context, 10.0f);
        float n13 = n(context, 4.0f);
        this.f24421v = n11;
        this.f24422w = n11;
        this.A = n11;
        this.f24417r = n13;
        this.f24418s = n13;
        this.f24414o = n12;
        this.F = n12;
    }

    public boolean C(int i11, int i12) {
        return true;
    }

    public final void D(Canvas canvas) {
        canvas.save();
        float yMaxTextHeight = getYMaxTextHeight();
        float yMaxTextLength = getYMaxTextLength();
        this.f24410k = 0.0f;
        this.f24406g.f24427b.getTextBounds("0", 0, "0".length(), this.f24407h);
        this.f24411l = ((float) this.f24407h.height()) + this.f24417r + this.f24414o;
        this.f24406g.f24430e.getTextBounds("0", 0, 1, this.f24407h);
        this.D = (float) (this.f24407h.height() * 3);
        canvas.translate(this.f24410k, this.f24412m - this.f24411l);
        if (this.Q) {
            canvas.drawLine(0.0f, -k(), 0.0f, 0.0f, this.f24406g.f24426a);
            canvas.drawLine(0.0f, 0.0f, l(), 0.0f, this.f24406g.f24426a);
        }
        F(canvas, Math.abs(k() / ((float) (this.B + 1))), yMaxTextHeight, yMaxTextLength);
        canvas.restore();
    }

    public abstract void E(Canvas canvas);

    public void F(Canvas canvas, float f11, float f12, float f13) {
        int i11 = 0;
        while (true) {
            int i12 = this.B;
            if (i11 <= i12 + 1) {
                if (C(i11, i12 + 1)) {
                    float f14 = ((float) (-i11)) * f11;
                    canvas.drawLine(0.0f, f14, l(), f14, this.f24406g.f24432g);
                    J(canvas, i11, -this.f24410k, f14 + (f12 / 2.0f), f13);
                }
                i11++;
            } else {
                float f15 = -getZeroLine();
                canvas.drawLine(0.0f, f15, l(), f15, this.f24406g.f24433h);
                return;
            }
        }
    }

    public final void G(Canvas canvas, int i11) {
        float f11;
        float f12;
        float f13;
        Canvas canvas2 = canvas;
        int i12 = i11;
        if (i12 >= 0 && i12 < getCount()) {
            canvas.save();
            canvas2.translate(this.f24410k, this.f24412m - this.f24411l);
            float cellWidth = (((float) i12) + this.J) * getCellWidth();
            canvas.drawLine(cellWidth, 0.0f, cellWidth, -k(), this.f24406g.f24429d);
            ge.a aVar = this.f24405f.get(i12);
            String v11 = v(i12, aVar.f25270a, aVar.f25271b);
            this.f24406g.f24430e.getTextBounds(v11, 0, v11.length(), this.f24407h);
            float width = ((float) this.f24407h.width()) + (this.F * 2.0f);
            float f14 = width / 2.0f;
            float f15 = cellWidth - f14;
            float f16 = f14 + cellWidth;
            float f17 = (float) (-(((double) k()) + (((double) this.f24407h.height()) * 2.5d)));
            float f18 = (float) (-(((double) k()) + (((double) this.f24407h.height()) * 0.5d)));
            if (f15 < 0.0f) {
                f12 = width + 0.0f;
                f11 = 0.0f;
            } else {
                if (f16 > l()) {
                    f16 = l();
                    f15 = f16 - width;
                }
                f12 = f16;
                f11 = f15;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                float f19 = this.G;
                f13 = f18;
                canvas.drawRoundRect(f11, f17, f12, f18, f19, f19, this.f24406g.f24431f);
            } else {
                f13 = f18;
                canvas.drawRect(f11, f17, f12, f13, this.f24406g.f24431f);
            }
            Path path = new Path();
            path.moveTo(cellWidth, -k());
            double d11 = (double) cellWidth;
            float height = (float) (d11 - (((double) this.f24407h.height()) * 0.5d));
            if (height < 0.0f) {
                height = 0.0f;
            }
            float height2 = (float) (d11 + (((double) this.f24407h.height()) * 0.5d));
            if (height2 > l()) {
                height2 = l();
            }
            float f21 = f13 - 5.0f;
            path.lineTo(height, f21);
            path.lineTo(height2, f21);
            canvas2.drawPath(path, this.f24406g.f24431f);
            canvas2.drawText(v11, ((f11 + f12) - ((float) this.f24407h.width())) / 2.0f, ((f17 + f13) + ((float) this.f24407h.height())) / 2.0f, this.f24406g.f24430e);
            canvas.restore();
        }
    }

    public void H(Canvas canvas) {
        int i11;
        if (this.K != null || this.L != null || (i11 = this.E) >= 0 || i11 < getCount()) {
            canvas.save();
            canvas.translate(this.f24410k, this.f24412m - this.f24411l);
            float L2 = L(this.E);
            float q11 = q(this.E);
            Drawable u11 = u(this.E);
            if (u11 != null) {
                float intrinsicWidth = ((float) u11.getIntrinsicWidth()) / 2.0f;
                float f11 = -q11;
                u11.setBounds((int) (L2 - intrinsicWidth), (int) (f11 - intrinsicWidth), (int) (L2 + intrinsicWidth), (int) (f11 + intrinsicWidth));
                u11.draw(canvas);
            }
            canvas.restore();
        }
    }

    public void I(Canvas canvas) {
        int count = getCount();
        if (count > 0) {
            canvas.save();
            canvas.translate(this.f24410k, this.f24412m - this.f24411l);
            float l11 = l() / ((float) count);
            float l12 = l();
            for (int i11 = 0; i11 < count; i11++) {
                String w11 = w(this.f24405f.get(i11).f25270a, i11);
                this.f24406g.f24427b.getTextBounds(w11, 0, w11.length(), this.f24407h);
                float width = ((((float) i11) + this.J) * l11) - ((float) (this.f24407h.width() / 2));
                if (((float) this.f24407h.width()) + width > l12) {
                    width = l12 - ((float) this.f24407h.width());
                }
                if (width < 0.0f) {
                    width = 0.0f;
                }
                canvas.drawText(w11, width, this.f24417r + ((float) this.f24407h.height()), this.f24406g.f24427b);
            }
            canvas.restore();
        }
    }

    public void J(Canvas canvas, int i11, float f11, float f12, float f13) {
        String x11 = x(i11);
        this.f24406g.f24428c.getTextBounds(x11, 0, x11.length(), this.f24407h);
        canvas.drawText(x11, f11 + this.f24414o + (f13 - ((float) this.f24407h.width())), f12, this.f24406g.f24428c);
    }

    public final void K() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public float L(int i11) {
        return getCellWidth() * (((float) i11) + this.J);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (r0 != 3) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.VelocityTracker r0 = r5.M
            r0.addMovement(r6)
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x0055
            r2 = 0
            if (r0 == r1) goto L_0x0048
            r3 = 2
            if (r0 == r3) goto L_0x0016
            r1 = 3
            if (r0 == r1) goto L_0x0048
            goto L_0x005c
        L_0x0016:
            android.view.VelocityTracker r0 = r5.M
            r3 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r3)
            android.view.VelocityTracker r0 = r5.M
            float r0 = r0.getXVelocity()
            float r0 = java.lang.Math.abs(r0)
            android.view.VelocityTracker r3 = r5.M
            float r3 = r3.getYVelocity()
            float r3 = java.lang.Math.abs(r3)
            r4 = 1077936128(0x40400000, float:3.0)
            float r0 = r0 * r4
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0040
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x005c
        L_0x0040:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L_0x005c
        L_0x0048:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            android.view.VelocityTracker r0 = r5.M
            r0.clear()
            goto L_0x005c
        L_0x0055:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x005c:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.view.histogram.AbsChartView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean getAllowDrawSelectedTap() {
        return this.P;
    }

    public float getCellWidth() {
        float l11;
        float count;
        if (getCount() == 0) {
            return l();
        }
        if (Float.compare(this.J, 0.0f) != 0 || getCount() == 1) {
            l11 = l();
            count = (float) getCount();
        } else {
            l11 = l();
            count = (float) (getCount() - 1);
        }
        return l11 / count;
    }

    public int getCount() {
        List<ge.a> list = this.f24405f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getCurrentSelectIndex() {
        return this.E;
    }

    public float getMaxCellHeight() {
        float f11 = -2.14748365E9f;
        int i11 = -1;
        for (int i12 = 0; i12 < getCount(); i12++) {
            float f12 = t(i12).f25271b;
            if (f11 < f12) {
                i11 = i12;
                f11 = f12;
            }
        }
        return r(i11) * k();
    }

    public float getMaxValue() {
        c cVar = this.f24402c;
        if (cVar == null) {
            return this.f24408i;
        }
        return cVar.b(this.f24408i, this.f24409j);
    }

    public float getMinValue() {
        c cVar = this.f24402c;
        if (cVar == null) {
            return this.f24409j;
        }
        return cVar.a(this.f24408i, this.f24409j);
    }

    public float getZeroLine() {
        float maxValue = getMaxValue() - getMinValue();
        if (Float.compare(maxValue, 0.0f) == 0) {
            return k() * 0.5f;
        }
        if (getMinValue() > 0.0f) {
            return 0.0f;
        }
        return (k() * Math.abs(getMinValue())) / maxValue;
    }

    public float k() {
        return (this.f24412m - this.f24411l) - this.D;
    }

    public float l() {
        return (this.f24413n - this.f24410k) - this.f24414o;
    }

    public Paint m(int i11) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i11);
        return paint;
    }

    public final void o() {
        e eVar = this.f24403d;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        D(canvas);
        if (this.N) {
            G(canvas, this.E);
        }
        E(canvas);
        I(canvas);
        if (this.O) {
            H(canvas);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f24412m = (float) getHeight();
        this.f24413n = (float) getWidth();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int s11;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.E = s(motionEvent.getX());
            invalidate();
            p(this.E);
        } else if (action == 1) {
            invalidate();
            o();
        } else if (action == 2 && (s11 = s(motionEvent.getX())) != this.E) {
            this.E = s11;
            invalidate();
            p(this.E);
        }
        return true;
    }

    public final void p(int i11) {
        e eVar;
        if (i11 >= 0 && i11 < getCount() && (eVar = this.f24403d) != null) {
            eVar.b(i11, this.f24405f.get(i11).f25271b);
        }
    }

    public float q(int i11) {
        return r(i11) * k();
    }

    public float r(int i11) {
        float minValue = getMinValue();
        float abs = Math.abs(getMaxValue() - minValue);
        if (Float.compare(abs, 0.0f) == 0) {
            return 0.5f;
        }
        if (i11 < 0 || i11 >= this.f24405f.size()) {
            return 0.0f;
        }
        return Math.abs(this.f24405f.get(i11).f25271b - minValue) / abs;
    }

    public final int s(float f11) {
        float f12 = this.f24410k;
        if (f11 < f12 || f11 > f12 + l()) {
            return this.E;
        }
        return (int) Math.floor((double) (((float) Math.abs(((double) (f11 - this.f24410k)) + ((0.5d - ((double) this.J)) * ((double) getCellWidth())))) / getCellWidth()));
    }

    public void setAllowDrawDownImageTap(boolean z11) {
        this.O = z11;
    }

    public void setAllowDrawLineTap(boolean z11) {
        this.N = z11;
    }

    public void setAllowDrawSelectedTap(boolean z11) {
        this.P = z11;
    }

    public void setAllowDrawXY(boolean z11) {
        this.Q = z11;
    }

    public void setData(List<ge.a> list) {
        this.f24405f = list;
        A();
        K();
    }

    public void setDefaultSelected(int i11) {
        this.E = i11;
        K();
    }

    public void setFormatAxis(b bVar) {
        this.f24404e = bVar;
    }

    public void setMaxMin(c cVar) {
        this.f24402c = cVar;
    }

    public void setOffset(float f11) {
        this.J = f11;
    }

    public void setOnTapListener(e eVar) {
        this.f24403d = eVar;
    }

    public void setTapDrawable(Drawable drawable) {
        this.K = drawable;
        K();
    }

    public void setTipsShow(d dVar) {
        this.f24401b = dVar;
    }

    public ge.a t(int i11) {
        if (i11 < 0 || i11 >= getCount()) {
            return null;
        }
        return this.f24405f.get(i11);
    }

    public final Drawable u(int i11) {
        ge.a t11 = t(i11);
        if (this.L == null) {
            this.L = this.K;
        }
        if (this.K == null) {
            this.K = this.L;
        }
        if (t11 == null) {
            return this.K;
        }
        if (t11.f25271b < 0.0f) {
            return this.L;
        }
        return this.K;
    }

    public String v(int i11, String str, float f11) {
        d dVar = this.f24401b;
        if (dVar != null) {
            return dVar.a(i11, str, f11);
        }
        return String.valueOf(f11);
    }

    public String w(String str, int i11) {
        b bVar = this.f24404e;
        if (bVar == null) {
            return str;
        }
        return bVar.a(str, i11);
    }

    public String x(int i11) {
        float minValue = getMinValue();
        return y(minValue + (((getMaxValue() - minValue) / ((float) (this.B + 1))) * ((float) i11)));
    }

    public String y(float f11) {
        b bVar = this.f24404e;
        if (bVar == null) {
            return String.valueOf(f11);
        }
        return bVar.b(f11);
    }

    public final void z(Context context, AttributeSet attributeSet, int i11, int i12) {
        B(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AbsChartView, i11, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        float n11 = n(context, 10.0f);
        float n12 = n(context, 10.0f);
        float n13 = n(context, 4.0f);
        for (int i13 = 0; i13 < indexCount; i13++) {
            int index = obtainStyledAttributes.getIndex(i13);
            if (index == R$styleable.AbsChartView_x_color) {
                this.f24420u = obtainStyledAttributes.getColor(index, RoundedDrawable.DEFAULT_BORDER_COLOR);
            } else if (index == R$styleable.AbsChartView_x_size) {
                this.f24421v = obtainStyledAttributes.getDimension(index, n11);
            } else if (index == R$styleable.AbsChartView_y_color) {
                this.f24419t = obtainStyledAttributes.getColor(index, RoundedDrawable.DEFAULT_BORDER_COLOR);
            } else if (index == R$styleable.AbsChartView_y_size) {
                this.f24422w = obtainStyledAttributes.getDimension(index, n11);
            } else if (index == R$styleable.AbsChartView_x_space) {
                this.f24417r = obtainStyledAttributes.getDimension(index, n13);
            } else if (index == R$styleable.AbsChartView_y_space) {
                this.f24418s = obtainStyledAttributes.getDimension(index, n13);
            } else if (index == R$styleable.AbsChartView_line_color) {
                this.f24425z = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.AbsChartView_tips_color) {
                this.f24423x = obtainStyledAttributes.getColor(index, RoundedDrawable.DEFAULT_BORDER_COLOR);
            } else if (index == R$styleable.AbsChartView_tips_size) {
                this.A = obtainStyledAttributes.getDimension(index, n11);
            } else if (index == R$styleable.AbsChartView_tips_background) {
                this.f24424y = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.AbsChartView_y_horizontal_line_num) {
                this.B = obtainStyledAttributes.getInt(index, 5);
            } else if (index == R$styleable.AbsChartView_y_horizontal_line_color) {
                this.C = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.AbsChartView_axis_space) {
                this.f24414o = obtainStyledAttributes.getDimension(index, n12);
            } else if (index == R$styleable.AbsChartView_tips_padding) {
                this.F = obtainStyledAttributes.getDimension(index, n12);
            } else if (index == R$styleable.AbsChartView_tips_radio) {
                this.G = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.AbsChartView_axis_color) {
                this.f24415p = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.AbsChartView_axis_width) {
                this.f24416q = obtainStyledAttributes.getDimension(index, 0.7f);
            } else if (index == R$styleable.AbsChartView_zero_line_color) {
                this.I = obtainStyledAttributes.getColor(index, RoundedDrawable.DEFAULT_BORDER_COLOR);
            } else if (index == R$styleable.AbsChartView_zero_line_size) {
                this.H = obtainStyledAttributes.getDimension(index, 0.7f);
            } else if (index == R$styleable.AbsChartView_tap_up_bg) {
                this.K = obtainStyledAttributes.getDrawable(index);
            } else if (index == R$styleable.AbsChartView_tap_down_bg) {
                this.L = obtainStyledAttributes.getDrawable(index);
            }
        }
        obtainStyledAttributes.recycle();
        this.f24406g = new a();
        setLayerType(1, (Paint) null);
        this.M = VelocityTracker.obtain();
    }

    public AbsChartView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24405f = new ArrayList();
        this.f24407h = new Rect();
        this.f24415p = -7829368;
        this.f24416q = 0.7f;
        this.f24419t = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f24420u = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f24423x = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f24424y = -7829368;
        this.f24425z = -7829368;
        this.B = 5;
        this.C = -7829368;
        this.D = 0.0f;
        this.E = -1;
        this.G = 0.0f;
        this.I = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.J = 0.5f;
        z(context, attributeSet, i11, 0);
    }
}
