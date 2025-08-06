package com.sumsub.sentry;

import com.sumsub.sentry.e0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 .2\u00020\u0001:\u0002\b\rB;\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e¢\u0006\u0004\b(\u0010)BW\b\u0017\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0001\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b(\u0010-J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tJ\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\r\u001a\u00020\tHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eHÆ\u0003JA\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eHÆ\u0001J\t\u0010\u0014\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR \u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u0012\u0004\b \u0010\u001e\u001a\u0004\b\u001f\u0010\u001cR0\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0010\u0010!\u0012\u0004\b%\u0010\u001e\u001a\u0004\b\"\u0010#\"\u0004\b\r\u0010$R0\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010!\u0012\u0004\b'\u0010\u001e\u001a\u0004\b&\u0010#\"\u0004\b\b\u0010$¨\u0006/"}, d2 = {"Lcom/sumsub/sentry/s;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "name", "version", "integration", "b", "", "Lcom/sumsub/sentry/e0;", "c", "d", "packages", "integrations", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "getName$annotations", "()V", "k", "getVersion$annotations", "Ljava/util/List;", "i", "()Ljava/util/List;", "(Ljava/util/List;)V", "getPackages$annotations", "e", "getIntegrations$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class s {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30490a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30491b;

    /* renamed from: c  reason: collision with root package name */
    public List<e0> f30492c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f30493d;

    public static final class a implements d0<s> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30494a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30495b;

        static {
            a aVar = new a();
            f30494a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SdkVersion", aVar, 4);
            pluginGeneratedSerialDescriptor.k("name", false);
            pluginGeneratedSerialDescriptor.k("version", false);
            pluginGeneratedSerialDescriptor.k("packages", true);
            pluginGeneratedSerialDescriptor.k("integrations", true);
            f30495b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.s deserialize(kotlinx.serialization.encoding.c r20) {
            /*
                r19 = this;
                kotlinx.serialization.descriptors.f r0 = r19.getDescriptor()
                r1 = r20
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 3
                r4 = 2
                r5 = 0
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L_0x0039
                java.lang.String r2 = r1.i(r0, r6)
                java.lang.String r6 = r1.i(r0, r7)
                kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                com.sumsub.sentry.e0$a r8 = com.sumsub.sentry.e0.a.f30326a
                r7.<init>(r8)
                java.lang.Object r4 = r1.j(r0, r4, r7, r5)
                kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                r7.<init>(r8)
                java.lang.Object r3 = r1.j(r0, r3, r7, r5)
                r5 = 15
                r14 = r2
                r13 = r5
                r15 = r6
                goto L_0x0087
            L_0x0039:
                r2 = r5
                r8 = r2
                r9 = r8
                r10 = r9
                r5 = r6
                r11 = r7
            L_0x003f:
                if (r11 == 0) goto L_0x0082
                int r12 = r1.w(r0)
                r13 = -1
                if (r12 == r13) goto L_0x0080
                if (r12 == 0) goto L_0x0079
                if (r12 == r7) goto L_0x0072
                if (r12 == r4) goto L_0x0064
                if (r12 != r3) goto L_0x005e
                kotlinx.serialization.internal.e r12 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r13 = kotlinx.serialization.internal.v1.f57779a
                r12.<init>(r13)
                java.lang.Object r10 = r1.j(r0, r3, r12, r10)
                r5 = r5 | 8
                goto L_0x003f
            L_0x005e:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r12)
                throw r0
            L_0x0064:
                kotlinx.serialization.internal.e r12 = new kotlinx.serialization.internal.e
                com.sumsub.sentry.e0$a r13 = com.sumsub.sentry.e0.a.f30326a
                r12.<init>(r13)
                java.lang.Object r9 = r1.j(r0, r4, r12, r9)
                r5 = r5 | 4
                goto L_0x003f
            L_0x0072:
                java.lang.String r8 = r1.i(r0, r7)
                r5 = r5 | 2
                goto L_0x003f
            L_0x0079:
                java.lang.String r2 = r1.i(r0, r6)
                r5 = r5 | 1
                goto L_0x003f
            L_0x0080:
                r11 = r6
                goto L_0x003f
            L_0x0082:
                r14 = r2
                r13 = r5
                r15 = r8
                r4 = r9
                r3 = r10
            L_0x0087:
                r1.c(r0)
                com.sumsub.sentry.s r0 = new com.sumsub.sentry.s
                r16 = r4
                java.util.List r16 = (java.util.List) r16
                r17 = r3
                java.util.List r17 = (java.util.List) r17
                r18 = 0
                r12 = r0
                r12.<init>((int) r13, (java.lang.String) r14, (java.lang.String) r15, (java.util.List) r16, (java.util.List) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.s.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.s");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var, h10.a.u(new e(e0.a.f30326a)), h10.a.u(new e(v1Var))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30495b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, s sVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            s.a(sVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<s> serializer() {
            return a.f30494a;
        }

        public b() {
        }
    }

    public /* synthetic */ s(int i11, String str, String str2, List list, List list2, q1 q1Var) {
        if (3 != (i11 & 3)) {
            h1.a(i11, 3, a.f30494a.getDescriptor());
        }
        this.f30490a = str;
        this.f30491b = str2;
        if ((i11 & 4) == 0) {
            this.f30492c = null;
        } else {
            this.f30492c = list;
        }
        if ((i11 & 8) == 0) {
            this.f30493d = null;
        } else {
            this.f30493d = list2;
        }
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public final String a() {
        return this.f30490a;
    }

    public final String b() {
        return this.f30491b;
    }

    public final List<e0> c() {
        return this.f30492c;
    }

    public final List<String> d() {
        return this.f30493d;
    }

    public final List<String> e() {
        return this.f30493d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return x.b(this.f30490a, sVar.f30490a) && x.b(this.f30491b, sVar.f30491b) && x.b(this.f30492c, sVar.f30492c) && x.b(this.f30493d, sVar.f30493d);
    }

    public final String g() {
        return this.f30490a;
    }

    public int hashCode() {
        int hashCode = ((this.f30490a.hashCode() * 31) + this.f30491b.hashCode()) * 31;
        List<e0> list = this.f30492c;
        int i11 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.f30493d;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode2 + i11;
    }

    public final List<e0> i() {
        return this.f30492c;
    }

    public final String k() {
        return this.f30491b;
    }

    public String toString() {
        return "SdkVersion(name=" + this.f30490a + ", version=" + this.f30491b + ", packages=" + this.f30492c + ", integrations=" + this.f30493d + ')';
    }

    public s(String str, String str2, List<e0> list, List<String> list2) {
        this.f30490a = str;
        this.f30491b = str2;
        this.f30492c = list;
        this.f30493d = list2;
    }

    public final s a(String str, String str2, List<e0> list, List<String> list2) {
        return new s(str, str2, list, list2);
    }

    public final void b(List<e0> list) {
        this.f30492c = list;
    }

    public static /* synthetic */ s a(s sVar, String str, String str2, List<e0> list, List<String> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sVar.f30490a;
        }
        if ((i11 & 2) != 0) {
            str2 = sVar.f30491b;
        }
        if ((i11 & 4) != 0) {
            list = sVar.f30492c;
        }
        if ((i11 & 8) != 0) {
            list2 = sVar.f30493d;
        }
        return sVar.a(str, str2, list, list2);
    }

    public static final void a(s sVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        bVar.p(fVar, 0, sVar.f30490a);
        bVar.p(fVar, 1, sVar.f30491b);
        if (bVar.q(fVar, 2) || sVar.f30492c != null) {
            bVar.y(fVar, 2, new e(e0.a.f30326a), sVar.f30492c);
        }
        if (bVar.q(fVar, 3) || sVar.f30493d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, new e(v1.f57779a), sVar.f30493d);
        }
    }

    public final void a(List<String> list) {
        this.f30493d = list;
    }

    public final void a(String str, String str2) {
        e0 e0Var = new e0(str, str2);
        if (this.f30492c == null) {
            this.f30492c = new ArrayList();
        }
        List<e0> list = this.f30492c;
        if (list != null) {
            list.add(e0Var);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(String str, String str2, List list, List list2, int i11, r rVar) {
        this(str, str2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : list2);
    }

    public final void a(String str) {
        if (this.f30493d == null) {
            this.f30493d = new ArrayList();
        }
        List<String> list = this.f30493d;
        if (list != null) {
            list.add(str);
        }
    }
}
