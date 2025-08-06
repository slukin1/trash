package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class DataSourceException extends IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public DataSourceException(int i11) {
        this.reason = i11;
    }

    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        Throwable th2;
        while (th2 != null) {
            if ((th2 instanceof DataSourceException) && ((DataSourceException) th2).reason == 0) {
                return true;
            }
            Throwable cause = th2.getCause();
            th2 = iOException;
            th2 = cause;
        }
        return false;
    }
}
