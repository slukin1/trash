package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus;
import com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus;
import com.sumsub.sns.internal.core.data.source.applicant.remote.i;
import com.sumsub.sns.internal.core.data.source.applicant.remote.p;
import com.sumsub.sns.internal.core.data.source.applicant.remote.s;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 L2\u00020\u0001:\u0002\b\u000bB[\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bF\u0010GBo\b\u0017\u0012\u0006\u0010H\u001a\u00020\u001e\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010J\u001a\u0004\u0018\u00010I¢\u0006\u0004\bF\u0010KJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J]\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u001eHÖ\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010$\u001a\u00020\u001eHÖ\u0001J\u0019\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001eHÖ\u0001R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\"\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010.\u0012\u0004\b1\u0010-\u001a\u0004\b/\u00100R\"\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u00102\u0012\u0004\b5\u0010-\u001a\u0004\b3\u00104R\"\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u00106\u0012\u0004\b9\u0010-\u001a\u0004\b7\u00108R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010:\u0012\u0004\b=\u0010-\u001a\u0004\b;\u0010<R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010>\u0012\u0004\bA\u0010-\u001a\u0004\b?\u0010@R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010B\u0012\u0004\bE\u0010-\u001a\u0004\bC\u0010D¨\u0006M"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/e0;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "b", "", "c", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationStatus;", "d", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;", "e", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/p;", "f", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i;", "g", "status", "confirmationType", "confirmationId", "confirmationStatus", "otpConfirmation", "oAuthConfirmation", "eidConfirmation", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "t", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "getStatus$annotations", "()V", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "l", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "getConfirmationType$annotations", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getConfirmationId$annotations", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationStatus;", "j", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationStatus;", "getConfirmationStatus$annotations", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;", "r", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;", "getOtpConfirmation$annotations", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/p;", "p", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/p;", "getOAuthConfirmation$annotations", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i;", "n", "()Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i;", "getEidConfirmation$annotations", "<init>", "(Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationStatus;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/p;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationStatus;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/s;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/p;Lcom/sumsub/sns/internal/core/data/source/applicant/remote/i;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class e0 implements Parcelable {
    public static final Parcelable.Creator<e0> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final EKycFlowStatus f33134a;

    /* renamed from: b  reason: collision with root package name */
    public final ConfirmationType f33135b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33136c;

    /* renamed from: d  reason: collision with root package name */
    public final ConfirmationStatus f33137d;

    /* renamed from: e  reason: collision with root package name */
    public final s f33138e;

    /* renamed from: f  reason: collision with root package name */
    public final p f33139f;

    /* renamed from: g  reason: collision with root package name */
    public final i f33140g;

    public static final class a implements d0<e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33141a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33142b;

        static {
            a aVar = new a();
            f33141a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.SubmitApplicantDataResponse", aVar, 7);
            pluginGeneratedSerialDescriptor.k("status", true);
            pluginGeneratedSerialDescriptor.k("confirmationType", true);
            pluginGeneratedSerialDescriptor.k("confirmationId", true);
            pluginGeneratedSerialDescriptor.k("confirmationStatus", true);
            pluginGeneratedSerialDescriptor.k("otpConfirmation", true);
            pluginGeneratedSerialDescriptor.k("oauthConfirmation", true);
            pluginGeneratedSerialDescriptor.k("eidConfirmation", true);
            f33142b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.e0 deserialize(kotlinx.serialization.encoding.c r21) {
            /*
                r20 = this;
                kotlinx.serialization.descriptors.f r0 = r20.getDescriptor()
                r1 = r21
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
                if (r2 == 0) goto L_0x0047
                com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus$a r2 = com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus.a.f33045a
                java.lang.Object r2 = r1.j(r0, r8, r2, r10)
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType$a r8 = com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType.a.f33043a
                java.lang.Object r8 = r1.j(r0, r9, r8, r10)
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r7, r9, r10)
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus.a.f33041a
                java.lang.Object r5 = r1.j(r0, r5, r9, r10)
                com.sumsub.sns.internal.core.data.source.applicant.remote.s$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.s.a.f33210a
                java.lang.Object r6 = r1.j(r0, r6, r9, r10)
                com.sumsub.sns.internal.core.data.source.applicant.remote.p$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.p.a.f33200a
                java.lang.Object r4 = r1.j(r0, r4, r9, r10)
                com.sumsub.sns.internal.core.data.source.applicant.remote.i$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.i.a.f33167a
                java.lang.Object r3 = r1.j(r0, r3, r9, r10)
                r9 = 127(0x7f, float:1.78E-43)
                r10 = r9
                goto L_0x00b4
            L_0x0047:
                r2 = r8
                r16 = r9
                r8 = r10
                r11 = r8
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x0050:
                if (r16 == 0) goto L_0x00a9
                int r9 = r1.w(r0)
                switch(r9) {
                    case -1: goto L_0x00a3;
                    case 0: goto L_0x0098;
                    case 1: goto L_0x008c;
                    case 2: goto L_0x0083;
                    case 3: goto L_0x007a;
                    case 4: goto L_0x0071;
                    case 5: goto L_0x0068;
                    case 6: goto L_0x005f;
                    default: goto L_0x0059;
                }
            L_0x0059:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r9)
                throw r0
            L_0x005f:
                com.sumsub.sns.internal.core.data.source.applicant.remote.i$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.i.a.f33167a
                java.lang.Object r8 = r1.j(r0, r3, r9, r8)
                r2 = r2 | 64
                goto L_0x00a7
            L_0x0068:
                com.sumsub.sns.internal.core.data.source.applicant.remote.p$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.p.a.f33200a
                java.lang.Object r15 = r1.j(r0, r4, r9, r15)
                r2 = r2 | 32
                goto L_0x00a7
            L_0x0071:
                com.sumsub.sns.internal.core.data.source.applicant.remote.s$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.s.a.f33210a
                java.lang.Object r14 = r1.j(r0, r6, r9, r14)
                r2 = r2 | 16
                goto L_0x00a7
            L_0x007a:
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus.a.f33041a
                java.lang.Object r13 = r1.j(r0, r5, r9, r13)
                r2 = r2 | 8
                goto L_0x00a7
            L_0x0083:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r12 = r1.j(r0, r7, r9, r12)
                r2 = r2 | 4
                goto L_0x00a7
            L_0x008c:
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType.a.f33043a
                r3 = 1
                java.lang.Object r11 = r1.j(r0, r3, r9, r11)
                r2 = r2 | 2
                r9 = r3
                r3 = 6
                goto L_0x0050
            L_0x0098:
                r3 = 1
                com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus$a r9 = com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus.a.f33045a
                r3 = 0
                java.lang.Object r10 = r1.j(r0, r3, r9, r10)
                r2 = r2 | 1
                goto L_0x00a6
            L_0x00a3:
                r3 = 0
                r16 = r3
            L_0x00a6:
                r3 = 6
            L_0x00a7:
                r9 = 1
                goto L_0x0050
            L_0x00a9:
                r3 = r8
                r8 = r11
                r7 = r12
                r5 = r13
                r6 = r14
                r4 = r15
                r19 = r10
                r10 = r2
                r2 = r19
            L_0x00b4:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.e0 r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.e0
                r11 = r2
                com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus r11 = (com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus) r11
                r12 = r8
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType r12 = (com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType) r12
                r13 = r7
                java.lang.String r13 = (java.lang.String) r13
                r14 = r5
                com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus r14 = (com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus) r14
                r15 = r6
                com.sumsub.sns.internal.core.data.source.applicant.remote.s r15 = (com.sumsub.sns.internal.core.data.source.applicant.remote.s) r15
                r16 = r4
                com.sumsub.sns.internal.core.data.source.applicant.remote.p r16 = (com.sumsub.sns.internal.core.data.source.applicant.remote.p) r16
                r17 = r3
                com.sumsub.sns.internal.core.data.source.applicant.remote.i r17 = (com.sumsub.sns.internal.core.data.source.applicant.remote.i) r17
                r18 = 0
                r9 = r0
                r9.<init>((int) r10, (com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus) r11, (com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType) r12, (java.lang.String) r13, (com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus) r14, (com.sumsub.sns.internal.core.data.source.applicant.remote.s) r15, (com.sumsub.sns.internal.core.data.source.applicant.remote.p) r16, (com.sumsub.sns.internal.core.data.source.applicant.remote.i) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.e0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.e0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(EKycFlowStatus.a.f33045a), h10.a.u(ConfirmationType.a.f33043a), h10.a.u(v1.f57779a), h10.a.u(ConfirmationStatus.a.f33041a), h10.a.u(s.a.f33210a), h10.a.u(p.a.f33200a), h10.a.u(i.a.f33167a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33142b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, e0 e0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            e0.a(e0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<e0> serializer() {
            return a.f33141a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<e0> {
        /* renamed from: a */
        public final e0 createFromParcel(Parcel parcel) {
            i iVar = null;
            EKycFlowStatus valueOf = parcel.readInt() == 0 ? null : EKycFlowStatus.valueOf(parcel.readString());
            ConfirmationType valueOf2 = parcel.readInt() == 0 ? null : ConfirmationType.valueOf(parcel.readString());
            String readString = parcel.readString();
            ConfirmationStatus valueOf3 = parcel.readInt() == 0 ? null : ConfirmationStatus.valueOf(parcel.readString());
            s createFromParcel = parcel.readInt() == 0 ? null : s.CREATOR.createFromParcel(parcel);
            p createFromParcel2 = parcel.readInt() == 0 ? null : p.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                iVar = i.CREATOR.createFromParcel(parcel);
            }
            return new e0(valueOf, valueOf2, readString, valueOf3, createFromParcel, createFromParcel2, iVar);
        }

        /* renamed from: a */
        public final e0[] newArray(int i11) {
            return new e0[i11];
        }
    }

    public e0() {
        this((EKycFlowStatus) null, (ConfirmationType) null, (String) null, (ConfirmationStatus) null, (s) null, (p) null, (i) null, 127, (r) null);
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

    public final EKycFlowStatus a() {
        return this.f33134a;
    }

    public final ConfirmationType b() {
        return this.f33135b;
    }

    public final String c() {
        return this.f33136c;
    }

    public final ConfirmationStatus d() {
        return this.f33137d;
    }

    public int describeContents() {
        return 0;
    }

    public final s e() {
        return this.f33138e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f33134a == e0Var.f33134a && this.f33135b == e0Var.f33135b && x.b(this.f33136c, e0Var.f33136c) && this.f33137d == e0Var.f33137d && x.b(this.f33138e, e0Var.f33138e) && x.b(this.f33139f, e0Var.f33139f) && x.b(this.f33140g, e0Var.f33140g);
    }

    public final p f() {
        return this.f33139f;
    }

    public final i g() {
        return this.f33140g;
    }

    public final String h() {
        return this.f33136c;
    }

    public int hashCode() {
        EKycFlowStatus eKycFlowStatus = this.f33134a;
        int i11 = 0;
        int hashCode = (eKycFlowStatus == null ? 0 : eKycFlowStatus.hashCode()) * 31;
        ConfirmationType confirmationType = this.f33135b;
        int hashCode2 = (hashCode + (confirmationType == null ? 0 : confirmationType.hashCode())) * 31;
        String str = this.f33136c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ConfirmationStatus confirmationStatus = this.f33137d;
        int hashCode4 = (hashCode3 + (confirmationStatus == null ? 0 : confirmationStatus.hashCode())) * 31;
        s sVar = this.f33138e;
        int hashCode5 = (hashCode4 + (sVar == null ? 0 : sVar.hashCode())) * 31;
        p pVar = this.f33139f;
        int hashCode6 = (hashCode5 + (pVar == null ? 0 : pVar.hashCode())) * 31;
        i iVar = this.f33140g;
        if (iVar != null) {
            i11 = iVar.hashCode();
        }
        return hashCode6 + i11;
    }

    public final ConfirmationStatus j() {
        return this.f33137d;
    }

    public final ConfirmationType l() {
        return this.f33135b;
    }

    public final i n() {
        return this.f33140g;
    }

    public final p p() {
        return this.f33139f;
    }

    public final s r() {
        return this.f33138e;
    }

    public final EKycFlowStatus t() {
        return this.f33134a;
    }

    public String toString() {
        return "SubmitApplicantDataResponse(status=" + this.f33134a + ", confirmationType=" + this.f33135b + ", confirmationId=" + this.f33136c + ", confirmationStatus=" + this.f33137d + ", otpConfirmation=" + this.f33138e + ", oAuthConfirmation=" + this.f33139f + ", eidConfirmation=" + this.f33140g + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        EKycFlowStatus eKycFlowStatus = this.f33134a;
        if (eKycFlowStatus == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(eKycFlowStatus.name());
        }
        ConfirmationType confirmationType = this.f33135b;
        if (confirmationType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(confirmationType.name());
        }
        parcel.writeString(this.f33136c);
        ConfirmationStatus confirmationStatus = this.f33137d;
        if (confirmationStatus == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(confirmationStatus.name());
        }
        s sVar = this.f33138e;
        if (sVar == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sVar.writeToParcel(parcel, i11);
        }
        p pVar = this.f33139f;
        if (pVar == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            pVar.writeToParcel(parcel, i11);
        }
        i iVar = this.f33140g;
        if (iVar == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        iVar.writeToParcel(parcel, i11);
    }

    public /* synthetic */ e0(int i11, EKycFlowStatus eKycFlowStatus, ConfirmationType confirmationType, String str, ConfirmationStatus confirmationStatus, s sVar, p pVar, i iVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33141a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33134a = null;
        } else {
            this.f33134a = eKycFlowStatus;
        }
        if ((i11 & 2) == 0) {
            this.f33135b = null;
        } else {
            this.f33135b = confirmationType;
        }
        if ((i11 & 4) == 0) {
            this.f33136c = null;
        } else {
            this.f33136c = str;
        }
        if ((i11 & 8) == 0) {
            this.f33137d = null;
        } else {
            this.f33137d = confirmationStatus;
        }
        if ((i11 & 16) == 0) {
            this.f33138e = null;
        } else {
            this.f33138e = sVar;
        }
        if ((i11 & 32) == 0) {
            this.f33139f = null;
        } else {
            this.f33139f = pVar;
        }
        if ((i11 & 64) == 0) {
            this.f33140g = null;
        } else {
            this.f33140g = iVar;
        }
    }

    public final e0 a(EKycFlowStatus eKycFlowStatus, ConfirmationType confirmationType, String str, ConfirmationStatus confirmationStatus, s sVar, p pVar, i iVar) {
        return new e0(eKycFlowStatus, confirmationType, str, confirmationStatus, sVar, pVar, iVar);
    }

    public e0(EKycFlowStatus eKycFlowStatus, ConfirmationType confirmationType, String str, ConfirmationStatus confirmationStatus, s sVar, p pVar, i iVar) {
        this.f33134a = eKycFlowStatus;
        this.f33135b = confirmationType;
        this.f33136c = str;
        this.f33137d = confirmationStatus;
        this.f33138e = sVar;
        this.f33139f = pVar;
        this.f33140g = iVar;
    }

    public static /* synthetic */ e0 a(e0 e0Var, EKycFlowStatus eKycFlowStatus, ConfirmationType confirmationType, String str, ConfirmationStatus confirmationStatus, s sVar, p pVar, i iVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            eKycFlowStatus = e0Var.f33134a;
        }
        if ((i11 & 2) != 0) {
            confirmationType = e0Var.f33135b;
        }
        ConfirmationType confirmationType2 = confirmationType;
        if ((i11 & 4) != 0) {
            str = e0Var.f33136c;
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            confirmationStatus = e0Var.f33137d;
        }
        ConfirmationStatus confirmationStatus2 = confirmationStatus;
        if ((i11 & 16) != 0) {
            sVar = e0Var.f33138e;
        }
        s sVar2 = sVar;
        if ((i11 & 32) != 0) {
            pVar = e0Var.f33139f;
        }
        p pVar2 = pVar;
        if ((i11 & 64) != 0) {
            iVar = e0Var.f33140g;
        }
        return e0Var.a(eKycFlowStatus, confirmationType2, str2, confirmationStatus2, sVar2, pVar2, iVar);
    }

    public static final void a(e0 e0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || e0Var.f33134a != null) {
            bVar.y(fVar, 0, EKycFlowStatus.a.f33045a, e0Var.f33134a);
        }
        if (bVar.q(fVar, 1) || e0Var.f33135b != null) {
            bVar.y(fVar, 1, ConfirmationType.a.f33043a, e0Var.f33135b);
        }
        if (bVar.q(fVar, 2) || e0Var.f33136c != null) {
            bVar.y(fVar, 2, v1.f57779a, e0Var.f33136c);
        }
        if (bVar.q(fVar, 3) || e0Var.f33137d != null) {
            bVar.y(fVar, 3, ConfirmationStatus.a.f33041a, e0Var.f33137d);
        }
        if (bVar.q(fVar, 4) || e0Var.f33138e != null) {
            bVar.y(fVar, 4, s.a.f33210a, e0Var.f33138e);
        }
        if (bVar.q(fVar, 5) || e0Var.f33139f != null) {
            bVar.y(fVar, 5, p.a.f33200a, e0Var.f33139f);
        }
        if (bVar.q(fVar, 6) || e0Var.f33140g != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 6, i.a.f33167a, e0Var.f33140g);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ e0(com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus r7, com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType r8, java.lang.String r9, com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus r10, com.sumsub.sns.internal.core.data.source.applicant.remote.s r11, com.sumsub.sns.internal.core.data.source.applicant.remote.p r12, com.sumsub.sns.internal.core.data.source.applicant.remote.i r13, int r14, kotlin.jvm.internal.r r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.e0.<init>(com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus, com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType, java.lang.String, com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationStatus, com.sumsub.sns.internal.core.data.source.applicant.remote.s, com.sumsub.sns.internal.core.data.source.applicant.remote.p, com.sumsub.sns.internal.core.data.source.applicant.remote.i, int, kotlin.jvm.internal.r):void");
    }
}
