package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class j implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67132a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f67133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f67134c;

    public /* synthetic */ j(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f67132a = firebaseMessaging;
        this.f67133b = str;
        this.f67134c = token;
    }

    public final Task then(Object obj) {
        return this.f67132a.lambda$blockingGetToken$9(this.f67133b, this.f67134c, (String) obj);
    }
}
