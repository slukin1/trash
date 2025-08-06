package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class b0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f67111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f67112c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f67113d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Metadata f67114e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f67115f;

    public /* synthetic */ b0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.f67111b = context;
        this.f67112c = scheduledExecutorService;
        this.f67113d = firebaseMessaging;
        this.f67114e = metadata;
        this.f67115f = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0(this.f67111b, this.f67112c, this.f67113d, this.f67114e, this.f67115f);
    }
}
