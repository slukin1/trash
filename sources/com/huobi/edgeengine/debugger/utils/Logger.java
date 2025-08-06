package com.huobi.edgeengine.debugger.utils;

import android.util.Log;
import kotlin.Metadata;
import tj.b;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007J'\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¨\u0006\u0011"}, d2 = {"Lcom/huobi/edgeengine/debugger/utils/Logger;", "", "", "tag", "msg", "", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "d", "", "tr", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Integer;", "b", "c", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class Logger {
    public final Integer a(String str, String str2) {
        if (b.b()) {
            return Integer.valueOf(Log.d(str, str2));
        }
        return null;
    }

    public final Integer b(String str, String str2, Throwable th2) {
        if (b.b()) {
            return Integer.valueOf(Log.e(str, str2, th2));
        }
        return null;
    }

    public final String c(Throwable th2) {
        return Log.getStackTraceString(th2);
    }

    public final Integer d(String str, String str2) {
        if (b.b()) {
            return Integer.valueOf(Log.i(str, str2));
        }
        return null;
    }

    public final Integer e(String str, String str2, Throwable th2) {
        if (b.b()) {
            return Integer.valueOf(Log.w(str, str2, th2));
        }
        return null;
    }
}
