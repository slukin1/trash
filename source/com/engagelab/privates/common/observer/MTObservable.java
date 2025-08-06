package com.engagelab.privates.common.observer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MTObservable {
    private static final String TAG = "MTObservable";
    public static final int WHAT_OBSERVER = 101;
    private static volatile MTObservable instance;
    public ConcurrentLinkedQueue<String> observeNameQueue = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<MTObserver> observeQueue = new ConcurrentLinkedQueue<>();

    public static MTObservable getInstance() {
        if (instance == null) {
            synchronized (MTObservable.class) {
                instance = new MTObservable();
            }
        }
        return instance;
    }

    public void dispatchMessage(Context context, int i11, Bundle bundle) {
        Iterator<MTObserver> it2 = this.observeQueue.iterator();
        while (it2.hasNext()) {
            MTObserver next = it2.next();
            if (next.isSupport(i11)) {
                next.dispatchMessage(context, i11, bundle);
            }
        }
    }

    public void handleMessage(Context context, int i11, String str, int i12, Bundle bundle) {
        Iterator<MTObserver> it2 = this.observeQueue.iterator();
        while (it2.hasNext()) {
            MTObserver next = it2.next();
            if (Arrays.asList(next.getThreadName()).contains(str) && next.isSupport(i12)) {
                if (i11 == 0) {
                    next.handleMessage(context, i12, bundle);
                }
                if (i11 == 1) {
                    next.handleDelayMessage(context, i12, bundle);
                }
            }
        }
    }

    public void observer(Context context, MTObserver mTObserver) {
        if (!this.observeQueue.contains(mTObserver)) {
            String canonicalName = mTObserver.getClass().getCanonicalName();
            if (!this.observeNameQueue.contains(canonicalName)) {
                MTCommonLog.d(TAG, "observer " + canonicalName);
                this.observeQueue.add(mTObserver);
                this.observeNameQueue.add(canonicalName);
                Bundle bundle = new Bundle();
                bundle.putString(MTCommonConstants.Observer.KEY_OBSERVER_NAME, canonicalName);
                if (MTGlobal.isMainProcess(context)) {
                    boolean lifecycleState = MTGlobal.getLifecycleState();
                    String currentActivityName = MTGlobal.getCurrentActivityName();
                    if (!TextUtils.isEmpty(currentActivityName)) {
                        bundle.putBoolean("state", lifecycleState);
                        bundle.putString("activity", currentActivityName);
                        if (mTObserver.isSupport(1005) || mTObserver.isSupport(1006)) {
                            mTObserver.dispatchMessage(context, 1005, (Bundle) null);
                        }
                    }
                    boolean networkState = MTGlobal.getNetworkState();
                    int networkType = MTGlobal.getNetworkType();
                    String networkName = MTGlobal.getNetworkName();
                    String networkRadio = MTGlobal.getNetworkRadio();
                    if (!TextUtils.isEmpty(networkRadio)) {
                        bundle.putBoolean("state", networkState);
                        bundle.putInt("type", networkType);
                        bundle.putString("name", networkName);
                        bundle.putString(MTCommonConstants.Network.KEY_RADIO, networkRadio);
                        int i11 = 1003;
                        if (mTObserver.isSupport(1003) || mTObserver.isSupport(1004)) {
                            if (!networkState) {
                                i11 = 1004;
                            }
                            mTObserver.dispatchMessage(context, i11, (Bundle) null);
                        }
                    }
                }
                MTMessenger.getInstance().sendMessageToRemoteProcess(context, 101, bundle);
            }
        }
    }

    public void observerOnRemoteProcess(Context context, Bundle bundle) {
        try {
            String string = bundle.getString(MTCommonConstants.Observer.KEY_OBSERVER_NAME);
            if (!this.observeNameQueue.contains(string)) {
                Object newInstance = Class.forName(string).newInstance();
                if (newInstance instanceof MTObserver) {
                    MTObserver mTObserver = (MTObserver) newInstance;
                    observer(context, mTObserver);
                    boolean z11 = bundle.getBoolean("state");
                    String string2 = bundle.getString("activity");
                    if (!TextUtils.isEmpty(string2)) {
                        MTGlobal.setLifecycleState(z11);
                        MTGlobal.setCurrentActivityName(string2);
                        int i11 = MTCommonConstants.RemoteWhat.TO_FOREGROUND;
                        if (mTObserver.isSupport(MTCommonConstants.RemoteWhat.TO_FOREGROUND) || mTObserver.isSupport(MTCommonConstants.RemoteWhat.TO_BACKGROUND)) {
                            if (!z11) {
                                i11 = 1994;
                            }
                            mTObserver.dispatchMessage(context, i11, (Bundle) null);
                        }
                    }
                    boolean z12 = bundle.getBoolean("state");
                    int i12 = bundle.getInt("type");
                    String string3 = bundle.getString("name");
                    String string4 = bundle.getString(MTCommonConstants.Network.KEY_RADIO);
                    if (!TextUtils.isEmpty(string4)) {
                        MTGlobal.setNetworkState(z12);
                        MTGlobal.setNetworkType(i12);
                        MTGlobal.setNetworkName(string3);
                        MTGlobal.setNetworkRadio(string4);
                        int i13 = MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED;
                        if (mTObserver.isSupport(MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED) || mTObserver.isSupport(MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED)) {
                            if (!z11) {
                                i13 = 1996;
                            }
                            mTObserver.dispatchMessage(context, i13, (Bundle) null);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "observer failed " + th2.getMessage());
        }
    }
}
