package com.sumsub.sns.internal.log.logger;

import com.sumsub.log.logger.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class e implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList<Logger> f34908a = new CopyOnWriteArrayList<>();

    public final void a(Logger logger) {
        this.f34908a.add(logger);
    }

    public final List<Logger> c() {
        return this.f34908a;
    }

    public final void clear() {
        this.f34908a.clear();
    }

    public void d(String str, String str2, Throwable th2) {
        for (Logger d11 : this.f34908a) {
            d11.d(str, str2, th2);
        }
    }

    public void e(String str, String str2, Throwable th2) {
        for (Logger e11 : this.f34908a) {
            e11.e(str, str2, th2);
        }
    }

    public void i(String str, String str2, Throwable th2) {
        for (Logger i11 : this.f34908a) {
            i11.i(str, str2, th2);
        }
    }

    public void v(String str, String str2, Throwable th2) {
        for (Logger v11 : this.f34908a) {
            v11.v(str, str2, th2);
        }
    }

    public void w(String str, String str2, Throwable th2) {
        for (Logger w11 : this.f34908a) {
            w11.w(str, str2, th2);
        }
    }
}
