package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.x;
import kotlinx.coroutines.internal.c0;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57087a = new c0("REHASH");

    /* renamed from: b  reason: collision with root package name */
    public static final e f57088b = new e((Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final e f57089c = new e(Boolean.TRUE);

    public static final e d(Object obj) {
        if (obj == null) {
            return f57088b;
        }
        if (x.b(obj, Boolean.TRUE)) {
            return f57089c;
        }
        return new e(obj);
    }

    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
