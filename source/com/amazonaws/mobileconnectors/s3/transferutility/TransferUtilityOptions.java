package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.Serializable;

public class TransferUtilityOptions implements Serializable {
    private static final Log LOGGER = LogFactory.b(TransferUtilityOptions.class);
    private static final int MILLIS_IN_MINUTE = 60000;
    private static final long serialVersionUID = 1;
    private long minimumUploadPartSizeInBytes;
    public TransferNetworkConnectionType transferNetworkConnectionType;
    @Deprecated
    private long transferServiceCheckTimeInterval;
    private int transferThreadPoolSize;

    public TransferUtilityOptions() {
        this.transferServiceCheckTimeInterval = getDefaultCheckTimeInterval();
        this.transferThreadPoolSize = getDefaultThreadPoolSize();
        this.transferNetworkConnectionType = getDefaultTransferNetworkConnectionType();
        this.minimumUploadPartSizeInBytes = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    }

    @Deprecated
    public static long getDefaultCheckTimeInterval() {
        return 60000;
    }

    public static int getDefaultThreadPoolSize() {
        return (Runtime.getRuntime().availableProcessors() + 1) * 2;
    }

    public static TransferNetworkConnectionType getDefaultTransferNetworkConnectionType() {
        return TransferNetworkConnectionType.ANY;
    }

    public long getMinimumUploadPartSizeInBytes() {
        return this.minimumUploadPartSizeInBytes;
    }

    public int getMinimumUploadPartSizeInMB() {
        return (int) (this.minimumUploadPartSizeInBytes / 1048576);
    }

    public TransferNetworkConnectionType getTransferNetworkConnectionType() {
        return this.transferNetworkConnectionType;
    }

    @Deprecated
    public long getTransferServiceCheckTimeInterval() {
        return this.transferServiceCheckTimeInterval;
    }

    public int getTransferThreadPoolSize() {
        return this.transferThreadPoolSize;
    }

    public void setMinimumUploadPartSizeInMB(int i11) {
        long j11 = ((long) i11) * 1048576;
        if (j11 > 5368709120L) {
            LOGGER.g("The provided minimumUploadPartSize is greater than the maximum upload part size limit. Setting upload part size to the maximum allowed value of5MB.");
            this.minimumUploadPartSizeInBytes = 5368709120L;
        } else if (j11 < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            LOGGER.g("The provided minimumUploadPartSize is less than the minimum upload part size limit. Setting upload part size to the minimum allowed value of5MB.");
            this.minimumUploadPartSizeInBytes = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        } else {
            this.minimumUploadPartSizeInBytes = j11;
        }
    }

    @Deprecated
    public void setTransferServiceCheckTimeInterval(long j11) {
    }

    public void setTransferThreadPoolSize(int i11) {
        if (i11 < 0) {
            this.transferThreadPoolSize = getDefaultThreadPoolSize();
        } else {
            this.transferThreadPoolSize = i11;
        }
    }

    public TransferUtilityOptions(int i11, TransferNetworkConnectionType transferNetworkConnectionType2) {
        this.transferServiceCheckTimeInterval = getDefaultCheckTimeInterval();
        this.transferThreadPoolSize = i11;
        this.transferNetworkConnectionType = transferNetworkConnectionType2;
        this.minimumUploadPartSizeInBytes = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    }
}
