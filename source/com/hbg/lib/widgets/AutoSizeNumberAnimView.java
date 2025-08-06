package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import i6.d;
import i6.m;
import java.math.BigDecimal;

public class AutoSizeNumberAnimView extends View implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public int f71001b;

    /* renamed from: c  reason: collision with root package name */
    public int f71002c;

    /* renamed from: d  reason: collision with root package name */
    public int f71003d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71004e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f71005f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f71006g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f71007h;

    /* renamed from: i  reason: collision with root package name */
    public String f71008i;

    /* renamed from: j  reason: collision with root package name */
    public int f71009j;

    /* renamed from: k  reason: collision with root package name */
    public long f71010k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f71011l;

    /* renamed from: m  reason: collision with root package name */
    public int f71012m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f71013n;

    /* renamed from: o  reason: collision with root package name */
    public BigDecimal f71014o;

    /* renamed from: p  reason: collision with root package name */
    public int f71015p;

    /* renamed from: q  reason: collision with root package name */
    public BigDecimal f71016q;

    /* renamed from: r  reason: collision with root package name */
    public String f71017r;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            AutoSizeNumberAnimView autoSizeNumberAnimView = AutoSizeNumberAnimView.this;
            int unused = autoSizeNumberAnimView.f71012m = autoSizeNumberAnimView.f71009j;
            boolean unused2 = AutoSizeNumberAnimView.this.f71011l = false;
            AutoSizeNumberAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = AutoSizeNumberAnimView.this.f71011l = true;
            AutoSizeNumberAnimView.this.invalidate();
        }
    }

    public AutoSizeNumberAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (!TextUtils.isEmpty(this.f71008i) && this.f71013n != null) {
            d.i("num=" + this.f71013n.toPlainString() + " text=" + this.f71008i);
        }
    }

    public final Bitmap e(Context context, int i11) {
        if (Build.VERSION.SDK_INT <= 21) {
            return BitmapFactory.decodeResource(context.getResources(), i11);
        }
        Drawable drawable = context.getDrawable(i11);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public void g() {
        postDelayed(new b(this), this.f71010k + 100);
        this.f71016q = this.f71013n.divide(new BigDecimal(this.f71009j), this.f71015p);
        if (!this.f71011l) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, this.f71009j});
            ofInt.addListener(new a());
            ofInt.addUpdateListener(this);
            ofInt.setDuration(this.f71010k);
            ofInt.start();
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f71012m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f71014o = new BigDecimal(this.f71012m);
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r1 = r6.f71014o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            super.onDraw(r7)
            java.math.BigDecimal r0 = r6.f71013n
            if (r0 == 0) goto L_0x0026
            int r1 = r6.f71012m
            int r2 = r6.f71009j
            if (r1 != r2) goto L_0x0012
            java.lang.String r0 = r0.toPlainString()
            goto L_0x0028
        L_0x0012:
            java.math.BigDecimal r0 = r6.f71016q
            if (r0 == 0) goto L_0x0023
            java.math.BigDecimal r1 = r6.f71014o
            if (r1 == 0) goto L_0x0023
            java.math.BigDecimal r0 = r0.multiply(r1)
            java.lang.String r0 = r0.toPlainString()
            goto L_0x0028
        L_0x0023:
            java.lang.String r0 = "--"
            goto L_0x0028
        L_0x0026:
            java.lang.String r0 = r6.f71017r
        L_0x0028:
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x008c
            int r2 = r6.f71002c
        L_0x0035:
            android.graphics.Paint r3 = r6.f71005f
            float r4 = (float) r2
            r3.setTextSize(r4)
            android.graphics.Paint r3 = r6.f71005f
            float r3 = r3.measureText(r0)
            int r3 = (int) r3
            int r4 = r6.f71001b
            if (r3 <= r4) goto L_0x004e
            int r4 = r6.f71003d
            if (r2 > r4) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            int r2 = r2 + -1
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onDraw: measureLen："
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "AutoSizeNumberAnimView"
            android.util.Log.d(r5, r4)
            boolean r4 = r6.f71004e
            if (r4 == 0) goto L_0x006b
            android.graphics.Bitmap r4 = r6.f71006g
            goto L_0x006d
        L_0x006b:
            android.graphics.Bitmap r4 = r6.f71007h
        L_0x006d:
            int r4 = r4.getWidth()
            int r4 = r4 * 3
            int r4 = r4 + r3
            r1.width = r4
            r6.setLayoutParams(r1)
            r1 = 0
            int r4 = r6.getHeight()
            int r4 = r4 / 2
            int r2 = r2 / 3
            int r4 = r4 + r2
            float r2 = (float) r4
            android.graphics.Paint r4 = r6.f71005f
            r7.drawText(r0, r1, r2, r4)
            r6.f71008i = r0
            r2 = r3
        L_0x008c:
            int r0 = r6.getHeight()
            int r0 = r0 / 2
            float r0 = (float) r0
            boolean r1 = r6.f71004e
            if (r1 == 0) goto L_0x00af
            android.graphics.Bitmap r1 = r6.f71006g
            int r1 = r1.getHeight()
            int r1 = r1 / 2
            float r1 = (float) r1
            float r0 = r0 - r1
            android.graphics.Bitmap r1 = r6.f71006g
            int r3 = r1.getWidth()
            int r2 = r2 + r3
            float r2 = (float) r2
            android.graphics.Paint r3 = r6.f71005f
            r7.drawBitmap(r1, r2, r0, r3)
            goto L_0x00c8
        L_0x00af:
            android.graphics.Bitmap r1 = r6.f71007h
            int r1 = r1.getHeight()
            int r1 = r1 / 2
            float r1 = (float) r1
            float r0 = r0 - r1
            android.graphics.Bitmap r1 = r6.f71007h
            android.graphics.Bitmap r3 = r6.f71006g
            int r3 = r3.getWidth()
            int r2 = r2 + r3
            float r2 = (float) r2
            android.graphics.Paint r3 = r6.f71005f
            r7.drawBitmap(r1, r2, r0, r3)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.AutoSizeNumberAnimView.onDraw(android.graphics.Canvas):void");
    }

    public void setDefaultMinTextSize(int i11) {
        this.f71003d = i11;
    }

    public void setDefaultTextSize(int i11) {
        this.f71002c = i11;
        this.f71005f.setTextSize((float) i11);
    }

    public void setMaxTextLength(int i11) {
        this.f71001b = i11;
    }

    public void setOpenEyes(boolean z11) {
        this.f71004e = z11;
        invalidate();
    }

    public void setText(String str) {
        this.f71017r = str;
        this.f71013n = null;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f71005f.setColor(i11);
    }

    public void setTextValue(String str) {
        this.f71013n = m.a(str);
        invalidate();
    }

    public AutoSizeNumberAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f71005f = paint;
        this.f71009j = 50;
        this.f71010k = 500;
        this.f71012m = 1;
        this.f71013n = BigDecimal.ZERO;
        this.f71015p = 2;
        paint.setAntiAlias(true);
        paint.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        this.f71006g = e(context, R$drawable.wallet_icon_invisible_selected);
        this.f71007h = e(context, R$drawable.wallet_icon_invisible);
        this.f71002c = getResources().getDimensionPixelOffset(R$dimen.global_text_size_24);
        this.f71003d = getResources().getDimensionPixelOffset(R$dimen.global_text_size_12);
        this.f71001b = getResources().getDimensionPixelOffset(R$dimen.dimen_170);
    }
}
