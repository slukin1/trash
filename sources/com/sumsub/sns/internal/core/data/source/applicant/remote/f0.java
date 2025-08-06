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

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\b\u0018B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001d\u0010\u001aB'\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0012\u001a\u00020\fHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fHÖ\u0001R*\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\u0017\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0018\u0010\u001a¨\u0006#"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/f0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "value", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getValue$annotations", "()V", "<init>", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class f0 implements Parcelable {
    public static final Parcelable.Creator<f0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public String f33146a;

    public static final class a implements d0<f0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33147a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33148b;

        static {
            a aVar = new a();
            f33147a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.ValueItem", aVar, 1);
            pluginGeneratedSerialDescriptor.k("value", true);
            f33148b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public f0 deserialize(kotlinx.serialization.encoding.c cVar) {
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
            return new f0(i11, (String) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33148b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, f0 f0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f0.a(f0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f0> serializer() {
            return a.f33147a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<f0> {
        /* renamed from: a */
        public final f0 createFromParcel(Parcel parcel) {
            return new f0(parcel.readString());
        }

        /* renamed from: a */
        public final f0[] newArray(int i11) {
            return new f0[i11];
        }
    }

    public f0() {
        this((String) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final String a() {
        return this.f33146a;
    }

    public final String b() {
        return this.f33146a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && x.b(this.f33146a, ((f0) obj).f33146a);
    }

    public int hashCode() {
        String str = this.f33146a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ValueItem(value=" + this.f33146a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33146a);
    }

    public /* synthetic */ f0(int i11, String str, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33147a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33146a = "";
        } else {
            this.f33146a = str;
        }
    }

    public final f0 a(String str) {
        return new f0(str);
    }

    public final void b(String str) {
        this.f33146a = str;
    }

    public f0(String str) {
        this.f33146a = str;
    }

    public static /* synthetic */ f0 a(f0 f0Var, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = f0Var.f33146a;
        }
        return f0Var.a(str);
    }

    public static final void a(f0 f0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || !x.b(f0Var.f33146a, "")) {
            bVar.y(fVar, 0, v1.f57779a, f0Var.f33146a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? "" : str);
    }
}
