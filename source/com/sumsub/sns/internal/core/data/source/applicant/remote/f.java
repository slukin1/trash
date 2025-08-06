package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0002\b\u001aB\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u001e\u0010\u001fB-\b\u0017\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001e\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eHÖ\u0001R&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/f;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/n;", "queue", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/util/List;", "b", "()Ljava/util/List;", "getQueue$annotations", "()V", "<init>", "(Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@kotlinx.serialization.f
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f33143a;

    public static final class a implements d0<f> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33144a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33145b;

        static {
            a aVar = new a();
            f33144a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.AvailableLanguages", aVar, 1);
            pluginGeneratedSerialDescriptor.k("queue", false);
            f33145b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public f deserialize(kotlinx.serialization.encoding.c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.p(descriptor, 0, new e(n.a.f33191a), null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.p(descriptor, 0, new e(n.a.f33191a), obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new f(i11, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{new e(n.a.f33191a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33145b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, f fVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f.a(fVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f> serializer() {
            return a.f33144a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<f> {
        /* renamed from: a */
        public final f createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList.add(n.CREATOR.createFromParcel(parcel));
            }
            return new f(arrayList);
        }

        /* renamed from: a */
        public final f[] newArray(int i11) {
            return new f[i11];
        }
    }

    public /* synthetic */ f(int i11, List list, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, a.f33144a.getDescriptor());
        }
        this.f33143a = list;
    }

    public static /* synthetic */ void c() {
    }

    public final List<n> a() {
        return this.f33143a;
    }

    public final List<n> b() {
        return this.f33143a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && x.b(this.f33143a, ((f) obj).f33143a);
    }

    public int hashCode() {
        return this.f33143a.hashCode();
    }

    public String toString() {
        return "AvailableLanguages(queue=" + this.f33143a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        List<n> list = this.f33143a;
        parcel.writeInt(list.size());
        for (n writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    public f(List<n> list) {
        this.f33143a = list;
    }

    public final f a(List<n> list) {
        return new f(list);
    }

    public static /* synthetic */ f a(f fVar, List<n> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = fVar.f33143a;
        }
        return fVar.a(list);
    }

    public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
        bVar.F(fVar2, 0, new e(n.a.f33191a), fVar.f33143a);
    }
}
