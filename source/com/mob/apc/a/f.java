package com.mob.apc.a;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f26883a = new f();

    private f() {
    }

    public static f a() {
        return f26883a;
    }

    public void b(String str, Object... objArr) {
        NLog instance = MobLog.getInstance();
        instance.i("[MC][APC]" + String.format(str, objArr));
    }

    public void a(Throwable th2) {
        MobLog.getInstance().d(th2, "%s", "[MC][APC]");
    }

    public void a(String str, Object... objArr) {
        NLog instance = MobLog.getInstance();
        instance.d("[MC][APC]" + String.format(str, objArr), new Object[0]);
    }
}
