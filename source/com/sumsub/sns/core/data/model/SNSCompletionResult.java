package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@a
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "", "()V", "AbnormalTermination", "SuccessTermination", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult$AbnormalTermination;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult$SuccessTermination;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SNSCompletionResult {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSCompletionResult$AbnormalTermination;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AbnormalTermination extends SNSCompletionResult {
        private final Throwable exception;

        public AbnormalTermination() {
            this((Throwable) null, 1, (r) null);
        }

        public static /* synthetic */ AbnormalTermination copy$default(AbnormalTermination abnormalTermination, Throwable th2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = abnormalTermination.exception;
            }
            return abnormalTermination.copy(th2);
        }

        public final Throwable component1() {
            return this.exception;
        }

        public final AbnormalTermination copy(Throwable th2) {
            return new AbnormalTermination(th2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AbnormalTermination) && x.b(this.exception, ((AbnormalTermination) obj).exception);
        }

        public final Throwable getException() {
            return this.exception;
        }

        public int hashCode() {
            Throwable th2 = this.exception;
            if (th2 == null) {
                return 0;
            }
            return th2.hashCode();
        }

        public String toString() {
            return "AbnormalTermination(exception=" + this.exception + ')';
        }

        public AbnormalTermination(Throwable th2) {
            super((r) null);
            this.exception = th2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AbnormalTermination(Throwable th2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : th2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSCompletionResult$SuccessTermination;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "reason", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "(Lcom/sumsub/sns/core/data/model/SNSLivenessReason;)V", "getReason", "()Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SuccessTermination extends SNSCompletionResult {
        private final SNSLivenessReason reason;

        public SuccessTermination() {
            this((SNSLivenessReason) null, 1, (r) null);
        }

        public static /* synthetic */ SuccessTermination copy$default(SuccessTermination successTermination, SNSLivenessReason sNSLivenessReason, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sNSLivenessReason = successTermination.reason;
            }
            return successTermination.copy(sNSLivenessReason);
        }

        public final SNSLivenessReason component1() {
            return this.reason;
        }

        public final SuccessTermination copy(SNSLivenessReason sNSLivenessReason) {
            return new SuccessTermination(sNSLivenessReason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessTermination) && x.b(this.reason, ((SuccessTermination) obj).reason);
        }

        public final SNSLivenessReason getReason() {
            return this.reason;
        }

        public int hashCode() {
            SNSLivenessReason sNSLivenessReason = this.reason;
            if (sNSLivenessReason == null) {
                return 0;
            }
            return sNSLivenessReason.hashCode();
        }

        public String toString() {
            return "SuccessTermination(reason=" + this.reason + ')';
        }

        public SuccessTermination(SNSLivenessReason sNSLivenessReason) {
            super((r) null);
            this.reason = sNSLivenessReason;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SuccessTermination(SNSLivenessReason sNSLivenessReason, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : sNSLivenessReason);
        }
    }

    public /* synthetic */ SNSCompletionResult(r rVar) {
        this();
    }

    private SNSCompletionResult() {
    }
}
