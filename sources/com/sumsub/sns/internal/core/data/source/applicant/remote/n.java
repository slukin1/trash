package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 .2\u00020\u0001:\u0002\b\u000bB+\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b(\u0010)B?\b\u0017\u0012\u0006\u0010*\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b(\u0010-J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ4\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\b\u0010\u0011J\t\u0010\u0012\u001a\u00020\tHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0013HÖ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\"\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010#\u0012\u0004\b%\u0010\"\u001a\u0004\b$\u0010\fR\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010#\u0012\u0004\b'\u0010\"\u001a\u0004\b&\u0010\f¨\u0006/"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/n;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "b", "()Ljava/lang/Long;", "c", "language", "queuePlace", "waitTimeSec", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/n;", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "getLanguage$annotations", "()V", "Ljava/lang/Long;", "f", "getQueuePlace$annotations", "h", "getWaitTimeSec$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33188a;

    /* renamed from: b  reason: collision with root package name */
    public final Long f33189b;

    /* renamed from: c  reason: collision with root package name */
    public final Long f33190c;

    public static final class a implements d0<n> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33191a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33192b;

        static {
            a aVar = new a();
            f33191a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.LanguageInfo", aVar, 3);
            pluginGeneratedSerialDescriptor.k("lang", true);
            pluginGeneratedSerialDescriptor.k("queuePlace", true);
            pluginGeneratedSerialDescriptor.k("waitTimeSec", true);
            f33192b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.n deserialize(kotlinx.serialization.encoding.c r12) {
            /*
                r11 = this;
                kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
                kotlinx.serialization.encoding.a r12 = r12.b(r0)
                boolean r1 = r12.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0025
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r12.j(r0, r4, r1, r2)
                kotlinx.serialization.internal.x0 r4 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r5 = r12.j(r0, r5, r4, r2)
                java.lang.Object r2 = r12.j(r0, r3, r4, r2)
                r3 = 7
                r4 = r3
                goto L_0x005f
            L_0x0025:
                r1 = r2
                r6 = r1
                r7 = r4
                r8 = r5
            L_0x0029:
                if (r8 == 0) goto L_0x005b
                int r9 = r12.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0059
                if (r9 == 0) goto L_0x0050
                if (r9 == r5) goto L_0x0047
                if (r9 != r3) goto L_0x0041
                kotlinx.serialization.internal.x0 r9 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r6 = r12.j(r0, r3, r9, r6)
                r7 = r7 | 4
                goto L_0x0029
            L_0x0041:
                kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
                r12.<init>((int) r9)
                throw r12
            L_0x0047:
                kotlinx.serialization.internal.x0 r9 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r1 = r12.j(r0, r5, r9, r1)
                r7 = r7 | 2
                goto L_0x0029
            L_0x0050:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r2 = r12.j(r0, r4, r9, r2)
                r7 = r7 | 1
                goto L_0x0029
            L_0x0059:
                r8 = r4
                goto L_0x0029
            L_0x005b:
                r5 = r1
                r1 = r2
                r2 = r6
                r4 = r7
            L_0x005f:
                r12.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.n r12 = new com.sumsub.sns.internal.core.data.source.applicant.remote.n
                r0 = r1
                java.lang.String r0 = (java.lang.String) r0
                r6 = r5
                java.lang.Long r6 = (java.lang.Long) r6
                r7 = r2
                java.lang.Long r7 = (java.lang.Long) r7
                r8 = 0
                r3 = r12
                r5 = r0
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.Long) r6, (java.lang.Long) r7, (kotlinx.serialization.internal.q1) r8)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.n.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.n");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            x0 x0Var = x0.f57786a;
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a), h10.a.u(x0Var), h10.a.u(x0Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33192b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, n nVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            n.a(nVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<n> serializer() {
            return a.f33191a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<n> {
        /* renamed from: a */
        public final n createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            Long l11 = null;
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() != 0) {
                l11 = Long.valueOf(parcel.readLong());
            }
            return new n(readString, valueOf, l11);
        }

        /* renamed from: a */
        public final n[] newArray(int i11) {
            return new n[i11];
        }
    }

    public n() {
        this((String) null, (Long) null, (Long) null, 7, (r) null);
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final String a() {
        return this.f33188a;
    }

    public final Long b() {
        return this.f33189b;
    }

    public final Long c() {
        return this.f33190c;
    }

    public final String d() {
        return this.f33188a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return x.b(this.f33188a, nVar.f33188a) && x.b(this.f33189b, nVar.f33189b) && x.b(this.f33190c, nVar.f33190c);
    }

    public final Long f() {
        return this.f33189b;
    }

    public final Long h() {
        return this.f33190c;
    }

    public int hashCode() {
        String str = this.f33188a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l11 = this.f33189b;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.f33190c;
        if (l12 != null) {
            i11 = l12.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "LanguageInfo(language=" + this.f33188a + ", queuePlace=" + this.f33189b + ", waitTimeSec=" + this.f33190c + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33188a);
        Long l11 = this.f33189b;
        if (l11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l11.longValue());
        }
        Long l12 = this.f33190c;
        if (l12 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l12.longValue());
    }

    public /* synthetic */ n(int i11, String str, Long l11, Long l12, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33191a.getDescriptor());
        }
        this.f33188a = (i11 & 1) == 0 ? null : str;
        if ((i11 & 2) == 0) {
            this.f33189b = 0L;
        } else {
            this.f33189b = l11;
        }
        if ((i11 & 4) == 0) {
            this.f33190c = 0L;
        } else {
            this.f33190c = l12;
        }
    }

    public final n a(String str, Long l11, Long l12) {
        return new n(str, l11, l12);
    }

    public static /* synthetic */ n a(n nVar, String str, Long l11, Long l12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = nVar.f33188a;
        }
        if ((i11 & 2) != 0) {
            l11 = nVar.f33189b;
        }
        if ((i11 & 4) != 0) {
            l12 = nVar.f33190c;
        }
        return nVar.a(str, l11, l12);
    }

    public static final void a(n nVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        Long l11;
        Long l12;
        boolean z11 = false;
        if (bVar.q(fVar, 0) || nVar.f33188a != null) {
            bVar.y(fVar, 0, v1.f57779a, nVar.f33188a);
        }
        if (bVar.q(fVar, 1) || (l12 = nVar.f33189b) == null || l12.longValue() != 0) {
            bVar.y(fVar, 1, x0.f57786a, nVar.f33189b);
        }
        if (bVar.q(fVar, 2) || (l11 = nVar.f33190c) == null || l11.longValue() != 0) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 2, x0.f57786a, nVar.f33190c);
        }
    }

    public n(String str, Long l11, Long l12) {
        this.f33188a = str;
        this.f33189b = l11;
        this.f33190c = l12;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, Long l11, Long l12, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0L : l11, (i11 & 4) != 0 ? 0L : l12);
    }
}
