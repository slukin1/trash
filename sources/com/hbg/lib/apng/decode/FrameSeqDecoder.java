package com.hbg.lib.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import y5.a;
import y5.b;

public abstract class FrameSeqDecoder<R extends y5.a, W extends y5.b> {

    /* renamed from: u  reason: collision with root package name */
    public static final Rect f66133u = new Rect();

    /* renamed from: a  reason: collision with root package name */
    public final int f66134a;

    /* renamed from: b  reason: collision with root package name */
    public final a6.b f66135b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f66136c;

    /* renamed from: d  reason: collision with root package name */
    public List<g> f66137d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public int f66138e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f66139f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f66140g = null;

    /* renamed from: h  reason: collision with root package name */
    public Set<j> f66141h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f66142i = new AtomicBoolean(true);

    /* renamed from: j  reason: collision with root package name */
    public Runnable f66143j = new a();

    /* renamed from: k  reason: collision with root package name */
    public int f66144k = 1;

    /* renamed from: l  reason: collision with root package name */
    public Set<Bitmap> f66145l = new HashSet();

    /* renamed from: m  reason: collision with root package name */
    public final Object f66146m = new Object();

    /* renamed from: n  reason: collision with root package name */
    public Map<Bitmap, Canvas> f66147n = new WeakHashMap();

    /* renamed from: o  reason: collision with root package name */
    public ByteBuffer f66148o;

    /* renamed from: p  reason: collision with root package name */
    public volatile Rect f66149p;

    /* renamed from: q  reason: collision with root package name */
    public W f66150q = z();

    /* renamed from: r  reason: collision with root package name */
    public R f66151r = null;

    /* renamed from: s  reason: collision with root package name */
    public boolean f66152s = false;

    /* renamed from: t  reason: collision with root package name */
    public volatile State f66153t = State.IDLE;

