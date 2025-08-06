package lm;

import com.huobi.kalle.CancelerManager;
import com.huobi.kalle.Kalle;
import com.huobi.kalle.c;
import com.huobi.kalle.simple.Callback;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f76250c;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f76251a = Kalle.a().p();

    /* renamed from: b  reason: collision with root package name */
    public final CancelerManager f76252b = new CancelerManager();

    public class a extends b<S, F> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f76253c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Callback callback, f fVar) {
            super(callback);
            this.f76253c = fVar;
        }

        public void d() {
            super.d();
            e.this.f76252b.b(this.f76253c);
        }
    }

    public static class b<S, F> extends Callback<S, F> {

        /* renamed from: a  reason: collision with root package name */
        public final Callback<S, F> f76255a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f76256b = Kalle.a().j();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                b.this.f76255a.g();
            }
        }

        /* renamed from: lm.e$b$b  reason: collision with other inner class name */
        public class C0811b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f76258b;

            public C0811b(h hVar) {
                this.f76258b = hVar;
            }

            public void run() {
                b.this.f76255a.f(this.f76258b);
            }
        }

        public class c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Exception f76260b;

            public c(Exception exc) {
                this.f76260b = exc;
            }

            public void run() {
                b.this.f76255a.e(this.f76260b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                b.this.f76255a.c();
            }
        }

        /* renamed from: lm.e$b$e  reason: collision with other inner class name */
        public class C0812e implements Runnable {
            public C0812e() {
            }

            public void run() {
                b.this.f76255a.d();
            }
        }

        public b(Callback<S, F> callback) {
            this.f76255a = callback;
        }

        public Type a() {
            return this.f76255a.a();
        }

        public Type b() {
            return this.f76255a.b();
        }

        public void c() {
            if (this.f76255a != null) {
                this.f76256b.execute(new d());
            }
        }

        public void d() {
            if (this.f76255a != null) {
                this.f76256b.execute(new C0812e());
            }
        }

        public void e(Exception exc) {
            if (this.f76255a != null) {
                this.f76256b.execute(new c(exc));
            }
        }

        public void f(h<S, F> hVar) {
            if (this.f76255a != null) {
                this.f76256b.execute(new C0811b(hVar));
            }
        }

        public void g() {
            if (this.f76255a != null) {
                this.f76256b.execute(new a());
            }
        }
    }

    public static e b() {
        if (f76250c == null) {
            synchronized (e.class) {
                if (f76250c == null) {
                    f76250c = new e();
                }
            }
        }
        return f76250c;
    }

    public <S, F> c c(f fVar, Callback<S, F> callback) {
        i iVar = new i(new b(fVar, callback.b(), callback.a()), new a(callback, fVar));
        this.f76252b.a(fVar, iVar);
        this.f76251a.execute(iVar);
        return iVar;
    }
}
