package com.google.android.play.core.integrity;

import android.net.Network;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import java.util.Objects;

final class c extends IntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f66828a;

    /* renamed from: b  reason: collision with root package name */
    private Long f66829b;

    public final IntegrityTokenRequest build() {
        String str = this.f66828a;
        if (str != null) {
            return new e(str, this.f66829b, (Network) null, (d) null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j11) {
        this.f66829b = Long.valueOf(j11);
        return this;
    }

    public final IntegrityTokenRequest.Builder setNonce(String str) {
        Objects.requireNonNull(str, "Null nonce");
        this.f66828a = str;
        return this;
    }
}
