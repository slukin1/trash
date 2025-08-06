package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

public final /* synthetic */ class ak implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ al f66788a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StandardIntegrityManager.PrepareIntegrityTokenRequest f66789b;

    public /* synthetic */ ak(al alVar, StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        this.f66788a = alVar;
        this.f66789b = prepareIntegrityTokenRequest;
    }

    public final Task then(Object obj) {
        return this.f66788a.a(this.f66789b, (Long) obj);
    }
}
