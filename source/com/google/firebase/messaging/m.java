package com.google.firebase.messaging;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

public final /* synthetic */ class m implements FirebaseInstanceIdInternal.NewTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67137a;

    public /* synthetic */ m(FirebaseMessaging firebaseMessaging) {
        this.f67137a = firebaseMessaging;
    }

    public final void onNewToken(String str) {
        this.f67137a.lambda$new$0(str);
    }
}
