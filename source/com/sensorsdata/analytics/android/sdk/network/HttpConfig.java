package com.sensorsdata.analytics.android.sdk.network;

import com.jumio.core.cdn.CDNDownload;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.io.Serializable;

public class HttpConfig implements Serializable {
    private static final String TAG = ("SA." + HttpConfig.class.getSimpleName());
    private int connectionTimeout = CDNDownload.DEFAULT_TIMEOUT;
    private int readTimeout = CDNDownload.DEFAULT_TIMEOUT;

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setConnectionTimeout(int i11) {
        if (i11 < 1000) {
            SALog.i(TAG, "connectionTimeout minimum value is 1000ms");
            this.connectionTimeout = 1000;
            return;
        }
        this.connectionTimeout = i11;
    }

    public void setReadTimeout(int i11) {
        if (i11 < 1000) {
            SALog.i(TAG, "readTimeout minimum value is 1000ms");
            this.readTimeout = 1000;
            return;
        }
        this.readTimeout = i11;
    }
}
