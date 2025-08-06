package com.sumsub.sentry;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000  2\u00020\u0001:\u0002\b\u000fB1\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001aBE\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000bR(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/sumsub/sentry/p;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getFormatted$annotations", "()V", "formatted", "b", "c", "getMessage$annotations", "message", "", "Ljava/util/List;", "e", "()Ljava/util/List;", "getParams$annotations", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class p {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30462a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30463b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f30464c;

    public static final class a implements d0<p> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30465a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30466b;

        static {
            a aVar = new a();
            f30465a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.Message", aVar, 3);
            pluginGeneratedSerialDescriptor.k("formatted", true);
            pluginGeneratedSerialDescriptor.k("message", true);
            pluginGeneratedSerialDescriptor.k("params", true);
            f30466b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.p deserialize(kotlinx.serialization.encoding.c r12) {
            /*
                r11 = this;
                kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
                kotlinx.serialization.encoding.a r12 = r12.b(r0)
                boolean r1 = r12.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0028
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r4 = r12.j(r0, r4, r1, r2)
                java.lang.Object r5 = r12.j(r0, r5, r1, r2)
                kotlinx.serialization.internal.e r6 = new kotlinx.serialization.internal.e
                r6.<init>(r1)
                java.lang.Object r1 = r12.j(r0, r3, r6, r2)
                r2 = 7
                r3 = r2
                goto L_0x0068
            L_0x0028:
                r1 = r2
                r6 = r1
                r7 = r6
                r2 = r4
                r8 = r5
            L_0x002d:
                if (r8 == 0) goto L_0x0064
                int r9 = r12.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0062
                if (r9 == 0) goto L_0x0059
                if (r9 == r5) goto L_0x0050
                if (r9 != r3) goto L_0x004a
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                r9.<init>(r10)
                java.lang.Object r7 = r12.j(r0, r3, r9, r7)
                r2 = r2 | 4
                goto L_0x002d
            L_0x004a:
                kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
                r12.<init>((int) r9)
                throw r12
            L_0x0050:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r12.j(r0, r5, r9, r6)
                r2 = r2 | 2
                goto L_0x002d
            L_0x0059:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r12.j(r0, r4, r9, r1)
                r2 = r2 | 1
                goto L_0x002d
            L_0x0062:
                r8 = r4
                goto L_0x002d
            L_0x0064:
                r4 = r1
                r3 = r2
                r5 = r6
                r1 = r7
            L_0x0068:
                r12.c(r0)
                com.sumsub.sentry.p r12 = new com.sumsub.sentry.p
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r5 = (java.lang.String) r5
                r6 = r1
                java.util.List r6 = (java.util.List) r6
                r7 = 0
                r2 = r12
                r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.util.List) r6, (kotlinx.serialization.internal.q1) r7)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.p.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.p");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(v1Var))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30466b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, p pVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            p.a(pVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<p> serializer() {
            return a.f30465a;
        }

        public b() {
        }
    }

    public p() {
        this((String) null, (String) null, (List) null, 7, (r) null);
    }

    public static final void a(p pVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || pVar.f30462a != null) {
            bVar.y(fVar, 0, v1.f57779a, pVar.f30462a);
        }
        if (bVar.q(fVar, 1) || pVar.f30463b != null) {
            bVar.y(fVar, 1, v1.f57779a, pVar.f30463b);
        }
        if (bVar.q(fVar, 2) || pVar.f30464c != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 2, new e(v1.f57779a), pVar.f30464c);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String c() {
        return this.f30463b;
    }

    public final List<String> e() {
        return this.f30464c;
    }

    public /* synthetic */ p(int i11, String str, String str2, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30465a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30462a = null;
        } else {
            this.f30462a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30463b = null;
        } else {
            this.f30463b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30464c = null;
        } else {
            this.f30464c = list;
        }
    }

    public final String a() {
        return this.f30462a;
    }

    public p(String str, String str2, List<String> list) {
        this.f30462a = str;
        this.f30463b = str2;
        this.f30464c = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(String str, String str2, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list);
    }
}
