package com.tencent.imsdk.v2;

import com.tencent.imsdk.offlinePush.OfflinePushToken;
import java.io.Serializable;

public class V2TIMOfflinePushConfig implements Serializable {
    private OfflinePushToken offlinePushToken;

    public V2TIMOfflinePushConfig(long j11, String str) {
        OfflinePushToken offlinePushToken2 = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken2;
        offlinePushToken2.setBusinessID((int) j11);
        this.offlinePushToken.setDeviceToken(str);
        this.offlinePushToken.setIsTPNSToken(false);
    }

    public OfflinePushToken getOfflinePushToken() {
        return this.offlinePushToken;
    }

    @Deprecated
    public V2TIMOfflinePushConfig(long j11, String str, boolean z11) {
        OfflinePushToken offlinePushToken2 = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken2;
        offlinePushToken2.setBusinessID((int) j11);
        this.offlinePushToken.setDeviceToken(str);
        this.offlinePushToken.setIsTPNSToken(z11);
    }
}
