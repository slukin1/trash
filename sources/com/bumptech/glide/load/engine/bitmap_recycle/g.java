package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class g implements e {

    /* renamed from: k  reason: collision with root package name */
    public static final Bitmap.Config f63772k = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    public final h f63773a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Bitmap.Config> f63774b;

    /* renamed from: c  reason: collision with root package name */
    public final long f63775c;

    /* renamed from: d  reason: collision with root package name */
    public final a f63776d;

    /* renamed from: e  reason: collision with root package name */
    public long f63777e;

    /* renamed from: f  reason: collision with root package name */
    public long f63778f;

    /* renamed from: g  reason: collision with root package name */
    public int f63779g;

    /* renamed from: h  reason: collision with root package name */
    public int f63780h;

    /* renamed from: i  reason: collision with root package name */
    public int f63781i;

    /* renamed from: j  reason: collision with root package name */
    public int f63782j;

    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public static final class b implements a {
        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    public g(long j11, h hVar, Set<Bitmap.Config> set) {
        this.f63775c = j11;
        this.f63777e = j11;
        this.f63773a = hVar;
        this.f63774b = set;
        this.f63776d = new b();
    }

    @TargetApi(26)
    public static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    public static Bitmap g(int i11, int i12, Bitmap.Config config) {
        if (config == null) {
            config = f63772k;
        }
        return Bitmap.createBitmap(i11, i12, config);
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            hashSet.add((Object) null);
        }
        if (i11 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static h l() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new c();
    }

    @TargetApi(19)
    public static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i11) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i11);
        }
        if (i11 >= 40 || (Build.VERSION.SDK_INT >= 23 && i11 >= 20)) {
            b();
        } else if (i11 >= 20 || i11 == 15) {
            q(n() / 2);
        }
    }

    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0);
    }

    public synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f63773a.b(bitmap)) <= this.f63777e) {
                        if (this.f63774b.contains(bitmap.getConfig())) {
                            int b11 = this.f63773a.b(bitmap);
                            this.f63773a.c(bitmap);
                            this.f63776d.a(bitmap);
                            this.f63781i++;
                            this.f63778f += (long) b11;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f63773a.e(bitmap));
                            }
                            h();
                            j();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f63773a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f63774b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public Bitmap d(int i11, int i12, Bitmap.Config config) {
        Bitmap m11 = m(i11, i12, config);
        if (m11 == null) {
            return g(i11, i12, config);
        }
        m11.eraseColor(0);
        return m11;
    }

    public Bitmap e(int i11, int i12, Bitmap.Config config) {
        Bitmap m11 = m(i11, i12, config);
        return m11 == null ? g(i11, i12, config) : m11;
    }

    public final void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f63779g + ", misses=" + this.f63780h + ", puts=" + this.f63781i + ", evictions=" + this.f63782j + ", currentSize=" + this.f63778f + ", maxSize=" + this.f63777e + "\nStrategy=" + this.f63773a);
    }

    public final void j() {
        q(this.f63777e);
    }

    public final synchronized Bitmap m(int i11, int i12, Bitmap.Config config) {
        Bitmap d11;
        f(config);
        d11 = this.f63773a.d(i11, i12, config != null ? config : f63772k);
        if (d11 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f63773a.a(i11, i12, config));
            }
            this.f63780h++;
        } else {
            this.f63779g++;
            this.f63778f -= (long) this.f63773a.b(d11);
            this.f63776d.b(d11);
            p(d11);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f63773a.a(i11, i12, config));
        }
        h();
        return d11;
    }

    public long n() {
        return this.f63777e;
    }

    public final synchronized void q(long j11) {
        while (this.f63778f > j11) {
            Bitmap removeLast = this.f63773a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f63778f = 0;
                return;
            }
            this.f63776d.b(removeLast);
            this.f63778f -= (long) this.f63773a.b(removeLast);
            this.f63782j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f63773a.e(removeLast));
            }
            h();
            removeLast.recycle();
        }
    }

    public g(long j11) {
        this(j11, l(), k());
    }
}
