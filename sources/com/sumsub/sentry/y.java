package com.sumsub.sentry;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sentry.SentryItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 12\u00020\u0001:\u0002\b\nB;\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b+\u0010,BU\b\u0017\u0012\u0006\u0010-\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u000e\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b+\u00100J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003JA\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u001a\u0012\u0004\b \u0010\u001e\u001a\u0004\b\u001f\u0010\u001cR \u0010\u0012\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010!\u0012\u0004\b$\u0010\u001e\u001a\u0004\b\"\u0010#R\"\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u0012\u0004\b&\u0010\u001e\u001a\u0004\b%\u0010\u001cR \u0010\u0014\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010'\u0012\u0004\b*\u0010\u001e\u001a\u0004\b(\u0010)¨\u00062"}, d2 = {"Lcom/sumsub/sentry/y;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Lcom/sumsub/sentry/SentryItemType;", "c", "d", "", "e", "contentType", "fileName", "type", "attachmentType", "length", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getContentType$annotations", "()V", "j", "getFileName$annotations", "Lcom/sumsub/sentry/SentryItemType;", "n", "()Lcom/sumsub/sentry/SentryItemType;", "getType$annotations", "f", "getAttachmentType$annotations", "I", "l", "()I", "getLength$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/SentryItemType;Ljava/lang/String;I)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sentry/SentryItemType;Ljava/lang/String;ILkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class y {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30526a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30527b;

    /* renamed from: c  reason: collision with root package name */
    public final SentryItemType f30528c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30529d;

    /* renamed from: e  reason: collision with root package name */
    public final int f30530e;

    public static final class a implements d0<y> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30531a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30532b;

        static {
            a aVar = new a();
            f30531a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryEnvelopeItemHeader", aVar, 5);
            pluginGeneratedSerialDescriptor.k(FirebaseAnalytics.Param.CONTENT_TYPE, true);
            pluginGeneratedSerialDescriptor.k("filename", true);
            pluginGeneratedSerialDescriptor.k("type", false);
            pluginGeneratedSerialDescriptor.k("attachment_type", true);
            pluginGeneratedSerialDescriptor.k("length", false);
            f30532b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.y deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 3
                r4 = 4
                r5 = 2
                r6 = 0
                r7 = 0
                r8 = 1
                if (r2 == 0) goto L_0x0033
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r7, r2, r6)
                java.lang.Object r8 = r1.j(r0, r8, r2, r6)
                com.sumsub.sentry.SentryItemType$a r9 = com.sumsub.sentry.SentryItemType.a.f30235a
                java.lang.Object r5 = r1.p(r0, r5, r9, r6)
                java.lang.Object r2 = r1.j(r0, r3, r2, r6)
                int r3 = r1.f(r0, r4)
                r4 = 31
                r9 = r3
                goto L_0x0086
            L_0x0033:
                r9 = r6
                r10 = r9
                r11 = r10
                r12 = r11
                r2 = r7
                r6 = r2
                r13 = r8
            L_0x003a:
                if (r13 == 0) goto L_0x0080
                int r14 = r1.w(r0)
                r15 = -1
                if (r14 == r15) goto L_0x007e
                if (r14 == 0) goto L_0x0075
                if (r14 == r8) goto L_0x006c
                if (r14 == r5) goto L_0x0063
                if (r14 == r3) goto L_0x005a
                if (r14 != r4) goto L_0x0054
                int r2 = r1.f(r0, r4)
                r6 = r6 | 16
                goto L_0x003a
            L_0x0054:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r14)
                throw r0
            L_0x005a:
                kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r12 = r1.j(r0, r3, r14, r12)
                r6 = r6 | 8
                goto L_0x003a
            L_0x0063:
                com.sumsub.sentry.SentryItemType$a r14 = com.sumsub.sentry.SentryItemType.a.f30235a
                java.lang.Object r11 = r1.p(r0, r5, r14, r11)
                r6 = r6 | 4
                goto L_0x003a
            L_0x006c:
                kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r8, r14, r10)
                r6 = r6 | 2
                goto L_0x003a
            L_0x0075:
                kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r7, r14, r9)
                r6 = r6 | 1
                goto L_0x003a
            L_0x007e:
                r13 = r7
                goto L_0x003a
            L_0x0080:
                r4 = r6
                r7 = r9
                r8 = r10
                r5 = r11
                r9 = r2
                r2 = r12
            L_0x0086:
                r1.c(r0)
                com.sumsub.sentry.y r0 = new com.sumsub.sentry.y
                r1 = r7
                java.lang.String r1 = (java.lang.String) r1
                r6 = r8
                java.lang.String r6 = (java.lang.String) r6
                r7 = r5
                com.sumsub.sentry.SentryItemType r7 = (com.sumsub.sentry.SentryItemType) r7
                r8 = r2
                java.lang.String r8 = (java.lang.String) r8
                r10 = 0
                r3 = r0
                r5 = r1
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (com.sumsub.sentry.SentryItemType) r7, (java.lang.String) r8, (int) r9, (kotlinx.serialization.internal.q1) r10)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.y.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.y");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), SentryItemType.a.f30235a, h10.a.u(v1Var), m0.f57742a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30532b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, y yVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            y.a(yVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<y> serializer() {
            return a.f30531a;
        }

        public b() {
        }
    }

    public /* synthetic */ y(int i11, String str, String str2, SentryItemType sentryItemType, String str3, int i12, q1 q1Var) {
        if (20 != (i11 & 20)) {
            h1.a(i11, 20, a.f30531a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30526a = null;
        } else {
            this.f30526a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30527b = null;
        } else {
            this.f30527b = str2;
        }
        this.f30528c = sentryItemType;
        if ((i11 & 8) == 0) {
            this.f30529d = null;
        } else {
            this.f30529d = str3;
        }
        this.f30530e = i12;
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o() {
    }

    public final String a() {
        return this.f30526a;
    }

    public final String b() {
        return this.f30527b;
    }

    public final SentryItemType c() {
        return this.f30528c;
    }

    public final String d() {
        return this.f30529d;
    }

    public final int e() {
        return this.f30530e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return x.b(this.f30526a, yVar.f30526a) && x.b(this.f30527b, yVar.f30527b) && this.f30528c == yVar.f30528c && x.b(this.f30529d, yVar.f30529d) && this.f30530e == yVar.f30530e;
    }

    public final String f() {
        return this.f30529d;
    }

    public final String h() {
        return this.f30526a;
    }

    public int hashCode() {
        String str = this.f30526a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f30527b;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f30528c.hashCode()) * 31;
        String str3 = this.f30529d;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.f30530e;
    }

    public final String j() {
        return this.f30527b;
    }

    public final int l() {
        return this.f30530e;
    }

    public final SentryItemType n() {
        return this.f30528c;
    }

    public String toString() {
        return "SentryEnvelopeItemHeader(contentType=" + this.f30526a + ", fileName=" + this.f30527b + ", type=" + this.f30528c + ", attachmentType=" + this.f30529d + ", length=" + this.f30530e + ')';
    }

    public y(String str, String str2, SentryItemType sentryItemType, String str3, int i11) {
        this.f30526a = str;
        this.f30527b = str2;
        this.f30528c = sentryItemType;
        this.f30529d = str3;
        this.f30530e = i11;
    }

    public final y a(String str, String str2, SentryItemType sentryItemType, String str3, int i11) {
        return new y(str, str2, sentryItemType, str3, i11);
    }

    public static /* synthetic */ y a(y yVar, String str, String str2, SentryItemType sentryItemType, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = yVar.f30526a;
        }
        if ((i12 & 2) != 0) {
            str2 = yVar.f30527b;
        }
        String str4 = str2;
        if ((i12 & 4) != 0) {
            sentryItemType = yVar.f30528c;
        }
        SentryItemType sentryItemType2 = sentryItemType;
        if ((i12 & 8) != 0) {
            str3 = yVar.f30529d;
        }
        String str5 = str3;
        if ((i12 & 16) != 0) {
            i11 = yVar.f30530e;
        }
        return yVar.a(str, str4, sentryItemType2, str5, i11);
    }

    public static final void a(y yVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || yVar.f30526a != null) {
            bVar.y(fVar, 0, v1.f57779a, yVar.f30526a);
        }
        if (bVar.q(fVar, 1) || yVar.f30527b != null) {
            bVar.y(fVar, 1, v1.f57779a, yVar.f30527b);
        }
        bVar.F(fVar, 2, SentryItemType.a.f30235a, yVar.f30528c);
        if (bVar.q(fVar, 3) || yVar.f30529d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, v1.f57779a, yVar.f30529d);
        }
        bVar.n(fVar, 4, yVar.f30530e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(String str, String str2, SentryItemType sentryItemType, String str3, int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, sentryItemType, (i12 & 8) != 0 ? null : str3, i11);
    }
}
