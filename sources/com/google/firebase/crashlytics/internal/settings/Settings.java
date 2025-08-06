package com.google.firebase.crashlytics.internal.settings;

public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z11, boolean z12, boolean z13) {
            this.collectReports = z11;
            this.collectAnrs = z12;
            this.collectBuildIds = z13;
        }
    }

    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i11, int i12) {
            this.maxCustomExceptionEvents = i11;
            this.maxCompleteSessionsCount = i12;
        }
    }

    public Settings(long j11, SessionData sessionData2, FeatureFlagData featureFlagData2, int i11, int i12, double d11, double d12, int i13) {
        this.expiresAtMillis = j11;
        this.sessionData = sessionData2;
        this.featureFlagData = featureFlagData2;
        this.settingsVersion = i11;
        this.cacheDuration = i12;
        this.onDemandUploadRatePerMinute = d11;
        this.onDemandBackoffBase = d12;
        this.onDemandBackoffStepDurationSeconds = i13;
    }

    public boolean isExpired(long j11) {
        return this.expiresAtMillis < j11;
    }
}
