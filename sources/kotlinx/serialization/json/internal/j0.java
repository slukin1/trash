package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.x;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.f;
import kotlinx.serialization.json.g;
import kotlinx.serialization.modules.d;

public class j0 extends AbstractDecoder implements f {

    /* renamed from: a  reason: collision with root package name */
    public final kotlinx.serialization.json.a f57911a;

    /* renamed from: b  reason: collision with root package name */
    public final WriteMode f57912b;

    /* renamed from: c  reason: collision with root package name */
    public final AbstractJsonLexer f57913c;

    /* renamed from: d  reason: collision with root package name */
    public final d f57914d;

    /* renamed from: e  reason: collision with root package name */
    public int f57915e = -1;

    /* renamed from: f  reason: collision with root package name */
    public a f57916f;

    /* renamed from: g  reason: collision with root package name */
    public final JsonConfiguration f57917g;

    /* renamed from: h  reason: collision with root package name */
    public final JsonElementMarker f57918h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f57919a;

        public a(String str) {
            this.f57919a = str;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57920a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlinx.serialization.json.internal.WriteMode[] r0 = kotlinx.serialization.json.internal.WriteMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.LIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.MAP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.POLY_OBJ     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.OBJ     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f57920a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.j0.b.<clinit>():void");
        }
    }

    public j0(kotlinx.serialization.json.a aVar, WriteMode writeMode, AbstractJsonLexer abstractJsonLexer, kotlinx.serialization.descriptors.f fVar, a aVar2) {
        this.f57911a = aVar;
        this.f57912b = writeMode;
        this.f57913c = abstractJsonLexer;
        this.f57914d = aVar.a();
        this.f57916f = aVar2;
        JsonConfiguration f11 = aVar.f();
        this.f57917g = f11;
        this.f57918h = f11.f() ? null : new JsonElementMarker(fVar);
    }

    public boolean A() {
        if (this.f57917g.m()) {
            return this.f57913c.i();
        }
        return this.f57913c.g();
    }

    public boolean D() {
        JsonElementMarker jsonElementMarker = this.f57918h;
        return !(jsonElementMarker != null ? jsonElementMarker.b() : false) && !AbstractJsonLexer.N(this.f57913c, false, 1, (Object) null);
    }

    public <T> T G(kotlinx.serialization.a<? extends T> aVar) {
        try {
            if (aVar instanceof AbstractPolymorphicSerializer) {
                if (!this.f57911a.f().l()) {
                    String c11 = h0.c(aVar.getDescriptor(), this.f57911a);
                    String l11 = this.f57913c.l(c11, this.f57917g.m());
                    kotlinx.serialization.a aVar2 = null;
                    if (l11 != null) {
                        aVar2 = ((AbstractPolymorphicSerializer) aVar).c(this, l11);
                    }
                    if (aVar2 == null) {
                        return h0.d(this, aVar);
                    }
                    this.f57916f = new a(c11);
                    return aVar2.deserialize(this);
                }
            }
            return aVar.deserialize(this);
        } catch (MissingFieldException e11) {
            List<String> missingFields = e11.getMissingFields();
            throw new MissingFieldException(missingFields, e11.getMessage() + " at path: " + this.f57913c.f57853b.a(), e11);
        }
    }

    public byte H() {
        long p11 = this.f57913c.p();
        byte b11 = (byte) ((int) p11);
        if (p11 == ((long) b11)) {
            return b11;
        }
        AbstractJsonLexer abstractJsonLexer = this.f57913c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse byte for input '" + p11 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final void K() {
        if (this.f57913c.E() == 4) {
            AbstractJsonLexer.y(this.f57913c, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean L(kotlinx.serialization.descriptors.f fVar, int i11) {
        String F;
        kotlinx.serialization.json.a aVar = this.f57911a;
        kotlinx.serialization.descriptors.f d11 = fVar.d(i11);
        if (!d11.b() && this.f57913c.M(true)) {
            return true;
        }
        if (!x.b(d11.getKind(), h.b.f57646a) || ((d11.b() && this.f57913c.M(false)) || (F = this.f57913c.F(this.f57917g.m())) == null || JsonNamesMapKt.g(d11, aVar, F) != -3)) {
            return false;
        }
        this.f57913c.q();
        return true;
    }

    public final int M() {
        boolean L = this.f57913c.L();
        if (this.f57913c.f()) {
            int i11 = this.f57915e;
            if (i11 == -1 || L) {
                int i12 = i11 + 1;
                this.f57915e = i12;
                return i12;
            }
            AbstractJsonLexer.y(this.f57913c, "Expected end of the array or comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!L) {
            return -1;
        } else {
            AbstractJsonLexer.y(this.f57913c, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final int N() {
        int i11 = this.f57915e;
        boolean z11 = false;
        boolean z12 = i11 % 2 != 0;
        if (!z12) {
            this.f57913c.o(':');
        } else if (i11 != -1) {
            z11 = this.f57913c.L();
        }
        if (this.f57913c.f()) {
            if (z12) {
                if (this.f57915e == -1) {
                    AbstractJsonLexer abstractJsonLexer = this.f57913c;
                    boolean z13 = !z11;
                    int a11 = abstractJsonLexer.f57852a;
                    if (!z13) {
                        AbstractJsonLexer.y(abstractJsonLexer, "Unexpected trailing comma", a11, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer abstractJsonLexer2 = this.f57913c;
                    int a12 = abstractJsonLexer2.f57852a;
                    if (!z11) {
                        AbstractJsonLexer.y(abstractJsonLexer2, "Expected comma after the key-value pair", a12, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i12 = this.f57915e + 1;
            this.f57915e = i12;
            return i12;
        } else if (!z11) {
            return -1;
        } else {
            AbstractJsonLexer.y(this.f57913c, "Expected '}', but had ',' instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final int O(kotlinx.serialization.descriptors.f fVar) {
        boolean z11;
        boolean L = this.f57913c.L();
        while (this.f57913c.f()) {
            String P = P();
            this.f57913c.o(':');
            int g11 = JsonNamesMapKt.g(fVar, this.f57911a, P);
            boolean z12 = false;
            if (g11 == -3) {
                z12 = true;
                z11 = false;
            } else if (!this.f57917g.d() || !L(fVar, g11)) {
                JsonElementMarker jsonElementMarker = this.f57918h;
                if (jsonElementMarker != null) {
                    jsonElementMarker.c(g11);
                }
                return g11;
            } else {
                z11 = this.f57913c.L();
            }
            L = z12 ? Q(P) : z11;
        }
        if (!L) {
            JsonElementMarker jsonElementMarker2 = this.f57918h;
            if (jsonElementMarker2 != null) {
                return jsonElementMarker2.d();
            }
            return -1;
        }
        AbstractJsonLexer.y(this.f57913c, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String P() {
        if (this.f57917g.m()) {
            return this.f57913c.t();
        }
        return this.f57913c.k();
    }

    public final boolean Q(String str) {
        if (this.f57917g.g() || S(this.f57916f, str)) {
            this.f57913c.H(this.f57917g.m());
        } else {
            this.f57913c.A(str);
        }
        return this.f57913c.L();
    }

    public final void R(kotlinx.serialization.descriptors.f fVar) {
        do {
        } while (w(fVar) != -1);
    }

    public final boolean S(a aVar, String str) {
        if (aVar == null || !x.b(aVar.f57919a, str)) {
            return false;
        }
        aVar.f57919a = null;
        return true;
    }

    public d a() {
        return this.f57914d;
    }

    public kotlinx.serialization.encoding.a b(kotlinx.serialization.descriptors.f fVar) {
        WriteMode b11 = p0.b(this.f57911a, fVar);
        this.f57913c.f57853b.c(fVar);
        this.f57913c.o(b11.begin);
        K();
        int i11 = b.f57920a[b11.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            return new j0(this.f57911a, b11, this.f57913c, fVar, this.f57916f);
        } else if (this.f57912b == b11 && this.f57911a.f().f()) {
            return this;
        } else {
            return new j0(this.f57911a, b11, this.f57913c, fVar, this.f57916f);
        }
    }

    public void c(kotlinx.serialization.descriptors.f fVar) {
        if (this.f57911a.f().g() && fVar.e() == 0) {
            R(fVar);
        }
        this.f57913c.o(this.f57912b.end);
        this.f57913c.f57853b.b();
    }

    public final kotlinx.serialization.json.a d() {
        return this.f57911a;
    }

    public Void g() {
        return null;
    }

    public long h() {
        return this.f57913c.p();
    }

    public short m() {
        long p11 = this.f57913c.p();
        short s11 = (short) ((int) p11);
        if (p11 == ((long) s11)) {
            return s11;
        }
        AbstractJsonLexer abstractJsonLexer = this.f57913c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse short for input '" + p11 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public double n() {
        AbstractJsonLexer abstractJsonLexer = this.f57913c;
        String s11 = abstractJsonLexer.s();
        try {
            double parseDouble = Double.parseDouble(s11);
            if (!this.f57911a.f().a()) {
                if (!(!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble))) {
                    w.j(this.f57913c, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "double" + "' for input '" + s11 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public char o() {
        String s11 = this.f57913c.s();
        if (s11.length() == 1) {
            return s11.charAt(0);
        }
        AbstractJsonLexer abstractJsonLexer = this.f57913c;
        AbstractJsonLexer.y(abstractJsonLexer, "Expected single char, but got '" + s11 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public <T> T p(kotlinx.serialization.descriptors.f fVar, int i11, kotlinx.serialization.a<? extends T> aVar, T t11) {
        boolean z11 = this.f57912b == WriteMode.MAP && (i11 & 1) == 0;
        if (z11) {
            this.f57913c.f57853b.d();
        }
        T p11 = super.p(fVar, i11, aVar, t11);
        if (z11) {
            this.f57913c.f57853b.f(p11);
        }
        return p11;
    }

    public String q() {
        if (this.f57917g.m()) {
            return this.f57913c.t();
        }
        return this.f57913c.q();
    }

    public int s(kotlinx.serialization.descriptors.f fVar) {
        kotlinx.serialization.json.a aVar = this.f57911a;
        String q11 = q();
        return JsonNamesMapKt.i(fVar, aVar, q11, " at path " + this.f57913c.f57853b.a());
    }

    public g t() {
        return new JsonTreeReader(this.f57911a.f(), this.f57913c).e();
    }

    public int u() {
        long p11 = this.f57913c.p();
        int i11 = (int) p11;
        if (p11 == ((long) i11)) {
            return i11;
        }
        AbstractJsonLexer abstractJsonLexer = this.f57913c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse int for input '" + p11 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public int w(kotlinx.serialization.descriptors.f fVar) {
        int i11;
        int i12 = b.f57920a[this.f57912b.ordinal()];
        if (i12 == 2) {
            i11 = N();
        } else if (i12 != 4) {
            i11 = M();
        } else {
            i11 = O(fVar);
        }
        if (this.f57912b != WriteMode.MAP) {
            this.f57913c.f57853b.g(i11);
        }
        return i11;
    }

    public c x(kotlinx.serialization.descriptors.f fVar) {
        if (l0.b(fVar)) {
            return new v(this.f57913c, this.f57911a);
        }
        return super.x(fVar);
    }

    public float y() {
        AbstractJsonLexer abstractJsonLexer = this.f57913c;
        String s11 = abstractJsonLexer.s();
        try {
            float parseFloat = Float.parseFloat(s11);
            if (!this.f57911a.f().a()) {
                if (!(!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat))) {
                    w.j(this.f57913c, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "float" + "' for input '" + s11 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }
}
