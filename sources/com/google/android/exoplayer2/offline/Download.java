package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Download {
    public static final int FAILURE_REASON_NONE = 0;
    public static final int FAILURE_REASON_UNKNOWN = 1;
    public static final int STATE_COMPLETED = 3;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_FAILED = 4;
    public static final int STATE_QUEUED = 0;
    public static final int STATE_REMOVING = 5;
    public static final int STATE_RESTARTING = 7;
    public static final int STATE_STOPPED = 1;
    public static final int STOP_REASON_NONE = 0;
    public final long contentLength;
    public final int failureReason;
    public final DownloadProgress progress;
    public final DownloadRequest request;
    public final long startTimeMs;
    public final int state;
    public final int stopReason;
    public final long updateTimeMs;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public Download(DownloadRequest downloadRequest, int i11, long j11, long j12, long j13, int i12, int i13) {
        this(downloadRequest, i11, j11, j12, j13, i12, i13, new DownloadProgress());
    }

    public long getBytesDownloaded() {
        return this.progress.bytesDownloaded;
    }

    public float getPercentDownloaded() {
        return this.progress.percentDownloaded;
    }

    public boolean isTerminalState() {
        int i11 = this.state;
        return i11 == 3 || i11 == 4;
    }

    public Download(DownloadRequest downloadRequest, int i11, long j11, long j12, long j13, int i12, int i13, DownloadProgress downloadProgress) {
        Assertions.checkNotNull(downloadProgress);
        boolean z11 = true;
        Assertions.checkArgument((i13 == 0) == (i11 != 4));
        if (i12 != 0) {
            Assertions.checkArgument((i11 == 2 || i11 == 0) ? false : z11);
        }
        this.request = downloadRequest;
        this.state = i11;
        this.startTimeMs = j11;
        this.updateTimeMs = j12;
        this.contentLength = j13;
        this.stopReason = i12;
        this.failureReason = i13;
        this.progress = downloadProgress;
    }
}
