package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.offlinePush.EnterBackgroundParam;
import com.tencent.imsdk.offlinePush.EnterForegroundParam;
import com.tencent.imsdk.offlinePush.OfflinePushManager;

public class V2TIMOfflinePushManagerImpl extends V2TIMOfflinePushManager {
    private final String TAG = "V2TIMOfflinePushManagerImpl";

    public static class V2TIMOfflinePushManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMOfflinePushManagerImpl v2TIMOfflinePushManagerImpl = new V2TIMOfflinePushManagerImpl();

        private V2TIMOfflinePushManagerImplHolder() {
        }
    }

    public static V2TIMOfflinePushManagerImpl getInstance() {
        return V2TIMOfflinePushManagerImplHolder.v2TIMOfflinePushManagerImpl;
    }

    public void doBackground(int i11, V2TIMCallback v2TIMCallback) {
        if (i11 < 0) {
            i11 = 0;
        }
        int instanceType = SystemUtil.getInstanceType();
        EnterBackgroundParam enterBackgroundParam = new EnterBackgroundParam();
        enterBackgroundParam.setC2cUnreadMessageCount(i11);
        enterBackgroundParam.setDeviceBrand(instanceType);
        OfflinePushManager.getInstance().doEnterBackground(enterBackgroundParam, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void doForeground(V2TIMCallback v2TIMCallback) {
        int instanceType = SystemUtil.getInstanceType();
        EnterForegroundParam enterForegroundParam = new EnterForegroundParam();
        enterForegroundParam.setDeviceBrand(instanceType);
        OfflinePushManager.getInstance().doEnterForeground(enterForegroundParam, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setOfflinePushConfig(V2TIMOfflinePushConfig v2TIMOfflinePushConfig, V2TIMCallback v2TIMCallback) {
        if (v2TIMOfflinePushConfig == null) {
            v2TIMOfflinePushConfig = new V2TIMOfflinePushConfig(0, "");
        }
        v2TIMOfflinePushConfig.getOfflinePushToken().setDeviceBrand(SystemUtil.getInstanceType());
        OfflinePushManager.getInstance().setOfflinePushToken(v2TIMOfflinePushConfig.getOfflinePushToken(), new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
        BaseManager.getInstance().checkTUIComponent(7);
    }
}
