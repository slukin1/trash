package com.iproov.sdk.logging;

import androidx.annotation.Keep;
import com.iproov.sdk.p011extends.Cdo;
import com.iproov.sdk.p011extends.Cif;

@Keep
public class IPLog {
    private static boolean loggingEnabled = true;
    private static final Cif loggingInstance = new Cdo();

    private IPLog() {
    }

    public static void d(String str, String str2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m609try(getPrefix() + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m606if(getPrefix() + str, str2);
        }
    }

    private static String getPrefix() {
        return String.format("£ [%s] ", new Object[]{Thread.currentThread().getName()});
    }

    public static void i(String str, String str2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m603do(getPrefix() + str, str2);
        }
    }

    public static void setLoggingEnabled(boolean z11) {
        loggingEnabled = z11;
    }

    public static void v(String str, String str2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m605for(getPrefix() + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m608new(getPrefix() + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m607if(getPrefix() + str, str2, th2);
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (loggingEnabled) {
            Cif ifVar = loggingInstance;
            ifVar.m604do(getPrefix() + str, str2, th2);
        }
    }
}
