package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import com.huobi.finance.bean.LoanOrderItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.q;
import java.util.concurrent.atomic.AtomicInteger;

public class r {

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicInteger f30119m = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final Picasso f30120a;

    /* renamed from: b  reason: collision with root package name */
    public final q.b f30121b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30122c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30123d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30124e = true;

    /* renamed from: f  reason: collision with root package name */
    public int f30125f;

    /* renamed from: g  reason: collision with root package name */
    public int f30126g;

    /* renamed from: h  reason: collision with root package name */
    public int f30127h;

    /* renamed from: i  reason: collision with root package name */
    public int f30128i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f30129j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f30130k;

    /* renamed from: l  reason: collision with root package name */
    public Object f30131l;

    public r(Picasso picasso, Uri uri, int i11) {
        if (!picasso.f29965o) {
            this.f30120a = picasso;
            this.f30121b = new q.b(uri, i11, picasso.f29962l);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    public r a() {
        this.f30121b.b(17);
        return this;
    }

    public r b() {
        this.f30131l = null;
        return this;
    }

    public final q c(long j11) {
        int andIncrement = f30119m.getAndIncrement();
        q a11 = this.f30121b.a();
        a11.f30082a = andIncrement;
        a11.f30083b = j11;
        boolean z11 = this.f30120a.f29964n;
        if (z11) {
            y.t("Main", LoanOrderItem.CREATED, a11.g(), a11.toString());
        }
        q p11 = this.f30120a.p(a11);
        if (p11 != a11) {
            p11.f30082a = andIncrement;
            p11.f30083b = j11;
            if (z11) {
                String d11 = p11.d();
                y.t("Main", "changed", d11, "into " + p11);
            }
        }
        return p11;
    }

    public r d(int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.f30130k == null) {
            this.f30126g = i11;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public r e() {
        this.f30123d = true;
        return this;
    }

    public final Drawable f() {
        int i11 = this.f30125f;
        if (i11 == 0) {
            return this.f30129j;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21) {
            return this.f30120a.f29955e.getDrawable(i11);
        }
        if (i12 >= 16) {
            return this.f30120a.f29955e.getResources().getDrawable(this.f30125f);
        }
        TypedValue typedValue = new TypedValue();
        this.f30120a.f29955e.getResources().getValue(this.f30125f, typedValue, true);
        return this.f30120a.f29955e.getResources().getDrawable(typedValue.resourceId);
    }

    public void g(ImageView imageView) {
        h(imageView, (Callback) null);
    }

    public void h(ImageView imageView, Callback callback) {
        Bitmap m11;
        ImageView imageView2 = imageView;
        Callback callback2 = callback;
        long nanoTime = System.nanoTime();
        y.c();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f30121b.c()) {
            this.f30120a.b(imageView2);
            if (this.f30124e) {
                o.d(imageView2, f());
            }
        } else {
            if (this.f30123d) {
                if (!this.f30121b.d()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f30124e) {
                            o.d(imageView2, f());
                        }
                        this.f30120a.e(imageView2, new g(this, imageView2, callback2));
                        return;
                    }
                    this.f30121b.e(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            q c11 = c(nanoTime);
            String f11 = y.f(c11);
            if (!MemoryPolicy.shouldReadFromMemoryCache(this.f30127h) || (m11 = this.f30120a.m(f11)) == null) {
                if (this.f30124e) {
                    o.d(imageView2, f());
                }
                this.f30120a.g(new k(this.f30120a, imageView, c11, this.f30127h, this.f30128i, this.f30126g, this.f30130k, f11, this.f30131l, callback, this.f30122c));
                return;
            }
            this.f30120a.b(imageView2);
            Picasso picasso = this.f30120a;
            Context context = picasso.f29955e;
            Picasso.LoadedFrom loadedFrom = Picasso.LoadedFrom.MEMORY;
            o.c(imageView, context, m11, loadedFrom, this.f30122c, picasso.f29963m);
            if (this.f30120a.f29964n) {
                String g11 = c11.g();
                y.t("Main", "completed", g11, "from " + loadedFrom);
            }
            if (callback2 != null) {
                callback.onSuccess();
            }
        }
    }

    public void i(v vVar) {
        Bitmap m11;
        long nanoTime = System.nanoTime();
        y.c();
        if (vVar == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f30123d) {
            Drawable drawable = null;
            if (!this.f30121b.c()) {
                this.f30120a.c(vVar);
                if (this.f30124e) {
                    drawable = f();
                }
                vVar.onPrepareLoad(drawable);
                return;
            }
            q c11 = c(nanoTime);
            String f11 = y.f(c11);
            if (!MemoryPolicy.shouldReadFromMemoryCache(this.f30127h) || (m11 = this.f30120a.m(f11)) == null) {
                if (this.f30124e) {
                    drawable = f();
                }
                vVar.onPrepareLoad(drawable);
                this.f30120a.g(new w(this.f30120a, vVar, c11, this.f30127h, this.f30128i, this.f30130k, f11, this.f30131l, this.f30126g));
                return;
            }
            this.f30120a.c(vVar);
            vVar.onBitmapLoaded(m11, Picasso.LoadedFrom.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public r j() {
        this.f30122c = true;
        return this;
    }

    public r k() {
        if (this.f30125f != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else if (this.f30129j == null) {
            this.f30124e = false;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public r l(Drawable drawable) {
        if (!this.f30124e) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.f30125f == 0) {
            this.f30129j = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public r m(int i11, int i12) {
        this.f30121b.e(i11, i12);
        return this;
    }

    public r n(x xVar) {
        this.f30121b.g(xVar);
        return this;
    }

    public r o() {
        this.f30123d = false;
        return this;
    }
}
