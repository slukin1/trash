package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 #2\u00020\u0001:\u0002\b\u0019B\u0019\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001bB-\b\u0017\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u001b\u0010\b\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\t\u0010\f\u001a\u00020\nHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0013\u001a\u00020\rHÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\rHÖ\u0001R0\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\u0018\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0019\u0010\u001b¨\u0006$"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/g0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "value", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/util/List;", "b", "()Ljava/util/List;", "(Ljava/util/List;)V", "getValue$annotations", "()V", "<init>", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class g0 implements Parcelable {
    public static final Parcelable.Creator<g0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public List<String> f33155a;

    public static final class a implements d0<g0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33156a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33157b;

        static {
            a aVar = new a();
            f33156a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.ValuesItem", aVar, 1);
            pluginGeneratedSerialDescriptor.k("values", true);
            f33157b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public g0 deserialize(kotlinx.serialization.encoding.c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, new e(v1.f57779a), null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, new e(v1.f57779a), obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new g0(i11, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(new e(v1.f57779a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33157b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, g0 g0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            g0.a(g0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<g0> serializer() {
            return a.f33156a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<g0> {
        /* renamed from: a */
        public final g0 createFromParcel(Parcel parcel) {
            return new g0(parcel.createStringArrayList());
        }

        /* renamed from: a */
        public final g0[] newArray(int i11) {
            return new g0[i11];
        }
    }

    public g0() {
        this((List) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final List<String> a() {
        return this.f33155a;
    }

    public final List<String> b() {
        return this.f33155a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g0) && x.b(this.f33155a, ((g0) obj).f33155a);
    }

    public int hashCode() {
        List<String> list = this.f33155a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "ValuesItem(value=" + this.f33155a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.f33155a);
    }

    public /* synthetic */ g0(int i11, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33156a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33155a = CollectionsKt__CollectionsKt.k();
        } else {
            this.f33155a = list;
        }
    }

    public final g0 a(List<String> list) {
        return new g0(list);
    }

    public final void b(List<String> list) {
        this.f33155a = list;
    }

    public static /* synthetic */ g0 a(g0 g0Var, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = g0Var.f33155a;
        }
        return g0Var.a(list);
    }

    public static final void a(g0 g0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || !x.b(g0Var.f33155a, CollectionsKt__CollectionsKt.k())) {
            bVar.y(fVar, 0, new e(v1.f57779a), g0Var.f33155a);
        }
    }

    public g0(List<String> list) {
        this.f33155a = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
