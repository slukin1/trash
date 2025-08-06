package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import java.util.Objects;

final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {
    private final String appIdentifier;
    private final int deliveryMechanism;
    private final DevelopmentPlatformProvider developmentPlatformProvider;
    private final String installUuid;
    private final String versionCode;
    private final String versionName;

    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i11, DevelopmentPlatformProvider developmentPlatformProvider2) {
        Objects.requireNonNull(str, "Null appIdentifier");
        this.appIdentifier = str;
        Objects.requireNonNull(str2, "Null versionCode");
        this.versionCode = str2;
        Objects.requireNonNull(str3, "Null versionName");
        this.versionName = str3;
        Objects.requireNonNull(str4, "Null installUuid");
        this.installUuid = str4;
        this.deliveryMechanism = i11;
        Objects.requireNonNull(developmentPlatformProvider2, "Null developmentPlatformProvider");
        this.developmentPlatformProvider = developmentPlatformProvider2;
    }

    public String appIdentifier() {
        return this.appIdentifier;
    }

    public int deliveryMechanism() {
        return this.deliveryMechanism;
    }

    public DevelopmentPlatformProvider developmentPlatformProvider() {
        return this.developmentPlatformProvider;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.AppData)) {
            return false;
        }
        StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
        if (!this.appIdentifier.equals(appData.appIdentifier()) || !this.versionCode.equals(appData.versionCode()) || !this.versionName.equals(appData.versionName()) || !this.installUuid.equals(appData.installUuid()) || this.deliveryMechanism != appData.deliveryMechanism() || !this.developmentPlatformProvider.equals(appData.developmentPlatformProvider())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((this.appIdentifier.hashCode() ^ 1000003) * 1000003) ^ this.versionCode.hashCode()) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.installUuid.hashCode()) * 1000003) ^ this.deliveryMechanism) * 1000003) ^ this.developmentPlatformProvider.hashCode();
    }

    public String installUuid() {
        return this.installUuid;
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.appIdentifier + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", installUuid=" + this.installUuid + ", deliveryMechanism=" + this.deliveryMechanism + ", developmentPlatformProvider=" + this.developmentPlatformProvider + "}";
    }

    public String versionCode() {
        return this.versionCode;
    }

    public String versionName() {
        return this.versionName;
    }
}
