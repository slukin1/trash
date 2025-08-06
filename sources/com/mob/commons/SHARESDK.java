package com.mob.commons;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.d;

public class SHARESDK implements MobProduct {
    private void initBusiness() {
        try {
            d.a();
        } catch (Throwable unused) {
        }
    }

    public String getProductTag() {
        initBusiness();
        return ShareSDK.SDK_TAG;
    }

    public int getSdkver() {
        initBusiness();
        return ShareSDK.SDK_VERSION_CODE;
    }
}
