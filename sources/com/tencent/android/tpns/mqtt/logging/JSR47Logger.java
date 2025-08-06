package com.tencent.android.tpns.mqtt.logging;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;

public class JSR47Logger implements Logger {
    private String catalogID = null;
    private Logger julLogger = null;
    private ResourceBundle logMessageCatalog = null;
    private String loggerName = null;
    private String resourceName = null;
    private ResourceBundle traceMessageCatalog = null;

    public static void dumpMemoryTrace47(Logger logger) {
        if (logger != null) {
            Handler[] handlers = logger.getHandlers();
            for (int i11 = 0; i11 < handlers.length; i11++) {
                if (handlers[i11] instanceof MemoryHandler) {
                    synchronized (handlers[i11]) {
                        ((MemoryHandler) handlers[i11]).push();
                    }
                    return;
                }
            }
            dumpMemoryTrace47(logger.getParent());
        }
    }

    private String getResourceMessage(ResourceBundle resourceBundle, String str) {
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return str;
        }
    }

    private void logToJsr47(Level level, String str, String str2, String str3, ResourceBundle resourceBundle, String str4, Object[] objArr, Throwable th2) {
        if (str4.indexOf("=====") == -1) {
            str4 = MessageFormat.format(getResourceMessage(resourceBundle, str4), objArr);
        }
        LogRecord logRecord = new LogRecord(level, this.resourceName + l.f34627b + str4);
        logRecord.setSourceClassName(str);
        logRecord.setSourceMethodName(str2);
        logRecord.setLoggerName(this.loggerName);
        if (th2 != null) {
            logRecord.setThrown(th2);
        }
        this.julLogger.log(logRecord);
    }

    private Level mapJULLevel(int i11) {
        switch (i11) {
            case 1:
                return Level.SEVERE;
            case 2:
                return Level.WARNING;
            case 3:
                return Level.INFO;
            case 4:
                return Level.CONFIG;
            case 5:
                return Level.FINE;
            case 6:
                return Level.FINER;
            case 7:
                return Level.FINEST;
            default:
                return null;
        }
    }

    public void config(String str, String str2, String str3) {
        log(4, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void dumpTrace() {
        dumpMemoryTrace47(this.julLogger);
    }

    public void fine(String str, String str2, String str3) {
        trace(5, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void finer(String str, String str2, String str3) {
        trace(6, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void finest(String str, String str2, String str3) {
        trace(7, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public String formatMessage(String str, Object[] objArr) {
        try {
            return this.logMessageCatalog.getString(str);
        } catch (MissingResourceException unused) {
            return str;
        }
    }

    public void info(String str, String str2, String str3) {
        log(3, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void initialise(ResourceBundle resourceBundle, String str, String str2) {
        this.traceMessageCatalog = this.logMessageCatalog;
        this.resourceName = str2;
        this.loggerName = str;
        this.julLogger = Logger.getLogger(str);
        this.logMessageCatalog = resourceBundle;
        this.traceMessageCatalog = resourceBundle;
        this.catalogID = resourceBundle.getString("0");
    }

    public boolean isLoggable(int i11) {
        Level mapJULLevel = mapJULLevel(i11);
        return mapJULLevel != null && this.julLogger.isLoggable(mapJULLevel);
    }

    public void log(int i11, String str, String str2, String str3, Object[] objArr, Throwable th2) {
        Level mapJULLevel = mapJULLevel(i11);
        if (mapJULLevel != null && this.julLogger.isLoggable(mapJULLevel)) {
            logToJsr47(mapJULLevel, str, str2, this.catalogID, this.logMessageCatalog, str3, objArr, th2);
        }
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public void severe(String str, String str2, String str3) {
        log(1, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void trace(int i11, String str, String str2, String str3, Object[] objArr, Throwable th2) {
        Level mapJULLevel = mapJULLevel(i11);
        if (mapJULLevel != null && this.julLogger.isLoggable(mapJULLevel)) {
            logToJsr47(mapJULLevel, str, str2, this.catalogID, this.traceMessageCatalog, str3, objArr, th2);
        }
    }

    public void warning(String str, String str2, String str3) {
        log(2, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void config(String str, String str2, String str3, Object[] objArr) {
        log(4, str, str2, str3, objArr, (Throwable) null);
    }

    public void fine(String str, String str2, String str3, Object[] objArr) {
        trace(5, str, str2, str3, objArr, (Throwable) null);
    }

    public void finer(String str, String str2, String str3, Object[] objArr) {
        trace(6, str, str2, str3, objArr, (Throwable) null);
    }

    public void finest(String str, String str2, String str3, Object[] objArr) {
        trace(7, str, str2, str3, objArr, (Throwable) null);
    }

    public void info(String str, String str2, String str3, Object[] objArr) {
        log(3, str, str2, str3, objArr, (Throwable) null);
    }

    public void severe(String str, String str2, String str3, Object[] objArr) {
        log(1, str, str2, str3, objArr, (Throwable) null);
    }

    public void warning(String str, String str2, String str3, Object[] objArr) {
        log(2, str, str2, str3, objArr, (Throwable) null);
    }

    public void config(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log(4, str, str2, str3, objArr, th2);
    }

    public void fine(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        trace(5, str, str2, str3, objArr, th2);
    }

    public void finer(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        trace(6, str, str2, str3, objArr, th2);
    }

    public void finest(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        trace(7, str, str2, str3, objArr, th2);
    }

    public void info(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log(3, str, str2, str3, objArr, th2);
    }

    public void severe(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log(1, str, str2, str3, objArr, th2);
    }

    public void warning(String str, String str2, String str3, Object[] objArr, Throwable th2) {
        log(2, str, str2, str3, objArr, th2);
    }
}
