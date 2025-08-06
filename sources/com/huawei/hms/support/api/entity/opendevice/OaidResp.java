package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class OaidResp extends AbstractMessageEntity {
    @Packed

    /* renamed from: id  reason: collision with root package name */
    private String f38489id;
    @Packed
    private boolean isTrackLimited;
    @Packed
    private PendingIntent settingIntent;

    public String getId() {
        return this.f38489id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String str) {
        this.f38489id = str;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean z11) {
        this.isTrackLimited = z11;
    }
}
