package com.sumsub.sns.internal.core.data.model;

import androidx.annotation.Keep;
import com.facebook.internal.ServerProtocol;
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

@f
@Keep
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 12\u00020\u0001:\u000223BW\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b+\u0010,Bk\b\u0017\u0012\u0006\u0010-\u001a\u00020\u001c\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b+\u00100J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u000e\u001a\u00020\tHÆ\u0003J\t\u0010\u000f\u001a\u00020\tHÆ\u0003J\t\u0010\u0010\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J_\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001cHÖ\u0001J\u0013\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0012\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0013\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b$\u0010#R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b%\u0010#R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b&\u0010#R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b'\u0010#R\u0017\u0010\u0017\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b(\u0010#R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b)\u0010#R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b*\u0010#¨\u00064"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/LogParams;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "write$Self", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "errorType", "location", "externalUserId", "fileName", "applicantId", "message", "kind", "stacktrace", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getErrorType", "()Ljava/lang/String;", "getLocation", "getExternalUserId", "getFileName", "getApplicantId", "getMessage", "getKind", "getStacktrace", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "a", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class LogParams {
    public static final b Companion = new b((r) null);
    private final String applicantId;
    private final String errorType;
    private final String externalUserId;
    private final String fileName;
    private final String kind;
    private final String location;
    private final String message;
    private final String stacktrace;

    public static final class a implements d0<LogParams> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32365a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32366b;

        static {
            a aVar = new a();
            f32365a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.LogParams", aVar, 8);
            pluginGeneratedSerialDescriptor.k("errorType", true);
            pluginGeneratedSerialDescriptor.k("location", false);
            pluginGeneratedSerialDescriptor.k("externalUserId", true);
            pluginGeneratedSerialDescriptor.k("fileName", true);
            pluginGeneratedSerialDescriptor.k("applicantId", false);
            pluginGeneratedSerialDescriptor.k("message", false);
            pluginGeneratedSerialDescriptor.k("kind", true);
            pluginGeneratedSerialDescriptor.k("stacktrace", true);
            f32366b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.LogParams deserialize(kotlinx.serialization.encoding.c r23) {
            /*
                r22 = this;
                kotlinx.serialization.descriptors.f r0 = r22.getDescriptor()
                r1 = r23
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
                if (r2 == 0) goto L_0x0048
                java.lang.String r2 = r1.i(r0, r9)
                java.lang.String r9 = r1.i(r0, r10)
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r8, r10, r11)
                java.lang.Object r6 = r1.j(r0, r6, r10, r11)
                java.lang.String r7 = r1.i(r0, r7)
                java.lang.String r5 = r1.i(r0, r5)
                java.lang.String r4 = r1.i(r0, r4)
                java.lang.Object r3 = r1.j(r0, r3, r10, r11)
                r10 = 255(0xff, float:3.57E-43)
                r13 = r2
                r19 = r4
                r18 = r5
                r17 = r7
                r14 = r9
                r12 = r10
                goto L_0x00b6
            L_0x0048:
                r2 = r9
                r18 = r10
                r9 = r11
                r12 = r9
                r13 = r12
                r14 = r13
                r15 = r14
                r16 = r15
                r17 = r16
            L_0x0054:
                if (r18 == 0) goto L_0x00aa
                int r10 = r1.w(r0)
                switch(r10) {
                    case -1: goto L_0x00a6;
                    case 0: goto L_0x009b;
                    case 1: goto L_0x0093;
                    case 2: goto L_0x008a;
                    case 3: goto L_0x0081;
                    case 4: goto L_0x007a;
                    case 5: goto L_0x0073;
                    case 6: goto L_0x006c;
                    case 7: goto L_0x0063;
                    default: goto L_0x005d;
                }
            L_0x005d:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r10)
                throw r0
            L_0x0063:
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r3, r10, r9)
                r2 = r2 | 128(0x80, float:1.794E-43)
                goto L_0x00a8
            L_0x006c:
                java.lang.String r17 = r1.i(r0, r4)
                r2 = r2 | 64
                goto L_0x00a8
            L_0x0073:
                java.lang.String r16 = r1.i(r0, r5)
                r2 = r2 | 32
                goto L_0x00a8
            L_0x007a:
                java.lang.String r15 = r1.i(r0, r7)
                r2 = r2 | 16
                goto L_0x00a8
            L_0x0081:
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r14 = r1.j(r0, r6, r10, r14)
                r2 = r2 | 8
                goto L_0x00a8
            L_0x008a:
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r13 = r1.j(r0, r8, r10, r13)
                r2 = r2 | 4
                goto L_0x00a8
            L_0x0093:
                r10 = 1
                java.lang.String r12 = r1.i(r0, r10)
                r2 = r2 | 2
                goto L_0x0054
            L_0x009b:
                r10 = 1
                r11 = 0
                java.lang.String r19 = r1.i(r0, r11)
                r2 = r2 | 1
                r11 = r19
                goto L_0x0054
            L_0x00a6:
                r18 = 0
            L_0x00a8:
                r10 = 1
                goto L_0x0054
            L_0x00aa:
                r3 = r9
                r8 = r13
                r6 = r14
                r18 = r16
                r19 = r17
                r13 = r11
                r14 = r12
                r17 = r15
                r12 = r2
            L_0x00b6:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.LogParams r0 = new com.sumsub.sns.internal.core.data.model.LogParams
                r15 = r8
                java.lang.String r15 = (java.lang.String) r15
                r16 = r6
                java.lang.String r16 = (java.lang.String) r16
                r20 = r3
                java.lang.String r20 = (java.lang.String) r20
                r21 = 0
                r11 = r0
                r11.<init>((int) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (kotlinx.serialization.internal.q1) r21)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.LogParams.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.LogParams");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var, h10.a.u(v1Var), h10.a.u(v1Var), v1Var, v1Var, v1Var, h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32366b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, LogParams logParams) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            LogParams.write$Self(logParams, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<LogParams> serializer() {
            return a.f32365a;
        }

        public b() {
        }
    }

    public /* synthetic */ LogParams(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, q1 q1Var) {
        if (50 != (i11 & 50)) {
            h1.a(i11, 50, a.f32365a.getDescriptor());
        }
        this.errorType = (i11 & 1) == 0 ? "msdkError" : str;
        this.location = str2;
        if ((i11 & 4) == 0) {
            this.externalUserId = null;
        } else {
            this.externalUserId = str3;
        }
        if ((i11 & 8) == 0) {
            this.fileName = null;
        } else {
            this.fileName = str4;
        }
        this.applicantId = str5;
        this.message = str6;
        if ((i11 & 64) == 0) {
            this.kind = ServerProtocol.DIALOG_PARAM_SDK_VERSION;
        } else {
            this.kind = str7;
        }
        if ((i11 & 128) == 0) {
            this.stacktrace = null;
        } else {
            this.stacktrace = str8;
        }
    }

    public static /* synthetic */ LogParams copy$default(LogParams logParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
        LogParams logParams2 = logParams;
        int i12 = i11;
        return logParams.copy((i12 & 1) != 0 ? logParams2.errorType : str, (i12 & 2) != 0 ? logParams2.location : str2, (i12 & 4) != 0 ? logParams2.externalUserId : str3, (i12 & 8) != 0 ? logParams2.fileName : str4, (i12 & 16) != 0 ? logParams2.applicantId : str5, (i12 & 32) != 0 ? logParams2.message : str6, (i12 & 64) != 0 ? logParams2.kind : str7, (i12 & 128) != 0 ? logParams2.stacktrace : str8);
    }

    public static final void write$Self(LogParams logParams, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || !x.b(logParams.errorType, "msdkError")) {
            bVar.p(fVar, 0, logParams.errorType);
        }
        bVar.p(fVar, 1, logParams.location);
        if (bVar.q(fVar, 2) || logParams.externalUserId != null) {
            bVar.y(fVar, 2, v1.f57779a, logParams.externalUserId);
        }
        if (bVar.q(fVar, 3) || logParams.fileName != null) {
            bVar.y(fVar, 3, v1.f57779a, logParams.fileName);
        }
        bVar.p(fVar, 4, logParams.applicantId);
        bVar.p(fVar, 5, logParams.message);
        if (bVar.q(fVar, 6) || !x.b(logParams.kind, ServerProtocol.DIALOG_PARAM_SDK_VERSION)) {
            bVar.p(fVar, 6, logParams.kind);
        }
        if (bVar.q(fVar, 7) || logParams.stacktrace != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 7, v1.f57779a, logParams.stacktrace);
        }
    }

    public final String component1() {
        return this.errorType;
    }

    public final String component2() {
        return this.location;
    }

    public final String component3() {
        return this.externalUserId;
    }

    public final String component4() {
        return this.fileName;
    }

    public final String component5() {
        return this.applicantId;
    }

    public final String component6() {
        return this.message;
    }

    public final String component7() {
        return this.kind;
    }

    public final String component8() {
        return this.stacktrace;
    }

    public final LogParams copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new LogParams(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogParams)) {
            return false;
        }
        LogParams logParams = (LogParams) obj;
        return x.b(this.errorType, logParams.errorType) && x.b(this.location, logParams.location) && x.b(this.externalUserId, logParams.externalUserId) && x.b(this.fileName, logParams.fileName) && x.b(this.applicantId, logParams.applicantId) && x.b(this.message, logParams.message) && x.b(this.kind, logParams.kind) && x.b(this.stacktrace, logParams.stacktrace);
    }

    public final String getApplicantId() {
        return this.applicantId;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getExternalUserId() {
        return this.externalUserId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStacktrace() {
        return this.stacktrace;
    }

    public int hashCode() {
        int hashCode = ((this.errorType.hashCode() * 31) + this.location.hashCode()) * 31;
        String str = this.externalUserId;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileName;
        int hashCode3 = (((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.applicantId.hashCode()) * 31) + this.message.hashCode()) * 31) + this.kind.hashCode()) * 31;
        String str3 = this.stacktrace;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "LogParams(errorType=" + this.errorType + ", location=" + this.location + ", externalUserId=" + this.externalUserId + ", fileName=" + this.fileName + ", applicantId=" + this.applicantId + ", message=" + this.message + ", kind=" + this.kind + ", stacktrace=" + this.stacktrace + ')';
    }

    public LogParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.errorType = str;
        this.location = str2;
        this.externalUserId = str3;
        this.fileName = str4;
        this.applicantId = str5;
        this.message = str6;
        this.kind = str7;
        this.stacktrace = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LogParams(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "msdkError"
            r3 = r1
            goto L_0x000b
        L_0x000a:
            r3 = r12
        L_0x000b:
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r5 = r2
            goto L_0x0013
        L_0x0012:
            r5 = r14
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001a
        L_0x0019:
            r6 = r15
        L_0x001a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = "sdk"
            r9 = r1
            goto L_0x0024
        L_0x0022:
            r9 = r18
        L_0x0024:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002a
            r10 = r2
            goto L_0x002c
        L_0x002a:
            r10 = r19
        L_0x002c:
            r2 = r11
            r4 = r13
            r7 = r16
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.LogParams.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
