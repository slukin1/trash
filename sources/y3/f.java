package y3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import f4.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import n3.g;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final l3.a f66688a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f66689b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f66690c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bumptech.glide.d f66691d;

    /* renamed from: e  reason: collision with root package name */
    public final e f66692e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66693f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66694g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66695h;

    /* renamed from: i  reason: collision with root package name */
    public com.bumptech.glide.c<Bitmap> f66696i;

    /* renamed from: j  reason: collision with root package name */
    public a f66697j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f66698k;

    /* renamed from: l  reason: collision with root package name */
    public a f66699l;

    /* renamed from: m  reason: collision with root package name */
    public Bitmap f66700m;

    /* renamed from: n  reason: collision with root package name */
    public g<Bitmap> f66701n;

    /* renamed from: o  reason: collision with root package name */
    public a f66702o;

    /* renamed from: p  reason: collision with root package name */
    public d f66703p;

    /* renamed from: q  reason: collision with root package name */
    public int f66704q;

    /* renamed from: r  reason: collision with root package name */
    public int f66705r;

    /* renamed from: s  reason: collision with root package name */
    public int f66706s;

    public static class a extends CustomTarget<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f66707b;

        /* renamed from: c  reason: collision with root package name */
        public final int f66708c;

        /* renamed from: d  reason: collision with root package name */
        public final long f66709d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap f66710e;

        public a(Handler handler, int i11, long j11) {
            this.f66707b = handler;
            this.f66708c = i11;
            this.f66709d = j11;
        }

        public Bitmap a() {
            return this.f66710e;
        }

        public void onLoadCleared(Drawable drawable) {
            this.f66710e = null;
        }

        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.transition.a<? super Bitmap> aVar) {
            this.f66710e = bitmap;
            this.f66707b.sendMessageAtTime(this.f66707b.obtainMessage(1, this), this.f66709d);
        }
    }

    public interface b {
        void a();
    }

    public class c implements Handler.Callback {
        public c() {
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                f.this.m((a) message.obj);
                return true;
            } else if (i11 != 2) {
                return false;
            } else {
                f.this.f66691d.g((a) message.obj);
                return false;
            }
        }
    }

    public interface d {
        void a();
    }

    public f(com.bumptech.glide.a aVar, l3.a aVar2, int i11, int i12, g<Bitmap> gVar, Bitmap bitmap) {
        this(aVar.g(), com.bumptech.glide.a.v(aVar.i()), aVar2, (Handler) null, i(com.bumptech.glide.a.v(aVar.i()), i11, i12), gVar, bitmap);
    }

    public static n3.b g() {
        return new e4.d(Double.valueOf(Math.random()));
    }

    public static com.bumptech.glide.c<Bitmap> i(com.bumptech.glide.d dVar, int i11, int i12) {
        return dVar.b().b(((RequestOptions) ((RequestOptions) RequestOptions.t0(DiskCacheStrategy.f63710b).q0(true)).k0(true)).Z(i11, i12));
    }

    public void a() {
        this.f66690c.clear();
        n();
        q();
        a aVar = this.f66697j;
        if (aVar != null) {
            this.f66691d.g(aVar);
            this.f66697j = null;
        }
        a aVar2 = this.f66699l;
        if (aVar2 != null) {
            this.f66691d.g(aVar2);
            this.f66699l = null;
        }
        a aVar3 = this.f66702o;
        if (aVar3 != null) {
            this.f66691d.g(aVar3);
            this.f66702o = null;
        }
        this.f66688a.clear();
        this.f66698k = true;
    }

    public ByteBuffer b() {
        return this.f66688a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        a aVar = this.f66697j;
        return aVar != null ? aVar.a() : this.f66700m;
    }

    public int d() {
        a aVar = this.f66697j;
        if (aVar != null) {
            return aVar.f66708c;
        }
        return -1;
    }

    public Bitmap e() {
        return this.f66700m;
    }

    public int f() {
        return this.f66688a.g();
    }

    public int h() {
        return this.f66706s;
    }

    public int j() {
        return this.f66688a.d() + this.f66704q;
    }

    public int k() {
        return this.f66705r;
    }

    public final void l() {
        if (this.f66693f && !this.f66694g) {
            if (this.f66695h) {
                h.a(this.f66702o == null, "Pending target must be null when starting from the first frame");
                this.f66688a.b();
                this.f66695h = false;
            }
            a aVar = this.f66702o;
            if (aVar != null) {
                this.f66702o = null;
                m(aVar);
                return;
            }
            this.f66694g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f66688a.h());
            this.f66688a.f();
            this.f66699l = new a(this.f66689b, this.f66688a.c(), uptimeMillis);
            this.f66696i.b(RequestOptions.u0(g())).L0(this.f66688a).A0(this.f66699l);
        }
    }

    public void m(a aVar) {
        d dVar = this.f66703p;
        if (dVar != null) {
            dVar.a();
        }
        this.f66694g = false;
        if (this.f66698k) {
            this.f66689b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f66693f) {
            this.f66702o = aVar;
        } else {
            if (aVar.a() != null) {
                n();
                a aVar2 = this.f66697j;
                this.f66697j = aVar;
                for (int size = this.f66690c.size() - 1; size >= 0; size--) {
                    this.f66690c.get(size).a();
                }
                if (aVar2 != null) {
                    this.f66689b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        }
    }

    public final void n() {
        Bitmap bitmap = this.f66700m;
        if (bitmap != null) {
            this.f66692e.c(bitmap);
            this.f66700m = null;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object, n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(n3.g<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = f4.h.d(r3)
            n3.g r0 = (n3.g) r0
            r2.f66701n = r0
            java.lang.Object r0 = f4.h.d(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.f66700m = r0
            com.bumptech.glide.c<android.graphics.Bitmap> r0 = r2.f66696i
            com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
            r1.<init>()
            com.bumptech.glide.request.BaseRequestOptions r3 = r1.n0(r3)
            com.bumptech.glide.c r3 = r0.b(r3)
            r2.f66696i = r3
            int r3 = f4.i.h(r4)
            r2.f66704q = r3
            int r3 = r4.getWidth()
            r2.f66705r = r3
            int r3 = r4.getHeight()
            r2.f66706s = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.f.o(n3.g, android.graphics.Bitmap):void");
    }

    public final void p() {
        if (!this.f66693f) {
            this.f66693f = true;
            this.f66698k = false;
            l();
        }
    }

    public final void q() {
        this.f66693f = false;
    }

    public void r(b bVar) {
        if (this.f66698k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f66690c.contains(bVar)) {
            boolean isEmpty = this.f66690c.isEmpty();
            this.f66690c.add(bVar);
            if (isEmpty) {
                p();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    public void s(b bVar) {
        this.f66690c.remove(bVar);
        if (this.f66690c.isEmpty()) {
            q();
        }
    }

    public f(e eVar, com.bumptech.glide.d dVar, l3.a aVar, Handler handler, com.bumptech.glide.c<Bitmap> cVar, g<Bitmap> gVar, Bitmap bitmap) {
        this.f66690c = new ArrayList();
        this.f66691d = dVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f66692e = eVar;
        this.f66689b = handler;
        this.f66696i = cVar;
        this.f66688a = aVar;
        o(gVar, bitmap);
    }
}
