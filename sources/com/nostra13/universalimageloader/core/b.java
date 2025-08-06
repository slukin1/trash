package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import ox.c;
import tx.a;
import vx.d;

public class b {

    /* renamed from: d  reason: collision with root package name */
    public static final String f28375d = "b";

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f28376e;

    /* renamed from: a  reason: collision with root package name */
    public c f28377a;

    /* renamed from: b  reason: collision with root package name */
    public d f28378b;

    /* renamed from: c  reason: collision with root package name */
    public a f28379c = new SimpleImageLoadingListener();

    public static Handler b(DisplayImageOptions displayImageOptions) {
        Handler y11 = displayImageOptions.y();
        if (displayImageOptions.J()) {
            return null;
        }
        return (y11 == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : y11;
    }

    public static b g() {
        if (f28376e == null) {
            synchronized (b.class) {
                if (f28376e == null) {
                    f28376e = new b();
                }
            }
        }
        return f28376e;
    }

    public final void a() {
        if (this.f28377a == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public void c(String str, sx.a aVar, DisplayImageOptions displayImageOptions) {
        f(str, aVar, displayImageOptions, (a) null, (tx.b) null);
    }

    public void d(String str, sx.a aVar, DisplayImageOptions displayImageOptions, c cVar, a aVar2, tx.b bVar) {
        a();
        if (aVar != null) {
            if (aVar2 == null) {
                aVar2 = this.f28379c;
            }
            a aVar3 = aVar2;
            if (displayImageOptions == null) {
                displayImageOptions = this.f28377a.f28397r;
            }
            if (TextUtils.isEmpty(str)) {
                this.f28378b.d(aVar);
                aVar3.a(str, aVar.c());
                if (displayImageOptions.N()) {
                    aVar.d(displayImageOptions.z(this.f28377a.f28380a));
                } else {
                    aVar.d((Drawable) null);
                }
                aVar3.c(str, aVar.c(), (Bitmap) null);
                return;
            }
            if (cVar == null) {
                cVar = vx.a.e(aVar, this.f28377a.a());
            }
            c cVar2 = cVar;
            String b11 = d.b(str, cVar2);
            this.f28378b.o(aVar, b11);
            aVar3.a(str, aVar.c());
            Bitmap bitmap = this.f28377a.f28393n.get(b11);
            if (bitmap == null || bitmap.isRecycled()) {
                if (displayImageOptions.P()) {
                    aVar.d(displayImageOptions.B(this.f28377a.f28380a));
                } else if (displayImageOptions.I()) {
                    aVar.d((Drawable) null);
                }
                LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.f28378b, new e(str, aVar, cVar2, b11, displayImageOptions, aVar3, bVar, this.f28378b.h(str)), b(displayImageOptions));
                if (displayImageOptions.J()) {
                    loadAndDisplayImageTask.run();
                } else {
                    this.f28378b.p(loadAndDisplayImageTask);
                }
            } else {
                vx.c.a("Load image from memory cache [%s]", b11);
                if (displayImageOptions.L()) {
                    f fVar = new f(this.f28378b, bitmap, new e(str, aVar, cVar2, b11, displayImageOptions, aVar3, bVar, this.f28378b.h(str)), b(displayImageOptions));
                    if (displayImageOptions.J()) {
                        fVar.run();
                    } else {
                        this.f28378b.q(fVar);
                    }
                } else {
                    displayImageOptions.w().a(bitmap, aVar, LoadedFrom.MEMORY_CACHE);
                    aVar3.c(str, aVar.c(), bitmap);
                }
            }
        } else {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
    }

    public void e(String str, sx.a aVar, DisplayImageOptions displayImageOptions, a aVar2) {
        f(str, aVar, displayImageOptions, aVar2, (tx.b) null);
    }

    public void f(String str, sx.a aVar, DisplayImageOptions displayImageOptions, a aVar2, tx.b bVar) {
        d(str, aVar, displayImageOptions, (c) null, aVar2, bVar);
    }

    public void h(boolean z11) {
        this.f28378b.k(z11);
    }

    public synchronized void i(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.f28377a == null) {
            vx.c.a("Initialize ImageLoader with configuration", new Object[0]);
            this.f28378b = new d(cVar);
            this.f28377a = cVar;
        } else {
            vx.c.f("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    public boolean j() {
        return this.f28377a != null;
    }

    public void k(String str, DisplayImageOptions displayImageOptions, a aVar) {
        l(str, (c) null, displayImageOptions, aVar, (tx.b) null);
    }

    public void l(String str, c cVar, DisplayImageOptions displayImageOptions, a aVar, tx.b bVar) {
        a();
        if (cVar == null) {
            cVar = this.f28377a.a();
        }
        if (displayImageOptions == null) {
            displayImageOptions = this.f28377a.f28397r;
        }
        String str2 = str;
        f(str2, new sx.c(str, cVar, ViewScaleType.CROP), displayImageOptions, aVar, bVar);
    }

    public void m(String str, a aVar) {
        l(str, (c) null, (DisplayImageOptions) null, aVar, (tx.b) null);
    }
}
