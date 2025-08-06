package com.huobi.edgeengine.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.m;
import com.blankj.utilcode.util.v;
import com.google.gson.reflect.TypeToken;
import com.huobi.R$styleable;
import i6.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import pro.huobi.R;

public final class HotCoinChartView extends View {
    public final Paint A;
    public List<PointBean> B;
    public List<String> C;
    public float D;
    public float E;
    public float F;
    public float G;
    public boolean H;
    public float I;
    public float J;
    public float K;
    public final float L;
    public final float M;

    /* renamed from: b  reason: collision with root package name */
    public final String f44448b;

    /* renamed from: c  reason: collision with root package name */
    public float f44449c;

    /* renamed from: d  reason: collision with root package name */
    public float f44450d;

    /* renamed from: e  reason: collision with root package name */
    public float f44451e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f44452f;

    /* renamed from: g  reason: collision with root package name */
    public int f44453g;

    /* renamed from: h  reason: collision with root package name */
    public int f44454h;

    /* renamed from: i  reason: collision with root package name */
    public int f44455i;

    /* renamed from: j  reason: collision with root package name */
    public final int f44456j;

    /* renamed from: k  reason: collision with root package name */
    public final int f44457k;

    /* renamed from: l  reason: collision with root package name */
    public final int f44458l;

    /* renamed from: m  reason: collision with root package name */
    public final int f44459m;

    /* renamed from: n  reason: collision with root package name */
    public final int f44460n;

    /* renamed from: o  reason: collision with root package name */
    public final int f44461o;

    /* renamed from: p  reason: collision with root package name */
    public int f44462p;

    /* renamed from: q  reason: collision with root package name */
    public final int f44463q;

    /* renamed from: r  reason: collision with root package name */
    public final int f44464r;

    /* renamed from: s  reason: collision with root package name */
    public final int f44465s;

    /* renamed from: t  reason: collision with root package name */
    public final int f44466t;

    /* renamed from: u  reason: collision with root package name */
    public final int f44467u;

    /* renamed from: v  reason: collision with root package name */
    public final float f44468v;

    /* renamed from: w  reason: collision with root package name */
    public final int f44469w;

    /* renamed from: x  reason: collision with root package name */
    public float f44470x;

    /* renamed from: y  reason: collision with root package name */
    public float f44471y;

    /* renamed from: z  reason: collision with root package name */
    public Rect f44472z;

    public static final class PointBean implements Serializable {
        private float originalValue;
        private String popupContent;
        private String popupDate;

        public PointBean(float f11, String str, String str2) {
            this.originalValue = f11;
            this.popupDate = str;
            this.popupContent = str2;
        }

        public static /* synthetic */ PointBean copy$default(PointBean pointBean, float f11, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = pointBean.originalValue;
            }
            if ((i11 & 2) != 0) {
                str = pointBean.popupDate;
            }
            if ((i11 & 4) != 0) {
                str2 = pointBean.popupContent;
            }
            return pointBean.copy(f11, str, str2);
        }

        public final float component1() {
            return this.originalValue;
        }

        public final String component2() {
            return this.popupDate;
        }

        public final String component3() {
            return this.popupContent;
        }

