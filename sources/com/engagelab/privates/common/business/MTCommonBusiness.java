package com.engagelab.privates.common.business;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;
import java.util.Iterator;

public class MTCommonBusiness {
    private static final String TAG = "MTCommonBusiness";
    private static volatile MTCommonBusiness instance;

    public static MTCommonBusiness getInstance() {
        if (instance == null) {
            synchronized (MTCommonBusiness.class) {
                instance = new MTCommonBusiness();
            }
        }
        return instance;
    }

    public void init(Context context) {
        Iterator<String> it2 = MTObservable.getInstance().observeNameQueue.iterator();
        while (it2.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString(MTCommonConstants.Observer.KEY_OBSERVER_NAME, it2.next());
            MTMessenger.getInstance().sendMessageToRemoteProcess(context, 101, bundle);
        }
        try {
            Object newInstance = Class.forName("com.engagelab.privates.collect.MTCollect").newInstance();
            if (newInstance instanceof MTObserver) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), (MTObserver) newInstance);
            }
        } catch (Throwable unused) {
        }
        try {
            Object newInstance2 = Class.forName("com.engagelab.privates.geofence.MTGeofence").newInstance();
            if (newInstance2 instanceof MTObserver) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), (MTObserver) newInstance2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Object newInstance3 = Class.forName("cn.jiguang.privates.wake.MTWake").newInstance();
            if (newInstance3 instanceof MTObserver) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), (MTObserver) newInstance3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void release(Context context) {
    }
}
