package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {
    private final String identifier;

    public static final class Builder extends CrashlyticsReport.Session.User.Builder {
        private String identifier;

        public CrashlyticsReport.Session.User build() {
            String str = "";
            if (this.identifier == null) {
                str = str + " identifier";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_User(this.identifier);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.User.Builder setIdentifier(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.identifier = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.identifier.equals(((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
        return false;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.identifier + "}";
    }

    private AutoValue_CrashlyticsReport_Session_User(String str) {
        this.identifier = str;
    }
}
