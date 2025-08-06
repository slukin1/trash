package com.mob.mgs.impl;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f27617a = new e();

    private e() {
    }

    public static e a() {
        return f27617a;
    }

    public void b(String str) {
        NLog instance = MobLog.getInstance();
        instance.d("[MC][MGS]" + str, new Object[0]);
    }

    public void a(String str) {
        NLog instance = MobLog.getInstance();
        instance.d("[MC][MGS]" + str, new Object[0]);
    }

    public void b(Throwable th2) {
        MobLog.getInstance().e(th2, "[MC][MGS]", new Object[0]);
    }

    public void a(Throwable th2) {
        MobLog.getInstance().d(th2, "[MC][MGS]", new Object[0]);
    }

    public void a(String str, Throwable th2) {
        NLog instance = MobLog.getInstance();
        instance.d(th2, "[MC][MGS] " + str, new Object[0]);
    }
}
