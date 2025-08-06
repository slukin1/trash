package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

public final /* synthetic */ class i {
    @Deprecated
    public static long a(LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i11, long j11, IOException iOException, int i12) {
        throw new UnsupportedOperationException();
    }

    public static long b(LoadErrorHandlingPolicy loadErrorHandlingPolicy, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    @Deprecated
    public static long c(LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i11, long j11, IOException iOException, int i12) {
        throw new UnsupportedOperationException();
    }

    public static long d(LoadErrorHandlingPolicy loadErrorHandlingPolicy, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    public static void e(LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j11) {
    }
}
