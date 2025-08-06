package com.huawei.agconnect;

import com.huawei.agconnect.core.a.a;

public abstract class AGCInitFinishManager {
    private static final AGCInitFinishManager INSTANCE = new a();

    public interface AGCInitFinishCallback {
        void onFinish();
    }

    public static AGCInitFinishManager getInstance() {
        return INSTANCE;
    }

    public abstract void addAGCInitFinishCallback(AGCInitFinishCallback aGCInitFinishCallback);
}
