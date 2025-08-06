package com.iproov.sdk;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.p009do.Cdo;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\r\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0011"}, d2 = {"Lcom/iproov/sdk/IProov;", "", "<init>", "()V", "Camera", "Canceller", "FaceDetector", "FailureReason", "FailureResult", "IProovSessionState", "IProovState", "LineDrawingStyle", "NaturalStyle", "Options", "Orientation", "Session", "SuccessResult", "iproov_release"}, k = 1, mv = {1, 5, 1})
@Keep
public final class IProov {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iproov/sdk/IProov$Camera;", "", "<init>", "(Ljava/lang/String;I)V", "FRONT", "EXTERNAL", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum Camera {
        FRONT,
        EXTERNAL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iproov/sdk/IProov$Canceller;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "APP", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum Canceller {
        USER,
        APP
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/iproov/sdk/IProov$FaceDetector;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "CLASSIC", "ML_KIT", "BLAZEFACE", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum FaceDetector {
        AUTO,
        CLASSIC,
        ML_KIT,
        BLAZEFACE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/iproov/sdk/IProov$FailureReason;", "", "", "feedbackCode", "Ljava/lang/String;", "getFeedbackCode", "()Ljava/lang/String;", "", "description", "I", "getDescription", "()I", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "UNKNOWN", "TOO_MUCH_MOVEMENT", "TOO_BRIGHT", "TOO_DARK", "MISALIGNED_FACE", "EYES_CLOSED", "FACE_TOO_FAR", "FACE_TOO_CLOSE", "SUNGLASSES", "OBSCURED_FACE", "USER_TIMEOUT", "NOT_SUPPORTED", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum FailureReason {
        UNKNOWN("unknown", R.string.iproov__failure_unknown),
        TOO_MUCH_MOVEMENT("too_much_movement", R.string.iproov__failure_too_much_movement),
        TOO_BRIGHT("too_bright", R.string.iproov__failure_too_bright),
        TOO_DARK("too_dark", R.string.iproov__failure_too_dark),
        MISALIGNED_FACE("misaligned_face", R.string.iproov__failure_misaligned_face),
        EYES_CLOSED("eyes_closed", R.string.iproov__failure_eyes_closed),
        FACE_TOO_FAR("face_too_far", R.string.iproov__failure_face_too_far),
        FACE_TOO_CLOSE("face_too_close", R.string.iproov__failure_face_too_close),
        SUNGLASSES("sunglasses", R.string.iproov__failure_sunglasses),
        OBSCURED_FACE("obscured_face", R.string.iproov__failure_obscured_face),
        USER_TIMEOUT("user_timeout", R.string.iproov__failure_user_timeout),
        NOT_SUPPORTED("not_supported", R.string.iproov__failure_not_supported);
        
        private final int description;
        private final String feedbackCode;

        private FailureReason(String str, int i11) {
            this.feedbackCode = str;
            this.description = i11;
        }

        public final int getDescription() {
            return this.description;
        }

        public final String getFeedbackCode() {
            return this.feedbackCode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProov$FailureResult;", "", "Lcom/iproov/sdk/IProov$FailureReason;", "component1", "Landroid/graphics/Bitmap;", "component2", "reason", "frame", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/iproov/sdk/IProov$FailureReason;", "getReason", "()Lcom/iproov/sdk/IProov$FailureReason;", "Landroid/graphics/Bitmap;", "getFrame", "()Landroid/graphics/Bitmap;", "<init>", "(Lcom/iproov/sdk/IProov$FailureReason;Landroid/graphics/Bitmap;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class FailureResult {
        private final Bitmap frame;
        private final FailureReason reason;

        public FailureResult(FailureReason failureReason, Bitmap bitmap) {
            this.reason = failureReason;
            this.frame = bitmap;
        }

        public static /* synthetic */ FailureResult copy$default(FailureResult failureResult, FailureReason failureReason, Bitmap bitmap, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                failureReason = failureResult.reason;
            }
            if ((i11 & 2) != 0) {
                bitmap = failureResult.frame;
            }
            return failureResult.copy(failureReason, bitmap);
        }

        public final FailureReason component1() {
            return this.reason;
        }

        public final Bitmap component2() {
            return this.frame;
        }

        public final FailureResult copy(FailureReason failureReason, Bitmap bitmap) {
            return new FailureResult(failureReason, bitmap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FailureResult)) {
                return false;
            }
            FailureResult failureResult = (FailureResult) obj;
            return this.reason == failureResult.reason && x.b(this.frame, failureResult.frame);
        }

        public final Bitmap getFrame() {
            return this.frame;
        }

        public final FailureReason getReason() {
            return this.reason;
        }

        public int hashCode() {
            int hashCode = this.reason.hashCode() * 31;
            Bitmap bitmap = this.frame;
            return hashCode + (bitmap == null ? 0 : bitmap.hashCode());
        }

        public String toString() {
            return "FailureResult(reason=" + this.reason + ", frame=" + this.frame + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProov$IProovSessionState;", "", "Lcom/iproov/sdk/IProov$Session;", "component1", "Lcom/iproov/sdk/IProov$IProovState;", "component2", "session", "state", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/iproov/sdk/IProov$Session;", "getSession", "()Lcom/iproov/sdk/IProov$Session;", "Lcom/iproov/sdk/IProov$IProovState;", "getState", "()Lcom/iproov/sdk/IProov$IProovState;", "<init>", "(Lcom/iproov/sdk/IProov$Session;Lcom/iproov/sdk/IProov$IProovState;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class IProovSessionState {
        private final Session session;
        private final IProovState state;

        public IProovSessionState(Session session2, IProovState iProovState) {
            this.session = session2;
            this.state = iProovState;
        }

        public static /* synthetic */ IProovSessionState copy$default(IProovSessionState iProovSessionState, Session session2, IProovState iProovState, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                session2 = iProovSessionState.session;
            }
            if ((i11 & 2) != 0) {
                iProovState = iProovSessionState.state;
            }
            return iProovSessionState.copy(session2, iProovState);
        }

        public final Session component1() {
            return this.session;
        }

        public final IProovState component2() {
            return this.state;
        }

        public final IProovSessionState copy(Session session2, IProovState iProovState) {
            return new IProovSessionState(session2, iProovState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IProovSessionState)) {
                return false;
            }
            IProovSessionState iProovSessionState = (IProovSessionState) obj;
            return x.b(this.session, iProovSessionState.session) && x.b(this.state, iProovSessionState.state);
        }

        public final Session getSession() {
            return this.session;
        }

        public final IProovState getState() {
            return this.state;
        }

