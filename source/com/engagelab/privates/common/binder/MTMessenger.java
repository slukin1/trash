package com.engagelab.privates.common.binder;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.engagelab.privates.common.business.MTCommonBusiness;
import com.engagelab.privates.common.cache.MTCommonConfig;
import com.engagelab.privates.common.component.MTCommonService;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MTMessenger {
    private static final String TAG = "MTMessenger";
    private static volatile MTMessenger instance;
    private final ConcurrentLinkedQueue<Message> mainMessageQueue = new ConcurrentLinkedQueue<>();
    private Messenger mainMessenger;
    private final ConcurrentLinkedQueue<Message> remoteMessageQueue = new ConcurrentLinkedQueue<>();
    private Messenger remoteMessenger;
    private boolean serviceFlag = false;

    public static MTMessenger getInstance() {
        if (instance == null) {
            synchronized (MTMessenger.class) {
                instance = new MTMessenger();
            }
        }
        return instance;
    }

    private boolean initConfig(Context context) {
        String appKey = MTGlobal.getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            MTCommonLog.e(TAG, "appKey is empty, please check it");
            return false;
        }
        String appChannel = MTGlobal.getAppChannel(context);
        String appProcess = MTGlobal.getAppProcess(context);
        String appVersionName = MTGlobal.getAppVersionName(context);
        int appVersionCode = MTGlobal.getAppVersionCode(context);
        MTCommonLog.d(TAG, "appVersionCode:" + appVersionCode + ", appVersionName:" + appVersionName + ", appKey:" + appKey + ", appChannel:" + appChannel + ", appProcess:" + appProcess);
        MTCommonConfig.setSdkVersionName(context, "3.0.0");
        MTCommonConfig.setSdkVersionCode(context, 300);
        MTCommonConfig.setAppKey(context, appKey);
        MTCommonConfig.setAppChannel(context, appChannel);
        return true;
    }

    public IBinder getBinder() {
        return this.remoteMessenger.getBinder();
    }

    public void initMainMessenger(Messenger messenger) {
        if (messenger != null) {
            try {
                this.mainMessenger = messenger;
                Iterator<Message> it2 = this.mainMessageQueue.iterator();
                while (it2.hasNext()) {
                    this.mainMessenger.send(it2.next());
                    it2.remove();
                }
            } catch (Throwable th2) {
                MTCommonLog.w(TAG, "initMainMessenger failed " + th2.getMessage());
            }
        }
    }

    public void initOnMainProcess(Context context) {
        try {
            if (this.mainMessenger == null) {
                MTCommonLog.i(TAG, "init common version:3.0.0");
                if (initConfig(context)) {
                    this.mainMessenger = new Messenger(new MainMessengerHandler(context, Looper.getMainLooper()));
                    Iterator<Message> it2 = this.mainMessageQueue.iterator();
                    while (it2.hasNext()) {
                        this.mainMessenger.send(it2.next());
                        it2.remove();
                    }
                } else {
                    return;
                }
            }
            if (MTGlobal.isNeedRemoteProcess && !this.serviceFlag) {
                this.serviceFlag = true;
                if (MTGlobal.getCommonService(context) == null) {
                    MTCommonLog.e(TAG, "MTCommonService is null, please create new Service extends MTCommonService");
                    return;
                }
                MTMessengerConnection mTMessengerConnection = new MTMessengerConnection(context);
                MTCommonService commonService = MTGlobal.getCommonService(context);
                if (commonService == null) {
                    MTCommonLog.e(TAG, "initOnMainProcess error, there are no service extends MTCommonService");
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(context, commonService.getClass());
                context.bindService(intent, mTMessengerConnection, 1);
                if (Build.VERSION.SDK_INT < 26) {
                    context.startService(intent);
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "initOnMainProcess failed " + th2.getMessage());
        }
    }

    public void initOnRemoteProcess(Context context) {
        try {
            if (this.remoteMessenger == null) {
                MTGlobal.isNeedRemoteProcess = true;
                MTCommonLog.i(TAG, "init common version:3.0.0");
                if (initConfig(context)) {
                    this.remoteMessenger = new Messenger(new RemoteMessengerHandler(context, Looper.getMainLooper()));
                    Iterator<Message> it2 = this.remoteMessageQueue.iterator();
                    while (it2.hasNext()) {
                        this.remoteMessenger.send(it2.next());
                        it2.remove();
                    }
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "initOnRemoteProcess failed " + th2.getMessage());
        }
    }

    public void onServiceConnected(Context context, IBinder iBinder) {
        MTCommonLog.i(TAG, "onServiceConnected");
        this.serviceFlag = true;
        MTCommonBusiness.getInstance().init(context);
        this.remoteMessenger = new Messenger(iBinder);
        try {
            Iterator<Message> it2 = this.remoteMessageQueue.iterator();
            while (it2.hasNext()) {
                this.remoteMessenger.send(it2.next());
                it2.remove();
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "sendMessageToRemoteProcess failed " + th2.getMessage());
        }
        sendMessageToMainProcess(context, 1001, (Bundle) null);
        sendMessageToRemoteProcess(context, MTCommonConstants.RemoteWhat.ON_SERVICE_CONNECTED, (Bundle) null);
    }

    public void onServiceDisconnected(Context context) {
        MTCommonLog.i(TAG, "onServiceDisconnected");
        this.serviceFlag = false;
        this.mainMessenger = null;
        this.remoteMessenger = null;
        this.mainMessageQueue.clear();
        this.remoteMessageQueue.clear();
        sendMessageToMainProcess(context, 1002, (Bundle) null);
    }

    public void sendMessageToMainProcess(Context context, int i11, Bundle bundle) {
        try {
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.setData(bundle);
            Messenger messenger = this.mainMessenger;
            if (messenger == null) {
                this.mainMessageQueue.add(obtain);
            } else {
                messenger.send(obtain);
            }
        } catch (DeadObjectException e11) {
            MTCommonLog.w(TAG, "sendMessageToMainProcess DeadObjectException " + e11.getMessage());
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "sendMessageToMainProcess failed " + th2.getMessage());
        }
    }

    public void sendMessageToRemoteProcess(Context context, int i11, Bundle bundle) {
        try {
            if (MTGlobal.isNeedRemoteProcess) {
                Message obtain = Message.obtain();
                obtain.what = i11;
                obtain.setData(bundle);
                if (MTGlobal.isMainProcess(context)) {
                    obtain.replyTo = this.mainMessenger;
                }
                Messenger messenger = this.remoteMessenger;
                if (messenger == null) {
                    this.remoteMessageQueue.add(obtain);
                } else {
                    messenger.send(obtain);
                }
            }
        } catch (DeadObjectException e11) {
            MTCommonLog.w(TAG, "sendMessageToRemoteProcess DeadObjectException " + e11.getMessage());
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "sendMessageToRemoteProcess failed " + th2.getMessage());
        }
    }
}
