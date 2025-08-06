package com.engagelab.privates.common.handler;

import android.os.HandlerThread;
import com.engagelab.privates.common.log.MTCommonLog;

public class CommonHandlerThread extends HandlerThread {
    private static final String TAG = "CommonHandlerThread";

    public CommonHandlerThread(String str) {
        super(str);
    }

    public void run() {
        try {
            super.run();
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "run failed " + th2.getMessage());
        }
    }
}
