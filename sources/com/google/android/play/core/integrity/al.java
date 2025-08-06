package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.StandardIntegrityManager;

final class al implements StandardIntegrityManager {

    /* renamed from: a  reason: collision with root package name */
    private final ax f66790a;

    /* renamed from: b  reason: collision with root package name */
    private final bd f66791b;

    public al(ax axVar, bd bdVar) {
        this.f66790a = axVar;
        this.f66791b = bdVar;
    }

    public final /* synthetic */ Task a(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest, Long l11) throws Exception {
        return Tasks.forResult(new bc(this.f66791b, prepareIntegrityTokenRequest.a(), l11.longValue()));
    }

    public final Task<StandardIntegrityManager.StandardIntegrityTokenProvider> prepareIntegrityToken(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        return this.f66790a.d(prepareIntegrityTokenRequest.a()).onSuccessTask(new ak(this, prepareIntegrityTokenRequest));
    }
}
