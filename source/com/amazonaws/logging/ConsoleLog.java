package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

public final class ConsoleLog implements Log {

    /* renamed from: a  reason: collision with root package name */
    public final String f14934a;

    /* renamed from: b  reason: collision with root package name */
    public LogFactory.Level f14935b = null;

    public ConsoleLog(String str) {
        this.f14934a = str;
    }

    public boolean a() {
        return l() == null || l().getValue() <= LogFactory.Level.INFO.getValue();
    }

    public void b(Object obj, Throwable th2) {
        if (e()) {
            o(LogFactory.Level.ERROR, obj, th2);
        }
    }

    public void c(Object obj) {
        if (e()) {
            o(LogFactory.Level.ERROR, obj, (Throwable) null);
        }
    }

    public void d(Object obj, Throwable th2) {
        if (i()) {
            o(LogFactory.Level.DEBUG, obj, th2);
        }
    }

    public boolean e() {
        return l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue();
    }

    public void f(Object obj, Throwable th2) {
        if (n()) {
            o(LogFactory.Level.WARN, obj, th2);
        }
    }

    public void g(Object obj) {
        if (n()) {
            o(LogFactory.Level.WARN, obj, (Throwable) null);
        }
    }

    public void h(Object obj) {
        if (i()) {
            o(LogFactory.Level.DEBUG, obj, (Throwable) null);
        }
    }

    public boolean i() {
        return l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue();
    }

    public void j(Object obj) {
        if (a()) {
            o(LogFactory.Level.INFO, obj, (Throwable) null);
        }
    }

    public void k(Object obj) {
        if (m()) {
            o(LogFactory.Level.TRACE, obj, (Throwable) null);
        }
    }

    public final LogFactory.Level l() {
        LogFactory.Level level = this.f14935b;
        if (level != null) {
            return level;
        }
        return LogFactory.a();
    }

    public boolean m() {
        return l() == null || l().getValue() <= LogFactory.Level.TRACE.getValue();
    }

    public boolean n() {
        return l() == null || l().getValue() <= LogFactory.Level.WARN.getValue();
    }

    public final void o(LogFactory.Level level, Object obj, Throwable th2) {
        System.out.printf("%s/%s: %s\n", new Object[]{this.f14934a, level.name(), obj});
        if (th2 != null) {
            System.out.println(th2.toString());
        }
    }
}
