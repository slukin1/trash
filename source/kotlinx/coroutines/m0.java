package kotlinx.coroutines;

import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.u;

public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f57378a = d0.f("kotlinx.coroutines.main.delay", false);

    /* renamed from: b  reason: collision with root package name */
    public static final p0 f57379b = b();

    public static final p0 a() {
        return f57379b;
    }

    public static final p0 b() {
        if (!f57378a) {
            return l0.f57369i;
        }
        MainCoroutineDispatcher c11 = v0.c();
        return (u.c(c11) || !(c11 instanceof p0)) ? l0.f57369i : (p0) c11;
    }
}
