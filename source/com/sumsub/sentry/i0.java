package com.sumsub.sentry;

import com.sumsub.sentry.h0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 %2\u00020\u0001:\u0002\b\u0012B=\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001e\u0010\u001fBQ\b\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0001\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001e\u0010$J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R(\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u000b\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\b\u0010\fR.\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u0019\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/sumsub/sentry/i0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sentry/h0;", "Ljava/util/List;", "()Ljava/util/List;", "getFrames$annotations", "()V", "frames", "", "", "b", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "getRegisters$annotations", "registers", "", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "getSnapshot$annotations", "snapshot", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/util/Map;Ljava/lang/Boolean;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class i0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<h0> f30382a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f30383b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f30384c;

    public static final class a implements d0<i0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30385a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30386b;

        static {
            a aVar = new a();
            f30385a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryStackTrace", aVar, 3);
            pluginGeneratedSerialDescriptor.k("frames", true);
            pluginGeneratedSerialDescriptor.k("registers", true);
            pluginGeneratedSerialDescriptor.k("snapshot", true);
            f30386b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.i0 deserialize(kotlinx.serialization.encoding.c r13) {
            /*
                r12 = this;
                kotlinx.serialization.descriptors.f r0 = r12.getDescriptor()
                kotlinx.serialization.encoding.a r13 = r13.b(r0)
                boolean r1 = r13.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0033
                kotlinx.serialization.internal.e r1 = new kotlinx.serialization.internal.e
                com.sumsub.sentry.h0$a r6 = com.sumsub.sentry.h0.a.f30376a
                r1.<init>(r6)
                java.lang.Object r1 = r13.j(r0, r4, r1, r2)
                kotlinx.serialization.internal.r0 r4 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r4.<init>(r6, r6)
                java.lang.Object r4 = r13.j(r0, r5, r4, r2)
                kotlinx.serialization.internal.h r5 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r2 = r13.j(r0, r3, r5, r2)
                r3 = 7
                r11 = r4
                r4 = r3
                r3 = r11
                goto L_0x0077
            L_0x0033:
                r1 = r2
                r6 = r1
                r7 = r4
                r8 = r5
            L_0x0037:
                if (r8 == 0) goto L_0x0073
                int r9 = r13.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0071
                if (r9 == 0) goto L_0x0063
                if (r9 == r5) goto L_0x0055
                if (r9 != r3) goto L_0x004f
                kotlinx.serialization.internal.h r9 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r6 = r13.j(r0, r3, r9, r6)
                r7 = r7 | 4
                goto L_0x0037
            L_0x004f:
                kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
                r13.<init>((int) r9)
                throw r13
            L_0x0055:
                kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                r9.<init>(r10, r10)
                java.lang.Object r1 = r13.j(r0, r5, r9, r1)
                r7 = r7 | 2
                goto L_0x0037
            L_0x0063:
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                com.sumsub.sentry.h0$a r10 = com.sumsub.sentry.h0.a.f30376a
                r9.<init>(r10)
                java.lang.Object r2 = r13.j(r0, r4, r9, r2)
                r7 = r7 | 1
                goto L_0x0037
            L_0x0071:
                r8 = r4
                goto L_0x0037
            L_0x0073:
                r3 = r1
                r1 = r2
                r2 = r6
                r4 = r7
            L_0x0077:
                r13.c(r0)
                com.sumsub.sentry.i0 r13 = new com.sumsub.sentry.i0
                r5 = r1
                java.util.List r5 = (java.util.List) r5
                r6 = r3
                java.util.Map r6 = (java.util.Map) r6
                r7 = r2
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                r8 = 0
                r3 = r13
                r3.<init>((int) r4, (java.util.List) r5, (java.util.Map) r6, (java.lang.Boolean) r7, (kotlinx.serialization.internal.q1) r8)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.i0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.i0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(new e(h0.a.f30376a)), h10.a.u(new r0(v1Var, v1Var)), h10.a.u(h.f57720a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30386b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, i0 i0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            i0.a(i0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<i0> serializer() {
            return a.f30385a;
        }

        public b() {
        }
    }

    public i0() {
        this((List) null, (Map) null, (Boolean) null, 7, (r) null);
    }

    public static final void a(i0 i0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || i0Var.f30382a != null) {
            bVar.y(fVar, 0, new e(h0.a.f30376a), i0Var.f30382a);
        }
        if (bVar.q(fVar, 1) || i0Var.f30383b != null) {
            v1 v1Var = v1.f57779a;
            bVar.y(fVar, 1, new r0(v1Var, v1Var), i0Var.f30383b);
        }
        if (bVar.q(fVar, 2) || i0Var.f30384c != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 2, h.f57720a, i0Var.f30384c);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final Map<String, String> c() {
        return this.f30383b;
    }

    public final Boolean e() {
        return this.f30384c;
    }

    public /* synthetic */ i0(int i11, List list, Map map, Boolean bool, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30385a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30382a = null;
        } else {
            this.f30382a = list;
        }
        if ((i11 & 2) == 0) {
            this.f30383b = null;
        } else {
            this.f30383b = map;
        }
        if ((i11 & 4) == 0) {
            this.f30384c = null;
        } else {
            this.f30384c = bool;
        }
    }

    public final List<h0> a() {
        return this.f30382a;
    }

    public i0(List<h0> list, Map<String, String> map, Boolean bool) {
        this.f30382a = list;
        this.f30383b = map;
        this.f30384c = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(List list, Map map, Boolean bool, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : map, (i11 & 4) != 0 ? null : bool);
    }
}
