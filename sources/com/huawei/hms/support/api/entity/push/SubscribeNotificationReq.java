package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class SubscribeNotificationReq implements IMessageEntity {
    @Packed
    private String entityIds;
    @Packed
    private String token;

    public String getEntityIds() {
        return this.entityIds;
    }

    public String getToken() {
        return this.token;
    }

    public void setEntityIds(String str) {
        this.entityIds = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
