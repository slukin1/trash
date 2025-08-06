package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Application_Organization extends CrashlyticsReport.Session.Application.Organization {
    private final String clsId;

    public static final class Builder extends CrashlyticsReport.Session.Application.Organization.Builder {
        private String clsId;

        public CrashlyticsReport.Session.Application.Organization build() {
            String str = "";
            if (this.clsId == null) {
                str = str + " clsId";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Application_Organization(this.clsId);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Application.Organization.Builder setClsId(String str) {
            Objects.requireNonNull(str, "Null clsId");
            this.clsId = str;
            return this;
        }

        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Application.Organization organization) {
            this.clsId = organization.getClsId();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.clsId.equals(((CrashlyticsReport.Session.Application.Organization) obj).getClsId());
        }
        return false;
    }

    public String getClsId() {
        return this.clsId;
    }

    public int hashCode() {
        return this.clsId.hashCode() ^ 1000003;
    }

    public CrashlyticsReport.Session.Application.Organization.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Organization{clsId=" + this.clsId + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Application_Organization(String str) {
        this.clsId = str;
    }
}
