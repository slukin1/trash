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

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\b\u0018B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dB'\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001c\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0012\u001a\u00020\fHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fHÖ\u0001R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "name", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getName$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33169a;

    public static final class a implements d0<i0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33170a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33171b;

        static {
            a aVar = new a();
            f33170a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.VideoIdentOptions", aVar, 1);
            pluginGeneratedSerialDescriptor.k("name", true);
            f33171b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public i0 deserialize(kotlinx.serialization.encoding.c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, v1.f57779a, null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, v1.f57779a, obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new i0(i11, (String) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33171b;
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
            return a.f33170a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<i0> {
        /* renamed from: a */
        public final i0 createFromParcel(Parcel parcel) {
            return new i0(parcel.readString());
        }

        /* renamed from: a */
        public final i0[] newArray(int i11) {
            return new i0[i11];
        }
    }

    public i0() {
        this((String) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final String a() {
        return this.f33169a;
    }

    public final String b() {
        return this.f33169a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i0) && x.b(this.f33169a, ((i0) obj).f33169a);
    }

    public int hashCode() {
        String str = this.f33169a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "VideoIdentOptions(name=" + this.f33169a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33169a);
    }

    public /* synthetic */ i0(int i11, String str, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33170a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33169a = null;
        } else {
            this.f33169a = str;
        }
    }

    public final i0 a(String str) {
        return new i0(str);
    }

    public i0(String str) {
        this.f33169a = str;
    }

    public static /* synthetic */ i0 a(i0 i0Var, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = i0Var.f33169a;
        }
        return i0Var.a(str);
    }

    public static final void a(i0 i0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || i0Var.f33169a != null) {
            bVar.y(fVar, 0, v1.f57779a, i0Var.f33169a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
