package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import java.util.Objects;

final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {
    private final String crashlyticsInstallId;
    private final String firebaseInstallationId;

    public AutoValue_InstallIdProvider_InstallIds(String str, String str2) {
        Objects.requireNonNull(str, "Null crashlyticsInstallId");
        this.crashlyticsInstallId = str;
        this.firebaseInstallationId = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallIdProvider.InstallIds)) {
            return false;
        }
        InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
        if (this.crashlyticsInstallId.equals(installIds.getCrashlyticsInstallId())) {
            String str = this.firebaseInstallationId;
            if (str == null) {
                if (installIds.getFirebaseInstallationId() == null) {
                    return true;
                }
            } else if (str.equals(installIds.getFirebaseInstallationId())) {
                return true;
            }
        }
        return false;
    }

    public String getCrashlyticsInstallId() {
        return this.crashlyticsInstallId;
    }

    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public int hashCode() {
        int hashCode = (this.crashlyticsInstallId.hashCode() ^ 1000003) * 1000003;
        String str = this.firebaseInstallationId;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.crashlyticsInstallId + ", firebaseInstallationId=" + this.firebaseInstallationId + "}";
    }
}
