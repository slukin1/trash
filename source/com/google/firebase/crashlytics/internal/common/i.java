package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class i implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67058a;

    public /* synthetic */ i(TaskCompletionSource taskCompletionSource) {
        this.f67058a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$callTask$2(this.f67058a, task);
    }
}
