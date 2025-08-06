package com.bbc876219.runtimestatis;

import android.util.Log;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;

@MultiInstancesServiceImpl(dependencies = {}, hookPoints = {"com.huobi.app.HuobiApplication.onBaseContextAttached"}, index = 0, isCacheIns = false, isHookAfter = false, isHookBefore = true, process = {"pro.huobi"}, sdkVersion = 0, serviceclass = InsertMethodHookService.class)
public class DemoIoWatchAppAttachBaseServiceImpl implements InsertMethodHookService {

    /* renamed from: a  reason: collision with root package name */
    public static IOWatchManager f63267a;

    public void hookAfter(Object obj, Object[] objArr) {
        Log.d("IoWatchAppAttachBase", "hookAfter() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
    }

    public void hookBefore(Object obj, Object[] objArr) {
        Log.d("IoWatchAppAttachBase", "hookBefore() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
        f63267a = IOWatchManager.d().b("/sdcard/Android/data/video").a(objArr[0].getDataDir()).f();
    }

    public boolean isRunInMainThread() {
        Log.d("IoWatchAppAttachBase", "isRunInMainThread() called return false");
        return false;
    }
}
