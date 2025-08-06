package hz;

import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import com.huobi.view.roundimg.RoundedDrawable;
import com.ytjojo.shadowlayout.R$styleable;
import com.ytjojo.shadowlayout.ShadowLayout;

public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public Path f52867a;

    /* renamed from: b  reason: collision with root package name */
    public Path f52868b;

    /* renamed from: c  reason: collision with root package name */
    public Path f52869c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f52870d;

    /* renamed from: e  reason: collision with root package name */
    public ShadowLayout f52871e;

    /* renamed from: f  reason: collision with root package name */
    public float f52872f;

    /* renamed from: g  reason: collision with root package name */
    public float f52873g;

    /* renamed from: h  reason: collision with root package name */
    public float f52874h;

    /* renamed from: i  reason: collision with root package name */
    public Point f52875i;

    /* renamed from: j  reason: collision with root package name */
    public Point f52876j;

    /* renamed from: k  reason: collision with root package name */
    public int f52877k;

    /* renamed from: l  reason: collision with root package name */
    public int f52878l;

    /* renamed from: m  reason: collision with root package name */
    public float f52879m;

    /* renamed from: n  reason: collision with root package name */
    public float f52880n;

    /* renamed from: o  reason: collision with root package name */
    public float f52881o;

    /* renamed from: p  reason: collision with root package name */
    public float f52882p;

    /* renamed from: q  reason: collision with root package name */
    public float f52883q;

    /* renamed from: r  reason: collision with root package name */
    public float f52884r;

    /* renamed from: s  reason: collision with root package name */
    public Rect f52885s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public boolean f52886t;

    public c(ShadowLayout shadowLayout, TypedArray typedArray) {
        this.f52871e = shadowLayout;
        this.f52871e.setWillNotDraw(false);
        this.f52871e.setClipToPadding(false);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f52871e.setLayerType(1, (Paint) null);
        }
        this.f52867a = new Path();
        this.f52868b = new Path();
        this.f52869c = new Path();
        Paint paint = new Paint(1);
        this.f52870d = paint;
        paint.setDither(true);
        this.f52870d.setStyle(Paint.Style.FILL);
        g(typedArray.getColor(R$styleable.ShadowLayout_sl_shadow_color, RoundedDrawable.DEFAULT_BORDER_COLOR));
        h(typedArray.getDimension(R$styleable.ShadowLayout_sl_shadow_radius, 25.0f));
        this.f52874h = (float) typedArray.getDimensionPixelSize(R$styleable.ShadowLayout_sl_shadow_offsetdx, 0);
        this.f52873g = (float) typedArray.getDimensionPixelSize(R$styleable.ShadowLayout_sl_shadow_offsetdy, 0);
        this.f52879m = typedArray.getFloat(R$styleable.ShadowLayout_shadow_path_coordinatex1, 0.0f);
        this.f52880n = typedArray.getFloat(R$styleable.ShadowLayout_shadow_path_coordinatey1, 1.0f);
        this.f52881o = typedArray.getFloat(R$styleable.ShadowLayout_shadow_path_coordinatex2, 1.0f);
        this.f52882p = typedArray.getFloat(R$styleable.ShadowLayout_shadow_path_coordinatey2, 1.0f);
        this.f52883q = typedArray.getFloat(R$styleable.ShadowLayout_shadow_path_startleft_y_rate, 0.6f);
        this.f52884r = typedArray.getFloat(R$styleable.ShadowLayout_shadow_path_endright_y_rate, 0.6f);
    }

    public void a(Canvas canvas) {
        this.f52871e.a(canvas);
    }

    public void b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.f52867a, Region.Op.REPLACE);
        canvas.clipPath(this.f52868b, Region.Op.DIFFERENCE);
        this.f52870d.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f52869c.set(this.f52868b);
        this.f52869c.offset(this.f52874h, this.f52873g);
        canvas.drawPath(this.f52869c, this.f52870d);
        canvas.restore();
    }

    public void c(boolean z11, int i11, int i12, int i13, int i14) {
        this.f52885s.set(i11, i12, i13, i14);
        this.f52867a.reset();
        this.f52869c.reset();
        float f11 = (float) i11;
        float f12 = (float) i12;
        this.f52867a.lineTo(f11, f12);
        float f13 = (float) i13;
        this.f52867a.lineTo(f13, f12);
        float f14 = (float) i14;
        this.f52867a.lineTo(f13, f14);
        this.f52867a.lineTo(f11, f14);
        this.f52867a.lineTo(f11, f12);
        if (!this.f52886t) {
            this.f52868b.reset();
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (this.f52875i == null) {
                this.f52875i = new Point();
            }
            if (this.f52876j == null) {
                this.f52876j = new Point();
            }
            float f15 = (float) i15;
            float f16 = (float) i16;
            this.f52875i.set((int) ((this.f52879m * f15) + f11), (int) ((this.f52880n * f16) + f12));
            this.f52876j.set((int) ((this.f52881o * f15) + f11), (int) ((this.f52882p * f16) + f12));
            this.f52878l = (int) ((this.f52883q * f16) + f12);
            this.f52877k = (int) ((this.f52884r * f16) + f12);
            this.f52868b.moveTo(f11, f12);
            this.f52868b.lineTo(f11, (float) this.f52878l);
            Path path = this.f52868b;
            Point point = this.f52875i;
            float f17 = (float) point.y;
            Point point2 = this.f52876j;
            path.cubicTo((float) point.x, f17, (float) point2.x, (float) point2.y, f13, (float) this.f52877k);
            this.f52868b.lineTo(f13, f12);
            this.f52868b.lineTo(f11, f12);
        }
    }

    public void d() {
    }

    public void e() {
        this.f52871e.postInvalidate();
    }

    public boolean f(Canvas canvas, View view) {
        canvas.clipPath(this.f52868b);
        return false;
    }

    public void g(int i11) {
        this.f52870d.setColor(i11);
        this.f52871e.postInvalidate();
    }

    public void h(float f11) {
        this.f52872f = Math.max(0.1f, f11);
        if (!this.f52871e.isInEditMode()) {
            this.f52870d.setMaskFilter(new BlurMaskFilter(this.f52872f, BlurMaskFilter.Blur.NORMAL));
            e();
        }
    }

    public void onDetachedFromWindow() {
    }
}
