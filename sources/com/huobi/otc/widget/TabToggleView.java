package com.huobi.otc.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.module.otc.R$font;
import com.hbg.module.otc.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import vp.s0;

public class TabToggleView extends View implements ValueAnimator.AnimatorUpdateListener {
    public int A;
    public int B;
    public int C;
    public int D;
    public ValueAnimator E;
    public boolean F;
    public final Interpolator G;
    public a H;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f80165b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f80166c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f80167d;

    /* renamed from: e  reason: collision with root package name */
    public ArgbEvaluator f80168e;

    /* renamed from: f  reason: collision with root package name */
    public int f80169f;

    /* renamed from: g  reason: collision with root package name */
    public int f80170g;

    /* renamed from: h  reason: collision with root package name */
    public int f80171h;

    /* renamed from: i  reason: collision with root package name */
    public float f80172i;

    /* renamed from: j  reason: collision with root package name */
    public String f80173j;

    /* renamed from: k  reason: collision with root package name */
    public String f80174k;

    /* renamed from: l  reason: collision with root package name */
    public int f80175l;

    /* renamed from: m  reason: collision with root package name */
    public int f80176m;

    /* renamed from: n  reason: collision with root package name */
    public int f80177n;

    /* renamed from: o  reason: collision with root package name */
    public int f80178o;

    /* renamed from: p  reason: collision with root package name */
    public int f80179p;

    /* renamed from: q  reason: collision with root package name */
    public int f80180q;

    /* renamed from: r  reason: collision with root package name */
    public int f80181r;

    /* renamed from: s  reason: collision with root package name */
    public int f80182s;

    /* renamed from: t  reason: collision with root package name */
    public int f80183t;

    /* renamed from: u  reason: collision with root package name */
    public int f80184u;

    /* renamed from: v  reason: collision with root package name */
    public int f80185v;

    /* renamed from: w  reason: collision with root package name */
    public int f80186w;

    /* renamed from: x  reason: collision with root package name */
    public int f80187x;

    /* renamed from: y  reason: collision with root package name */
    public int f80188y;

    /* renamed from: z  reason: collision with root package name */
    public int f80189z;

    public interface a {
        boolean a();

        void b(float f11, int i11);

        boolean c();
    }

