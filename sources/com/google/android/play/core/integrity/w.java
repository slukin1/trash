package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

final class w implements IntegrityManager {

    /* renamed from: a  reason: collision with root package name */
    private final ad f66857a;

    public w(ad adVar) {
        this.f66857a = adVar;
    }

    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.f66857a.b(integrityTokenRequest);
    }
}
