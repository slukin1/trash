package kotlinx.serialization.json;

import h10.a;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.j0;
import kotlinx.serialization.json.internal.n0;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final f f57851a = j0.a("kotlinx.serialization.json.JsonUnquotedLiteral", a.I(d0.f56774a));

    public static final t a(Boolean bool) {
        if (bool == null) {
            return JsonNull.INSTANCE;
        }
        return new n(bool, false, (f) null, 4, (r) null);
    }

    public static final t b(Number number) {
        if (number == null) {
            return JsonNull.INSTANCE;
        }
        return new n(number, false, (f) null, 4, (r) null);
    }

    public static final t c(String str) {
        if (str == null) {
            return JsonNull.INSTANCE;
        }
        return new n(str, true, (f) null, 4, (r) null);
    }

    public static final Void d(g gVar, String str) {
        throw new IllegalArgumentException("Element " + Reflection.b(gVar.getClass()) + " is not a " + str);
    }

    public static final Boolean e(t tVar) {
        return n0.d(tVar.a());
    }

    public static final String f(t tVar) {
        if (tVar instanceof JsonNull) {
            return null;
        }
        return tVar.a();
    }

    public static final double g(t tVar) {
        return Double.parseDouble(tVar.a());
    }

    public static final Double h(t tVar) {
        return StringsKt__StringNumberConversionsJVMKt.j(tVar.a());
    }

    public static final float i(t tVar) {
        return Float.parseFloat(tVar.a());
    }

    public static final int j(t tVar) {
        return Integer.parseInt(tVar.a());
    }

    public static final Integer k(t tVar) {
        return StringsKt__StringNumberConversionsKt.m(tVar.a());
    }

    public static final t l(g gVar) {
        t tVar = gVar instanceof t ? (t) gVar : null;
        if (tVar != null) {
            return tVar;
        }
        d(gVar, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final f m() {
        return f57851a;
    }

    public static final long n(t tVar) {
        return Long.parseLong(tVar.a());
    }

    public static final Long o(t tVar) {
        return StringsKt__StringNumberConversionsKt.o(tVar.a());
    }
}
