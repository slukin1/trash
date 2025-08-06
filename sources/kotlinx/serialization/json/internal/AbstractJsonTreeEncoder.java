package kotlinx.serialization.json.internal;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.m;
import kotlin.o;
import kotlin.q;
import kotlin.t;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.k;
import kotlinx.serialization.json.n;
import kotlinx.serialization.modules.d;

public abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements k {

    /* renamed from: b  reason: collision with root package name */
    public final kotlinx.serialization.json.a f57856b;

    /* renamed from: c  reason: collision with root package name */
    public final l<g, Unit> f57857c;

    /* renamed from: d  reason: collision with root package name */
    public final JsonConfiguration f57858d;

    /* renamed from: e  reason: collision with root package name */
    public String f57859e;

    public static final class a extends AbstractEncoder {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbstractJsonTreeEncoder f57860a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57861b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f57862c;

        public a(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str, f fVar) {
            this.f57860a = abstractJsonTreeEncoder;
            this.f57861b = str;
            this.f57862c = fVar;
        }

        public d a() {
            return this.f57860a.d().a();
        }

        public void v(String str) {
            this.f57860a.y0(this.f57861b, new n(str, false, this.f57862c));
        }
    }

    public static final class b extends AbstractEncoder {

        /* renamed from: a  reason: collision with root package name */
        public final d f57863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbstractJsonTreeEncoder f57864b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f57865c;

        public b(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str) {
            this.f57864b = abstractJsonTreeEncoder;
            this.f57865c = str;
            this.f57863a = abstractJsonTreeEncoder.d().a();
        }

        public void A(long j11) {
            K(f.a(q.b(j11), 10));
        }

        public final void K(String str) {
            this.f57864b.y0(this.f57865c, new n(str, false, (f) null, 4, (r) null));
        }

        public d a() {
            return this.f57863a;
        }

        public void f(byte b11) {
            K(m.f(m.b(b11)));
        }

        public void k(short s11) {
            K(t.f(t.b(s11)));
        }

        public void s(int i11) {
            K(d.a(o.b(i11), 10));
        }
    }

    public AbstractJsonTreeEncoder(kotlinx.serialization.json.a aVar, l<? super g, Unit> lVar) {
        this.f57856b = aVar;
        this.f57857c = lVar;
        this.f57858d = aVar.f();
    }

    public /* synthetic */ AbstractJsonTreeEncoder(kotlinx.serialization.json.a aVar, l lVar, r rVar) {
        this(aVar, lVar);
    }

    public static final /* synthetic */ String h0(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        return (String) abstractJsonTreeEncoder.Y();
    }

    public void B() {
        String str = (String) Z();
        if (str == null) {
            this.f57857c.invoke(JsonNull.INSTANCE);
        } else {
            T(str);
        }
    }

    public void E() {
    }

    public void X(f fVar) {
        this.f57857c.invoke(v0());
    }

    public final d a() {
        return this.f57856b.a();
    }

    public kotlinx.serialization.encoding.b b(f fVar) {
        l lVar;
        AbstractJsonTreeEncoder abstractJsonTreeEncoder;
        if (Z() == null) {
            lVar = this.f57857c;
        } else {
            lVar = new AbstractJsonTreeEncoder$beginStructure$consumer$1(this);
        }
        h kind = fVar.getKind();
        if (x.b(kind, i.b.f57648a) ? true : kind instanceof kotlinx.serialization.descriptors.d) {
            abstractJsonTreeEncoder = new d0(this.f57856b, lVar);
        } else if (x.b(kind, i.c.f57649a)) {
            kotlinx.serialization.json.a aVar = this.f57856b;
            f a11 = p0.a(fVar.d(0), aVar.a());
            h kind2 = a11.getKind();
            if ((kind2 instanceof e) || x.b(kind2, h.b.f57646a)) {
                abstractJsonTreeEncoder = new f0(this.f57856b, lVar);
            } else if (aVar.f().b()) {
                abstractJsonTreeEncoder = new d0(this.f57856b, lVar);
            } else {
                throw w.d(a11);
            }
        } else {
            abstractJsonTreeEncoder = new b0(this.f57856b, lVar);
        }
        String str = this.f57859e;
        if (str != null) {
            abstractJsonTreeEncoder.y0(str, kotlinx.serialization.json.i.c(fVar.h()));
            this.f57859e = null;
        }
        return abstractJsonTreeEncoder;
    }

    public final kotlinx.serialization.json.a d() {
        return this.f57856b;
    }

    public String d0(String str, String str2) {
        return str2;
    }

    public <T> void e(kotlinx.serialization.g<? super T> gVar, T t11) {
        if (Z() == null && TreeJsonEncoderKt.b(p0.a(gVar.getDescriptor(), a()))) {
            y yVar = new y(this.f57856b, this.f57857c);
            yVar.e(gVar, t11);
            yVar.X(gVar.getDescriptor());
        } else if (!(gVar instanceof AbstractPolymorphicSerializer) || d().f().l()) {
            gVar.serialize(this, t11);
        } else {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) gVar;
            String c11 = h0.c(gVar.getDescriptor(), d());
            kotlinx.serialization.g b11 = kotlinx.serialization.d.b(abstractPolymorphicSerializer, this, t11);
            h0.f(abstractPolymorphicSerializer, b11, c11);
            h0.b(b11.getDescriptor().getKind());
            this.f57859e = c11;
            b11.serialize(this, t11);
        }
    }

    public String e0(f fVar, int i11) {
        return JsonNamesMapKt.f(fVar, this.f57856b, i11);
    }

    /* renamed from: i0 */
    public void J(String str, boolean z11) {
        y0(str, kotlinx.serialization.json.i.a(Boolean.valueOf(z11)));
    }

    /* renamed from: j0 */
    public void K(String str, byte b11) {
        y0(str, kotlinx.serialization.json.i.b(Byte.valueOf(b11)));
    }

    /* renamed from: k0 */
    public void L(String str, char c11) {
        y0(str, kotlinx.serialization.json.i.c(String.valueOf(c11)));
    }

    /* renamed from: l0 */
    public void M(String str, double d11) {
        y0(str, kotlinx.serialization.json.i.b(Double.valueOf(d11)));
        if (!this.f57858d.a()) {
            if (!(!Double.isInfinite(d11) && !Double.isNaN(d11))) {
                throw w.c(Double.valueOf(d11), str, v0().toString());
            }
        }
    }

    /* renamed from: m0 */
    public void N(String str, f fVar, int i11) {
        y0(str, kotlinx.serialization.json.i.c(fVar.f(i11)));
    }

    /* renamed from: n0 */
    public void O(String str, float f11) {
        y0(str, kotlinx.serialization.json.i.b(Float.valueOf(f11)));
        if (!this.f57858d.a()) {
            if (!(!Float.isInfinite(f11) && !Float.isNaN(f11))) {
                throw w.c(Float.valueOf(f11), str, v0().toString());
            }
        }
    }

    /* renamed from: o0 */
    public kotlinx.serialization.encoding.d P(String str, f fVar) {
        if (l0.b(fVar)) {
            return x0(str);
        }
        if (l0.a(fVar)) {
            return w0(str, fVar);
        }
        return super.P(str, fVar);
    }

    /* renamed from: p0 */
    public void Q(String str, int i11) {
        y0(str, kotlinx.serialization.json.i.b(Integer.valueOf(i11)));
    }

    public boolean q(f fVar, int i11) {
        return this.f57858d.e();
    }

    /* renamed from: q0 */
    public void R(String str, long j11) {
        y0(str, kotlinx.serialization.json.i.b(Long.valueOf(j11)));
    }

    public void r(g gVar) {
        e(JsonElementSerializer.f57821a, gVar);
    }

    /* renamed from: r0 */
    public void T(String str) {
        y0(str, JsonNull.INSTANCE);
    }

    /* renamed from: s0 */
    public void U(String str, short s11) {
        y0(str, kotlinx.serialization.json.i.b(Short.valueOf(s11)));
    }

    /* renamed from: t0 */
    public void V(String str, String str2) {
        y0(str, kotlinx.serialization.json.i.c(str2));
    }

    /* renamed from: u0 */
    public void W(String str, Object obj) {
        y0(str, kotlinx.serialization.json.i.c(obj.toString()));
    }

    public abstract g v0();

    public final a w0(String str, f fVar) {
        return new a(this, str, fVar);
    }

    public final b x0(String str) {
        return new b(this, str);
    }

    public abstract void y0(String str, g gVar);
}
