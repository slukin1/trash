package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

public class Session<T extends AuthToken> {
    @SerializedName("auth_token")
    private final T authToken;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private final long f51181id;

    public Session(T t11, long j11) {
        if (t11 != null) {
            this.authToken = t11;
            this.f51181id = j11;
            return;
        }
        throw new IllegalArgumentException("AuthToken must not be null.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Session session = (Session) obj;
        if (this.f51181id != session.f51181id) {
            return false;
        }
        T t11 = this.authToken;
        T t12 = session.authToken;
        if (t11 != null) {
            return t11.equals(t12);
        }
        if (t12 == null) {
            return true;
        }
        return false;
    }

    public T getAuthToken() {
        return this.authToken;
    }

    public long getId() {
        return this.f51181id;
    }

    public int hashCode() {
        T t11 = this.authToken;
        int hashCode = t11 != null ? t11.hashCode() : 0;
        long j11 = this.f51181id;
        return (hashCode * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }
}