        public final PointBean copy(float f11, String str, String str2) {
            return new PointBean(f11, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PointBean)) {
                return false;
            }
            PointBean pointBean = (PointBean) obj;
            return Float.compare(this.originalValue, pointBean.originalValue) == 0 && x.b(this.popupDate, pointBean.popupDate) && x.b(this.popupContent, pointBean.popupContent);
        }

        public final float getOriginalValue() {
            return this.originalValue;
        }

        public final String getPopupContent() {
            return this.popupContent;
        }

        public final String getPopupDate() {
            return this.popupDate;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.originalValue) * 31) + this.popupDate.hashCode()) * 31) + this.popupContent.hashCode();
        }

        public final void setOriginalValue(float f11) {
            this.originalValue = f11;
        }

        public final void setPopupContent(String str) {
            this.popupContent = str;
        }

        public final void setPopupDate(String str) {
            this.popupDate = str;
        }

        public String toString() {
            return "PointBean(originalValue=" + this.originalValue + ", popupDate=" + this.popupDate + ", popupContent=" + this.popupContent + ')';
        }
    }

    public static final class a extends TypeToken<List<? extends PointBean>> {
    }

    public static final class b extends TypeToken<List<? extends String>> {
    }

    public HotCoinChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotCoinChartView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ float j(HotCoinChartView hotCoinChartView, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = hotCoinChartView.D;
        }
        if ((i11 & 4) != 0) {
            f13 = hotCoinChartView.E;
        }
        return hotCoinChartView.i(f11, f12, f13);
    }

    public final void a(Canvas canvas, int i11) {
        this.J = h(i11);
        PointBean pointBean = (PointBean) CollectionsKt___CollectionsKt.d0(this.B, i11);
        this.K = j(this, pointBean != null ? pointBean.getOriginalValue() : 0.0f, 0.0f, 0.0f, 6, (Object) null);
        Paint paint = this.f44452f;
        paint.setAntiAlias(true);
        paint.setColor(this.f44454h);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.J, this.K, (float) this.f44456j, this.f44452f);
        Paint paint2 = this.f44452f;
        paint2.setAntiAlias(true);
        paint2.setColor(this.f44455i);
        paint2.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.J, this.K, (float) this.f44457k, this.f44452f);
    }

    public final void b(Canvas canvas, int i11) {
        float f11;
        float f12;
        float f13;
        float f14;
        Canvas canvas2 = canvas;
        PointBean pointBean = (PointBean) CollectionsKt___CollectionsKt.d0(this.B, i11);
        if (pointBean != null) {
            this.f44452f.setTextSize((float) this.f44461o);
            int width = g(this.f44452f, pointBean.getPopupDate()).width();
            int height = g(this.f44452f, pointBean.getPopupDate()).height();
            this.f44452f.setTextSize((float) this.f44463q);
            int width2 = g(this.f44452f, pointBean.getPopupContent()).width();
            int height2 = g(this.f44452f, pointBean.getPopupContent()).height();
            int max = Math.max(width, width2) + (this.f44458l * 2);
            int i12 = height + height2 + (this.f44459m * 2) + this.f44460n;
            Paint paint = this.f44452f;
            paint.setAntiAlias(true);
            paint.setColor(this.f44465s);
            paint.setStyle(Paint.Style.FILL);
            float f15 = this.J;
            boolean z11 = false;
            if (f15 > this.f44451e / ((float) 2)) {
                int i13 = this.f44467u;
                float f16 = (f15 - ((float) i13)) - ((float) max);
                float f17 = this.K;
                float f18 = (float) (i12 / 2);
                float f19 = f17 - f18;
                if (f19 < 0.0f) {
                    f19 = 0.0f;
                }
                float f21 = f15 - ((float) i13);
                if (f19 == 0.0f) {
                    z11 = true;
                }
                f13 = z11 ? (float) i12 : f17 + f18;
                f12 = f16;
                f11 = f19;
                f14 = f21;
            } else {
                float f22 = f15 + ((float) this.f44467u);
                float f23 = this.K;
                float f24 = (float) (i12 / 2);
                float f25 = f23 - f24;
                float f26 = f25 < 0.0f ? 0.0f : f25;
                float f27 = ((float) max) + f22;
                if (f26 == 0.0f) {
                    z11 = true;
                }
                f13 = z11 ? (float) i12 : f23 + f24;
                f12 = f22;
                f11 = f26;
                f14 = f27;
            }
            int i14 = this.f44466t;
            float f28 = f11;
            float f29 = f14;
            float f31 = f13;
            canvas.drawRoundRect(f12, f28, f29, f31, (float) i14, (float) i14, this.f44452f);
            int color = ContextCompat.getColor(getContext(), R.color.baseColorSecondarySeparator);
            Paint paint2 = this.f44452f;
            paint2.setAntiAlias(true);
            paint2.setColor(color);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth((float) v.a(0.5f));
            int i15 = this.f44466t;
            canvas.drawRoundRect(f12, f28, f29, f31, (float) i15, (float) i15, this.f44452f);
            Paint paint3 = this.f44452f;
            paint3.setAntiAlias(true);
            paint3.setColor(this.f44462p);
            paint3.setStyle(Paint.Style.FILL);
            paint3.setTextSize((float) this.f44461o);
            paint3.setTextAlign(Paint.Align.LEFT);
            float f32 = f12 + ((float) this.f44458l);
            float f33 = f11 + ((float) this.f44459m) + ((float) height);
            canvas2.drawText(pointBean.getPopupDate(), f32, f33, this.f44452f);
            Paint paint4 = this.f44452f;
            paint4.setAntiAlias(true);
            paint4.setColor(this.f44464r);
            paint4.setStyle(Paint.Style.FILL);
            paint4.setTextSize((float) this.f44463q);
            paint4.setTextAlign(Paint.Align.LEFT);
            canvas2.drawText(pointBean.getPopupContent(), f32, f33 + ((float) height2) + ((float) this.f44460n), this.f44452f);
        }
    }

    public final void c(Canvas canvas) {
        Paint paint = this.f44452f;
        paint.setColor(this.f44453g);
        paint.setStrokeWidth((float) v.a(0.5f));
        paint.setStyle(Paint.Style.STROKE);
        float f11 = (float) 3;
        float f12 = this.f44450d / f11;
        float f13 = this.M;
        float f14 = this.f44451e;
        float f15 = ((float) 2) * f12;
        float f16 = f11 * f12;
        canvas.drawLines(new float[]{f13, 0.0f, f14 - f13, 0.0f, f13, f12, f14 - f13, f12, f13, f15, f14 - f13, f15, f13, f16, f14 - f13, f16}, this.f44452f);
    }

    public final void d(Canvas canvas) {
        T t11;
        T t12;
        Path path = new Path();
        Iterator<T> it2 = this.B.iterator();
        if (!it2.hasNext()) {
            t11 = null;
        } else {
            t11 = it2.next();
            if (it2.hasNext()) {
                float originalValue = ((PointBean) t11).getOriginalValue();
                do {
                    T next = it2.next();
                    float originalValue2 = ((PointBean) next).getOriginalValue();
                    if (Float.compare(originalValue, originalValue2) < 0) {
                        t11 = next;
                        originalValue = originalValue2;
                    }
                } while (it2.hasNext());
            }
        }
        PointBean pointBean = (PointBean) t11;
        this.D = pointBean != null ? pointBean.getOriginalValue() : 1.0f;
        Iterator<T> it3 = this.B.iterator();
        if (!it3.hasNext()) {
            t12 = null;
        } else {
            t12 = it3.next();
            if (it3.hasNext()) {
                float originalValue3 = ((PointBean) t12).getOriginalValue();
                do {
                    T next2 = it3.next();
                    float originalValue4 = ((PointBean) next2).getOriginalValue();
                    if (Float.compare(originalValue3, originalValue4) > 0) {
                        t12 = next2;
                        originalValue3 = originalValue4;
                    }
                } while (it3.hasNext());
            }
        }
        PointBean pointBean2 = (PointBean) t12;
        this.E = pointBean2 != null ? pointBean2.getOriginalValue() : 0.0f;
        int i11 = 0;
        for (T next3 : this.B) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            PointBean pointBean3 = (PointBean) next3;
            if (i11 == 0) {
                path.moveTo(h(i11), j(this, pointBean3.getOriginalValue(), 0.0f, 0.0f, 6, (Object) null));
            } else {
                path.lineTo(h(i11), j(this, pointBean3.getOriginalValue(), 0.0f, 0.0f, 6, (Object) null));
            }
            i11 = i12;
        }
        Paint paint = this.A;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        paint.setStrokeWidth((float) v.a(1.5f));
        paint.setShader((Shader) null);
        canvas.drawPath(path, this.A);
    }

    public final void e(Canvas canvas, int i11) {
        float h11 = h(i11);
        Paint paint = this.f44452f;
        paint.setColor(this.f44453g);
        paint.setStrokeWidth((float) v.a(0.5f));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(h11, 0.0f, h11, this.f44450d, this.f44452f);
    }

    public final void f(Canvas canvas) {
        Paint paint = this.f44452f;
        paint.setColor(this.f44469w);
        paint.setTextSize(this.f44468v);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        float height = this.f44450d + ((float) this.f44472z.height());
        int i11 = 0;
        if (this.C.size() >= 5) {
            float width = ((float) this.f44472z.width()) / 2.0f;
            float width2 = ((this.f44451e - ((float) this.f44472z.width())) - (this.M * ((float) 2))) / ((float) 4);
            for (T next : this.C) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                String str = (String) next;
                if (i11 <= 4) {
                    canvas.drawText(str, (((float) i11) * width2) + width + this.M, height, this.f44452f);
                }
                i11 = i12;
            }
        } else if (this.C.size() >= 3) {
            float width3 = ((float) this.f44472z.width()) / 2.0f;
            float f11 = (float) 2;
            float width4 = ((this.f44451e - ((float) this.f44472z.width())) - (this.M * f11)) / f11;
            for (T next2 : this.C) {
                int i13 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                String str2 = (String) next2;
                if (i11 <= 2) {
                    canvas.drawText(str2, (((float) i11) * width4) + width3 + this.M, height, this.f44452f);
                }
                i11 = i13;
            }
        } else if (this.C.size() >= 1) {
            float width5 = ((float) this.f44472z.width()) / 2.0f;
            float width6 = (this.f44451e - ((float) this.f44472z.width())) - (this.M * ((float) 2));
            for (T next3 : this.C) {
                int i14 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                canvas.drawText((String) next3, (((float) i11) * width6) + width5 + this.M, height, this.f44452f);
                i11 = i14;
            }
        } else {
            LogUtils.j("图表表头必须是5个");
        }
    }

    public final Rect g(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public final float getMTableHeight() {
        return this.f44450d;
    }

    public final Rect getMTableTextRect() {
        return this.f44472z;
    }

    public final float getMTableWidth() {
        return this.f44451e;
    }

    public final float getMViewHeight() {
        return this.f44449c;
    }

    public final float h(int i11) {
        if (this.I <= 0.0f) {
            this.I = (this.f44451e - (this.M * ((float) 2))) / ((float) (this.B.size() - 1));
        }
        return (((float) i11) * this.I) + this.M;
    }

    public final float i(float f11, float f12, float f13) {
        if (f13 == f12) {
            return this.f44450d - this.L;
        }
        float f14 = this.f44450d;
        float f15 = this.L;
        return (f14 - (((f11 - f13) * (f14 - (((float) 2) * f15))) / (f12 - f13))) - f15;
    }

    public final void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.HotCoinChartView);
        this.f44470x = obtainStyledAttributes.getDimension(3, (float) v.a(28.0f));
        this.f44471y = obtainStyledAttributes.getDimension(2, (float) v.a(14.0f));
        this.f44472z = new Rect(0, 0, (int) this.f44470x, (int) this.f44471y);
        m(obtainStyledAttributes.getString(1));
        l(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
    }

    public final void l(String str) {
        try {
            this.B.clear();
            this.I = 0.0f;
            this.H = false;
            List list = (List) m.d().fromJson(str, new a().getType());
            if (list != null) {
                this.B.addAll(list);
            }
        } catch (Throwable th2) {
            LogUtils.j(th2);
        }
    }

    public final void m(String str) {
        try {
            this.C.clear();
            List list = (List) m.d().fromJson(str, new b().getType());
            if (list != null) {
                this.C.addAll(list);
            }
        } catch (Throwable th2) {
            LogUtils.j(th2);
        }
    }

    public void onDraw(Canvas canvas) {
        String str = this.f44448b;
        d.c(str, "onDraw isTouched= " + this.H);
        canvas.save();
        c(canvas);
        f(canvas);
        d(canvas);
        if (this.H) {
            int rint = (int) ((float) Math.rint((double) (this.F / this.I)));
            e(canvas, rint);
            a(canvas, rint);
            b(canvas, rint);
        }
        canvas.restore();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        setMeasuredDimension((int) (((float) size) + (this.M * ((float) 2))), View.MeasureSpec.getSize(i12));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f44451e = (float) i11;
        float f11 = (float) i12;
        this.f44449c = f11;
        this.f44450d = (f11 - ((float) this.f44472z.height())) - ((float) v.a(4.0f));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.H = !this.H;
            this.F = motionEvent.getX();
            this.G = motionEvent.getY();
            postInvalidate();
        }
        return true;
    }

    public final void setMTableHeight(float f11) {
        this.f44450d = f11;
    }

    public final void setMTableTextRect(Rect rect) {
        this.f44472z = rect;
    }

    public final void setMTableWidth(float f11) {
        this.f44451e = f11;
    }

    public final void setMViewHeight(float f11) {
        this.f44449c = f11;
    }

    public final void setPointList(List<PointBean> list) {
        this.B.clear();
        this.I = 0.0f;
        if (list != null) {
            this.B.addAll(list);
        }
        invalidate();
    }

    public final void setPointListJson(String str) {
        if (str != null) {
            chartData chartdata = (chartData) m.c(str, chartData.class);
            setXList(chartdata.getXList());
            setPointList(chartdata.getPointList());
        }
    }

    public final void setXList(List<String> list) {
        this.C.clear();
        if (list != null) {
            this.C.addAll(list);
        }
        invalidate();
    }

    public final void setXTextHeight(int i11) {
        this.f44472z.bottom = i11;
        invalidate();
    }

    public final void setXTextWidth(int i11) {
        this.f44472z.right = i11;
        invalidate();
    }

    public HotCoinChartView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44448b = "HotCoinChartView";
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.LEFT);
        this.f44452f = paint;
        this.f44453g = ContextCompat.getColor(context, R.color.kColorEBEBEB);
        this.f44454h = ContextCompat.getColor(context, R.color.KBaseTextColor);
        this.f44455i = ContextCompat.getColor(context, R.color.kColorMajorTheme100);
        this.f44456j = v.a(4.0f);
        this.f44457k = v.a(3.0f);
        this.f44458l = v.a(8.0f);
        this.f44459m = v.a(12.0f);
        this.f44460n = v.a(8.0f);
        this.f44461o = v.a(12.0f);
        this.f44462p = ContextCompat.getColor(context, R.color.KBaseColorThreeLevelText);
        this.f44463q = v.a(12.0f);
        this.f44464r = ContextCompat.getColor(context, R.color.kColorPrimaryText);
        this.f44465s = ContextCompat.getColor(context, R.color.KBaseColorContentBackground);
        this.f44466t = v.a(4.0f);
        this.f44467u = v.a(7.0f);
        this.f44468v = (float) v.a(10.0f);
        this.f44469w = ContextCompat.getColor(context, R.color.baseColorThreeLevelText);
        this.f44470x = (float) v.a(28.0f);
        this.f44471y = (float) v.a(14.0f);
        this.f44472z = new Rect(0, 0, (int) this.f44470x, (int) this.f44471y);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.A = paint2;
        this.B = new ArrayList();
        this.C = new ArrayList();
        k(attributeSet);
        this.L = (float) v.a(20.0f);
        this.M = (float) v.a(4.0f);
    }

    public static final class chartData implements Serializable {
        private List<PointBean> pointList;
        private List<String> xList;

        public chartData() {
            this((List) null, (List) null, 3, (r) null);
        }

        public chartData(List<PointBean> list, List<String> list2) {
            this.pointList = list;
            this.xList = list2;
        }

        public static /* synthetic */ chartData copy$default(chartData chartdata, List<PointBean> list, List<String> list2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = chartdata.pointList;
            }
            if ((i11 & 2) != 0) {
                list2 = chartdata.xList;
            }
            return chartdata.copy(list, list2);
        }

        public final List<PointBean> component1() {
            return this.pointList;
        }

        public final List<String> component2() {
            return this.xList;
        }

        public final chartData copy(List<PointBean> list, List<String> list2) {
            return new chartData(list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof chartData)) {
                return false;
            }
            chartData chartdata = (chartData) obj;
            return x.b(this.pointList, chartdata.pointList) && x.b(this.xList, chartdata.xList);
        }

        public final List<PointBean> getPointList() {
            return this.pointList;
        }

        public final List<String> getXList() {
            return this.xList;
        }

        public int hashCode() {
            List<PointBean> list = this.pointList;
            int i11 = 0;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            List<String> list2 = this.xList;
            if (list2 != null) {
                i11 = list2.hashCode();
            }
            return hashCode + i11;
        }

        public final void setPointList(List<PointBean> list) {
            this.pointList = list;
        }

        public final void setXList(List<String> list) {
            this.xList = list;
        }

        public String toString() {
            return "chartData(pointList=" + this.pointList + ", xList=" + this.xList + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ chartData(List list, List list2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : list2);
        }
    }
}
