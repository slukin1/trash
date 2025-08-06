package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class g implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67056a;

    public /* synthetic */ g(TaskCompletionSource taskCompletionSource) {
        this.f67056a = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Utils.lambda$race$1(this.f67056a, task);
    }
}
