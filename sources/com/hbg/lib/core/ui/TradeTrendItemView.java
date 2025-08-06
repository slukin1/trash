package com.hbg.lib.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$dimen;
import com.hbg.lib.core.R$font;
import com.hbg.lib.widgets.SubscriptHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.regex.Matcher;
import k6.c;

public class TradeTrendItemView extends View implements View.OnClickListener {
    public boolean A;
    public int B;
    public int C;
    public String D;
    public boolean E;
    public int F;
    public float G;
    public final Paint H;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f68594b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f68595c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f68596d;

    /* renamed from: e  reason: collision with root package name */
    public c f68597e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68598f;

    /* renamed from: g  reason: collision with root package name */
    public int f68599g;

    /* renamed from: h  reason: collision with root package name */
    public int f68600h;

    /* renamed from: i  reason: collision with root package name */
    public int f68601i;

    /* renamed from: j  reason: collision with root package name */
    public int f68602j;

    /* renamed from: k  reason: collision with root package name */
    public int f68603k;

    /* renamed from: l  reason: collision with root package name */
    public int f68604l;

    /* renamed from: m  reason: collision with root package name */
    public String f68605m;

    /* renamed from: n  reason: collision with root package name */
    public String f68606n;

    /* renamed from: o  reason: collision with root package name */
    public String f68607o;

    /* renamed from: p  reason: collision with root package name */
    public String f68608p;

    /* renamed from: q  reason: collision with root package name */
    public Paint.FontMetrics f68609q;

    /* renamed from: r  reason: collision with root package name */
    public String f68610r;

    /* renamed from: s  reason: collision with root package name */
    public final Rect f68611s;

    /* renamed from: t  reason: collision with root package name */
    public float f68612t;

    /* renamed from: u  reason: collision with root package name */
    public int f68613u;

    /* renamed from: v  reason: collision with root package name */
    public int f68614v;

    /* renamed from: w  reason: collision with root package name */
    public int f68615w;

    /* renamed from: x  reason: collision with root package name */
    public final float f68616x;

    /* renamed from: y  reason: collision with root package name */
    public final int f68617y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f68618z;

    public TradeTrendItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getAmountMarginEnd() {
        return this.E ? this.f68615w : this.f68613u;
    }

    public final void a() {
        this.f68596d.setTextSize((float) this.f68599g);
        this.f68595c.setTextSize((float) this.f68599g);
        this.H.setTextSize(((float) this.f68599g) * 0.8f);
        float f11 = 0.0f;
        this.G = 0.0f;
        String str = this.f68605m;
        if (str != null) {
            String str2 = this.f68606n;
            if (str2 != null) {
                this.G = this.f68595c.measureText(str2) + this.H.measureText(this.f68608p) + this.f68595c.measureText(this.f68607o);
            } else {
                this.G = this.f68595c.measureText(str);
            }
        }
        float f12 = this.f68618z ? ((float) this.f68617y) + this.f68616x : 0.0f;
        String str3 = this.f68610r;
        float measureText = str3 != null ? this.f68596d.measureText(str3) : 0.0f;
        if (this.E && !TextUtils.isEmpty(this.D)) {
            f11 = this.f68596d.measureText(this.D);
        }
        if (((float) this.f68614v) + this.G + f12 + measureText + ((float) getAmountMarginEnd()) + f11 > ((float) getWidth()) && h()) {
            a();
        }
    }

    public final void b(Canvas canvas) {
        int i11;
        this.f68596d.setColor(this.f68603k);
        if (this.f68610r != null) {
            if (g()) {
                i11 = getWidth() - getAmountMarginEnd();
            } else {
                i11 = getAmountMarginEnd();
            }
            canvas.drawText(this.f68610r, (float) i11, (float) ((getHeight() / 2) + (this.f68599g / 2)), this.f68596d);
        }
    }

