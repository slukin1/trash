package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {
    private final String file;
    private final int importance;
    private final long offset;

    /* renamed from: pc  reason: collision with root package name */
    private final long f67067pc;
    private final String symbol;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {
        private String file;
        private Integer importance;
        private Long offset;

        /* renamed from: pc  reason: collision with root package name */
        private Long f67068pc;
        private String symbol;

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            String str = "";
            if (this.f67068pc == null) {
                str = str + " pc";
            }
            if (this.symbol == null) {
                str = str + " symbol";
            }
            if (this.offset == null) {
                str = str + " offset";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f67068pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String str) {
            this.file = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i11) {
            this.importance = Integer.valueOf(i11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long j11) {
            this.offset = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long j11) {
            this.f67068pc = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String str) {
            Objects.requireNonNull(str, "Null symbol");
            this.symbol = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f67067pc == frame.getPc() && this.symbol.equals(frame.getSymbol()) && ((str = this.file) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.offset == frame.getOffset() && this.importance == frame.getImportance()) {
            return true;
        }
        return false;
    }

    public String getFile() {
        return this.file;
    }

    public int getImportance() {
        return this.importance;
    }

    public long getOffset() {
        return this.offset;
    }

    public long getPc() {
        return this.f67067pc;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        long j11 = this.f67067pc;
        int hashCode = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.symbol.hashCode()) * 1000003;
        String str = this.file;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j12 = this.offset;
        return ((((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.importance;
    }

    public String toString() {
        return "Frame{pc=" + this.f67067pc + ", symbol=" + this.symbol + ", file=" + this.file + ", offset=" + this.offset + ", importance=" + this.importance + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j11, String str, String str2, long j12, int i11) {
        this.f67067pc = j11;
        this.symbol = str;
        this.file = str2;
        this.offset = j12;
        this.importance = i11;
    }
}
