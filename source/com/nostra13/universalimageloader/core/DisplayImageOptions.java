package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public final class DisplayImageOptions {

    /* renamed from: a  reason: collision with root package name */
    public final int f28293a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28294b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28295c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f28296d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable f28297e;

    /* renamed from: f  reason: collision with root package name */
    public final Drawable f28298f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f28299g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f28300h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f28301i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageScaleType f28302j;

    /* renamed from: k  reason: collision with root package name */
    public final BitmapFactory.Options f28303k;

    /* renamed from: l  reason: collision with root package name */
    public final int f28304l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f28305m;

    /* renamed from: n  reason: collision with root package name */
    public final Object f28306n;

    /* renamed from: o  reason: collision with root package name */
    public final ux.a f28307o;

    /* renamed from: p  reason: collision with root package name */
    public final ux.a f28308p;

    /* renamed from: q  reason: collision with root package name */
    public final qx.a f28309q;

    /* renamed from: r  reason: collision with root package name */
    public final Handler f28310r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f28311s;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f28312a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f28313b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f28314c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f28315d = null;

        /* renamed from: e  reason: collision with root package name */
        public Drawable f28316e = null;

        /* renamed from: f  reason: collision with root package name */
        public Drawable f28317f = null;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28318g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28319h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28320i = false;

        /* renamed from: j  reason: collision with root package name */
        public ImageScaleType f28321j = ImageScaleType.IN_SAMPLE_POWER_OF_2;

        /* renamed from: k  reason: collision with root package name */
        public BitmapFactory.Options f28322k = new BitmapFactory.Options();

        /* renamed from: l  reason: collision with root package name */
        public int f28323l = 0;

        /* renamed from: m  reason: collision with root package name */
        public boolean f28324m = false;

        /* renamed from: n  reason: collision with root package name */
        public Object f28325n = null;

        /* renamed from: o  reason: collision with root package name */
        public ux.a f28326o = null;

        /* renamed from: p  reason: collision with root package name */
        public ux.a f28327p = null;

        /* renamed from: q  reason: collision with root package name */
        public qx.a f28328q = DefaultConfigurationFactory.a();

        /* renamed from: r  reason: collision with root package name */
        public Handler f28329r = null;

        /* renamed from: s  reason: collision with root package name */
        public boolean f28330s = false;

        public Builder A(boolean z11) {
            this.f28318g = z11;
            return this;
        }

        public Builder B(int i11) {
            this.f28313b = i11;
            return this;
        }

        public Builder C(Drawable drawable) {
            this.f28316e = drawable;
            return this;
        }

        public Builder D(int i11) {
            this.f28314c = i11;
            return this;
        }

        public Builder E(Drawable drawable) {
            this.f28317f = drawable;
            return this;
        }

        public Builder F(int i11) {
            this.f28312a = i11;
            return this;
        }

        public Builder G(Drawable drawable) {
            this.f28315d = drawable;
            return this;
        }

        public Builder t(Bitmap.Config config) {
            if (config != null) {
                this.f28322k.inPreferredConfig = config;
                return this;
            }
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }

        public DisplayImageOptions u() {
            return new DisplayImageOptions(this);
        }

        public Builder v(boolean z11) {
            this.f28319h = z11;
            return this;
        }

        public Builder w(boolean z11) {
            this.f28320i = z11;
            return this;
        }

        public Builder x(DisplayImageOptions displayImageOptions) {
            this.f28312a = displayImageOptions.f28293a;
            this.f28313b = displayImageOptions.f28294b;
            this.f28314c = displayImageOptions.f28295c;
            this.f28315d = displayImageOptions.f28296d;
            this.f28316e = displayImageOptions.f28297e;
            this.f28317f = displayImageOptions.f28298f;
            this.f28318g = displayImageOptions.f28299g;
            this.f28319h = displayImageOptions.f28300h;
            this.f28320i = displayImageOptions.f28301i;
            this.f28321j = displayImageOptions.f28302j;
            this.f28322k = displayImageOptions.f28303k;
            this.f28323l = displayImageOptions.f28304l;
            this.f28324m = displayImageOptions.f28305m;
            this.f28325n = displayImageOptions.f28306n;
            this.f28326o = displayImageOptions.f28307o;
            this.f28327p = displayImageOptions.f28308p;
            this.f28328q = displayImageOptions.f28309q;
            this.f28329r = displayImageOptions.f28310r;
            this.f28330s = displayImageOptions.f28311s;
            return this;
        }

        public Builder y(qx.a aVar) {
            if (aVar != null) {
                this.f28328q = aVar;
                return this;
            }
            throw new IllegalArgumentException("displayer can't be null");
        }

        public Builder z(ImageScaleType imageScaleType) {
            this.f28321j = imageScaleType;
            return this;
        }
    }

    public static DisplayImageOptions t() {
        return new Builder().u();
    }

    public Drawable A(Resources resources) {
        int i11 = this.f28295c;
        return i11 != 0 ? resources.getDrawable(i11) : this.f28298f;
    }

    public Drawable B(Resources resources) {
        int i11 = this.f28293a;
        return i11 != 0 ? resources.getDrawable(i11) : this.f28296d;
    }

    public ImageScaleType C() {
        return this.f28302j;
    }

    public ux.a D() {
        return this.f28308p;
    }

    public ux.a E() {
        return this.f28307o;
    }

    public boolean F() {
        return this.f28300h;
    }

    public boolean G() {
        return this.f28301i;
    }

    public boolean H() {
        return this.f28305m;
    }

    public boolean I() {
        return this.f28299g;
    }

    public boolean J() {
        return this.f28311s;
    }

    public boolean K() {
        return this.f28304l > 0;
    }

    public boolean L() {
        return this.f28308p != null;
    }

    public boolean M() {
        return this.f28307o != null;
    }

    public boolean N() {
        return (this.f28297e == null && this.f28294b == 0) ? false : true;
    }

    public boolean O() {
        return (this.f28298f == null && this.f28295c == 0) ? false : true;
    }

    public boolean P() {
        return (this.f28296d == null && this.f28293a == 0) ? false : true;
    }

    public BitmapFactory.Options u() {
        return this.f28303k;
    }

    public int v() {
        return this.f28304l;
    }

    public qx.a w() {
        return this.f28309q;
    }

    public Object x() {
        return this.f28306n;
    }

    public Handler y() {
        return this.f28310r;
    }

    public Drawable z(Resources resources) {
        int i11 = this.f28294b;
        return i11 != 0 ? resources.getDrawable(i11) : this.f28297e;
    }

    public DisplayImageOptions(Builder builder) {
        this.f28293a = builder.f28312a;
        this.f28294b = builder.f28313b;
        this.f28295c = builder.f28314c;
        this.f28296d = builder.f28315d;
        this.f28297e = builder.f28316e;
        this.f28298f = builder.f28317f;
        this.f28299g = builder.f28318g;
        this.f28300h = builder.f28319h;
        this.f28301i = builder.f28320i;
        this.f28302j = builder.f28321j;
        this.f28303k = builder.f28322k;
        this.f28304l = builder.f28323l;
        this.f28305m = builder.f28324m;
        this.f28306n = builder.f28325n;
        this.f28307o = builder.f28326o;
        this.f28308p = builder.f28327p;
        this.f28309q = builder.f28328q;
        this.f28310r = builder.f28329r;
        this.f28311s = builder.f28330s;
    }
}
