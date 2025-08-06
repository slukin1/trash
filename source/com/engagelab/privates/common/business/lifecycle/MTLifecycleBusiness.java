package com.engagelab.privates.common.business.lifecycle;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonService;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;

public class MTLifecycleBusiness {
    private static final String TAG = "MTLifecycleBusiness";
    private static volatile MTLifecycleBusiness instance;
    private int activityFlag = 0;
    private boolean init = false;
    private MTLifecycleListener lifecycleListener;
    private boolean startServiceFlag = false;

    public static MTLifecycleBusiness getInstance() {
        if (instance == null) {
            synchronized (MTLifecycleBusiness.class) {
                instance = new MTLifecycleBusiness();
            }
        }
        return instance;
    }

    private void startCommonService(Context context) {
        if (Build.VERSION.SDK_INT >= 26 && !this.startServiceFlag && MTGlobal.isNeedRemoteProcess) {
            this.startServiceFlag = true;
            MTCommonService commonService = MTGlobal.getCommonService(context);
            if (commonService != null) {
                Intent intent = new Intent();
                intent.setClass(context, commonService.getClass());
                context.startService(intent);
            }
        }
    }

    public void init(Context context) {
        if (!this.init) {
            this.init = true;
            if (Build.VERSION.SDK_INT >= 14) {
                MTLifecycleListener mTLifecycleListener = new MTLifecycleListener();
                this.lifecycleListener = mTLifecycleListener;
                ((Application) context).registerActivityLifecycleCallbacks(mTLifecycleListener);
            }
        }
    }

    public void onActivityResumed(Context context, Bundle bundle) {
        MTGlobal.setCurrentActivityName(bundle.getString("activity"));
    }

    public void onMainLifecycleState(Context context, Bundle bundle) {
        boolean z11 = bundle.getBoolean("state");
        MTGlobal.setLifecycleState(z11);
        if (z11) {
            if (this.activityFlag == 0) {
                startCommonService(context);
                MTCommonLog.d(TAG, "toForeground currentActivity:" + MTGlobal.getCurrentActivityName());
                MTCommonPrivatesApi.sendMessageToMainProcess(context, 1005, bundle);
                if (MTGlobal.isNeedRemoteProcess) {
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.TO_FOREGROUND, bundle);
                }
            }
            this.activityFlag++;
            return;
        }
        int i11 = this.activityFlag;
        if (i11 > 0) {
            this.activityFlag = i11 - 1;
        }
        if (this.activityFlag == 0) {
            MTCommonLog.d(TAG, "toBackground currentActivity:" + MTGlobal.getCurrentActivityName());
            MTCommonPrivatesApi.sendMessageToMainProcess(context, 1006, bundle);
            if (MTGlobal.isNeedRemoteProcess) {
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.TO_BACKGROUND, bundle);
            }
        }
    }

    public void onRemoteLifecycleState(Context context, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("activity");
            boolean z11 = bundle.getBoolean("state");
            MTGlobal.setCurrentActivityName(string);
            MTGlobal.setLifecycleState(z11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MTGlobal.getLifecycleState() ? "toForeground" : "toBackground");
            sb2.append(" currentActivity:");
            sb2.append(MTGlobal.getCurrentActivityName());
            MTCommonLog.d(TAG, sb2.toString());
        }
    }

    public void release(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            ((Application) context).unregisterActivityLifecycleCallbacks(this.lifecycleListener);
        }
    }
}
