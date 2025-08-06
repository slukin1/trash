package com.huobi.app;

import android.app.Application;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;
import com.bbc876219.lib.zlog.Log;
import com.bbc876219.runtimestatis.RunTimeStatisManager;
import j3.a;

@MultiInstancesServiceImpl(dependencies = {}, hookPoints = {"com.huobi.app.HuobiMainApplication.attachBaseContext"}, index = 0, isCacheIns = false, isHookAfter = false, isHookBefore = true, process = {"pro.huobi"}, sdkVersion = 0, serviceclass = InsertMethodHookService.class)
public class HuobiRuntimeStatisAppAttachBaseServiceImpl implements InsertMethodHookService {
    public void hookAfter(Object obj, Object[] objArr) {
        Log.b("RuntimeStatis", "hookAfter() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
    }

    public void hookBefore(Object obj, Object[] objArr) {
        Log.b("RuntimeStatis", "hookBefore() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
        a aVar = new a(40);
        aVar.setStatisticSubThread(false);
        RunTimeStatisManager.installBlockManager((Application) obj, aVar);
    }

    public boolean isRunInMainThread() {
        Log.b("RuntimeStatis", "isRunInMainThread() called return false");
        return false;
    }
}
