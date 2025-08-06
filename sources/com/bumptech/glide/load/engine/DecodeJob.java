package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.engine.g;
import g4.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DecodeJob<R> implements e.a, Runnable, Comparable<DecodeJob<?>>, a.f {
    public Object A;
    public DataSource B;
    public o3.d<?> C;
    public volatile e D;
    public volatile boolean E;
    public volatile boolean F;

    /* renamed from: b  reason: collision with root package name */
    public final f<R> f63673b = new f<>();

    /* renamed from: c  reason: collision with root package name */
    public final List<Throwable> f63674c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final g4.c f63675d = g4.c.a();

    /* renamed from: e  reason: collision with root package name */
    public final e f63676e;

    /* renamed from: f  reason: collision with root package name */
    public final androidx.core.util.e<DecodeJob<?>> f63677f;

    /* renamed from: g  reason: collision with root package name */
    public final d<?> f63678g = new d<>();

    /* renamed from: h  reason: collision with root package name */
    public final f f63679h = new f();

    /* renamed from: i  reason: collision with root package name */
    public com.bumptech.glide.b f63680i;

    /* renamed from: j  reason: collision with root package name */
    public n3.b f63681j;

    /* renamed from: k  reason: collision with root package name */
    public Priority f63682k;

    /* renamed from: l  reason: collision with root package name */
    public k f63683l;

    /* renamed from: m  reason: collision with root package name */
    public int f63684m;

    /* renamed from: n  reason: collision with root package name */
    public int f63685n;

    /* renamed from: o  reason: collision with root package name */
    public DiskCacheStrategy f63686o;

    /* renamed from: p  reason: collision with root package name */
    public Options f63687p;

    /* renamed from: q  reason: collision with root package name */
    public b<R> f63688q;

    /* renamed from: r  reason: collision with root package name */
    public int f63689r;

    /* renamed from: s  reason: collision with root package name */
    public Stage f63690s;

    /* renamed from: t  reason: collision with root package name */
    public RunReason f63691t;

    /* renamed from: u  reason: collision with root package name */
    public long f63692u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f63693v;

    /* renamed from: w  reason: collision with root package name */
    public Object f63694w;

    /* renamed from: x  reason: collision with root package name */
    public Thread f63695x;

    /* renamed from: y  reason: collision with root package name */
    public n3.b f63696y;

    /* renamed from: z  reason: collision with root package name */
    public n3.b f63697z;

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63698a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f63699b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f63700c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63700c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f63700c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f63699b = r2
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f63699b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f63699b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f63699b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f63699b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f63698a = r3
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f63698a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f63698a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.a.<clinit>():void");
        }
    }

    public interface b<R> {
        void b(GlideException glideException);

        void c(r<R> rVar, DataSource dataSource);

        void d(DecodeJob<?> decodeJob);
    }

    public final class c<Z> implements g.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        public final DataSource f63701a;

        public c(DataSource dataSource) {
            this.f63701a = dataSource;
        }

        public r<Z> a(r<Z> rVar) {
            return DecodeJob.this.w(this.f63701a, rVar);
        }
    }

    public static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        public n3.b f63703a;

        /* renamed from: b  reason: collision with root package name */
        public n3.f<Z> f63704b;

        /* renamed from: c  reason: collision with root package name */
        public q<Z> f63705c;

        public void a() {
            this.f63703a = null;
            this.f63704b = null;
            this.f63705c = null;
        }

        public void b(e eVar, Options options) {
            g4.b.a("DecodeJob.encode");
            try {
                eVar.a().b(this.f63703a, new d(this.f63704b, this.f63705c, options));
            } finally {
                this.f63705c.f();
                g4.b.d();
            }
        }

        public boolean c() {
            return this.f63705c != null;
        }

        public <X> void d(n3.b bVar, n3.f<X> fVar, q<X> qVar) {
            this.f63703a = bVar;
            this.f63704b = fVar;
            this.f63705c = qVar;
        }
    }

    public interface e {
        com.bumptech.glide.load.engine.cache.a a();
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63706a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63707b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63708c;

        public final boolean a(boolean z11) {
            return (this.f63708c || z11 || this.f63707b) && this.f63706a;
        }

        public synchronized boolean b() {
            this.f63707b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.f63708c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z11) {
            this.f63706a = true;
            return a(z11);
        }

        public synchronized void e() {
            this.f63707b = false;
            this.f63706a = false;
            this.f63708c = false;
        }
    }

    public DecodeJob(e eVar, androidx.core.util.e<DecodeJob<?>> eVar2) {
        this.f63676e = eVar;
        this.f63677f = eVar2;
    }

    public final <Data, ResourceType> r<R> A(Data data, DataSource dataSource, p<Data, ResourceType, R> pVar) throws GlideException {
        Options m11 = m(dataSource);
        com.bumptech.glide.load.data.a l11 = this.f63680i.h().l(data);
        try {
            return pVar.a(l11, m11, this.f63684m, this.f63685n, new c(dataSource));
        } finally {
            l11.b();
        }
    }

    public final void B() {
        int i11 = a.f63698a[this.f63691t.ordinal()];
        if (i11 == 1) {
            this.f63690s = l(Stage.INITIALIZE);
            this.D = k();
            z();
        } else if (i11 == 2) {
            z();
        } else if (i11 == 3) {
            j();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f63691t);
        }
    }

    public final void C() {
        Throwable th2;
        this.f63675d.c();
        if (this.E) {
            if (this.f63674c.isEmpty()) {
                th2 = null;
            } else {
                List<Throwable> list = this.f63674c;
                th2 = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th2);
        }
        this.E = true;
    }

    public boolean D() {
        Stage l11 = l(Stage.INITIALIZE);
        return l11 == Stage.RESOURCE_CACHE || l11 == Stage.DATA_CACHE;
    }

    public void a() {
        this.F = true;
        e eVar = this.D;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public void b(n3.b bVar, Object obj, o3.d<?> dVar, DataSource dataSource, n3.b bVar2) {
        this.f63696y = bVar;
        this.A = obj;
        this.C = dVar;
        this.B = dataSource;
        this.f63697z = bVar2;
        if (Thread.currentThread() != this.f63695x) {
            this.f63691t = RunReason.DECODE_DATA;
            this.f63688q.d(this);
            return;
        }
        g4.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            j();
        } finally {
            g4.b.d();
        }
    }

    public void c(n3.b bVar, Exception exc, o3.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(bVar, dataSource, dVar.a());
        this.f63674c.add(glideException);
        if (Thread.currentThread() != this.f63695x) {
            this.f63691t = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f63688q.d(this);
            return;
        }
        z();
    }

    public g4.c e() {
        return this.f63675d;
    }

    public void f() {
        this.f63691t = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f63688q.d(this);
    }

    /* renamed from: g */
    public int compareTo(DecodeJob<?> decodeJob) {
        int n11 = n() - decodeJob.n();
        return n11 == 0 ? this.f63689r - decodeJob.f63689r : n11;
    }

    public final <Data> r<R> h(o3.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long b11 = f4.e.b();
            r<R> i11 = i(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                p("Decoded result " + i11, b11);
            }
            return i11;
        } finally {
            dVar.b();
        }
    }

    public final <Data> r<R> i(Data data, DataSource dataSource) throws GlideException {
        return A(data, dataSource, this.f63673b.h(data.getClass()));
    }

    public final void j() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j11 = this.f63692u;
            q("Retrieved data", j11, "data: " + this.A + ", cache key: " + this.f63696y + ", fetcher: " + this.C);
        }
        r<R> rVar = null;
        try {
            rVar = h(this.C, this.A, this.B);
        } catch (GlideException e11) {
            e11.setLoggingDetails(this.f63697z, this.B);
            this.f63674c.add(e11);
        }
        if (rVar != null) {
            s(rVar, this.B);
        } else {
            z();
        }
    }

    public final e k() {
        int i11 = a.f63699b[this.f63690s.ordinal()];
        if (i11 == 1) {
            return new s(this.f63673b, this);
        }
        if (i11 == 2) {
            return new b(this.f63673b, this);
        }
        if (i11 == 3) {
            return new v(this.f63673b, this);
        }
        if (i11 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f63690s);
    }

    public final Stage l(Stage stage) {
        int i11 = a.f63699b[stage.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return this.f63693v ? Stage.FINISHED : Stage.SOURCE;
            }
            if (i11 == 3 || i11 == 4) {
                return Stage.FINISHED;
            }
            if (i11 != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + stage);
            } else if (this.f63686o.b()) {
                return Stage.RESOURCE_CACHE;
            } else {
                return l(Stage.RESOURCE_CACHE);
            }
        } else if (this.f63686o.a()) {
            return Stage.DATA_CACHE;
        } else {
            return l(Stage.DATA_CACHE);
        }
    }

    public final Options m(DataSource dataSource) {
        Options options = this.f63687p;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        boolean z11 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f63673b.w();
        n3.d dVar = com.bumptech.glide.load.resource.bitmap.e.f64082j;
        Boolean bool = (Boolean) options.a(dVar);
        if (bool != null && (!bool.booleanValue() || z11)) {
            return options;
        }
        Options options2 = new Options();
        options2.b(this.f63687p);
        options2.c(dVar, Boolean.valueOf(z11));
        return options2;
    }

    public final int n() {
        return this.f63682k.ordinal();
    }

    public DecodeJob<R> o(com.bumptech.glide.b bVar, Object obj, k kVar, n3.b bVar2, int i11, int i12, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, n3.g<?>> map, boolean z11, boolean z12, boolean z13, Options options, b<R> bVar3, int i13) {
        this.f63673b.u(bVar, obj, bVar2, i11, i12, diskCacheStrategy, cls, cls2, priority, options, map, z11, z12, this.f63676e);
        this.f63680i = bVar;
        this.f63681j = bVar2;
        this.f63682k = priority;
        this.f63683l = kVar;
        this.f63684m = i11;
        this.f63685n = i12;
        this.f63686o = diskCacheStrategy;
        this.f63693v = z13;
        this.f63687p = options;
        this.f63688q = bVar3;
        this.f63689r = i13;
        this.f63691t = RunReason.INITIALIZE;
        this.f63694w = obj;
        return this;
    }

    public final void p(String str, long j11) {
        q(str, j11, (String) null);
    }

    public final void q(String str, long j11, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(f4.e.a(j11));
        sb2.append(", load key: ");
        sb2.append(this.f63683l);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb2.toString());
    }

    public final void r(r<R> rVar, DataSource dataSource) {
        C();
        this.f63688q.c(rVar, dataSource);
    }

    public void run() {
        g4.b.b("DecodeJob#run(model=%s)", this.f63694w);
        o3.d<?> dVar = this.C;
        try {
            if (this.F) {
                t();
                if (dVar != null) {
                    dVar.b();
                }
                g4.b.d();
                return;
            }
            B();
            if (dVar != null) {
                dVar.b();
            }
            g4.b.d();
        } catch (CallbackException e11) {
            throw e11;
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            g4.b.d();
            throw th2;
        }
    }

    public final void s(r<R> rVar, DataSource dataSource) {
        if (rVar instanceof n) {
            ((n) rVar).initialize();
        }
        q<R> qVar = null;
        q<R> qVar2 = rVar;
        if (this.f63678g.c()) {
            q<R> c11 = q.c(rVar);
            qVar = c11;
            qVar2 = c11;
        }
        r(qVar2, dataSource);
        this.f63690s = Stage.ENCODE;
        try {
            if (this.f63678g.c()) {
                this.f63678g.b(this.f63676e, this.f63687p);
            }
            u();
        } finally {
            if (qVar != null) {
                qVar.f();
            }
        }
    }

    public final void t() {
        C();
        this.f63688q.b(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.f63674c)));
        v();
    }

    public final void u() {
        if (this.f63679h.b()) {
            y();
        }
    }

    public final void v() {
        if (this.f63679h.c()) {
            y();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.bumptech.glide.load.engine.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bumptech.glide.load.engine.t} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.engine.t} */
    /* JADX WARNING: type inference failed for: r12v5, types: [n3.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.bumptech.glide.load.engine.r<Z> w(com.bumptech.glide.load.DataSource r12, com.bumptech.glide.load.engine.r<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.f<R> r0 = r11.f63673b
            n3.g r0 = r0.r(r8)
            com.bumptech.glide.b r2 = r11.f63680i
            int r3 = r11.f63684m
            int r4 = r11.f63685n
            com.bumptech.glide.load.engine.r r2 = r0.transform(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.recycle()
        L_0x002b:
            com.bumptech.glide.load.engine.f<R> r13 = r11.f63673b
            boolean r13 = r13.v(r0)
            if (r13 == 0) goto L_0x0040
            com.bumptech.glide.load.engine.f<R> r13 = r11.f63673b
            n3.f r1 = r13.n(r0)
            com.bumptech.glide.load.Options r13 = r11.f63687p
            com.bumptech.glide.load.EncodeStrategy r13 = r1.b(r13)
            goto L_0x0042
        L_0x0040:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            com.bumptech.glide.load.engine.f<R> r1 = r11.f63673b
            n3.b r2 = r11.f63696y
            boolean r1 = r1.x(r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = r11.f63686o
            boolean r12 = r3.d(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.a.f63700c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            com.bumptech.glide.load.engine.t r12 = new com.bumptech.glide.load.engine.t
            com.bumptech.glide.load.engine.f<R> r13 = r11.f63673b
            com.bumptech.glide.load.engine.bitmap_recycle.b r2 = r13.b()
            n3.b r3 = r11.f63696y
            n3.b r4 = r11.f63681j
            int r5 = r11.f63684m
            int r6 = r11.f63685n
            com.bumptech.glide.load.Options r9 = r11.f63687p
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            com.bumptech.glide.load.engine.c r12 = new com.bumptech.glide.load.engine.c
            n3.b r13 = r11.f63696y
            n3.b r1 = r11.f63681j
            r12.<init>(r13, r1)
        L_0x009b:
            com.bumptech.glide.load.engine.q r0 = com.bumptech.glide.load.engine.q.c(r0)
            com.bumptech.glide.load.engine.DecodeJob$d<?> r13 = r11.f63678g
            r13.d(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.w(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.r):com.bumptech.glide.load.engine.r");
    }

    public void x(boolean z11) {
        if (this.f63679h.d(z11)) {
            y();
        }
    }

    public final void y() {
        this.f63679h.e();
        this.f63678g.a();
        this.f63673b.a();
        this.E = false;
        this.f63680i = null;
        this.f63681j = null;
        this.f63687p = null;
        this.f63682k = null;
        this.f63683l = null;
        this.f63688q = null;
        this.f63690s = null;
        this.D = null;
        this.f63695x = null;
        this.f63696y = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.f63692u = 0;
        this.F = false;
        this.f63694w = null;
        this.f63674c.clear();
        this.f63677f.release(this);
    }

    public final void z() {
        this.f63695x = Thread.currentThread();
        this.f63692u = f4.e.b();
        boolean z11 = false;
        while (!this.F && this.D != null && !(z11 = this.D.a())) {
            this.f63690s = l(this.f63690s);
            this.D = k();
            if (this.f63690s == Stage.SOURCE) {
                f();
                return;
            }
        }
        if ((this.f63690s == Stage.FINISHED || this.F) && !z11) {
            t();
        }
    }
}
