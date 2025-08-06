package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

final class AutoValue_TokenResult extends TokenResult {
    private final TokenResult.ResponseCode responseCode;
    private final String token;
    private final long tokenExpirationTimestamp;

    public static final class Builder extends TokenResult.Builder {
        private TokenResult.ResponseCode responseCode;
        private String token;
        private Long tokenExpirationTimestamp;

        public TokenResult build() {
            String str = "";
            if (this.tokenExpirationTimestamp == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode2) {
            this.responseCode = responseCode2;
            return this;
        }

        public TokenResult.Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public TokenResult.Builder setTokenExpirationTimestamp(long j11) {
            this.tokenExpirationTimestamp = Long.valueOf(j11);
            return this;
        }

        public Builder() {
        }

        private Builder(TokenResult tokenResult) {
            this.token = tokenResult.getToken();
            this.tokenExpirationTimestamp = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.responseCode = tokenResult.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.tokenExpirationTimestamp == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode2 = this.responseCode;
                if (responseCode2 == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode2.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getToken() {
        return this.token;
    }

    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public int hashCode() {
        String str = this.token;
        int i11 = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j11 = this.tokenExpirationTimestamp;
        int i12 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i11 = responseCode2.hashCode();
        }
        return i12 ^ i11;
    }

    public TokenResult.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "TokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", responseCode=" + this.responseCode + "}";
    }

    private AutoValue_TokenResult(String str, long j11, TokenResult.ResponseCode responseCode2) {
        this.token = str;
        this.tokenExpirationTimestamp = j11;
        this.responseCode = responseCode2;
    }
}
