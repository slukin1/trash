package com.hbg.lib.iplayer.common.util;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

public class HandlerThreadUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, HandlerThread> f69197a;

    public static synchronized Looper a(String str) {
        Looper looper;
        synchronized (HandlerThreadUtil.class) {
            if (f69197a == null) {
                f69197a = new HashMap();
            }
            HandlerThread handlerThread = f69197a.get(str);
            if (handlerThread == null) {
                handlerThread = new HandlerThread(str);
                handlerThread.start();
                f69197a.put(str, handlerThread);
            }
            looper = handlerThread.getLooper();
        }
        return looper;
    }
}
