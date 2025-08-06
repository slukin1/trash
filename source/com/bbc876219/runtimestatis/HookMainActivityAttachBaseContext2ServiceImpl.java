package com.bbc876219.runtimestatis;

import androidx.fragment.app.FragmentActivity;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;
import com.bbc876219.lib.zlog.ZLog;

@MultiInstancesServiceImpl(appId = "com.example.maindemo", dependencies = {HookMainActivityAttachBaseContext3ServiceImpl.class}, hookPoints = {"com.example.maindemo.MainActivity.attachBaseContext"}, index = 2, isCacheIns = false, isHookAfter = true, isHookBefore = false, sdkVersion = 4, serviceclass = InsertMethodHookService.class)
public class HookMainActivityAttachBaseContext2ServiceImpl implements InsertMethodHookService {
    public void hookAfter(Object obj, Object[] objArr) {
        ZLog.b("MainActivity2.attachBaseContext", "hookAfter() called with: activity = [" + obj + "], objects = [" + objArr + "]");
    }

    public void hookBefore(Object obj, Object[] objArr) {
        if (obj instanceof FragmentActivity) {
            ZLog.b("MainActivity2.attachBaseContext", "hookBefore() called with: activity = [" + obj + "], objects = [" + objArr + "]");
        }
    }

    public boolean isRunInMainThread() {
        return true;
    }
}
