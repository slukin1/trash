package com.google.firebase.crashlytics.internal.common;

import com.google.auto.value.AutoValue;

public interface InstallIdProvider {

    @AutoValue
    public static abstract class InstallIds {
        public static InstallIds create(String str, String str2) {
            return new AutoValue_InstallIdProvider_InstallIds(str, str2);
        }

        public static InstallIds createWithoutFid(String str) {
            return create(str, (String) null);
        }

        public abstract String getCrashlyticsInstallId();

        public abstract String getFirebaseInstallationId();
    }

    InstallIds getInstallIds();
}
