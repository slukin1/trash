package com.iproov.sdk;

import com.iproov.sdk.p009do.Ccase;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iproov/sdk/IProovSessionState;", "", "Lcom/iproov/sdk/do/case;", "component1", "Lcom/iproov/sdk/IProovState;", "component2", "session", "state", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/iproov/sdk/IProovState;", "getState", "()Lcom/iproov/sdk/IProovState;", "Lcom/iproov/sdk/do/case;", "getSession", "()Lcom/iproov/sdk/do/case;", "<init>", "(Lcom/iproov/sdk/do/case;Lcom/iproov/sdk/IProovState;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
public final class IProovSessionState {
    private final Ccase session;
    private final IProovState state;

    public IProovSessionState(Ccase caseR, IProovState iProovState) {
        this.session = caseR;
        this.state = iProovState;
    }

    public static /* synthetic */ IProovSessionState copy$default(IProovSessionState iProovSessionState, Ccase caseR, IProovState iProovState, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            caseR = iProovSessionState.session;
        }
        if ((i11 & 2) != 0) {
            iProovState = iProovSessionState.state;
        }
        return iProovSessionState.copy(caseR, iProovState);
    }

    public final Ccase component1() {
        return this.session;
    }

    public final IProovState component2() {
        return this.state;
    }

    public final IProovSessionState copy(Ccase caseR, IProovState iProovState) {
        return new IProovSessionState(caseR, iProovState);
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

    public final Ccase getSession() {
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
