package com.huobi.vulcan.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import ku.c;
import lu.a;

public class ScreenStatusBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static ScreenStatusBroadcastReceiver f20598a;

    public static void a(Context context) {
        if (f20598a == null) {
            f20598a = new ScreenStatusBroadcastReceiver();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            context.registerReceiver(f20598a, new IntentFilter("android.intent.action.SCREEN_OFF"), 2);
            context.registerReceiver(f20598a, new IntentFilter("android.intent.action.SCREEN_ON"), 2);
            return;
        }
        context.registerReceiver(f20598a, new IntentFilter("android.intent.action.SCREEN_OFF"));
        context.registerReceiver(f20598a, new IntentFilter("android.intent.action.SCREEN_ON"));
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            a.f("ScreenStatusBroadcastReceiver", "screen off-");
            c.q().i();
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            a.f("ScreenStatusBroadcastReceiver", "screen on-");
            c.q().l();
        }
    }
}
