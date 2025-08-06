package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f67105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f67106b;

    public /* synthetic */ a(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f67105a = enhancedIntentService;
        this.f67106b = intent;
    }

    public final void onComplete(Task task) {
        this.f67105a.lambda$onStartCommand$1(this.f67106b, task);
    }
}
