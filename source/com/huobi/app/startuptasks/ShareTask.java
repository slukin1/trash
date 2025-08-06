package com.huobi.app.startuptasks;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.model.ServerHosts;
import com.mob.MobSDK;

public final class ShareTask extends BaseAppStartTask {
    public void c() {
        KakaoSdk.f(a(), "03dfd30cef5c32ec299514f3f962c2ec", (String) null, (Boolean) null, (ServerHosts) null, (ApprovalType) null, (SdkIdentifier) null, 124, (Object) null);
        MobSDK.submitPolicyGrantResult(true);
    }
}
