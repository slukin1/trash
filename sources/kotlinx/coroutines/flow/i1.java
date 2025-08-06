package kotlinx.coroutines.flow;

public interface i1 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f57228a = a.f57229a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f57229a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final i1 f57230b = new StartedEagerly();

        /* renamed from: c  reason: collision with root package name */
        public static final i1 f57231c = new StartedLazily();

        public static /* synthetic */ i1 b(a aVar, long j11, long j12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = 0;
            }
            if ((i11 & 2) != 0) {
                j12 = Long.MAX_VALUE;
            }
            return aVar.a(j11, j12);
        }

        public final i1 a(long j11, long j12) {
            return new StartedWhileSubscribed(j11, j12);
        }

        public final i1 c() {
            return f57230b;
        }

        public final i1 d() {
            return f57231c;
        }
    }

    d<SharingCommand> a(j1<Integer> j1Var);
}
