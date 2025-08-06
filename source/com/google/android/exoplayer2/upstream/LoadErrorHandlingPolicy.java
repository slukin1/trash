package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

public interface LoadErrorHandlingPolicy {

    public static final class LoadErrorInfo {
        public final int errorCount;
        public final IOException exception;
        public final LoadEventInfo loadEventInfo;
        public final MediaLoadData mediaLoadData;

        public LoadErrorInfo(LoadEventInfo loadEventInfo2, MediaLoadData mediaLoadData2, IOException iOException, int i11) {
            this.loadEventInfo = loadEventInfo2;
            this.mediaLoadData = mediaLoadData2;
            this.exception = iOException;
            this.errorCount = i11;
        }
    }

    @Deprecated
    long getBlacklistDurationMsFor(int i11, long j11, IOException iOException, int i12);

    long getBlacklistDurationMsFor(LoadErrorInfo loadErrorInfo);

    int getMinimumLoadableRetryCount(int i11);

    @Deprecated
    long getRetryDelayMsFor(int i11, long j11, IOException iOException, int i12);

    long getRetryDelayMsFor(LoadErrorInfo loadErrorInfo);

    void onLoadTaskConcluded(long j11);
}
