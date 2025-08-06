package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OdidResp extends AbstractMessageEntity {
    @Packed

    /* renamed from: id  reason: collision with root package name */
    private String f38490id;

    public String getId() {
        return this.f38490id;
    }

    public void setId(String str) {
        this.f38490id = str;
    }
}
