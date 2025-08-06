package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

final class i extends StandardIntegrityManager.StandardIntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f66835a;

    public final StandardIntegrityManager.StandardIntegrityTokenRequest build() {
        return new k(this.f66835a, (j) null);
    }

    public final StandardIntegrityManager.StandardIntegrityTokenRequest.Builder setRequestHash(String str) {
        this.f66835a = str;
        return this;
    }
}
