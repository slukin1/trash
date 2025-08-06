package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class h implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67129a;

    public /* synthetic */ h(FirebaseMessaging firebaseMessaging) {
        this.f67129a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        this.f67129a.lambda$new$2((TopicsSubscriber) obj);
    }
}
