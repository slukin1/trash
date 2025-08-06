package com.tencent.android.tpush.stat.b;

import com.tencent.android.tpush.logging.TLogger;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private String f69974a = "default";

    /* renamed from: b  reason: collision with root package name */
    private boolean f69975b = true;

    /* renamed from: c  reason: collision with root package name */
    private int f69976c = 2;

    public c() {
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(c.class.getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public boolean a() {
        return this.f69975b;
    }

    public void c(Object obj) {
        String str;
        if (this.f69976c <= 5) {
            String b11 = b();
            if (b11 == null) {
                str = obj.toString();
            } else {
                str = b11 + " - " + obj;
            }
            TLogger.w(this.f69974a, str);
        }
    }

    public void d(Object obj) {
        if (a()) {
            c(obj);
        }
    }

    public void e(Object obj) {
        String str;
        if (this.f69976c <= 6) {
            String b11 = b();
            if (b11 == null) {
                str = obj.toString();
            } else {
                str = b11 + " - " + obj;
            }
            TLogger.e(this.f69974a, str);
        }
    }

    public void f(Object obj) {
        if (a()) {
            e(obj);
        }
    }

    public void g(Object obj) {
        String str;
        if (this.f69976c <= 3) {
            String b11 = b();
            if (b11 == null) {
                str = obj.toString();
            } else {
                str = b11 + " - " + obj;
            }
            TLogger.d(this.f69974a, str);
        }
    }

    public void h(Object obj) {
        if (a()) {
            g(obj);
        }
    }

    public void a(boolean z11) {
        this.f69975b = z11;
    }

    public void a(Object obj) {
        String str;
        if (this.f69976c <= 4) {
            String b11 = b();
            if (b11 == null) {
                str = obj.toString();
            } else {
                str = b11 + " - " + obj;
            }
            TLogger.i(this.f69974a, str);
        }
    }

    public c(String str) {
        this.f69974a = str;
    }

    public void a(Throwable th2) {
        if (this.f69976c <= 6) {
            TLogger.e(this.f69974a, "", th2);
        }
    }

    public void b(Object obj) {
        if (a()) {
            a(obj);
        }
    }

    public void b(Throwable th2) {
        if (a()) {
            a(th2);
        }
    }
}
