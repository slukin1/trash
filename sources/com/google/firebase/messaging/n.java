package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class n implements RequestDeduplicator.GetTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67138a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f67139b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f67140c;

    public /* synthetic */ n(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f67138a = firebaseMessaging;
        this.f67139b = str;
        this.f67140c = token;
    }

    public final Task start() {
        return this.f67138a.lambda$blockingGetToken$10(this.f67139b, this.f67140c);
    }
}
