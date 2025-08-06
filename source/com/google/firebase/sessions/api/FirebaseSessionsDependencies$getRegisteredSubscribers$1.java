package com.google.firebase.sessions.api;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", f = "FirebaseSessionsDependencies.kt", l = {107}, m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FirebaseSessionsDependencies this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, c<? super FirebaseSessionsDependencies$getRegisteredSubscribers$1> cVar) {
        super(cVar);
        this.this$0 = firebaseSessionsDependencies;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
    }
}
