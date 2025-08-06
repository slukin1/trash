package kotlinx.serialization.json.internal;

import com.iproov.sdk.bridge.OptionsBridge;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.g;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.k;
import kotlinx.serialization.modules.d;

public final class k0 extends AbstractEncoder implements k {

    /* renamed from: a  reason: collision with root package name */
    public final j f57922a;

    /* renamed from: b  reason: collision with root package name */
    public final kotlinx.serialization.json.a f57923b;

    /* renamed from: c  reason: collision with root package name */
    public final WriteMode f57924c;

    /* renamed from: d  reason: collision with root package name */
    public final k[] f57925d;

    /* renamed from: e  reason: collision with root package name */
    public final d f57926e;

    /* renamed from: f  reason: collision with root package name */
    public final JsonConfiguration f57927f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57928g;

    /* renamed from: h  reason: collision with root package name */
    public String f57929h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57930a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
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
                f57930a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.k0.a.<clinit>():void");
        }
    }

    public k0(j jVar, kotlinx.serialization.json.a aVar, WriteMode writeMode, k[] kVarArr) {
        this.f57922a = jVar;
        this.f57923b = aVar;
        this.f57924c = writeMode;
        this.f57925d = kVarArr;
        this.f57926e = d().a();
        this.f57927f = d().f();
        int ordinal = writeMode.ordinal();
        if (kVarArr == null) {
            return;
        }
        if (kVarArr[ordinal] != null || kVarArr[ordinal] != this) {
            kVarArr[ordinal] = this;
        }
    }

    public void A(long j11) {
        if (this.f57928g) {
            v(String.valueOf(j11));
        } else {
            this.f57922a.i(j11);
        }
    }

    public void B() {
        this.f57922a.j(OptionsBridge.NULL_VALUE);
    }

    public void D(char c11) {
        v(String.valueOf(c11));
    }

    public boolean H(f fVar, int i11) {
        int i12 = a.f57930a[this.f57924c.ordinal()];
        if (i12 != 1) {
            boolean z11 = false;
            if (i12 != 2) {
                if (i12 != 3) {
                    if (!this.f57922a.a()) {
                        this.f57922a.e(',');
                    }
                    this.f57922a.c();
                    v(JsonNamesMapKt.f(fVar, d(), i11));
                    this.f57922a.e(':');
                    this.f57922a.o();
                } else {
                    if (i11 == 0) {
                        this.f57928g = true;
                    }
                    if (i11 == 1) {
                        this.f57922a.e(',');
                        this.f57922a.o();
                        this.f57928g = false;
                    }
                }
            } else if (!this.f57922a.a()) {
                if (i11 % 2 == 0) {
                    this.f57922a.e(',');
                    this.f57922a.c();
                    z11 = true;
                } else {
                    this.f57922a.e(':');
                    this.f57922a.o();
                }
                this.f57928g = z11;
            } else {
                this.f57928g = true;
                this.f57922a.c();
            }
        } else {
            if (!this.f57922a.a()) {
                this.f57922a.e(',');
            }
            this.f57922a.c();
        }
        return true;
    }

    public final void K(f fVar) {
        this.f57922a.c();
        v(this.f57929h);
        this.f57922a.e(':');
        this.f57922a.o();
        v(fVar.h());
    }

    public d a() {
        return this.f57926e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        r5 = r5[r0.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.encoding.b b(kotlinx.serialization.descriptors.f r5) {
        /*
            r4 = this;
            kotlinx.serialization.json.a r0 = r4.d()
            kotlinx.serialization.json.internal.WriteMode r0 = kotlinx.serialization.json.internal.p0.b(r0, r5)
            char r1 = r0.begin
            if (r1 == 0) goto L_0x0016
            kotlinx.serialization.json.internal.j r2 = r4.f57922a
            r2.e(r1)
            kotlinx.serialization.json.internal.j r1 = r4.f57922a
            r1.b()
        L_0x0016:
            java.lang.String r1 = r4.f57929h
            if (r1 == 0) goto L_0x0020
            r4.K(r5)
            r5 = 0
            r4.f57929h = r5
        L_0x0020:
            kotlinx.serialization.json.internal.WriteMode r5 = r4.f57924c
            if (r5 != r0) goto L_0x0025
            return r4
        L_0x0025:
            kotlinx.serialization.json.k[] r5 = r4.f57925d
            if (r5 == 0) goto L_0x0032
            int r1 = r0.ordinal()
            r5 = r5[r1]
            if (r5 == 0) goto L_0x0032
            goto L_0x003f
        L_0x0032:
            kotlinx.serialization.json.internal.k0 r5 = new kotlinx.serialization.json.internal.k0
            kotlinx.serialization.json.internal.j r1 = r4.f57922a
            kotlinx.serialization.json.a r2 = r4.d()
            kotlinx.serialization.json.k[] r3 = r4.f57925d
            r5.<init>((kotlinx.serialization.json.internal.j) r1, (kotlinx.serialization.json.a) r2, (kotlinx.serialization.json.internal.WriteMode) r0, (kotlinx.serialization.json.k[]) r3)
        L_0x003f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.k0.b(kotlinx.serialization.descriptors.f):kotlinx.serialization.encoding.b");
    }

    public void c(f fVar) {
        if (this.f57924c.end != 0) {
            this.f57922a.p();
            this.f57922a.c();
            this.f57922a.e(this.f57924c.end);
        }
    }

    public kotlinx.serialization.json.a d() {
        return this.f57923b;
    }

    public <T> void e(g<? super T> gVar, T t11) {
        if (!(gVar instanceof AbstractPolymorphicSerializer) || d().f().l()) {
            gVar.serialize(this, t11);
            return;
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) gVar;
        String c11 = h0.c(gVar.getDescriptor(), d());
        g b11 = kotlinx.serialization.d.b(abstractPolymorphicSerializer, this, t11);
        h0.f(abstractPolymorphicSerializer, b11, c11);
        h0.b(b11.getDescriptor().getKind());
        this.f57929h = c11;
        b11.serialize(this, t11);
    }

    public void f(byte b11) {
        if (this.f57928g) {
            v(String.valueOf(b11));
        } else {
            this.f57922a.d(b11);
        }
    }

    public void g(f fVar, int i11) {
        v(fVar.f(i11));
    }

    public kotlinx.serialization.encoding.d h(f fVar) {
        if (l0.b(fVar)) {
            j jVar = this.f57922a;
            if (!(jVar instanceof r)) {
                jVar = new r(jVar.f57909a, this.f57928g);
            }
            return new k0(jVar, d(), this.f57924c, (k[]) null);
        } else if (!l0.a(fVar)) {
            return super.h(fVar);
        } else {
            j jVar2 = this.f57922a;
            if (!(jVar2 instanceof k)) {
                jVar2 = new k(jVar2.f57909a, this.f57928g);
            }
            return new k0(jVar2, d(), this.f57924c, (k[]) null);
        }
    }

    public void k(short s11) {
        if (this.f57928g) {
            v(String.valueOf(s11));
        } else {
            this.f57922a.k(s11);
        }
    }

    public void l(boolean z11) {
        if (this.f57928g) {
            v(String.valueOf(z11));
        } else {
            this.f57922a.l(z11);
        }
    }

    public void m(float f11) {
        if (this.f57928g) {
            v(String.valueOf(f11));
        } else {
            this.f57922a.g(f11);
        }
        if (!this.f57927f.a()) {
            if (!(!Float.isInfinite(f11) && !Float.isNaN(f11))) {
                throw w.b(Float.valueOf(f11), this.f57922a.f57909a.toString());
            }
        }
    }

    public boolean q(f fVar, int i11) {
        return this.f57927f.e();
    }

    public void r(kotlinx.serialization.json.g gVar) {
        e(JsonElementSerializer.f57821a, gVar);
    }

    public void s(int i11) {
        if (this.f57928g) {
            v(String.valueOf(i11));
        } else {
            this.f57922a.h(i11);
        }
    }

    public void v(String str) {
        this.f57922a.m(str);
    }

    public void x(double d11) {
        if (this.f57928g) {
            v(String.valueOf(d11));
        } else {
            this.f57922a.f(d11);
        }
        if (!this.f57927f.a()) {
            if (!(!Double.isInfinite(d11) && !Double.isNaN(d11))) {
                throw w.b(Double.valueOf(d11), this.f57922a.f57909a.toString());
            }
        }
    }

    public <T> void y(f fVar, int i11, g<? super T> gVar, T t11) {
        if (t11 != null || this.f57927f.f()) {
            super.y(fVar, i11, gVar, t11);
        }
    }

    public k0(g0 g0Var, kotlinx.serialization.json.a aVar, WriteMode writeMode, k[] kVarArr) {
        this(t.a(g0Var, aVar), aVar, writeMode, kVarArr);
    }
}
