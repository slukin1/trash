package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch {
    private final String arch;
    private final String buildId;
    private final String libraryName;

    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder {
        private String arch;
        private String buildId;
        private String libraryName;

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch build() {
            String str = "";
            if (this.arch == null) {
                str = str + " arch";
            }
            if (this.libraryName == null) {
                str = str + " libraryName";
            }
            if (this.buildId == null) {
                str = str + " buildId";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(this.arch, this.libraryName, this.buildId);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder setArch(String str) {
            Objects.requireNonNull(str, "Null arch");
            this.arch = str;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder setBuildId(String str) {
            Objects.requireNonNull(str, "Null buildId");
            this.buildId = str;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder setLibraryName(String str) {
            Objects.requireNonNull(str, "Null libraryName");
            this.libraryName = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch = (CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) obj;
        if (!this.arch.equals(buildIdMappingForArch.getArch()) || !this.libraryName.equals(buildIdMappingForArch.getLibraryName()) || !this.buildId.equals(buildIdMappingForArch.getBuildId())) {
            return false;
        }
        return true;
    }

    public String getArch() {
        return this.arch;
    }

    public String getBuildId() {
        return this.buildId;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public int hashCode() {
        return ((((this.arch.hashCode() ^ 1000003) * 1000003) ^ this.libraryName.hashCode()) * 1000003) ^ this.buildId.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.arch + ", libraryName=" + this.libraryName + ", buildId=" + this.buildId + "}";
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(String str, String str2, String str3) {
        this.arch = str;
        this.libraryName = str2;
        this.buildId = str3;
    }
}
