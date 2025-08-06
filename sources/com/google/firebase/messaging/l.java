package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class l implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f67136a;

    public /* synthetic */ l(String str) {
        this.f67136a = str;
    }

    public final Task then(Object obj) {
        return ((TopicsSubscriber) obj).subscribeToTopic(this.f67136a);
    }
}
