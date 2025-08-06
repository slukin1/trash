package xu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.huobi.woodpecker.kalle.connect.NetworkChecker;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class a implements e {

    /* renamed from: b  reason: collision with root package name */
    public final Context f23440b;

    /* renamed from: c  reason: collision with root package name */
    public final C0212a f23441c;

    /* renamed from: xu.a$a  reason: collision with other inner class name */
    public static class C0212a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public NetworkChecker f23442a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f23443b;

        public C0212a(NetworkChecker networkChecker) {
            this.f23442a = networkChecker;
            this.f23443b = networkChecker.a();
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            this.f23443b = this.f23442a.a();
        }
    }

    public a(Context context) {
        this.f23440b = context;
        C0212a aVar = new C0212a(new NetworkChecker(context));
        this.f23441c = aVar;
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
        return this.f23441c.f23443b;
    }
}
