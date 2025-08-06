package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class a implements Parcelable {

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a$a  reason: collision with other inner class name */
    public static final class C0469a extends a {
        public static final Parcelable.Creator<C0469a> CREATOR = new C0470a();

        /* renamed from: a  reason: collision with root package name */
        public final String f35856a;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a$a$a  reason: collision with other inner class name */
        public static final class C0470a implements Parcelable.Creator<C0469a> {
            /* renamed from: a */
            public final C0469a createFromParcel(Parcel parcel) {
                return new C0469a(parcel.readString());
            }

            /* renamed from: a */
            public final C0469a[] newArray(int i11) {
                return new C0469a[i11];
            }
        }

        public C0469a(String str) {
            super((r) null);
            this.f35856a = str;
        }

        public final String a() {
            return this.f35856a;
        }

        public final String b() {
            return this.f35856a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0469a) && x.b(this.f35856a, ((C0469a) obj).f35856a);
        }

        public int hashCode() {
            return this.f35856a.hashCode();
        }

        public String toString() {
            return "CanEnter(pin=" + this.f35856a + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f35856a);
        }

        public final C0469a a(String str) {
            return new C0469a(str);
        }

        public static /* synthetic */ C0469a a(C0469a aVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.f35856a;
            }
            return aVar.a(str);
        }
    }

    public static final class b extends a {
        public static final Parcelable.Creator<b> CREATOR = new C0471a();

        /* renamed from: a  reason: collision with root package name */
        public final String f35857a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35858b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35859c;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a$b$a  reason: collision with other inner class name */
        public static final class C0471a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(String str, String str2, String str3) {
            super((r) null);
            this.f35857a = str;
            this.f35858b = str2;
            this.f35859c = str3;
        }

        public final String a() {
            return this.f35857a;
        }

        public final String b() {
            return this.f35858b;
        }

        public final String c() {
            return this.f35859c;
        }

        public final String d() {
            return this.f35859c;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f35858b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f35857a, bVar.f35857a) && x.b(this.f35858b, bVar.f35858b) && x.b(this.f35859c, bVar.f35859c);
        }

        public final String f() {
            return this.f35857a;
        }

        public int hashCode() {
            int hashCode = ((this.f35857a.hashCode() * 31) + this.f35858b.hashCode()) * 31;
            String str = this.f35859c;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CanEnterForTransportPin(pin=" + this.f35857a + ", newPin=" + this.f35858b + ", lastPinDigit=" + this.f35859c + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f35857a);
            parcel.writeString(this.f35858b);
            parcel.writeString(this.f35859c);
        }

        public final b a(String str, String str2, String str3) {
            return new b(str, str2, str3);
        }

        public static /* synthetic */ b a(b bVar, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bVar.f35857a;
            }
            if ((i11 & 2) != 0) {
                str2 = bVar.f35858b;
            }
            if ((i11 & 4) != 0) {
                str3 = bVar.f35859c;
            }
            return bVar.a(str, str2, str3);
        }
    }

    public static final class c extends a {
        public static final Parcelable.Creator<c> CREATOR = new C0472a();

        /* renamed from: a  reason: collision with root package name */
        public final boolean f35860a;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a$c$a  reason: collision with other inner class name */
        public static final class C0472a implements Parcelable.Creator<c> {
            /* renamed from: a */
            public final c createFromParcel(Parcel parcel) {
                return new c(parcel.readInt() != 0);
            }

            /* renamed from: a */
            public final c[] newArray(int i11) {
                return new c[i11];
            }
        }

        public c(boolean z11) {
            super((r) null);
            this.f35860a = z11;
        }

        public final boolean a() {
            return this.f35860a;
        }

        public final boolean b() {
            return this.f35860a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.f35860a == ((c) obj).f35860a;
        }

        public int hashCode() {
            boolean z11 = this.f35860a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "PinEnter(needCan=" + this.f35860a + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f35860a ? 1 : 0);
        }

        public final c a(boolean z11) {
            return new c(z11);
        }

        public static /* synthetic */ c a(c cVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = cVar.f35860a;
            }
            return cVar.a(z11);
        }
    }

    public static final class d extends a {
        public static final Parcelable.Creator<d> CREATOR = new C0473a();

        /* renamed from: a  reason: collision with root package name */
        public static final d f35861a = new d();

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a$d$a  reason: collision with other inner class name */
        public static final class C0473a implements Parcelable.Creator<d> {
            /* renamed from: a */
            public final d createFromParcel(Parcel parcel) {
                parcel.readInt();
                return d.f35861a;
            }

            /* renamed from: a */
            public final d[] newArray(int i11) {
                return new d[i11];
            }
        }

        public d() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public static final class e extends a {
        public static final Parcelable.Creator<e> CREATOR = new C0474a();

        /* renamed from: a  reason: collision with root package name */
        public static final e f35862a = new e();

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a$e$a  reason: collision with other inner class name */
        public static final class C0474a implements Parcelable.Creator<e> {
            /* renamed from: a */
            public final e createFromParcel(Parcel parcel) {
                parcel.readInt();
                return e.f35862a;
            }

            /* renamed from: a */
            public final e[] newArray(int i11) {
                return new e[i11];
            }
        }

        public e() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public /* synthetic */ a(r rVar) {
        this();
    }

    public a() {
    }
}
