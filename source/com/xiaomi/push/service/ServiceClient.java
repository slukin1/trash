package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.av;
import com.xiaomi.push.dz;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fr;
import com.xiaomi.push.fy;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import com.xiaomi.push.s;
import com.xiaomi.push.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

public class ServiceClient {

    /* renamed from: a  reason: collision with root package name */
    private static long f52388a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ServiceClient f3266a;

    /* renamed from: a  reason: collision with other field name */
    private static String f3267a;

    /* renamed from: b  reason: collision with root package name */
    private static String f52389b = (fy.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a  reason: collision with other field name */
    private final BroadcastReceiver f3268a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            av.a();
        }
    };

    /* renamed from: a  reason: collision with other field name */
    private Context f3269a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f3270a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f3271a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f3272a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public Messenger f3273b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f3274b = false;

    private ServiceClient(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f3269a = applicationContext;
        s.a(applicationContext);
        a(this.f3269a);
        if (a()) {
            b.c("use miui push service");
            this.f3272a = true;
        }
    }

    private void b() {
        this.f3269a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f3269a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f3266a == null) {
            f3266a = new ServiceClient(context);
        }
        return f3266a;
    }

    public static String getSession() {
        return f3267a;
    }

    public static void setSession(String str) {
        f3267a = str;
    }

    public boolean batchSendMessage(fo[] foVarArr, boolean z11) {
        if (!av.a(this.f3269a)) {
            return false;
        }
        Intent a11 = a();
        int length = foVarArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i11 = 0; i11 < foVarArr.length; i11++) {
            String a12 = dz.a();
            if (!TextUtils.isEmpty(a12)) {
                fm fmVar = new fm("pf", (String) null, (String[]) null, (String[]) null);
                fm fmVar2 = new fm("sent", (String) null, (String[]) null, (String[]) null);
                fmVar2.a(a12);
                fmVar.a(fmVar2);
                foVarArr[i11].a(fmVar);
            }
            b.c("SEND:" + foVarArr[i11].a());
            bundleArr[i11] = foVarArr[i11].a();
        }
        if (length <= 0) {
            return false;
        }
        a11.setAction(an.f52490g);
        a11.putExtra(an.K, f3267a);
        a11.putExtra("ext_packets", bundleArr);
        a11.putExtra("ext_encrypt", z11);
        return startServiceSafely(a11);
    }

    public void checkAlive() {
        Intent a11 = a();
        a11.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a11);
    }

    public boolean closeChannel() {
        Intent a11 = a();
        a11.setAction(an.f52492i);
        return startServiceSafely(a11);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z11, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z11, a(list), a(list2));
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f3272a;
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent a11 = a();
        a11.setAction(an.f52498o);
        a11.putExtras(bundle);
        b.e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(a11);
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z11, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z11);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z11, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z11, a(list), a(list2));
    }

    public boolean sendIQ(fn fnVar) {
        if (!av.a(this.f3269a)) {
            return false;
        }
        Intent a11 = a();
        Bundle a12 = fnVar.a();
        if (a12 == null) {
            return false;
        }
        b.c("SEND:" + fnVar.a());
        a11.setAction(an.f52489f);
        a11.putExtra(an.K, f3267a);
        a11.putExtra("ext_packet", a12);
        return startServiceSafely(a11);
    }

    public boolean sendMessage(fo foVar, boolean z11) {
        if (!av.a(this.f3269a)) {
            return false;
        }
        Intent a11 = a();
        String a12 = dz.a();
        if (!TextUtils.isEmpty(a12)) {
            fm fmVar = new fm("pf", (String) null, (String[]) null, (String[]) null);
            fm fmVar2 = new fm("sent", (String) null, (String[]) null, (String[]) null);
            fmVar2.a(a12);
            fmVar.a(fmVar2);
            foVar.a(fmVar);
        }
        Bundle a13 = foVar.a();
        if (a13 == null) {
            return false;
        }
        b.c("SEND:" + foVar.a());
        a11.setAction(an.f52488e);
        a11.putExtra(an.K, f3267a);
        a11.putExtra("ext_packet", a13);
        a11.putExtra("ext_encrypt", z11);
        return startServiceSafely(a11);
    }

    public boolean sendPresence(fr frVar) {
        if (!av.a(this.f3269a)) {
            return false;
        }
        Intent a11 = a();
        Bundle a12 = frVar.a();
        if (a12 == null) {
            return false;
        }
        b.c("SEND:" + frVar.a());
        a11.setAction(an.f52491h);
        a11.putExtra(an.K, f3267a);
        a11.putExtra("ext_packet", a12);
        return startServiceSafely(a11);
    }

    public void setMessenger(Messenger messenger) {
        this.f3270a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (j.a() || Build.VERSION.SDK_INT < 26) {
                this.f3269a.startService(intent);
                return true;
            }
            a(intent);
            return true;
        } catch (Exception e11) {
            b.a((Throwable) e11);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z11, Map<String, String> map, Map<String, String> map2) {
        Intent a11 = a();
        a11.setAction(an.f52493j);
        a(a11, str, str2, str3, str4, str5, z11, map, map2);
        return startServiceSafely(a11);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z11) {
        Intent a11 = a();
        a11.setAction(an.f52487d);
        a(a11, str, str2, str3, str4, str5, z11, map, map2);
        startServiceSafely(a11);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z11, Map<String, String> map, Map<String, String> map2) {
        Intent a11 = a();
        a11.setAction(an.f52494k);
        a(a11, str, str2, str3, str4, str5, z11, map, map2);
        startServiceSafely(a11);
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a11 = a();
        a11.setAction(an.f52495l);
        if (map != null) {
            String a12 = a(map);
            if (!TextUtils.isEmpty(a12)) {
                a11.putExtra(an.E, a12);
            }
        }
        if (map2 != null) {
            String a13 = a(map2);
            if (!TextUtils.isEmpty(a13)) {
                a11.putExtra(an.F, a13);
            }
        }
        a11.putExtra(an.f52506w, str);
        startServiceSafely(a11);
    }

    public boolean closeChannel(String str) {
        Intent a11 = a();
        a11.setAction(an.f52492i);
        a11.putExtra(an.f52506w, str);
        return startServiceSafely(a11);
    }

    private void a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                av.a(context);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            m.a(context.getApplicationContext(), this.f3268a, intentFilter, 2);
        } catch (Throwable th2) {
            b.a("add network status listener failed:" + th2);
        }
    }

    public boolean closeChannel(String str, String str2) {
        Intent a11 = a();
        a11.setAction(an.f52492i);
        a11.putExtra(an.f52506w, str);
        a11.putExtra(an.f52503t, str2);
        return startServiceSafely(a11);
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair next : list) {
                if (next != null) {
                    hashMap.put(next.getName(), next.getValue());
                }
            }
        }
        return hashMap;
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z11, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(an.f52503t, str);
        intent.putExtra(an.f52506w, str2);
        intent.putExtra(an.A, str3);
        intent.putExtra(an.C, str5);
        intent.putExtra(an.B, str4);
        intent.putExtra(an.D, z11);
        intent.putExtra(an.K, f3267a);
        intent.putExtra(an.O, this.f3270a);
        if (map != null && map.size() > 0) {
            String a11 = a(map);
            if (!TextUtils.isEmpty(a11)) {
                intent.putExtra(an.E, a11);
            }
        }
        if (map2 != null && map2.size() > 0) {
            String a12 = a(map2);
            if (!TextUtils.isEmpty(a12)) {
                intent.putExtra(an.F, a12);
            }
        }
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!av.a(this.f3269a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a11 = a();
        a11.setAction(an.f52488e);
        a11.putExtra(an.K, f3267a);
        a11.putExtra("ext_raw_packet", bArr);
        int indexOf = str.indexOf(TIMMentionEditText.TIM_MENTION_TAG);
        String str4 = null;
        String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str4 = str.substring(indexOf + 1, lastIndexOf);
            str3 = str.substring(lastIndexOf + 1);
        } else {
            str3 = null;
        }
        a11.putExtra(an.f52503t, substring);
        a11.putExtra(an.f52504u, str4);
        a11.putExtra(an.f52505v, str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f52389b);
        long j11 = f52388a;
        f52388a = 1 + j11;
        sb2.append(j11);
        String sb3 = sb2.toString();
        a11.putExtra("ext_pkt_id", sb3);
        a11.putExtra("ext_chid", str2);
        b.e("SEND: chid=" + str2 + ", packetId=" + sb3);
        return startServiceSafely(a11);
    }

    private String a(Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 1;
        for (Map.Entry next : map.entrySet()) {
            sb2.append((String) next.getKey());
            sb2.append(":");
            sb2.append((String) next.getValue());
            if (i11 < map.size()) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i11++;
        }
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2929a() {
        if (y.f3454a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f3269a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null && packageInfo.versionCode >= 104) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m2926a() {
        try {
            return this.f3269a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", a());
            intent.putExtra(an.G, this.f3269a.getPackageName());
            a();
            return intent;
        }
        Intent intent2 = new Intent(this.f3269a, XMPushService.class);
        intent2.putExtra(an.G, this.f3269a.getPackageName());
        b();
        return intent2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m2927a() {
        this.f3269a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f3269a, XMPushService.class), 2, 1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m2928a(Intent intent) {
        if (this.f3274b) {
            Message a11 = a(intent);
            if (this.f3271a.size() >= 50) {
                this.f3271a.remove(0);
            }
            this.f3271a.add(a11);
            return;
        } else if (this.f3273b == null) {
            this.f3269a.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        Messenger unused = ServiceClient.this.f3273b = new Messenger(iBinder);
                        boolean unused2 = ServiceClient.this.f3274b = false;
                        for (Message send : ServiceClient.a(ServiceClient.this)) {
                            try {
                                ServiceClient.a(ServiceClient.this).send(send);
                            } catch (RemoteException e11) {
                                b.a((Throwable) e11);
                            }
                        }
                        ServiceClient.a(ServiceClient.this).clear();
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    Messenger unused = ServiceClient.this.f3273b = null;
                    boolean unused2 = ServiceClient.this.f3274b = false;
                }
            }, 1);
            this.f3274b = true;
            this.f3271a.clear();
            this.f3271a.add(a(intent));
        } else {
            try {
                this.f3273b.send(a(intent));
            } catch (RemoteException unused) {
                this.f3273b = null;
                this.f3274b = false;
            }
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }
}
