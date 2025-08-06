package com.mob.mcl.d;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f27527a = new b();

    private b() {
    }

    public static b a() {
        return f27527a;
    }

    public void b(String str) {
        NLog instance = MobLog.getInstance();
        instance.d("[MC][MCL]" + str, new Object[0]);
    }

    public void a(String str) {
        NLog instance = MobLog.getInstance();
        instance.d("[MC][MCL]" + str, new Object[0]);
    }

    public void a(Throwable th2) {
        MobLog.getInstance().d(th2, "%s", "[MC][MCL]");
    }

    public void a(String str, Throwable th2) {
        NLog instance = MobLog.getInstance();
        instance.d(th2, "%s", "[MC][MCL] " + str);
    }
}
