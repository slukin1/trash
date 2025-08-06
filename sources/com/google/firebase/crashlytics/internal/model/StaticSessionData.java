package com.google.firebase.crashlytics.internal.model;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

@AutoValue
public abstract class StaticSessionData {

    @AutoValue
    public static abstract class AppData {
        public static AppData create(String str, String str2, String str3, String str4, int i11, DevelopmentPlatformProvider developmentPlatformProvider) {
            return new AutoValue_StaticSessionData_AppData(str, str2, str3, str4, i11, developmentPlatformProvider);
        }

        public abstract String appIdentifier();

        public abstract int deliveryMechanism();

        public abstract DevelopmentPlatformProvider developmentPlatformProvider();

        public abstract String installUuid();

        public abstract String versionCode();

        public abstract String versionName();
    }

    @AutoValue
    public static abstract class DeviceData {
        public static DeviceData create(int i11, String str, int i12, long j11, long j12, boolean z11, int i13, String str2, String str3) {
            return new AutoValue_StaticSessionData_DeviceData(i11, str, i12, j11, j12, z11, i13, str2, str3);
        }

        public abstract int arch();

        public abstract int availableProcessors();

        public abstract long diskSpace();

        public abstract boolean isEmulator();

        public abstract String manufacturer();

        public abstract String model();

        public abstract String modelClass();

        public abstract int state();

        public abstract long totalRam();
    }

    @AutoValue
    public static abstract class OsData {
        public static OsData create(String str, String str2, boolean z11) {
            return new AutoValue_StaticSessionData_OsData(str, str2, z11);
        }

        public abstract boolean isRooted();

        public abstract String osCodeName();

        public abstract String osRelease();
    }

    public static StaticSessionData create(AppData appData, OsData osData, DeviceData deviceData) {
        return new AutoValue_StaticSessionData(appData, osData, deviceData);
    }

    public abstract AppData appData();

    public abstract DeviceData deviceData();

    public abstract OsData osData();
}
