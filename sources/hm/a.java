package hm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.huobi.kalle.connect.NetworkChecker;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class a implements e {

    /* renamed from: b  reason: collision with root package name */
    public final Context f76189b;

    /* renamed from: c  reason: collision with root package name */
    public final C0807a f76190c;

    /* renamed from: hm.a$a  reason: collision with other inner class name */
    public static class C0807a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public NetworkChecker f76191a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f76192b;

        public C0807a(NetworkChecker networkChecker) {
            this.f76191a = networkChecker;
            this.f76192b = networkChecker.a();
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            this.f76192b = this.f76191a.a();
        }
    }

    public a(Context context) {
        this.f76189b = context;
        C0807a aVar = new C0807a(new NetworkChecker(context));
        this.f76190c = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.ethernet.STATE_CHANGE");
        intentFilter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (Build.VERSION.SDK_INT >= 26) {
            context.registerReceiver(aVar, intentFilter, 2);
        } else {
            context.registerReceiver(aVar, intentFilter);
        }
    }

    public boolean isAvailable() {
        return this.f76190c.f76192b;
    }
}
