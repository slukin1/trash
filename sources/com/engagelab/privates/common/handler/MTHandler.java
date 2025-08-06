package com.engagelab.privates.common.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.engagelab.privates.common.log.MTCommonLog;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;

public class MTHandler {
    private static final int DEFAULT_RELEASE_INTERVAL = 300000;
    private static final String TAG = "MTHandler";
    private static volatile MTHandler instance;
    private final ConcurrentHashMap<String, CommonHandler> handlerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, CommonHandlerThread> handlerThreadMap = new ConcurrentHashMap<>();

    public static MTHandler getInstance() {
        if (instance == null) {
            synchronized (MTHandler.class) {
                instance = new MTHandler();
            }
        }
        return instance;
    }

    public CommonHandler buildHandler(Context context, String str) {
        return buildHandler(context, str, DEFAULT_RELEASE_INTERVAL);
    }

    public void releaseHandler(Context context, String str) {
        try {
            if (this.handlerMap.containsKey(str)) {
                CommonHandler commonHandler = this.handlerMap.get(str);
                if (commonHandler != null) {
                    MTCommonLog.d(TAG, "releaseHandler:" + str);
                    commonHandler.removeCallbacksAndMessages((Object) null);
                }
                this.handlerMap.remove(str);
            }
            if (this.handlerThreadMap.containsKey(str)) {
                CommonHandlerThread commonHandlerThread = this.handlerThreadMap.get(str);
                if (commonHandlerThread != null) {
                    commonHandlerThread.quit();
                }
                this.handlerThreadMap.remove(str);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "releaseHandler failed " + th2.getMessage());
        }
    }

    public void removeMessages(Context context, String str, int i11) {
        try {
            CommonHandler buildHandler = buildHandler(context, str);
            if (buildHandler != null) {
                buildHandler.removeMessages(i11);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "removeMessages failed " + th2.getMessage());
        }
    }

    public void sendMessage(Context context, String str, int i11, Bundle bundle) {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 0;
            obtain.obj = str;
            obtain.what = i11;
            obtain.setData(bundle);
            CommonHandler buildHandler = buildHandler(context, str);
            if (buildHandler != null) {
                buildHandler.sendMessage(obtain);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "sendMessage failed " + th2.getMessage());
        }
    }

    public void sendMessageDelayed(Context context, String str, int i11, Bundle bundle, long j11) {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 1;
            obtain.obj = str;
            obtain.what = i11;
            obtain.setData(bundle);
            CommonHandler buildHandler = buildHandler(context, str);
            if (buildHandler != null) {
                buildHandler.sendMessageDelayed(obtain, j11);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "sendMessageDelayed failed " + th2.getMessage());
        }
    }

    public synchronized CommonHandler buildHandler(Context context, String str, int i11) {
        CommonHandler commonHandler;
        try {
            CommonHandlerThread commonHandlerThread = this.handlerThreadMap.get(str);
            if (commonHandlerThread == null) {
                commonHandlerThread = new CommonHandlerThread(str);
                this.handlerThreadMap.put(str, commonHandlerThread);
            }
            if (commonHandlerThread.getState() == Thread.State.NEW) {
                commonHandlerThread.start();
            }
            commonHandler = this.handlerMap.get(str);
            if (commonHandlerThread.getState() == Thread.State.TERMINATED) {
                if (commonHandler != null) {
                    commonHandler.removeCallbacksAndMessages((Object) null);
                }
                commonHandlerThread = new CommonHandlerThread(str);
                commonHandlerThread.start();
                this.handlerThreadMap.put(str, commonHandlerThread);
                commonHandler = new CommonHandler(commonHandlerThread.getLooper(), context, i11);
                this.handlerMap.put(str, commonHandler);
                MTCommonLog.d(TAG, "buildHandler：" + str);
            }
            if (commonHandler == null) {
                commonHandler = new CommonHandler(commonHandlerThread.getLooper(), context, i11);
                this.handlerMap.put(str, commonHandler);
                MTCommonLog.d(TAG, "buildHandler：" + str);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "buildHandler failed " + th2.getMessage());
            return null;
        }
        return commonHandler;
    }
}
