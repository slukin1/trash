package com.bbc876219.runtimestatis;

import android.util.Log;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.AppOnCreateService;

@MultiInstancesServiceImpl
public class RunTimeStatisOnCreateServiceImpl implements AppOnCreateService {
    public boolean isRunInMainThread() {
        return true;
    }

    public void onCreate() {
        Log.d("RunTimeStatisInitAppSer", "onCreate() called");
    }
}