    public enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (!FrameSeqDecoder.this.f66142i.get()) {
                if (FrameSeqDecoder.this.p()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    FrameSeqDecoder.this.f66136c.postDelayed(this, Math.max(0, FrameSeqDecoder.this.N() - (System.currentTimeMillis() - currentTimeMillis)));
                    for (j b11 : FrameSeqDecoder.this.f66141h) {
                        b11.b(FrameSeqDecoder.this.f66148o);
                    }
                    return;
                }
                FrameSeqDecoder.this.O();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f66155b;

        public b(j jVar) {
            this.f66155b = jVar;
        }

        public void run() {
            FrameSeqDecoder.this.f66141h.add(this.f66155b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f66157b;

        public c(j jVar) {
            this.f66157b = jVar;
        }

        public void run() {
            FrameSeqDecoder.this.f66141h.remove(this.f66157b);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            if (FrameSeqDecoder.this.f66141h.size() == 0) {
                FrameSeqDecoder.this.O();
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread f66160b;

        public e(Thread thread) {
            this.f66160b = thread;
        }

        public void run() {
            try {
                if (FrameSeqDecoder.this.f66149p == null) {
                    if (FrameSeqDecoder.this.f66151r == null) {
                        FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                        y5.a unused = frameSeqDecoder.f66151r = frameSeqDecoder.x(frameSeqDecoder.f66135b.a());
                    } else {
                        FrameSeqDecoder.this.f66151r.reset();
                    }
                    FrameSeqDecoder frameSeqDecoder2 = FrameSeqDecoder.this;
                    frameSeqDecoder2.A(frameSeqDecoder2.F(frameSeqDecoder2.f66151r));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                FrameSeqDecoder.this.f66149p = FrameSeqDecoder.f66133u;
            } catch (Throwable th2) {
                LockSupport.unpark(this.f66160b);
                throw th2;
            }
            LockSupport.unpark(this.f66160b);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            FrameSeqDecoder.this.B();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            FrameSeqDecoder.this.C();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            int unused = FrameSeqDecoder.this.f66139f = 0;
            FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
            frameSeqDecoder.f66138e = -1;
            boolean unused2 = frameSeqDecoder.f66152s = false;
        }
    }

    public class i implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f66165b;

        public i(boolean z11) {
            this.f66165b = z11;
        }

        public void run() {
            FrameSeqDecoder.this.C();
            try {
                FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                frameSeqDecoder.A(frameSeqDecoder.F(frameSeqDecoder.x(frameSeqDecoder.f66135b.a())));
                if (this.f66165b) {
                    FrameSeqDecoder.this.B();
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    public interface j {
        void a();

        void b(ByteBuffer byteBuffer);

        void onStart();
    }

    public FrameSeqDecoder(a6.b bVar, j jVar) {
        this.f66135b = bVar;
        if (jVar != null) {
            this.f66141h.add(jVar);
        }
        int a11 = x5.a.b().a();
        this.f66134a = a11;
        this.f66136c = new Handler(x5.a.b().c(a11));
    }

    public final void A(Rect rect) {
        this.f66149p = rect;
        int width = rect.width() * rect.height();
        int i11 = this.f66144k;
        this.f66148o = ByteBuffer.allocate(((width / (i11 * i11)) + 1) * 4);
        if (this.f66150q == null) {
            this.f66150q = z();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void B() {
        this.f66142i.compareAndSet(true, false);
        System.currentTimeMillis();
        try {
            if (this.f66137d.size() == 0) {
                try {
                    R r11 = this.f66151r;
                    if (r11 == null) {
                        this.f66151r = x(this.f66135b.a());
                    } else {
                        r11.reset();
                    }
                    A(F(this.f66151r));
                } catch (Throwable unused) {
                }
            }
            this.f66153t = State.RUNNING;
            if (w() == 0 || !this.f66152s) {
                this.f66138e = -1;
                this.f66143j.run();
                for (j onStart : this.f66141h) {
                    onStart.onStart();
                }
                return;
            }
            Log.i("wuxinrong", q() + " No need to started");
        } catch (Throwable th2) {
            this.f66153t = State.RUNNING;
            throw th2;
        }
    }

    public final void C() {
        this.f66136c.removeCallbacks(this.f66143j);
        this.f66137d.clear();
        synchronized (this.f66146m) {
            for (Bitmap next : this.f66145l) {
                if (next != null && !next.isRecycled()) {
                    next.recycle();
                }
            }
            this.f66145l.clear();
        }
        if (this.f66148o != null) {
            this.f66148o = null;
        }
        this.f66147n.clear();
        try {
            R r11 = this.f66151r;
            if (r11 != null) {
                r11.close();
                this.f66151r = null;
            }
            W w11 = this.f66150q;
            if (w11 != null) {
                w11.close();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        H();
        this.f66153t = State.IDLE;
        for (j a11 : this.f66141h) {
            a11.a();
        }
    }

    public boolean D() {
        return this.f66153t == State.RUNNING || this.f66153t == State.INITIALIZING;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap E(int r8, int r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f66146m
            monitor-enter(r0)
            r1 = 0
            java.util.Set<android.graphics.Bitmap> r2 = r7.f66145l     // Catch:{ all -> 0x006d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x006d }
        L_0x000a:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x006d }
            if (r3 == 0) goto L_0x0060
            int r1 = r8 * r9
            int r1 = r1 * 4
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x006d }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ all -> 0x006d }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006d }
            r5 = 19
            r6 = 0
            if (r4 < r5) goto L_0x0042
            if (r3 == 0) goto L_0x005e
            int r4 = r3.getAllocationByteCount()     // Catch:{ all -> 0x006d }
            if (r4 < r1) goto L_0x005e
            r2.remove()     // Catch:{ all -> 0x006d }
            int r1 = r3.getWidth()     // Catch:{ all -> 0x006d }
            if (r1 != r8) goto L_0x0038
            int r1 = r3.getHeight()     // Catch:{ all -> 0x006d }
            if (r1 == r9) goto L_0x003d
        L_0x0038:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x006d }
            r3.reconfigure(r8, r9, r1)     // Catch:{ all -> 0x006d }
        L_0x003d:
            r3.eraseColor(r6)     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r3
        L_0x0042:
            if (r3 == 0) goto L_0x005e
            int r4 = r3.getByteCount()     // Catch:{ all -> 0x006d }
            if (r4 < r1) goto L_0x005e
            int r1 = r3.getWidth()     // Catch:{ all -> 0x006d }
            if (r1 != r8) goto L_0x005c
            int r8 = r3.getHeight()     // Catch:{ all -> 0x006d }
            if (r8 != r9) goto L_0x005c
            r2.remove()     // Catch:{ all -> 0x006d }
            r3.eraseColor(r6)     // Catch:{ all -> 0x006d }
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r3
        L_0x005e:
            r1 = r3
            goto L_0x000a
        L_0x0060:
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ OutOfMemoryError -> 0x0067 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r8, r9, r2)     // Catch:{ OutOfMemoryError -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r1
        L_0x006d:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.apng.decode.FrameSeqDecoder.E(int, int):android.graphics.Bitmap");
    }

    public abstract Rect F(R r11) throws IOException;

    public void G(Bitmap bitmap) {
        synchronized (this.f66146m) {
            if (bitmap != null) {
                if (!this.f66145l.contains(bitmap)) {
                    this.f66145l.add(bitmap);
                }
            }
        }
    }

    public abstract void H();

    public void I(j jVar) {
        this.f66136c.post(new c(jVar));
    }

    public abstract void J(g gVar);

    public void K() {
        this.f66136c.post(new h());
    }

    public boolean L(int i11, int i12) {
        int s11 = s(i11, i12);
        if (s11 == this.f66144k) {
            return false;
        }
        this.f66144k = s11;
        boolean D = D();
        this.f66136c.removeCallbacks(this.f66143j);
        this.f66136c.post(new i(D));
        return true;
    }

    public void M() {
        State state;
        if (this.f66149p != f66133u) {
            if (this.f66153t == State.RUNNING || this.f66153t == (state = State.INITIALIZING)) {
                Log.i("wuxinrong", q() + " Already started");
                return;
            }
            if (this.f66153t == State.FINISHING) {
                Log.e("wuxinrong", q() + " Processing,wait for finish at " + this.f66153t);
            }
            this.f66153t = state;
            if (Looper.myLooper() == this.f66136c.getLooper()) {
                B();
            } else {
                this.f66136c.post(new f());
            }
        }
    }

    public final long N() {
        int i11 = this.f66138e + 1;
        this.f66138e = i11;
        if (i11 >= u()) {
            this.f66138e = 0;
            this.f66139f++;
        }
        g t11 = t(this.f66138e);
        if (t11 == null) {
            return 0;
        }
        J(t11);
        return (long) t11.f66207f;
    }

    public void O() {
        if (this.f66149p != f66133u) {
            State state = this.f66153t;
            State state2 = State.FINISHING;
            if (state == state2 || this.f66153t == State.IDLE) {
                Log.i("wuxinrong", q() + "No need to stop");
                return;
            }
            if (this.f66153t == State.INITIALIZING) {
                Log.e("wuxinrong", q() + "Processing,wait for finish at " + this.f66153t);
            }
            this.f66153t = state2;
            if (Looper.myLooper() == this.f66136c.getLooper()) {
                C();
            } else {
                this.f66136c.post(new g());
            }
        }
    }

    public void P() {
        this.f66136c.post(new d());
    }

    public void o(j jVar) {
        this.f66136c.post(new b(jVar));
    }

    public final boolean p() {
        if (!D() || this.f66137d.size() == 0) {
            return false;
        }
        if (w() <= 0 || this.f66139f < w() - 1) {
            return true;
        }
        if (this.f66139f == w() - 1 && this.f66138e < u() - 1) {
            return true;
        }
        this.f66152s = true;
        return false;
    }

    public final String q() {
        return "";
    }

    public Rect r() {
        if (this.f66149p == null) {
            if (this.f66153t == State.FINISHING) {
                Log.e("wuxinrong", "In finishing,do not interrupt");
            }
            Thread currentThread = Thread.currentThread();
            this.f66136c.post(new e(currentThread));
            LockSupport.park(currentThread);
        }
        return this.f66149p == null ? f66133u : this.f66149p;
    }

    public int s(int i11, int i12) {
        int i13 = 1;
        if (i11 != 0 && i12 != 0) {
            int min = Math.min(r().width() / i11, r().height() / i12);
            while (true) {
                int i14 = i13 * 2;
                if (i14 > min) {
                    break;
                }
                i13 = i14;
            }
        }
        return i13;
    }

    public g t(int i11) {
        if (i11 < 0 || i11 >= this.f66137d.size()) {
            return null;
        }
        return this.f66137d.get(i11);
    }

    public int u() {
        return this.f66137d.size();
    }

    public abstract int v();

    public final int w() {
        Integer num = this.f66140g;
        return num != null ? num.intValue() : v();
    }

    public abstract R x(y5.a aVar);

    public int y() {
        return this.f66144k;
    }

    public abstract W z();
}
