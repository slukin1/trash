package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.x0;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b!\b\b\u0018\u0000 62\u00020\u0001:\u0003\u000578B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\t\u0010\u0005\u001a\u00020\bHÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\u000b\u001a\u00020\bHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0012\u001a\u00020\fHÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fHÖ\u0001J\u001c\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018H\u0002R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010#\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0011\u0010%\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u0011\u0010'\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u0011\u0010)\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0011\u0010+\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b*\u0010\u001eR\u0011\u0010-\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b,\u0010\u001eR\u0011\u0010/\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b.\u0010\u001eR\u0011\u00101\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u0011\u00103\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b2\u0010\u001c¨\u00069"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/internal/core/common/x0;", "repository", "", "a", "Lcom/sumsub/sns/internal/core/data/source/dynamic/b$c;", "strings", "", "scene", "value", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "map", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "e", "()Z", "isEKyc", "g", "isIdentity", "k", "isSelfie", "h", "isPOA", "d", "isApplicantData", "i", "isPhoneVerification", "f", "isEmailVerification", "j", "isQuestionnaireVerification", "m", "isVideoIdent", "l", "isSupported", "b", "iconName", "<init>", "(Ljava/lang/String;)V", "Companion", "DocSetType", "IdentityDocItemType", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f(with = a.C0330a.class)
public final class DocumentType implements Parcelable {
    public static final Parcelable.Creator<DocumentType> CREATOR = new b();
    public static final a Companion = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final String f32347b = "IDENTITY";

    /* renamed from: c  reason: collision with root package name */
    public static final String f32348c = "SELFIE";

    /* renamed from: d  reason: collision with root package name */
    public static final String f32349d = "PROOF_OF_RESIDENCE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f32350e = "APPLICANT_DATA";

    /* renamed from: f  reason: collision with root package name */
    public static final String f32351f = "INVESTABILITY";

    /* renamed from: g  reason: collision with root package name */
    public static final String f32352g = "EMAIL_VERIFICATION";

    /* renamed from: h  reason: collision with root package name */
    public static final String f32353h = "PHONE_VERIFICATION";

    /* renamed from: i  reason: collision with root package name */
    public static final String f32354i = "QUESTIONNAIRE";

    /* renamed from: j  reason: collision with root package name */
    public static final String f32355j = "TYPE_UNKNOWN";

    /* renamed from: k  reason: collision with root package name */
    public static final String f32356k = "VIDEO_IDENT";

    /* renamed from: l  reason: collision with root package name */
    public static final String f32357l = "E_KYC";

    /* renamed from: a  reason: collision with root package name */
    public final String f32358a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/DocumentType$DocSetType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IDENTITY", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum DocSetType {
        IDENTITY(DocumentType.f32347b);
        
        private final String value;

        private DocSetType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/DocumentType$IdentityDocItemType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PASSPORT", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum IdentityDocItemType {
        PASSPORT("PASSPORT");
        
        private final String value;

