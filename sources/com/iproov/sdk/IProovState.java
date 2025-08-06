package com.iproov.sdk;

import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.p009do.Cdo;
import com.iproov.sdk.p009do.Cif;
import com.iproov.sdk.p009do.Cthis;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProovState;", "", "", "toString", "", "isFinal", "Z", "()Z", "<init>", "(Z)V", "Cancelled", "Connected", "Connecting", "Error", "Failure", "Processing", "Success", "Lcom/iproov/sdk/IProovState$Connecting;", "Lcom/iproov/sdk/IProovState$Connected;", "Lcom/iproov/sdk/IProovState$Processing;", "Lcom/iproov/sdk/IProovState$Success;", "Lcom/iproov/sdk/IProovState$Failure;", "Lcom/iproov/sdk/IProovState$Cancelled;", "Lcom/iproov/sdk/IProovState$Error;", "iproov_release"}, k = 1, mv = {1, 5, 1})
public abstract class IProovState {
    private final boolean isFinal;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProovState$Cancelled;", "Lcom/iproov/sdk/IProovState;", "Lcom/iproov/sdk/if;", "component1", "canceller", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/if;", "getCanceller", "()Lcom/iproov/sdk/if;", "<init>", "(Lcom/iproov/sdk/if;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class Cancelled extends IProovState {
        private final Cif canceller;

        public Cancelled(Cif ifVar) {
            super(true, (r) null);
            this.canceller = ifVar;
        }

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, Cif ifVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                ifVar = cancelled.canceller;
            }
            return cancelled.copy(ifVar);
        }

        public final Cif component1() {
            return this.canceller;
        }

        public final Cancelled copy(Cif ifVar) {
            return new Cancelled(ifVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cancelled) && this.canceller == ((Cancelled) obj).canceller;
        }

        public final Cif getCanceller() {
            return this.canceller;
        }

        public int hashCode() {
            return this.canceller.hashCode();
        }

        public String toString() {
            return "Cancelled(canceller=" + this.canceller + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iproov/sdk/IProovState$Connected;", "Lcom/iproov/sdk/IProovState;", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class Connected extends IProovState {
        public static final Connected INSTANCE = new Connected();

        private Connected() {
            super(false, (r) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iproov/sdk/IProovState$Connecting;", "Lcom/iproov/sdk/IProovState;", "<init>", "()V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class Connecting extends IProovState {
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super(false, (r) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProovState$Error;", "Lcom/iproov/sdk/IProovState;", "", "toString", "Lcom/iproov/sdk/core/exception/IProovException;", "component1", "exception", "copy", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/core/exception/IProovException;", "getException", "()Lcom/iproov/sdk/core/exception/IProovException;", "<init>", "(Lcom/iproov/sdk/core/exception/IProovException;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
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
            return IProovState.super.toString() + ' ' + Cdo.m565do(this.exception);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProovState$Failure;", "Lcom/iproov/sdk/IProovState;", "", "toString", "Lcom/iproov/sdk/do/if;", "component1", "failureResult", "copy", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/do/if;", "getFailureResult", "()Lcom/iproov/sdk/do/if;", "<init>", "(Lcom/iproov/sdk/do/if;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class Failure extends IProovState {
        private final Cif failureResult;

        public Failure(Cif ifVar) {
            super(true, (r) null);
            this.failureResult = ifVar;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, Cif ifVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                ifVar = failure.failureResult;
            }
            return failure.copy(ifVar);
        }

        public final Cif component1() {
            return this.failureResult;
        }

        public final Failure copy(Cif ifVar) {
            return new Failure(ifVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && x.b(this.failureResult, ((Failure) obj).failureResult);
        }

        public final Cif getFailureResult() {
            return this.failureResult;
        }

        public int hashCode() {
            return this.failureResult.hashCode();
        }

        public String toString() {
            return IProovState.super.toString() + ' ' + IProovStateKt.toLoggable(this.failureResult);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProovState$Processing;", "Lcom/iproov/sdk/IProovState;", "", "toString", "", "component1", "component2", "progress", "message", "copy", "", "hashCode", "", "other", "", "equals", "D", "getProgress", "()D", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(DLjava/lang/String;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
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
            return IProovState.super.toString() + ' ' + Cdo.m564do(this.progress) + ' ' + this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iproov/sdk/IProovState$Success;", "Lcom/iproov/sdk/IProovState;", "Lcom/iproov/sdk/do/this;", "component1", "successResult", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/iproov/sdk/do/this;", "getSuccessResult", "()Lcom/iproov/sdk/do/this;", "<init>", "(Lcom/iproov/sdk/do/this;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
    public static final class Success extends IProovState {
        private final Cthis successResult;

        public Success(Cthis thisR) {
            super(true, (r) null);
            this.successResult = thisR;
        }

        public static /* synthetic */ Success copy$default(Success success, Cthis thisR, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                thisR = success.successResult;
            }
            return success.copy(thisR);
        }

        public final Cthis component1() {
            return this.successResult;
        }

        public final Success copy(Cthis thisR) {
            return new Success(thisR);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && x.b(this.successResult, ((Success) obj).successResult);
        }

        public final Cthis getSuccessResult() {
            return this.successResult;
        }

        public int hashCode() {
            return this.successResult.hashCode();
        }

        public String toString() {
            return "Success(successResult=" + this.successResult + ')';
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
