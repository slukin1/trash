package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class e implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e f67122a = new e();

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$1(task);
    }
}
