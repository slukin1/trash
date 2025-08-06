package com.huobi.app.startuptasks;

import android.app.Application;
import com.hbg.lib.common.BaseApplication;

public abstract class BaseAppStartTask {
    public final Application a() {
        return BaseApplication.b();
    }

    public String b() {
        return getClass().getSimpleName();
    }

    public abstract void c();
}
