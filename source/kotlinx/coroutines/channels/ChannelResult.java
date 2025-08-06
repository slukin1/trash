package kotlinx.coroutines.channels;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class ChannelResult<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f57037b = new b((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final Failed f57038c = new Failed();

    /* renamed from: a  reason: collision with root package name */
    public final Object f57039a;

    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    public static final class a extends Failed {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f57040a;

        public a(Throwable th2) {
            this.f57040a = th2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && x.b(this.f57040a, ((a) obj).f57040a);
        }

        public int hashCode() {
            Throwable th2 = this.f57040a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.f57040a + ')';
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public final <E> Object a(Throwable th2) {
            return ChannelResult.c(new a(th2));
        }

        public final <E> Object b() {
            return ChannelResult.c(ChannelResult.f57038c);
        }

        public final <E> Object c(E e11) {
            return ChannelResult.c(e11);
        }
    }

    public /* synthetic */ ChannelResult(Object obj) {
        this.f57039a = obj;
    }

    public static final /* synthetic */ ChannelResult b(Object obj) {
        return new ChannelResult(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && x.b(obj, ((ChannelResult) obj2).l());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f57040a;
        }
        return null;
    }

    public static final T f(Object obj) {
        if (!(obj instanceof Failed)) {
            return obj;
        }
        return null;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return obj instanceof Failed;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof Failed);
    }

    public static String k(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f57039a, obj);
    }

    public int hashCode() {
        return g(this.f57039a);
    }

    public final /* synthetic */ Object l() {
        return this.f57039a;
    }

    public String toString() {
        return k(this.f57039a);
    }
}
