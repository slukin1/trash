package com.bbc876219.runtimestatis;

import android.content.Context;
import android.util.Log;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;
import java.io.IOException;

@MultiInstancesServiceImpl(dependencies = {}, hookPoints = {"com.example.maindemo.BaseApplication.attachBaseContext", "com.yxcorp.gifshow.App.attachBaseContext"}, index = 0, isCacheIns = false, isHookAfter = false, isHookBefore = true, sdkVersion = 0, serviceclass = InsertMethodHookService.class)
public class IoWatchAppAttachBaseServiceImpl implements InsertMethodHookService {

    /* renamed from: a  reason: collision with root package name */
    public static IOWatchManager f63280a;

    public static String[] a(Context context, String str) {
        try {
            return context.getAssets().list(str);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public void hookAfter(Object obj, Object[] objArr) {
        Log.d("IoWatchAppAttachBase", "hookAfter() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
    }

    public void hookBefore(Object obj, Object[] objArr) {
        Log.d("IoWatchAppAttachBase", "hookBefore() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
        Context context = objArr[0];
        f63280a = IOWatchManager.d().b("/sdcard/Android/data/video").a(context.getDataDir()).c(a(context, "/")).f();
    }

    public boolean isRunInMainThread() {
        Log.d("IoWatchAppAttachBase", "isRunInMainThread() called return false");
        return false;
    }
}
