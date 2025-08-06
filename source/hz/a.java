package hz;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.View;
import com.ytjojo.shadowlayout.R$styleable;
import com.ytjojo.shadowlayout.ShadowLayout;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f52836a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f52837b;

    /* renamed from: c  reason: collision with root package name */
    public final Canvas f52838c = new Canvas();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f52839d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public boolean f52840e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52841f;

    /* renamed from: g  reason: collision with root package name */
    public int f52842g;

    /* renamed from: h  reason: collision with root package name */
    public int f52843h;

    /* renamed from: i  reason: collision with root package name */
    public float f52844i;

    /* renamed from: j  reason: collision with root package name */
    public float f52845j;

    /* renamed from: k  reason: collision with root package name */
    public float f52846k;

    /* renamed from: l  reason: collision with root package name */
    public float f52847l;

    /* renamed from: m  reason: collision with root package name */
    public float f52848m;

    /* renamed from: n  reason: collision with root package name */
    public float f52849n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f52850o = true;

    /* renamed from: p  reason: collision with root package name */
    public ShadowLayout f52851p;

    /* renamed from: q  reason: collision with root package name */
    public Runnable f52852q = new b();

    /* renamed from: hz.a$a  reason: collision with other inner class name */
    public class C0646a extends Paint {
        public C0646a(int i11) {
            super(i11);
            setDither(true);
            setFilterBitmap(true);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            boolean unused = a.this.f52840e = true;
            a.this.f52851p.postInvalidate();
        }
    }

    public a(ShadowLayout shadowLayout, TypedArray typedArray) {
        C0646a aVar = new C0646a(1);
        this.f52836a = aVar;
        this.f52851p = shadowLayout;
        shadowLayout.setWillNotDraw(false);
        this.f52851p.setLayerType(2, aVar);
        l(typedArray.getBoolean(R$styleable.ShadowLayout_sl_shadowed, true));
        n(typedArray.getDimension(R$styleable.ShadowLayout_sl_shadow_radius, 30.0f));
        this.f52848m = (float) typedArray.getDimensionPixelSize(R$styleable.ShadowLayout_sl_shadow_offsetdx, Integer.MAX_VALUE);
        this.f52847l = (float) typedArray.getDimensionPixelSize(R$styleable.ShadowLayout_sl_shadow_offsetdy, Integer.MAX_VALUE);
        this.f52845j = typedArray.getDimension(R$styleable.ShadowLayout_sl_shadow_distance, 0.0f);
        m((float) typedArray.getInteger(R$styleable.ShadowLayout_sl_shadow_angle, 45));
        g(typedArray.getColor(R$styleable.ShadowLayout_sl_shadow_color, -12303292));
        this.f52849n = (float) typedArray.getDimensionPixelSize(R$styleable.ShadowLayout_sl_shadow_zoomdy, 0);
        int max = (int) (this.f52844i + Math.max(this.f52848m, this.f52847l));
        this.f52851p.setPadding(max, max, max, max);
    }

    public void a(Canvas canvas) {
        Bitmap bitmap;
        if (this.f52841f) {
            if (this.f52840e) {
                if (this.f52839d.width() == 0 || this.f52839d.height() == 0) {
                    this.f52837b = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                } else {
                    Bitmap createBitmap = Bitmap.createBitmap(this.f52839d.width(), this.f52839d.height(), Bitmap.Config.ARGB_8888);
                    this.f52837b = createBitmap;
                    this.f52838c.setBitmap(createBitmap);
                    this.f52840e = false;
                    this.f52851p.a(this.f52838c);
                    Bitmap extractAlpha = this.f52837b.extractAlpha();
                    this.f52838c.drawColor(0, PorterDuff.Mode.CLEAR);
                    this.f52836a.setColor(i(false));
                    float f11 = this.f52849n;
                    if (!(f11 == 0.0f || f11 == 2.14748365E9f)) {
                        extractAlpha = j(extractAlpha, f11);
                    }
                    if (this.f52850o) {
                        int width = extractAlpha.getWidth();
                        int height = extractAlpha.getHeight();
                        float width2 = (float) ((this.f52838c.getWidth() - width) / 2);
                        float f12 = this.f52848m;
                        if (f12 == 2.14748365E9f) {
                            f12 = 0.0f;
                        }
                        float f13 = width2 + f12;
                        float height2 = (float) ((this.f52838c.getHeight() - height) / 2);
                        float f14 = this.f52847l;
                        if (f14 == 2.14748365E9f) {
                            f14 = 0.0f;
                        }
                        this.f52838c.drawBitmap(extractAlpha, f13, height2 + f14, this.f52836a);
                    } else {
                        Canvas canvas2 = this.f52838c;
                        float f15 = this.f52848m;
                        if (f15 == 2.14748365E9f) {
                            f15 = 0.0f;
                        }
                        float f16 = this.f52847l;
                        if (f16 == 2.14748365E9f) {
                            f16 = 0.0f;
                        }
                        canvas2.drawBitmap(extractAlpha, f15, f16, this.f52836a);
                    }
                    extractAlpha.recycle();
                }
            }
            this.f52836a.setColor(i(true));
            if (!(this.f52838c == null || (bitmap = this.f52837b) == null || bitmap.isRecycled())) {
                canvas.drawBitmap(this.f52837b, 0.0f, 0.0f, this.f52836a);
            }
        }
        this.f52851p.a(this.f52838c);
    }

    public void b(Canvas canvas) {
    }

    public void c(boolean z11, int i11, int i12, int i13, int i14) {
        this.f52839d.set(0, 0, this.f52851p.getMeasuredWidth(), this.f52851p.getMeasuredHeight());
    }

    public void d() {
    }

    public void e() {
        this.f52840e = true;
        this.f52851p.postInvalidate();
    }

    public boolean f(Canvas canvas, View view) {
        return false;
    }

    public void g(int i11) {
        this.f52842g = i11;
        this.f52843h = Color.alpha(i11);
        e();
    }

    public final int i(boolean z11) {
        return Color.argb(z11 ? 255 : this.f52843h, Color.red(this.f52842g), Color.green(this.f52842g), Color.blue(this.f52842g));
    }

    public Bitmap j(Bitmap bitmap, float f11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f12 = (float) height;
        float f13 = f11 + f12;
        if (f13 <= 1.0f) {
            f13 = 1.0f;
        }
        float f14 = f13 / f12;
        Matrix matrix = new Matrix();
        matrix.postScale(f14, f14);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public final void k() {
        float f11 = this.f52845j;
        if (f11 > 0.0f) {
            this.f52848m = (float) (((double) f11) * Math.cos(((double) (this.f52846k / 180.0f)) * 3.141592653589793d));
            this.f52847l = (float) (((double) this.f52845j) * Math.sin(((double) (this.f52846k / 180.0f)) * 3.141592653589793d));
        }
        this.f52840e = true;
        this.f52851p.postInvalidate();
    }

    public void l(boolean z11) {
        this.f52841f = z11;
        if (this.f52851p.isLayoutRequested() && this.f52851p.getParent() != null) {
            this.f52851p.postInvalidate();
        }
    }

    public void m(float f11) {
        this.f52846k = Math.max(0.0f, Math.min(f11, 360.0f));
        k();
    }

    public void n(float f11) {
        this.f52844i = Math.max(0.1f, f11);
        if (!this.f52851p.isInEditMode()) {
            this.f52836a.setMaskFilter(new BlurMaskFilter(this.f52844i, BlurMaskFilter.Blur.NORMAL));
            e();
        }
    }

    public void onDetachedFromWindow() {
        Bitmap bitmap = this.f52837b;
        if (bitmap != null) {
            bitmap.recycle();
            this.f52837b = null;
        }
    }
}
