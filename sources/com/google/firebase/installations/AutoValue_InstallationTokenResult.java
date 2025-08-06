package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;
import java.util.Objects;

final class AutoValue_InstallationTokenResult extends InstallationTokenResult {
    private final String token;
    private final long tokenCreationTimestamp;
    private final long tokenExpirationTimestamp;

    public static final class Builder extends InstallationTokenResult.Builder {
        private String token;
        private Long tokenCreationTimestamp;
        private Long tokenExpirationTimestamp;

        public InstallationTokenResult build() {
            String str = "";
            if (this.token == null) {
                str = str + " token";
            }
            if (this.tokenExpirationTimestamp == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.tokenCreationTimestamp == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.tokenCreationTimestamp.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public InstallationTokenResult.Builder setToken(String str) {
            Objects.requireNonNull(str, "Null token");
            this.token = str;
            return this;
        }

        public InstallationTokenResult.Builder setTokenCreationTimestamp(long j11) {
            this.tokenCreationTimestamp = Long.valueOf(j11);
            return this;
        }

        public InstallationTokenResult.Builder setTokenExpirationTimestamp(long j11) {
            this.tokenExpirationTimestamp = Long.valueOf(j11);
            return this;
        }

        public Builder() {
        }

        private Builder(InstallationTokenResult installationTokenResult) {
            this.token = installationTokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(installationTokenResult.getTokenExpirationTimestamp());
            this.tokenCreationTimestamp = Long.valueOf(installationTokenResult.getTokenCreationTimestamp());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.token.equals(installationTokenResult.getToken()) && this.tokenExpirationTimestamp == installationTokenResult.getTokenExpirationTimestamp() && this.tokenCreationTimestamp == installationTokenResult.getTokenCreationTimestamp()) {
            return true;
        }
        return false;
    }

    public String getToken() {
        return this.token;
    }

    public long getTokenCreationTimestamp() {
        return this.tokenCreationTimestamp;
    }

    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public int hashCode() {
        long j11 = this.tokenExpirationTimestamp;
        long j12 = this.tokenCreationTimestamp;
        return ((((this.token.hashCode() ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)));
    }

    public InstallationTokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", tokenCreationTimestamp=" + this.tokenCreationTimestamp + "}";
    }

    private AutoValue_InstallationTokenResult(String str, long j11, long j12) {
        this.token = str;
        this.tokenExpirationTimestamp = j11;
        this.tokenCreationTimestamp = j12;
    }
}
