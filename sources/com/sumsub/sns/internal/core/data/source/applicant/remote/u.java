package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.x;
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

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0002\b\fB)\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b%\u0010&B?\b\u0017\u0012\u0006\u0010'\u001a\u00020\u0010\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0001\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b%\u0010*J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J+\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010HÖ\u0001R\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR4\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\f\u0010 \u0012\u0004\b$\u0010\u001f\u001a\u0004\b!\u0010\"\"\u0004\b\b\u0010#¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/u;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/x;", "b", "id", "sections", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getId$annotations", "()V", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "getSections$annotations", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class u implements Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33215a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, x> f33216b;

    public static final class a implements d0<u> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33217a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33218b;

        static {
            a aVar = new a();
            f33217a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.Questionnaire", aVar, 2);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("sections", true);
            f33218b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public u deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.p(descriptor, 1, new r0(v1Var, x.a.f33241a), null);
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
                        obj2 = b11.p(descriptor, 1, new r0(v1.f57779a, x.a.f33241a), obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new u(i11, (String) obj, (Map) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), new r0(v1Var, x.a.f33241a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33218b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, u uVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            u.a(uVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<u> serializer() {
            return a.f33217a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<u> {
        /* renamed from: a */
        public final u createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                linkedHashMap.put(parcel.readString(), x.CREATOR.createFromParcel(parcel));
            }
            return new u(readString, linkedHashMap);
        }

        /* renamed from: a */
        public final u[] newArray(int i11) {
            return new u[i11];
        }
    }

    public u() {
        this((String) null, (Map) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f33215a;
    }

    public final Map<String, x> b() {
        return this.f33216b;
    }

    public final String c() {
        return this.f33215a;
    }

    public int describeContents() {
        return 0;
    }

    public final Map<String, x> e() {
        return this.f33216b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.x.b(this.f33215a, uVar.f33215a) && kotlin.jvm.internal.x.b(this.f33216b, uVar.f33216b);
    }

    public int hashCode() {
        String str = this.f33215a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.f33216b.hashCode();
    }

    public String toString() {
        return "Questionnaire(id=" + this.f33215a + ", sections=" + this.f33216b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33215a);
        Map<String, x> map = this.f33216b;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            ((x) next.getValue()).writeToParcel(parcel, i11);
        }
    }

    public /* synthetic */ u(int i11, String str, Map map, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33217a.getDescriptor());
        }
        this.f33215a = (i11 & 1) == 0 ? null : str;
        if ((i11 & 2) == 0) {
            this.f33216b = new LinkedHashMap();
        } else {
            this.f33216b = map;
        }
    }

    public final u a(String str, Map<String, x> map) {
        return new u(str, map);
    }

    public static /* synthetic */ u a(u uVar, String str, Map<String, x> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = uVar.f33215a;
        }
        if ((i11 & 2) != 0) {
            map = uVar.f33216b;
        }
        return uVar.a(str, map);
    }

    public static final void a(u uVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || uVar.f33215a != null) {
            bVar.y(fVar, 0, v1.f57779a, uVar.f33215a);
        }
        bVar.F(fVar, 1, new r0(v1.f57779a, x.a.f33241a), uVar.f33216b);
    }

    public u(String str, Map<String, x> map) {
        this.f33215a = str;
        this.f33216b = map;
    }

    public final void a(Map<String, x> map) {
        this.f33216b = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(String str, Map map, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? new LinkedHashMap() : map);
    }
}
