package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.f;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.n;
import kotlinx.serialization.json.t;
import kotlinx.serialization.modules.d;

public abstract class b extends NamedValueDecoder implements f {

    /* renamed from: c  reason: collision with root package name */
    public final a f57888c;

    /* renamed from: d  reason: collision with root package name */
    public final g f57889d;

    /* renamed from: e  reason: collision with root package name */
    public final JsonConfiguration f57890e;

    public b(a aVar, g gVar) {
        this.f57888c = aVar;
        this.f57889d = gVar;
        this.f57890e = d().f();
    }

    public /* synthetic */ b(a aVar, g gVar, r rVar) {
        this(aVar, gVar);
    }

    public boolean D() {
        return !(h0() instanceof JsonNull);
    }

    public <T> T G(kotlinx.serialization.a<? extends T> aVar) {
        return h0.d(this, aVar);
    }

    public d a() {
        return d().a();
    }

    public kotlinx.serialization.encoding.a b(kotlinx.serialization.descriptors.f fVar) {
        g h02 = h0();
        h kind = fVar.getKind();
        if (x.b(kind, i.b.f57648a) ? true : kind instanceof kotlinx.serialization.descriptors.d) {
            a d11 = d();
            if (h02 instanceof kotlinx.serialization.json.b) {
                return new c0(d11, (kotlinx.serialization.json.b) h02);
            }
            throw w.e(-1, "Expected " + Reflection.b(kotlinx.serialization.json.b.class) + " as the serialized body of " + fVar.h() + ", but had " + Reflection.b(h02.getClass()));
        } else if (x.b(kind, i.c.f57649a)) {
            a d12 = d();
            kotlinx.serialization.descriptors.f a11 = p0.a(fVar.d(0), d12.a());
            h kind2 = a11.getKind();
            if ((kind2 instanceof e) || x.b(kind2, h.b.f57646a)) {
                a d13 = d();
                if (h02 instanceof JsonObject) {
                    return new e0(d13, (JsonObject) h02);
                }
                throw w.e(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + fVar.h() + ", but had " + Reflection.b(h02.getClass()));
            } else if (d12.f().b()) {
                a d14 = d();
                if (h02 instanceof kotlinx.serialization.json.b) {
                    return new c0(d14, (kotlinx.serialization.json.b) h02);
                }
                throw w.e(-1, "Expected " + Reflection.b(kotlinx.serialization.json.b.class) + " as the serialized body of " + fVar.h() + ", but had " + Reflection.b(h02.getClass()));
            } else {
                throw w.d(a11);
            }
        } else {
            a d15 = d();
            if (h02 instanceof JsonObject) {
                return new a0(d15, (JsonObject) h02, (String) null, (kotlinx.serialization.descriptors.f) null, 12, (r) null);
            }
            throw w.e(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + fVar.h() + ", but had " + Reflection.b(h02.getClass()));
        }
    }

    public String b0(String str, String str2) {
        return str2;
    }

    public void c(kotlinx.serialization.descriptors.f fVar) {
    }

    public a d() {
        return this.f57888c;
    }

    public final n f0(t tVar, String str) {
        n nVar = tVar instanceof n ? (n) tVar : null;
        if (nVar != null) {
            return nVar;
        }
        throw w.e(-1, "Unexpected 'null' when " + str + " was expected");
    }

    public abstract g g0(String str);

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = g0(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.serialization.json.g h0() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.W()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000e
            kotlinx.serialization.json.g r0 = r1.g0(r0)
            if (r0 != 0) goto L_0x0012
        L_0x000e:
            kotlinx.serialization.json.g r0 = r1.v0()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.b.h0():kotlinx.serialization.json.g");
    }

    /* renamed from: i0 */
    public boolean J(String str) {
        t u02 = u0(str);
        if (d().f().m() || !f0(u02, "boolean").c()) {
            try {
                Boolean e11 = kotlinx.serialization.json.i.e(u02);
                if (e11 != null) {
                    return e11.booleanValue();
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException unused) {
                w0("boolean");
                throw new KotlinNothingValueException();
            }
        } else {
            throw w.f(-1, "Boolean literal for key '" + str + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        }
    }

    /* renamed from: j0 */
    public byte K(String str) {
        try {
            int j11 = kotlinx.serialization.json.i.j(u0(str));
            boolean z11 = false;
            if (-128 <= j11 && j11 <= 127) {
                z11 = true;
            }
            Byte valueOf = z11 ? Byte.valueOf((byte) j11) : null;
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            w0("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: k0 */
    public char L(String str) {
        try {
            return StringsKt___StringsKt.o1(u0(str).a());
        } catch (IllegalArgumentException unused) {
            w0("char");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: l0 */
    public double M(String str) {
        try {
            double g11 = kotlinx.serialization.json.i.g(u0(str));
            if (!d().f().a()) {
                if (!(!Double.isInfinite(g11) && !Double.isNaN(g11))) {
                    throw w.a(Double.valueOf(g11), str, h0().toString());
                }
            }
            return g11;
        } catch (IllegalArgumentException unused) {
            w0("double");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: m0 */
    public int N(String str, kotlinx.serialization.descriptors.f fVar) {
        return JsonNamesMapKt.j(fVar, d(), u0(str).a(), (String) null, 4, (Object) null);
    }

    /* renamed from: n0 */
    public float O(String str) {
        try {
            float i11 = kotlinx.serialization.json.i.i(u0(str));
            if (!d().f().a()) {
                if (!(!Float.isInfinite(i11) && !Float.isNaN(i11))) {
                    throw w.a(Float.valueOf(i11), str, h0().toString());
                }
            }
            return i11;
        } catch (IllegalArgumentException unused) {
            w0("float");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: o0 */
    public c P(String str, kotlinx.serialization.descriptors.f fVar) {
        if (l0.b(fVar)) {
            return new v(new m0(u0(str).a()), d());
        }
        return super.P(str, fVar);
    }

    /* renamed from: p0 */
    public int Q(String str) {
        try {
            return kotlinx.serialization.json.i.j(u0(str));
        } catch (IllegalArgumentException unused) {
            w0("int");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: q0 */
    public long R(String str) {
        try {
            return kotlinx.serialization.json.i.n(u0(str));
        } catch (IllegalArgumentException unused) {
            w0("long");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: r0 */
    public boolean S(String str) {
        return g0(str) != JsonNull.INSTANCE;
    }

    /* renamed from: s0 */
    public short T(String str) {
        try {
            int j11 = kotlinx.serialization.json.i.j(u0(str));
            boolean z11 = false;
            if (-32768 <= j11 && j11 <= 32767) {
                z11 = true;
            }
            Short valueOf = z11 ? Short.valueOf((short) j11) : null;
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            w0("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("short");
            throw new KotlinNothingValueException();
        }
    }

    public g t() {
        return h0();
    }

    /* renamed from: t0 */
    public String U(String str) {
        t u02 = u0(str);
        if (!d().f().m() && !f0(u02, "string").c()) {
            throw w.f(-1, "String literal for key '" + str + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        } else if (!(u02 instanceof JsonNull)) {
            return u02.a();
        } else {
            throw w.f(-1, "Unexpected 'null' value instead of string literal", h0().toString());
        }
    }

    public final t u0(String str) {
        g g02 = g0(str);
        t tVar = g02 instanceof t ? (t) g02 : null;
        if (tVar != null) {
            return tVar;
        }
        throw w.f(-1, "Expected JsonPrimitive at " + str + ", found " + g02, h0().toString());
    }

    public abstract g v0();

    public final Void w0(String str) {
        throw w.f(-1, "Failed to parse '" + str + '\'', h0().toString());
    }
}
