package com.engagelab.privates.common.binder;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;

public class RemoteMessengerHandler extends Handler {
    private static final String TAG = "RemoteMessengerHandler";
    private final Context context;

    public RemoteMessengerHandler(Context context2, Looper looper) {
        super(looper);
        this.context = context2;
    }

    public void handleMessage(Message message) {
        try {
            MTMessenger.getInstance().initMainMessenger(message.replyTo);
            int i11 = message.what;
            Bundle data = message.getData();
            if (i11 == 101) {
                MTObservable.getInstance().observerOnRemoteProcess(this.context, data);
            } else {
                MTObservable.getInstance().dispatchMessage(this.context, i11, data);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "handleMessage failed " + th2.getMessage());
        }
    }
}
