package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageDownload f67150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f67151c;

    public /* synthetic */ w(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        this.f67150b = imageDownload;
        this.f67151c = taskCompletionSource;
    }

    public final void run() {
        this.f67150b.lambda$start$0(this.f67151c);
    }
}
