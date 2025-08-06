package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@a
@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0011\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0011\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(¨\u0006)"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "Ljava/io/Serializable;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "CameraInitializationIssue", "CameraPermissionDenied", "CancelledByHostApplication", "CompletedUnsuccessfullyAllowContinue", "ContextSwitch", "InitializationError", "InvalideDeviceLicenseKeyIndetifier", "LicenseExpiredOrInvalid", "LockedOut", "MissingGuidanceImages", "NetworkError", "PortraitRequired", "Timeout", "UnknownInternalError", "UserCancelled", "VeritifcationSuccessfully", "VersionDeprecated", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraInitializationIssue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraPermissionDenied;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CancelledByHostApplication;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CompletedUnsuccessfullyAllowContinue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$ContextSwitch;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InitializationError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InvalideDeviceLicenseKeyIndetifier;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LicenseExpiredOrInvalid;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LockedOut;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$MissingGuidanceImages;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$PortraitRequired;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$Timeout;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UnknownInternalError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UserCancelled;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VeritifcationSuccessfully;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VersionDeprecated;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SNSLivenessReason implements Serializable {
    private final String message;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraInitializationIssue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CameraInitializationIssue extends SNSLivenessReason {
        public static final CameraInitializationIssue INSTANCE = new CameraInitializationIssue();

        private CameraInitializationIssue() {
            super("Session failed because of an unexpected camera error.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraPermissionDenied;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CameraPermissionDenied extends SNSLivenessReason {
        public static final CameraPermissionDenied INSTANCE = new CameraPermissionDenied();

        private CameraPermissionDenied() {
            super("Camera is required but access prevented by user settings.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CancelledByHostApplication;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CancelledByHostApplication extends SNSLivenessReason {
        public static final CancelledByHostApplication INSTANCE = new CancelledByHostApplication();

        private CancelledByHostApplication() {
            super("Canceled by host application", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CompletedUnsuccessfullyAllowContinue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CompletedUnsuccessfullyAllowContinue extends SNSLivenessReason {
        public static final CompletedUnsuccessfullyAllowContinue INSTANCE = new CompletedUnsuccessfullyAllowContinue();

        private CompletedUnsuccessfullyAllowContinue() {
            super("Session completed unsuccessfully but allows to continue", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$ContextSwitch;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ContextSwitch extends SNSLivenessReason {
        public static final ContextSwitch INSTANCE = new ContextSwitch();

        private ContextSwitch() {
            super("Session cancelled because a Context Switch occurred during session.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InitializationError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitializationError extends SNSLivenessReason {
        private final Exception exception;

        public InitializationError(Exception exc) {
            super("Liveness initialization is failed", (r) null);
            this.exception = exc;
        }

        public static /* synthetic */ InitializationError copy$default(InitializationError initializationError, Exception exc, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                exc = initializationError.exception;
            }
            return initializationError.copy(exc);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final InitializationError copy(Exception exc) {
            return new InitializationError(exc);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InitializationError) && x.b(this.exception, ((InitializationError) obj).exception);
        }

        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "InitializationError(exception=" + this.exception + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InvalideDeviceLicenseKeyIndetifier;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InvalideDeviceLicenseKeyIndetifier extends SNSLivenessReason {
        public static final InvalideDeviceLicenseKeyIndetifier INSTANCE = new InvalideDeviceLicenseKeyIndetifier();

        private InvalideDeviceLicenseKeyIndetifier() {
            super("The Device License Key Identifier provided was invalid.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LicenseExpiredOrInvalid;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LicenseExpiredOrInvalid extends SNSLivenessReason {
        public static final LicenseExpiredOrInvalid INSTANCE = new LicenseExpiredOrInvalid();

        private LicenseExpiredOrInvalid() {
            super("License was expired, contained invalid text, or you are attempting to initialize in an App that is not specified in your license.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LockedOut;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LockedOut extends SNSLivenessReason {
        public static final LockedOut INSTANCE = new LockedOut();

        private LockedOut() {
            super("ZoOm is in a lockout state.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$MissingGuidanceImages;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MissingGuidanceImages extends SNSLivenessReason {
        public static final MissingGuidanceImages INSTANCE = new MissingGuidanceImages();

        private MissingGuidanceImages() {
            super("Session cancelled because guidance images were not provided.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NetworkError extends SNSLivenessReason {
        private final Exception exception;

        public NetworkError() {
            this((Exception) null, 1, (r) null);
        }

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, Exception exc, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                exc = networkError.exception;
            }
            return networkError.copy(exc);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final NetworkError copy(Exception exc) {
            return new NetworkError(exc);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetworkError) && x.b(this.exception, ((NetworkError) obj).exception);
        }

        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            Exception exc = this.exception;
            if (exc == null) {
                return 0;
            }
            return exc.hashCode();
        }

        public String toString() {
            return "NetworkError(exception=" + this.exception + ')';
        }

        public NetworkError(Exception exc) {
            super("Network connectivity issue encountered.", (r) null);
            this.exception = exc;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetworkError(Exception exc, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : exc);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$PortraitRequired;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PortraitRequired extends SNSLivenessReason {
        public static final PortraitRequired INSTANCE = new PortraitRequired();

        private PortraitRequired() {
            super("Portrait mode is required.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$Timeout;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Timeout extends SNSLivenessReason {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super("Session cancelled due to timeout.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UnknownInternalError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UnknownInternalError extends SNSLivenessReason {
        public static final UnknownInternalError INSTANCE = new UnknownInternalError();

        private UnknownInternalError() {
            super("Session failed because of an unhandled internal error.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UserCancelled;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UserCancelled extends SNSLivenessReason {
        public static final UserCancelled INSTANCE = new UserCancelled();

        private UserCancelled() {
            super("User cancelled before completing session.", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VeritifcationSuccessfully;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VeritifcationSuccessfully extends SNSLivenessReason {
        public static final VeritifcationSuccessfully INSTANCE = new VeritifcationSuccessfully();

        private VeritifcationSuccessfully() {
            super("The Liveness session was performed successfully ", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VersionDeprecated;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VersionDeprecated extends SNSLivenessReason {
        public static final VersionDeprecated INSTANCE = new VersionDeprecated();

        private VersionDeprecated() {
            super("Current version of SDK is deprecated.", (r) null);
        }
    }

    public /* synthetic */ SNSLivenessReason(String str, r rVar) {
        this(str);
    }

    public final String getMessage() {
        return this.message;
    }

    private SNSLivenessReason(String str) {
        this.message = str;
    }
}
