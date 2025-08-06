package com.google.firebase.sessions;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.google.firebase.sessions.SessionInitiator$initiateSession$1", f = "SessionInitiator.kt", l = {63}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SessionInitiator$initiateSession$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ SessionDetails $sessionDetails;
    public int label;
    public final /* synthetic */ SessionInitiator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SessionInitiator$initiateSession$1(SessionInitiator sessionInitiator, SessionDetails sessionDetails, c<? super SessionInitiator$initiateSession$1> cVar) {
        super(2, cVar);
        this.this$0 = sessionInitiator;
        this.$sessionDetails = sessionDetails;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SessionInitiator$initiateSession$1(this.this$0, this.$sessionDetails, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SessionInitiator$initiateSession$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            SessionInitiateListener access$getSessionInitiateListener$p = this.this$0.sessionInitiateListener;
            SessionDetails sessionDetails = this.$sessionDetails;
            this.label = 1;
            if (access$getSessionInitiateListener$p.onInitiateSession(sessionDetails, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
