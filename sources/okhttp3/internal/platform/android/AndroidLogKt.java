package okhttp3.internal.platform.android;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class AndroidLogKt {
    /* access modifiers changed from: private */
    public static final int getAndroidLevel(LogRecord logRecord) {
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            return 5;
        }
        return logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
    }
}
