package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.c0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 E2\u00020\u0001:\u0002\b\nBm\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b?\u0010@B\u0001\b\u0017\u0012\u0006\u0010A\u001a\u00020\u001f\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\b?\u0010DJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003Jv\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\b\u0010\u001dJ\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u001fHÖ\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\u0019\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001fHÖ\u0001R\"\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010)\u0012\u0004\b/\u0010-\u001a\u0004\b.\u0010+R\"\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010)\u0012\u0004\b1\u0010-\u001a\u0004\b0\u0010+R\"\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u00102\u0012\u0004\b4\u0010-\u001a\u0004\b3\u0010\u000eR\"\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010)\u0012\u0004\b6\u0010-\u001a\u0004\b5\u0010+R\"\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010)\u0012\u0004\b8\u0010-\u001a\u0004\b7\u0010+R\"\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010)\u0012\u0004\b:\u0010-\u001a\u0004\b9\u0010+R(\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010;\u0012\u0004\b>\u0010-\u001a\u0004\b<\u0010=¨\u0006F"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/w;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "", "d", "()Ljava/lang/Boolean;", "e", "f", "g", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/c0;", "h", "internalId", "id", "clientId", "modifiable", "createdAt", "title", "desc", "sections", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/w;", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "getInternalId$annotations", "()V", "o", "getId$annotations", "i", "getClientId$annotations", "Ljava/lang/Boolean;", "s", "getModifiable$annotations", "k", "getCreatedAt$annotations", "w", "getTitle$annotations", "m", "getDesc$annotations", "Ljava/util/List;", "u", "()Ljava/util/List;", "getSections$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class w implements Parcelable {
    public static final Parcelable.Creator<w> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33230a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33231b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33232c;

    /* renamed from: d  reason: collision with root package name */
    public final Boolean f33233d;

    /* renamed from: e  reason: collision with root package name */
    public final String f33234e;

    /* renamed from: f  reason: collision with root package name */
    public final String f33235f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33236g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c0> f33237h;

    public static final class a implements d0<w> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33238a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33239b;

        static {
            a aVar = new a();
            f33238a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.QuestionnaireResponse", aVar, 8);
            pluginGeneratedSerialDescriptor.k("_id", true);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("clientId", true);
            pluginGeneratedSerialDescriptor.k("modifiable", true);
            pluginGeneratedSerialDescriptor.k("createdAt", true);
            pluginGeneratedSerialDescriptor.k("title", true);
            pluginGeneratedSerialDescriptor.k("desc", true);
            pluginGeneratedSerialDescriptor.k("sections", true);
            f33239b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c0, code lost:
            r3 = 7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
            r9 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            r9 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
            r9 = r9;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.w deserialize(kotlinx.serialization.encoding.c r18) {
            /*
                r17 = this;
                kotlinx.serialization.descriptors.f r0 = r17.getDescriptor()
                r1 = r18
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 3
                r7 = 4
                r8 = 2
                r9 = 0
                r10 = 1
                r11 = 0
                if (r2 == 0) goto L_0x004b
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r9, r2, r11)
                java.lang.Object r10 = r1.j(r0, r10, r2, r11)
                java.lang.Object r8 = r1.j(r0, r8, r2, r11)
                kotlinx.serialization.internal.h r12 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r6 = r1.j(r0, r6, r12, r11)
                java.lang.Object r7 = r1.j(r0, r7, r2, r11)
                java.lang.Object r5 = r1.j(r0, r5, r2, r11)
                java.lang.Object r2 = r1.j(r0, r4, r2, r11)
                kotlinx.serialization.internal.e r4 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.source.applicant.remote.c0$a r12 = com.sumsub.sns.internal.core.data.source.applicant.remote.c0.a.f33081a
                r4.<init>(r12)
                java.lang.Object r3 = r1.j(r0, r3, r4, r11)
                r4 = 255(0xff, float:3.57E-43)
                r11 = r9
                r9 = r5
                r5 = r4
                goto L_0x00ca
            L_0x004b:
                r2 = r9
                r16 = r10
                r8 = r11
                r9 = r8
                r10 = r9
                r12 = r10
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x0055:
                if (r16 == 0) goto L_0x00c3
                int r6 = r1.w(r0)
                switch(r6) {
                    case -1: goto L_0x00bd;
                    case 0: goto L_0x00b2;
                    case 1: goto L_0x00a7;
                    case 2: goto L_0x009c;
                    case 3: goto L_0x0090;
                    case 4: goto L_0x0086;
                    case 5: goto L_0x007b;
                    case 6: goto L_0x0072;
                    case 7: goto L_0x0064;
                    default: goto L_0x005e;
                }
            L_0x005e:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r6)
                throw r0
            L_0x0064:
                kotlinx.serialization.internal.e r6 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.source.applicant.remote.c0$a r7 = com.sumsub.sns.internal.core.data.source.applicant.remote.c0.a.f33081a
                r6.<init>(r7)
                java.lang.Object r8 = r1.j(r0, r3, r6, r8)
                r2 = r2 | 128(0x80, float:1.794E-43)
                goto L_0x0083
            L_0x0072:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r4, r6, r10)
                r2 = r2 | 64
                goto L_0x0083
            L_0x007b:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r5, r6, r9)
                r2 = r2 | 32
            L_0x0083:
                r6 = 3
                r7 = 4
                goto L_0x0055
            L_0x0086:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r7 = 4
                java.lang.Object r15 = r1.j(r0, r7, r6, r15)
                r2 = r2 | 16
                goto L_0x00c1
            L_0x0090:
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                r3 = 3
                java.lang.Object r14 = r1.j(r0, r3, r6, r14)
                r2 = r2 | 8
                r6 = r3
                r3 = 7
                goto L_0x0055
            L_0x009c:
                r3 = 3
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r3 = 2
                java.lang.Object r13 = r1.j(r0, r3, r6, r13)
                r2 = r2 | 4
                goto L_0x00c0
            L_0x00a7:
                r3 = 2
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r3 = 1
                java.lang.Object r12 = r1.j(r0, r3, r6, r12)
                r2 = r2 | 2
                goto L_0x00c0
            L_0x00b2:
                r3 = 1
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r11 = r1.j(r0, r3, r6, r11)
                r2 = r2 | 1
                goto L_0x00c0
            L_0x00bd:
                r3 = 0
                r16 = r3
            L_0x00c0:
                r3 = 7
            L_0x00c1:
                r6 = 3
                goto L_0x0055
            L_0x00c3:
                r5 = r2
                r3 = r8
                r2 = r10
                r10 = r12
                r8 = r13
                r6 = r14
                r7 = r15
            L_0x00ca:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.w r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.w
                r1 = r11
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r10 = (java.lang.String) r10
                java.lang.String r8 = (java.lang.String) r8
                r11 = r6
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                r12 = r7
                java.lang.String r12 = (java.lang.String) r12
                r13 = r9
                java.lang.String r13 = (java.lang.String) r13
                java.lang.String r2 = (java.lang.String) r2
                java.util.List r3 = (java.util.List) r3
                r14 = 0
                r4 = r0
                r6 = r1
                r7 = r10
                r9 = r11
                r10 = r12
                r11 = r13
                r12 = r2
                r13 = r3
                r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.Boolean) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.util.List) r13, (kotlinx.serialization.internal.q1) r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.w.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.w");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(h.f57720a), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(c0.a.f33081a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33239b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, w wVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            w.a(wVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<w> serializer() {
            return a.f33238a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<w> {
        /* renamed from: a */
        public final w createFromParcel(Parcel parcel) {
            Boolean bool;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            ArrayList arrayList = null;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(c0.CREATOR.createFromParcel(parcel));
                }
            }
            return new w(readString, readString2, readString3, bool, readString4, readString5, readString6, arrayList);
        }

        /* renamed from: a */
        public final w[] newArray(int i11) {
            return new w[i11];
        }
    }

    public w() {
        this((String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (List) null, 255, (r) null);
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void p() {
    }

    public static /* synthetic */ void r() {
    }

    public static /* synthetic */ void t() {
    }

    public static /* synthetic */ void v() {
    }

    public static /* synthetic */ void x() {
    }

    public final String a() {
        return this.f33230a;
    }

    public final String b() {
        return this.f33231b;
    }

    public final String c() {
        return this.f33232c;
    }

    public final Boolean d() {
        return this.f33233d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f33234e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return x.b(this.f33230a, wVar.f33230a) && x.b(this.f33231b, wVar.f33231b) && x.b(this.f33232c, wVar.f33232c) && x.b(this.f33233d, wVar.f33233d) && x.b(this.f33234e, wVar.f33234e) && x.b(this.f33235f, wVar.f33235f) && x.b(this.f33236g, wVar.f33236g) && x.b(this.f33237h, wVar.f33237h);
    }

    public final String f() {
        return this.f33235f;
    }

    public final String g() {
        return this.f33236g;
    }

    public final List<c0> h() {
        return this.f33237h;
    }

    public int hashCode() {
        String str = this.f33230a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33231b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f33232c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.f33233d;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.f33234e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f33235f;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f33236g;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<c0> list = this.f33237h;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode7 + i11;
    }

    public final String i() {
        return this.f33232c;
    }

    public final String k() {
        return this.f33234e;
    }

    public final String m() {
        return this.f33236g;
    }

    public final String o() {
        return this.f33231b;
    }

    public final String q() {
        return this.f33230a;
    }

    public final Boolean s() {
        return this.f33233d;
    }

    public String toString() {
        return "QuestionnaireResponse(internalId=" + this.f33230a + ", id=" + this.f33231b + ", clientId=" + this.f33232c + ", modifiable=" + this.f33233d + ", createdAt=" + this.f33234e + ", title=" + this.f33235f + ", desc=" + this.f33236g + ", sections=" + this.f33237h + ')';
    }

    public final List<c0> u() {
        return this.f33237h;
    }

    public final String w() {
        return this.f33235f;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33230a);
        parcel.writeString(this.f33231b);
        parcel.writeString(this.f33232c);
        Boolean bool = this.f33233d;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.f33234e);
        parcel.writeString(this.f33235f);
        parcel.writeString(this.f33236g);
        List<c0> list = this.f33237h;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (c0 writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    public /* synthetic */ w(int i11, String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33238a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33230a = null;
        } else {
            this.f33230a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33231b = null;
        } else {
            this.f33231b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f33232c = null;
        } else {
            this.f33232c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f33233d = null;
        } else {
            this.f33233d = bool;
        }
        if ((i11 & 16) == 0) {
            this.f33234e = null;
        } else {
            this.f33234e = str4;
        }
        if ((i11 & 32) == 0) {
            this.f33235f = null;
        } else {
            this.f33235f = str5;
        }
        if ((i11 & 64) == 0) {
            this.f33236g = null;
        } else {
            this.f33236g = str6;
        }
        if ((i11 & 128) == 0) {
            this.f33237h = null;
        } else {
            this.f33237h = list;
        }
    }

    public final w a(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, List<c0> list) {
        return new w(str, str2, str3, bool, str4, str5, str6, list);
    }

    public w(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, List<c0> list) {
        this.f33230a = str;
        this.f33231b = str2;
        this.f33232c = str3;
        this.f33233d = bool;
        this.f33234e = str4;
        this.f33235f = str5;
        this.f33236g = str6;
        this.f33237h = list;
    }

    public static /* synthetic */ w a(w wVar, String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, List list, int i11, Object obj) {
        w wVar2 = wVar;
        int i12 = i11;
        return wVar.a((i12 & 1) != 0 ? wVar2.f33230a : str, (i12 & 2) != 0 ? wVar2.f33231b : str2, (i12 & 4) != 0 ? wVar2.f33232c : str3, (i12 & 8) != 0 ? wVar2.f33233d : bool, (i12 & 16) != 0 ? wVar2.f33234e : str4, (i12 & 32) != 0 ? wVar2.f33235f : str5, (i12 & 64) != 0 ? wVar2.f33236g : str6, (i12 & 128) != 0 ? wVar2.f33237h : list);
    }

    public static final void a(w wVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || wVar.f33230a != null) {
            bVar.y(fVar, 0, v1.f57779a, wVar.f33230a);
        }
        if (bVar.q(fVar, 1) || wVar.f33231b != null) {
            bVar.y(fVar, 1, v1.f57779a, wVar.f33231b);
        }
        if (bVar.q(fVar, 2) || wVar.f33232c != null) {
            bVar.y(fVar, 2, v1.f57779a, wVar.f33232c);
        }
        if (bVar.q(fVar, 3) || wVar.f33233d != null) {
            bVar.y(fVar, 3, h.f57720a, wVar.f33233d);
        }
        if (bVar.q(fVar, 4) || wVar.f33234e != null) {
            bVar.y(fVar, 4, v1.f57779a, wVar.f33234e);
        }
        if (bVar.q(fVar, 5) || wVar.f33235f != null) {
            bVar.y(fVar, 5, v1.f57779a, wVar.f33235f);
        }
        if (bVar.q(fVar, 6) || wVar.f33236g != null) {
            bVar.y(fVar, 6, v1.f57779a, wVar.f33236g);
        }
        if (bVar.q(fVar, 7) || wVar.f33237h != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 7, new e(c0.a.f33081a), wVar.f33237h);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ w(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Boolean r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.util.List r17, int r18, kotlin.jvm.internal.r r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.w.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.r):void");
    }
}
