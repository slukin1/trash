package com.bbc876219.runtimestatis;

import android.app.Application;
import android.util.Log;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.AppAttachBaseContextService;
import j3.a;

@MultiInstancesServiceImpl
public class RunTimeStatisInitAppServiceImpl implements AppAttachBaseContextService {
    public void attachBaseContext(Application application) {
        Log.d("RunTimeStatisInitAppSer", "attachBaseContext: " + application);
        RunTimeStatisManager.installBlockManager(application, new a(50));
    }

    public boolean isRunInMainThread() {
        return true;
    }
}
