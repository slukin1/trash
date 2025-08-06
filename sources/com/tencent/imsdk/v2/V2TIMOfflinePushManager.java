package com.tencent.imsdk.v2;

public abstract class V2TIMOfflinePushManager {
    public static V2TIMOfflinePushManager getInstance() {
        return V2TIMOfflinePushManagerImpl.getInstance();
    }

    public abstract void doBackground(int i11, V2TIMCallback v2TIMCallback);

    public abstract void doForeground(V2TIMCallback v2TIMCallback);

    public abstract void setOfflinePushConfig(V2TIMOfflinePushConfig v2TIMOfflinePushConfig, V2TIMCallback v2TIMCallback);
}