        private IdentityDocItemType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static final class a {

        /* renamed from: com.sumsub.sns.internal.core.data.model.DocumentType$a$a  reason: collision with other inner class name */
        public static final class C0330a implements kotlinx.serialization.b<DocumentType> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0330a f32359a = new C0330a();

            /* renamed from: b  reason: collision with root package name */
            public static final kotlinx.serialization.descriptors.f f32360b = SerialDescriptorsKt.a("DocumentType", e.i.f57638a);

            /* renamed from: a */
            public void serialize(d dVar, DocumentType documentType) {
                dVar.v(documentType.c());
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32360b;
            }

            /* renamed from: a */
            public DocumentType deserialize(c cVar) {
                return DocumentType.Companion.a(cVar.q());
            }
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final DocumentType a(String str) {
            boolean z11 = true;
            if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32348c, false, 2, (Object) null))) {
                if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32347b, false, 2, (Object) null))) {
                    if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32350e, false, 2, (Object) null))) {
                        if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32349d, false, 2, (Object) null))) {
                            if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32351f, false, 2, (Object) null))) {
                                if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32352g, false, 2, (Object) null))) {
                                    if (!(str != null && StringsKt__StringsJVMKt.M(str, DocumentType.f32353h, false, 2, (Object) null))) {
                                        if (str == null || !StringsKt__StringsJVMKt.M(str, "QUESTIONNAIRE", false, 2, (Object) null)) {
                                            z11 = false;
                                        }
                                        if (!z11) {
                                            if (str != null) {
                                                return new DocumentType(str);
                                            }
                                            throw new IllegalArgumentException("Null document type");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new DocumentType(str);
        }

        public final kotlinx.serialization.b<DocumentType> serializer() {
            return C0330a.f32359a;
        }

        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<DocumentType> {
        /* renamed from: a */
        public final DocumentType createFromParcel(Parcel parcel) {
            return new DocumentType(parcel.readString());
        }

        /* renamed from: a */
        public final DocumentType[] newArray(int i11) {
            return new DocumentType[i11];
        }
    }

    public DocumentType(String str) {
        this.f32358a = str;
    }

    public final String a() {
        return this.f32358a;
    }

    public final String b() {
        return "DocType/" + this.f32358a;
    }

    public final String c() {
        return this.f32358a;
    }

    public final boolean d() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32350e, false, 2, (Object) null);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32357l, false, 2, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DocumentType) && x.b(this.f32358a, ((DocumentType) obj).f32358a);
    }

    public final boolean f() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32352g, false, 2, (Object) null);
    }

    public final boolean g() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32347b, false, 2, (Object) null);
    }

    public final boolean h() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32349d, false, 2, (Object) null);
    }

    public int hashCode() {
        return this.f32358a.hashCode();
    }

    public final boolean i() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32353h, false, 2, (Object) null);
    }

    public final boolean j() {
        return StringsKt__StringsJVMKt.M(this.f32358a, "QUESTIONNAIRE", false, 2, (Object) null);
    }

    public final boolean k() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32348c, false, 2, (Object) null);
    }

    public final boolean l() {
        return g() || k() || h() || d() || i() || f() || j() || e();
    }

    public final boolean m() {
        return StringsKt__StringsJVMKt.M(this.f32358a, f32356k, false, 2, (Object) null);
    }

    public String toString() {
        return "DocumentType(value=" + this.f32358a + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f32358a);
    }

    public final DocumentType a(String str) {
        return new DocumentType(str);
    }

    public static /* synthetic */ DocumentType a(DocumentType documentType, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = documentType.f32358a;
        }
        return documentType.a(str);
    }

    public final CharSequence a(x0 x0Var) {
        return a(x0Var.a());
    }

    public final CharSequence a(b.c cVar) {
        return cVar == null ? "" : a(cVar.d());
    }

    public final CharSequence a(Map<String, String> map) {
        d0 d0Var = d0.f56774a;
        String str = map.get(String.format("sns_step_%s_title", Arrays.copyOf(new Object[]{this.f32358a}, 1)));
        if (str == null || str.length() == 0) {
            if (g()) {
                str = map.get(String.format("sns_step_%s_title", Arrays.copyOf(new Object[]{f32347b}, 1)));
            } else if (k()) {
                str = map.get(String.format("sns_step_%s_title", Arrays.copyOf(new Object[]{f32348c}, 1)));
            } else if (d()) {
                str = map.get(String.format("sns_step_%s_title", Arrays.copyOf(new Object[]{f32350e}, 1)));
            } else {
                str = this.f32358a;
            }
        }
        return str != null ? str : this.f32358a;
    }

    public static /* synthetic */ CharSequence a(DocumentType documentType, x0 x0Var, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return documentType.a(x0Var, str);
    }

    public final CharSequence a(x0 x0Var, String str) {
        String str2;
        String str3;
        String str4;
        boolean z11 = false;
        if (str != null) {
            d0 d0Var = d0.f56774a;
            str2 = String.format(n0.j.a.f32225f, Arrays.copyOf(new Object[]{this.f32358a, str}, 2));
            str3 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{this.f32358a}, 1));
            str4 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1));
        } else {
            d0 d0Var2 = d0.f56774a;
            str2 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{this.f32358a}, 1));
            str3 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{this.f32358a}, 1));
            str4 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1));
        }
        CharSequence a11 = i.a(x0Var, str2, str3, str4);
        if (a11.length() > 0) {
            z11 = true;
        }
        if (!z11) {
            a11 = null;
        }
        return a11 == null ? this.f32358a : a11;
    }

    public static /* synthetic */ CharSequence a(DocumentType documentType, b.c cVar, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return documentType.a(cVar, str);
    }

    public final CharSequence a(b.c cVar, String str) {
        String str2;
        String str3;
        String str4;
        if (cVar == null) {
            return "";
        }
        boolean z11 = false;
        if (str != null) {
            d0 d0Var = d0.f56774a;
            str2 = String.format(n0.j.a.f32225f, Arrays.copyOf(new Object[]{this.f32358a, str}, 2));
            str3 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{this.f32358a}, 1));
            str4 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1));
        } else {
            d0 d0Var2 = d0.f56774a;
            str2 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{this.f32358a}, 1));
            str3 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{this.f32358a}, 1));
            str4 = String.format(n0.j.a.f32223d, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1));
        }
        String a11 = cVar.a(str2, str3, str4);
        if (a11.length() > 0) {
            z11 = true;
        }
        if (!z11) {
            a11 = null;
        }
        return a11 != null ? a11 : this.f32358a;
    }
}
