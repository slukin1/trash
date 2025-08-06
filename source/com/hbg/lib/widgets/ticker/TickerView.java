package com.hbg.lib.widgets.ticker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import i6.d;

public class TickerView extends View {

    /* renamed from: w  reason: collision with root package name */
    public static final Interpolator f72342w = new AccelerateDecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f72343b;

    /* renamed from: c  reason: collision with root package name */
    public final c f72344c;

    /* renamed from: d  reason: collision with root package name */
    public final ma.a f72345d;

    /* renamed from: e  reason: collision with root package name */
    public final ValueAnimator f72346e = ValueAnimator.ofFloat(new float[]{1.0f});

    /* renamed from: f  reason: collision with root package name */
    public final Rect f72347f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public String f72348g;

    /* renamed from: h  reason: collision with root package name */
    public int f72349h;

    /* renamed from: i  reason: collision with root package name */
    public int f72350i;

    /* renamed from: j  reason: collision with root package name */
    public int f72351j;

    /* renamed from: k  reason: collision with root package name */
    public int f72352k;

    /* renamed from: l  reason: collision with root package name */
    public float f72353l;

    /* renamed from: m  reason: collision with root package name */
    public int f72354m;

    /* renamed from: n  reason: collision with root package name */
    public long f72355n;

    /* renamed from: o  reason: collision with root package name */
    public long f72356o;

    /* renamed from: p  reason: collision with root package name */
    public Interpolator f72357p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f72358q;

    /* renamed from: r  reason: collision with root package name */
    public String f72359r;

    /* renamed from: s  reason: collision with root package name */
    public float f72360s;

    /* renamed from: t  reason: collision with root package name */
    public float f72361t;

    /* renamed from: u  reason: collision with root package name */
    public float f72362u;

    /* renamed from: v  reason: collision with root package name */
    public float f72363v;

    public enum ScrollingDirection {
        ANY,
        UP,
        DOWN
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TickerView.this.f72345d.g(valueAnimator.getAnimatedFraction());
            TickerView.this.c();
            TickerView.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            TickerView.this.f72345d.f();
            TickerView.this.c();
            TickerView.this.invalidate();
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f72366a;

        /* renamed from: b  reason: collision with root package name */
        public int f72367b;

        /* renamed from: c  reason: collision with root package name */
        public float f72368c;

        /* renamed from: d  reason: collision with root package name */
        public float f72369d;

        /* renamed from: e  reason: collision with root package name */
        public float f72370e;

        /* renamed from: f  reason: collision with root package name */
        public String f72371f;

        /* renamed from: g  reason: collision with root package name */
        public int f72372g = RoundedDrawable.DEFAULT_BORDER_COLOR;

        /* renamed from: h  reason: collision with root package name */
        public float f72373h;

        /* renamed from: i  reason: collision with root package name */
        public int f72374i;

        public c(Resources resources) {
            this.f72373h = TypedValue.applyDimension(2, 12.0f, resources.getDisplayMetrics());
            this.f72366a = 8388611;
        }

        public void a(TypedArray typedArray) {
            this.f72366a = typedArray.getInt(R$styleable.TickerView_android_gravity, this.f72366a);
            this.f72367b = typedArray.getColor(R$styleable.TickerView_android_shadowColor, this.f72367b);
            this.f72368c = typedArray.getFloat(R$styleable.TickerView_android_shadowDx, this.f72368c);
            this.f72369d = typedArray.getFloat(R$styleable.TickerView_android_shadowDy, this.f72369d);
            this.f72370e = typedArray.getFloat(R$styleable.TickerView_android_shadowRadius, this.f72370e);
            this.f72371f = typedArray.getString(R$styleable.TickerView_android_text);
            this.f72372g = typedArray.getColor(R$styleable.TickerView_android_textColor, this.f72372g);
            this.f72373h = typedArray.getDimension(R$styleable.TickerView_android_textSize, this.f72373h);
            this.f72374i = typedArray.getInt(R$styleable.TickerView_android_textStyle, this.f72374i);
        }
    }

