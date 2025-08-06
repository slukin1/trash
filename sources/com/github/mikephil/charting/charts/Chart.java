package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import d5.b;
import e5.d;
import e5.f;
import g5.e;
import i5.g;
import i5.i;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"NewApi"})
public abstract class Chart<T extends ChartData<? extends e<? extends Entry>>> extends ViewGroup implements f5.e {
    public boolean A = false;
    public d[] B;
    public float C = 0.0f;
    public boolean D = true;
    public b5.a E;
    public ArrayList<Runnable> F = new ArrayList<>();
    public boolean G = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65357b = false;

    /* renamed from: c  reason: collision with root package name */
    public T f65358c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65359d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65360e = true;

    /* renamed from: f  reason: collision with root package name */
    public float f65361f = 0.9f;

    /* renamed from: g  reason: collision with root package name */
    public b f65362g = new b(0);

    /* renamed from: h  reason: collision with root package name */
    public Paint f65363h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f65364i;

    /* renamed from: j  reason: collision with root package name */
    public XAxis f65365j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f65366k = true;

    /* renamed from: l  reason: collision with root package name */
    public Description f65367l;

    /* renamed from: m  reason: collision with root package name */
    public Legend f65368m;

    /* renamed from: n  reason: collision with root package name */
    public h5.a f65369n;

    /* renamed from: o  reason: collision with root package name */
    public ChartTouchListener f65370o;

    /* renamed from: p  reason: collision with root package name */
    public String f65371p = "No chart data available.";

    /* renamed from: q  reason: collision with root package name */
    public com.github.mikephil.charting.listener.b f65372q;

    /* renamed from: r  reason: collision with root package name */
    public i f65373r;

    /* renamed from: s  reason: collision with root package name */
    public g f65374s;

    /* renamed from: t  reason: collision with root package name */
    public f f65375t;

    /* renamed from: u  reason: collision with root package name */
    public ViewPortHandler f65376u = new ViewPortHandler();

    /* renamed from: v  reason: collision with root package name */
    public ChartAnimator f65377v;

    /* renamed from: w  reason: collision with root package name */
    public float f65378w = 0.0f;

    /* renamed from: x  reason: collision with root package name */
    public float f65379x = 0.0f;

