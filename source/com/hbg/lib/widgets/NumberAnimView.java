package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import i6.d;
import java.math.BigDecimal;

public class NumberAnimView extends View implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71550b;

    /* renamed from: c  reason: collision with root package name */
    public BigDecimal f71551c;

    /* renamed from: d  reason: collision with root package name */
    public BigDecimal f71552d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71553e;

    /* renamed from: f  reason: collision with root package name */
    public int f71554f;

    /* renamed from: g  reason: collision with root package name */
    public b f71555g;

    /* renamed from: h  reason: collision with root package name */
    public int f71556h;

    /* renamed from: i  reason: collision with root package name */
    public int f71557i;

    /* renamed from: j  reason: collision with root package name */
    public long f71558j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71559k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f71560l;

    /* renamed from: m  reason: collision with root package name */
    public int f71561m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f71562n;

    /* renamed from: o  reason: collision with root package name */
    public String f71563o;

    /* renamed from: p  reason: collision with root package name */
    public String f71564p;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            NumberAnimView numberAnimView = NumberAnimView.this;
            int unused = numberAnimView.f71554f = numberAnimView.f71557i;
            boolean unused2 = NumberAnimView.this.f71553e = false;
            NumberAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = NumberAnimView.this.f71553e = true;
            NumberAnimView.this.invalidate();
        }
    }

    public interface b {
        String a(String str);
    }

    public NumberAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        if (!TextUtils.isEmpty(this.f71564p) && this.f71551c != null) {
            d.i("num=" + this.f71551c.toPlainString() + " text=" + this.f71564p);
        }
    }

    public void f() {
        postDelayed(new i1(this), this.f71558j + 100);
        this.f71562n = this.f71551c.divide(new BigDecimal(this.f71557i), this.f71561m);
        if (!this.f71553e) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, this.f71557i});
            ofInt.addListener(new a());
            ofInt.addUpdateListener(this);
            ofInt.setDuration(this.f71558j);
            ofInt.start();
        }
    }

    public Paint getPaint() {
        return this.f71550b;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f71554f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f71552d = new BigDecimal(this.f71554f);
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r1 = r4.f71552d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            java.math.BigDecimal r0 = r4.f71551c
            if (r0 == 0) goto L_0x0026
            int r1 = r4.f71554f
            int r2 = r4.f71557i
            if (r1 != r2) goto L_0x0012
            java.lang.String r0 = r0.toPlainString()
            goto L_0x0028
        L_0x0012:
            java.math.BigDecimal r0 = r4.f71562n
            if (r0 == 0) goto L_0x0023
            java.math.BigDecimal r1 = r4.f71552d
            if (r1 == 0) goto L_0x0023
            java.math.BigDecimal r0 = r0.multiply(r1)
            java.lang.String r0 = r0.toPlainString()
            goto L_0x0028
        L_0x0023:
            java.lang.String r0 = "--"
            goto L_0x0028
        L_0x0026:
            java.lang.String r0 = r4.f71563o
        L_0x0028:
            com.hbg.lib.widgets.NumberAnimView$b r1 = r4.f71555g
            if (r1 == 0) goto L_0x0030
            java.lang.String r0 = r1.a(r0)
        L_0x0030:
            boolean r1 = r4.f71559k
            if (r1 != 0) goto L_0x0038
            boolean r1 = r4.f71560l
            if (r1 == 0) goto L_0x005e
        L_0x0038:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            if (r1 == 0) goto L_0x005e
            boolean r2 = r4.f71559k
            if (r2 == 0) goto L_0x004f
            android.graphics.Paint r2 = r4.f71550b
            float r2 = r2.measureText(r0)
            int r2 = (int) r2
            int r3 = r1.width
            if (r3 == r2) goto L_0x004f
            r1.width = r2
        L_0x004f:
            boolean r2 = r4.f71560l
            if (r2 == 0) goto L_0x005b
            int r2 = r1.height
            int r3 = r4.f71556h
            if (r2 == r3) goto L_0x005b
            r1.height = r3
        L_0x005b:
            r4.setLayoutParams(r1)
        L_0x005e:
            r1 = 0
            int r2 = r4.getHeight()
            int r2 = r2 / 2
            int r3 = r4.f71556h
            int r3 = r3 / 3
            int r2 = r2 + r3
            float r2 = (float) r2
            android.graphics.Paint r3 = r4.f71550b
            r5.drawText(r0, r1, r2, r3)
            r4.f71564p = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.NumberAnimView.onDraw(android.graphics.Canvas):void");
    }

    public void setCallback(b bVar) {
        this.f71555g = bVar;
    }

    public void setDuration(long j11) {
        this.f71558j = j11;
    }

    public void setMaxCount(int i11) {
        this.f71557i = i11;
    }

    public void setNeedResizeHeight(boolean z11) {
        this.f71560l = z11;
    }

    public void setNeedResizeWidth(boolean z11) {
        this.f71559k = z11;
    }

    public void setNumber(BigDecimal bigDecimal) {
        this.f71551c = bigDecimal;
        if (!this.f71553e) {
            this.f71554f = this.f71557i;
            invalidate();
        }
    }

    public void setRoundingMode(int i11) {
        this.f71561m = i11;
    }

    public void setText(String str) {
        this.f71563o = str;
        this.f71551c = null;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f71550b.setColor(i11);
    }

    public void setTextSize(int i11) {
        this.f71556h = i11;
        this.f71550b.setTextSize((float) i11);
    }

    public NumberAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f71550b = paint;
        this.f71551c = BigDecimal.ZERO;
        this.f71554f = 1;
        this.f71557i = 50;
        this.f71558j = 500;
        this.f71559k = true;
        this.f71560l = true;
        this.f71561m = 2;
        paint.setAntiAlias(true);
        paint.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
    }
}
