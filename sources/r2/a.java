package r2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f16442a;

    /* renamed from: b  reason: collision with root package name */
    public String f16443b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f16444c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f16445d;

    /* renamed from: r2.a$a  reason: collision with other inner class name */
    public class C0098a extends BroadcastReceiver {

        /* renamed from: r2.a$a$a  reason: collision with other inner class name */
        public class C0099a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Intent f16447b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f16448c;

            public C0099a(Intent intent, Context context) {
                this.f16447b = intent;
                this.f16448c = context;
            }

            public void run() {
                try {
                    if (!C0098a.this.isInitialStickyBroadcast() && "android.net.conn.CONNECTIVITY_CHANGE".equals(this.f16447b.getAction()) && a.i(this.f16448c)) {
                        String b11 = a.this.l();
                        if (!b11.equals("None_Network") && !b11.equalsIgnoreCase(a.this.f16443b)) {
                            Iterator it2 = a.this.f16444c.iterator();
                            while (it2.hasNext()) {
                                ((c) it2.next()).a(b11);
                            }
                        }
                        if (!b11.equals("None_Network")) {
                            String unused = a.this.f16443b = b11;
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public C0098a() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                a.this.f16445d.execute(new C0099a(intent, context));
            } catch (Exception unused) {
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f16450a = new a((C0098a) null);
    }

    public interface c {
        void a(String str);
    }

    public a() {
        this.f16443b = "None_Network";
        this.f16444c = new ArrayList<>();
        this.f16445d = w2.c.a(OptionsBridge.NETWORK_KEY);
    }

    public /* synthetic */ a(C0098a aVar) {
        this();
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static a f() {
        return b.f16450a;
    }

    public static boolean i(Context context) {
        try {
            return a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        } catch (Throwable th2) {
            HttpDnsLog.j("check network info permission fail", th2);
            return false;
        }
    }

    public void g(Context context) {
        if (context == null) {
            throw new IllegalStateException("Context can't be null");
        } else if (this.f16442a == null) {
            this.f16442a = context.getApplicationContext();
            C0098a aVar = new C0098a();
            try {
                if (i(this.f16442a)) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    this.f16442a.registerReceiver(aVar, intentFilter);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void h(c cVar) {
        this.f16444c.add(cVar);
    }

    public final String l() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f16442a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                HttpDnsLog.b("[detectCurrentNetwork] - Network name:" + typeName + " subType name: " + activeNetworkInfo.getSubtypeName());
                return typeName == null ? "None_Network" : typeName;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return "None_Network";
    }

    public String m() {
        return "unknown";
    }
}
