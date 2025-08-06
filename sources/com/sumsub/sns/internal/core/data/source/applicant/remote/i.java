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

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 *2\u00020\u0001:\u0002\b\nB+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%B?\b\u0017\u0012\u0006\u0010&\u001a\u00020\u0010\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b$\u0010)J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010HÖ\u0001R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u0012\u0004\b!\u0010\u001f\u001a\u0004\b \u0010\u001dR\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u0012\u0004\b#\u0010\u001f\u001a\u0004\b\"\u0010\u001d¨\u0006+"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "mobileToken", "url", "hash", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "getMobileToken$annotations", "()V", "h", "getUrl$annotations", "d", "getHash$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33164a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33165b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33166c;

    public static final class a implements d0<i> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33167a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33168b;

        static {
            a aVar = new a();
            f33167a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.EidConfirmation", aVar, 3);
            pluginGeneratedSerialDescriptor.k("mobileToken", true);
            pluginGeneratedSerialDescriptor.k("url", true);
            pluginGeneratedSerialDescriptor.k("hash", true);
            f33168b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.i deserialize(kotlinx.serialization.encoding.c r12) {
            /*
                r11 = this;
                kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
                kotlinx.serialization.encoding.a r12 = r12.b(r0)
                boolean r1 = r12.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0023
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r4 = r12.j(r0, r4, r1, r2)
                java.lang.Object r5 = r12.j(r0, r5, r1, r2)
                java.lang.Object r1 = r12.j(r0, r3, r1, r2)
                r2 = 7
                r3 = r2
                goto L_0x005e
            L_0x0023:
                r1 = r2
                r6 = r1
                r7 = r6
                r2 = r4
                r8 = r5
            L_0x0028:
                if (r8 == 0) goto L_0x005a
                int r9 = r12.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0058
                if (r9 == 0) goto L_0x004f
                if (r9 == r5) goto L_0x0046
                if (r9 != r3) goto L_0x0040
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r12.j(r0, r3, r9, r7)
                r2 = r2 | 4
                goto L_0x0028
            L_0x0040:
                kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
                r12.<init>((int) r9)
                throw r12
            L_0x0046:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r12.j(r0, r5, r9, r6)
                r2 = r2 | 2
                goto L_0x0028
            L_0x004f:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r12.j(r0, r4, r9, r1)
                r2 = r2 | 1
                goto L_0x0028
            L_0x0058:
                r8 = r4
                goto L_0x0028
            L_0x005a:
                r4 = r1
                r3 = r2
                r5 = r6
                r1 = r7
            L_0x005e:
                r12.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.i r12 = new com.sumsub.sns.internal.core.data.source.applicant.remote.i
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r5 = (java.lang.String) r5
                r6 = r1
                java.lang.String r6 = (java.lang.String) r6
                r7 = 0
                r2 = r12
                r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (kotlinx.serialization.internal.q1) r7)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.i.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.i");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33168b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, i iVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            i.a(iVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<i> serializer() {
            return a.f33167a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<i> {
        /* renamed from: a */
        public final i createFromParcel(Parcel parcel) {
            return new i(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: a */
        public final i[] newArray(int i11) {
            return new i[i11];
        }
    }

    public i() {
        this((String) null, (String) null, (String) null, 7, (r) null);
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final String a() {
        return this.f33164a;
    }

    public final String b() {
        return this.f33165b;
    }

    public final String c() {
        return this.f33166c;
    }

    public final String d() {
        return this.f33166c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return x.b(this.f33164a, iVar.f33164a) && x.b(this.f33165b, iVar.f33165b) && x.b(this.f33166c, iVar.f33166c);
    }

    public final String f() {
        return this.f33164a;
    }

    public final String h() {
        return this.f33165b;
    }

    public int hashCode() {
        String str = this.f33164a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33165b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f33166c;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "EidConfirmation(mobileToken=" + this.f33164a + ", url=" + this.f33165b + ", hash=" + this.f33166c + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33164a);
        parcel.writeString(this.f33165b);
        parcel.writeString(this.f33166c);
    }

    public /* synthetic */ i(int i11, String str, String str2, String str3, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33167a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33164a = null;
        } else {
            this.f33164a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33165b = null;
        } else {
            this.f33165b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f33166c = null;
        } else {
            this.f33166c = str3;
        }
    }

    public final i a(String str, String str2, String str3) {
        return new i(str, str2, str3);
    }

    public i(String str, String str2, String str3) {
        this.f33164a = str;
        this.f33165b = str2;
        this.f33166c = str3;
    }

    public static /* synthetic */ i a(i iVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = iVar.f33164a;
        }
        if ((i11 & 2) != 0) {
            str2 = iVar.f33165b;
        }
        if ((i11 & 4) != 0) {
            str3 = iVar.f33166c;
        }
        return iVar.a(str, str2, str3);
    }

    public static final void a(i iVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || iVar.f33164a != null) {
            bVar.y(fVar, 0, v1.f57779a, iVar.f33164a);
        }
        if (bVar.q(fVar, 1) || iVar.f33165b != null) {
            bVar.y(fVar, 1, v1.f57779a, iVar.f33165b);
        }
        if (bVar.q(fVar, 2) || iVar.f33166c != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 2, v1.f57779a, iVar.f33166c);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, String str2, String str3, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
