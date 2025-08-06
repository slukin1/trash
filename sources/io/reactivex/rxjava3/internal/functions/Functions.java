package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public final class Functions {

    /* renamed from: a  reason: collision with root package name */
    public static final j00.h<Object, Object> f55442a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f55443b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final j00.a f55444c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final j00.g<Object> f55445d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final j00.g<Throwable> f55446e = new e();

    /* renamed from: f  reason: collision with root package name */
    public static final j00.g<Throwable> f55447f = new j();

    /* renamed from: g  reason: collision with root package name */
    public static final j00.i f55448g = new c();

    /* renamed from: h  reason: collision with root package name */
    public static final j00.j<Object> f55449h = new k();

    /* renamed from: i  reason: collision with root package name */
    public static final j00.j<Object> f55450i = new f();

    /* renamed from: j  reason: collision with root package name */
    public static final j00.k<Object> f55451j = new i();

    /* renamed from: k  reason: collision with root package name */
    public static final j00.g<z20.d> f55452k = new h();

    public enum HashSetSupplier implements j00.k<Set<Object>> {
        INSTANCE;

        public Set<Object> get() {
            return new HashSet();
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class a implements j00.a {
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static final class b implements j00.g<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class c implements j00.i {
    }

    public static final class d implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class e implements j00.g<Throwable> {
        /* renamed from: a */
        public void accept(Throwable th2) {
            o00.a.n(th2);
        }
    }

    public static final class f implements j00.j<Object> {
        public boolean test(Object obj) {
            return false;
        }
    }

    public static final class g implements j00.h<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    public static final class h implements j00.g<z20.d> {
        /* renamed from: a */
        public void accept(z20.d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    public static final class i implements j00.k<Object> {
        public Object get() {
            return null;
        }
    }

    public static final class j implements j00.g<Throwable> {
        /* renamed from: a */
        public void accept(Throwable th2) {
            o00.a.n(new OnErrorNotImplementedException(th2));
        }
    }

    public static final class k implements j00.j<Object> {
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> j00.g<T> a() {
        return f55445d;
    }
}
