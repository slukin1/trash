package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.math.BigDecimal;

public class CommonProgressBar extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f71145b;

    /* renamed from: c  reason: collision with root package name */
    public View f71146c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71147d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f71148e;

    /* renamed from: f  reason: collision with root package name */
    public CommonCircleCountView f71149f;

    /* renamed from: g  reason: collision with root package name */
    public float f71150g;

    /* renamed from: h  reason: collision with root package name */
    public int f71151h;

    /* renamed from: i  reason: collision with root package name */
    public int f71152i;

    /* renamed from: j  reason: collision with root package name */
    public double f71153j;

    /* renamed from: k  reason: collision with root package name */
    public double f71154k;

    /* renamed from: l  reason: collision with root package name */
    public int f71155l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71156m;

    /* renamed from: n  reason: collision with root package name */
    public int f71157n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f71158o;

    /* renamed from: p  reason: collision with root package name */
    public int f71159p;

    /* renamed from: q  reason: collision with root package name */
    public a f71160q;

    /* renamed from: r  reason: collision with root package name */
    public int f71161r;

    /* renamed from: s  reason: collision with root package name */
    public double f71162s;

    /* renamed from: t  reason: collision with root package name */
    public String f71163t;

    /* renamed from: u  reason: collision with root package name */
    public int f71164u;

    /* renamed from: v  reason: collision with root package name */
    public int f71165v;

    /* renamed from: w  reason: collision with root package name */
    public int f71166w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f71167x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f71168y;

    public interface a {
        void a(double d11, double d12, double d13);

        void b(float f11);

        void c(boolean z11);
    }

    public CommonProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static BigDecimal c(String str) {
        if (TextUtils.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(str);
        } catch (Exception unused) {
            return BigDecimal.ZERO;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        k(false);
    }

    private int getAvailableWidth() {
        return ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f71164u * 2);
    }

    public final void d(boolean z11) {
        a aVar;
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (this.f71153j > 0.0d) {
            double d11 = this.f71154k;
            if (d11 > 0.0d) {
                bigDecimal = c(String.valueOf(d11)).divide(c(String.valueOf(this.f71153j)), this.f71159p, 1);
            }
        }
        double doubleValue = bigDecimal.doubleValue();
        this.f71162s = doubleValue;
        double max = Math.max(doubleValue, 0.0d);
        this.f71162s = max;
        this.f71162s = Math.min(max, 1.0d);
        if (this.f71156m) {
            String str = c(String.valueOf(this.f71162s)).multiply(c(String.valueOf(100))).intValue() + "%";
            this.f71163t = str;
            this.f71147d.setText(str);
        }
        if (z11 && (aVar = this.f71160q) != null) {
            aVar.a(this.f71162s, this.f71154k, this.f71153j);
        }
    }

    public final boolean e(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        if (x11 < ((float) getPaddingLeft())) {
            i(0.0d, true);
            return false;
        } else if (x11 > ((float) (getWidth() - getPaddingRight()))) {
            i(this.f71153j, true);
            return false;
        } else if (getAvailableWidth() <= 0) {
            i(0.0d, true);
            return false;
        } else {
            i(c(String.valueOf((x11 - ((float) getPaddingLeft())) - ((float) this.f71164u))).divide(c(String.valueOf(getAvailableWidth())), this.f71159p, 1).multiply(c(String.valueOf(this.f71153j))).doubleValue(), true);
            return true;
        }
    }

    public final void f(Context context) {
        int i11;
        if (this.f71158o != null) {
            this.f71148e = new ImageView(context);
            int i12 = this.f71166w;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i12, i12);
            layoutParams.leftMargin = this.f71164u;
            this.f71148e.setImageDrawable(this.f71158o);
            this.f71148e.setLayoutParams(layoutParams);
        }
        this.f71145b = new View(context);
        int i13 = this.f71155l;
        if (i13 == 0) {
            i13 = -1;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i13);
        int i14 = this.f71166w;
        if (i14 > 0) {
            i11 = ((i14 + this.f71165v) - i13) / 2;
            layoutParams2.topMargin = i11;
        } else {
            i11 = 0;
        }
        int i15 = this.f71164u;
        layoutParams2.leftMargin = i15;
        layoutParams2.rightMargin = i15;
        this.f71145b.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f71152i);
        gradientDrawable.setCornerRadius(this.f71150g);
        this.f71145b.setBackground(gradientDrawable);
        addView(this.f71145b);
        this.f71146c = new View(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(0, i13);
        int i16 = this.f71166w;
        if (i16 > 0) {
            layoutParams3.topMargin = ((i16 + this.f71165v) - i13) / 2;
        }
        int i17 = this.f71164u;
        layoutParams3.leftMargin = i17;
        layoutParams3.rightMargin = i17;
        this.f71146c.setLayoutParams(layoutParams3);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(this.f71151h);
        gradientDrawable2.setCornerRadius(this.f71150g);
        this.f71146c.setBackground(gradientDrawable2);
        addView(this.f71146c);
        if (this.f71161r > 0) {
            this.f71149f = new CommonCircleCountView(context);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, i13);
            layoutParams4.topMargin = i11;
            int i18 = this.f71164u;
            layoutParams4.leftMargin = i18;
            layoutParams4.rightMargin = i18;
            this.f71149f.setLayoutParams(layoutParams4);
            this.f71149f.setCount(this.f71161r);
            addView(this.f71149f);
        }
        if (this.f71156m) {
            this.f71147d = new TextView(context);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = i11 + this.f71155l;
            this.f71147d.setLayoutParams(layoutParams5);
            this.f71147d.setTextColor(this.f71151h);
            this.f71147d.setTextSize(1, 11.0f);
            this.f71147d.setText(this.f71163t);
            addView(this.f71147d);
        }
        ImageView imageView = this.f71148e;
        if (imageView != null) {
            addView(imageView);
        }
        k(false);
    }

    public double getMax() {
        return this.f71153j;
    }

    public double getProgress() {
        return this.f71154k;
    }

    public void i(double d11, boolean z11) {
        this.f71154k = d11;
        k(z11);
        invalidate();
    }

    public void j(String str, boolean z11) {
        i(c(str).doubleValue(), z11);
    }

    public final void k(boolean z11) {
        d(z11);
        if (getWidth() == 0) {
            post(new s(this));
        } else {
            h();
        }
    }

    /* renamed from: l */
    public final void h() {
        double d11 = this.f71162s;
        int intValue = d11 > 0.0d ? c(String.valueOf(d11)).multiply(c(String.valueOf(getAvailableWidth()))).intValue() : 0;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f71146c.getLayoutParams();
        layoutParams.width = intValue;
        this.f71146c.setLayoutParams(layoutParams);
        this.f71146c.measure(View.MeasureSpec.makeMeasureSpec(intValue, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        View view = this.f71146c;
        view.layout(0, 0, view.getMeasuredWidth(), this.f71146c.getMeasuredHeight());
        if (this.f71147d != null) {
            int i11 = this.f71164u;
            this.f71147d.setTranslationX(Math.min(Math.max((float) (i11 + intValue), (float) i11), (((((float) getWidth()) - this.f71147d.getPaint().measureText(this.f71163t)) - ((float) this.f71164u)) - ((float) getPaddingLeft())) - ((float) getPaddingRight())));
        }
        if (this.f71148e != null) {
            int i12 = this.f71164u;
            int i13 = this.f71166w;
            float max = Math.max((float) ((i12 - (i13 >> 1)) + intValue), (float) (i12 - (i13 >> 1)));
            int width = getWidth() - (this.f71166w >> 1);
            int i14 = this.f71164u;
            float min = Math.min(max, (float) (((width - i14) - i14) - getPaddingLeft()));
            this.f71148e.setTranslationX(min);
            a aVar = this.f71160q;
            if (aVar != null) {
                aVar.b(min);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        h();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.f71167x
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x0029
            if (r0 == r2) goto L_0x001e
            r3 = 2
            if (r0 == r3) goto L_0x0016
            r5 = 3
            if (r0 == r5) goto L_0x001e
            goto L_0x0028
        L_0x0016:
            r4.requestDisallowInterceptTouchEvent(r2)
            boolean r5 = r4.e(r5)
            return r5
        L_0x001e:
            r4.requestDisallowInterceptTouchEvent(r1)
            com.hbg.lib.widgets.CommonProgressBar$a r5 = r4.f71160q
            if (r5 == 0) goto L_0x0028
            r5.c(r1)
        L_0x0028:
            return r2
        L_0x0029:
            com.hbg.lib.widgets.CommonProgressBar$a r0 = r4.f71160q
            if (r0 == 0) goto L_0x0030
            r0.c(r2)
        L_0x0030:
            boolean r5 = r4.e(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.CommonProgressBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBallCount(int i11) {
        this.f71161r = i11;
        CommonCircleCountView commonCircleCountView = this.f71149f;
        if (commonCircleCountView != null) {
            commonCircleCountView.setCount(i11);
        }
    }

    public void setCallback(a aVar) {
        this.f71160q = aVar;
    }

    public void setIsTrue(boolean z11) {
        this.f71168y = z11;
    }

    public void setMax(String str) {
        setMax(c(str).doubleValue());
    }

    public void setPrecision(int i11) {
        this.f71159p = i11;
    }

    public void setProgressBgColor(int i11) {
        this.f71152i = i11;
        this.f71145b.setBackgroundColor(i11);
        invalidate();
    }

    public void setProgressColor(int i11) {
        this.f71151h = i11;
        this.f71146c.setBackgroundColor(i11);
        invalidate();
    }

    public void setThumbImage(Drawable drawable) {
        if (drawable != null) {
            this.f71158o = drawable;
        }
        this.f71148e.setImageDrawable(this.f71158o);
    }

    public CommonProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71153j = 100.0d;
        this.f71159p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonProgressBar, i11, 0);
        this.f71150g = obtainStyledAttributes.getDimension(R$styleable.CommonProgressBar_cpb_corner, 0.0f);
        this.f71151h = obtainStyledAttributes.getColor(R$styleable.CommonProgressBar_cpb_progress_color, 0);
        this.f71152i = obtainStyledAttributes.getColor(R$styleable.CommonProgressBar_cpb_bg_color, 0);
        this.f71153j = c(obtainStyledAttributes.getString(R$styleable.CommonProgressBar_cpb_max)).doubleValue();
        this.f71154k = c(obtainStyledAttributes.getString(R$styleable.CommonProgressBar_cpb_progress)).doubleValue();
        this.f71155l = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressBar_cpb_progress_height, 0);
        this.f71156m = obtainStyledAttributes.getBoolean(R$styleable.CommonProgressBar_cpb_show_progress_text, false);
        this.f71157n = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressBar_cpb_progress_text_size, 0);
        this.f71164u = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressBar_cpb_progress_padding, 0);
        this.f71158o = obtainStyledAttributes.getDrawable(R$styleable.CommonProgressBar_cpb_progress_thumb);
        this.f71165v = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressBar_cpb_progress_thumb_pivot_y_offset, 0);
        this.f71166w = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CommonProgressBar_cpb_progress_thumb_height, 0);
        this.f71161r = obtainStyledAttributes.getInteger(R$styleable.CommonProgressBar_cpb_progress_point_count, 0);
        this.f71167x = obtainStyledAttributes.getBoolean(R$styleable.CommonProgressBar_cpb_progress_touchable, false);
        if (this.f71157n == 0) {
            this.f71157n = getResources().getDimensionPixelOffset(R$dimen.global_text_size_12);
        }
        obtainStyledAttributes.recycle();
        f(context);
        if (isInEditMode()) {
            k(false);
        } else {
            post(new t(this));
        }
    }

    public void setMax(double d11) {
        this.f71153j = d11;
    }
}
