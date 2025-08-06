package com.huobi.woodpecker.monitor.base;

import gv.a;
import kv.e;

public abstract class BaseMonitor implements a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f21151b = false;

    public boolean c() {
        return this.f21151b;
    }

    public void d() {
    }

    public void e() {
    }

    public final a f() {
        if (!c()) {
            e.c(getClass().getName(), "monitor start !!!!!");
            d();
            this.f21151b = true;
        }
        return this;
    }

    public final a g() {
        if (c()) {
            e.c(getClass().getName(), "monitor stop !!!!!");
            e();
            this.f21151b = false;
        }
        return this;
    }
}
