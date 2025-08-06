package kotlinx.coroutines;

import kotlinx.coroutines.internal.c0;

public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57459a = new c0("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f57460b = new c0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f57461c = new c0("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f57462d = new c0("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f57463e = new c0("SEALED");

    /* renamed from: f  reason: collision with root package name */
    public static final a1 f57464f = new a1(false);

    /* renamed from: g  reason: collision with root package name */
    public static final a1 f57465g = new a1(true);

    public static final Object g(Object obj) {
        return obj instanceof i1 ? new j1((i1) obj) : obj;
    }

    public static final Object h(Object obj) {
        i1 i1Var;
        j1 j1Var = obj instanceof j1 ? (j1) obj : null;
        return (j1Var == null || (i1Var = j1Var.f57359a) == null) ? obj : i1Var;
    }
}
