package com.engagelab.privates.common.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.MTCommon;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.handler.MTHandler;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;

public class MTCommonPrivatesApi {
    public static final int SDK_VERSION_CODE = 300;
    public static final String SDK_VERSION_NAME = "3.0.0";
    private static final String TAG = "MTCommonPrivatesApi";

    public static void buildHandler(Context context, String str) {
        MTHandler.getInstance().buildHandler(context, str);
    }

    public static void init(Context context, boolean z11) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't init with empty context");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.context = context.getApplicationContext();
            MTGlobal.isNeedRemoteProcess = z11 || MTGlobal.isNeedRemoteProcess;
            if (MTGlobal.isMainProcess(context.getApplicationContext())) {
                sendMessage(context, MTCommon.THREAD_COMMON, 1000, (Bundle) null);
            }
        }
    }

    public static void observer(Context context, MTObserver mTObserver) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't observer with empty context");
        } else if (!MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonLog.e(TAG, "can't observer in another process");
        } else {
            MTObservable.getInstance().observer(context.getApplicationContext(), mTObserver);
        }
    }

    public static void releaseHandler(Context context, String str) {
        MTHandler.getInstance().releaseHandler(context, str);
    }

    public static void removeMessages(Context context, String str, int i11) {
        MTHandler.getInstance().removeMessages(context, str, i11);
    }

    public static void sendMessage(Context context, String str, int i11, Bundle bundle) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessage with empty context");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "can't sendMessage with empty name");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTHandler.getInstance().sendMessage(context, str, i11, bundle);
        } else {
            MTCommonLog.e(TAG, "can't sendMessage in another process");
        }
    }

    public static void sendMessageDelayed(Context context, String str, int i11, Bundle bundle, long j11) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessageDelayed with empty context");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "can't sendMessageDelayed with empty name");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTHandler.getInstance().sendMessageDelayed(context, str, i11, bundle, j11);
        } else {
            MTCommonLog.e(TAG, "can't sendMessageDelayed in another process");
        }
    }

    public static void sendMessageToMainProcess(Context context, int i11, Bundle bundle) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessageToMainProcess with empty context");
        } else {
            MTMessenger.getInstance().sendMessageToMainProcess(context.getApplicationContext(), i11, bundle);
        }
    }

    public static void sendMessageToRemoteProcess(Context context, int i11, Bundle bundle) {
        if (context == null) {
            MTCommonLog.e(TAG, "can't sendMessageToRemoteProcess with empty context");
        } else {
            MTMessenger.getInstance().sendMessageToRemoteProcess(context.getApplicationContext(), i11, bundle);
        }
    }

    public static void buildHandler(Context context, String str, int i11) {
        MTHandler.getInstance().buildHandler(context, str, i11);
    }
}
