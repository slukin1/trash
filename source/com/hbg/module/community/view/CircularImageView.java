package com.hbg.module.community.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.hbg.module.content.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CircularImageView extends AppCompatImageView {

    /* renamed from: x  reason: collision with root package name */
    public static final a f17564x = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final Paint f17565b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f17566c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f17567d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f17568e;

    /* renamed from: f  reason: collision with root package name */
    public int f17569f;

    /* renamed from: g  reason: collision with root package name */
    public int f17570g;

    /* renamed from: h  reason: collision with root package name */
    public int f17571h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f17572i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f17573j;

    /* renamed from: k  reason: collision with root package name */
    public GradientDirection f17574k;

    /* renamed from: l  reason: collision with root package name */
    public float f17575l;

    /* renamed from: m  reason: collision with root package name */
    public int f17576m;

    /* renamed from: n  reason: collision with root package name */
    public Integer f17577n;

    /* renamed from: o  reason: collision with root package name */
    public Integer f17578o;

    /* renamed from: p  reason: collision with root package name */
    public GradientDirection f17579p;

    /* renamed from: q  reason: collision with root package name */
    public float f17580q;

    /* renamed from: r  reason: collision with root package name */
    public int f17581r;

    /* renamed from: s  reason: collision with root package name */
    public ShadowGravity f17582s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f17583t;

    /* renamed from: u  reason: collision with root package name */
    public ColorFilter f17584u;

    /* renamed from: v  reason: collision with root package name */
    public Bitmap f17585v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f17586w;

    public enum GradientDirection {
        LEFT_TO_RIGHT(1),
        RIGHT_TO_LEFT(2),
        TOP_TO_BOTTOM(3),
        BOTTOM_TO_TOP(4);
        
        private final int value;

        private GradientDirection(int i11) {
            this.value = i11;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum ShadowGravity {
        CENTER(1),
        TOP(2),
        BOTTOM(3),
        START(4),
        END(5);
        
        private final int value;

        private ShadowGravity(int i11) {
            this.value = i11;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17587a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f17588b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f17589c;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0076 */
        static {
            /*
                com.hbg.module.community.view.CircularImageView$GradientDirection[] r0 = com.hbg.module.community.view.CircularImageView.GradientDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.hbg.module.community.view.CircularImageView$GradientDirection r2 = com.hbg.module.community.view.CircularImageView.GradientDirection.LEFT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.hbg.module.community.view.CircularImageView$GradientDirection r3 = com.hbg.module.community.view.CircularImageView.GradientDirection.RIGHT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.hbg.module.community.view.CircularImageView$GradientDirection r4 = com.hbg.module.community.view.CircularImageView.GradientDirection.TOP_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.hbg.module.community.view.CircularImageView$GradientDirection r5 = com.hbg.module.community.view.CircularImageView.GradientDirection.BOTTOM_TO_TOP     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f17587a = r0
                com.hbg.module.community.view.CircularImageView$ShadowGravity[] r0 = com.hbg.module.community.view.CircularImageView.ShadowGravity.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.hbg.module.community.view.CircularImageView$ShadowGravity r5 = com.hbg.module.community.view.CircularImageView.ShadowGravity.CENTER     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.hbg.module.community.view.CircularImageView$ShadowGravity r5 = com.hbg.module.community.view.CircularImageView.ShadowGravity.TOP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.hbg.module.community.view.CircularImageView$ShadowGravity r5 = com.hbg.module.community.view.CircularImageView.ShadowGravity.BOTTOM     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.hbg.module.community.view.CircularImageView$ShadowGravity r5 = com.hbg.module.community.view.CircularImageView.ShadowGravity.START     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.hbg.module.community.view.CircularImageView$ShadowGravity r4 = com.hbg.module.community.view.CircularImageView.ShadowGravity.END     // Catch:{ NoSuchFieldError -> 0x005d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                f17588b = r0
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x006e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0076 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0076 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                f17589c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.view.CircularImageView.b.<clinit>():void");
        }
    }

    public static final class c extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CircularImageView f17590a;

        public c(CircularImageView circularImageView) {
            this.f17590a = circularImageView;
        }

        public void getOutline(View view, Outline outline) {
            if (outline != null) {
                outline.setOval(0, 0, this.f17590a.f17570g, this.f17590a.f17570g);
            }
        }
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularImageView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void setCivColorFilter(ColorFilter colorFilter) {
        if (!x.b(this.f17584u, colorFilter)) {
            this.f17584u = colorFilter;
            if (colorFilter != null) {
                this.f17586w = null;
                invalidate();
            }
        }
    }

    public final Bitmap d(BitmapDrawable bitmapDrawable) {
        return Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight(), false);
    }

    public final Matrix e(Bitmap bitmap, int i11) {
        float f11;
        float f12;
        Matrix matrix = new Matrix();
        float f13 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i11) {
            float f14 = (float) i11;
            f12 = f14 / ((float) bitmap.getHeight());
            f13 = (f14 - (((float) bitmap.getWidth()) * f12)) * 0.5f;
            f11 = 0.0f;
        } else {
            float f15 = (float) i11;
            f12 = f15 / ((float) bitmap.getWidth());
            f11 = (f15 - (((float) bitmap.getHeight()) * f12)) * 0.5f;
        }
        matrix.setScale(f12, f12);
        matrix.postTranslate(f13, f11);
        return matrix;
    }

    public final Matrix f(Bitmap bitmap, int i11) {
        float f11;
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() > i11 || bitmap.getHeight() > i11) {
            float f12 = (float) i11;
            f11 = RangesKt___RangesKt.f(f12 / ((float) bitmap.getWidth()), f12 / ((float) bitmap.getHeight()));
        } else {
            f11 = 1.0f;
        }
        float f13 = (float) i11;
        matrix.setScale(f11, f11);
        matrix.postTranslate((float) MathKt__MathJVMKt.b((f13 - (((float) bitmap.getWidth()) * f11)) * 0.5f), (float) MathKt__MathJVMKt.b((f13 - (((float) bitmap.getHeight()) * f11)) * 0.5f));
        return matrix;
    }

    public final LinearGradient g(int i11, int i12, GradientDirection gradientDirection) {
        float f11;
        float f12;
        float f13;
        float f14;
        int i13 = b.f17587a[gradientDirection.ordinal()];
        if (i13 != 1) {
            if (i13 == 2) {
                f14 = (float) getWidth();
                f13 = 0.0f;
            } else if (i13 == 3) {
                f11 = (float) getHeight();
                f14 = 0.0f;
                f13 = 0.0f;
                f12 = 0.0f;
            } else if (i13 != 4) {
                f14 = 0.0f;
                f13 = 0.0f;
            } else {
                f13 = (float) getHeight();
                f14 = 0.0f;
                f12 = 0.0f;
                f11 = f12;
            }
            f12 = f13;
            f11 = f12;
        } else {
            f12 = (float) getWidth();
            f14 = 0.0f;
            f13 = 0.0f;
            f11 = 0.0f;
        }
        return new LinearGradient(f14, f13, f12, f11, i11, i12, Shader.TileMode.CLAMP);
    }

    public final int getBorderColor() {
        return this.f17576m;
    }

    public final GradientDirection getBorderColorDirection() {
        return this.f17579p;
    }

    public final Integer getBorderColorEnd() {
        return this.f17578o;
    }

    public final Integer getBorderColorStart() {
        return this.f17577n;
    }

    public final float getBorderWidth() {
        return this.f17575l;
    }

    public final int getCircleColor() {
        return this.f17571h;
    }

    public final GradientDirection getCircleColorDirection() {
        return this.f17574k;
    }

    public final Integer getCircleColorEnd() {
        return this.f17573j;
    }

    public final Integer getCircleColorStart() {
        return this.f17572i;
    }

    public ImageView.ScaleType getScaleType() {
        ImageView.ScaleType scaleType = super.getScaleType();
        return scaleType == null ? ImageView.ScaleType.CENTER_CROP : scaleType;
    }

    public final int getShadowColor() {
        return this.f17581r;
    }

    public final boolean getShadowEnable() {
        return this.f17583t;
    }

    public final ShadowGravity getShadowGravity() {
        return this.f17582s;
    }

    public final float getShadowRadius() {
        return this.f17580q;
    }

    public final void h() {
        float f11;
        float f12;
        float f13;
        if (Build.VERSION.SDK_INT < 28) {
            setLayerType(1, this.f17567d);
        }
        int i11 = b.f17588b[this.f17582s.ordinal()];
        float f14 = 0.0f;
        if (i11 == 2) {
            f12 = -this.f17580q;
        } else if (i11 != 3) {
            if (i11 == 4) {
                f13 = -this.f17580q;
            } else if (i11 != 5) {
                f11 = 0.0f;
                this.f17567d.setShadowLayer(this.f17580q, f14, f11, this.f17581r);
            } else {
                f13 = this.f17580q;
            }
            f14 = f13 / ((float) 2);
            f11 = 0.0f;
            this.f17567d.setShadowLayer(this.f17580q, f14, f11, this.f17581r);
        } else {
            f12 = this.f17580q;
        }
        f11 = f12 / ((float) 2);
        this.f17567d.setShadowLayer(this.f17580q, f14, f11, this.f17581r);
    }

    public final Bitmap i(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof VectorDrawable)) {
            return v((VectorDrawable) drawable);
        }
        if (drawable instanceof BitmapDrawable) {
            return d((BitmapDrawable) drawable);
        }
        return q(drawable);
    }

    public final Matrix j(Bitmap bitmap, int i11) {
        Matrix matrix = new Matrix();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        RectF rectF2 = new RectF();
        float f11 = (float) i11;
        rectF2.set(0.0f, 0.0f, f11, f11);
        Unit unit = Unit.f56620a;
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        return matrix;
    }

    public final void k(Context context, AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircularImageView, i11, 0);
        setCircleColor(obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_circle_color, -1));
        int color = obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_circle_color_start, 0);
        if (color != 0) {
            setCircleColorStart(Integer.valueOf(color));
        }
        int color2 = obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_circle_color_end, 0);
        if (color2 != 0) {
            setCircleColorEnd(Integer.valueOf(color2));
        }
        setCircleColorDirection(r(obtainStyledAttributes.getInteger(R$styleable.CircularImageView_civ_circle_color_direction, this.f17574k.getValue())));
        if (obtainStyledAttributes.getBoolean(R$styleable.CircularImageView_civ_border, true)) {
            setBorderWidth(obtainStyledAttributes.getDimension(R$styleable.CircularImageView_civ_border_width, getResources().getDisplayMetrics().density * 4.0f));
            setBorderColor(obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_border_color, -1));
            int color3 = obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_border_color_start, 0);
            if (color3 != 0) {
                setBorderColorStart(Integer.valueOf(color3));
            }
            int color4 = obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_border_color_end, 0);
            if (color4 != 0) {
                setBorderColorEnd(Integer.valueOf(color4));
            }
            setBorderColorDirection(r(obtainStyledAttributes.getInteger(R$styleable.CircularImageView_civ_border_color_direction, this.f17579p.getValue())));
        }
        setShadowEnable(obtainStyledAttributes.getBoolean(R$styleable.CircularImageView_civ_shadow, this.f17583t));
        if (this.f17583t) {
            setShadowGravity(s(obtainStyledAttributes.getInteger(R$styleable.CircularImageView_civ_shadow_gravity, this.f17582s.getValue())));
            setShadowRadius(obtainStyledAttributes.getDimension(R$styleable.CircularImageView_civ_shadow_radius, getResources().getDisplayMetrics().density * 8.0f));
            setShadowColor(obtainStyledAttributes.getColor(R$styleable.CircularImageView_civ_shadow_color, this.f17581r));
        }
        obtainStyledAttributes.recycle();
    }

    public final void l() {
        if (!x.b(this.f17586w, getDrawable())) {
            Drawable drawable = getDrawable();
            this.f17586w = drawable;
            this.f17585v = i(drawable);
            u();
        }
    }

    public final void m() {
        int i11 = (this.f17575l > 0.0f ? 1 : (this.f17575l == 0.0f ? 0 : -1)) == 0 ? this.f17571h : this.f17576m;
        Paint paint = this.f17566c;
        Integer num = this.f17577n;
        int intValue = num != null ? num.intValue() : i11;
        Integer num2 = this.f17578o;
        if (num2 != null) {
            i11 = num2.intValue();
        }
        paint.setShader(g(intValue, i11, this.f17579p));
    }

    public final void n() {
        Paint paint = this.f17568e;
        Integer num = this.f17572i;
        int intValue = num != null ? num.intValue() : this.f17571h;
        Integer num2 = this.f17573j;
        paint.setShader(g(intValue, num2 != null ? num2.intValue() : this.f17571h, this.f17574k));
    }

    public final void o() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(!this.f17583t ? new c(this) : null);
        }
    }

    public void onDraw(Canvas canvas) {
        l();
        if (this.f17585v != null) {
            float f11 = ((float) this.f17569f) + this.f17575l;
            boolean z11 = this.f17583t;
            float f12 = z11 ? this.f17580q * ((float) 2) : 0.0f;
            if (z11) {
                h();
                canvas.drawCircle(f11, f11, f11 - f12, this.f17567d);
            }
            canvas.drawCircle(f11, f11, f11 - f12, this.f17566c);
            canvas.drawCircle(f11, f11, ((float) this.f17569f) - f12, this.f17568e);
            canvas.drawCircle(f11, f11, ((float) this.f17569f) - f12, this.f17565b);
        }
    }

    public void onMeasure(int i11, int i12) {
        int min = Math.min(p(i11) - (getPaddingLeft() + getPaddingRight()), p(i12) - (getPaddingTop() + getPaddingBottom()));
        this.f17570g = min;
        setMeasuredDimension(min, min);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        t();
    }

    public final int p(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : this.f17570g;
    }

    public final Bitmap q(Drawable drawable) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final GradientDirection r(int i11) {
        if (i11 == 1) {
            return GradientDirection.LEFT_TO_RIGHT;
        }
        if (i11 == 2) {
            return GradientDirection.RIGHT_TO_LEFT;
        }
        if (i11 == 3) {
            return GradientDirection.TOP_TO_BOTTOM;
        }
        if (i11 == 4) {
            return GradientDirection.BOTTOM_TO_TOP;
        }
        throw new IllegalArgumentException("This value is not supported for GradientDirection: " + i11);
    }

    public final ShadowGravity s(int i11) {
        if (i11 == 1) {
            return ShadowGravity.CENTER;
        }
        if (i11 == 2) {
            return ShadowGravity.TOP;
        }
        if (i11 == 3) {
            return ShadowGravity.BOTTOM;
        }
        if (i11 == 4) {
            return ShadowGravity.START;
        }
        if (i11 == 5) {
            return ShadowGravity.END;
        }
        throw new IllegalArgumentException("This value is not supported for ShadowGravity: " + i11);
    }

    public final void setBorderColor(int i11) {
        this.f17576m = i11;
        m();
        invalidate();
    }

    public final void setBorderColorDirection(GradientDirection gradientDirection) {
        this.f17579p = gradientDirection;
        m();
        invalidate();
    }

    public final void setBorderColorEnd(Integer num) {
        this.f17578o = num;
        m();
        invalidate();
    }

    public final void setBorderColorStart(Integer num) {
        this.f17577n = num;
        m();
        invalidate();
    }

    public final void setBorderWidth(float f11) {
        this.f17575l = f11;
        t();
    }

    public final void setCircleColor(int i11) {
        this.f17571h = i11;
        n();
        invalidate();
    }

    public final void setCircleColorDirection(GradientDirection gradientDirection) {
        this.f17574k = gradientDirection;
        n();
        invalidate();
    }

    public final void setCircleColorEnd(Integer num) {
        this.f17573j = num;
        n();
        invalidate();
    }

    public final void setCircleColorStart(Integer num) {
        this.f17572i = num;
        n();
        invalidate();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        setCivColorFilter(colorFilter);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (CollectionsKt__CollectionsKt.n(ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.FIT_CENTER).contains(scaleType)) {
            super.setScaleType(scaleType);
            return;
        }
        throw new IllegalArgumentException(("ScaleType " + scaleType + " not supported. Just ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE & ScaleType.FIT_CENTER are available for this library.").toString());
    }

    public final void setShadowColor(int i11) {
        this.f17581r = i11;
        this.f17567d.setColor(i11);
        invalidate();
    }

    public final void setShadowEnable(boolean z11) {
        this.f17583t = z11;
        if (z11) {
            if (this.f17580q == 0.0f) {
                setShadowRadius(getResources().getDisplayMetrics().density * 8.0f);
            }
        }
        t();
    }

    public final void setShadowGravity(ShadowGravity shadowGravity) {
        this.f17582s = shadowGravity;
        invalidate();
    }

    public final void setShadowRadius(float f11) {
        this.f17580q = f11;
        setShadowEnable(f11 > 0.0f);
    }

    public final void t() {
        if (this.f17585v != null) {
            u();
        }
        int min = Math.min(getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        this.f17570g = min;
        this.f17569f = ((int) (((float) min) - (this.f17575l * ((float) 2)))) / 2;
        n();
        m();
        o();
        invalidate();
    }

    public final void u() {
        Matrix matrix;
        Bitmap bitmap = this.f17585v;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            int i11 = b.f17589c[getScaleType().ordinal()];
            if (i11 == 1) {
                matrix = e(bitmap, this.f17570g);
            } else if (i11 == 2) {
                matrix = f(bitmap, this.f17570g);
            } else if (i11 != 3) {
                matrix = new Matrix();
            } else {
                matrix = j(bitmap, this.f17570g);
            }
            bitmapShader.setLocalMatrix(matrix);
            this.f17565b.setShader(bitmapShader);
            this.f17565b.setColorFilter(this.f17584u);
        }
    }

    public final Bitmap v(VectorDrawable vectorDrawable) {
        Bitmap createBitmap = Bitmap.createBitmap(getScaleType() == ImageView.ScaleType.CENTER_INSIDE ? vectorDrawable.getIntrinsicWidth() : getWidth(), getScaleType() == ImageView.ScaleType.CENTER_INSIDE ? vectorDrawable.getIntrinsicHeight() : getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return createBitmap;
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.f17565b = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.f17566c = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        this.f17567d = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        this.f17568e = paint4;
        this.f17571h = -1;
        GradientDirection gradientDirection = GradientDirection.LEFT_TO_RIGHT;
        this.f17574k = gradientDirection;
        this.f17576m = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f17579p = gradientDirection;
        this.f17581r = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f17582s = ShadowGravity.BOTTOM;
        k(context, attributeSet, i11);
    }
}
