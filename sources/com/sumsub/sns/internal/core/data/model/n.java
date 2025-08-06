package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import java.io.File;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final File f32645a;

    /* renamed from: b  reason: collision with root package name */
    public final File f32646b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32647c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32648d;

    /* renamed from: e  reason: collision with root package name */
    public final IdentitySide f32649e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f32650f;

    /* renamed from: g  reason: collision with root package name */
    public final com.sumsub.sns.internal.ml.badphotos.models.b f32651g;

    /* renamed from: h  reason: collision with root package name */
    public final b f32652h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f32653i;

    public static final class a implements Parcelable.Creator<n> {
        /* renamed from: a */
        public final n createFromParcel(Parcel parcel) {
            File file = (File) parcel.readSerializable();
            File file2 = (File) parcel.readSerializable();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            b bVar = null;
            IdentitySide valueOf = parcel.readInt() == 0 ? null : IdentitySide.valueOf(parcel.readString());
            boolean z11 = parcel.readInt() != 0;
            com.sumsub.sns.internal.ml.badphotos.models.b createFromParcel = parcel.readInt() == 0 ? null : com.sumsub.sns.internal.ml.badphotos.models.b.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                bVar = b.CREATOR.createFromParcel(parcel);
            }
            return new n(file, file2, readString, readString2, valueOf, z11, createFromParcel, bVar, parcel.readInt() != 0);
        }

        /* renamed from: a */
        public final n[] newArray(int i11) {
            return new n[i11];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final int f32654a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32655b;

        public static final class a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel.readInt(), parcel.readLong());
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b(int i11, long j11) {
            this.f32654a = i11;
            this.f32655b = j11;
        }

        public final int a() {
            return this.f32654a;
        }

        public final long b() {
            return this.f32655b;
        }

        public final int c() {
            return this.f32654a;
        }

        public final long d() {
            return this.f32655b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f32654a == bVar.f32654a && this.f32655b == bVar.f32655b;
        }

        public int hashCode() {
            return (this.f32654a * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f32655b);
        }

        public String toString() {
            return "VideoStats(duration=" + this.f32654a + ", fileSize=" + this.f32655b + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f32654a);
            parcel.writeLong(this.f32655b);
        }

        public final b a(int i11, long j11) {
            return new b(i11, j11);
        }

        public static /* synthetic */ b a(b bVar, int i11, long j11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = bVar.f32654a;
            }
            if ((i12 & 2) != 0) {
                j11 = bVar.f32655b;
            }
            return bVar.a(i11, j11);
        }
    }

    public n() {
        this((File) null, (File) null, (String) null, (String) null, (IdentitySide) null, false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (b) null, false, 511, (r) null);
    }

    public final File a() {
        return this.f32645a;
    }

    public final File b() {
        return this.f32646b;
    }

    public final String c() {
        return this.f32647c;
    }

    public final String d() {
        return this.f32648d;
    }

    public int describeContents() {
        return 0;
    }

    public final IdentitySide e() {
        return this.f32649e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return x.b(this.f32645a, nVar.f32645a) && x.b(this.f32646b, nVar.f32646b) && x.b(this.f32647c, nVar.f32647c) && x.b(this.f32648d, nVar.f32648d) && this.f32649e == nVar.f32649e && this.f32650f == nVar.f32650f && x.b(this.f32651g, nVar.f32651g) && x.b(this.f32652h, nVar.f32652h) && this.f32653i == nVar.f32653i;
    }

    public final boolean f() {
        return this.f32650f;
    }

    public final com.sumsub.sns.internal.ml.badphotos.models.b g() {
        return this.f32651g;
    }

    public final b h() {
        return this.f32652h;
    }

    public int hashCode() {
        File file = this.f32645a;
        int i11 = 0;
        int hashCode = (file == null ? 0 : file.hashCode()) * 31;
        File file2 = this.f32646b;
        int hashCode2 = (hashCode + (file2 == null ? 0 : file2.hashCode())) * 31;
        String str = this.f32647c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32648d;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        IdentitySide identitySide = this.f32649e;
        int hashCode5 = (hashCode4 + (identitySide == null ? 0 : identitySide.hashCode())) * 31;
        boolean z11 = this.f32650f;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode5 + (z11 ? 1 : 0)) * 31;
        com.sumsub.sns.internal.ml.badphotos.models.b bVar = this.f32651g;
        int hashCode6 = (i12 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        b bVar2 = this.f32652h;
        if (bVar2 != null) {
            i11 = bVar2.hashCode();
        }
        int i13 = (hashCode6 + i11) * 31;
        boolean z13 = this.f32653i;
        if (!z13) {
            z12 = z13;
        }
        return i13 + (z12 ? 1 : 0);
    }

    public final boolean i() {
        return this.f32653i;
    }

    public final String j() {
        return this.f32647c;
    }

    public final File k() {
        return this.f32645a;
    }

    public final com.sumsub.sns.internal.ml.badphotos.models.b l() {
        return this.f32651g;
    }

    public final File m() {
        return this.f32646b;
    }

    public final boolean n() {
        return this.f32650f;
    }

    public final IdentitySide o() {
        return this.f32649e;
    }

    public final String p() {
        return this.f32648d;
    }

    public final b q() {
        return this.f32652h;
    }

    public final boolean r() {
        return this.f32645a == null || this.f32646b == null;
    }

    public final boolean s() {
        return this.f32653i;
    }

    public final boolean t() {
        return x.b(this.f32648d, DocCapture.f31491b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("type=");
        sb2.append(this.f32648d);
        sb2.append(", document=");
        File file = this.f32645a;
        String str = null;
        sb2.append(file != null ? file.getAbsolutePath() : null);
        sb2.append(", raw=");
        File file2 = this.f32646b;
        sb2.append(file2 != null ? file2.getAbsolutePath() : null);
        sb2.append(", side=");
        IdentitySide identitySide = this.f32649e;
        if (identitySide != null) {
            str = identitySide.getValue();
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeSerializable(this.f32645a);
        parcel.writeSerializable(this.f32646b);
        parcel.writeString(this.f32647c);
        parcel.writeString(this.f32648d);
        IdentitySide identitySide = this.f32649e;
        if (identitySide == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(identitySide.name());
        }
        parcel.writeInt(this.f32650f ? 1 : 0);
        com.sumsub.sns.internal.ml.badphotos.models.b bVar = this.f32651g;
        if (bVar == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bVar.writeToParcel(parcel, i11);
        }
        b bVar2 = this.f32652h;
        if (bVar2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bVar2.writeToParcel(parcel, i11);
        }
        parcel.writeInt(this.f32653i ? 1 : 0);
    }

    public n(File file, File file2, String str, String str2, IdentitySide identitySide, boolean z11, com.sumsub.sns.internal.ml.badphotos.models.b bVar, b bVar2, boolean z12) {
        this.f32645a = file;
        this.f32646b = file2;
        this.f32647c = str;
        this.f32648d = str2;
        this.f32649e = identitySide;
        this.f32650f = z11;
        this.f32651g = bVar;
        this.f32652h = bVar2;
        this.f32653i = z12;
    }

    public final n a(File file, File file2, String str, String str2, IdentitySide identitySide, boolean z11, com.sumsub.sns.internal.ml.badphotos.models.b bVar, b bVar2, boolean z12) {
        return new n(file, file2, str, str2, identitySide, z11, bVar, bVar2, z12);
    }

    public static /* synthetic */ n a(n nVar, File file, File file2, String str, String str2, IdentitySide identitySide, boolean z11, com.sumsub.sns.internal.ml.badphotos.models.b bVar, b bVar2, boolean z12, int i11, Object obj) {
        n nVar2 = nVar;
        int i12 = i11;
        return nVar.a((i12 & 1) != 0 ? nVar2.f32645a : file, (i12 & 2) != 0 ? nVar2.f32646b : file2, (i12 & 4) != 0 ? nVar2.f32647c : str, (i12 & 8) != 0 ? nVar2.f32648d : str2, (i12 & 16) != 0 ? nVar2.f32649e : identitySide, (i12 & 32) != 0 ? nVar2.f32650f : z11, (i12 & 64) != 0 ? nVar2.f32651g : bVar, (i12 & 128) != 0 ? nVar2.f32652h : bVar2, (i12 & 256) != 0 ? nVar2.f32653i : z12);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ n(java.io.File r12, java.io.File r13, java.lang.String r14, java.lang.String r15, com.sumsub.sns.internal.core.data.model.IdentitySide r16, boolean r17, com.sumsub.sns.internal.ml.badphotos.models.b r18, com.sumsub.sns.internal.core.data.model.n.b r19, boolean r20, int r21, kotlin.jvm.internal.r r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            r8 = 0
            if (r7 == 0) goto L_0x002e
            r7 = r8
            goto L_0x0030
        L_0x002e:
            r7 = r17
        L_0x0030:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0036
            r9 = r2
            goto L_0x0038
        L_0x0036:
            r9 = r18
        L_0x0038:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r2 = r19
        L_0x003f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r8 = r20
        L_0x0046:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r9
            r20 = r2
            r21 = r8
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.n.<init>(java.io.File, java.io.File, java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, boolean, com.sumsub.sns.internal.ml.badphotos.models.b, com.sumsub.sns.internal.core.data.model.n$b, boolean, int, kotlin.jvm.internal.r):void");
    }
}
