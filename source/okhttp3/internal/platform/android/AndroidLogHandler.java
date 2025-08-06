package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        AndroidLog.INSTANCE.androidLog$okhttp(logRecord.getLoggerName(), AndroidLogKt.getAndroidLevel(logRecord), logRecord.getMessage(), logRecord.getThrown());
    }
}
