package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

public interface AnyClient {

    public interface CallBack {
        void onCallback(IMessageEntity iMessageEntity, String str);
    }

    void connect(int i11);

    void connect(int i11, boolean z11);

    void disconnect();

    int getRequestHmsVersionCode();

    String getSessionId();

    boolean isConnected();

    boolean isConnecting();

    void post(IMessageEntity iMessageEntity, String str, CallBack callBack);
}
