package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {
    private final long baseAddress;
    private final String name;
    private final long size;
    private final String uuid;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {
        private Long baseAddress;
        private String name;
        private Long size;
        private String uuid;

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            String str = "";
            if (this.baseAddress == null) {
                str = str + " baseAddress";
            }
            if (this.size == null) {
                str = str + " size";
            }
            if (this.name == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress.longValue(), this.size.longValue(), this.name, this.uuid);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j11) {
            this.baseAddress = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            Objects.requireNonNull(str, "Null name");
            this.name = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j11) {
            this.size = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(String str) {
            this.uuid = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.baseAddress == binaryImage.getBaseAddress() && this.size == binaryImage.getSize() && this.name.equals(binaryImage.getName())) {
            String str = this.uuid;
            if (str == null) {
                if (binaryImage.getUuid() == null) {
                    return true;
                }
            } else if (str.equals(binaryImage.getUuid())) {
                return true;
            }
        }
        return false;
    }

    public long getBaseAddress() {
        return this.baseAddress;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    @Encodable.Ignore
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        long j11 = this.baseAddress;
        long j12 = this.size;
        int hashCode = (((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.name.hashCode()) * 1000003;
        String str = this.uuid;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.baseAddress + ", size=" + this.size + ", name=" + this.name + ", uuid=" + this.uuid + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j11, long j12, String str, String str2) {
        this.baseAddress = j11;
        this.size = j12;
        this.name = str;
        this.uuid = str2;
    }
}