    public final void c(Canvas canvas) {
        if (this.A) {
            this.f68594b.setColor(this.f68601i);
            this.f68611s.set(0, 0, getWidth(), getHeight());
            canvas.drawRect(this.f68611s, this.f68594b);
            return;
        }
        this.f68594b.setColor(this.f68600h);
        if (this.C == 0) {
            this.f68611s.set(0, 0, (int) (((float) getWidth()) * this.f68612t), getHeight());
        } else {
            this.f68611s.set((int) (((float) getWidth()) * (1.0f - this.f68612t)), 0, getWidth(), getHeight());
        }
        canvas.drawRect(this.f68611s, this.f68594b);
    }

    public final void d(Canvas canvas) {
        if (this.f68618z) {
            float f11 = ((float) this.f68614v) + this.G + ((float) this.f68617y) + (this.f68616x / 2.0f);
            if (!g()) {
                f11 = ((float) getWidth()) - f11;
            }
            float f12 = this.f68616x;
            canvas.drawCircle(f11, ((float) (getHeight() / 2)) + (f12 / 2.0f), f12, this.f68595c);
        }
    }

    public final void e(Canvas canvas) {
        this.f68596d.setColor(this.f68604l);
        if (this.E) {
            float f11 = (float) this.f68613u;
            if (g()) {
                f11 = ((float) getWidth()) - f11;
            }
            String str = this.D;
            if (str != null) {
                canvas.drawText(str, f11, (float) ((getHeight() / 2) + (this.f68599g / 2)), this.f68596d);
            }
        }
    }

    public final void f(Canvas canvas) {
        if (this.f68605m != null) {
            this.f68595c.setColor(this.f68602j);
            this.H.setColor(this.f68602j);
            float f11 = (float) this.f68614v;
            if (!g()) {
                f11 = (float) (getWidth() - this.f68614v);
            }
            if (this.f68606n != null) {
                float height = (float) ((getHeight() / 2) + (this.f68599g / 2));
                this.f68595c.getFontMetrics(this.f68609q);
                if (g()) {
                    canvas.drawText(this.f68606n, f11, height, this.f68595c);
                    float measureText = f11 + this.f68595c.measureText(this.f68606n);
                    canvas.drawText(this.f68608p, measureText, this.f68609q.bottom + height, this.H);
                    canvas.drawText(this.f68607o, measureText + this.H.measureText(this.f68608p), height, this.f68595c);
                    return;
                }
                canvas.drawText(this.f68607o, f11, height, this.f68595c);
                float measureText2 = f11 - this.f68595c.measureText(this.f68607o);
                canvas.drawText(this.f68608p, measureText2, this.f68609q.bottom + height, this.H);
                canvas.drawText(this.f68606n, measureText2 - this.H.measureText(this.f68608p), height, this.f68595c);
                return;
            }
            canvas.drawText(this.f68605m, f11, (float) ((getHeight() / 2) + (this.f68599g / 2)), this.f68595c);
        }
    }

    public final boolean g() {
        return this.B == 0;
    }

    public final boolean h() {
        int i11 = this.F - 1;
        this.F = i11;
        setTextSize(PixelUtils.a((float) i11));
        if (this.F >= 8) {
            return true;
        }
        return false;
    }

    public void i() {
        c.a c11;
        c cVar = this.f68597e;
        if (cVar != null && (c11 = cVar.c()) != null) {
            Context context = getContext();
            setBgColor(c11.g(context));
            setSelectedBgColor(c11.d(context));
            setPriceColor(c11.m(context));
            setAlignment(c11.h());
            setProgressAlignment(c11.o());
            setIndex(c11.getIndex());
            setDrawIndex(c11.f());
            setMarginBegin((int) c11.i(context));
            setMarginEnd((int) c11.j(context));
            if (c11.k()) {
                setPrice(c11.b());
                setAmount(c11.n());
                setDrawCircle(c11.c());
                setPercent(c11.l());
            } else {
                setPrice("--");
                setAmount("--");
                setDrawCircle(false);
                setPercent(0.0f);
            }
            invalidate();
        }
    }

