package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.m;

public final class NotificationClickedActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private long f51288a;

    /* renamed from: a  reason: collision with other field name */
    private BroadcastReceiver f2441a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f2442a;

    /* renamed from: b  reason: collision with root package name */
    private long f51289b;

    private void a(Intent intent) {
        if (intent != null) {
            try {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    intent2.putExtra("nca_create_time", this.f51288a);
                    intent2.putExtra("nca_resume_time", this.f51289b);
                    b.a("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                    return;
                }
                b.d("PushClickedActivity", "clicked activity start service, newIntent is null");
            } catch (Exception e11) {
                b.a((Throwable) e11);
            }
        } else {
            b.d("PushClickedActivity", "clicked activity start service, missing intent");
        }
    }

    public void onCreate(Bundle bundle) {
        this.f51288a = System.currentTimeMillis();
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = BadgeDrawable.TOP_START;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f2442a = handler;
        handler.postDelayed(new Runnable() {
            public void run() {
                b.e("clicked activity finish by timeout.");
                NotificationClickedActivity.this.finish();
            }
        }, 3000);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        AnonymousClass2 r42 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                b.b("clicked activity finish by normal.");
                NotificationClickedActivity.this.finish();
            }
        };
        this.f2441a = r42;
        try {
            m.a(this, r42, intentFilter, c.a(this), (Handler) null, 4);
        } catch (Exception unused) {
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f2442a.removeCallbacksAndMessages((Object) null);
        try {
            unregisterReceiver(this.f2441a);
        } catch (Exception unused) {
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        this.f51289b = System.currentTimeMillis();
        super.onResume();
        a(getIntent());
    }
}
