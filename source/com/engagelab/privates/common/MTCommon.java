package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.business.lifecycle.MTLifecycleBusiness;
import com.engagelab.privates.common.business.network.MTNetworkBusiness;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.observer.MTObserver;

public class MTCommon extends MTObserver {
    public static final String THREAD_COMMON = "ENGAGELAB-PRIVATES-COMMON";

    public void dispatchMessage(Context context, int i11, Bundle bundle) {
        MTCommonPrivatesApi.sendMessage(context, THREAD_COMMON, i11, bundle);
    }

    public String[] getThreadName() {
        return new String[]{THREAD_COMMON};
    }

    public void handleMessage(Context context, int i11, Bundle bundle) {
        if (i11 == 1000) {
            MTMessenger.getInstance().initOnMainProcess(context);
        } else if (i11 == 1013) {
            MTLifecycleBusiness.getInstance().onActivityResumed(context, bundle);
        } else if (i11 == 1007) {
            MTNetworkBusiness.getInstance().onMainNetworkState(context, bundle);
        } else if (i11 != 1008) {
            switch (i11) {
                case MTCommonConstants.RemoteWhat.TO_BACKGROUND /*1994*/:
                case MTCommonConstants.RemoteWhat.TO_FOREGROUND /*1995*/:
                    MTLifecycleBusiness.getInstance().onRemoteLifecycleState(context, bundle);
                    return;
                case MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED /*1996*/:
                case MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED /*1997*/:
                    MTNetworkBusiness.getInstance().onRemoteNetworkState(context, bundle);
                    return;
                default:
                    return;
            }
        } else {
            MTLifecycleBusiness.getInstance().onMainLifecycleState(context, bundle);
        }
    }

    public boolean isSupport(int i11) {
        if (i11 == 1000 || i11 == 1013 || i11 == 1007 || i11 == 1008) {
            return true;
        }
        switch (i11) {
            case MTCommonConstants.RemoteWhat.TO_BACKGROUND /*1994*/:
            case MTCommonConstants.RemoteWhat.TO_FOREGROUND /*1995*/:
            case MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED /*1996*/:
            case MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED /*1997*/:
                return true;
            default:
                return false;
        }
    }
}
