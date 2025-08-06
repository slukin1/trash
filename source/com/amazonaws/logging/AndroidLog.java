package com.amazonaws.logging;

import android.util.Log;
import com.amazonaws.logging.LogFactory;

public class AndroidLog implements Log {

    /* renamed from: a  reason: collision with root package name */
    public final String f14932a;

    /* renamed from: b  reason: collision with root package name */
    public LogFactory.Level f14933b = null;

    public AndroidLog(String str) {
        this.f14932a = str;
    }

    public boolean a() {
        return Log.isLoggable(this.f14932a, 4) && (l() == null || l().getValue() <= LogFactory.Level.INFO.getValue());
    }

    public void b(Object obj, Throwable th2) {
        if (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue()) {
            Log.e(this.f14932a, obj.toString(), th2);
        }
    }

    public void c(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue()) {
            Log.e(this.f14932a, obj.toString());
        }
    }

    public void d(Object obj, Throwable th2) {
        if (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            Log.d(this.f14932a, obj.toString(), th2);
        }
    }

    public boolean e() {
        return Log.isLoggable(this.f14932a, 6) && (l() == null || l().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    public void f(Object obj, Throwable th2) {
        if (l() == null || l().getValue() <= LogFactory.Level.WARN.getValue()) {
            Log.w(this.f14932a, obj.toString(), th2);
        }
    }

    public void g(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.WARN.getValue()) {
            Log.w(this.f14932a, obj.toString());
        }
    }

    public void h(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            Log.d(this.f14932a, obj.toString());
        }
    }

    public boolean i() {
        return Log.isLoggable(this.f14932a, 3) && (l() == null || l().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    public void j(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.INFO.getValue()) {
            Log.i(this.f14932a, obj.toString());
        }
    }

    public void k(Object obj) {
        if (l() == null || l().getValue() <= LogFactory.Level.TRACE.getValue()) {
            Log.v(this.f14932a, obj.toString());
        }
    }

    public final LogFactory.Level l() {
        LogFactory.Level level = this.f14933b;
        if (level != null) {
            return level;
        }
        return LogFactory.a();
    }
}
