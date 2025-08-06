package com.hbg.module.content.custom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.h;
import com.blankj.utilcode.util.v;
import com.hbg.lib.core.util.w;
import com.hbg.module.content.R$color;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.r;

public final class LineChartWidget extends View {

    /* renamed from: n  reason: collision with root package name */
    public static final a f18174n = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final Path f18175b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f18176c;

    /* renamed from: d  reason: collision with root package name */
    public List<Float> f18177d;

    /* renamed from: e  reason: collision with root package name */
    public float f18178e;

    /* renamed from: f  reason: collision with root package name */
    public float f18179f;

    /* renamed from: g  reason: collision with root package name */
    public List<? extends PointF> f18180g;

    /* renamed from: h  reason: collision with root package name */
    public float f18181h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f18182i;

    /* renamed from: j  reason: collision with root package name */
    public PointF f18183j;

    /* renamed from: k  reason: collision with root package name */
    public final i f18184k;

    /* renamed from: l  reason: collision with root package name */
    public int f18185l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f18186m;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public LineChartWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LineChartWidget(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final int getChatBg() {
        if (getColorMode() == 1) {
            return h.a(R$color.kColorFsGreen);
        }
        return h.a(R$color.kColorFsRed);
    }

    private final int getColorMode() {
        boolean l11 = w.l();
        int i11 = this.f18185l;
        if (i11 != 1 || !l11) {
            return (i11 != 2 || l11) ? 1 : 2;
        }
        return 2;
    }

    private final Shader getGraphBgGradient() {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) getMeasuredHeight(), getChatBg(), 0, Shader.TileMode.REPEAT);
    }

    private final Paint getGraphPaint() {
        return (Paint) this.f18184k.getValue();
    }

    public final int getLineColor() {
        if (getColorMode() == 1) {
            return h.a(R$color.kColorPriceGreen);
        }
        return h.a(R$color.kColorPriceRed);
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        List<? extends PointF> list = this.f18180g;
        int i11 = 0;
        if (!(list == null || list.isEmpty())) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f11 = this.f18181h;
            float paddingTop = ((float) ((measuredHeight - getPaddingTop()) - getPaddingBottom())) - (4.0f * f11);
            float paddingStart = (((((float) measuredWidth) - (f11 * 3.0f)) - ((float) getPaddingStart())) - ((float) getPaddingEnd())) / ((float) CollectionsKt__CollectionsKt.m(this.f18177d));
            float paddingStart2 = ((float) getPaddingStart()) + (this.f18181h * 1.5f);
            float paddingTop2 = ((float) getPaddingTop()) + (this.f18181h * 1.5f);
            int i12 = 0;
            for (T next : this.f18180g) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                PointF pointF = (PointF) next;
                pointF.x = (((float) i12) * paddingStart) + paddingStart2;
                float floatValue = this.f18177d.get(i12).floatValue();
                float f12 = this.f18178e;
                float f13 = this.f18179f;
                if (f12 == f13) {
                    pointF.y = paddingTop / ((float) 2);
                } else {
                    pointF.y = ((((float) 1) - ((floatValue - f13) / (f12 - f13))) * paddingTop) + paddingTop2;
                }
                if (this.f18182i.y == Float.MIN_VALUE) {
                    if (f12 == floatValue) {
                        this.f18182i = pointF;
                    }
                }
                if (this.f18183j.y == Float.MAX_VALUE) {
                    if (f13 == floatValue) {
                        this.f18183j = pointF;
                    }
                }
                i12 = i13;
            }
            this.f18175b.reset();
            int m11 = CollectionsKt__CollectionsKt.m(this.f18180g);
            while (i11 < m11) {
                Object obj = this.f18180g.get(i11);
                int i14 = i11 + 1;
                Object obj2 = this.f18180g.get(i14);
                if (i11 == 0) {
                    PointF pointF2 = (PointF) obj;
                    this.f18175b.moveTo(pointF2.x, pointF2.y);
                }
                PointF pointF3 = (PointF) obj;
                float f14 = pointF3.x;
                PointF pointF4 = (PointF) obj2;
                float f15 = pointF4.x;
                float f16 = (f14 + f15) / 2.0f;
                Path path = this.f18175b;
                float f17 = pointF3.y;
                float f18 = pointF4.y;
                path.cubicTo(f16, f17, f16, f18, f15, f18);
                i11 = i14;
            }
            if (this.f18186m) {
                this.f18176c.set(this.f18175b);
                float paddingBottom = ((float) measuredHeight) - (((float) getPaddingBottom()) * 1.0f);
                this.f18176c.lineTo(((PointF) CollectionsKt___CollectionsKt.m0(this.f18180g)).x, paddingBottom);
                this.f18176c.lineTo(paddingStart2, paddingBottom);
                Paint graphPaint = getGraphPaint();
                graphPaint.setStyle(Paint.Style.FILL);
                graphPaint.setStrokeWidth(this.f18181h);
                graphPaint.setShader(getGraphBgGradient());
                canvas2.drawPath(this.f18176c, getGraphPaint());
            }
            Paint graphPaint2 = getGraphPaint();
            graphPaint2.setColor(getLineColor());
            graphPaint2.setStrokeWidth(this.f18181h);
            graphPaint2.setStyle(Paint.Style.STROKE);
            graphPaint2.setShader((Shader) null);
            canvas2.drawPath(this.f18175b, getGraphPaint());
        }
    }

    public final void setData(List<Float> list) {
        if (list != null) {
            this.f18177d = list;
            this.f18178e = Float.MIN_VALUE;
            this.f18179f = Float.MAX_VALUE;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (Number floatValue : list) {
                float floatValue2 = floatValue.floatValue();
                float f11 = this.f18178e;
                if (f11 < floatValue2) {
                    f11 = floatValue2;
                }
                this.f18178e = f11;
                float f12 = this.f18179f;
                if (f12 <= floatValue2) {
                    floatValue2 = f12;
                }
                this.f18179f = floatValue2;
                arrayList.add(new PointF());
            }
            this.f18180g = arrayList;
            invalidate();
        }
    }

    public final void setDrawGraphBg(boolean z11) {
        this.f18186m = z11;
    }

    public final void setLineWidth(Float f11) {
        if (f11 != null) {
            float floatValue = f11.floatValue();
            if (floatValue > 0.0f) {
                this.f18181h = floatValue;
                invalidate();
            }
        }
    }

    public final void setMode(int i11) {
        this.f18185l = i11;
    }

    public LineChartWidget(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f18175b = new Path();
        this.f18176c = new Path();
        this.f18177d = CollectionsKt__CollectionsKt.k();
        this.f18178e = Float.MIN_VALUE;
        this.f18179f = Float.MAX_VALUE;
        this.f18180g = CollectionsKt__CollectionsKt.k();
        this.f18181h = (float) v.a(2.0f);
        this.f18182i = new PointF();
        this.f18183j = new PointF();
        this.f18184k = LazyKt__LazyJVMKt.a(new LineChartWidget$graphPaint$2(this));
        this.f18185l = 1;
        this.f18186m = true;
    }
}
