package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
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

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 A2\u00020\u0001:\u0002\b\nBa\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b;\u0010<Bu\b\u0017\u0012\u0006\u0010=\u001a\u00020\u001d\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b;\u0010@J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003Jj\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\b\u0010\u001bJ\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001dHÖ\u0001J\u0013\u0010!\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0019\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001dHÖ\u0001R\"\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010'\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\"\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010'\u0012\u0004\b-\u0010+\u001a\u0004\b,\u0010)R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010'\u0012\u0004\b/\u0010+\u001a\u0004\b.\u0010)R\"\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010'\u0012\u0004\b1\u0010+\u001a\u0004\b0\u0010)R\"\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010'\u0012\u0004\b3\u0010+\u001a\u0004\b2\u0010)R\"\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u00104\u0012\u0004\b6\u0010+\u001a\u0004\b5\u0010\u0010R(\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u00107\u0012\u0004\b:\u0010+\u001a\u0004\b8\u00109¨\u0006B"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/c0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "d", "e", "", "f", "()Ljava/lang/Boolean;", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/k;", "g", "id", "createdAt", "title", "desc", "condition", "delimiter", "items", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/c0;", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "getId$annotations", "()V", "j", "getCreatedAt$annotations", "t", "getTitle$annotations", "n", "getDesc$annotations", "h", "getCondition$annotations", "Ljava/lang/Boolean;", "l", "getDelimiter$annotations", "Ljava/util/List;", "r", "()Ljava/util/List;", "getItems$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class c0 implements Parcelable {
    public static final Parcelable.Creator<c0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33074a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33075b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33076c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33077d;

    /* renamed from: e  reason: collision with root package name */
    public final String f33078e;

    /* renamed from: f  reason: collision with root package name */
    public final Boolean f33079f;

    /* renamed from: g  reason: collision with root package name */
    public final List<k> f33080g;

    public static final class a implements d0<c0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33081a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33082b;

        static {
            a aVar = new a();
            f33081a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.Section", aVar, 7);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("createdAt", true);
            pluginGeneratedSerialDescriptor.k("title", true);
            pluginGeneratedSerialDescriptor.k("desc", true);
            pluginGeneratedSerialDescriptor.k("condition", true);
            pluginGeneratedSerialDescriptor.k(TtmlNode.RUBY_DELIMITER, true);
            pluginGeneratedSerialDescriptor.k(FirebaseAnalytics.Param.ITEMS, true);
            f33082b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0085, code lost:
            r7 = 2;
            r12 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b0, code lost:
            r3 = 6;
            r12 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            r12 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
            r12 = r12;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.c0 deserialize(kotlinx.serialization.encoding.c r18) {
            /*
                r17 = this;
                kotlinx.serialization.descriptors.f r0 = r17.getDescriptor()
                r1 = r18
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 6
                r4 = 5
                r5 = 3
                r6 = 4
                r7 = 2
                r8 = 0
                r9 = 1
                r10 = 0
                if (r2 == 0) goto L_0x0045
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r8, r2, r10)
                java.lang.Object r9 = r1.j(r0, r9, r2, r10)
                java.lang.Object r7 = r1.j(r0, r7, r2, r10)
                java.lang.Object r5 = r1.j(r0, r5, r2, r10)
                java.lang.Object r2 = r1.j(r0, r6, r2, r10)
                kotlinx.serialization.internal.h r6 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r4 = r1.j(r0, r4, r6, r10)
                kotlinx.serialization.internal.e r6 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.source.applicant.remote.k$a r11 = com.sumsub.sns.internal.core.data.source.applicant.remote.k.a.f33184a
                r6.<init>(r11)
                java.lang.Object r3 = r1.j(r0, r3, r6, r10)
                r6 = 127(0x7f, float:1.78E-43)
                r12 = r7
                r7 = r6
                goto L_0x00ba
            L_0x0045:
                r2 = r8
                r16 = r9
                r8 = r10
                r11 = r8
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x004e:
                if (r16 == 0) goto L_0x00b3
                int r9 = r1.w(r0)
                switch(r9) {
                    case -1: goto L_0x00ad;
                    case 0: goto L_0x00a0;
                    case 1: goto L_0x0092;
                    case 2: goto L_0x0087;
                    case 3: goto L_0x007d;
                    case 4: goto L_0x0074;
                    case 5: goto L_0x006b;
                    case 6: goto L_0x005d;
                    default: goto L_0x0057;
                }
            L_0x0057:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r9)
                throw r0
            L_0x005d:
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.source.applicant.remote.k$a r7 = com.sumsub.sns.internal.core.data.source.applicant.remote.k.a.f33184a
                r9.<init>(r7)
                java.lang.Object r8 = r1.j(r0, r3, r9, r8)
                r2 = r2 | 64
                goto L_0x0085
            L_0x006b:
                kotlinx.serialization.internal.h r7 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r15 = r1.j(r0, r4, r7, r15)
                r2 = r2 | 32
                goto L_0x0085
            L_0x0074:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r14 = r1.j(r0, r6, r7, r14)
                r2 = r2 | 16
                goto L_0x0085
            L_0x007d:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r13 = r1.j(r0, r5, r7, r13)
                r2 = r2 | 8
            L_0x0085:
                r7 = 2
                goto L_0x00b1
            L_0x0087:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r9 = 2
                java.lang.Object r12 = r1.j(r0, r9, r7, r12)
                r2 = r2 | 4
                r7 = r9
                goto L_0x00b1
            L_0x0092:
                r9 = r7
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r3 = 1
                java.lang.Object r11 = r1.j(r0, r3, r7, r11)
                r2 = r2 | 2
                r7 = r9
                r9 = r3
                r3 = 6
                goto L_0x004e
            L_0x00a0:
                r9 = r7
                r3 = 1
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r10 = r1.j(r0, r3, r7, r10)
                r2 = r2 | 1
                r7 = r9
                goto L_0x00b0
            L_0x00ad:
                r3 = 0
                r16 = r3
            L_0x00b0:
                r3 = 6
            L_0x00b1:
                r9 = 1
                goto L_0x004e
            L_0x00b3:
                r7 = r2
                r3 = r8
                r8 = r10
                r9 = r11
                r5 = r13
                r2 = r14
                r4 = r15
            L_0x00ba:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.c0 r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.c0
                java.lang.String r8 = (java.lang.String) r8
                java.lang.String r9 = (java.lang.String) r9
                r10 = r12
                java.lang.String r10 = (java.lang.String) r10
                r11 = r5
                java.lang.String r11 = (java.lang.String) r11
                r12 = r2
                java.lang.String r12 = (java.lang.String) r12
                r13 = r4
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                r14 = r3
                java.util.List r14 = (java.util.List) r14
                r15 = 0
                r6 = r0
                r6.<init>((int) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.Boolean) r13, (java.util.List) r14, (kotlinx.serialization.internal.q1) r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.c0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.c0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(h.f57720a), h10.a.u(new e(k.a.f33184a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33082b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, c0 c0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            c0.a(c0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<c0> serializer() {
            return a.f33081a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<c0> {
        /* renamed from: a */
        public final c0 createFromParcel(Parcel parcel) {
            Boolean bool;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            ArrayList arrayList = null;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(k.CREATOR.createFromParcel(parcel));
                }
            }
            return new c0(readString, readString2, readString3, readString4, readString5, bool, arrayList);
        }

        /* renamed from: a */
        public final c0[] newArray(int i11) {
            return new c0[i11];
        }
    }

    public c0() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (List) null, 127, (r) null);
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o() {
    }

    public static /* synthetic */ void q() {
    }

    public static /* synthetic */ void s() {
    }

    public static /* synthetic */ void u() {
    }

    public final String a() {
        return this.f33074a;
    }

    public final String b() {
        return this.f33075b;
    }

    public final String c() {
        return this.f33076c;
    }

    public final String d() {
        return this.f33077d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f33078e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return x.b(this.f33074a, c0Var.f33074a) && x.b(this.f33075b, c0Var.f33075b) && x.b(this.f33076c, c0Var.f33076c) && x.b(this.f33077d, c0Var.f33077d) && x.b(this.f33078e, c0Var.f33078e) && x.b(this.f33079f, c0Var.f33079f) && x.b(this.f33080g, c0Var.f33080g);
    }

    public final Boolean f() {
        return this.f33079f;
    }

    public final List<k> g() {
        return this.f33080g;
    }

    public final String h() {
        return this.f33078e;
    }

    public int hashCode() {
        String str = this.f33074a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33075b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f33076c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f33077d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f33078e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.f33079f;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<k> list = this.f33080g;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode6 + i11;
    }

    public final String j() {
        return this.f33075b;
    }

    public final Boolean l() {
        return this.f33079f;
    }

    public final String n() {
        return this.f33077d;
    }

    public final String p() {
        return this.f33074a;
    }

    public final List<k> r() {
        return this.f33080g;
    }

    public final String t() {
        return this.f33076c;
    }

    public String toString() {
        return "Section(id=" + this.f33074a + ", createdAt=" + this.f33075b + ", title=" + this.f33076c + ", desc=" + this.f33077d + ", condition=" + this.f33078e + ", delimiter=" + this.f33079f + ", items=" + this.f33080g + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33074a);
        parcel.writeString(this.f33075b);
        parcel.writeString(this.f33076c);
        parcel.writeString(this.f33077d);
        parcel.writeString(this.f33078e);
        Boolean bool = this.f33079f;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<k> list = this.f33080g;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (k writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    public /* synthetic */ c0(int i11, String str, String str2, String str3, String str4, String str5, Boolean bool, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33081a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33074a = null;
        } else {
            this.f33074a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33075b = null;
        } else {
            this.f33075b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f33076c = null;
        } else {
            this.f33076c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f33077d = null;
        } else {
            this.f33077d = str4;
        }
        if ((i11 & 16) == 0) {
            this.f33078e = null;
        } else {
            this.f33078e = str5;
        }
        if ((i11 & 32) == 0) {
            this.f33079f = null;
        } else {
            this.f33079f = bool;
        }
        if ((i11 & 64) == 0) {
            this.f33080g = null;
        } else {
            this.f33080g = list;
        }
    }

    public final c0 a(String str, String str2, String str3, String str4, String str5, Boolean bool, List<k> list) {
        return new c0(str, str2, str3, str4, str5, bool, list);
    }

    public c0(String str, String str2, String str3, String str4, String str5, Boolean bool, List<k> list) {
        this.f33074a = str;
        this.f33075b = str2;
        this.f33076c = str3;
        this.f33077d = str4;
        this.f33078e = str5;
        this.f33079f = bool;
        this.f33080g = list;
    }

    public static /* synthetic */ c0 a(c0 c0Var, String str, String str2, String str3, String str4, String str5, Boolean bool, List<k> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = c0Var.f33074a;
        }
        if ((i11 & 2) != 0) {
            str2 = c0Var.f33075b;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = c0Var.f33076c;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = c0Var.f33077d;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = c0Var.f33078e;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            bool = c0Var.f33079f;
        }
        Boolean bool2 = bool;
        if ((i11 & 64) != 0) {
            list = c0Var.f33080g;
        }
        return c0Var.a(str, str6, str7, str8, str9, bool2, list);
    }

    public static final void a(c0 c0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || c0Var.f33074a != null) {
            bVar.y(fVar, 0, v1.f57779a, c0Var.f33074a);
        }
        if (bVar.q(fVar, 1) || c0Var.f33075b != null) {
            bVar.y(fVar, 1, v1.f57779a, c0Var.f33075b);
        }
        if (bVar.q(fVar, 2) || c0Var.f33076c != null) {
            bVar.y(fVar, 2, v1.f57779a, c0Var.f33076c);
        }
        if (bVar.q(fVar, 3) || c0Var.f33077d != null) {
            bVar.y(fVar, 3, v1.f57779a, c0Var.f33077d);
        }
        if (bVar.q(fVar, 4) || c0Var.f33078e != null) {
            bVar.y(fVar, 4, v1.f57779a, c0Var.f33078e);
        }
        if (bVar.q(fVar, 5) || c0Var.f33079f != null) {
            bVar.y(fVar, 5, h.f57720a, c0Var.f33079f);
        }
        if (bVar.q(fVar, 6) || c0Var.f33080g != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 6, new e(k.a.f33184a), c0Var.f33080g);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c0(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.Boolean r12, java.util.List r13, int r14, kotlin.jvm.internal.r r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.c0.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.util.List, int, kotlin.jvm.internal.r):void");
    }
}
