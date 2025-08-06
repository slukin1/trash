package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.android.tpush.common.MessageKey;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 H2\u00020\u0001:\u0002\b\nBs\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bB\u0010CB\u0001\b\u0017\u0012\u0006\u0010D\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bB\u0010GJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J|\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b\b\u0010\u001fJ\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0010HÖ\u0001J\u0013\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010&\u001a\u00020\u0010HÖ\u0001J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0010HÖ\u0001R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010+\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\"\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010+\u0012\u0004\b1\u0010/\u001a\u0004\b0\u0010-R\"\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010+\u0012\u0004\b3\u0010/\u001a\u0004\b2\u0010-R\"\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010+\u0012\u0004\b5\u0010/\u001a\u0004\b4\u0010-R\"\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010+\u0012\u0004\b7\u0010/\u001a\u0004\b6\u0010-R\"\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010+\u0012\u0004\b9\u0010/\u001a\u0004\b8\u0010-R\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010+\u0012\u0004\b;\u0010/\u001a\u0004\b:\u0010-R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010<\u0012\u0004\b>\u0010/\u001a\u0004\b=\u0010\u0012R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010?\u0012\u0004\bA\u0010/\u001a\u0004\b@\u0010\u0015¨\u0006I"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/b0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "d", "e", "f", "g", "", "h", "()Ljava/lang/Integer;", "", "i", "()Ljava/lang/Long;", "id", "createdAt", "identifier", "identifierType", "targetType", "status", "targetId", "verificationCodeLength", "timeToResendInSec", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/b0;", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "getId$annotations", "()V", "j", "getCreatedAt$annotations", "n", "getIdentifier$annotations", "p", "getIdentifierType$annotations", "v", "getTargetType$annotations", "r", "getStatus$annotations", "t", "getTargetId$annotations", "Ljava/lang/Integer;", "z", "getVerificationCodeLength$annotations", "Ljava/lang/Long;", "x", "getTimeToResendInSec$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33063a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33064b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33065c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33066d;

    /* renamed from: e  reason: collision with root package name */
    public final String f33067e;

    /* renamed from: f  reason: collision with root package name */
    public final String f33068f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33069g;

    /* renamed from: h  reason: collision with root package name */
    public final Integer f33070h;

    /* renamed from: i  reason: collision with root package name */
    public final Long f33071i;

    public static final class a implements d0<b0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33072a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33073b;

        static {
            a aVar = new a();
            f33072a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.RequestCodeResponse", aVar, 9);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("createdAt", true);
            pluginGeneratedSerialDescriptor.k(Constants.IDENTIFIER, true);
            pluginGeneratedSerialDescriptor.k("identifierType", true);
            pluginGeneratedSerialDescriptor.k(MessageKey.MSG_TARGET_TYPE, true);
            pluginGeneratedSerialDescriptor.k("status", true);
            pluginGeneratedSerialDescriptor.k("targetId", true);
            pluginGeneratedSerialDescriptor.k("verificationCodeLength", true);
            pluginGeneratedSerialDescriptor.k("timeToResendInSec", true);
            f33073b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.b0 deserialize(kotlinx.serialization.encoding.c r21) {
            /*
                r20 = this;
                kotlinx.serialization.descriptors.f r0 = r20.getDescriptor()
                r1 = r21
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 3
                r7 = 8
                r8 = 4
                r9 = 2
                r10 = 0
                r11 = 1
                r12 = 0
                if (r2 == 0) goto L_0x004c
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r10, r2, r12)
                java.lang.Object r11 = r1.j(r0, r11, r2, r12)
                java.lang.Object r9 = r1.j(r0, r9, r2, r12)
                java.lang.Object r6 = r1.j(r0, r6, r2, r12)
                java.lang.Object r8 = r1.j(r0, r8, r2, r12)
                java.lang.Object r5 = r1.j(r0, r5, r2, r12)
                java.lang.Object r2 = r1.j(r0, r4, r2, r12)
                kotlinx.serialization.internal.m0 r4 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r3 = r1.j(r0, r3, r4, r12)
                kotlinx.serialization.internal.x0 r4 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r4 = r1.j(r0, r7, r4, r12)
                r7 = 511(0x1ff, float:7.16E-43)
                r12 = r10
                r10 = r8
                r8 = r7
                goto L_0x00d2
            L_0x004c:
                r2 = r10
                r19 = r11
                r6 = r12
                r8 = r6
                r9 = r8
                r10 = r9
                r11 = r10
                r13 = r11
                r14 = r13
                r15 = r14
            L_0x0057:
                if (r19 == 0) goto L_0x00ca
                int r5 = r1.w(r0)
                switch(r5) {
                    case -1: goto L_0x00c4;
                    case 0: goto L_0x00b9;
                    case 1: goto L_0x00ae;
                    case 2: goto L_0x00a3;
                    case 3: goto L_0x0098;
                    case 4: goto L_0x008d;
                    case 5: goto L_0x0081;
                    case 6: goto L_0x0078;
                    case 7: goto L_0x006f;
                    case 8: goto L_0x0066;
                    default: goto L_0x0060;
                }
            L_0x0060:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r5)
                throw r0
            L_0x0066:
                kotlinx.serialization.internal.x0 r5 = kotlinx.serialization.internal.x0.f57786a
                java.lang.Object r8 = r1.j(r0, r7, r5, r8)
                r2 = r2 | 256(0x100, float:3.59E-43)
                goto L_0x00c8
            L_0x006f:
                kotlinx.serialization.internal.m0 r5 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r6 = r1.j(r0, r3, r5, r6)
                r2 = r2 | 128(0x80, float:1.794E-43)
                goto L_0x00c8
            L_0x0078:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r4, r5, r9)
                r2 = r2 | 64
                goto L_0x00c8
            L_0x0081:
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 5
                java.lang.Object r11 = r1.j(r0, r3, r5, r11)
                r2 = r2 | 32
                r5 = r3
                r3 = 7
                goto L_0x0057
            L_0x008d:
                r3 = 5
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 4
                java.lang.Object r10 = r1.j(r0, r3, r5, r10)
                r2 = r2 | 16
                goto L_0x00c7
            L_0x0098:
                r3 = 4
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 3
                java.lang.Object r15 = r1.j(r0, r3, r5, r15)
                r2 = r2 | 8
                goto L_0x00c7
            L_0x00a3:
                r3 = 3
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 2
                java.lang.Object r14 = r1.j(r0, r3, r5, r14)
                r2 = r2 | 4
                goto L_0x00c7
            L_0x00ae:
                r3 = 2
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 1
                java.lang.Object r13 = r1.j(r0, r3, r5, r13)
                r2 = r2 | 2
                goto L_0x00c7
            L_0x00b9:
                r3 = 1
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r12 = r1.j(r0, r3, r5, r12)
                r2 = r2 | 1
                goto L_0x00c7
            L_0x00c4:
                r3 = 0
                r19 = r3
            L_0x00c7:
                r3 = 7
            L_0x00c8:
                r5 = 5
                goto L_0x0057
            L_0x00ca:
                r3 = r6
                r4 = r8
                r5 = r11
                r11 = r13
                r6 = r15
                r8 = r2
                r2 = r9
                r9 = r14
            L_0x00d2:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.b0
                r1 = r12
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r11 = (java.lang.String) r11
                r12 = r9
                java.lang.String r12 = (java.lang.String) r12
                java.lang.String r6 = (java.lang.String) r6
                r13 = r10
                java.lang.String r13 = (java.lang.String) r13
                r14 = r5
                java.lang.String r14 = (java.lang.String) r14
                r15 = r2
                java.lang.String r15 = (java.lang.String) r15
                r16 = r3
                java.lang.Integer r16 = (java.lang.Integer) r16
                r17 = r4
                java.lang.Long r17 = (java.lang.Long) r17
                r18 = 0
                r7 = r0
                r9 = r1
                r10 = r11
                r11 = r12
                r12 = r6
                r7.<init>((int) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.Integer) r16, (java.lang.Long) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.b0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.b0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(m0.f57742a), h10.a.u(x0.f57786a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33073b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, b0 b0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            b0.a(b0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b0> serializer() {
            return a.f33072a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<b0> {
        /* renamed from: a */
        public final b0 createFromParcel(Parcel parcel) {
            return new b0(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* renamed from: a */
        public final b0[] newArray(int i11) {
            return new b0[i11];
        }
    }

    public b0() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Long) null, 511, (r) null);
    }

    public static /* synthetic */ void A() {
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

    public static /* synthetic */ void w() {
    }

    public static /* synthetic */ void y() {
    }

    public final String a() {
        return this.f33063a;
    }

    public final String b() {
        return this.f33064b;
    }

    public final String c() {
        return this.f33065c;
    }

    public final String d() {
        return this.f33066d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f33067e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return x.b(this.f33063a, b0Var.f33063a) && x.b(this.f33064b, b0Var.f33064b) && x.b(this.f33065c, b0Var.f33065c) && x.b(this.f33066d, b0Var.f33066d) && x.b(this.f33067e, b0Var.f33067e) && x.b(this.f33068f, b0Var.f33068f) && x.b(this.f33069g, b0Var.f33069g) && x.b(this.f33070h, b0Var.f33070h) && x.b(this.f33071i, b0Var.f33071i);
    }

    public final String f() {
        return this.f33068f;
    }

    public final String g() {
        return this.f33069g;
    }

    public final Integer h() {
        return this.f33070h;
    }

    public int hashCode() {
        String str = this.f33063a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33064b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f33065c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f33066d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f33067e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f33068f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f33069g;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.f33070h;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Long l11 = this.f33071i;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return hashCode8 + i11;
    }

    public final Long i() {
        return this.f33071i;
    }

    public final String j() {
        return this.f33064b;
    }

    public final String l() {
        return this.f33063a;
    }

    public final String n() {
        return this.f33065c;
    }

    public final String p() {
        return this.f33066d;
    }

    public final String r() {
        return this.f33068f;
    }

    public final String t() {
        return this.f33069g;
    }

    public String toString() {
        return "RequestCodeResponse(id=" + this.f33063a + ", createdAt=" + this.f33064b + ", identifier=" + this.f33065c + ", identifierType=" + this.f33066d + ", targetType=" + this.f33067e + ", status=" + this.f33068f + ", targetId=" + this.f33069g + ", verificationCodeLength=" + this.f33070h + ", timeToResendInSec=" + this.f33071i + ')';
    }

    public final String v() {
        return this.f33067e;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33063a);
        parcel.writeString(this.f33064b);
        parcel.writeString(this.f33065c);
        parcel.writeString(this.f33066d);
        parcel.writeString(this.f33067e);
        parcel.writeString(this.f33068f);
        parcel.writeString(this.f33069g);
        Integer num = this.f33070h;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Long l11 = this.f33071i;
        if (l11 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l11.longValue());
    }

    public final Long x() {
        return this.f33071i;
    }

    public final Integer z() {
        return this.f33070h;
    }

    public /* synthetic */ b0(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Long l11, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33072a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33063a = null;
        } else {
            this.f33063a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33064b = null;
        } else {
            this.f33064b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f33065c = null;
        } else {
            this.f33065c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f33066d = null;
        } else {
            this.f33066d = str4;
        }
        if ((i11 & 16) == 0) {
            this.f33067e = null;
        } else {
            this.f33067e = str5;
        }
        if ((i11 & 32) == 0) {
            this.f33068f = null;
        } else {
            this.f33068f = str6;
        }
        if ((i11 & 64) == 0) {
            this.f33069g = null;
        } else {
            this.f33069g = str7;
        }
        if ((i11 & 128) == 0) {
            this.f33070h = null;
        } else {
            this.f33070h = num;
        }
        if ((i11 & 256) == 0) {
            this.f33071i = null;
        } else {
            this.f33071i = l11;
        }
    }

    public final b0 a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Long l11) {
        return new b0(str, str2, str3, str4, str5, str6, str7, num, l11);
    }

    public b0(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Long l11) {
        this.f33063a = str;
        this.f33064b = str2;
        this.f33065c = str3;
        this.f33066d = str4;
        this.f33067e = str5;
        this.f33068f = str6;
        this.f33069g = str7;
        this.f33070h = num;
        this.f33071i = l11;
    }

    public static /* synthetic */ b0 a(b0 b0Var, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Long l11, int i11, Object obj) {
        b0 b0Var2 = b0Var;
        int i12 = i11;
        return b0Var.a((i12 & 1) != 0 ? b0Var2.f33063a : str, (i12 & 2) != 0 ? b0Var2.f33064b : str2, (i12 & 4) != 0 ? b0Var2.f33065c : str3, (i12 & 8) != 0 ? b0Var2.f33066d : str4, (i12 & 16) != 0 ? b0Var2.f33067e : str5, (i12 & 32) != 0 ? b0Var2.f33068f : str6, (i12 & 64) != 0 ? b0Var2.f33069g : str7, (i12 & 128) != 0 ? b0Var2.f33070h : num, (i12 & 256) != 0 ? b0Var2.f33071i : l11);
    }

    public static final void a(b0 b0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || b0Var.f33063a != null) {
            bVar.y(fVar, 0, v1.f57779a, b0Var.f33063a);
        }
        if (bVar.q(fVar, 1) || b0Var.f33064b != null) {
            bVar.y(fVar, 1, v1.f57779a, b0Var.f33064b);
        }
        if (bVar.q(fVar, 2) || b0Var.f33065c != null) {
            bVar.y(fVar, 2, v1.f57779a, b0Var.f33065c);
        }
        if (bVar.q(fVar, 3) || b0Var.f33066d != null) {
            bVar.y(fVar, 3, v1.f57779a, b0Var.f33066d);
        }
        if (bVar.q(fVar, 4) || b0Var.f33067e != null) {
            bVar.y(fVar, 4, v1.f57779a, b0Var.f33067e);
        }
        if (bVar.q(fVar, 5) || b0Var.f33068f != null) {
            bVar.y(fVar, 5, v1.f57779a, b0Var.f33068f);
        }
        if (bVar.q(fVar, 6) || b0Var.f33069g != null) {
            bVar.y(fVar, 6, v1.f57779a, b0Var.f33069g);
        }
        if (bVar.q(fVar, 7) || b0Var.f33070h != null) {
            bVar.y(fVar, 7, m0.f57742a, b0Var.f33070h);
        }
        if (bVar.q(fVar, 8) || b0Var.f33071i != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 8, x0.f57786a, b0Var.f33071i);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b0(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.lang.Long r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.b0.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Long, int, kotlin.jvm.internal.r):void");
    }
}
