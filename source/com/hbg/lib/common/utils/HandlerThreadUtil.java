package com.hbg.lib.common.utils;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

public class HandlerThreadUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, HandlerThread> f67485a;

    public static synchronized Looper a(String str) {
        Looper looper;
        synchronized (HandlerThreadUtil.class) {
            if (f67485a == null) {
                f67485a = new HashMap();
            }
            HandlerThread handlerThread = f67485a.get(str);
            if (handlerThread == null) {
                handlerThread = new HandlerThread(str);
                handlerThread.start();
                f67485a.put(str, handlerThread);
            }
            looper = handlerThread.getLooper();
        }
        return looper;
    }
}
