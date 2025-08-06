package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.huobi.view.chart.Chart;
import com.huobi.view.roundimg.RoundedDrawable;
import e5.d;
import g5.b;
import i5.g;
import i5.q;
import i5.t;

@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends b<? extends Entry>>> extends Chart<T> implements f5.b {
    public int H = 100;
    public boolean I = false;
    public boolean J = false;
    public boolean K = true;
    public boolean L = true;
    public boolean M = true;
    public boolean N = true;
    public boolean O = true;
    public boolean P = true;
    public Paint Q;
    public Paint R;
    public boolean S = false;
    public boolean T = false;
    public boolean U = false;
    public float V = 15.0f;
    public boolean W = false;

    /* renamed from: a0  reason: collision with root package name */
    public h5.b f65336a0;

    /* renamed from: b0  reason: collision with root package name */
    public YAxis f65337b0;

    /* renamed from: c0  reason: collision with root package name */
    public YAxis f65338c0;

    /* renamed from: d0  reason: collision with root package name */
    public t f65339d0;

    /* renamed from: e0  reason: collision with root package name */
    public t f65340e0;

    /* renamed from: f0  reason: collision with root package name */
    public k5.a f65341f0;

    /* renamed from: g0  reason: collision with root package name */
    public k5.a f65342g0;

    /* renamed from: h0  reason: collision with root package name */
    public q f65343h0;

    /* renamed from: i0  reason: collision with root package name */
    public long f65344i0 = 0;

    /* renamed from: j0  reason: collision with root package name */
    public long f65345j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    public RectF f65346k0 = new RectF();

    /* renamed from: l0  reason: collision with root package name */
    public Matrix f65347l0 = new Matrix();

    /* renamed from: m0  reason: collision with root package name */
    public Matrix f65348m0 = new Matrix();

    /* renamed from: n0  reason: collision with root package name */
    public boolean f65349n0 = false;

    /* renamed from: t0  reason: collision with root package name */
    public float[] f65350t0 = new float[2];

    /* renamed from: u0  reason: collision with root package name */
    public com.github.mikephil.charting.utils.a f65351u0 = com.github.mikephil.charting.utils.a.b(0.0d, 0.0d);

    /* renamed from: v0  reason: collision with root package name */
    public com.github.mikephil.charting.utils.a f65352v0 = com.github.mikephil.charting.utils.a.b(0.0d, 0.0d);

    /* renamed from: w0  reason: collision with root package name */
    public float[] f65353w0 = new float[2];

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65354a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f65355b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f65356c;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f65356c = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f65356c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f65355b = r2
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f65355b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = f65355b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f65354a = r2
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f65354a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.BarLineChartBase.a.<clinit>():void");
        }
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public YAxis A(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.f65337b0;
        }
        return this.f65338c0;
    }

    public b B(float f11, float f12) {
        d k11 = k(f11, f12);
        if (k11 != null) {
            return (b) ((BarLineScatterCandleBubbleData) this.f65358c).e(k11.d());
        }
        return null;
    }

    public boolean C() {
        return this.f65376u.t();
    }

    public boolean D() {
        if (!this.f65337b0.b0() && !this.f65338c0.b0()) {
            return false;
        }
        return true;
    }

    public boolean E() {
        return this.U;
    }

    public boolean F() {
        return this.K;
    }

    public boolean G() {
        return this.M || this.N;
    }

    public boolean H() {
        return this.M;
    }

    public boolean I() {
        return this.N;
    }

    public boolean J() {
        return this.f65376u.u();
    }

    public boolean K() {
        return this.L;
    }

    public boolean L() {
        return this.J;
    }

    public boolean M() {
        return this.O;
    }

    public boolean N() {
        return this.P;
    }

    public void O() {
        this.f65342g0.l(this.f65338c0.b0());
        this.f65341f0.l(this.f65337b0.b0());
    }

    public void P() {
        if (this.f65357b) {
            Log.i(Chart.LOG_TAG, "Preparing Value-Px Matrix, xmin: " + this.f65365j.G + ", xmax: " + this.f65365j.F + ", xdelta: " + this.f65365j.H);
        }
        k5.a aVar = this.f65342g0;
        XAxis xAxis = this.f65365j;
        float f11 = xAxis.G;
        float f12 = xAxis.H;
        YAxis yAxis = this.f65338c0;
        aVar.m(f11, f12, yAxis.H, yAxis.G);
        k5.a aVar2 = this.f65341f0;
        XAxis xAxis2 = this.f65365j;
        float f13 = xAxis2.G;
        float f14 = xAxis2.H;
        YAxis yAxis2 = this.f65337b0;
        aVar2.m(f13, f14, yAxis2.H, yAxis2.G);
    }

    public void Q(float f11, float f12, float f13, float f14) {
        this.f65376u.S(f11, f12, f13, -f14, this.f65347l0);
        this.f65376u.J(this.f65347l0, this, false);
        f();
        postInvalidate();
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f65370o;
        if (chartTouchListener instanceof com.github.mikephil.charting.listener.a) {
            ((com.github.mikephil.charting.listener.a) chartTouchListener).f();
        }
    }

    public k5.a d(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.f65341f0;
        }
        return this.f65342g0;
    }

    public boolean e(YAxis.AxisDependency axisDependency) {
        return A(axisDependency).b0();
    }

    public void f() {
        if (!this.f65349n0) {
            y(this.f65346k0);
            RectF rectF = this.f65346k0;
            float f11 = rectF.left + 0.0f;
            float f12 = rectF.top + 0.0f;
            float f13 = rectF.right + 0.0f;
            float f14 = rectF.bottom + 0.0f;
            if (this.f65337b0.c0()) {
                f11 += this.f65337b0.T(this.f65339d0.c());
            }
            if (this.f65338c0.c0()) {
                f13 += this.f65338c0.T(this.f65340e0.c());
            }
            if (this.f65365j.f() && this.f65365j.A()) {
                XAxis xAxis = this.f65365j;
                float e11 = ((float) xAxis.L) + xAxis.e();
                if (this.f65365j.P() == XAxis.XAxisPosition.BOTTOM) {
                    f14 += e11;
                } else {
                    if (this.f65365j.P() != XAxis.XAxisPosition.TOP) {
                        if (this.f65365j.P() == XAxis.XAxisPosition.BOTH_SIDED) {
                            f14 += e11;
                        }
                    }
                    f12 += e11;
                }
            }
            float extraTopOffset = f12 + getExtraTopOffset();
            float extraRightOffset = f13 + getExtraRightOffset();
            float extraBottomOffset = f14 + getExtraBottomOffset();
            float extraLeftOffset = f11 + getExtraLeftOffset();
            float e12 = Utils.e(this.V);
            this.f65376u.K(Math.max(e12, extraLeftOffset), Math.max(e12, extraTopOffset), Math.max(e12, extraRightOffset), Math.max(e12, extraBottomOffset));
            if (this.f65357b) {
                Log.i(Chart.LOG_TAG, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Content: ");
                sb2.append(this.f65376u.o().toString());
                Log.i(Chart.LOG_TAG, sb2.toString());
            }
        }
        O();
        P();
    }

    public YAxis getAxisLeft() {
        return this.f65337b0;
    }

    public YAxis getAxisRight() {
        return this.f65338c0;
    }

    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public h5.b getDrawListener() {
        return this.f65336a0;
    }

    public float getHighestVisibleX() {
        d(YAxis.AxisDependency.LEFT).h(this.f65376u.i(), this.f65376u.f(), this.f65352v0);
        return (float) Math.min((double) this.f65365j.F, this.f65352v0.f65588c);
    }

    public float getLowestVisibleX() {
        d(YAxis.AxisDependency.LEFT).h(this.f65376u.h(), this.f65376u.f(), this.f65351u0);
        return (float) Math.max((double) this.f65365j.G, this.f65351u0.f65588c);
    }

    public int getMaxVisibleCount() {
        return this.H;
    }

    public float getMinOffset() {
        return this.V;
    }

    public t getRendererLeftYAxis() {
        return this.f65339d0;
    }

    public t getRendererRightYAxis() {
        return this.f65340e0;
    }

    public q getRendererXAxis() {
        return this.f65343h0;
    }

    public float getScaleX() {
        ViewPortHandler viewPortHandler = this.f65376u;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.q();
    }

    public float getScaleY() {
        ViewPortHandler viewPortHandler = this.f65376u;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.r();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    public float getYChartMax() {
        return Math.max(this.f65337b0.F, this.f65338c0.F);
    }

    public float getYChartMin() {
        return Math.min(this.f65337b0.G, this.f65338c0.G);
    }

    public void n() {
        super.n();
        this.f65337b0 = new YAxis(YAxis.AxisDependency.LEFT);
        this.f65338c0 = new YAxis(YAxis.AxisDependency.RIGHT);
        this.f65341f0 = new k5.a(this.f65376u);
        this.f65342g0 = new k5.a(this.f65376u);
        this.f65339d0 = new t(this.f65376u, this.f65337b0, this.f65341f0);
        this.f65340e0 = new t(this.f65376u, this.f65338c0, this.f65342g0);
        this.f65343h0 = new q(this.f65376u, this.f65365j, this.f65341f0);
        setHighlighter(new e5.b(this));
        this.f65370o = new com.github.mikephil.charting.listener.a(this, this.f65376u.p(), 3.0f);
        Paint paint = new Paint();
        this.Q = paint;
        paint.setStyle(Paint.Style.FILL);
        this.Q.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.R = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.R.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.R.setStrokeWidth(Utils.e(1.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f65358c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            z(canvas);
            if (this.I) {
                w();
            }
            if (this.f65337b0.f()) {
                t tVar = this.f65339d0;
                YAxis yAxis = this.f65337b0;
                tVar.a(yAxis.G, yAxis.F, yAxis.b0());
            }
            if (this.f65338c0.f()) {
                t tVar2 = this.f65340e0;
                YAxis yAxis2 = this.f65338c0;
                tVar2.a(yAxis2.G, yAxis2.F, yAxis2.b0());
            }
            if (this.f65365j.f()) {
                q qVar = this.f65343h0;
                XAxis xAxis = this.f65365j;
                qVar.a(xAxis.G, xAxis.F, false);
            }
            this.f65343h0.j(canvas);
            this.f65339d0.j(canvas);
            this.f65340e0.j(canvas);
            this.f65343h0.k(canvas);
            this.f65339d0.k(canvas);
            this.f65340e0.k(canvas);
            if (this.f65365j.f() && this.f65365j.B()) {
                this.f65343h0.n(canvas);
            }
            if (this.f65337b0.f() && this.f65337b0.B()) {
                this.f65339d0.l(canvas);
            }
            if (this.f65338c0.f() && this.f65338c0.B()) {
                this.f65340e0.l(canvas);
            }
            int save = canvas.save();
            canvas.clipRect(this.f65376u.o());
            this.f65374s.b(canvas);
            if (v()) {
                this.f65374s.d(canvas, this.B);
            }
            canvas.restoreToCount(save);
            this.f65374s.c(canvas);
            if (this.f65365j.f() && !this.f65365j.B()) {
                this.f65343h0.n(canvas);
            }
            if (this.f65337b0.f() && !this.f65337b0.B()) {
                this.f65339d0.l(canvas);
            }
            if (this.f65338c0.f() && !this.f65338c0.B()) {
                this.f65340e0.l(canvas);
            }
            this.f65343h0.i(canvas);
            this.f65339d0.i(canvas);
            this.f65340e0.i(canvas);
            if (E()) {
                int save2 = canvas.save();
                canvas.clipRect(this.f65376u.o());
                this.f65374s.f(canvas);
                canvas.restoreToCount(save2);
            } else {
                this.f65374s.f(canvas);
            }
            this.f65373r.e(canvas);
            h(canvas);
            i(canvas);
            if (this.f65357b) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j11 = this.f65344i0 + currentTimeMillis2;
                this.f65344i0 = j11;
                long j12 = this.f65345j0 + 1;
                this.f65345j0 = j12;
                Log.i(Chart.LOG_TAG, "Drawtime: " + currentTimeMillis2 + " ms, average: " + (j11 / j12) + " ms, cycles: " + this.f65345j0);
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        float[] fArr = this.f65353w0;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.W) {
            fArr[0] = this.f65376u.h();
            this.f65353w0[1] = this.f65376u.j();
            d(YAxis.AxisDependency.LEFT).j(this.f65353w0);
        }
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.W) {
            d(YAxis.AxisDependency.LEFT).k(this.f65353w0);
            this.f65376u.e(this.f65353w0, this);
            return;
        }
        ViewPortHandler viewPortHandler = this.f65376u;
        viewPortHandler.J(viewPortHandler.p(), this, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.f65370o;
        if (chartTouchListener == null || this.f65358c == null || !this.f65366k) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void s() {
        if (this.f65358c != null) {
            if (this.f65357b) {
                Log.i(Chart.LOG_TAG, "Preparing...");
            }
            g gVar = this.f65374s;
            if (gVar != null) {
                gVar.g();
            }
            x();
            t tVar = this.f65339d0;
            YAxis yAxis = this.f65337b0;
            tVar.a(yAxis.G, yAxis.F, yAxis.b0());
            t tVar2 = this.f65340e0;
            YAxis yAxis2 = this.f65338c0;
            tVar2.a(yAxis2.G, yAxis2.F, yAxis2.b0());
            q qVar = this.f65343h0;
            XAxis xAxis = this.f65365j;
            qVar.a(xAxis.G, xAxis.F, false);
            if (this.f65368m != null) {
                this.f65373r.a(this.f65358c);
            }
            f();
        } else if (this.f65357b) {
            Log.i(Chart.LOG_TAG, "Preparing... DATA NOT SET.");
        }
    }

    public void setAutoScaleMinMaxEnabled(boolean z11) {
        this.I = z11;
    }

    public void setBorderColor(int i11) {
        this.R.setColor(i11);
    }

    public void setBorderWidth(float f11) {
        this.R.setStrokeWidth(Utils.e(f11));
    }

    public void setClipValuesToContent(boolean z11) {
        this.U = z11;
    }

    public void setDoubleTapToZoomEnabled(boolean z11) {
        this.K = z11;
    }

    public void setDragEnabled(boolean z11) {
        this.M = z11;
        this.N = z11;
    }

    public void setDragOffsetX(float f11) {
        this.f65376u.M(f11);
    }

    public void setDragOffsetY(float f11) {
        this.f65376u.N(f11);
    }

    public void setDragXEnabled(boolean z11) {
        this.M = z11;
    }

    public void setDragYEnabled(boolean z11) {
        this.N = z11;
    }

    public void setDrawBorders(boolean z11) {
        this.T = z11;
    }

    public void setDrawGridBackground(boolean z11) {
        this.S = z11;
    }

    public void setGridBackgroundColor(int i11) {
        this.Q.setColor(i11);
    }

    public void setHighlightPerDragEnabled(boolean z11) {
        this.L = z11;
    }

    public void setKeepPositionOnRotation(boolean z11) {
        this.W = z11;
    }

    public void setMaxVisibleValueCount(int i11) {
        this.H = i11;
    }

    public void setMinOffset(float f11) {
        this.V = f11;
    }

    public void setOnDrawListener(h5.b bVar) {
        this.f65336a0 = bVar;
    }

    public void setPinchZoom(boolean z11) {
        this.J = z11;
    }

    public void setRendererLeftYAxis(t tVar) {
        this.f65339d0 = tVar;
    }

    public void setRendererRightYAxis(t tVar) {
        this.f65340e0 = tVar;
    }

    public void setScaleEnabled(boolean z11) {
        this.O = z11;
        this.P = z11;
    }

    public void setScaleXEnabled(boolean z11) {
        this.O = z11;
    }

    public void setScaleYEnabled(boolean z11) {
        this.P = z11;
    }

    public void setVisibleXRangeMaximum(float f11) {
        this.f65376u.Q(this.f65365j.H / f11);
    }

    public void setVisibleXRangeMinimum(float f11) {
        this.f65376u.O(this.f65365j.H / f11);
    }

    public void setXAxisRenderer(q qVar) {
        this.f65343h0 = qVar;
    }

    public void w() {
        ((BarLineScatterCandleBubbleData) this.f65358c).d(getLowestVisibleX(), getHighestVisibleX());
        this.f65365j.j(((BarLineScatterCandleBubbleData) this.f65358c).n(), ((BarLineScatterCandleBubbleData) this.f65358c).m());
        if (this.f65337b0.f()) {
            YAxis yAxis = this.f65337b0;
            YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
            yAxis.j(((BarLineScatterCandleBubbleData) this.f65358c).r(axisDependency), ((BarLineScatterCandleBubbleData) this.f65358c).p(axisDependency));
        }
        if (this.f65338c0.f()) {
            YAxis yAxis2 = this.f65338c0;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
            yAxis2.j(((BarLineScatterCandleBubbleData) this.f65358c).r(axisDependency2), ((BarLineScatterCandleBubbleData) this.f65358c).p(axisDependency2));
        }
        f();
    }

    public void x() {
        this.f65365j.j(((BarLineScatterCandleBubbleData) this.f65358c).n(), ((BarLineScatterCandleBubbleData) this.f65358c).m());
        YAxis yAxis = this.f65337b0;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.j(((BarLineScatterCandleBubbleData) this.f65358c).r(axisDependency), ((BarLineScatterCandleBubbleData) this.f65358c).p(axisDependency));
        YAxis yAxis2 = this.f65338c0;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.j(((BarLineScatterCandleBubbleData) this.f65358c).r(axisDependency2), ((BarLineScatterCandleBubbleData) this.f65358c).p(axisDependency2));
    }

    public void y(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.f65368m;
        if (legend != null && legend.f() && !this.f65368m.E()) {
            int i11 = a.f65356c[this.f65368m.z().ordinal()];
            if (i11 == 1) {
                int i12 = a.f65355b[this.f65368m.v().ordinal()];
                if (i12 == 1) {
                    rectF.left += Math.min(this.f65368m.f65438x, this.f65376u.m() * this.f65368m.w()) + this.f65368m.d();
                } else if (i12 == 2) {
                    rectF.right += Math.min(this.f65368m.f65438x, this.f65376u.m() * this.f65368m.w()) + this.f65368m.d();
                } else if (i12 == 3) {
                    int i13 = a.f65354a[this.f65368m.B().ordinal()];
                    if (i13 == 1) {
                        rectF.top += Math.min(this.f65368m.f65439y, this.f65376u.l() * this.f65368m.w()) + this.f65368m.e();
                    } else if (i13 == 2) {
                        rectF.bottom += Math.min(this.f65368m.f65439y, this.f65376u.l() * this.f65368m.w()) + this.f65368m.e();
                    }
                }
            } else if (i11 == 2) {
                int i14 = a.f65354a[this.f65368m.B().ordinal()];
                if (i14 == 1) {
                    rectF.top += Math.min(this.f65368m.f65439y, this.f65376u.l() * this.f65368m.w()) + this.f65368m.e();
                    if (getXAxis().f() && getXAxis().A()) {
                        rectF.top += (float) getXAxis().L;
                    }
                } else if (i14 == 2) {
                    rectF.bottom += Math.min(this.f65368m.f65439y, this.f65376u.l() * this.f65368m.w()) + this.f65368m.e();
                    if (getXAxis().f() && getXAxis().A()) {
                        rectF.bottom += (float) getXAxis().L;
                    }
                }
            }
        }
    }

    public void z(Canvas canvas) {
        if (this.S) {
            canvas.drawRect(this.f65376u.o(), this.Q);
        }
        if (this.T) {
            canvas.drawRect(this.f65376u.o(), this.R);
        }
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarLineChartBase(Context context) {
        super(context);
    }
}
