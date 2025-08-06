package com.sumsub.sns.internal.core.data.source.applicant.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;

@f
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/EKycFlowStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "COMPLETED", "SKIPPED", "CONFIRMATION_REQUIRED", "REJECTED", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum EKycFlowStatus {
    COMPLETED,
    SKIPPED,
    CONFIRMATION_REQUIRED,
    REJECTED;
    
    public static final b Companion = null;

    public static final class a implements d0<EKycFlowStatus> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33045a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33046b = null;

        static {
            f33045a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.EKycFlowStatus", 4);
            enumDescriptor.k("completed", false);
            enumDescriptor.k(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, false);
            enumDescriptor.k("confirmationRequired", false);
            enumDescriptor.k("rejected", false);
            f33046b = enumDescriptor;
        }

        /* renamed from: a */
        public EKycFlowStatus deserialize(c cVar) {
            return EKycFlowStatus.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33046b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, EKycFlowStatus eKycFlowStatus) {
            dVar.g(getDescriptor(), eKycFlowStatus.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<EKycFlowStatus> serializer() {
            return a.f33045a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }
}
