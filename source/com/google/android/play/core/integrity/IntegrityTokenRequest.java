package com.google.android.play.core.integrity;

import android.net.Network;

public abstract class IntegrityTokenRequest {

    public static abstract class Builder {
        public abstract IntegrityTokenRequest build();

        public abstract Builder setCloudProjectNumber(long j11);

        public abstract Builder setNonce(String str);
    }

    public static Builder builder() {
        return new c();
    }

    public abstract Network a();

    public abstract Long cloudProjectNumber();

    public abstract String nonce();
}