    /* renamed from: y  reason: collision with root package name */
    public float f65380y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    public float f65381z = 0.0f;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Chart.this.postInvalidate();
        }
    }

    public Chart(Context context) {
        super(context);
        n();
    }

    public abstract void f();

    public void g() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public ChartAnimator getAnimator() {
        return this.f65377v;
    }

    public MPPointF getCenter() {
        return MPPointF.c(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public MPPointF getCenterOffsets() {
        return this.f65376u.n();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.f65376u.o();
    }

    public T getData() {
        return this.f65358c;
    }

    public d5.e getDefaultValueFormatter() {
        return this.f65362g;
    }

    public Description getDescription() {
        return this.f65367l;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f65361f;
    }

    public float getExtraBottomOffset() {
        return this.f65380y;
    }

    public float getExtraLeftOffset() {
        return this.f65381z;
    }

    public float getExtraRightOffset() {
        return this.f65379x;
    }

    public float getExtraTopOffset() {
        return this.f65378w;
    }

    public d[] getHighlighted() {
        return this.B;
    }

    public f getHighlighter() {
        return this.f65375t;
    }

    public ArrayList<Runnable> getJobs() {
        return this.F;
    }

    public Legend getLegend() {
        return this.f65368m;
    }

    public i getLegendRenderer() {
        return this.f65373r;
    }

    public b5.a getMarker() {
        return this.E;
    }

    @Deprecated
    public b5.a getMarkerView() {
        return getMarker();
    }

    public float getMaxHighlightDistance() {
        return this.C;
    }

    public abstract /* synthetic */ int getMaxVisibleCount();

    public com.github.mikephil.charting.listener.b getOnChartGestureListener() {
        return this.f65372q;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.f65370o;
    }

    public g getRenderer() {
        return this.f65374s;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.f65376u;
    }

    public XAxis getXAxis() {
        return this.f65365j;
    }

    public float getXChartMax() {
        return this.f65365j.F;
    }

    public float getXChartMin() {
        return this.f65365j.G;
    }

    public float getXRange() {
        return this.f65365j.H;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        return this.f65358c.o();
    }

    public float getYMin() {
        return this.f65358c.q();
    }

    public void h(Canvas canvas) {
        float f11;
        float f12;
        Description description = this.f65367l;
        if (description != null && description.f()) {
            MPPointF j11 = this.f65367l.j();
            this.f65363h.setTypeface(this.f65367l.c());
            this.f65363h.setTextSize(this.f65367l.b());
            this.f65363h.setColor(this.f65367l.a());
            this.f65363h.setTextAlign(this.f65367l.l());
            if (j11 == null) {
                f12 = (((float) getWidth()) - this.f65376u.H()) - this.f65367l.d();
                f11 = (((float) getHeight()) - this.f65376u.F()) - this.f65367l.e();
            } else {
                float f13 = j11.f65546c;
                f11 = j11.f65547d;
                f12 = f13;
            }
            canvas.drawText(this.f65367l.k(), f12, f11, this.f65363h);
        }
    }

    public void i(Canvas canvas) {
        if (this.E != null && p() && v()) {
            int i11 = 0;
            while (true) {
                d[] dVarArr = this.B;
                if (i11 < dVarArr.length) {
                    d dVar = dVarArr[i11];
                    e e11 = this.f65358c.e(dVar.d());
                    Entry i12 = this.f65358c.i(this.B[i11]);
                    int b11 = e11.b(i12);
                    if (i12 != null && ((float) b11) <= ((float) e11.getEntryCount()) * this.f65377v.a()) {
                        float[] l11 = l(dVar);
                        if (this.f65376u.x(l11[0], l11[1])) {
                            this.E.a(i12, dVar);
                            this.E.draw(canvas, l11[0], l11[1]);
                        }
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void j() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public d k(float f11, float f12) {
        if (this.f65358c != null) {
            return getHighlighter().getHighlight(f11, f12);
        }
        Log.e(com.huobi.view.chart.Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public float[] l(d dVar) {
        return new float[]{dVar.e(), dVar.f()};
    }

    public void m(d dVar, boolean z11) {
        Entry entry = null;
        if (dVar == null) {
            this.B = null;
        } else {
            if (this.f65357b) {
                Log.i(com.huobi.view.chart.Chart.LOG_TAG, "Highlighted: " + dVar.toString());
            }
            Entry i11 = this.f65358c.i(dVar);
            if (i11 == null) {
                this.B = null;
                dVar = null;
            } else {
                this.B = new d[]{dVar};
            }
            entry = i11;
        }
        setLastHighlighted(this.B);
        if (z11 && this.f65369n != null) {
            if (!v()) {
                this.f65369n.onNothingSelected();
            } else {
                this.f65369n.a(entry, dVar);
            }
        }
        invalidate();
    }

    public void n() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.f65377v = new ChartAnimator();
        } else {
            this.f65377v = new ChartAnimator(new a());
        }
        Utils.v(getContext());
        this.C = Utils.e(500.0f);
        this.f65367l = new Description();
        Legend legend = new Legend();
        this.f65368m = legend;
        this.f65373r = new i(this.f65376u, legend);
        this.f65365j = new XAxis();
        this.f65363h = new Paint(1);
        Paint paint = new Paint(1);
        this.f65364i = paint;
        paint.setColor(Color.rgb(TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, PsExtractor.PRIVATE_STREAM_1, 51));
        this.f65364i.setTextAlign(Paint.Align.CENTER);
        this.f65364i.setTextSize(Utils.e(12.0f));
        if (this.f65357b) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean o() {
        return this.f65360e;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.G) {
            u(this);
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.f65358c == null) {
            if (!TextUtils.isEmpty(this.f65371p)) {
                MPPointF center = getCenter();
                canvas.drawText(this.f65371p, center.f65546c, center.f65547d, this.f65364i);
            }
        } else if (!this.A) {
            f();
            this.A = true;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            getChildAt(i15).layout(i11, i12, i13, i14);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int e11 = (int) Utils.e(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(e11, i11)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(e11, i12)));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (this.f65357b) {
            Log.i(com.huobi.view.chart.Chart.LOG_TAG, "OnSizeChanged()");
        }
        if (i11 > 0 && i12 > 0 && i11 < 10000 && i12 < 10000) {
            if (this.f65357b) {
                Log.i(com.huobi.view.chart.Chart.LOG_TAG, "Setting chart dimens, width: " + i11 + ", height: " + i12);
            }
            this.f65376u.L((float) i11, (float) i12);
        } else if (this.f65357b) {
            Log.w(com.huobi.view.chart.Chart.LOG_TAG, "*Avoiding* setting chart dimens! width: " + i11 + ", height: " + i12);
        }
        s();
        Iterator<Runnable> it2 = this.F.iterator();
        while (it2.hasNext()) {
            post(it2.next());
        }
        this.F.clear();
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public boolean p() {
        return this.D;
    }

    public boolean q() {
        return this.f65359d;
    }

    public boolean r() {
        return this.f65357b;
    }

    public abstract void s();

    public void setData(T t11) {
        this.f65358c = t11;
        this.A = false;
        if (t11 != null) {
            t(t11.q(), t11.o());
            for (e eVar : this.f65358c.g()) {
                if (eVar.needsFormatter() || eVar.getValueFormatter() == this.f65362g) {
                    eVar.I(this.f65362g);
                }
            }
            s();
            if (this.f65357b) {
                Log.i(com.huobi.view.chart.Chart.LOG_TAG, "Data is set.");
            }
        }
    }

    public void setDescription(Description description) {
        this.f65367l = description;
    }

    public void setDragDecelerationEnabled(boolean z11) {
        this.f65360e = z11;
    }

    public void setDragDecelerationFrictionCoef(float f11) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 >= 1.0f) {
            f11 = 0.999f;
        }
        this.f65361f = f11;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z11) {
        setDrawMarkers(z11);
    }

    public void setDrawMarkers(boolean z11) {
        this.D = z11;
    }

    public void setExtraBottomOffset(float f11) {
        this.f65380y = Utils.e(f11);
    }

    public void setExtraLeftOffset(float f11) {
        this.f65381z = Utils.e(f11);
    }

    public void setExtraRightOffset(float f11) {
        this.f65379x = Utils.e(f11);
    }

    public void setExtraTopOffset(float f11) {
        this.f65378w = Utils.e(f11);
    }

    public void setHardwareAccelerationEnabled(boolean z11) {
        if (Build.VERSION.SDK_INT < 11) {
            Log.e(com.huobi.view.chart.Chart.LOG_TAG, "Cannot enable/disable hardware acceleration for devices below API level 11.");
        } else if (z11) {
            setLayerType(2, (Paint) null);
        } else {
            setLayerType(1, (Paint) null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z11) {
        this.f65359d = z11;
    }

    public void setHighlighter(e5.b bVar) {
        this.f65375t = bVar;
    }

    public void setLastHighlighted(d[] dVarArr) {
        if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) {
            this.f65370o.d((d) null);
        } else {
            this.f65370o.d(dVarArr[0]);
        }
    }

    public void setLogEnabled(boolean z11) {
        this.f65357b = z11;
    }

    public void setMarker(b5.a aVar) {
        this.E = aVar;
    }

    @Deprecated
    public void setMarkerView(b5.a aVar) {
        setMarker(aVar);
    }

    public void setMaxHighlightDistance(float f11) {
        this.C = Utils.e(f11);
    }

    public void setNoDataText(String str) {
        this.f65371p = str;
    }

    public void setNoDataTextColor(int i11) {
        this.f65364i.setColor(i11);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.f65364i.setTypeface(typeface);
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.listener.b bVar) {
        this.f65372q = bVar;
    }

    public void setOnChartValueSelectedListener(h5.a aVar) {
        this.f65369n = aVar;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.f65370o = chartTouchListener;
    }

    public void setRenderer(g gVar) {
        if (gVar != null) {
            this.f65374s = gVar;
        }
    }

    public void setTouchEnabled(boolean z11) {
        this.f65366k = z11;
    }

    public void setUnbindEnabled(boolean z11) {
        this.G = z11;
    }

    public void t(float f11, float f12) {
        float f13;
        T t11 = this.f65358c;
        if (t11 == null || t11.h() < 2) {
            f13 = Math.max(Math.abs(f11), Math.abs(f12));
        } else {
            f13 = Math.abs(f12 - f11);
        }
        this.f65362g.a(Utils.i(f13));
    }

    public final void u(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback((Drawable.Callback) null);
        }
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 < viewGroup.getChildCount()) {
                    u(viewGroup.getChildAt(i11));
                    i11++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    public boolean v() {
        d[] dVarArr = this.B;
        return (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) ? false : true;
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n();
    }

    public Chart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        n();
    }
}
