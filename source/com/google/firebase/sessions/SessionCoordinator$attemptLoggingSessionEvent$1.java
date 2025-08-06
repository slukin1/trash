package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.google.firebase.sessions.SessionCoordinator", f = "SessionCoordinator.kt", l = {36}, m = "attemptLoggingSessionEvent")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SessionCoordinator$attemptLoggingSessionEvent$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SessionCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SessionCoordinator$attemptLoggingSessionEvent$1(SessionCoordinator sessionCoordinator, c<? super SessionCoordinator$attemptLoggingSessionEvent$1> cVar) {
        super(cVar);
        this.this$0 = sessionCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.attemptLoggingSessionEvent((SessionEvent) null, this);
    }
}
