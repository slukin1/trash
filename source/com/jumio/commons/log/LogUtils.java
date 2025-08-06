package com.jumio.commons.log;

import android.graphics.Bitmap;
import com.jumio.analytics.AnalyticsEvent;
import java.io.File;

public final class LogUtils {
    public static final LogUtils INSTANCE = new LogUtils();
    public static final String NEW_LINE = "\r\n";

    public final void dumpDataInSubfolder(byte[] bArr, String str, String str2) {
    }

    public final void dumpImageInSubfolder(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i11, String str2) {
    }

    public final File getDebugFileRoot(String str) {
        return null;
    }

    public final File getLogFolder() {
        return null;
    }

    public final File getSubFolder(String str) {
        return null;
    }

    public final void init() {
    }

    public final void logAnalytics(AnalyticsEvent analyticsEvent) {
    }

    public final void logInfoInSubfolder(String str, String str2, String str3) {
    }

    public final void logServerRequest(String str, String str2) {
    }

    public final void logServerResponse(String str, int i11, long j11, String str2) {
    }

    public final void setSessionLogFolderName(String str) {
    }
}
