package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

final class AutoValue_LogEvent extends LogEvent {
    private final Integer eventCode;
    private final long eventTimeMs;
    private final long eventUptimeMs;
    private final NetworkConnectionInfo networkConnectionInfo;
    private final byte[] sourceExtension;
    private final String sourceExtensionJsonProto3;
    private final long timezoneOffsetSeconds;

    public static final class Builder extends LogEvent.Builder {
        private Integer eventCode;
        private Long eventTimeMs;
        private Long eventUptimeMs;
        private NetworkConnectionInfo networkConnectionInfo;
        private byte[] sourceExtension;
        private String sourceExtensionJsonProto3;
        private Long timezoneOffsetSeconds;

        public LogEvent build() {
            String str = "";
            if (this.eventTimeMs == null) {
                str = str + " eventTimeMs";
            }
            if (this.eventUptimeMs == null) {
                str = str + " eventUptimeMs";
            }
            if (this.timezoneOffsetSeconds == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.eventTimeMs.longValue(), this.eventCode, this.eventUptimeMs.longValue(), this.sourceExtension, this.sourceExtensionJsonProto3, this.timezoneOffsetSeconds.longValue(), this.networkConnectionInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogEvent.Builder setEventCode(Integer num) {
            this.eventCode = num;
            return this;
        }

        public LogEvent.Builder setEventTimeMs(long j11) {
            this.eventTimeMs = Long.valueOf(j11);
            return this;
        }

        public LogEvent.Builder setEventUptimeMs(long j11) {
            this.eventUptimeMs = Long.valueOf(j11);
            return this;
        }

        public LogEvent.Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo2) {
            this.networkConnectionInfo = networkConnectionInfo2;
            return this;
        }

        public LogEvent.Builder setSourceExtension(byte[] bArr) {
            this.sourceExtension = bArr;
            return this;
        }

        public LogEvent.Builder setSourceExtensionJsonProto3(String str) {
            this.sourceExtensionJsonProto3 = str;
            return this;
        }

        public LogEvent.Builder setTimezoneOffsetSeconds(long j11) {
            this.timezoneOffsetSeconds = Long.valueOf(j11);
            return this;
        }
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.eventTimeMs == logEvent.getEventTimeMs() && ((num = this.eventCode) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && this.eventUptimeMs == logEvent.getEventUptimeMs()) {
            if (Arrays.equals(this.sourceExtension, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).sourceExtension : logEvent.getSourceExtension()) && ((str = this.sourceExtensionJsonProto3) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.timezoneOffsetSeconds == logEvent.getTimezoneOffsetSeconds()) {
                NetworkConnectionInfo networkConnectionInfo2 = this.networkConnectionInfo;
                if (networkConnectionInfo2 == null) {
                    if (logEvent.getNetworkConnectionInfo() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo2.equals(logEvent.getNetworkConnectionInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getEventCode() {
        return this.eventCode;
    }

    public long getEventTimeMs() {
        return this.eventTimeMs;
    }

    public long getEventUptimeMs() {
        return this.eventUptimeMs;
    }

    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    public byte[] getSourceExtension() {
        return this.sourceExtension;
    }

    public String getSourceExtensionJsonProto3() {
        return this.sourceExtensionJsonProto3;
    }

    public long getTimezoneOffsetSeconds() {
        return this.timezoneOffsetSeconds;
    }

    public int hashCode() {
        long j11 = this.eventTimeMs;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.eventCode;
        int i12 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j12 = this.eventUptimeMs;
        int hashCode2 = (((((i11 ^ hashCode) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j13 = this.timezoneOffsetSeconds;
        int i13 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j13 >>> 32) ^ j13))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo2 = this.networkConnectionInfo;
        if (networkConnectionInfo2 != null) {
            i12 = networkConnectionInfo2.hashCode();
        }
        return i13 ^ i12;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.eventTimeMs + ", eventCode=" + this.eventCode + ", eventUptimeMs=" + this.eventUptimeMs + ", sourceExtension=" + Arrays.toString(this.sourceExtension) + ", sourceExtensionJsonProto3=" + this.sourceExtensionJsonProto3 + ", timezoneOffsetSeconds=" + this.timezoneOffsetSeconds + ", networkConnectionInfo=" + this.networkConnectionInfo + "}";
    }

    private AutoValue_LogEvent(long j11, Integer num, long j12, byte[] bArr, String str, long j13, NetworkConnectionInfo networkConnectionInfo2) {
        this.eventTimeMs = j11;
        this.eventCode = num;
        this.eventUptimeMs = j12;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j13;
        this.networkConnectionInfo = networkConnectionInfo2;
    }
}
