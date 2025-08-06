package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f28380a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28381b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28382c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28383d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28384e;

    /* renamed from: f  reason: collision with root package name */
    public final ux.a f28385f;

    /* renamed from: g  reason: collision with root package name */
    public final Executor f28386g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f28387h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f28388i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f28389j;

    /* renamed from: k  reason: collision with root package name */
    public final int f28390k;

    /* renamed from: l  reason: collision with root package name */
    public final int f28391l;

    /* renamed from: m  reason: collision with root package name */
    public final QueueProcessingType f28392m;

    /* renamed from: n  reason: collision with root package name */
    public final mx.a f28393n;

    /* renamed from: o  reason: collision with root package name */
    public final ix.a f28394o;

    /* renamed from: p  reason: collision with root package name */
    public final ImageDownloader f28395p;

    /* renamed from: q  reason: collision with root package name */
    public final px.b f28396q;

    /* renamed from: r  reason: collision with root package name */
    public final DisplayImageOptions f28397r;

    /* renamed from: s  reason: collision with root package name */
    public final ImageDownloader f28398s;

    /* renamed from: t  reason: collision with root package name */
    public final ImageDownloader f28399t;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28400a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme[] r0 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28400a = r0
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28400a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.c.a.<clinit>():void");
        }
    }

    public static class b {

        /* renamed from: y  reason: collision with root package name */
        public static final QueueProcessingType f28401y = QueueProcessingType.FIFO;

        /* renamed from: a  reason: collision with root package name */
        public Context f28402a;

        /* renamed from: b  reason: collision with root package name */
        public int f28403b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f28404c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f28405d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f28406e = 0;

        /* renamed from: f  reason: collision with root package name */
        public ux.a f28407f = null;

        /* renamed from: g  reason: collision with root package name */
        public Executor f28408g = null;

        /* renamed from: h  reason: collision with root package name */
        public Executor f28409h = null;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28410i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f28411j = false;

        /* renamed from: k  reason: collision with root package name */
        public int f28412k = 3;

        /* renamed from: l  reason: collision with root package name */
        public int f28413l = 3;

        /* renamed from: m  reason: collision with root package name */
        public boolean f28414m = false;

        /* renamed from: n  reason: collision with root package name */
        public QueueProcessingType f28415n = f28401y;

        /* renamed from: o  reason: collision with root package name */
        public int f28416o = 0;

        /* renamed from: p  reason: collision with root package name */
        public long f28417p = 0;

        /* renamed from: q  reason: collision with root package name */
        public int f28418q = 0;

        /* renamed from: r  reason: collision with root package name */
        public mx.a f28419r = null;

        /* renamed from: s  reason: collision with root package name */
        public ix.a f28420s = null;

        /* renamed from: t  reason: collision with root package name */
        public lx.a f28421t = null;

        /* renamed from: u  reason: collision with root package name */
        public ImageDownloader f28422u = null;

        /* renamed from: v  reason: collision with root package name */
        public px.b f28423v;

        /* renamed from: w  reason: collision with root package name */
        public DisplayImageOptions f28424w = null;

        /* renamed from: x  reason: collision with root package name */
        public boolean f28425x = false;

        public b(Context context) {
            this.f28402a = context.getApplicationContext();
        }

        public b A(int i11) {
            if (i11 > 0) {
                if (this.f28419r != null) {
                    vx.c.f("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
                }
                this.f28416o = i11;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public b B(int i11) {
            if (i11 <= 0 || i11 >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.f28419r != null) {
                vx.c.f("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.f28416o = (int) (((float) Runtime.getRuntime().maxMemory()) * (((float) i11) / 100.0f));
            return this;
        }

        public b C(QueueProcessingType queueProcessingType) {
            if (!(this.f28408g == null && this.f28409h == null)) {
                vx.c.f("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.f28415n = queueProcessingType;
            return this;
        }

        public b D(int i11) {
            if (!(this.f28408g == null && this.f28409h == null)) {
                vx.c.f("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.f28412k = i11;
            return this;
        }

        public b E(int i11) {
            if (!(this.f28408g == null && this.f28409h == null)) {
                vx.c.f("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            if (i11 < 1) {
                this.f28413l = 1;
            } else if (i11 > 10) {
                this.f28413l = 10;
            } else {
                this.f28413l = i11;
            }
            return this;
        }

        public c t() {
            z();
            return new c(this, (a) null);
        }

        public b u(int i11, int i12, ux.a aVar) {
            this.f28405d = i11;
            this.f28406e = i12;
            this.f28407f = aVar;
            return this;
        }

        public b v(int i11) {
            if (i11 > 0) {
                if (this.f28420s != null) {
                    vx.c.f("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.f28418q = i11;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public b w(lx.a aVar) {
            if (this.f28420s != null) {
                vx.c.f("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.f28421t = aVar;
            return this;
        }

        public b x(int i11) {
            if (i11 > 0) {
                if (this.f28420s != null) {
                    vx.c.f("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.f28417p = (long) i11;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public b y(ImageDownloader imageDownloader) {
            this.f28422u = imageDownloader;
            return this;
        }

        public final void z() {
            if (this.f28408g == null) {
                this.f28408g = DefaultConfigurationFactory.c(this.f28412k, this.f28413l, this.f28415n);
            } else {
                this.f28410i = true;
            }
            if (this.f28409h == null) {
                this.f28409h = DefaultConfigurationFactory.c(this.f28412k, this.f28413l, this.f28415n);
            } else {
                this.f28411j = true;
            }
            if (this.f28420s == null) {
                if (this.f28421t == null) {
                    this.f28421t = DefaultConfigurationFactory.d();
                }
                this.f28420s = DefaultConfigurationFactory.b(this.f28402a, this.f28421t, this.f28417p, this.f28418q);
            }
            if (this.f28419r == null) {
                this.f28419r = DefaultConfigurationFactory.g(this.f28402a, this.f28416o);
            }
            if (this.f28414m) {
                this.f28419r = new nx.a(this.f28419r, vx.d.a());
            }
            if (this.f28422u == null) {
                this.f28422u = DefaultConfigurationFactory.f(this.f28402a);
            }
            if (this.f28423v == null) {
                this.f28423v = DefaultConfigurationFactory.e(this.f28425x);
            }
            if (this.f28424w == null) {
                this.f28424w = DisplayImageOptions.t();
            }
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.c$c  reason: collision with other inner class name */
    public static class C0246c implements ImageDownloader {

        /* renamed from: a  reason: collision with root package name */
        public final ImageDownloader f28426a;

        public C0246c(ImageDownloader imageDownloader) {
            this.f28426a = imageDownloader;
        }

        public InputStream a(String str, Object obj) throws IOException {
            int i11 = a.f28400a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i11 != 1 && i11 != 2) {
                return this.f28426a.a(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    public static class d implements ImageDownloader {

        /* renamed from: a  reason: collision with root package name */
        public final ImageDownloader f28427a;

        public d(ImageDownloader imageDownloader) {
            this.f28427a = imageDownloader;
        }

        public InputStream a(String str, Object obj) throws IOException {
            InputStream a11 = this.f28427a.a(str, obj);
            int i11 = a.f28400a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i11 == 1 || i11 == 2) {
                return new ox.b(a11);
            }
            return a11;
        }
    }

    public /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public ox.c a() {
        DisplayMetrics displayMetrics = this.f28380a.getDisplayMetrics();
        int i11 = this.f28381b;
        if (i11 <= 0) {
            i11 = displayMetrics.widthPixels;
        }
        int i12 = this.f28382c;
        if (i12 <= 0) {
            i12 = displayMetrics.heightPixels;
        }
        return new ox.c(i11, i12);
    }

    public c(b bVar) {
        this.f28380a = bVar.f28402a.getResources();
        this.f28381b = bVar.f28403b;
        this.f28382c = bVar.f28404c;
        this.f28383d = bVar.f28405d;
        this.f28384e = bVar.f28406e;
        this.f28385f = bVar.f28407f;
        this.f28386g = bVar.f28408g;
        this.f28387h = bVar.f28409h;
        this.f28390k = bVar.f28412k;
        this.f28391l = bVar.f28413l;
        this.f28392m = bVar.f28415n;
        this.f28394o = bVar.f28420s;
        this.f28393n = bVar.f28419r;
        this.f28397r = bVar.f28424w;
        ImageDownloader g11 = bVar.f28422u;
        this.f28395p = g11;
        this.f28396q = bVar.f28423v;
        this.f28388i = bVar.f28410i;
        this.f28389j = bVar.f28411j;
        this.f28398s = new C0246c(g11);
        this.f28399t = new d(g11);
        vx.c.g(bVar.f28425x);
    }
}
