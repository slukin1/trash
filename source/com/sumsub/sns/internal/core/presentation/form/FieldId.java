package com.sumsub.sns.internal.core.presentation.form;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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

@f
@Keep
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 (2\u00020\u0001:\u0002)*B\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#B3\b\u0017\u0012\u0006\u0010$\u001a\u00020\u0010\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b\"\u0010'J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010HÖ\u0001R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u0012\u0004\b!\u0010\u001f\u001a\u0004\b \u0010\u001d¨\u0006+"}, d2 = {"Lcom/sumsub/sns/internal/core/presentation/form/FieldId;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "write$Self", "", "component1", "component2", "sectionId", "itemId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "getSectionId", "()Ljava/lang/String;", "getSectionId$annotations", "()V", "getItemId", "getItemId$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "a", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class FieldId implements Parcelable {
    public static final Parcelable.Creator<FieldId> CREATOR = new c();
    public static final b Companion = new b((r) null);
    private final String itemId;
    private final String sectionId;

    public static final class a implements d0<FieldId> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33716a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33717b;

        static {
            a aVar = new a();
            f33716a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.presentation.form.FieldId", aVar, 2);
            pluginGeneratedSerialDescriptor.k("sectionId", true);
            pluginGeneratedSerialDescriptor.k("itemId", true);
            f33717b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public FieldId deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.j(descriptor, 1, v1Var, null);
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
                        obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new FieldId(i11, (String) obj, (String) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33717b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, FieldId fieldId) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            FieldId.write$Self(fieldId, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<FieldId> serializer() {
            return a.f33716a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<FieldId> {
        /* renamed from: a */
        public final FieldId createFromParcel(Parcel parcel) {
            return new FieldId(parcel.readString(), parcel.readString());
        }

        /* renamed from: a */
        public final FieldId[] newArray(int i11) {
            return new FieldId[i11];
        }
    }

    public FieldId() {
        this((String) null, (String) null, 3, (r) null);
    }

    public static /* synthetic */ FieldId copy$default(FieldId fieldId, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fieldId.sectionId;
        }
        if ((i11 & 2) != 0) {
            str2 = fieldId.itemId;
        }
        return fieldId.copy(str, str2);
    }

    public static /* synthetic */ void getItemId$annotations() {
    }

    public static /* synthetic */ void getSectionId$annotations() {
    }

    public static final void write$Self(FieldId fieldId, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || fieldId.sectionId != null) {
            bVar.y(fVar, 0, v1.f57779a, fieldId.sectionId);
        }
        if (bVar.q(fVar, 1) || fieldId.itemId != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, v1.f57779a, fieldId.itemId);
        }
    }

    public final String component1() {
        return this.sectionId;
    }

    public final String component2() {
        return this.itemId;
    }

    public final FieldId copy(String str, String str2) {
        return new FieldId(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldId)) {
            return false;
        }
        FieldId fieldId = (FieldId) obj;
        return x.b(this.sectionId, fieldId.sectionId) && x.b(this.itemId, fieldId.itemId);
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public int hashCode() {
        String str = this.sectionId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.itemId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "FieldId(sectionId=" + this.sectionId + ", itemId=" + this.itemId + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.sectionId);
        parcel.writeString(this.itemId);
    }

    public /* synthetic */ FieldId(int i11, String str, String str2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33716a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.sectionId = null;
        } else {
            this.sectionId = str;
        }
        if ((i11 & 2) == 0) {
            this.itemId = null;
        } else {
            this.itemId = str2;
        }
    }

    public FieldId(String str, String str2) {
        this.sectionId = str;
        this.itemId = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FieldId(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
