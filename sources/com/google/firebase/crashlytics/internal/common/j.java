package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class j implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f67059a;

    public /* synthetic */ j(CountDownLatch countDownLatch) {
        this.f67059a = countDownLatch;
    }

    public final Object then(Task task) {
        return this.f67059a.countDown();
    }
}
