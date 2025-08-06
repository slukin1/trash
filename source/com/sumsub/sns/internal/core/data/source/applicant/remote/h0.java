package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.i0;
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

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 )2\u00020\u0001:\u0002\b\u000bB\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b#\u0010$B3\b\u0017\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b#\u0010(J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u000e\u001a\u00020\tHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0015\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fHÖ\u0001R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u0012\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/h0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i0;", "b", "token", "options", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "getToken$annotations", "()V", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i0;", "c", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i0;", "getOptions$annotations", "<init>", "(Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i0;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i0;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class h0 implements Parcelable {
    public static final Parcelable.Creator<h0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33160a;

    /* renamed from: b  reason: collision with root package name */
    public final i0 f33161b;

    public static final class a implements d0<h0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33162a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33163b;

        static {
            a aVar = new a();
            f33162a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.VideoIdentApplyResponse", aVar, 2);
            pluginGeneratedSerialDescriptor.k("token", true);
            pluginGeneratedSerialDescriptor.k("options", true);
            f33163b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public h0 deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                obj2 = b11.j(descriptor, 0, v1.f57779a, null);
                obj = b11.j(descriptor, 1, i0.a.f33170a, null);
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
                        obj2 = b11.j(descriptor, 0, v1.f57779a, obj2);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj3 = b11.j(descriptor, 1, i0.a.f33170a, obj3);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new h0(i11, (String) obj2, (i0) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a), h10.a.u(i0.a.f33170a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33163b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, h0 h0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            h0.a(h0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<h0> serializer() {
            return a.f33162a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<h0> {
        /* renamed from: a */
        public final h0 createFromParcel(Parcel parcel) {
            return new h0(parcel.readString(), parcel.readInt() == 0 ? null : i0.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: a */
        public final h0[] newArray(int i11) {
            return new h0[i11];
        }
    }

    public h0() {
        this((String) null, (i0) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f33160a;
    }

    public final i0 b() {
        return this.f33161b;
    }

    public final i0 c() {
        return this.f33161b;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f33160a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return x.b(this.f33160a, h0Var.f33160a) && x.b(this.f33161b, h0Var.f33161b);
    }

    public int hashCode() {
        String str = this.f33160a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        i0 i0Var = this.f33161b;
        if (i0Var != null) {
            i11 = i0Var.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "VideoIdentApplyResponse(token=" + this.f33160a + ", options=" + this.f33161b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33160a);
        i0 i0Var = this.f33161b;
        if (i0Var == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        i0Var.writeToParcel(parcel, i11);
    }

    public /* synthetic */ h0(int i11, String str, i0 i0Var, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33162a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33160a = null;
        } else {
            this.f33160a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33161b = null;
        } else {
            this.f33161b = i0Var;
        }
    }

    public final h0 a(String str, i0 i0Var) {
        return new h0(str, i0Var);
    }

    public h0(String str, i0 i0Var) {
        this.f33160a = str;
        this.f33161b = i0Var;
    }

    public static /* synthetic */ h0 a(h0 h0Var, String str, i0 i0Var, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = h0Var.f33160a;
        }
        if ((i11 & 2) != 0) {
            i0Var = h0Var.f33161b;
        }
        return h0Var.a(str, i0Var);
    }

    public static final void a(h0 h0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || h0Var.f33160a != null) {
            bVar.y(fVar, 0, v1.f57779a, h0Var.f33160a);
        }
        if (bVar.q(fVar, 1) || h0Var.f33161b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, i0.a.f33170a, h0Var.f33161b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(String str, i0 i0Var, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : i0Var);
    }
}
