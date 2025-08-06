package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class u implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32926a = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final String f32927b = "EXTRA_RESULT";

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends u {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public final String f32928c;

        /* renamed from: d  reason: collision with root package name */
        public final SNSLivenessReason f32929d;

        /* renamed from: e  reason: collision with root package name */
        public final String f32930e;

        public static final class a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel.readString(), (SNSLivenessReason) parcel.readSerializable(), parcel.readString());
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(String str, SNSLivenessReason sNSLivenessReason, String str2) {
            super((r) null);
            this.f32928c = str;
            this.f32929d = sNSLivenessReason;
            this.f32930e = str2;
        }

        public final String a() {
            return this.f32930e;
        }

        public final String b() {
            return this.f32928c;
        }

        public final SNSLivenessReason c() {
            return this.f32929d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f32928c);
            parcel.writeSerializable(this.f32929d);
            parcel.writeString(this.f32930e);
        }
    }

    public static final class c extends u {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public final SNSLivenessReason f32931c;

        /* renamed from: d  reason: collision with root package name */
        public final DocumentType f32932d;

        public static final class a implements Parcelable.Creator<c> {
            /* renamed from: a */
            public final c createFromParcel(Parcel parcel) {
                return new c((SNSLivenessReason) parcel.readSerializable(), DocumentType.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final c[] newArray(int i11) {
                return new c[i11];
            }
        }

        public c(SNSLivenessReason sNSLivenessReason, DocumentType documentType) {
            super((r) null);
            this.f32931c = sNSLivenessReason;
            this.f32932d = documentType;
        }

        public final SNSLivenessReason a() {
            return this.f32931c;
        }

        public final DocumentType b() {
            return this.f32932d;
        }

        public final DocumentType c() {
            return this.f32932d;
        }

        public final SNSLivenessReason d() {
            return this.f32931c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f32931c, cVar.f32931c) && x.b(this.f32932d, cVar.f32932d);
        }

        public int hashCode() {
            return (this.f32931c.hashCode() * 31) + this.f32932d.hashCode();
        }

        public String toString() {
            return "FaceDetection(reason=" + this.f32931c + ", documentType=" + this.f32932d + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeSerializable(this.f32931c);
            this.f32932d.writeToParcel(parcel, i11);
        }

        public final c a(SNSLivenessReason sNSLivenessReason, DocumentType documentType) {
            return new c(sNSLivenessReason, documentType);
        }

        public static /* synthetic */ c a(c cVar, SNSLivenessReason sNSLivenessReason, DocumentType documentType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sNSLivenessReason = cVar.f32931c;
            }
            if ((i11 & 2) != 0) {
                documentType = cVar.f32932d;
            }
            return cVar.a(sNSLivenessReason, documentType);
        }
    }

    public /* synthetic */ u(r rVar) {
        this();
    }

    public u() {
    }
}
