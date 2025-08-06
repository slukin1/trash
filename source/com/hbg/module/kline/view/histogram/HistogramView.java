package com.hbg.module.kline.view.histogram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.hbg.lib.core.util.p;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$styleable;

public class HistogramView extends AbsChartView {
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f24480a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f24481b0;

    /* renamed from: c0  reason: collision with root package name */
    public float f24482c0;

    /* renamed from: d0  reason: collision with root package name */
    public a f24483d0;

    /* renamed from: e0  reason: collision with root package name */
    public Paint f24484e0;

    /* renamed from: f0  reason: collision with root package name */
    public Drawable f24485f0;

    /* renamed from: g0  reason: collision with root package name */
    public Rect f24486g0;

    /* renamed from: h0  reason: collision with root package name */
    public int f24487h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f24488i0;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Paint f24489a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f24490b;

        /* renamed from: c  reason: collision with root package name */
        public Paint f24491c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f24492d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f24493e;

        public a() {
            this.f24489a = HistogramView.this.m(HistogramView.this.R);
            this.f24490b = HistogramView.this.m(HistogramView.this.T);
            this.f24491c = HistogramView.this.m(HistogramView.this.R);
            this.f24492d = HistogramView.this.m(-7829368);
            Paint m11 = HistogramView.this.m(HistogramView.this.f24420u);
            this.f24493e = m11;
            m11.setTextSize(HistogramView.this.f24421v);
        }
    }

    public HistogramView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void z(Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HistogramView, i11, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i13 = 0; i13 < indexCount; i13++) {
            int index = obtainStyledAttributes.getIndex(i13);
            if (index == R$styleable.HistogramView_histogram_width_percent) {
                this.f24482c0 = obtainStyledAttributes.getFloat(index, 0.5f);
            } else if (index == R$styleable.HistogramView_histogram_positive_bottom_color) {
                this.S = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_positive_top_color) {
                this.R = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_negative_bottom_color) {
                this.U = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_negative_top_color) {
                this.T = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_negative_bottom_color) {
                this.f24481b0 = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_negative_top_color) {
                this.f24480a0 = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_positive_bottom_color) {
                this.W = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_positive_top_color) {
                this.V = obtainStyledAttributes.getColor(index, -7829368);
            }
        }
        obtainStyledAttributes.recycle();
        this.f24483d0 = new a();
        Paint paint = new Paint();
        this.f24484e0 = paint;
        paint.setTextSize((float) O(10.0f));
        this.f24484e0.setColor(-7829368);
        this.f24486g0 = new Rect();
        this.f24487h0 = 0;
        this.f24488i0 = O(12.0f);
        if (!p.h(context) || p.i(context)) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.kline_water_remark, typedValue, true);
            this.f24485f0 = getResources().getDrawable(typedValue.resourceId);
        } else {
            this.f24485f0 = getResources().getDrawable(R$drawable.kline_water_logo_zh_cn);
        }
        Drawable drawable = this.f24485f0;
        if (drawable != null) {
            this.f24486g0.set(0, 0, drawable.getIntrinsicWidth(), this.f24485f0.getIntrinsicHeight());
            this.f24485f0.setBounds(this.f24486g0);
        }
        Q();
    }

    public boolean C(int i11, int i12) {
        return false;
    }

    public void E(Canvas canvas) {
        float f11;
        float f12;
        char c11;
        int i11;
        String str;
        String str2;
        Paint paint;
        ge.a aVar;
        String str3;
        String str4;
        Paint paint2;
        Canvas canvas2 = canvas;
        float cellWidth = getCellWidth();
        float zeroLine = getZeroLine();
        P(canvas);
        canvas.save();
        canvas2.translate(this.f24410k, (this.f24412m - this.f24411l) - zeroLine);
        String str5 = "GxqHistogramView";
        Log.d(str5, "mOriginalX: " + this.f24410k + " mHeight : " + this.f24412m + " mOriginalY: " + this.f24411l + " baseLine:" + zeroLine);
        char c12 = 0;
        float f13 = ((1.0f - this.f24482c0) * cellWidth) / 2.0f;
        float l11 = l() / ((float) getCount());
        float l12 = l();
        int i12 = 0;
        while (i12 < getCount()) {
            ge.a t11 = t(i12);
            if (t11 == null) {
                i11 = i12;
                f11 = cellWidth;
                f12 = zeroLine;
                str = str5;
                c11 = c12;
            } else {
                float f14 = -(q(i12) - zeroLine);
                if (t11.f25271b >= 0.0f) {
                    if (getCurrentSelectIndex() != i12 || !getAllowDrawSelectedTap()) {
                        str4 = " mSpace:";
                        str3 = " mRect.height():";
                        aVar = t11;
                        float f15 = f14;
                        this.f24483d0.f24489a.setShader(new LinearGradient((((float) i12) * cellWidth) + f13, f15, (((float) (i12 + 1)) * cellWidth) - f13, 0.0f, this.R, this.S, Shader.TileMode.CLAMP));
                        paint2 = this.f24483d0.f24489a;
                    } else {
                        str4 = " mSpace:";
                        str3 = " mRect.height():";
                        aVar = t11;
                        float f16 = f14;
                        this.f24483d0.f24491c.setShader(new LinearGradient((((float) i12) * cellWidth) + f13, f16, (((float) (i12 + 1)) * cellWidth) - f13, 0.0f, this.V, this.W, Shader.TileMode.CLAMP));
                        paint2 = this.f24483d0.f24491c;
                    }
                    float f17 = (float) i12;
                    float f18 = (cellWidth * f17) + f13;
                    String str6 = str4;
                    String str7 = str3;
                    float f19 = f14;
                    f12 = zeroLine;
                    float f21 = f14;
                    float f22 = (((float) (i12 + 1)) * cellWidth) - f13;
                    f11 = cellWidth;
                    ge.a aVar2 = aVar;
                    int i13 = i12;
                    canvas.drawRect(f18, f19, f22, 0.0f, paint2);
                    String y11 = y(aVar2.f25271b);
                    this.f24483d0.f24493e.getTextBounds(y11, 0, y11.length(), this.f24407h);
                    float width = ((f17 + this.J) * l11) - (((float) this.f24407h.width()) / 2.0f);
                    if (((float) this.f24407h.width()) + width > l12) {
                        width = l12 - ((float) this.f24407h.width());
                    }
                    if (width < 0.0f) {
                        width = 0.0f;
                    }
                    this.f24483d0.f24493e.setColor(this.R);
                    c11 = 0;
                    canvas2.drawText(y11, width, f21 - (((float) this.f24407h.height()) / 2.0f), this.f24483d0.f24493e);
                    Log.d(str5, "data: " + aVar2 + " top : " + f21 + " space: " + f13 + str6 + this.f24414o + str7 + this.f24407h.height());
                    str = str5;
                    i11 = i13;
                } else {
                    int i14 = i12;
                    f11 = cellWidth;
                    f12 = zeroLine;
                    c11 = 0;
                    String str8 = " mSpace:";
                    float f23 = f14;
                    ge.a aVar3 = t11;
                    String str9 = " mRect.height():";
                    int i15 = i14;
                    if (getCurrentSelectIndex() != i15 || !getAllowDrawSelectedTap()) {
                        str2 = str9;
                        this.f24483d0.f24490b.setShader(new LinearGradient((((float) i15) * f11) + f13, 0.0f, (((float) (i15 + 1)) * f11) - f13, f23, this.T, this.U, Shader.TileMode.CLAMP));
                        paint = this.f24483d0.f24490b;
                    } else {
                        str2 = str9;
                        this.f24483d0.f24492d.setShader(new LinearGradient((((float) i15) * f11) + f13, 0.0f, (((float) (i15 + 1)) * f11) - f13, f23, this.f24480a0, this.f24481b0, Shader.TileMode.CLAMP));
                        paint = this.f24483d0.f24492d;
                    }
                    float f24 = (float) i15;
                    i11 = i15;
                    String str10 = str2;
                    String str11 = str5;
                    String str12 = str8;
                    canvas.drawRect((f11 * f24) + f13, 0.0f, (((float) (i15 + 1)) * f11) - f13, f23, paint);
                    String y12 = y(aVar3.f25271b);
                    this.f24483d0.f24493e.getTextBounds(y12, 0, y12.length(), this.f24407h);
                    float width2 = ((f24 + this.J) * l11) - ((float) (this.f24407h.width() / 2));
                    if (((float) this.f24407h.width()) + width2 > l12) {
                        width2 = l12 - ((float) this.f24407h.width());
                    }
                    if (width2 < 0.0f) {
                        width2 = 0.0f;
                    }
                    this.f24483d0.f24493e.setColor(this.U);
                    canvas2.drawText(y12, width2, f23 + (((float) this.f24407h.height()) * 1.5f), this.f24483d0.f24493e);
                    str = str11;
                    Log.d(str, "data: " + aVar3 + " bottom : " + f23 + " space: " + f13 + str12 + this.f24414o + str10 + this.f24407h.height());
                    i12 = i11 + 1;
                    str5 = str;
                    c12 = c11;
                    zeroLine = f12;
                    cellWidth = f11;
                }
            }
            i12 = i11 + 1;
            str5 = str;
            c12 = c11;
            zeroLine = f12;
            cellWidth = f11;
        }
        canvas.restore();
    }

    public void I(Canvas canvas) {
    }

    public void J(Canvas canvas, int i11, float f11, float f12, float f13) {
    }

    public final int O(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void P(Canvas canvas) {
        if (this.f24485f0 != null) {
            canvas.save();
            canvas.translate((float) this.f24487h0, (float) ((getHeight() - this.f24486g0.height()) - this.f24488i0));
            this.f24485f0.draw(canvas);
            canvas.restore();
        }
    }

    public final void Q() {
        if (this.V == -1) {
            this.V = this.R;
        }
        if (this.W == -1) {
            this.W = this.S;
        }
        if (this.f24480a0 == -1) {
            this.f24480a0 = this.T;
        }
        if (this.f24481b0 == -1) {
            this.f24481b0 = this.U;
        }
    }

    public void setFallColor(int i11) {
        this.T = i11;
        this.U = i11;
    }

    public void setRiseColor(int i11) {
        this.R = i11;
        this.S = i11;
    }

    public HistogramView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.R = -7829368;
        this.S = -7829368;
        this.T = -7829368;
        this.U = -7829368;
        this.V = -1;
        this.W = -1;
        this.f24480a0 = -1;
        this.f24481b0 = -1;
        this.f24482c0 = 0.5f;
        z(context, attributeSet, i11, 0);
    }
}
