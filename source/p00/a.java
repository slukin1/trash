package p00;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import j00.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Scheduler f59934a = o00.a.h(new h());

    /* renamed from: b  reason: collision with root package name */
    public static final Scheduler f59935b = o00.a.e(new b());

    /* renamed from: c  reason: collision with root package name */
    public static final Scheduler f59936c = o00.a.f(new c());

    /* renamed from: d  reason: collision with root package name */
    public static final Scheduler f59937d = io.reactivex.rxjava3.internal.schedulers.e.f();

    /* renamed from: e  reason: collision with root package name */
    public static final Scheduler f59938e = o00.a.g(new f());

    /* renamed from: p00.a$a  reason: collision with other inner class name */
    public static final class C0675a {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f59939a = new ComputationScheduler();
    }

    public static final class b implements k<Scheduler> {
        /* renamed from: a */
        public Scheduler get() {
            return C0675a.f59939a;
        }
    }

    public static final class c implements k<Scheduler> {
        /* renamed from: a */
        public Scheduler get() {
            return d.f59940a;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f59940a = new IoScheduler();
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f59941a = new NewThreadScheduler();
    }

    public static final class f implements k<Scheduler> {
        /* renamed from: a */
        public Scheduler get() {
            return e.f59941a;
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f59942a = new SingleScheduler();
    }

    public static final class h implements k<Scheduler> {
        /* renamed from: a */
        public Scheduler get() {
            return g.f59942a;
        }
    }

    public static Scheduler a() {
        return o00.a.o(f59936c);
    }
}