    public TickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextPaint textPaint = new TextPaint(1);
        this.f72343b = textPaint;
        c cVar = new c(textPaint);
        this.f72344c = cVar;
        this.f72345d = new ma.a(cVar);
        f(context, attributeSet, 0, 0);
    }

    public static void j(Canvas canvas, int i11, Rect rect, float f11, float f12) {
        int width = rect.width();
        int height = rect.height();
        float f13 = (i11 & 16) == 16 ? ((float) rect.top) + ((((float) height) - f12) / 2.0f) : 0.0f;
        float f14 = (i11 & 1) == 1 ? ((float) rect.left) + ((((float) width) - f11) / 2.0f) : 0.0f;
        if ((i11 & 48) == 48) {
            f13 = 0.0f;
        }
        if ((i11 & 80) == 80) {
            f13 = ((float) rect.top) + (((float) height) - f12);
        }
        if ((i11 & 8388611) == 8388611) {
            f14 = 0.0f;
        }
        if ((i11 & 8388613) == 8388613) {
            f14 = ((float) rect.left) + (((float) width) - f11);
        }
        canvas.translate(f14, f13);
        canvas.clipRect(0.0f, 0.0f, f11, f12);
    }

    public final void c() {
        boolean z11 = true;
        boolean z12 = this.f72349h != e();
        if (this.f72350i == d()) {
            z11 = false;
        }
        if (z12 || z11) {
            requestLayout();
        }
    }

    public final int d() {
        return ((int) this.f72344c.b()) + getPaddingTop() + getPaddingBottom();
    }

    public final int e() {
        return ((int) (this.f72358q ? this.f72345d.d() : this.f72345d.e())) + getPaddingLeft() + getPaddingRight();
    }

    public void f(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f72361t = getResources().getDimension(R$dimen.dimen_1);
        this.f72363v = getResources().getDimension(R$dimen.global_text_size_6);
        c cVar = new c(context.getResources());
        int[] iArr = R$styleable.TickerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, i12);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.TickerView_android_textAppearance, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, iArr);
            cVar.a(obtainStyledAttributes2);
            obtainStyledAttributes2.recycle();
        }
        cVar.a(obtainStyledAttributes);
        this.f72357p = f72342w;
        this.f72356o = (long) obtainStyledAttributes.getInt(R$styleable.TickerView_ticker_animationDuration, 350);
        this.f72358q = obtainStyledAttributes.getBoolean(R$styleable.TickerView_ticker_animateMeasurementChange, false);
        this.f72351j = cVar.f72366a;
        int i13 = cVar.f72367b;
        if (i13 != 0) {
            this.f72343b.setShadowLayer(cVar.f72370e, cVar.f72368c, cVar.f72369d, i13);
        }
        int i14 = cVar.f72374i;
        if (i14 != 0) {
            this.f72354m = i14;
            setTypeface(this.f72343b.getTypeface());
        }
        setTextColor(cVar.f72372g);
        setTextSize(cVar.f72373h);
        int i15 = obtainStyledAttributes.getInt(R$styleable.TickerView_ticker_defaultCharacterList, 0);
        if (i15 == 1) {
            setCharacterLists(TickerUtils.b());
        } else if (i15 == 2) {
            setCharacterLists(TickerUtils.a());
        } else if (isInEditMode()) {
            setCharacterLists(TickerUtils.b());
        }
        int i16 = obtainStyledAttributes.getInt(R$styleable.TickerView_ticker_defaultPreferredScrollingDirection, 0);
        if (i16 == 0) {
            this.f72344c.f(ScrollingDirection.ANY);
        } else if (i16 == 1) {
            this.f72344c.f(ScrollingDirection.UP);
        } else if (i16 == 2) {
            this.f72344c.f(ScrollingDirection.DOWN);
        } else {
            throw new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: " + i16);
        }
        if (g()) {
            k(cVar.f72371f, false);
        } else {
            this.f72359r = cVar.f72371f;
        }
        obtainStyledAttributes.recycle();
        this.f72346e.addUpdateListener(new a());
        this.f72346e.addListener(new b());
    }

    public boolean g() {
        return this.f72345d.b() != null;
    }

    public boolean getAnimateMeasurementChange() {
        return this.f72358q;
    }

    public long getAnimationDelay() {
        return this.f72355n;
    }

    public long getAnimationDuration() {
        return this.f72356o;
    }

    public Interpolator getAnimationInterpolator() {
        return this.f72357p;
    }

    public int getGravity() {
        return this.f72351j;
    }

    public String getText() {
        return this.f72348g;
    }

    public int getTextColor() {
        return this.f72352k;
    }

    public float getTextSize() {
        return this.f72353l;
    }

    public Typeface getTypeface() {
        return this.f72343b.getTypeface();
    }

    public final void h() {
        this.f72344c.e();
        c();
        invalidate();
    }

    public final void i(Canvas canvas) {
        j(canvas, this.f72351j, this.f72347f, this.f72345d.d(), this.f72344c.b());
    }

    public void k(String str, boolean z11) {
        char[] cArr;
        if (!TextUtils.equals(str, this.f72348g)) {
            this.f72348g = str;
            if (this.f72360s > 0.0f) {
                TextPaint textPaint = new TextPaint(this.f72343b);
                float f11 = this.f72362u;
                textPaint.setTextSize(f11);
                if (textPaint.measureText(str) > this.f72360s) {
                    do {
                        float f12 = this.f72361t;
                        if (f11 - f12 < this.f72363v) {
                            break;
                        }
                        f11 -= f12;
                        textPaint.setTextSize(f11);
                    } while (textPaint.measureText(str) > this.f72360s);
                }
                if (f11 != 0.0f) {
                    l(f11);
                } else {
                    l(f11);
                }
                d.b("TickerView-->setText--> textSize:" + this.f72353l + " mMaxTextSize:" + this.f72362u + " mMinTextSize:" + this.f72363v + " tempTextSize:" + f11);
            }
            if (str == null) {
                cArr = new char[0];
            } else {
                cArr = str.toCharArray();
            }
            this.f72345d.i(cArr);
            setContentDescription(str);
            if (z11) {
                if (this.f72346e.isRunning()) {
                    this.f72346e.cancel();
                }
                this.f72346e.setStartDelay(this.f72355n);
                this.f72346e.setDuration(this.f72356o);
                this.f72346e.setInterpolator(this.f72357p);
                this.f72346e.start();
                return;
            }
            this.f72345d.g(1.0f);
            this.f72345d.f();
            c();
            invalidate();
        }
    }

    public void l(float f11) {
        if (this.f72353l != f11) {
            this.f72353l = f11;
            this.f72343b.setTextSize(f11);
            h();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        i(canvas);
        canvas.translate(0.0f, this.f72344c.a());
        this.f72345d.a(canvas, this.f72343b);
        canvas.restore();
    }

    public void onMeasure(int i11, int i12) {
        this.f72349h = e();
        this.f72350i = d();
        int resolveSize = View.resolveSize(this.f72349h, i11);
        int resolveSize2 = View.resolveSize(this.f72350i, i12);
        float f11 = this.f72360s;
        if (f11 > 0.0f) {
            resolveSize = (int) Math.min((float) resolveSize, f11);
        }
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f72347f.set(getPaddingLeft(), getPaddingTop(), i11 - getPaddingRight(), i12 - getPaddingBottom());
    }

    public void setAnimateMeasurementChange(boolean z11) {
        this.f72358q = z11;
    }

    public void setAnimationDelay(long j11) {
        this.f72355n = j11;
    }

    public void setAnimationDuration(long j11) {
        this.f72356o = j11;
    }

    public void setAnimationInterpolator(Interpolator interpolator) {
        this.f72357p = interpolator;
    }

    public void setCharacterLists(String... strArr) {
        this.f72345d.h(strArr);
        String str = this.f72359r;
        if (str != null) {
            k(str, false);
            this.f72359r = null;
        }
    }

    public void setGravity(int i11) {
        if (this.f72351j != i11) {
            this.f72351j = i11;
            invalidate();
        }
    }

    public void setMaxWidth(float f11) {
        this.f72360s = f11;
    }

    public void setPaintFlags(int i11) {
        this.f72343b.setFlags(i11);
        h();
    }

    public void setPreferredScrollingDirection(ScrollingDirection scrollingDirection) {
        this.f72344c.f(scrollingDirection);
    }

    public void setText(String str) {
        k(str, !TextUtils.isEmpty(this.f72348g));
    }

    public void setTextColor(int i11) {
        if (this.f72352k != i11) {
            this.f72352k = i11;
            this.f72343b.setColor(i11);
            invalidate();
        }
    }

    public void setTextSize(float f11) {
        this.f72362u = f11;
        l(f11);
    }

    public void setTypeface(Typeface typeface) {
        int i11 = this.f72354m;
        if (i11 == 3) {
            typeface = Typeface.create(typeface, 3);
        } else if (i11 == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (i11 == 2) {
            typeface = Typeface.create(typeface, 2);
        }
        this.f72343b.setTypeface(typeface);
        h();
    }

    public TickerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TextPaint textPaint = new TextPaint(1);
        this.f72343b = textPaint;
        c cVar = new c(textPaint);
        this.f72344c = cVar;
        this.f72345d = new ma.a(cVar);
        f(context, attributeSet, i11, 0);
    }
}
