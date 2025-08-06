package com.huobi.app;

import android.util.Log;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;

@MultiInstancesServiceImpl(dependencies = {}, hookPoints = {"com.huobi.app.HuobiMainApplication.attachBaseContext"}, index = 0, isCacheIns = false, isHookAfter = false, isHookBefore = true, process = {"pro.huobi"}, sdkVersion = 0, serviceclass = InsertMethodHookService.class)
public class HuobiIoWatchAppAttachBaseServiceImpl implements InsertMethodHookService {
    public void hookAfter(Object obj, Object[] objArr) {
        Log.d("IoWatchAppAttachBase", "hookAfter() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
    }

    public void hookBefore(Object obj, Object[] objArr) {
        Log.d("IoWatchAppAttachBase", "hookBefore() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
    }

    public boolean isRunInMainThread() {
        Log.d("IoWatchAppAttachBase", "isRunInMainThread() called return false");
        return false;
    }
}
