package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class s implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f66889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f66890b;

    public /* synthetic */ s(ac acVar, TaskCompletionSource taskCompletionSource) {
        this.f66889a = acVar;
        this.f66890b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.f66889a.u(this.f66890b, task);
    }
}
