package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.android.tpush.common.MessageKey;
import io.flutter.plugins.firebase.crashlytics.Constants;
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

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 *2\u00020\u0001:\u0002\b\nB\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b$\u0010%B?\b\u0017\u0012\u0006\u0010&\u001a\u00020\u0010\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b$\u0010)J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J'\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0010HÖ\u0001R \u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR \u0010\r\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u0012\u0004\b!\u0010\u001f\u001a\u0004\b \u0010\u001dR \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u0012\u0004\b#\u0010\u001f\u001a\u0004\b\"\u0010\u001d¨\u0006+"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/a0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "targetType", "identifierType", "identifier", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getTargetType$annotations", "()V", "f", "getIdentifierType$annotations", "d", "getIdentifier$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class a0 implements Parcelable {
    public static final Parcelable.Creator<a0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33054a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33055b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33056c;

    public static final class a implements d0<a0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33057a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33058b;

        static {
            a aVar = new a();
            f33057a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.RequestCode", aVar, 3);
            pluginGeneratedSerialDescriptor.k(MessageKey.MSG_TARGET_TYPE, false);
            pluginGeneratedSerialDescriptor.k("identifierType", false);
            pluginGeneratedSerialDescriptor.k(Constants.IDENTIFIER, false);
            f33058b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public a0 deserialize(kotlinx.serialization.encoding.c cVar) {
            String str;
            String str2;
            String str3;
            int i11;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                String i12 = b11.i(descriptor, 0);
                String i13 = b11.i(descriptor, 1);
                str3 = i12;
                str = b11.i(descriptor, 2);
                str2 = i13;
                i11 = 7;
            } else {
                String str4 = null;
                String str5 = null;
                String str6 = null;
                int i14 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        str4 = b11.i(descriptor, 0);
                        i14 |= 1;
                    } else if (w11 == 1) {
                        str6 = b11.i(descriptor, 1);
                        i14 |= 2;
                    } else if (w11 == 2) {
                        str5 = b11.i(descriptor, 2);
                        i14 |= 4;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                str3 = str4;
                str = str5;
                str2 = str6;
                i11 = i14;
            }
            b11.c(descriptor);
            return new a0(i11, str3, str2, str, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var, v1Var};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33058b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, a0 a0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            a0.a(a0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<a0> serializer() {
            return a.f33057a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<a0> {
        /* renamed from: a */
        public final a0 createFromParcel(Parcel parcel) {
            return new a0(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: a */
        public final a0[] newArray(int i11) {
            return new a0[i11];
        }
    }

    public /* synthetic */ a0(int i11, String str, String str2, String str3, q1 q1Var) {
        if (7 != (i11 & 7)) {
            h1.a(i11, 7, a.f33057a.getDescriptor());
        }
        this.f33054a = str;
        this.f33055b = str2;
        this.f33056c = str3;
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final String a() {
        return this.f33054a;
    }

    public final String b() {
        return this.f33055b;
    }

    public final String c() {
        return this.f33056c;
    }

    public final String d() {
        return this.f33056c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return x.b(this.f33054a, a0Var.f33054a) && x.b(this.f33055b, a0Var.f33055b) && x.b(this.f33056c, a0Var.f33056c);
    }

    public final String f() {
        return this.f33055b;
    }

    public final String h() {
        return this.f33054a;
    }

    public int hashCode() {
        return (((this.f33054a.hashCode() * 31) + this.f33055b.hashCode()) * 31) + this.f33056c.hashCode();
    }

    public String toString() {
        return "RequestCode(targetType=" + this.f33054a + ", identifierType=" + this.f33055b + ", identifier=" + this.f33056c + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33054a);
        parcel.writeString(this.f33055b);
        parcel.writeString(this.f33056c);
    }

    public a0(String str, String str2, String str3) {
        this.f33054a = str;
        this.f33055b = str2;
        this.f33056c = str3;
    }

    public final a0 a(String str, String str2, String str3) {
        return new a0(str, str2, str3);
    }

    public static /* synthetic */ a0 a(a0 a0Var, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = a0Var.f33054a;
        }
        if ((i11 & 2) != 0) {
            str2 = a0Var.f33055b;
        }
        if ((i11 & 4) != 0) {
            str3 = a0Var.f33056c;
        }
        return a0Var.a(str, str2, str3);
    }

    public static final void a(a0 a0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, a0Var.f33054a);
        bVar.p(fVar, 1, a0Var.f33055b);
        bVar.p(fVar, 2, a0Var.f33056c);
    }
}
