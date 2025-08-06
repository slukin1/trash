package com.engagelab.privates.common.binder;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;

public class MainMessengerHandler extends Handler {
    private static final String TAG = "MainMessengerHandler";
    private final Context context;

    public MainMessengerHandler(Context context2, Looper looper) {
        super(looper);
        this.context = context2;
    }

    public void handleMessage(Message message) {
        try {
            MTObservable.getInstance().dispatchMessage(this.context, message.what, message.getData());
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "handleMessage failed " + th2.getMessage());
        }
    }
}
