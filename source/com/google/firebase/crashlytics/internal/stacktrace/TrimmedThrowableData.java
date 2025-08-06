package com.google.firebase.crashlytics.internal.stacktrace;

public class TrimmedThrowableData {
    public final TrimmedThrowableData cause;
    public final String className;
    public final String localizedMessage;
    public final StackTraceElement[] stacktrace;

    public TrimmedThrowableData(Throwable th2, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.localizedMessage = th2.getLocalizedMessage();
        this.className = th2.getClass().getName();
        this.stacktrace = stackTraceTrimmingStrategy.getTrimmedStackTrace(th2.getStackTrace());
        Throwable cause2 = th2.getCause();
        this.cause = cause2 != null ? new TrimmedThrowableData(cause2, stackTraceTrimmingStrategy) : null;
    }
}
