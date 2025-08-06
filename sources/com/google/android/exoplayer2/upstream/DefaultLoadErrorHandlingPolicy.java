package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = -1;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public /* synthetic */ long getBlacklistDurationMsFor(int i11, long j11, IOException iOException, int i12) {
        return i.a(this, i11, j11, iOException, i12);
    }

    public long getBlacklistDurationMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.exception;
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i11 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        if (i11 == 403 || i11 == 404 || i11 == 410 || i11 == 416 || i11 == 500 || i11 == 503) {
            return 60000;
        }
        return -9223372036854775807L;
    }

    public int getMinimumLoadableRetryCount(int i11) {
        int i12 = this.minimumLoadableRetryCount;
        if (i12 == -1) {
            return i11 == 7 ? 6 : 3;
        }
        return i12;
    }

    public /* synthetic */ long getRetryDelayMsFor(int i11, long j11, IOException iOException, int i12) {
        return i.c(this, i11, j11, iOException, i12);
    }

    public long getRetryDelayMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.exception;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return (long) Math.min((loadErrorInfo.errorCount - 1) * 1000, 5000);
    }

    public /* synthetic */ void onLoadTaskConcluded(long j11) {
        i.e(this, j11);
    }

    public DefaultLoadErrorHandlingPolicy(int i11) {
        this.minimumLoadableRetryCount = i11;
    }
}
