package com.hbg.lite.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$string;
import com.hbg.lite.R$styleable;
import hb.h;
import hb.i;
import hb.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TradingCurveView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f77328b;

    /* renamed from: c  reason: collision with root package name */
    public int f77329c;

    /* renamed from: d  reason: collision with root package name */
    public int f77330d;

    /* renamed from: e  reason: collision with root package name */
    public int f77331e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f77332f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f77333g;

    /* renamed from: h  reason: collision with root package name */
    public Path f77334h;

    /* renamed from: i  reason: collision with root package name */
    public Path f77335i;

    /* renamed from: j  reason: collision with root package name */
    public int f77336j;

    /* renamed from: k  reason: collision with root package name */
    public int f77337k;

    /* renamed from: l  reason: collision with root package name */
    public int f77338l;

    /* renamed from: m  reason: collision with root package name */
    public List<Double> f77339m;

    /* renamed from: n  reason: collision with root package name */
    public String f77340n;

    /* renamed from: o  reason: collision with root package name */
    public BlurMaskFilter f77341o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f77342p;

    public TradingCurveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(List list) {
        try {
            p();
            this.f77335i.reset();
            d();
            e(list);
            invalidate();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(List list) {
        try {
            p();
            this.f77334h.reset();
            e(list);
            invalidate();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        try {
            this.f77335i.reset();
            d();
            invalidate();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void d() {
        int i11;
        if (!CollectionsUtils.b(this.f77339m)) {
            int size = ((this.f77330d - this.f77339m.size()) * this.f77328b) / this.f77330d;
            this.f77329c = size;
            i11 = Math.max(size - PixelUtils.a(1.5f), 0);
        } else {
            i11 = this.f77328b;
        }
        this.f77335i.reset();
        this.f77335i.moveTo(0.0f, (float) (this.f77331e / 2));
        this.f77335i.lineTo((float) i11, (float) (this.f77331e / 2));
    }

    public final void e(List<Double> list) {
        int i11;
        Double d11 = (Double) Collections.min(list);
        double doubleValue = ((Double) Collections.max(list)).doubleValue() - d11.doubleValue();
        this.f77334h.reset();
        for (int i12 = 0; i12 < list.size(); i12++) {
            Double d12 = list.get(i12);
            int size = (((this.f77328b - this.f77329c) * i12) / list.size()) + this.f77329c;
            if (doubleValue == 0.0d) {
                i11 = this.f77331e / 2;
            } else {
                i11 = ((int) (((double) (this.f77331e - 4)) * (1.0d - ((d12.doubleValue() - d11.doubleValue()) / doubleValue)))) + 2;
            }
            if (i12 == 0) {
                this.f77334h.moveTo((float) size, (float) i11);
            } else {
                this.f77334h.lineTo((float) size, (float) i11);
            }
        }
    }

    public final void f(Canvas canvas) {
        q();
        canvas.drawPath(this.f77335i, this.f77333g);
    }

    public final void g(Canvas canvas) {
        r();
        canvas.drawPath(this.f77334h, this.f77332f);
    }

    public double h(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return Double.parseDouble(str);
    }

    public final void i(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        k(context);
        o(context, attributeSet);
        j();
    }

    public final void j() {
        r();
    }

    public final void k(Context context) {
        this.f77336j = getResources().getColor(R$color.color_black);
        this.f77337k = getResources().getColor(R$color.color_flat);
        this.f77342p = NightHelper.e().g();
        this.f77328b = PixelUtils.a(80.0f);
        if (this.f77342p) {
            this.f77341o = new BlurMaskFilter(getResources().getDimension(R$dimen.dimen_20), BlurMaskFilter.Blur.SOLID);
        }
        this.f77340n = context.getString(R$string.cny_pre_symbol);
    }

    public final void o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LiteTradingView);
        this.f77338l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LiteTradingView_strokeWidth, 1);
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<Double> list = this.f77339m;
        if (list == null || list.size() == 0) {
            f(canvas);
        } else if (this.f77339m.size() >= this.f77330d) {
            g(canvas);
        } else {
            f(canvas);
            g(canvas);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode == 1073741824 && this.f77328b <= 0) {
            this.f77328b = size;
        } else if (mode == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Width must be EXACTLY");
        }
        if (mode2 == 1073741824) {
            this.f77331e = size2;
        } else if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Height must be EXACTLY");
        }
        setMeasuredDimension(this.f77328b, this.f77331e);
    }

    public final void p() {
        this.f77334h.reset();
        this.f77335i.reset();
        this.f77329c = 0;
    }

    public final void q() {
        if (this.f77333g == null) {
            this.f77333g = new Paint(1);
        }
        this.f77338l = PixelUtils.a(1.5f);
        this.f77333g.setAntiAlias(true);
        this.f77333g.setStyle(Paint.Style.STROKE);
        this.f77333g.setStrokeWidth((float) this.f77338l);
        this.f77333g.setColor(this.f77337k);
        this.f77333g.setStrokeJoin(Paint.Join.ROUND);
        this.f77333g.setMaskFilter((MaskFilter) null);
        this.f77333g.setPathEffect(new DashPathEffect(new float[]{(float) PixelUtils.a(10.89f), (float) PixelUtils.a(1.3f)}, 0.0f));
    }

    public final void r() {
        if (this.f77332f == null) {
            this.f77332f = new Paint();
        }
        this.f77338l = PixelUtils.a(1.5f);
        this.f77332f.setAntiAlias(true);
        this.f77332f.setStyle(Paint.Style.STROKE);
        this.f77332f.setStrokeWidth((float) this.f77338l);
        this.f77332f.setColor(this.f77336j);
        this.f77332f.setStrokeJoin(Paint.Join.ROUND);
        this.f77332f.setPathEffect(new CornerPathEffect(5.0f));
        this.f77332f.setMaskFilter((MaskFilter) null);
    }

    public void s(List<Double> list) {
        this.f77339m = list;
        post(new i(this, list));
    }

    public void setColor(int i11) {
        this.f77336j = i11;
    }

    public void setCurrencySymbol(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f77340n = str;
        }
    }

    public void setData(List<String> list) {
        if (list == null || list.size() == 0) {
            u();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String h11 : list) {
            arrayList.add(Double.valueOf(h(h11)));
        }
        if (arrayList.size() >= this.f77330d) {
            t(arrayList);
        } else {
            s(arrayList);
        }
    }

    public void t(List<Double> list) {
        this.f77339m = list;
        post(new j(this, list));
    }

    public void u() {
        post(new h(this));
    }

    public TradingCurveView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77329c = 0;
        this.f77330d = 24;
        this.f77334h = new Path();
        this.f77335i = new Path();
        i(context, attributeSet);
    }
}
