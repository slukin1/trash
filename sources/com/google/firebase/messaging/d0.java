package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class d0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f67121a;

    public /* synthetic */ d0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f67121a = bindRequest;
    }

    public final void onComplete(Task task) {
        this.f67121a.finish();
    }
}
