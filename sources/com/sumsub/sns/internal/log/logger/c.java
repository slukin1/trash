package com.sumsub.sns.internal.log.logger;

import com.sumsub.log.logger.Logger;
import java.util.List;

public final class c implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public final List<Logger> f34906a;

    public c(List<? extends Logger> list) {
        this.f34906a = list;
    }

    public void d(String str, String str2, Throwable th2) {
        for (Logger d11 : this.f34906a) {
            d11.d(str, str2, th2);
        }
    }

    public void e(String str, String str2, Throwable th2) {
        for (Logger e11 : this.f34906a) {
            e11.e(str, str2, th2);
        }
    }

    public void i(String str, String str2, Throwable th2) {
        for (Logger i11 : this.f34906a) {
            i11.i(str, str2, th2);
        }
    }

    public void v(String str, String str2, Throwable th2) {
        for (Logger v11 : this.f34906a) {
            v11.v(str, str2, th2);
        }
    }

    public void w(String str, String str2, Throwable th2) {
        for (Logger w11 : this.f34906a) {
            w11.w(str, str2, th2);
        }
    }
}
