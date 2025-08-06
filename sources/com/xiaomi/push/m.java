package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Handler f52373a;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f3254a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f52374b;

    public static Handler a() {
        if (f52374b == null) {
            synchronized (f3254a) {
                if (f52374b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    f52374b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f52374b;
    }

    private static Handler b() {
        if (f52373a == null) {
            synchronized (m.class) {
                if (f52373a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f52373a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f52373a;
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i11) {
        return a(context, broadcastReceiver, intentFilter, (String) null, i11);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i11) {
        return a(context, broadcastReceiver, intentFilter, str, b(), i11);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i11) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i11);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }
}
