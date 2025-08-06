package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.b;
import d10.l;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@a
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0001\t\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "name", "getName", "ActionCompleted", "Approved", "Failed", "FinallyRejected", "Incomplete", "Initial", "Pending", "Ready", "TemporarilyDeclined", "Lcom/sumsub/sns/core/data/model/SNSSDKState$ActionCompleted;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Approved;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$FinallyRejected;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Incomplete;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Initial;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Pending;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Ready;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$TemporarilyDeclined;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SNSSDKState {
    private final String message;
    private final String name;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Approved;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Approved extends SNSSDKState {
        public static final Approved INSTANCE = new Approved();

        private Approved() {
            super("Applicant has been approved", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "message", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "ApplicantMisconfigured", "ApplicantNotFound", "InitialLoadingFailed", "InvalidParameters", "NetworkError", "Unauthorized", "Unknown", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantMisconfigured;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantNotFound;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InitialLoadingFailed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InvalidParameters;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unauthorized;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unknown;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Failed extends SNSSDKState {
        private final Exception exception;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantMisconfigured;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class ApplicantMisconfigured extends Failed {
            public static final ApplicantMisconfigured INSTANCE = new ApplicantMisconfigured();

            private ApplicantMisconfigured() {
                super("Applicant is found, but is misconfigured (most likely lacks of idDocs)", (Exception) null, 2, (r) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantNotFound;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class ApplicantNotFound extends Failed {
            public ApplicantNotFound(Exception exc) {
                super("No applicant is found for the given parameters", exc, (r) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InitialLoadingFailed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class InitialLoadingFailed extends Failed {
            public InitialLoadingFailed(Exception exc) {
                super("An error while initial loading the SDK", exc, (r) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InvalidParameters;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "messages", "", "", "(Ljava/util/List;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class InvalidParameters extends Failed {
            public InvalidParameters(List<String> list) {
                super("An attempt to setup with invalid parameters.\n" + CollectionsKt___CollectionsKt.k0(list, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null), (Exception) null, 2, (r) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class NetworkError extends Failed {
            public NetworkError(Exception exc) {
                super("A network error occured (the user will be presented with Network Oops screen)", exc, (r) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unauthorized;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Unauthorized extends Failed {
            public static final Unauthorized INSTANCE = new Unauthorized();

            private Unauthorized() {
                super("Your token isn't valid or the SDK can't refresh your token. Do you have a valid token updater?", (Exception) null, 2, (r) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unknown;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Unknown extends Failed {
            public Unknown(Exception exc) {
                super(b.W, exc, (r) null);
            }
        }

        public /* synthetic */ Failed(String str, Exception exc, r rVar) {
            this(str, exc);
        }

        public final Exception getException() {
            return this.exception;
        }

        private Failed(String str, Exception exc) {
            super(str, (r) null);
            this.exception = exc;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Failed(String str, Exception exc, int i11, r rVar) {
            this(str, (i11 & 2) != 0 ? null : exc, (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$FinallyRejected;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FinallyRejected extends SNSSDKState {
        public static final FinallyRejected INSTANCE = new FinallyRejected();

        private FinallyRejected() {
            super("Applicant has been finally rejected", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Incomplete;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Incomplete extends SNSSDKState {
        public static final Incomplete INSTANCE = new Incomplete();

        private Incomplete() {
            super("Some but not all verification steps are passed over", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Initial;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Initial extends SNSSDKState {
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super("No verification steps are passed yet", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Pending;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Pending extends SNSSDKState {
        public static final Pending INSTANCE = new Pending();

        private Pending() {
            super("Verification is in pending state", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Ready;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Ready extends SNSSDKState {
        public static final Ready INSTANCE = new Ready();

        private Ready() {
            super("SDK is ready", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$TemporarilyDeclined;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TemporarilyDeclined extends SNSSDKState {
        public static final TemporarilyDeclined INSTANCE = new TemporarilyDeclined();

        private TemporarilyDeclined() {
            super("Applicant has been declined temporarily", (r) null);
        }
    }

    public /* synthetic */ SNSSDKState(String str, r rVar) {
        this(str);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$ActionCompleted;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "actionId", "", "type", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "answer", "payload", "", "", "(Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/util/Map;)V", "getActionId", "()Ljava/lang/String;", "getAnswer", "getPayload", "()Ljava/util/Map;", "getType", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ActionCompleted extends SNSSDKState {
        private final String actionId;
        private final String answer;
        private final Map<String, Object> payload;
        private final FlowActionType type;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionCompleted(String str, FlowActionType flowActionType, String str2, Map map, int i11, r rVar) {
            this(str, flowActionType, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? MapsKt__MapsKt.h() : map);
        }

        public static /* synthetic */ ActionCompleted copy$default(ActionCompleted actionCompleted, String str, FlowActionType flowActionType, String str2, Map<String, Object> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = actionCompleted.actionId;
            }
            if ((i11 & 2) != 0) {
                flowActionType = actionCompleted.type;
            }
            if ((i11 & 4) != 0) {
                str2 = actionCompleted.answer;
            }
            if ((i11 & 8) != 0) {
                map = actionCompleted.payload;
            }
            return actionCompleted.copy(str, flowActionType, str2, map);
        }

        public final String component1() {
            return this.actionId;
        }

        public final FlowActionType component2() {
            return this.type;
        }

        public final String component3() {
            return this.answer;
        }

        public final Map<String, Object> component4() {
            return this.payload;
        }

        public final ActionCompleted copy(String str, FlowActionType flowActionType, String str2, Map<String, ? extends Object> map) {
            return new ActionCompleted(str, flowActionType, str2, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionCompleted)) {
                return false;
            }
            ActionCompleted actionCompleted = (ActionCompleted) obj;
            return x.b(this.actionId, actionCompleted.actionId) && x.b(this.type, actionCompleted.type) && x.b(this.answer, actionCompleted.answer) && x.b(this.payload, actionCompleted.payload);
        }

        public final String getActionId() {
            return this.actionId;
        }

        public final String getAnswer() {
            return this.answer;
        }

        public final Map<String, Object> getPayload() {
            return this.payload;
        }

        public final FlowActionType getType() {
            return this.type;
        }

        public int hashCode() {
            int hashCode = ((this.actionId.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.answer;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.payload.hashCode();
        }

        public String toString() {
            return "ActionCompleted(actionId=" + this.actionId + ", type=" + this.type + ", answer=" + this.answer + ", payload=" + this.payload + ')';
        }

        public ActionCompleted(String str, FlowActionType flowActionType, String str2, Map<String, ? extends Object> map) {
            super("Flow Action", (r) null);
            this.actionId = str;
            this.type = flowActionType;
            this.answer = str2;
            this.payload = map;
        }
    }

    private SNSSDKState(String str) {
        this.message = str;
        String f11 = Reflection.b(getClass()).f();
        this.name = f11 == null ? "" : f11;
    }
}
