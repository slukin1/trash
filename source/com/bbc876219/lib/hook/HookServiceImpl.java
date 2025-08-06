package com.bbc876219.lib.hook;

import android.content.Context;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;
import com.bbc876219.lib.zlog.Log;
import g3.b;

@MultiInstancesServiceImpl(dependencies = {}, hookPoints = {"com.example.maindemo.BaseApplication.attachBaseContext"}, index = 0, isCacheIns = false, isHookAfter = false, isHookBefore = true, sdkVersion = 0, serviceclass = InsertMethodHookService.class)
public class HookServiceImpl implements InsertMethodHookService {
    public void hookAfter(Object obj, Object[] objArr) {
    }

    public void hookBefore(Object obj, Object[] objArr) {
        Log.b("HookServiceImpl", "hookBefore() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
        b.e((Context) obj);
    }

    public boolean isRunInMainThread() {
        return false;
    }
}
