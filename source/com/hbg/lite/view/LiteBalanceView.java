package com.hbg.lite.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lite.R$color;
import i6.m;
import java.math.BigDecimal;

public class LiteBalanceView extends View implements ValueAnimator.AnimatorUpdateListener {
    public b A;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f77563b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f77564c;

    /* renamed from: d  reason: collision with root package name */
    public int f77565d;

    /* renamed from: e  reason: collision with root package name */
    public int f77566e;

    /* renamed from: f  reason: collision with root package name */
    public int f77567f;

    /* renamed from: g  reason: collision with root package name */
    public String f77568g;

    /* renamed from: h  reason: collision with root package name */
    public String f77569h;

    /* renamed from: i  reason: collision with root package name */
    public int f77570i;

    /* renamed from: j  reason: collision with root package name */
    public int f77571j;

    /* renamed from: k  reason: collision with root package name */
    public int f77572k;

    /* renamed from: l  reason: collision with root package name */
    public int f77573l;

    /* renamed from: m  reason: collision with root package name */
    public float f77574m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f77575n;

    /* renamed from: o  reason: collision with root package name */
    public BigDecimal f77576o;

    /* renamed from: p  reason: collision with root package name */
    public BigDecimal f77577p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f77578q;

    /* renamed from: r  reason: collision with root package name */
    public int f77579r;

    /* renamed from: s  reason: collision with root package name */
    public int f77580s;

    /* renamed from: t  reason: collision with root package name */
    public long f77581t;

    /* renamed from: u  reason: collision with root package name */
    public BigDecimal f77582u;

    /* renamed from: v  reason: collision with root package name */
    public BigDecimal f77583v;

    /* renamed from: w  reason: collision with root package name */
    public String f77584w;

    /* renamed from: x  reason: collision with root package name */
    public String f77585x;

    /* renamed from: y  reason: collision with root package name */
    public String f77586y;

    /* renamed from: z  reason: collision with root package name */
    public String f77587z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            LiteBalanceView liteBalanceView = LiteBalanceView.this;
            int unused = liteBalanceView.f77579r = liteBalanceView.f77580s;
            boolean unused2 = LiteBalanceView.this.f77578q = false;
            LiteBalanceView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = LiteBalanceView.this.f77578q = true;
            LiteBalanceView.this.invalidate();
        }
    }

    public interface b {
        String a(String str);

        String b(String str);
    }

    public LiteBalanceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getConvertMarginEnd() {
        return this.f77570i;
    }

    public final void d() {
        this.f77563b.setTextSize((float) this.f77565d);
        String str = this.f77586y;
        if (str != null) {
            this.f77574m = this.f77563b.measureText(str);
        }
        float f11 = 0.0f;
        String str2 = this.f77587z;
        if (str2 != null) {
            f11 = this.f77564c.measureText(str2);
        }
        if (((float) this.f77571j) + this.f77574m + f11 + ((float) getConvertMarginEnd()) > ((float) getWidth()) && g()) {
            d();
        }
    }

    public final void e(Canvas canvas) {
        BigDecimal bigDecimal;
        String str = this.f77584w;
        this.f77563b.setColor(this.f77566e);
        String str2 = this.f77568g;
        if (!(str2 == null || this.f77575n == null)) {
            if (this.f77579r == this.f77580s) {
                str = str2;
            } else {
                BigDecimal bigDecimal2 = this.f77582u;
                if (!(bigDecimal2 == null || (bigDecimal = this.f77577p) == null)) {
                    str = bigDecimal2.multiply(bigDecimal).toPlainString();
                }
            }
        }
        b bVar = this.A;
        if (bVar != null) {
            str = bVar.a(str);
        }
        this.f77586y = str;
    }

    public final void f(Canvas canvas) {
        BigDecimal bigDecimal;
        String str = this.f77585x;
        this.f77564c.setColor(this.f77567f);
        String str2 = this.f77569h;
        if (!(str2 == null || this.f77576o == null)) {
            if (this.f77579r == this.f77580s) {
                str = str2;
            } else {
                BigDecimal bigDecimal2 = this.f77583v;
                if (!(bigDecimal2 == null || (bigDecimal = this.f77577p) == null)) {
                    str = bigDecimal2.multiply(bigDecimal).toPlainString();
                }
            }
        }
        b bVar = this.A;
        if (bVar != null) {
            str = bVar.b(str);
        }
        this.f77587z = str;
    }

    public final boolean g() {
        int a11 = this.f77565d - PixelUtils.a(1.0f);
        this.f77565d = a11;
        setTextSize(a11);
        return this.f77565d >= PixelUtils.a(20.0f);
    }

    public void h() {
        this.f77582u = this.f77575n.divide(new BigDecimal(this.f77580s), 1);
        this.f77583v = this.f77576o.divide(new BigDecimal(this.f77580s), 1);
        if (!this.f77578q) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, this.f77580s});
            ofInt.addListener(new a());
            ofInt.addUpdateListener(this);
            ofInt.setDuration(this.f77581t);
            ofInt.start();
        }
    }

    public void i() {
        invalidate();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f77579r = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f77577p = new BigDecimal(this.f77579r);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f77565d = this.f77573l;
        e(canvas);
        f(canvas);
        d();
        canvas.drawText(this.f77586y, (float) this.f77571j, (float) ((getHeight() / 2) + (this.f77565d / 2)), this.f77563b);
        canvas.drawText(this.f77587z, this.f77574m + ((float) this.f77571j), (float) ((getHeight() / 2) + (this.f77565d / 2)), this.f77564c);
        if (this.f77578q) {
            invalidate();
        }
    }

    public void setBalance(String str) {
        this.f77568g = str;
        this.f77575n = m.a(str);
        if (!this.f77578q) {
            this.f77579r = this.f77580s;
        }
    }

    public void setBalanceText(String str) {
        this.f77584w = str;
        this.f77575n = null;
    }

    public void setCallBack(b bVar) {
        this.A = bVar;
    }

    public void setConvert(String str) {
        this.f77569h = str;
        this.f77576o = m.a(str);
        if (!this.f77578q) {
            this.f77579r = this.f77580s;
        }
    }

    public void setConvertText(String str) {
        this.f77585x = str;
        this.f77576o = null;
    }

    public void setTextSize(int i11) {
        this.f77565d = i11;
    }

    public LiteBalanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f77563b = paint;
        Paint paint2 = new Paint();
        this.f77564c = paint2;
        BigDecimal bigDecimal = BigDecimal.ZERO;
        this.f77575n = bigDecimal;
        this.f77576o = bigDecimal;
        this.f77579r = 1;
        this.f77580s = 50;
        this.f77581t = 500;
        this.f77584w = "--";
        this.f77585x = "--";
        Context context2 = getContext();
        int i12 = R$color.baseTextColor;
        this.f77566e = ContextCompat.getColor(context2, i12);
        this.f77567f = ContextCompat.getColor(getContext(), i12);
        int a11 = PixelUtils.a(45.0f);
        this.f77573l = a11;
        this.f77565d = a11;
        this.f77572k = PixelUtils.a(14.0f);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        paint2.setTextAlign(Paint.Align.LEFT);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f77567f);
        paint2.setTextSize((float) this.f77572k);
        paint.setTextAlign(Paint.Align.LEFT);
        paint2.setTextAlign(Paint.Align.LEFT);
    }
}
