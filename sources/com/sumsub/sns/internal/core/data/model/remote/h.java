package com.sumsub.sns.internal.core.data.model.remote;

import com.facebook.GraphRequest;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType;
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

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 /2\u00020\u0001:\u0002\b\nB=\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b)\u0010*BQ\b\u0017\u0012\u0006\u0010+\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0001\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b)\u0010.J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J?\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\t\u0010\u0014\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u001a\u0012\u0004\b \u0010\u001e\u001a\u0004\b\u001f\u0010\u001cR\"\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010!\u0012\u0004\b$\u0010\u001e\u001a\u0004\b\"\u0010#R(\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010%\u0012\u0004\b(\u0010\u001e\u001a\u0004\b&\u0010'¨\u00060"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/h;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "c", "", "Lcom/sumsub/sns/internal/core/data/model/h$d;", "d", "sourceId", "docType", "confirmationType", "fields", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "getSourceId$annotations", "()V", "g", "getDocType$annotations", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "e", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "getConfirmationType$annotations", "Ljava/util/List;", "i", "()Ljava/util/List;", "getFields$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class h {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32742a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32743b;

    /* renamed from: c  reason: collision with root package name */
    public final ConfirmationType f32744c;

    /* renamed from: d  reason: collision with root package name */
    public final List<h.d> f32745d;

    public static final class a implements d0<h> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32746a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32747b;

        static {
            a aVar = new a();
            f32746a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteApplicantDataSource", aVar, 4);
            pluginGeneratedSerialDescriptor.k("sourceId", true);
            pluginGeneratedSerialDescriptor.k("docType", true);
            pluginGeneratedSerialDescriptor.k("confirmationType", true);
            pluginGeneratedSerialDescriptor.k(GraphRequest.FIELDS_PARAM, true);
            f32747b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.h deserialize(kotlinx.serialization.encoding.c r15) {
            /*
                r14 = this;
                kotlinx.serialization.descriptors.f r0 = r14.getDescriptor()
                kotlinx.serialization.encoding.a r15 = r15.b(r0)
                boolean r1 = r15.k()
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L_0x0034
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r5 = r15.j(r0, r5, r1, r4)
                java.lang.Object r1 = r15.j(r0, r6, r1, r4)
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType$a r6 = com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType.a.f33043a
                java.lang.Object r3 = r15.j(r0, r3, r6, r4)
                kotlinx.serialization.internal.e r6 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.model.h$d$a r7 = com.sumsub.sns.internal.core.data.model.h.d.a.f32626a
                r6.<init>(r7)
                java.lang.Object r2 = r15.j(r0, r2, r6, r4)
                r4 = 15
                r13 = r5
                r5 = r4
                r4 = r13
                goto L_0x0081
            L_0x0034:
                r1 = r4
                r7 = r1
                r8 = r7
                r9 = r8
                r4 = r5
                r10 = r6
            L_0x003a:
                if (r10 == 0) goto L_0x007c
                int r11 = r15.w(r0)
                r12 = -1
                if (r11 == r12) goto L_0x007a
                if (r11 == 0) goto L_0x0071
                if (r11 == r6) goto L_0x0068
                if (r11 == r3) goto L_0x005f
                if (r11 != r2) goto L_0x0059
                kotlinx.serialization.internal.e r11 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.model.h$d$a r12 = com.sumsub.sns.internal.core.data.model.h.d.a.f32626a
                r11.<init>(r12)
                java.lang.Object r9 = r15.j(r0, r2, r11, r9)
                r4 = r4 | 8
                goto L_0x003a
            L_0x0059:
                kotlinx.serialization.UnknownFieldException r15 = new kotlinx.serialization.UnknownFieldException
                r15.<init>((int) r11)
                throw r15
            L_0x005f:
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType$a r11 = com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType.a.f33043a
                java.lang.Object r8 = r15.j(r0, r3, r11, r8)
                r4 = r4 | 4
                goto L_0x003a
            L_0x0068:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r15.j(r0, r6, r11, r7)
                r4 = r4 | 2
                goto L_0x003a
            L_0x0071:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r15.j(r0, r5, r11, r1)
                r4 = r4 | 1
                goto L_0x003a
            L_0x007a:
                r10 = r5
                goto L_0x003a
            L_0x007c:
                r5 = r4
                r3 = r8
                r2 = r9
                r4 = r1
                r1 = r7
            L_0x0081:
                r15.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.h r15 = new com.sumsub.sns.internal.core.data.model.remote.h
                r6 = r4
                java.lang.String r6 = (java.lang.String) r6
                r7 = r1
                java.lang.String r7 = (java.lang.String) r7
                r8 = r3
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType r8 = (com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType) r8
                r9 = r2
                java.util.List r9 = (java.util.List) r9
                r10 = 0
                r4 = r15
                r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType) r8, (java.util.List) r9, (kotlinx.serialization.internal.q1) r10)
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.h.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.h");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(ConfirmationType.a.f33043a), h10.a.u(new e(h.d.a.f32626a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32747b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, h hVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            h.a(hVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<h> serializer() {
            return a.f32746a;
        }

        public b() {
        }
    }

    public h() {
        this((String) null, (String) null, (ConfirmationType) null, (List) null, 15, (r) null);
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
        return this.f32742a;
    }

    public final String b() {
        return this.f32743b;
    }

    public final ConfirmationType c() {
        return this.f32744c;
    }

    public final List<h.d> d() {
        return this.f32745d;
    }

    public final ConfirmationType e() {
        return this.f32744c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return x.b(this.f32742a, hVar.f32742a) && x.b(this.f32743b, hVar.f32743b) && this.f32744c == hVar.f32744c && x.b(this.f32745d, hVar.f32745d);
    }

    public final String g() {
        return this.f32743b;
    }

    public int hashCode() {
        String str = this.f32742a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32743b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ConfirmationType confirmationType = this.f32744c;
        int hashCode3 = (hashCode2 + (confirmationType == null ? 0 : confirmationType.hashCode())) * 31;
        List<h.d> list = this.f32745d;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode3 + i11;
    }

    public final List<h.d> i() {
        return this.f32745d;
    }

    public final String k() {
        return this.f32742a;
    }

    public String toString() {
        return "RemoteApplicantDataSource(sourceId=" + this.f32742a + ", docType=" + this.f32743b + ", confirmationType=" + this.f32744c + ", fields=" + this.f32745d + ')';
    }

    public /* synthetic */ h(int i11, String str, String str2, ConfirmationType confirmationType, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32746a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32742a = null;
        } else {
            this.f32742a = str;
        }
        if ((i11 & 2) == 0) {
            this.f32743b = null;
        } else {
            this.f32743b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f32744c = null;
        } else {
            this.f32744c = confirmationType;
        }
        if ((i11 & 8) == 0) {
            this.f32745d = null;
        } else {
            this.f32745d = list;
        }
    }

    public final h a(String str, String str2, ConfirmationType confirmationType, List<h.d> list) {
        return new h(str, str2, confirmationType, list);
    }

    public h(String str, String str2, ConfirmationType confirmationType, List<h.d> list) {
        this.f32742a = str;
        this.f32743b = str2;
        this.f32744c = confirmationType;
        this.f32745d = list;
    }

    public static /* synthetic */ h a(h hVar, String str, String str2, ConfirmationType confirmationType, List<h.d> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = hVar.f32742a;
        }
        if ((i11 & 2) != 0) {
            str2 = hVar.f32743b;
        }
        if ((i11 & 4) != 0) {
            confirmationType = hVar.f32744c;
        }
        if ((i11 & 8) != 0) {
            list = hVar.f32745d;
        }
        return hVar.a(str, str2, confirmationType, list);
    }

    public static final void a(h hVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || hVar.f32742a != null) {
            bVar.y(fVar, 0, v1.f57779a, hVar.f32742a);
        }
        if (bVar.q(fVar, 1) || hVar.f32743b != null) {
            bVar.y(fVar, 1, v1.f57779a, hVar.f32743b);
        }
        if (bVar.q(fVar, 2) || hVar.f32744c != null) {
            bVar.y(fVar, 2, ConfirmationType.a.f33043a, hVar.f32744c);
        }
        if (bVar.q(fVar, 3) || hVar.f32745d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, new e(h.d.a.f32626a), hVar.f32745d);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(String str, String str2, ConfirmationType confirmationType, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : confirmationType, (i11 & 8) != 0 ? null : list);
    }
}
