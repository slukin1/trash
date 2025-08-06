package com.bbc876219.runtimestatis;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.HomeActivityAttachBaseContextService;

@MultiInstancesServiceImpl
public class HomeActivityAttachBaseContextServiceImpl implements HomeActivityAttachBaseContextService {
    @SuppressLint({"LongLogTag"})
    public void attachBaseContext(FragmentActivity fragmentActivity) {
        Log.d("HomeActivityAttachBaseContextServiceImpl", "attachBaseContext: " + fragmentActivity);
        fragmentActivity.getSupportFragmentManager().r1(new RunTimeStatisFragmentLifecycleCallbacks(), false);
    }

    public boolean isRunInMainThread() {
        return true;
    }
}
