package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

final class f extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private long f66832a;

    /* renamed from: b  reason: collision with root package name */
    private byte f66833b;

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest build() {
        if (this.f66833b == 1) {
            return new h(this.f66832a, (g) null);
        }
        throw new IllegalStateException("Missing required properties: cloudProjectNumber");
    }

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder setCloudProjectNumber(long j11) {
        this.f66832a = j11;
        this.f66833b = 1;
        return this;
    }
}
