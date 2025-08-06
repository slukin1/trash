package androidx.dynamicanimation.animation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f9324g = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f9325a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f9326b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C0034a f9327c = new C0034a();

    /* renamed from: d  reason: collision with root package name */
    public c f9328d;

    /* renamed from: e  reason: collision with root package name */
    public long f9329e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9330f = false;

    /* renamed from: androidx.dynamicanimation.animation.a$a  reason: collision with other inner class name */
    public class C0034a {
        public C0034a() {
        }

        public void a() {
            a.this.f9329e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f9329e);
            if (a.this.f9326b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    public interface b {
        boolean a(long j11);
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final C0034a f9332a;

        public c(C0034a aVar) {
            this.f9332a = aVar;
        }

        public abstract void a();
    }

    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f9333b = new C0035a();

        /* renamed from: c  reason: collision with root package name */
        public final Handler f9334c = new Handler(Looper.myLooper());

        /* renamed from: d  reason: collision with root package name */
        public long f9335d = -1;

        /* renamed from: androidx.dynamicanimation.animation.a$d$a  reason: collision with other inner class name */
        public class C0035a implements Runnable {
            public C0035a() {
            }

            public void run() {
                d.this.f9335d = SystemClock.uptimeMillis();
                d.this.f9332a.a();
            }
        }

        public d(C0034a aVar) {
            super(aVar);
        }

        public void a() {
            this.f9334c.postDelayed(this.f9333b, Math.max(10 - (SystemClock.uptimeMillis() - this.f9335d), 0));
        }
    }

    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f9337b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f9338c = new C0036a();

        /* renamed from: androidx.dynamicanimation.animation.a$e$a  reason: collision with other inner class name */
        public class C0036a implements Choreographer.FrameCallback {
            public C0036a() {
            }

            public void doFrame(long j11) {
                e.this.f9332a.a();
            }
        }

        public e(C0034a aVar) {
            super(aVar);
        }

        public void a() {
            this.f9337b.postFrameCallback(this.f9338c);
        }
    }

    public static a d() {
        ThreadLocal<a> threadLocal = f9324g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    public void a(b bVar, long j11) {
        if (this.f9326b.size() == 0) {
            e().a();
        }
        if (!this.f9326b.contains(bVar)) {
            this.f9326b.add(bVar);
        }
        if (j11 > 0) {
            this.f9325a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j11));
        }
    }

    public final void b() {
        if (this.f9330f) {
            for (int size = this.f9326b.size() - 1; size >= 0; size--) {
                if (this.f9326b.get(size) == null) {
                    this.f9326b.remove(size);
                }
            }
            this.f9330f = false;
        }
    }

    public void c(long j11) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i11 = 0; i11 < this.f9326b.size(); i11++) {
            b bVar = this.f9326b.get(i11);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.a(j11);
            }
        }
        b();
    }

    public c e() {
        if (this.f9328d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f9328d = new e(this.f9327c);
            } else {
                this.f9328d = new d(this.f9327c);
            }
        }
        return this.f9328d;
    }

    public final boolean f(b bVar, long j11) {
        Long l11 = this.f9325a.get(bVar);
        if (l11 == null) {
            return true;
        }
        if (l11.longValue() >= j11) {
            return false;
        }
        this.f9325a.remove(bVar);
        return true;
    }

    public void g(b bVar) {
        this.f9325a.remove(bVar);
        int indexOf = this.f9326b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f9326b.set(indexOf, (Object) null);
            this.f9330f = true;
        }
    }
}
