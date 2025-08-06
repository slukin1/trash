package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class c implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f67116a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f67117b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f67118c;

    public /* synthetic */ c(Context context, Intent intent, boolean z11) {
        this.f67116a = context;
        this.f67117b = intent;
        this.f67118c = z11;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f67116a, this.f67117b, this.f67118c, task);
    }
}
