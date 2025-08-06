package yz;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.ImageSizeResolver;

public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final String f60218a;

    /* renamed from: b  reason: collision with root package name */
    public final AsyncDrawableLoader f60219b;

    /* renamed from: c  reason: collision with root package name */
    public final io.noties.markwon.image.a f60220c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageSizeResolver f60221d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable f60222e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f60223f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable.Callback f60224g;

    /* renamed from: h  reason: collision with root package name */
    public int f60225h;

    /* renamed from: i  reason: collision with root package name */
    public float f60226i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f60227j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f60228k = false;

    public a(String str, AsyncDrawableLoader asyncDrawableLoader, ImageSizeResolver imageSizeResolver, io.noties.markwon.image.a aVar) {
        this.f60218a = str;
        this.f60219b = asyncDrawableLoader;
        this.f60221d = imageSizeResolver;
        this.f60220c = aVar;
        Drawable b11 = asyncDrawableLoader.b(this);
        this.f60222e = b11;
        if (b11 != null) {
            j(b11);
        }
    }

    public static Rect h(Drawable drawable) {
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            if (!bounds.isEmpty()) {
                return bounds;
            }
            Rect a11 = d.a(drawable);
            if (!a11.isEmpty()) {
                return a11;
            }
        }
        return new Rect(0, 0, 1, 1);
    }

    public io.noties.markwon.image.a a() {
        return this.f60220c;
    }

    public float b() {
        return this.f60226i;
    }

    public int c() {
        return this.f60225h;
    }

    public Drawable d() {
        return this.f60223f;
    }

    public void draw(Canvas canvas) {
        if (e()) {
            this.f60223f.draw(canvas);
        }
    }

    public boolean e() {
        return this.f60223f != null;
    }

    public final void f() {
        if (this.f60225h == 0) {
            this.f60227j = true;
            setBounds(h(this.f60223f));
            return;
        }
        this.f60227j = false;
        Rect i11 = i();
        this.f60223f.setBounds(i11);
        this.f60223f.setCallback(this.f60224g);
        setBounds(i11);
        invalidateSelf();
    }

    public void g(int i11, float f11) {
        this.f60225h = i11;
        this.f60226i = f11;
        if (this.f60227j) {
            f();
        }
    }

    public int getIntrinsicHeight() {
        if (e()) {
            return this.f60223f.getIntrinsicHeight();
        }
        return 1;
    }

    public int getIntrinsicWidth() {
        if (e()) {
            return this.f60223f.getIntrinsicWidth();
        }
        return 1;
    }

    public int getOpacity() {
        if (e()) {
            return this.f60223f.getOpacity();
        }
        return -2;
    }

    public final Rect i() {
        return this.f60221d.a(this);
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f60223f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        Rect bounds = drawable.getBounds();
        if (bounds.isEmpty()) {
            Rect a11 = d.a(drawable);
            if (a11.isEmpty()) {
                drawable.setBounds(0, 0, 1, 1);
            } else {
                drawable.setBounds(a11);
            }
            setBounds(drawable.getBounds());
            k(drawable);
            return;
        }
        this.f60223f = drawable;
        drawable.setCallback(this.f60224g);
        setBounds(bounds);
        this.f60227j = false;
    }

    public void k(Drawable drawable) {
        this.f60228k = false;
        Drawable drawable2 = this.f60223f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f60223f = drawable;
        f();
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public String toString() {
        return "AsyncDrawable{destination='" + this.f60218a + '\'' + ", imageSize=" + this.f60220c + ", result=" + this.f60223f + ", canvasWidth=" + this.f60225h + ", textSize=" + this.f60226i + ", waitingForDimensions=" + this.f60227j + '}';
    }
}
