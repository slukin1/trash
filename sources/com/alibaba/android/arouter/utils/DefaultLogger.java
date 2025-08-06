package com.alibaba.android.arouter.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.facade.template.ILogger;

public class DefaultLogger implements ILogger {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f14080b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14081c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14082d = false;

    /* renamed from: a  reason: collision with root package name */
    public String f14083a = "ARouter";

    public DefaultLogger() {
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb2 = new StringBuilder("[");
        if (f14081c) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id2 = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb2.append("ThreadId=");
            sb2.append(id2);
            sb2.append(" & ");
            sb2.append("ThreadName=");
            sb2.append(name);
            sb2.append(" & ");
            sb2.append("FileName=");
            sb2.append(fileName);
            sb2.append(" & ");
            sb2.append("ClassName=");
            sb2.append(className);
            sb2.append(" & ");
            sb2.append("MethodName=");
            sb2.append(methodName);
            sb2.append(" & ");
            sb2.append("LineNumber=");
            sb2.append(lineNumber);
        }
        sb2.append(" ] ");
        return sb2.toString();
    }

    public void debug(String str, String str2) {
        if (f14080b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.d(str, str2 + a(stackTraceElement));
        }
    }

    public void error(String str, String str2) {
        if (f14080b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.e(str, str2 + a(stackTraceElement));
        }
    }

    public String getDefaultTag() {
        return this.f14083a;
    }

    public void info(String str, String str2) {
        if (f14080b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.i(str, str2 + a(stackTraceElement));
        }
    }

    public boolean isMonitorMode() {
        return f14082d;
    }

    public void monitor(String str) {
        if (f14080b && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(this.f14083a + "::monitor", str + a(stackTraceElement));
        }
    }

    public void showLog(boolean z11) {
        f14080b = z11;
    }

    public void showStackTrace(boolean z11) {
        f14081c = z11;
    }

    public void warning(String str, String str2) {
        if (f14080b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.w(str, str2 + a(stackTraceElement));
        }
    }

    public DefaultLogger(String str) {
        this.f14083a = str;
    }
}
