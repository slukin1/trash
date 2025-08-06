package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"com/google/firebase/sessions/FirebaseSessions$sessionInitiateListener$1", "Lcom/google/firebase/sessions/SessionInitiateListener;", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "", "onInitiateSession", "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/c;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class FirebaseSessions$sessionInitiateListener$1 implements SessionInitiateListener {
    public final /* synthetic */ FirebaseSessions this$0;

    public FirebaseSessions$sessionInitiateListener$1(FirebaseSessions firebaseSessions) {
        this.this$0 = firebaseSessions;
    }

    public Object onInitiateSession(SessionDetails sessionDetails, c<? super Unit> cVar) {
        Object access$initiateSessionStart = this.this$0.initiateSessionStart(sessionDetails, cVar);
        return access$initiateSessionStart == IntrinsicsKt__IntrinsicsKt.d() ? access$initiateSessionStart : Unit.f56620a;
    }
}