        public int hashCode() {
            return (this.session.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IProovSessionState(session=" + this.session + ", state=" + this.state + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState;", "", "", "toString", "", "isFinal", "Z", "()Z", "<init>", "(Z)V", "Cancelled", "Connected", "Connecting", "Error", "Failure", "Processing", "Success", "Lcom/iproov/sdk/IProov$IProovState$Connecting;", "Lcom/iproov/sdk/IProov$IProovState$Connected;", "Lcom/iproov/sdk/IProov$IProovState$Processing;", "Lcom/iproov/sdk/IProov$IProovState$Success;", "Lcom/iproov/sdk/IProov$IProovState$Failure;", "Lcom/iproov/sdk/IProov$IProovState$Cancelled;", "Lcom/iproov/sdk/IProov$IProovState$Error;", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static abstract class IProovState {
        private final boolean isFinal;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Cancelled;", "Lcom/iproov/sdk/IProov$IProovState;", "Lcom/iproov/sdk/IProov$Canceller;", "component1", "canceller", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/IProov$Canceller;", "getCanceller", "()Lcom/iproov/sdk/IProov$Canceller;", "<init>", "(Lcom/iproov/sdk/IProov$Canceller;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Cancelled extends IProovState {
            private final Canceller canceller;

            public Cancelled(Canceller canceller2) {
                super(true, (r) null);
                this.canceller = canceller2;
            }

            public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, Canceller canceller2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    canceller2 = cancelled.canceller;
                }
                return cancelled.copy(canceller2);
            }

            public final Canceller component1() {
                return this.canceller;
            }

            public final Cancelled copy(Canceller canceller2) {
                return new Cancelled(canceller2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cancelled) && this.canceller == ((Cancelled) obj).canceller;
            }

            public final Canceller getCanceller() {
                return this.canceller;
            }

            public int hashCode() {
                return this.canceller.hashCode();
            }

            public String toString() {
                return "Cancelled(canceller=" + this.canceller + ')';
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Connected;", "Lcom/iproov/sdk/IProov$IProovState;", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Connected extends IProovState {
            public static final Connected INSTANCE = new Connected();

            private Connected() {
                super(false, (r) null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Connecting;", "Lcom/iproov/sdk/IProov$IProovState;", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Connecting extends IProovState {
            public static final Connecting INSTANCE = new Connecting();

            private Connecting() {
                super(false, (r) null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Error;", "Lcom/iproov/sdk/IProov$IProovState;", "", "toString", "Lcom/iproov/sdk/core/exception/IProovException;", "component1", "exception", "copy", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/core/exception/IProovException;", "getException", "()Lcom/iproov/sdk/core/exception/IProovException;", "<init>", "(Lcom/iproov/sdk/core/exception/IProovException;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Error extends IProovState {
            private final IProovException exception;

            public Error(IProovException iProovException) {
                super(true, (r) null);
                this.exception = iProovException;
            }

            public static /* synthetic */ Error copy$default(Error error, IProovException iProovException, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    iProovException = error.exception;
                }
                return error.copy(iProovException);
            }

            public final IProovException component1() {
                return this.exception;
            }

            public final Error copy(IProovException iProovException) {
                return new Error(iProovException);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && x.b(this.exception, ((Error) obj).exception);
            }

            public final IProovException getException() {
                return this.exception;
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + Cdo.m565do(this.exception);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Failure;", "Lcom/iproov/sdk/IProov$IProovState;", "", "toString", "Lcom/iproov/sdk/IProov$FailureResult;", "component1", "failureResult", "copy", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/IProov$FailureResult;", "getFailureResult", "()Lcom/iproov/sdk/IProov$FailureResult;", "<init>", "(Lcom/iproov/sdk/IProov$FailureResult;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Failure extends IProovState {
            private final FailureResult failureResult;

            public Failure(FailureResult failureResult2) {
                super(true, (r) null);
                this.failureResult = failureResult2;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, FailureResult failureResult2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    failureResult2 = failure.failureResult;
                }
                return failure.copy(failureResult2);
            }

            public final FailureResult component1() {
                return this.failureResult;
            }

            public final Failure copy(FailureResult failureResult2) {
                return new Failure(failureResult2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && x.b(this.failureResult, ((Failure) obj).failureResult);
            }

            public final FailureResult getFailureResult() {
                return this.failureResult;
            }

            public int hashCode() {
                return this.failureResult.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + IProovKt.toLoggable(this.failureResult);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Processing;", "Lcom/iproov/sdk/IProov$IProovState;", "", "toString", "", "component1", "component2", "progress", "message", "copy", "", "hashCode", "", "other", "", "equals", "D", "getProgress", "()D", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(DLjava/lang/String;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Processing extends IProovState {
            private final String message;
            private final double progress;

            public Processing(double d11, String str) {
                super(false, (r) null);
                this.progress = d11;
                this.message = str;
            }

            public static /* synthetic */ Processing copy$default(Processing processing, double d11, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    d11 = processing.progress;
                }
                if ((i11 & 2) != 0) {
                    str = processing.message;
                }
                return processing.copy(d11, str);
            }

            public final double component1() {
                return this.progress;
            }

            public final String component2() {
                return this.message;
            }

            public final Processing copy(double d11, String str) {
                return new Processing(d11, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Processing)) {
                    return false;
                }
                Processing processing = (Processing) obj;
                return x.b(Double.valueOf(this.progress), Double.valueOf(processing.progress)) && x.b(this.message, processing.message);
            }

            public final String getMessage() {
                return this.message;
            }

            public final double getProgress() {
                return this.progress;
            }

            public int hashCode() {
                return (Double.doubleToLongBits(this.progress) * 31) + this.message.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + Cdo.m564do(this.progress) + ' ' + this.message;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$IProovState$Success;", "Lcom/iproov/sdk/IProov$IProovState;", "", "toString", "Lcom/iproov/sdk/IProov$SuccessResult;", "component1", "successResult", "copy", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/IProov$SuccessResult;", "getSuccessResult", "()Lcom/iproov/sdk/IProov$SuccessResult;", "<init>", "(Lcom/iproov/sdk/IProov$SuccessResult;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Success extends IProovState {
            private final SuccessResult successResult;

            public Success(SuccessResult successResult2) {
                super(true, (r) null);
                this.successResult = successResult2;
            }

            public static /* synthetic */ Success copy$default(Success success, SuccessResult successResult2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    successResult2 = success.successResult;
                }
                return success.copy(successResult2);
            }

            public final SuccessResult component1() {
                return this.successResult;
            }

            public final Success copy(SuccessResult successResult2) {
                return new Success(successResult2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && x.b(this.successResult, ((Success) obj).successResult);
            }

            public final SuccessResult getSuccessResult() {
                return this.successResult;
            }

            public int hashCode() {
                return this.successResult.hashCode();
            }

            public String toString() {
                return super.toString();
            }
        }

        private IProovState(boolean z11) {
            this.isFinal = z11;
        }

        public /* synthetic */ IProovState(boolean z11, r rVar) {
            this(z11);
        }

        public final boolean isFinal() {
            return this.isFinal;
        }

        public String toString() {
            return "IProovState [" + getClass().getSimpleName() + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iproov/sdk/IProov$LineDrawingStyle;", "", "<init>", "(Ljava/lang/String;I)V", "CLASSIC", "SHADED", "VIBRANT", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum LineDrawingStyle {
        CLASSIC,
        SHADED,
        VIBRANT
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iproov/sdk/IProov$NaturalStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BLUR", "CLEAR", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum NaturalStyle {
        BLUR,
        CLEAR
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/iproov/sdk/IProov$Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "PORTRAIT", "LANDSCAPE", "REVERSE_PORTRAIT", "REVERSE_LANDSCAPE", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public enum Orientation {
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u0016\u0010\u0007\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$Session;", "", "", "cancel", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "uuid", "", "getToken", "()Ljava/lang/String;", "token", "Lcom/iproov/sdk/IProov$IProovState;", "getCurrentState", "()Lcom/iproov/sdk/IProov$IProovState;", "currentState", "", "isActive", "()Z", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public interface Session {
        void cancel();

        IProovState getCurrentState();

        String getToken();

        UUID getUuid();

        boolean isActive();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/iproov/sdk/IProov$SuccessResult;", "", "Landroid/graphics/Bitmap;", "component1", "frame", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "getFrame", "()Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class SuccessResult {
        private final Bitmap frame;

        public SuccessResult(Bitmap bitmap) {
            this.frame = bitmap;
        }

        public static /* synthetic */ SuccessResult copy$default(SuccessResult successResult, Bitmap bitmap, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bitmap = successResult.frame;
            }
            return successResult.copy(bitmap);
        }

        public final Bitmap component1() {
            return this.frame;
        }

        public final SuccessResult copy(Bitmap bitmap) {
            return new SuccessResult(bitmap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SuccessResult) && x.b(this.frame, ((SuccessResult) obj).frame);
        }

        public final Bitmap getFrame() {
            return this.frame;
        }

        public int hashCode() {
            Bitmap bitmap = this.frame;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.hashCode();
        }

        public String toString() {
            return "SuccessResult(frame=" + this.frame + ')';
        }
    }

    private IProov() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bv\b\b\u0018\u00002\u00020\u0001:\u0010\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001BÛ\u0001\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0003\u0010%\u001a\u00020\u0004\u0012\b\b\u0003\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0003\u0010(\u001a\u00020\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010+\u001a\u00020\u000e\u0012\b\b\u0002\u0010,\u001a\u00020\u0010\u0012\b\b\u0003\u0010-\u001a\u00020\u0004\u0012\b\b\u0003\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u000e\u0012\b\b\u0002\u00100\u001a\u00020\u000e\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00103\u001a\u00020\u001a\u0012\b\b\u0002\u00104\u001a\u00020\u001c\u0012\b\b\u0002\u00105\u001a\u00020\u001e\u0012\b\b\u0002\u00106\u001a\u00020 \u0012\b\b\u0002\u00107\u001a\u00020\"¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0015\u001a\u00020\u000eHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u001aHÆ\u0003J\t\u0010\u001d\u001a\u00020\u001cHÆ\u0003J\t\u0010\u001f\u001a\u00020\u001eHÆ\u0003J\t\u0010!\u001a\u00020 HÆ\u0003J\t\u0010#\u001a\u00020\"HÆ\u0003JÛ\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0003\u0010%\u001a\u00020\u00042\b\b\u0003\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0003\u0010(\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u00102\b\b\u0003\u0010-\u001a\u00020\u00042\b\b\u0003\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u001a2\b\b\u0002\u00104\u001a\u00020\u001c2\b\b\u0002\u00105\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u00020 2\b\b\u0002\u00107\u001a\u00020\"HÆ\u0001J\t\u00109\u001a\u00020\u0002HÖ\u0001J\t\u0010:\u001a\u00020\u0004HÖ\u0001J\u0013\u0010<\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010B\u001a\u0004\bG\u0010D\"\u0004\bH\u0010FR\"\u0010'\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010B\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR$\u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010+\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010,\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010B\u001a\u0004\bd\u0010D\"\u0004\be\u0010FR\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010B\u001a\u0004\bf\u0010D\"\u0004\bg\u0010FR\"\u0010/\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010Z\u001a\u0004\bh\u0010\\\"\u0004\bi\u0010^R\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010Z\u001a\u0004\bj\u0010\\\"\u0004\bk\u0010^R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010B\u001a\u0004\bq\u0010D\"\u0004\br\u0010FR\"\u00103\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u00104\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R,\u00105\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u001c\n\u0004\b5\u0010}\u0012\u0006\b\u0001\u0010\u0001\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R'\u00106\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b6\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u00107\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b7\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/iproov/sdk/IProov$Options;", "", "", "component1", "", "component2", "component3", "Lcom/iproov/sdk/IProov$Options$Filter;", "component4", "component5", "Lcom/iproov/sdk/IProov$Options$Font;", "component6", "Lcom/iproov/sdk/IProov$Options$Icon;", "component7", "", "component8", "Lcom/iproov/sdk/IProov$Options$CloseButton;", "component9", "component10", "component11", "component12", "component13", "", "Lcom/iproov/sdk/IProov$Options$Certificate;", "component14", "component15", "Lcom/iproov/sdk/IProov$Orientation;", "component16", "Lcom/iproov/sdk/IProov$Camera;", "component17", "Lcom/iproov/sdk/IProov$FaceDetector;", "component18", "Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "component19", "Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "component20", "title", "titleTextColor", "headerBackgroundColor", "filter", "surroundColor", "font", "logo", "enableScreenshots", "closeButton", "promptTextColor", "promptBackgroundColor", "promptRoundedCorners", "disableExteriorEffects", "certificates", "timeoutSecs", "orientation", "camera", "faceDetector", "genuinePresenceAssurance", "livenessAssurance", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "I", "getTitleTextColor", "()I", "setTitleTextColor", "(I)V", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "Lcom/iproov/sdk/IProov$Options$Filter;", "getFilter", "()Lcom/iproov/sdk/IProov$Options$Filter;", "setFilter", "(Lcom/iproov/sdk/IProov$Options$Filter;)V", "getSurroundColor", "setSurroundColor", "Lcom/iproov/sdk/IProov$Options$Font;", "getFont", "()Lcom/iproov/sdk/IProov$Options$Font;", "setFont", "(Lcom/iproov/sdk/IProov$Options$Font;)V", "Lcom/iproov/sdk/IProov$Options$Icon;", "getLogo", "()Lcom/iproov/sdk/IProov$Options$Icon;", "setLogo", "(Lcom/iproov/sdk/IProov$Options$Icon;)V", "Z", "getEnableScreenshots", "()Z", "setEnableScreenshots", "(Z)V", "Lcom/iproov/sdk/IProov$Options$CloseButton;", "getCloseButton", "()Lcom/iproov/sdk/IProov$Options$CloseButton;", "setCloseButton", "(Lcom/iproov/sdk/IProov$Options$CloseButton;)V", "getPromptTextColor", "setPromptTextColor", "getPromptBackgroundColor", "setPromptBackgroundColor", "getPromptRoundedCorners", "setPromptRoundedCorners", "getDisableExteriorEffects", "setDisableExteriorEffects", "Ljava/util/List;", "getCertificates", "()Ljava/util/List;", "setCertificates", "(Ljava/util/List;)V", "getTimeoutSecs", "setTimeoutSecs", "Lcom/iproov/sdk/IProov$Orientation;", "getOrientation", "()Lcom/iproov/sdk/IProov$Orientation;", "setOrientation", "(Lcom/iproov/sdk/IProov$Orientation;)V", "Lcom/iproov/sdk/IProov$Camera;", "getCamera", "()Lcom/iproov/sdk/IProov$Camera;", "setCamera", "(Lcom/iproov/sdk/IProov$Camera;)V", "Lcom/iproov/sdk/IProov$FaceDetector;", "getFaceDetector", "()Lcom/iproov/sdk/IProov$FaceDetector;", "setFaceDetector", "(Lcom/iproov/sdk/IProov$FaceDetector;)V", "getFaceDetector$annotations", "()V", "Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "getGenuinePresenceAssurance", "()Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "setGenuinePresenceAssurance", "(Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;)V", "Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "getLivenessAssurance", "()Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "setLivenessAssurance", "(Lcom/iproov/sdk/IProov$Options$LivenessAssurance;)V", "<init>", "(Ljava/lang/String;IILcom/iproov/sdk/IProov$Options$Filter;ILcom/iproov/sdk/IProov$Options$Font;Lcom/iproov/sdk/IProov$Options$Icon;ZLcom/iproov/sdk/IProov$Options$CloseButton;IIZZLjava/util/List;ILcom/iproov/sdk/IProov$Orientation;Lcom/iproov/sdk/IProov$Camera;Lcom/iproov/sdk/IProov$FaceDetector;Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;Lcom/iproov/sdk/IProov$Options$LivenessAssurance;)V", "Certificate", "CloseButton", "Defaults", "Filter", "Font", "GenuinePresenceAssurance", "Icon", "LivenessAssurance", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class Options {
        private Camera camera;
        private List<? extends Certificate> certificates;
        private CloseButton closeButton;
        private boolean disableExteriorEffects;
        private boolean enableScreenshots;
        private FaceDetector faceDetector;
        private Filter filter;
        private Font font;
        private GenuinePresenceAssurance genuinePresenceAssurance;
        private int headerBackgroundColor;
        private LivenessAssurance livenessAssurance;
        private Icon logo;
        private Orientation orientation;
        private int promptBackgroundColor;
        private boolean promptRoundedCorners;
        private int promptTextColor;
        private int surroundColor;
        private int timeoutSecs;
        private String title;
        private int titleTextColor;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Certificate;", "", "<init>", "()V", "ByteArrayCertificate", "ResourceCertificate", "Lcom/iproov/sdk/IProov$Options$Certificate$ResourceCertificate;", "Lcom/iproov/sdk/IProov$Options$Certificate$ByteArrayCertificate;", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static abstract class Certificate {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Certificate$ByteArrayCertificate;", "Lcom/iproov/sdk/IProov$Options$Certificate;", "", "component1", "byteArray", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "[B", "getByteArray", "()[B", "<init>", "([B)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class ByteArrayCertificate extends Certificate {
                private final byte[] byteArray;

                public ByteArrayCertificate(byte[] bArr) {
                    super((r) null);
                    this.byteArray = bArr;
                }

                public static /* synthetic */ ByteArrayCertificate copy$default(ByteArrayCertificate byteArrayCertificate, byte[] bArr, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        bArr = byteArrayCertificate.byteArray;
                    }
                    return byteArrayCertificate.copy(bArr);
                }

                public final byte[] component1() {
                    return this.byteArray;
                }

                public final ByteArrayCertificate copy(byte[] bArr) {
                    return new ByteArrayCertificate(bArr);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof ByteArrayCertificate) && x.b(this.byteArray, ((ByteArrayCertificate) obj).byteArray);
                }

                public final byte[] getByteArray() {
                    return this.byteArray;
                }

                public int hashCode() {
                    return Arrays.hashCode(this.byteArray);
                }

                public String toString() {
                    return "ByteArrayCertificate(byteArray=" + Arrays.toString(this.byteArray) + ')';
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0003\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Certificate$ResourceCertificate;", "Lcom/iproov/sdk/IProov$Options$Certificate;", "", "component1", "resID", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getResID", "()I", "<init>", "(I)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class ResourceCertificate extends Certificate {
                private final int resID;

                public ResourceCertificate(int i11) {
                    super((r) null);
                    this.resID = i11;
                }

                public static /* synthetic */ ResourceCertificate copy$default(ResourceCertificate resourceCertificate, int i11, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        i11 = resourceCertificate.resID;
                    }
                    return resourceCertificate.copy(i11);
                }

                public final int component1() {
                    return this.resID;
                }

                public final ResourceCertificate copy(int i11) {
                    return new ResourceCertificate(i11);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof ResourceCertificate) && this.resID == ((ResourceCertificate) obj).resID;
                }

                public final int getResID() {
                    return this.resID;
                }

                public int hashCode() {
                    return this.resID;
                }

                public String toString() {
                    return "ResourceCertificate(resID=" + this.resID + ')';
                }
            }

            private Certificate() {
            }

            public /* synthetic */ Certificate(r rVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bK\u0010LR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0007\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00058\u0006@\u0007XT¢\u0006\u0006\n\u0004\b$\u0010\u0007R\u001c\u0010%\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\nR\u0016\u0010'\u001a\u00020\u001c8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u001eR\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b.\u0010\u0007R\u0019\u00100\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u00105\u001a\u0002048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u0010:\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010?\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010D\u001a\u00020C8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010H\u001a\u00020\u001c8\u0006@\u0006XD¢\u0006\f\n\u0004\bH\u0010\u001e\u001a\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Defaults;", "", "", "title", "Ljava/lang/String;", "", "titleTextColor", "I", "headerBackgroundColor", "getHeaderBackgroundColor", "()I", "Lcom/iproov/sdk/IProov$Options$Filter$LineDrawingFilter;", "filter", "Lcom/iproov/sdk/IProov$Options$Filter$LineDrawingFilter;", "getFilter", "()Lcom/iproov/sdk/IProov$Options$Filter$LineDrawingFilter;", "surroundColor", "getSurroundColor", "Lcom/iproov/sdk/IProov$Options$Font;", "font", "Lcom/iproov/sdk/IProov$Options$Font;", "getFont", "()Lcom/iproov/sdk/IProov$Options$Font;", "Lcom/iproov/sdk/IProov$Options$Icon;", "logo", "Lcom/iproov/sdk/IProov$Options$Icon;", "getLogo", "()Lcom/iproov/sdk/IProov$Options$Icon;", "", "enableScreenshots", "Z", "Lcom/iproov/sdk/IProov$Options$CloseButton;", "closeButton", "Lcom/iproov/sdk/IProov$Options$CloseButton;", "getCloseButton", "()Lcom/iproov/sdk/IProov$Options$CloseButton;", "promptTextColor", "promptBackgroundColor", "getPromptBackgroundColor", "promptRoundedCorners", "", "Lcom/iproov/sdk/IProov$Options$Certificate;", "certificates", "Ljava/util/List;", "getCertificates", "()Ljava/util/List;", "timeoutSecs", "Lcom/iproov/sdk/IProov$Orientation;", "orientation", "Lcom/iproov/sdk/IProov$Orientation;", "getOrientation", "()Lcom/iproov/sdk/IProov$Orientation;", "Lcom/iproov/sdk/IProov$Camera;", "camera", "Lcom/iproov/sdk/IProov$Camera;", "getCamera", "()Lcom/iproov/sdk/IProov$Camera;", "Lcom/iproov/sdk/IProov$FaceDetector;", "faceDetector", "Lcom/iproov/sdk/IProov$FaceDetector;", "getFaceDetector", "()Lcom/iproov/sdk/IProov$FaceDetector;", "Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "genuinePresenceAssurance", "Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "getGenuinePresenceAssurance", "()Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "livenessAssurance", "Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "getLivenessAssurance", "()Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "disableExteriorEffects", "getDisableExteriorEffects", "()Z", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class Defaults {
            public static final Defaults INSTANCE = new Defaults();
            private static final Camera camera = Camera.FRONT;
            private static final List<Certificate> certificates = CollectionsKt__CollectionsKt.n(new Certificate.ResourceCertificate(R.raw.iproov__certificate_old_intermediate), new Certificate.ResourceCertificate(R.raw.iproov__certificate_gsgccr3dvtlsca2020), new Certificate.ResourceCertificate(R.raw.iproov__certificate_gsgccr6alphasslca2023));
            private static final CloseButton closeButton = new CloseButton((Icon) null, 0, 3, (r) null);
            private static final boolean disableExteriorEffects = false;
            public static final boolean enableScreenshots = false;
            private static final FaceDetector faceDetector = FaceDetector.CLASSIC;
            private static final Filter.LineDrawingFilter filter = new Filter.LineDrawingFilter((LineDrawingStyle) null, 0, 0, 7, (r) null);
            private static final Font font = null;
            private static final GenuinePresenceAssurance genuinePresenceAssurance = new GenuinePresenceAssurance(0, 0, 0.0f, 0.0f, 0.0f, 31, (r) null);
            private static final int headerBackgroundColor = Color.parseColor("#00FFFFFF");
            private static final LivenessAssurance livenessAssurance = new LivenessAssurance(0, 0, 3, (r) null);
            private static final Icon logo = null;
            private static final Orientation orientation = Orientation.PORTRAIT;
            private static final int promptBackgroundColor = Color.parseColor("#CC000000");
            public static final boolean promptRoundedCorners = true;
            public static final int promptTextColor = -1;
            private static final int surroundColor = Color.parseColor("#66000000");
            public static final int timeoutSecs = 10;
            public static final String title = "";
            public static final int titleTextColor = -1;

            private Defaults() {
            }

            public final Camera getCamera() {
                return camera;
            }

            public final List<Certificate> getCertificates() {
                return certificates;
            }

            public final CloseButton getCloseButton() {
                return closeButton;
            }

            public final boolean getDisableExteriorEffects() {
                return disableExteriorEffects;
            }

            public final FaceDetector getFaceDetector() {
                return faceDetector;
            }

            public final Filter.LineDrawingFilter getFilter() {
                return filter;
            }

            public final Font getFont() {
                return font;
            }

            public final GenuinePresenceAssurance getGenuinePresenceAssurance() {
                return genuinePresenceAssurance;
            }

            public final int getHeaderBackgroundColor() {
                return headerBackgroundColor;
            }

            public final LivenessAssurance getLivenessAssurance() {
                return livenessAssurance;
            }

            public final Icon getLogo() {
                return logo;
            }

            public final Orientation getOrientation() {
                return orientation;
            }

            public final int getPromptBackgroundColor() {
                return promptBackgroundColor;
            }

            public final int getSurroundColor() {
                return surroundColor;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Filter;", "", "<init>", "()V", "LineDrawingFilter", "NaturalFilter", "Lcom/iproov/sdk/IProov$Options$Filter$LineDrawingFilter;", "Lcom/iproov/sdk/IProov$Options$Filter$NaturalFilter;", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static abstract class Filter {
            private Filter() {
            }

            public /* synthetic */ Filter(r rVar) {
                this();
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Filter$NaturalFilter;", "Lcom/iproov/sdk/IProov$Options$Filter;", "Lcom/iproov/sdk/IProov$NaturalStyle;", "component1", "style", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/IProov$NaturalStyle;", "getStyle", "()Lcom/iproov/sdk/IProov$NaturalStyle;", "setStyle", "(Lcom/iproov/sdk/IProov$NaturalStyle;)V", "<init>", "Defaults", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class NaturalFilter extends Filter {
                private NaturalStyle style;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Filter$NaturalFilter$Defaults;", "", "Lcom/iproov/sdk/IProov$NaturalStyle;", "style", "Lcom/iproov/sdk/IProov$NaturalStyle;", "getStyle", "()Lcom/iproov/sdk/IProov$NaturalStyle;", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
                public static final class Defaults {
                    public static final Defaults INSTANCE = new Defaults();
                    private static final NaturalStyle style = NaturalStyle.BLUR;

                    private Defaults() {
                    }

                    public final NaturalStyle getStyle() {
                        return style;
                    }
                }

                public NaturalFilter() {
                    this((NaturalStyle) null, 1, (r) null);
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ NaturalFilter(NaturalStyle naturalStyle, int i11, r rVar) {
                    this((i11 & 1) != 0 ? Defaults.INSTANCE.getStyle() : naturalStyle);
                }

                public static /* synthetic */ NaturalFilter copy$default(NaturalFilter naturalFilter, NaturalStyle naturalStyle, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        naturalStyle = naturalFilter.style;
                    }
                    return naturalFilter.copy(naturalStyle);
                }

                public final NaturalStyle component1() {
                    return this.style;
                }

                public final NaturalFilter copy(NaturalStyle naturalStyle) {
                    return new NaturalFilter(naturalStyle);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof NaturalFilter) && this.style == ((NaturalFilter) obj).style;
                }

                public final NaturalStyle getStyle() {
                    return this.style;
                }

                public int hashCode() {
                    return this.style.hashCode();
                }

                public final void setStyle(NaturalStyle naturalStyle) {
                    this.style = naturalStyle;
                }

                public String toString() {
                    return "NaturalFilter(style=" + this.style + ')';
                }

                public NaturalFilter(NaturalStyle naturalStyle) {
                    super((r) null);
                    this.style = naturalStyle;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001:\u0001 B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0003\u0010\b\u001a\u00020\u0004\u0012\b\b\u0003\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u00042\b\b\u0003\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Filter$LineDrawingFilter;", "Lcom/iproov/sdk/IProov$Options$Filter;", "Lcom/iproov/sdk/IProov$LineDrawingStyle;", "component1", "", "component2", "component3", "style", "foregroundColor", "backgroundColor", "copy", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/IProov$LineDrawingStyle;", "getStyle", "()Lcom/iproov/sdk/IProov$LineDrawingStyle;", "setStyle", "(Lcom/iproov/sdk/IProov$LineDrawingStyle;)V", "I", "getForegroundColor", "()I", "setForegroundColor", "(I)V", "getBackgroundColor", "setBackgroundColor", "<init>", "(Lcom/iproov/sdk/IProov$LineDrawingStyle;II)V", "Defaults", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class LineDrawingFilter extends Filter {
                private int backgroundColor;
                private int foregroundColor;
                private LineDrawingStyle style;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Filter$LineDrawingFilter$Defaults;", "", "Lcom/iproov/sdk/IProov$LineDrawingStyle;", "style", "Lcom/iproov/sdk/IProov$LineDrawingStyle;", "getStyle", "()Lcom/iproov/sdk/IProov$LineDrawingStyle;", "", "foregroundColor", "I", "getForegroundColor", "()I", "backgroundColor", "getBackgroundColor", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
                public static final class Defaults {
                    public static final Defaults INSTANCE = new Defaults();
                    private static final int backgroundColor = Color.parseColor("#FAFAFA");
                    private static final int foregroundColor = Color.parseColor("#404040");
                    private static final LineDrawingStyle style = LineDrawingStyle.SHADED;

                    private Defaults() {
                    }

                    public final int getBackgroundColor() {
                        return backgroundColor;
                    }

                    public final int getForegroundColor() {
                        return foregroundColor;
                    }

                    public final LineDrawingStyle getStyle() {
                        return style;
                    }
                }

                public LineDrawingFilter() {
                    this((LineDrawingStyle) null, 0, 0, 7, (r) null);
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ LineDrawingFilter(LineDrawingStyle lineDrawingStyle, int i11, int i12, int i13, r rVar) {
                    this((i13 & 1) != 0 ? Defaults.INSTANCE.getStyle() : lineDrawingStyle, (i13 & 2) != 0 ? Defaults.INSTANCE.getForegroundColor() : i11, (i13 & 4) != 0 ? Defaults.INSTANCE.getBackgroundColor() : i12);
                }

                public static /* synthetic */ LineDrawingFilter copy$default(LineDrawingFilter lineDrawingFilter, LineDrawingStyle lineDrawingStyle, int i11, int i12, int i13, Object obj) {
                    if ((i13 & 1) != 0) {
                        lineDrawingStyle = lineDrawingFilter.style;
                    }
                    if ((i13 & 2) != 0) {
                        i11 = lineDrawingFilter.foregroundColor;
                    }
                    if ((i13 & 4) != 0) {
                        i12 = lineDrawingFilter.backgroundColor;
                    }
                    return lineDrawingFilter.copy(lineDrawingStyle, i11, i12);
                }

                public final LineDrawingStyle component1() {
                    return this.style;
                }

                public final int component2() {
                    return this.foregroundColor;
                }

                public final int component3() {
                    return this.backgroundColor;
                }

                public final LineDrawingFilter copy(LineDrawingStyle lineDrawingStyle, int i11, int i12) {
                    return new LineDrawingFilter(lineDrawingStyle, i11, i12);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof LineDrawingFilter)) {
                        return false;
                    }
                    LineDrawingFilter lineDrawingFilter = (LineDrawingFilter) obj;
                    return this.style == lineDrawingFilter.style && this.foregroundColor == lineDrawingFilter.foregroundColor && this.backgroundColor == lineDrawingFilter.backgroundColor;
                }

                public final int getBackgroundColor() {
                    return this.backgroundColor;
                }

                public final int getForegroundColor() {
                    return this.foregroundColor;
                }

                public final LineDrawingStyle getStyle() {
                    return this.style;
                }

                public int hashCode() {
                    return (((this.style.hashCode() * 31) + this.foregroundColor) * 31) + this.backgroundColor;
                }

                public final void setBackgroundColor(int i11) {
                    this.backgroundColor = i11;
                }

                public final void setForegroundColor(int i11) {
                    this.foregroundColor = i11;
                }

                public final void setStyle(LineDrawingStyle lineDrawingStyle) {
                    this.style = lineDrawingStyle;
                }

                public String toString() {
                    return "LineDrawingFilter(style=" + this.style + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ')';
                }

                public LineDrawingFilter(LineDrawingStyle lineDrawingStyle, int i11, int i12) {
                    super((r) null);
                    this.style = lineDrawingStyle;
                    this.foregroundColor = i11;
                    this.backgroundColor = i12;
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Font;", "", "<init>", "()V", "PathFont", "ResourceFont", "Lcom/iproov/sdk/IProov$Options$Font$PathFont;", "Lcom/iproov/sdk/IProov$Options$Font$ResourceFont;", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static abstract class Font {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0006\u001a\u00020\u0002HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Font$PathFont;", "Lcom/iproov/sdk/IProov$Options$Font;", "", "component1", "path", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class PathFont extends Font {
                private final String path;

                public PathFont(String str) {
                    super((r) null);
                    this.path = str;
                }

                public static /* synthetic */ PathFont copy$default(PathFont pathFont, String str, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = pathFont.path;
                    }
                    return pathFont.copy(str);
                }

                public final String component1() {
                    return this.path;
                }

                public final PathFont copy(String str) {
                    return new PathFont(str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof PathFont) && x.b(this.path, ((PathFont) obj).path);
                }

                public final String getPath() {
                    return this.path;
                }

                public int hashCode() {
                    return this.path.hashCode();
                }

                public String toString() {
                    return "PathFont(path=" + this.path + ')';
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0003\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Font$ResourceFont;", "Lcom/iproov/sdk/IProov$Options$Font;", "", "component1", "pathID", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getPathID", "()I", "<init>", "(I)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class ResourceFont extends Font {
                private final int pathID;

                public ResourceFont(int i11) {
                    super((r) null);
                    this.pathID = i11;
                }

                public static /* synthetic */ ResourceFont copy$default(ResourceFont resourceFont, int i11, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        i11 = resourceFont.pathID;
                    }
                    return resourceFont.copy(i11);
                }

                public final int component1() {
                    return this.pathID;
                }

                public final ResourceFont copy(int i11) {
                    return new ResourceFont(i11);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof ResourceFont) && this.pathID == ((ResourceFont) obj).pathID;
                }

                public final int getPathID() {
                    return this.pathID;
                }

                public int hashCode() {
                    return this.pathID;
                }

                public String toString() {
                    return "ResourceFont(pathID=" + this.pathID + ')';
                }
            }

            private Font() {
            }

            public /* synthetic */ Font(r rVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Icon;", "", "<init>", "()V", "BitmapIcon", "DrawableIcon", "ResourceIcon", "Lcom/iproov/sdk/IProov$Options$Icon$BitmapIcon;", "Lcom/iproov/sdk/IProov$Options$Icon$DrawableIcon;", "Lcom/iproov/sdk/IProov$Options$Icon$ResourceIcon;", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static abstract class Icon {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Icon$BitmapIcon;", "Lcom/iproov/sdk/IProov$Options$Icon;", "Landroid/graphics/Bitmap;", "component1", "imageBitmap", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/graphics/Bitmap;", "getImageBitmap", "()Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class BitmapIcon extends Icon {
                private final Bitmap imageBitmap;

                public BitmapIcon(Bitmap bitmap) {
                    super((r) null);
                    this.imageBitmap = bitmap;
                }

                public static /* synthetic */ BitmapIcon copy$default(BitmapIcon bitmapIcon, Bitmap bitmap, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        bitmap = bitmapIcon.imageBitmap;
                    }
                    return bitmapIcon.copy(bitmap);
                }

                public final Bitmap component1() {
                    return this.imageBitmap;
                }

                public final BitmapIcon copy(Bitmap bitmap) {
                    return new BitmapIcon(bitmap);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof BitmapIcon) && x.b(this.imageBitmap, ((BitmapIcon) obj).imageBitmap);
                }

                public final Bitmap getImageBitmap() {
                    return this.imageBitmap;
                }

                public int hashCode() {
                    return this.imageBitmap.hashCode();
                }

                public String toString() {
                    return "BitmapIcon(imageBitmap=" + this.imageBitmap + ')';
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Icon$DrawableIcon;", "Lcom/iproov/sdk/IProov$Options$Icon;", "Landroid/graphics/drawable/Drawable;", "component1", "imageDrawable", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/graphics/drawable/Drawable;", "getImageDrawable", "()Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class DrawableIcon extends Icon {
                private final Drawable imageDrawable;

                public DrawableIcon(Drawable drawable) {
                    super((r) null);
                    this.imageDrawable = drawable;
                }

                public static /* synthetic */ DrawableIcon copy$default(DrawableIcon drawableIcon, Drawable drawable, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        drawable = drawableIcon.imageDrawable;
                    }
                    return drawableIcon.copy(drawable);
                }

                public final Drawable component1() {
                    return this.imageDrawable;
                }

                public final DrawableIcon copy(Drawable drawable) {
                    return new DrawableIcon(drawable);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof DrawableIcon) && x.b(this.imageDrawable, ((DrawableIcon) obj).imageDrawable);
                }

                public final Drawable getImageDrawable() {
                    return this.imageDrawable;
                }

                public int hashCode() {
                    return this.imageDrawable.hashCode();
                }

                public String toString() {
                    return "DrawableIcon(imageDrawable=" + this.imageDrawable + ')';
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0003\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/iproov/sdk/IProov$Options$Icon$ResourceIcon;", "Lcom/iproov/sdk/IProov$Options$Icon;", "", "component1", "imageID", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getImageID", "()I", "<init>", "(I)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class ResourceIcon extends Icon {
                private final int imageID;

                public ResourceIcon(int i11) {
                    super((r) null);
                    this.imageID = i11;
                }

                public static /* synthetic */ ResourceIcon copy$default(ResourceIcon resourceIcon, int i11, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        i11 = resourceIcon.imageID;
                    }
                    return resourceIcon.copy(i11);
                }

                public final int component1() {
                    return this.imageID;
                }

                public final ResourceIcon copy(int i11) {
                    return new ResourceIcon(i11);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof ResourceIcon) && this.imageID == ((ResourceIcon) obj).imageID;
                }

                public final int getImageID() {
                    return this.imageID;
                }

                public int hashCode() {
                    return this.imageID;
                }

                public String toString() {
                    return "ResourceIcon(imageID=" + this.imageID + ')';
                }
            }

            private Icon() {
            }

            public /* synthetic */ Icon(r rVar) {
                this();
            }
        }

        public Options() {
            this((String) null, 0, 0, (Filter) null, 0, (Font) null, (Icon) null, false, (CloseButton) null, 0, 0, false, false, (List) null, 0, (Orientation) null, (Camera) null, (FaceDetector) null, (GenuinePresenceAssurance) null, (LivenessAssurance) null, 1048575, (r) null);
        }

        public Options(String str, int i11, int i12, Filter filter2, int i13, Font font2, Icon icon, boolean z11, CloseButton closeButton2, int i14, int i15, boolean z12, boolean z13, List<? extends Certificate> list, int i16, Orientation orientation2, Camera camera2, FaceDetector faceDetector2, GenuinePresenceAssurance genuinePresenceAssurance2, LivenessAssurance livenessAssurance2) {
            this.title = str;
            this.titleTextColor = i11;
            this.headerBackgroundColor = i12;
            this.filter = filter2;
            this.surroundColor = i13;
            this.font = font2;
            this.logo = icon;
            this.enableScreenshots = z11;
            this.closeButton = closeButton2;
            this.promptTextColor = i14;
            this.promptBackgroundColor = i15;
            this.promptRoundedCorners = z12;
            this.disableExteriorEffects = z13;
            this.certificates = list;
            this.timeoutSecs = i16;
            this.orientation = orientation2;
            this.camera = camera2;
            this.faceDetector = faceDetector2;
            this.genuinePresenceAssurance = genuinePresenceAssurance2;
            this.livenessAssurance = livenessAssurance2;
        }

        public static /* synthetic */ Options copy$default(Options options, String str, int i11, int i12, Filter filter2, int i13, Font font2, Icon icon, boolean z11, CloseButton closeButton2, int i14, int i15, boolean z12, boolean z13, List list, int i16, Orientation orientation2, Camera camera2, FaceDetector faceDetector2, GenuinePresenceAssurance genuinePresenceAssurance2, LivenessAssurance livenessAssurance2, int i17, Object obj) {
            Options options2 = options;
            int i18 = i17;
            return options.copy((i18 & 1) != 0 ? options2.title : str, (i18 & 2) != 0 ? options2.titleTextColor : i11, (i18 & 4) != 0 ? options2.headerBackgroundColor : i12, (i18 & 8) != 0 ? options2.filter : filter2, (i18 & 16) != 0 ? options2.surroundColor : i13, (i18 & 32) != 0 ? options2.font : font2, (i18 & 64) != 0 ? options2.logo : icon, (i18 & 128) != 0 ? options2.enableScreenshots : z11, (i18 & 256) != 0 ? options2.closeButton : closeButton2, (i18 & 512) != 0 ? options2.promptTextColor : i14, (i18 & 1024) != 0 ? options2.promptBackgroundColor : i15, (i18 & 2048) != 0 ? options2.promptRoundedCorners : z12, (i18 & 4096) != 0 ? options2.disableExteriorEffects : z13, (i18 & 8192) != 0 ? options2.certificates : list, (i18 & 16384) != 0 ? options2.timeoutSecs : i16, (i18 & 32768) != 0 ? options2.orientation : orientation2, (i18 & 65536) != 0 ? options2.camera : camera2, (i18 & 131072) != 0 ? options2.faceDetector : faceDetector2, (i18 & 262144) != 0 ? options2.genuinePresenceAssurance : genuinePresenceAssurance2, (i18 & 524288) != 0 ? options2.livenessAssurance : livenessAssurance2);
        }

        public static /* synthetic */ void getFaceDetector$annotations() {
        }

        public final String component1() {
            return this.title;
        }

        public final int component10() {
            return this.promptTextColor;
        }

        public final int component11() {
            return this.promptBackgroundColor;
        }

        public final boolean component12() {
            return this.promptRoundedCorners;
        }

        public final boolean component13() {
            return this.disableExteriorEffects;
        }

        public final List<Certificate> component14() {
            return this.certificates;
        }

        public final int component15() {
            return this.timeoutSecs;
        }

        public final Orientation component16() {
            return this.orientation;
        }

        public final Camera component17() {
            return this.camera;
        }

        public final FaceDetector component18() {
            return this.faceDetector;
        }

        public final GenuinePresenceAssurance component19() {
            return this.genuinePresenceAssurance;
        }

        public final int component2() {
            return this.titleTextColor;
        }

        public final LivenessAssurance component20() {
            return this.livenessAssurance;
        }

        public final int component3() {
            return this.headerBackgroundColor;
        }

        public final Filter component4() {
            return this.filter;
        }

        public final int component5() {
            return this.surroundColor;
        }

        public final Font component6() {
            return this.font;
        }

        public final Icon component7() {
            return this.logo;
        }

        public final boolean component8() {
            return this.enableScreenshots;
        }

        public final CloseButton component9() {
            return this.closeButton;
        }

        public final Options copy(String str, int i11, int i12, Filter filter2, int i13, Font font2, Icon icon, boolean z11, CloseButton closeButton2, int i14, int i15, boolean z12, boolean z13, List<? extends Certificate> list, int i16, Orientation orientation2, Camera camera2, FaceDetector faceDetector2, GenuinePresenceAssurance genuinePresenceAssurance2, LivenessAssurance livenessAssurance2) {
            return new Options(str, i11, i12, filter2, i13, font2, icon, z11, closeButton2, i14, i15, z12, z13, list, i16, orientation2, camera2, faceDetector2, genuinePresenceAssurance2, livenessAssurance2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Options)) {
                return false;
            }
            Options options = (Options) obj;
            return x.b(this.title, options.title) && this.titleTextColor == options.titleTextColor && this.headerBackgroundColor == options.headerBackgroundColor && x.b(this.filter, options.filter) && this.surroundColor == options.surroundColor && x.b(this.font, options.font) && x.b(this.logo, options.logo) && this.enableScreenshots == options.enableScreenshots && x.b(this.closeButton, options.closeButton) && this.promptTextColor == options.promptTextColor && this.promptBackgroundColor == options.promptBackgroundColor && this.promptRoundedCorners == options.promptRoundedCorners && this.disableExteriorEffects == options.disableExteriorEffects && x.b(this.certificates, options.certificates) && this.timeoutSecs == options.timeoutSecs && this.orientation == options.orientation && this.camera == options.camera && this.faceDetector == options.faceDetector && x.b(this.genuinePresenceAssurance, options.genuinePresenceAssurance) && x.b(this.livenessAssurance, options.livenessAssurance);
        }

        public final Camera getCamera() {
            return this.camera;
        }

        public final List<Certificate> getCertificates() {
            return this.certificates;
        }

        public final CloseButton getCloseButton() {
            return this.closeButton;
        }

        public final boolean getDisableExteriorEffects() {
            return this.disableExteriorEffects;
        }

        public final boolean getEnableScreenshots() {
            return this.enableScreenshots;
        }

        public final FaceDetector getFaceDetector() {
            return this.faceDetector;
        }

        public final Filter getFilter() {
            return this.filter;
        }

        public final Font getFont() {
            return this.font;
        }

        public final GenuinePresenceAssurance getGenuinePresenceAssurance() {
            return this.genuinePresenceAssurance;
        }

        public final int getHeaderBackgroundColor() {
            return this.headerBackgroundColor;
        }

        public final LivenessAssurance getLivenessAssurance() {
            return this.livenessAssurance;
        }

        public final Icon getLogo() {
            return this.logo;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final int getPromptBackgroundColor() {
            return this.promptBackgroundColor;
        }

        public final boolean getPromptRoundedCorners() {
            return this.promptRoundedCorners;
        }

        public final int getPromptTextColor() {
            return this.promptTextColor;
        }

        public final int getSurroundColor() {
            return this.surroundColor;
        }

        public final int getTimeoutSecs() {
            return this.timeoutSecs;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getTitleTextColor() {
            return this.titleTextColor;
        }

        public int hashCode() {
            int hashCode = ((((((((this.title.hashCode() * 31) + this.titleTextColor) * 31) + this.headerBackgroundColor) * 31) + this.filter.hashCode()) * 31) + this.surroundColor) * 31;
            Font font2 = this.font;
            int i11 = 0;
            int hashCode2 = (hashCode + (font2 == null ? 0 : font2.hashCode())) * 31;
            Icon icon = this.logo;
            if (icon != null) {
                i11 = icon.hashCode();
            }
            int i12 = (hashCode2 + i11) * 31;
            boolean z11 = this.enableScreenshots;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int hashCode3 = (((((((i12 + (z11 ? 1 : 0)) * 31) + this.closeButton.hashCode()) * 31) + this.promptTextColor) * 31) + this.promptBackgroundColor) * 31;
            boolean z13 = this.promptRoundedCorners;
            if (z13) {
                z13 = true;
            }
            int i13 = (hashCode3 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.disableExteriorEffects;
            if (!z14) {
                z12 = z14;
            }
            return ((((((((((((((i13 + (z12 ? 1 : 0)) * 31) + this.certificates.hashCode()) * 31) + this.timeoutSecs) * 31) + this.orientation.hashCode()) * 31) + this.camera.hashCode()) * 31) + this.faceDetector.hashCode()) * 31) + this.genuinePresenceAssurance.hashCode()) * 31) + this.livenessAssurance.hashCode();
        }

        public final void setCamera(Camera camera2) {
            this.camera = camera2;
        }

        public final void setCertificates(List<? extends Certificate> list) {
            this.certificates = list;
        }

        public final void setCloseButton(CloseButton closeButton2) {
            this.closeButton = closeButton2;
        }

        public final void setDisableExteriorEffects(boolean z11) {
            this.disableExteriorEffects = z11;
        }

        public final void setEnableScreenshots(boolean z11) {
            this.enableScreenshots = z11;
        }

        public final void setFaceDetector(FaceDetector faceDetector2) {
            this.faceDetector = faceDetector2;
        }

        public final void setFilter(Filter filter2) {
            this.filter = filter2;
        }

        public final void setFont(Font font2) {
            this.font = font2;
        }

        public final void setGenuinePresenceAssurance(GenuinePresenceAssurance genuinePresenceAssurance2) {
            this.genuinePresenceAssurance = genuinePresenceAssurance2;
        }

        public final void setHeaderBackgroundColor(int i11) {
            this.headerBackgroundColor = i11;
        }

        public final void setLivenessAssurance(LivenessAssurance livenessAssurance2) {
            this.livenessAssurance = livenessAssurance2;
        }

        public final void setLogo(Icon icon) {
            this.logo = icon;
        }

        public final void setOrientation(Orientation orientation2) {
            this.orientation = orientation2;
        }

        public final void setPromptBackgroundColor(int i11) {
            this.promptBackgroundColor = i11;
        }

        public final void setPromptRoundedCorners(boolean z11) {
            this.promptRoundedCorners = z11;
        }

        public final void setPromptTextColor(int i11) {
            this.promptTextColor = i11;
        }

        public final void setSurroundColor(int i11) {
            this.surroundColor = i11;
        }

        public final void setTimeoutSecs(int i11) {
            this.timeoutSecs = i11;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final void setTitleTextColor(int i11) {
            this.titleTextColor = i11;
        }

        public String toString() {
            return "Options(title=" + this.title + ", titleTextColor=" + this.titleTextColor + ", headerBackgroundColor=" + this.headerBackgroundColor + ", filter=" + this.filter + ", surroundColor=" + this.surroundColor + ", font=" + this.font + ", logo=" + this.logo + ", enableScreenshots=" + this.enableScreenshots + ", closeButton=" + this.closeButton + ", promptTextColor=" + this.promptTextColor + ", promptBackgroundColor=" + this.promptBackgroundColor + ", promptRoundedCorners=" + this.promptRoundedCorners + ", disableExteriorEffects=" + this.disableExteriorEffects + ", certificates=" + this.certificates + ", timeoutSecs=" + this.timeoutSecs + ", orientation=" + this.orientation + ", camera=" + this.camera + ", faceDetector=" + this.faceDetector + ", genuinePresenceAssurance=" + this.genuinePresenceAssurance + ", livenessAssurance=" + this.livenessAssurance + ')';
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/iproov/sdk/IProov$Options$CloseButton;", "", "Lcom/iproov/sdk/IProov$Options$Icon;", "component1", "", "component2", "icon", "colorTint", "copy", "", "toString", "hashCode", "other", "", "equals", "Lcom/iproov/sdk/IProov$Options$Icon;", "getIcon", "()Lcom/iproov/sdk/IProov$Options$Icon;", "setIcon", "(Lcom/iproov/sdk/IProov$Options$Icon;)V", "I", "getColorTint", "()I", "setColorTint", "(I)V", "<init>", "(Lcom/iproov/sdk/IProov$Options$Icon;I)V", "Defaults", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class CloseButton {
            private int colorTint;
            private Icon icon;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0007XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/iproov/sdk/IProov$Options$CloseButton$Defaults;", "", "Lcom/iproov/sdk/IProov$Options$Icon;", "icon", "Lcom/iproov/sdk/IProov$Options$Icon;", "getIcon", "()Lcom/iproov/sdk/IProov$Options$Icon;", "", "colorTint", "I", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class Defaults {
                public static final Defaults INSTANCE = new Defaults();
                public static final int colorTint = -1;
                private static final Icon icon = new Icon.ResourceIcon(R.drawable.ic_arrow_back);

                private Defaults() {
                }

                public final Icon getIcon() {
                    return icon;
                }
            }

            public CloseButton() {
                this((Icon) null, 0, 3, (r) null);
            }

            public CloseButton(Icon icon2, int i11) {
                this.icon = icon2;
                this.colorTint = i11;
            }

            public static /* synthetic */ CloseButton copy$default(CloseButton closeButton, Icon icon2, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    icon2 = closeButton.icon;
                }
                if ((i12 & 2) != 0) {
                    i11 = closeButton.colorTint;
                }
                return closeButton.copy(icon2, i11);
            }

            public final Icon component1() {
                return this.icon;
            }

            public final int component2() {
                return this.colorTint;
            }

            public final CloseButton copy(Icon icon2, int i11) {
                return new CloseButton(icon2, i11);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CloseButton)) {
                    return false;
                }
                CloseButton closeButton = (CloseButton) obj;
                return x.b(this.icon, closeButton.icon) && this.colorTint == closeButton.colorTint;
            }

            public final int getColorTint() {
                return this.colorTint;
            }

            public final Icon getIcon() {
                return this.icon;
            }

            public int hashCode() {
                return (this.icon.hashCode() * 31) + this.colorTint;
            }

            public final void setColorTint(int i11) {
                this.colorTint = i11;
            }

            public final void setIcon(Icon icon2) {
                this.icon = icon2;
            }

            public String toString() {
                return "CloseButton(icon=" + this.icon + ", colorTint=" + this.colorTint + ')';
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CloseButton(Icon icon2, int i11, int i12, r rVar) {
                this((i12 & 1) != 0 ? Defaults.INSTANCE.getIcon() : icon2, (i12 & 2) != 0 ? -1 : i11);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001b\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u00022\b\b\u0003\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProov$Options$LivenessAssurance;", "", "", "component1", "component2", "ovalStrokeColor", "completedOvalStrokeColor", "copy", "", "toString", "hashCode", "other", "", "equals", "I", "getOvalStrokeColor", "()I", "setOvalStrokeColor", "(I)V", "getCompletedOvalStrokeColor", "setCompletedOvalStrokeColor", "<init>", "(II)V", "Defaults", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class LivenessAssurance {
            private int completedOvalStrokeColor;
            private int ovalStrokeColor;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/iproov/sdk/IProov$Options$LivenessAssurance$Defaults;", "", "", "ovalStrokeColor", "I", "getOvalStrokeColor", "()I", "completedOvalStrokeColor", "getCompletedOvalStrokeColor", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class Defaults {
                public static final Defaults INSTANCE = new Defaults();
                private static final int completedOvalStrokeColor = Color.parseColor("#01AC41");
                private static final int ovalStrokeColor = -1;

                private Defaults() {
                }

                public final int getCompletedOvalStrokeColor() {
                    return completedOvalStrokeColor;
                }

                public final int getOvalStrokeColor() {
                    return ovalStrokeColor;
                }
            }

            public LivenessAssurance() {
                this(0, 0, 3, (r) null);
            }

            public LivenessAssurance(int i11, int i12) {
                this.ovalStrokeColor = i11;
                this.completedOvalStrokeColor = i12;
            }

            public static /* synthetic */ LivenessAssurance copy$default(LivenessAssurance livenessAssurance, int i11, int i12, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    i11 = livenessAssurance.ovalStrokeColor;
                }
                if ((i13 & 2) != 0) {
                    i12 = livenessAssurance.completedOvalStrokeColor;
                }
                return livenessAssurance.copy(i11, i12);
            }

            public final int component1() {
                return this.ovalStrokeColor;
            }

            public final int component2() {
                return this.completedOvalStrokeColor;
            }

            public final LivenessAssurance copy(int i11, int i12) {
                return new LivenessAssurance(i11, i12);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof LivenessAssurance)) {
                    return false;
                }
                LivenessAssurance livenessAssurance = (LivenessAssurance) obj;
                return this.ovalStrokeColor == livenessAssurance.ovalStrokeColor && this.completedOvalStrokeColor == livenessAssurance.completedOvalStrokeColor;
            }

            public final int getCompletedOvalStrokeColor() {
                return this.completedOvalStrokeColor;
            }

            public final int getOvalStrokeColor() {
                return this.ovalStrokeColor;
            }

            public int hashCode() {
                return (this.ovalStrokeColor * 31) + this.completedOvalStrokeColor;
            }

            public final void setCompletedOvalStrokeColor(int i11) {
                this.completedOvalStrokeColor = i11;
            }

            public final void setOvalStrokeColor(int i11) {
                this.ovalStrokeColor = i11;
            }

            public String toString() {
                return "LivenessAssurance(ovalStrokeColor=" + this.ovalStrokeColor + ", completedOvalStrokeColor=" + this.completedOvalStrokeColor + ')';
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ LivenessAssurance(int i11, int i12, int i13, r rVar) {
                this((i13 & 1) != 0 ? Defaults.INSTANCE.getOvalStrokeColor() : i11, (i13 & 2) != 0 ? Defaults.INSTANCE.getCompletedOvalStrokeColor() : i12);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001:\u0001'B9\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002\u0012\b\b\u0003\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\"\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u0006("}, d2 = {"Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance;", "", "", "component1", "component2", "", "component3", "component4", "component5", "readyOvalStrokeColor", "notReadyOvalStrokeColor", "maxPitch", "maxYaw", "maxRoll", "copy", "", "toString", "hashCode", "other", "", "equals", "I", "getReadyOvalStrokeColor", "()I", "setReadyOvalStrokeColor", "(I)V", "getNotReadyOvalStrokeColor", "setNotReadyOvalStrokeColor", "F", "getMaxPitch", "()F", "setMaxPitch", "(F)V", "getMaxYaw", "setMaxYaw", "getMaxRoll", "setMaxRoll", "<init>", "(IIFFF)V", "Defaults", "iproov_release"}, k = 1, mv = {1, 5, 1})
        public static final class GenuinePresenceAssurance {
            private float maxPitch;
            private float maxRoll;
            private float maxYaw;
            private int notReadyOvalStrokeColor;
            private int readyOvalStrokeColor;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007XT¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007XT¢\u0006\f\n\u0004\b\r\u0010\n\u0012\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007XT¢\u0006\f\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0010\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/iproov/sdk/IProov$Options$GenuinePresenceAssurance$Defaults;", "", "", "readyOvalStrokeColor", "I", "getReadyOvalStrokeColor", "()I", "notReadyOvalStrokeColor", "", "maxPitch", "F", "getMaxPitch$annotations", "()V", "maxYaw", "getMaxYaw$annotations", "maxRoll", "getMaxRoll$annotations", "<init>", "iproov_release"}, k = 1, mv = {1, 5, 1})
            public static final class Defaults {
                public static final Defaults INSTANCE = new Defaults();
                public static final float maxPitch = 0.25f;
                public static final float maxRoll = 0.25f;
                public static final float maxYaw = 0.25f;
                public static final int notReadyOvalStrokeColor = -1;
                private static final int readyOvalStrokeColor = Color.parseColor("#01AC41");

                private Defaults() {
                }

                public static /* synthetic */ void getMaxPitch$annotations() {
                }

                public static /* synthetic */ void getMaxRoll$annotations() {
                }

                public static /* synthetic */ void getMaxYaw$annotations() {
                }

                public final int getReadyOvalStrokeColor() {
                    return readyOvalStrokeColor;
                }
            }

            public GenuinePresenceAssurance() {
                this(0, 0, 0.0f, 0.0f, 0.0f, 31, (r) null);
            }

            public GenuinePresenceAssurance(int i11, int i12, float f11, float f12, float f13) {
                this.readyOvalStrokeColor = i11;
                this.notReadyOvalStrokeColor = i12;
                this.maxPitch = f11;
                this.maxYaw = f12;
                this.maxRoll = f13;
            }

            public static /* synthetic */ GenuinePresenceAssurance copy$default(GenuinePresenceAssurance genuinePresenceAssurance, int i11, int i12, float f11, float f12, float f13, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    i11 = genuinePresenceAssurance.readyOvalStrokeColor;
                }
                if ((i13 & 2) != 0) {
                    i12 = genuinePresenceAssurance.notReadyOvalStrokeColor;
                }
                int i14 = i12;
                if ((i13 & 4) != 0) {
                    f11 = genuinePresenceAssurance.maxPitch;
                }
                float f14 = f11;
                if ((i13 & 8) != 0) {
                    f12 = genuinePresenceAssurance.maxYaw;
                }
                float f15 = f12;
                if ((i13 & 16) != 0) {
                    f13 = genuinePresenceAssurance.maxRoll;
                }
                return genuinePresenceAssurance.copy(i11, i14, f14, f15, f13);
            }

            public final int component1() {
                return this.readyOvalStrokeColor;
            }

            public final int component2() {
                return this.notReadyOvalStrokeColor;
            }

            public final float component3() {
                return this.maxPitch;
            }

            public final float component4() {
                return this.maxYaw;
            }

            public final float component5() {
                return this.maxRoll;
            }

            public final GenuinePresenceAssurance copy(int i11, int i12, float f11, float f12, float f13) {
                return new GenuinePresenceAssurance(i11, i12, f11, f12, f13);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GenuinePresenceAssurance)) {
                    return false;
                }
                GenuinePresenceAssurance genuinePresenceAssurance = (GenuinePresenceAssurance) obj;
                return this.readyOvalStrokeColor == genuinePresenceAssurance.readyOvalStrokeColor && this.notReadyOvalStrokeColor == genuinePresenceAssurance.notReadyOvalStrokeColor && x.b(Float.valueOf(this.maxPitch), Float.valueOf(genuinePresenceAssurance.maxPitch)) && x.b(Float.valueOf(this.maxYaw), Float.valueOf(genuinePresenceAssurance.maxYaw)) && x.b(Float.valueOf(this.maxRoll), Float.valueOf(genuinePresenceAssurance.maxRoll));
            }

            public final float getMaxPitch() {
                return this.maxPitch;
            }

            public final float getMaxRoll() {
                return this.maxRoll;
            }

            public final float getMaxYaw() {
                return this.maxYaw;
            }

            public final int getNotReadyOvalStrokeColor() {
                return this.notReadyOvalStrokeColor;
            }

            public final int getReadyOvalStrokeColor() {
                return this.readyOvalStrokeColor;
            }

            public int hashCode() {
                return (((((((this.readyOvalStrokeColor * 31) + this.notReadyOvalStrokeColor) * 31) + Float.floatToIntBits(this.maxPitch)) * 31) + Float.floatToIntBits(this.maxYaw)) * 31) + Float.floatToIntBits(this.maxRoll);
            }

            public final void setMaxPitch(float f11) {
                this.maxPitch = f11;
            }

            public final void setMaxRoll(float f11) {
                this.maxRoll = f11;
            }

            public final void setMaxYaw(float f11) {
                this.maxYaw = f11;
            }

            public final void setNotReadyOvalStrokeColor(int i11) {
                this.notReadyOvalStrokeColor = i11;
            }

            public final void setReadyOvalStrokeColor(int i11) {
                this.readyOvalStrokeColor = i11;
            }

            public String toString() {
                return "GenuinePresenceAssurance(readyOvalStrokeColor=" + this.readyOvalStrokeColor + ", notReadyOvalStrokeColor=" + this.notReadyOvalStrokeColor + ", maxPitch=" + this.maxPitch + ", maxYaw=" + this.maxYaw + ", maxRoll=" + this.maxRoll + ')';
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ GenuinePresenceAssurance(int r4, int r5, float r6, float r7, float r8, int r9, kotlin.jvm.internal.r r10) {
                /*
                    r3 = this;
                    r10 = r9 & 1
                    if (r10 == 0) goto L_0x000a
                    com.iproov.sdk.IProov$Options$GenuinePresenceAssurance$Defaults r4 = com.iproov.sdk.IProov.Options.GenuinePresenceAssurance.Defaults.INSTANCE
                    int r4 = r4.getReadyOvalStrokeColor()
                L_0x000a:
                    r10 = r9 & 2
                    if (r10 == 0) goto L_0x000f
                    r5 = -1
                L_0x000f:
                    r10 = r5
                    r5 = r9 & 4
                    r0 = 1048576000(0x3e800000, float:0.25)
                    if (r5 == 0) goto L_0x0018
                    r1 = r0
                    goto L_0x0019
                L_0x0018:
                    r1 = r6
                L_0x0019:
                    r5 = r9 & 8
                    if (r5 == 0) goto L_0x001f
                    r2 = r0
                    goto L_0x0020
                L_0x001f:
                    r2 = r7
                L_0x0020:
                    r5 = r9 & 16
                    if (r5 == 0) goto L_0x0025
                    goto L_0x0026
                L_0x0025:
                    r0 = r8
                L_0x0026:
                    r5 = r3
                    r6 = r4
                    r7 = r10
                    r8 = r1
                    r9 = r2
                    r10 = r0
                    r5.<init>(r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProov.Options.GenuinePresenceAssurance.<init>(int, int, float, float, float, int, kotlin.jvm.internal.r):void");
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Options(java.lang.String r22, int r23, int r24, com.iproov.sdk.IProov.Options.Filter r25, int r26, com.iproov.sdk.IProov.Options.Font r27, com.iproov.sdk.IProov.Options.Icon r28, boolean r29, com.iproov.sdk.IProov.Options.CloseButton r30, int r31, int r32, boolean r33, boolean r34, java.util.List r35, int r36, com.iproov.sdk.IProov.Orientation r37, com.iproov.sdk.IProov.Camera r38, com.iproov.sdk.IProov.FaceDetector r39, com.iproov.sdk.IProov.Options.GenuinePresenceAssurance r40, com.iproov.sdk.IProov.Options.LivenessAssurance r41, int r42, kotlin.jvm.internal.r r43) {
            /*
                r21 = this;
                r0 = r42
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0009
                java.lang.String r1 = ""
                goto L_0x000b
            L_0x0009:
                r1 = r22
            L_0x000b:
                r2 = r0 & 2
                r3 = -1
                if (r2 == 0) goto L_0x0012
                r2 = r3
                goto L_0x0014
            L_0x0012:
                r2 = r23
            L_0x0014:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x001f
                com.iproov.sdk.IProov$Options$Defaults r4 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                int r4 = r4.getHeaderBackgroundColor()
                goto L_0x0021
            L_0x001f:
                r4 = r24
            L_0x0021:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x002c
                com.iproov.sdk.IProov$Options$Defaults r5 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Options$Filter$LineDrawingFilter r5 = r5.getFilter()
                goto L_0x002e
            L_0x002c:
                r5 = r25
            L_0x002e:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0039
                com.iproov.sdk.IProov$Options$Defaults r6 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                int r6 = r6.getSurroundColor()
                goto L_0x003b
            L_0x0039:
                r6 = r26
            L_0x003b:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0046
                com.iproov.sdk.IProov$Options$Defaults r7 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Options$Font r7 = r7.getFont()
                goto L_0x0048
            L_0x0046:
                r7 = r27
            L_0x0048:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0053
                com.iproov.sdk.IProov$Options$Defaults r8 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Options$Icon r8 = r8.getLogo()
                goto L_0x0055
            L_0x0053:
                r8 = r28
            L_0x0055:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x005b
                r9 = 0
                goto L_0x005d
            L_0x005b:
                r9 = r29
            L_0x005d:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0068
                com.iproov.sdk.IProov$Options$Defaults r10 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Options$CloseButton r10 = r10.getCloseButton()
                goto L_0x006a
            L_0x0068:
                r10 = r30
            L_0x006a:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x006f
                goto L_0x0071
            L_0x006f:
                r3 = r31
            L_0x0071:
                r11 = r0 & 1024(0x400, float:1.435E-42)
                if (r11 == 0) goto L_0x007c
                com.iproov.sdk.IProov$Options$Defaults r11 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                int r11 = r11.getPromptBackgroundColor()
                goto L_0x007e
            L_0x007c:
                r11 = r32
            L_0x007e:
                r12 = r0 & 2048(0x800, float:2.87E-42)
                if (r12 == 0) goto L_0x0084
                r12 = 1
                goto L_0x0086
            L_0x0084:
                r12 = r33
            L_0x0086:
                r13 = r0 & 4096(0x1000, float:5.74E-42)
                if (r13 == 0) goto L_0x0091
                com.iproov.sdk.IProov$Options$Defaults r13 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                boolean r13 = r13.getDisableExteriorEffects()
                goto L_0x0093
            L_0x0091:
                r13 = r34
            L_0x0093:
                r14 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r14 == 0) goto L_0x009e
                com.iproov.sdk.IProov$Options$Defaults r14 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                java.util.List r14 = r14.getCertificates()
                goto L_0x00a0
            L_0x009e:
                r14 = r35
            L_0x00a0:
                r15 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r15 == 0) goto L_0x00a7
                r15 = 10
                goto L_0x00a9
            L_0x00a7:
                r15 = r36
            L_0x00a9:
                r16 = 32768(0x8000, float:4.5918E-41)
                r16 = r0 & r16
                if (r16 == 0) goto L_0x00b7
                com.iproov.sdk.IProov$Options$Defaults r16 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Orientation r16 = r16.getOrientation()
                goto L_0x00b9
            L_0x00b7:
                r16 = r37
            L_0x00b9:
                r17 = 65536(0x10000, float:9.18355E-41)
                r17 = r0 & r17
                if (r17 == 0) goto L_0x00c6
                com.iproov.sdk.IProov$Options$Defaults r17 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Camera r17 = r17.getCamera()
                goto L_0x00c8
            L_0x00c6:
                r17 = r38
            L_0x00c8:
                r18 = 131072(0x20000, float:1.83671E-40)
                r18 = r0 & r18
                if (r18 == 0) goto L_0x00d5
                com.iproov.sdk.IProov$Options$Defaults r18 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$FaceDetector r18 = r18.getFaceDetector()
                goto L_0x00d7
            L_0x00d5:
                r18 = r39
            L_0x00d7:
                r19 = 262144(0x40000, float:3.67342E-40)
                r19 = r0 & r19
                if (r19 == 0) goto L_0x00e4
                com.iproov.sdk.IProov$Options$Defaults r19 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Options$GenuinePresenceAssurance r19 = r19.getGenuinePresenceAssurance()
                goto L_0x00e6
            L_0x00e4:
                r19 = r40
            L_0x00e6:
                r20 = 524288(0x80000, float:7.34684E-40)
                r0 = r0 & r20
                if (r0 == 0) goto L_0x00f3
                com.iproov.sdk.IProov$Options$Defaults r0 = com.iproov.sdk.IProov.Options.Defaults.INSTANCE
                com.iproov.sdk.IProov$Options$LivenessAssurance r0 = r0.getLivenessAssurance()
                goto L_0x00f5
            L_0x00f3:
                r0 = r41
            L_0x00f5:
                r22 = r21
                r23 = r1
                r24 = r2
                r25 = r4
                r26 = r5
                r27 = r6
                r28 = r7
                r29 = r8
                r30 = r9
                r31 = r10
                r32 = r3
                r33 = r11
                r34 = r12
                r35 = r13
                r36 = r14
                r37 = r15
                r38 = r16
                r39 = r17
                r40 = r18
                r41 = r19
                r42 = r0
                r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProov.Options.<init>(java.lang.String, int, int, com.iproov.sdk.IProov$Options$Filter, int, com.iproov.sdk.IProov$Options$Font, com.iproov.sdk.IProov$Options$Icon, boolean, com.iproov.sdk.IProov$Options$CloseButton, int, int, boolean, boolean, java.util.List, int, com.iproov.sdk.IProov$Orientation, com.iproov.sdk.IProov$Camera, com.iproov.sdk.IProov$FaceDetector, com.iproov.sdk.IProov$Options$GenuinePresenceAssurance, com.iproov.sdk.IProov$Options$LivenessAssurance, int, kotlin.jvm.internal.r):void");
        }
    }
}
