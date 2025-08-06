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
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 #2\u00020\u0001:\u0002\b\u001aB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001d\u0010\u001eB'\b\u0017\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001d\u0010\"J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\b\u0010\nJ\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0014\u001a\u00020\tHÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tHÖ\u0001R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\n¨\u0006$"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "()Ljava/lang/Integer;", "codeLength", "(Ljava/lang/Integer;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;", "", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/Integer;", "b", "getCodeLength$annotations", "()V", "<init>", "(Ljava/lang/Integer;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Integer;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class s implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Integer f33209a;

    public static final class a implements d0<s> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33210a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33211b;

        static {
            a aVar = new a();
            f33210a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.OtpConfirmation", aVar, 1);
            pluginGeneratedSerialDescriptor.k("codeLength", true);
            f33211b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public s deserialize(kotlinx.serialization.encoding.c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, m0.f57742a, null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, m0.f57742a, obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new s(i11, (Integer) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(m0.f57742a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33211b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, s sVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            s.a(sVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<s> serializer() {
            return a.f33210a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<s> {
        /* renamed from: a */
        public final s createFromParcel(Parcel parcel) {
            return new s(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: a */
        public final s[] newArray(int i11) {
            return new s[i11];
        }
    }

    public s() {
        this((Integer) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final Integer a() {
        return this.f33209a;
    }

    public final Integer b() {
        return this.f33209a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && x.b(this.f33209a, ((s) obj).f33209a);
    }

    public int hashCode() {
        Integer num = this.f33209a;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "OtpConfirmation(codeLength=" + this.f33209a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int i12;
        Integer num = this.f33209a;
        if (num == null) {
            i12 = 0;
        } else {
            parcel.writeInt(1);
            i12 = num.intValue();
        }
        parcel.writeInt(i12);
    }

    public /* synthetic */ s(int i11, Integer num, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33210a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33209a = null;
        } else {
            this.f33209a = num;
        }
    }

    public final s a(Integer num) {
        return new s(num);
    }

    public s(Integer num) {
        this.f33209a = num;
    }

    public static /* synthetic */ s a(s sVar, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = sVar.f33209a;
        }
        return sVar.a(num);
    }

    public static final void a(s sVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || sVar.f33209a != null) {
            bVar.y(fVar, 0, m0.f57742a, sVar.f33209a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Integer num, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : num);
    }
}
