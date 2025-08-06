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

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 )2\u00020\u0001:\u0002\b\u000bB%\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n¢\u0006\u0004\b#\u0010$B9\b\u0017\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b#\u0010(J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\nHÆ\u0003J'\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\nHÆ\u0001J\t\u0010\u000e\u001a\u00020\tHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0015\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fHÖ\u0001R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u0012\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/v;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "b", "value", "values", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getValue$annotations", "()V", "Ljava/util/List;", "e", "()Ljava/util/List;", "getValues$annotations", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class v implements Parcelable {
    public static final Parcelable.Creator<v> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33226a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f33227b;

    public static final class a implements d0<v> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33228a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33229b;

        static {
            a aVar = new a();
            f33228a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.QuestionnaireItem", aVar, 2);
            pluginGeneratedSerialDescriptor.k("value", true);
            pluginGeneratedSerialDescriptor.k("values", true);
            f33229b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public v deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.j(descriptor, 1, new e(v1Var), null);
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
                        obj2 = b11.j(descriptor, 1, new e(v1.f57779a), obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new v(i11, (String) obj, (List) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(new e(v1Var))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33229b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, v vVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            v.a(vVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<v> serializer() {
            return a.f33228a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<v> {
        /* renamed from: a */
        public final v createFromParcel(Parcel parcel) {
            return new v(parcel.readString(), parcel.createStringArrayList());
        }

        /* renamed from: a */
        public final v[] newArray(int i11) {
            return new v[i11];
        }
    }

    public v() {
        this((String) null, (List) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f33226a;
    }

    public final List<String> b() {
        return this.f33227b;
    }

    public final String c() {
        return this.f33226a;
    }

    public int describeContents() {
        return 0;
    }

    public final List<String> e() {
        return this.f33227b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return x.b(this.f33226a, vVar.f33226a) && x.b(this.f33227b, vVar.f33227b);
    }

    public int hashCode() {
        String str = this.f33226a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.f33227b;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "QuestionnaireItem(value=" + this.f33226a + ", values=" + this.f33227b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33226a);
        parcel.writeStringList(this.f33227b);
    }

    public /* synthetic */ v(int i11, String str, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33228a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33226a = null;
        } else {
            this.f33226a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33227b = null;
        } else {
            this.f33227b = list;
        }
    }

    public final v a(String str, List<String> list) {
        return new v(str, list);
    }

    public v(String str, List<String> list) {
        this.f33226a = str;
        this.f33227b = list;
    }

    public static /* synthetic */ v a(v vVar, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vVar.f33226a;
        }
        if ((i11 & 2) != 0) {
            list = vVar.f33227b;
        }
        return vVar.a(str, list);
    }

    public static final void a(v vVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || vVar.f33226a != null) {
            bVar.y(fVar, 0, v1.f57779a, vVar.f33226a);
        }
        if (bVar.q(fVar, 1) || vVar.f33227b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, new e(v1.f57779a), vVar.f33227b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(String str, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : list);
    }
}