    public TabToggleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean f(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            float x11 = motionEvent.getX();
            int width = view.getWidth();
            if (x11 > 0.0f && x11 <= ((float) width)) {
                if (x11 <= ((float) this.D)) {
                    g();
                } else {
                    h();
                }
                view.performClick();
            }
        }
        return true;
    }

    public final void b() {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.E.cancel();
        }
    }

    public final void c() {
        this.E.setDuration(270);
        this.E.addUpdateListener(this);
        this.E.start();
        this.E.setInterpolator(this.G);
        invalidate();
    }

    public final int d(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void e(Context context) {
        float f11 = 1.0f;
        this.f80170g = d(1.0f);
        this.f80171h = d(5.0f);
        this.C = d(12.0f);
        this.f80165b.setAntiAlias(true);
        this.f80165b.setStrokeWidth((float) this.f80170g);
        this.f80165b.setStyle(Paint.Style.STROKE);
        this.f80165b.setTextSize((float) this.f80186w);
        this.f80165b.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        this.f80165b.setTextAlign(Paint.Align.CENTER);
        if (this.f80187x == 0 || this.f80188y == 0) {
            Paint paint = this.f80165b;
            String str = this.f80173j;
            paint.getTextBounds(str, 0, str.length(), this.f80167d);
            this.f80187x = this.f80167d.width();
            this.f80188y = this.f80167d.height();
        }
        if (this.f80189z == 0 || this.A == 0) {
            Paint paint2 = this.f80165b;
            String str2 = this.f80174k;
            paint2.getTextBounds(str2, 0, str2.length(), this.f80167d);
            this.f80189z = this.f80167d.width();
            this.A = this.f80167d.height();
        }
        if (this.F) {
            f11 = 0.0f;
        }
        this.f80172i = f11;
        setOnTouchListener(new s0(this));
    }

    public void g() {
        a aVar = this.H;
        if ((aVar == null || !aVar.a()) && !this.F) {
            this.F = true;
            b();
            this.E = ValueAnimator.ofFloat(new float[]{this.f80172i, 0.0f});
            c();
        }
    }

    public void h() {
        a aVar = this.H;
        if ((aVar == null || !aVar.c()) && this.F) {
            this.F = false;
            b();
            this.E = ValueAnimator.ofFloat(new float[]{this.f80172i, 1.0f});
            c();
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f80172i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f80169f = getHeight() / 2;
        this.f80165b.setAlpha(255);
        RectF rectF = this.f80166c;
        int i11 = this.f80170g;
        rectF.set((float) (i11 / 2), (float) (i11 / 2), (float) (getWidth() - (this.f80170g / 2)), (float) (getHeight() - (this.f80170g / 2)));
        int i12 = this.f80175l;
        if (i12 != 0) {
            this.f80165b.setColor(i12);
            this.f80165b.setStyle(Paint.Style.FILL);
            RectF rectF2 = this.f80166c;
            int i13 = this.f80169f;
            canvas.drawRoundRect(rectF2, (float) i13, (float) i13, this.f80165b);
        }
        this.f80165b.setColor(((Integer) this.f80168e.evaluate(this.f80172i, Integer.valueOf(this.f80176m), Integer.valueOf(this.f80177n))).intValue());
        this.f80165b.setStyle(Paint.Style.STROKE);
        RectF rectF3 = this.f80166c;
        int i14 = this.f80169f;
        canvas.drawRoundRect(rectF3, (float) i14, (float) i14, this.f80165b);
        if (Float.compare(this.f80172i, 0.0f) != 0) {
            this.f80165b.setColor(this.f80182s);
            this.f80165b.setStyle(Paint.Style.FILL);
            this.f80165b.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(this.f80173j, (float) getPaddingLeft(), (float) ((getHeight() / 2) + (this.f80188y / 3) + this.f80170g), this.f80165b);
        }
        if (Float.compare(this.f80172i, 1.0f) != 0) {
            this.f80165b.setColor(this.f80183t);
            this.f80165b.setStyle(Paint.Style.FILL);
            this.f80165b.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(this.f80174k, (float) ((getWidth() - getPaddingRight()) + (this.f80170g / 2)), (float) ((getHeight() / 2) + (this.A / 3) + this.f80170g), this.f80165b);
        }
        int width = getWidth();
        int i15 = this.C;
        int i16 = (width - (i15 * 2)) - this.f80189z;
        int i17 = this.f80170g;
        int i18 = i16 - i17;
        this.D = (i15 * 2) + this.f80187x + i17;
        int width2 = getWidth();
        int i19 = this.f80170g;
        int i21 = width2 - i19;
        RectF rectF4 = this.f80166c;
        float f11 = this.f80172i;
        float f12 = ((float) (i19 / 2)) + (((float) i18) * f11);
        float f13 = (float) (i19 / 2);
        int i22 = this.D;
        rectF4.set(f12, f13, ((float) i22) + (((float) (i21 - i22)) * f11) + 1.0f, (float) (getHeight() - (this.f80170g / 2)));
        int intValue = ((Integer) this.f80168e.evaluate(this.f80172i, Integer.valueOf(this.f80178o), Integer.valueOf(this.f80179p))).intValue();
        this.f80165b.setColor(intValue);
        this.f80165b.setStyle(Paint.Style.FILL);
        RectF rectF5 = this.f80166c;
        int i23 = this.f80169f;
        canvas.drawRoundRect(rectF5, (float) i23, (float) i23, this.f80165b);
        this.f80165b.setColor(((Integer) this.f80168e.evaluate(this.f80172i, Integer.valueOf(this.f80180q), Integer.valueOf(this.f80181r))).intValue());
        this.f80165b.setStyle(Paint.Style.STROKE);
        RectF rectF6 = this.f80166c;
        int i24 = this.f80169f;
        canvas.drawRoundRect(rectF6, (float) i24, (float) i24, this.f80165b);
        this.f80165b.setColor(((Integer) this.f80168e.evaluate(this.f80172i, Integer.valueOf(this.f80184u), Integer.valueOf(this.f80185v))).intValue());
        this.f80165b.setStyle(Paint.Style.FILL);
        this.f80165b.setTextAlign(Paint.Align.CENTER);
        RectF rectF7 = this.f80166c;
        float f14 = rectF7.left;
        float f15 = f14 + ((rectF7.right - f14) / 2.0f);
        int height = getHeight() / 2;
        float f16 = this.f80172i;
        float f17 = (float) (height + ((f16 < 0.5f ? this.f80188y : this.A) / 3) + this.f80170g);
        this.f80165b.setAlpha((int) ((1.0f - f16) * 255.0f));
        canvas.drawText(this.f80173j, f15, f17, this.f80165b);
        this.f80165b.setAlpha((int) (this.f80172i * 255.0f));
        canvas.drawText(this.f80174k, f15, f17, this.f80165b);
        a aVar = this.H;
        if (aVar != null) {
            aVar.b(this.f80172i, intValue);
        }
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            invalidate();
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            size = this.f80187x + this.f80189z + this.B + getPaddingLeft() + getPaddingRight();
        }
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = this.f80188y + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCallback(a aVar) {
        this.H = aVar;
    }

    public TabToggleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f80165b = new Paint();
        this.f80166c = new RectF();
        this.f80167d = new Rect();
        this.f80168e = new ArgbEvaluator();
        this.f80173j = "text1";
        this.f80174k = "text2";
        this.f80175l = 0;
        this.f80176m = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80177n = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80178o = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80179p = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80180q = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80181r = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80182s = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80183t = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80184u = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f80185v = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.F = true;
        this.G = new DecelerateInterpolator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TabToggleView, i11, 0);
        CharSequence text = obtainStyledAttributes.getText(R$styleable.TabToggleView_toggle_view_tab_text1);
        this.f80173j = text != null ? text.toString() : this.f80173j;
        CharSequence text2 = obtainStyledAttributes.getText(R$styleable.TabToggleView_toggle_view_tab_text2);
        this.f80174k = text2 != null ? text2.toString() : this.f80174k;
        this.B = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.TabToggleView_toggle_view_text_padding, d(20.0f));
        this.f80186w = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.TabToggleView_toggle_view_text_size, d(12.0f));
        this.f80175l = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_view_bg_color, this.f80175l);
        this.f80176m = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_view_bg_stroke_color1, this.f80176m);
        this.f80177n = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_view_bg_stroke_color2, this.f80177n);
        this.f80178o = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_btn_bg_color1, this.f80178o);
        this.f80179p = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_btn_bg_color2, this.f80179p);
        this.f80180q = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_btn_stroke_color1, this.f80180q);
        this.f80181r = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_btn_stroke_color2, this.f80181r);
        this.f80182s = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_unchecked_text_color1, this.f80182s);
        this.f80183t = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_unchecked_text_color2, this.f80183t);
        this.f80184u = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_checked_text_color1, this.f80184u);
        this.f80185v = obtainStyledAttributes.getColor(R$styleable.TabToggleView_toggle_checked_text_color2, this.f80185v);
        this.F = obtainStyledAttributes.getBoolean(R$styleable.TabToggleView_toggle_is_default_checked_tab1, this.F);
        obtainStyledAttributes.recycle();
        e(context);
    }
}
