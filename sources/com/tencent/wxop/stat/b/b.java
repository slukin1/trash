package com.tencent.wxop.stat.b;

import android.util.Log;
import com.tencent.wxop.stat.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f50990a = "default";

    /* renamed from: ch  reason: collision with root package name */
    private boolean f50991ch = true;

    /* renamed from: cp  reason: collision with root package name */
    private int f50992cp = 2;

    public b() {
    }

    public b(String str) {
        this.f50990a = str;
    }

    private String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        int i11 = 0;
        while (i11 < length) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || stackTraceElement.getClassName().equals(b.class.getName())) {
                i11++;
            } else {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final void a(Throwable th2) {
        if (this.f50992cp <= 6) {
            Log.e(this.f50990a, "", th2);
            c.F();
        }
    }

    public final void ap() {
        this.f50991ch = false;
    }

    public final void b(Object obj) {
        String str;
        if (this.f50991ch && this.f50992cp <= 4) {
            String c11 = c();
            if (c11 == null) {
                str = obj.toString();
            } else {
                str = c11 + " - " + obj;
            }
            Log.i(this.f50990a, str);
            c.F();
        }
    }

    public final void b(Throwable th2) {
        if (this.f50991ch) {
            a(th2);
        }
    }

    public final void c(Object obj) {
        if (this.f50991ch) {
            warn(obj);
        }
    }

    public final void d(Object obj) {
        if (this.f50991ch) {
            error(obj);
        }
    }

    public final void debug(Object obj) {
        String str;
        if (this.f50992cp <= 3) {
            String c11 = c();
            if (c11 == null) {
                str = obj.toString();
            } else {
                str = c11 + " - " + obj;
            }
            Log.d(this.f50990a, str);
            c.F();
        }
    }

    public final void e(Object obj) {
        if (this.f50991ch) {
            debug(obj);
        }
    }

    public final void error(Object obj) {
        String str;
        if (this.f50992cp <= 6) {
            String c11 = c();
            if (c11 == null) {
                str = obj.toString();
            } else {
                str = c11 + " - " + obj;
            }
            Log.e(this.f50990a, str);
            c.F();
        }
    }

    public final void warn(Object obj) {
        String str;
        if (this.f50992cp <= 5) {
            String c11 = c();
            if (c11 == null) {
                str = obj.toString();
            } else {
                str = c11 + " - " + obj;
            }
            Log.w(this.f50990a, str);
            c.F();
        }
    }
}
