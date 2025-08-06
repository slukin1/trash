package com.sumsub.sentry;

import com.facebook.internal.ServerProtocol;
import com.sumsub.sentry.d0;
import com.sumsub.sentry.s;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0010B\"\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017B6\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R+\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR\"\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sentry/w;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sentry/d0;", "Ljava/lang/String;", "()Ljava/lang/String;", "getEventId-Chs0R2U$annotations", "()V", "eventId", "Lcom/sumsub/sentry/s;", "b", "Lcom/sumsub/sentry/s;", "c", "()Lcom/sumsub/sentry/s;", "getSdkVersion$annotations", "sdkVersion", "<init>", "(Ljava/lang/String;Lcom/sumsub/sentry/s;Lkotlin/jvm/internal/r;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sumsub/sentry/s;Lkotlinx/serialization/internal/q1;Lkotlin/jvm/internal/r;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class w {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30519a;

    /* renamed from: b  reason: collision with root package name */
    public final s f30520b;

    public static final class a implements d0<w> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30521a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30522b;

        static {
            a aVar = new a();
            f30521a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryEnvelopeHeader", aVar, 2);
            pluginGeneratedSerialDescriptor.k("event_id", true);
            pluginGeneratedSerialDescriptor.k(ServerProtocol.DIALOG_PARAM_SDK_VERSION, true);
            f30522b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.w deserialize(kotlinx.serialization.encoding.c r11) {
            /*
                r10 = this;
                kotlinx.serialization.descriptors.f r0 = r10.getDescriptor()
                kotlinx.serialization.encoding.a r11 = r11.b(r0)
                boolean r1 = r11.k()
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0020
                com.sumsub.sentry.d0$a r1 = com.sumsub.sentry.d0.a.f30317a
                java.lang.Object r1 = r11.j(r0, r3, r1, r2)
                com.sumsub.sentry.s$a r3 = com.sumsub.sentry.s.a.f30494a
                java.lang.Object r3 = r11.j(r0, r4, r3, r2)
                r4 = 3
                r5 = r4
                goto L_0x004d
            L_0x0020:
                r1 = r2
                r5 = r1
                r6 = r3
                r7 = r4
            L_0x0024:
                if (r7 == 0) goto L_0x004b
                int r8 = r11.w(r0)
                r9 = -1
                if (r8 == r9) goto L_0x0049
                if (r8 == 0) goto L_0x0040
                if (r8 != r4) goto L_0x003a
                com.sumsub.sentry.s$a r8 = com.sumsub.sentry.s.a.f30494a
                java.lang.Object r5 = r11.j(r0, r4, r8, r5)
                r6 = r6 | 2
                goto L_0x0024
            L_0x003a:
                kotlinx.serialization.UnknownFieldException r11 = new kotlinx.serialization.UnknownFieldException
                r11.<init>((int) r8)
                throw r11
            L_0x0040:
                com.sumsub.sentry.d0$a r8 = com.sumsub.sentry.d0.a.f30317a
                java.lang.Object r1 = r11.j(r0, r3, r8, r1)
                r6 = r6 | 1
                goto L_0x0024
            L_0x0049:
                r7 = r3
                goto L_0x0024
            L_0x004b:
                r3 = r5
                r5 = r6
            L_0x004d:
                r11.c(r0)
                com.sumsub.sentry.w r11 = new com.sumsub.sentry.w
                com.sumsub.sentry.d0 r1 = (com.sumsub.sentry.d0) r1
                if (r1 == 0) goto L_0x005a
                java.lang.String r2 = r1.b()
            L_0x005a:
                r6 = r2
                r7 = r3
                com.sumsub.sentry.s r7 = (com.sumsub.sentry.s) r7
                r8 = 0
                r9 = 0
                r4 = r11
                r4.<init>(r5, r6, r7, r8, r9)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.w.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.w");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(d0.a.f30317a), h10.a.u(s.a.f30494a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30522b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, w wVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            w.a(wVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<w> serializer() {
            return a.f30521a;
        }

        public b() {
        }
    }

    public /* synthetic */ w(int i11, String str, s sVar, q1 q1Var, r rVar) {
        this(i11, str, sVar, q1Var);
    }

    public static final void a(w wVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || wVar.f30519a != null) {
            d0.a aVar = d0.a.f30317a;
            String str = wVar.f30519a;
            bVar.y(fVar, 0, aVar, str != null ? d0.a(str) : null);
        }
        if (bVar.q(fVar, 1) || wVar.f30520b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, s.a.f30494a, wVar.f30520b);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public final s c() {
        return this.f30520b;
    }

    public /* synthetic */ w(String str, s sVar, r rVar) {
        this(str, sVar);
    }

    public final String a() {
        return this.f30519a;
    }

    public w(int i11, String str, s sVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30521a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30519a = null;
        } else {
            this.f30519a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30520b = null;
        } else {
            this.f30520b = sVar;
        }
    }

    public w(String str, s sVar) {
        this.f30519a = str;
        this.f30520b = sVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(String str, s sVar, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : sVar, (r) null);
    }
}
