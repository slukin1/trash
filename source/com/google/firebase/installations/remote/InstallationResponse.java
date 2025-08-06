package com.google.firebase.installations.remote;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;

@AutoValue
public abstract class InstallationResponse {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract InstallationResponse build();

        public abstract Builder setAuthToken(TokenResult tokenResult);

        public abstract Builder setFid(String str);

        public abstract Builder setRefreshToken(String str);

        public abstract Builder setResponseCode(ResponseCode responseCode);

        public abstract Builder setUri(String str);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    public static Builder builder() {
        return new AutoValue_InstallationResponse.Builder();
    }

    public abstract TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract ResponseCode getResponseCode();

    public abstract String getUri();

    public abstract Builder toBuilder();
}
