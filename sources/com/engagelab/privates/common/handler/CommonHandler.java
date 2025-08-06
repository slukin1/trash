package com.engagelab.privates.common.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;

public class CommonHandler extends Handler {
    private static final String TAG = "CommonHandler";
    private static final int WHAT_RELEASE = -1000;
    private final Context context;
    private final int releaseInterval;

    public CommonHandler(Looper looper, Context context2, int i11) {
        super(looper);
        this.context = context2;
        this.releaseInterval = i11;
    }

    public void handleMessage(Message message) {
        try {
            int i11 = message.arg1;
            String valueOf = String.valueOf(message.obj);
            int i12 = message.what;
            Bundle data = message.getData();
            if (i12 == -1000) {
                MTHandler.getInstance().releaseHandler(this.context, getLooper().getThread().getName());
                return;
            }
            removeMessages(-1000);
            sendEmptyMessageDelayed(-1000, (long) this.releaseInterval);
            MTObservable.getInstance().handleMessage(this.context, i11, valueOf, i12, data);
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "handleMessage failed " + th2.getMessage());
        }
    }
}
