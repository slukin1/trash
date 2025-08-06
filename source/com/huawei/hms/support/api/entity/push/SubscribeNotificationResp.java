package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class SubscribeNotificationResp implements IMessageEntity {
    @Packed
    private int retCode = -1;
    @Packed
    private String subscribeResults;

    public int getRetCode() {
        return this.retCode;
    }

    public String getSubscribeResults() {
        return this.subscribeResults;
    }

    public void setRetCode(int i11) {
        this.retCode = i11;
    }

    public void setSubscribeResults(String str) {
        this.subscribeResults = str;
    }
}
