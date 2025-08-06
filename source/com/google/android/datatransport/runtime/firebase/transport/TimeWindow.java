package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class TimeWindow {
    private static final TimeWindow DEFAULT_INSTANCE = new Builder().build();
    private final long end_ms_;
    private final long start_ms_;

    public static final class Builder {
        private long end_ms_ = 0;
        private long start_ms_ = 0;

        public TimeWindow build() {
            return new TimeWindow(this.start_ms_, this.end_ms_);
        }

        public Builder setEndMs(long j11) {
            this.end_ms_ = j11;
            return this;
        }

        public Builder setStartMs(long j11) {
            this.start_ms_ = j11;
            return this;
        }
    }

    public TimeWindow(long j11, long j12) {
        this.start_ms_ = j11;
        this.end_ms_ = j12;
    }

    public static TimeWindow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public long getEndMs() {
        return this.end_ms_;
    }

    @Protobuf(tag = 1)
    public long getStartMs() {
        return this.start_ms_;
    }
}