    public void j(c cVar) {
        this.f68597e = cVar;
        i();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        c cVar = this.f68597e;
        if (!(cVar == null || cVar.c() == null || !this.f68597e.c().k() || this.f68597e.b() == null)) {
            this.f68597e.b().onCallback(this.f68597e);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.F = 12;
        setTextSize(this.f68598f);
        this.f68595c.setTextAlign(g() ? Paint.Align.LEFT : Paint.Align.RIGHT);
        this.H.setTextAlign(g() ? Paint.Align.LEFT : Paint.Align.RIGHT);
        this.f68596d.setTextAlign(g() ? Paint.Align.RIGHT : Paint.Align.LEFT);
        c(canvas);
        a();
        f(canvas);
        d(canvas);
        e(canvas);
        b(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = true;
            invalidate();
        } else if (action == 1 || action == 3) {
            this.A = false;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAlignment(int i11) {
        this.B = i11;
    }

    public void setAmount(String str) {
        this.f68610r = str;
    }

    public void setAmountColor(int i11) {
        this.f68603k = i11;
    }

    public void setBgColor(int i11) {
        this.f68600h = i11;
    }

    public void setDrawCircle(boolean z11) {
        this.f68618z = z11;
    }

    public void setDrawIndex(boolean z11) {
        this.E = z11;
    }

    public void setIndex(String str) {
        this.D = str;
    }

    public void setIndexColor(int i11) {
        this.f68604l = i11;
    }

    public void setMarginBegin(int i11) {
        this.f68614v = i11;
    }

    public void setMarginEnd(int i11) {
        if (this.E) {
            this.f68615w = i11;
        } else {
            this.f68613u = i11;
        }
    }

    public void setPercent(float f11) {
        this.f68612t = f11;
    }

    public void setPrice(String str) {
        this.f68605m = str;
        this.f68606n = null;
        this.f68607o = null;
        this.f68608p = null;
        if (SubscriptHelper.b()) {
            Matcher matcher = SubscriptHelper.f71611a.matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start();
                int a11 = SubscriptHelper.a(group);
                this.f68606n = this.f68605m.substring(0, start + 2);
                this.f68607o = this.f68605m.substring(start + 1 + a11);
                this.f68608p = String.valueOf(a11);
            }
        }
    }

    public void setPriceColor(int i11) {
        this.f68602j = i11;
    }

    public void setProgressAlignment(int i11) {
        this.C = i11;
    }

    public void setSelectedBgColor(int i11) {
        this.f68601i = i11;
    }

    public void setTextSize(int i11) {
        this.f68599g = i11;
    }

    public TradeTrendItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TradeTrendItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f68594b = new Paint();
        Paint paint = new Paint();
        this.f68595c = paint;
        Paint paint2 = new Paint();
        this.f68596d = paint2;
        this.f68609q = new Paint.FontMetrics();
        this.f68611s = new Rect();
        this.F = 11;
        Paint paint3 = new Paint();
        this.H = paint3;
        setOnClickListener(this);
        this.f68613u = getResources().getDimensionPixelOffset(R$dimen.global_margin_right);
        this.f68615w = getResources().getDimensionPixelOffset(R$dimen.dimen_42);
        this.f68616x = (float) getResources().getDimensionPixelOffset(R$dimen.dimen_2_5);
        this.f68617y = getResources().getDimensionPixelOffset(R$dimen.dimen_3);
        this.f68600h = -2059;
        this.f68602j = ContextCompat.getColor(getContext(), R$color.color_rise);
        int color = ContextCompat.getColor(getContext(), R$color.global_secondary_text_color);
        this.f68603k = color;
        this.f68604l = color;
        int a11 = PixelUtils.a((float) this.F);
        this.f68598f = a11;
        this.f68599g = a11;
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        int i12 = R$font.roboto_regular;
        paint.setTypeface(ResourcesCompat.h(context, i12));
        paint3.setTextAlign(Paint.Align.LEFT);
        paint3.setAntiAlias(true);
        paint3.setTypeface(ResourcesCompat.h(context, i12));
        paint2.setTextAlign(Paint.Align.RIGHT);
        paint2.setTypeface(ResourcesCompat.h(context, i12));
        paint2.setAntiAlias(true);
        paint2.setColor(this.f68603k);
        paint2.setTypeface(ResourcesCompat.h(context, i12));
    }
}
