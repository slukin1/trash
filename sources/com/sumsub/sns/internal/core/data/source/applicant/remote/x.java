package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sns.internal.core.data.source.applicant.remote.v;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0002\b\u001aB\u001d\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u001e\u0010\u001fB3\b\u0017\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001e\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0001J\t\u0010\r\u001a\u00020\nHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eHÖ\u0001R,\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/x;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/v;", "items", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "getItems$annotations", "()V", "<init>", "(Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class x implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, v> f33240a;

    public static final class a implements d0<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33241a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33242b;

        static {
            a aVar = new a();
            f33241a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.QuestionnaireSection", aVar, 1);
            pluginGeneratedSerialDescriptor.k(FirebaseAnalytics.Param.ITEMS, true);
            f33242b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public x deserialize(kotlinx.serialization.encoding.c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.p(descriptor, 0, new r0(v1.f57779a, v.a.f33228a), null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.p(descriptor, 0, new r0(v1.f57779a, v.a.f33228a), obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new x(i11, (Map) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{new r0(v1.f57779a, v.a.f33228a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33242b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, x xVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            x.a(xVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<x> serializer() {
            return a.f33241a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<x> {
        /* renamed from: a */
        public final x createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                linkedHashMap.put(parcel.readString(), v.CREATOR.createFromParcel(parcel));
            }
            return new x(linkedHashMap);
        }

        /* renamed from: a */
        public final x[] newArray(int i11) {
            return new x[i11];
        }
    }

    public x() {
        this((Map) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final Map<String, v> a() {
        return this.f33240a;
    }

    public final Map<String, v> b() {
        return this.f33240a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && kotlin.jvm.internal.x.b(this.f33240a, ((x) obj).f33240a);
    }

    public int hashCode() {
        return this.f33240a.hashCode();
    }

    public String toString() {
        return "QuestionnaireSection(items=" + this.f33240a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Map<String, v> map = this.f33240a;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            ((v) next.getValue()).writeToParcel(parcel, i11);
        }
    }

    public /* synthetic */ x(int i11, Map map, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33241a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33240a = new LinkedHashMap();
        } else {
            this.f33240a = map;
        }
    }

    public final x a(Map<String, v> map) {
        return new x(map);
    }

    public static /* synthetic */ x a(x xVar, Map<String, v> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = xVar.f33240a;
        }
        return xVar.a(map);
    }

    public static final void a(x xVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.F(fVar, 0, new r0(v1.f57779a, v.a.f33228a), xVar.f33240a);
    }

    public x(Map<String, v> map) {
        this.f33240a = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(Map map, int i11, r rVar) {
        this((i11 & 1) != 0 ? new LinkedHashMap() : map);
    }
}
