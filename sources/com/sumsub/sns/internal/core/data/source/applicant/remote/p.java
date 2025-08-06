package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0002\b\nB\u001f\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!B3\b\u0017\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b \u0010%J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u0012\u0004\b\u001f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001b¨\u0006'"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/p;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "url", "redirectUrl", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "getUrl$annotations", "()V", "c", "getRedirectUrl$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33198a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33199b;

    public static final class a implements d0<p> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33200a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33201b;

        static {
            a aVar = new a();
            f33200a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.OAuthConfirmation", aVar, 2);
            pluginGeneratedSerialDescriptor.k("url", true);
            pluginGeneratedSerialDescriptor.k("redirectUrl", true);
            f33201b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public p deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.j(descriptor, 1, v1Var, null);
                i11 = 3;
            } else {
                obj2 = null;
                Object obj3 = null;
                int i12 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new p(i11, (String) obj, (String) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33201b;
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
            return a.f33200a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<p> {
        /* renamed from: a */
        public final p createFromParcel(Parcel parcel) {
            return new p(parcel.readString(), parcel.readString());
        }

        /* renamed from: a */
        public final p[] newArray(int i11) {
            return new p[i11];
        }
    }

    public p() {
        this((String) null, (String) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f33198a;
    }

    public final String b() {
        return this.f33199b;
    }

    public final String c() {
        return this.f33199b;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f33198a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return x.b(this.f33198a, pVar.f33198a) && x.b(this.f33199b, pVar.f33199b);
    }

    public int hashCode() {
        String str = this.f33198a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33199b;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "OAuthConfirmation(url=" + this.f33198a + ", redirectUrl=" + this.f33199b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33198a);
        parcel.writeString(this.f33199b);
    }

    public /* synthetic */ p(int i11, String str, String str2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33200a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33198a = null;
        } else {
            this.f33198a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33199b = null;
        } else {
            this.f33199b = str2;
        }
    }

    public final p a(String str, String str2) {
        return new p(str, str2);
    }

    public p(String str, String str2) {
        this.f33198a = str;
        this.f33199b = str2;
    }

    public static /* synthetic */ p a(p pVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pVar.f33198a;
        }
        if ((i11 & 2) != 0) {
            str2 = pVar.f33199b;
        }
        return pVar.a(str, str2);
    }

    public static final void a(p pVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || pVar.f33198a != null) {
            bVar.y(fVar, 0, v1.f57779a, pVar.f33198a);
        }
        if (bVar.q(fVar, 1) || pVar.f33199b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, v1.f57779a, pVar.f33199b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
