package bv;

import com.huobi.woodpecker.kalle.CancelerManager;
import com.huobi.woodpecker.kalle.Kalle;
import com.huobi.woodpecker.kalle.d;
import com.huobi.woodpecker.kalle.simple.Callback;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f19385c;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f19386a = Kalle.b().p();

    /* renamed from: b  reason: collision with root package name */
    public final CancelerManager f19387b = new CancelerManager();

    public class a extends c<S, F> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f19388c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Callback callback, i iVar) {
            super(callback);
            this.f19388c = iVar;
        }

        public void d() {
            super.d();
            e.this.f19387b.b(this.f19388c);
        }
    }

    public class b extends c<S, F> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f19390c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Callback callback, f fVar) {
            super(callback);
            this.f19390c = fVar;
        }

        public void d() {
            super.d();
            e.this.f19387b.b(this.f19390c);
        }
    }

    public static class c<S, F> extends Callback<S, F> {

        /* renamed from: a  reason: collision with root package name */
        public final Callback<S, F> f19392a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f19393b = Kalle.b().j();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                c.this.f19392a.g();
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f19395b;

            public b(h hVar) {
                this.f19395b = hVar;
            }

            public void run() {
                c.this.f19392a.f(this.f19395b);
            }
        }

        /* renamed from: bv.e$c$c  reason: collision with other inner class name */
        public class C0136c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Exception f19397b;

            public C0136c(Exception exc) {
                this.f19397b = exc;
            }

            public void run() {
                c.this.f19392a.e(this.f19397b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                c.this.f19392a.c();
            }
        }

        /* renamed from: bv.e$c$e  reason: collision with other inner class name */
        public class C0137e implements Runnable {
            public C0137e() {
            }

            public void run() {
                c.this.f19392a.d();
            }
        }

        public c(Callback<S, F> callback) {
            this.f19392a = callback;
        }

        public Type a() {
            return this.f19392a.a();
        }

        public Type b() {
            return this.f19392a.b();
        }

        public void c() {
            if (this.f19392a != null) {
                this.f19393b.execute(new d());
            }
        }

        public void d() {
            if (this.f19392a != null) {
                this.f19393b.execute(new C0137e());
            }
        }

        public void e(Exception exc) {
            if (this.f19392a != null) {
                this.f19393b.execute(new C0136c(exc));
            }
        }

        public void f(h<S, F> hVar) {
            if (this.f19392a != null) {
                this.f19393b.execute(new b(hVar));
            }
        }

        public void g() {
            if (this.f19392a != null) {
                this.f19393b.execute(new a());
            }
        }
    }

    public static e b() {
        if (f19385c == null) {
            synchronized (e.class) {
                if (f19385c == null) {
                    f19385c = new e();
                }
            }
        }
        return f19385c;
    }

    public <S, F> d c(f fVar, Callback<S, F> callback) {
        k kVar = new k(new b(fVar, callback.b(), callback.a()), new b(callback, fVar));
        this.f19387b.a(fVar, kVar);
        this.f19386a.execute(kVar);
        return kVar;
    }

    public <S, F> d d(i iVar, Callback<S, F> callback) {
        k kVar = new k(new j(iVar, callback.b(), callback.a()), new a(callback, iVar));
        this.f19387b.a(iVar, kVar);
        this.f19386a.execute(kVar);
        return kVar;
    }
}
