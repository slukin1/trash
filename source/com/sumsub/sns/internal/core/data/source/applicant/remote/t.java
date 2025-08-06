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

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\b\u0018B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dB'\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001c\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0012\u001a\u00020\fHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fHÖ\u0001R \u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/t;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "code", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getCode$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33212a;

    public static final class a implements d0<t> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33213a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33214b;

        static {
            a aVar = new a();
            f33213a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.OtpConfirmationData", aVar, 1);
            pluginGeneratedSerialDescriptor.k("code", false);
            f33214b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public t deserialize(kotlinx.serialization.encoding.c cVar) {
            String str;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                str = b11.i(descriptor, 0);
            } else {
                str = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        str = b11.i(descriptor, 0);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new t(i11, str, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33214b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, t tVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            t.a(tVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<t> serializer() {
            return a.f33213a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<t> {
        /* renamed from: a */
        public final t createFromParcel(Parcel parcel) {
            return new t(parcel.readString());
        }

        /* renamed from: a */
        public final t[] newArray(int i11) {
            return new t[i11];
        }
    }

    public /* synthetic */ t(int i11, String str, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, a.f33213a.getDescriptor());
        }
        this.f33212a = str;
    }

    public static /* synthetic */ void c() {
    }

    public final String a() {
        return this.f33212a;
    }

    public final String b() {
        return this.f33212a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && x.b(this.f33212a, ((t) obj).f33212a);
    }

    public int hashCode() {
        return this.f33212a.hashCode();
    }

    public String toString() {
        return "OtpConfirmationData(code=" + this.f33212a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33212a);
    }

    public t(String str) {
        this.f33212a = str;
    }

    public final t a(String str) {
        return new t(str);
    }

    public static /* synthetic */ t a(t tVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tVar.f33212a;
        }
        return tVar.a(str);
    }

    public static final void a(t tVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, tVar.f33212a);
    }
}
