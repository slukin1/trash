package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import java.util.ArrayList;
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

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0002\b\rB+\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b%\u0010&B?\b\u0017\u0012\u0006\u0010'\u001a\u00020\u0011\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b%\u0010*J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0011\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J-\u0010\b\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\tHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0011HÖ\u0001R(\u0010\u000e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR(\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010!\u0012\u0004\b$\u0010 \u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/y;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/SNSEntityId;", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/u;", "b", "entityId", "questionnaires", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getEntityId$annotations", "()V", "Ljava/util/List;", "e", "()Ljava/util/List;", "getQuestionnaires$annotations", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33243a;

    /* renamed from: b  reason: collision with root package name */
    public final List<u> f33244b;

    public static final class a implements d0<y> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33245a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33246b;

        static {
            a aVar = new a();
            f33245a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.QuestionnaireSubmitModel", aVar, 2);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("questionnaires", true);
            f33246b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public y deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                obj2 = b11.j(descriptor, 0, v1.f57779a, null);
                obj = b11.j(descriptor, 1, new e(u.a.f33217a), null);
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
                        obj3 = b11.j(descriptor, 1, new e(u.a.f33217a), obj3);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new y(i11, (String) obj2, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a), h10.a.u(new e(u.a.f33217a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33246b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, y yVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            y.a(yVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<y> serializer() {
            return a.f33245a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<y> {
        /* renamed from: a */
        public final y createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList2.add(u.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new y(readString, arrayList);
        }

        /* renamed from: a */
        public final y[] newArray(int i11) {
            return new y[i11];
        }
    }

    public y() {
        this((String) null, (List) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f33243a;
    }

    public final List<u> b() {
        return this.f33244b;
    }

    public final String c() {
        return this.f33243a;
    }

    public int describeContents() {
        return 0;
    }

    public final List<u> e() {
        return this.f33244b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return x.b(this.f33243a, yVar.f33243a) && x.b(this.f33244b, yVar.f33244b);
    }

    public int hashCode() {
        String str = this.f33243a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<u> list = this.f33244b;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "QuestionnaireSubmitModel(entityId=" + this.f33243a + ", questionnaires=" + this.f33244b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33243a);
        List<u> list = this.f33244b;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (u writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    public /* synthetic */ y(int i11, String str, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33245a.getDescriptor());
        }
        this.f33243a = (i11 & 1) == 0 ? null : str;
        if ((i11 & 2) == 0) {
            this.f33244b = new ArrayList();
        } else {
            this.f33244b = list;
        }
    }

    public final y a(String str, List<u> list) {
        return new y(str, list);
    }

    public static /* synthetic */ y a(y yVar, String str, List<u> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = yVar.f33243a;
        }
        if ((i11 & 2) != 0) {
            list = yVar.f33244b;
        }
        return yVar.a(str, list);
    }

    public static final void a(y yVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || yVar.f33243a != null) {
            bVar.y(fVar, 0, v1.f57779a, yVar.f33243a);
        }
        if (bVar.q(fVar, 1) || !x.b(yVar.f33244b, new ArrayList())) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, new e(u.a.f33217a), yVar.f33244b);
        }
    }

    public y(String str, List<u> list) {
        this.f33243a = str;
        this.f33244b = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(String str, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? new ArrayList() : list);
    }
}
