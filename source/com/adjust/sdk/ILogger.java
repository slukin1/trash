package com.adjust.sdk;

public interface ILogger {
    void Assert(String str, Object... objArr);

    void debug(String str, Object... objArr);

    void error(String str, Object... objArr);

    void info(String str, Object... objArr);

    void lockLogLevel();

    void setLogLevel(LogLevel logLevel, boolean z11);

    void setLogLevelString(String str, boolean z11);

    void verbose(String str, Object... objArr);

    void warn(String str, Object... objArr);

    void warnInProduction(String str, Object... objArr);
}
