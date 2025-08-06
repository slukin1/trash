package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class d implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f67120a = new d();

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$bindToMessagingService$3(task);
    }
}
