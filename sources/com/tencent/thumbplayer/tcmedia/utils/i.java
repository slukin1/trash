package com.tencent.thumbplayer.tcmedia.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;

public class i extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f49706a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static String f49707b = "unknown";

    /* renamed from: c  reason: collision with root package name */
    private static int f49708c;

    /* renamed from: d  reason: collision with root package name */
    private static int f49709d;

    /* renamed from: e  reason: collision with root package name */
    private static String f49710e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<b> f49711f;

    /* renamed from: g  reason: collision with root package name */
    private HandlerThread f49712g;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static i f49713a = new i();
    }

    public interface b {
        void a(int i11, int i12, int i13, int i14);
    }

    private i() {
        this.f49711f = null;
        this.f49711f = new ArrayList<>();
    }

    public static i a() {
        return a.f49713a;
    }

    private synchronized void a(Context context, Handler handler) {
        if (context != null) {
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, handler);
        }
    }

    private boolean a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            return networkInfo.isConnected() || networkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static int b() {
        return f49708c;
    }

    private static int b(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            switch (networkInfo.getSubtype()) {
                case 0:
                    break;
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 13:
                    return 4;
                default:
                    return 3;
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ Exception -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[Catch:{ Exception -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067 A[Catch:{ Exception -> 0x0074 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x000b
            java.lang.String r0 = "connectivity"
            java.lang.Object r8 = r8.getSystemService(r0)     // Catch:{ Exception -> 0x0074 }
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch:{ Exception -> 0x0074 }
            goto L_0x000c
        L_0x000b:
            r8 = 0
        L_0x000c:
            if (r8 == 0) goto L_0x0074
            r0 = 0
            android.net.NetworkInfo r1 = r8.getNetworkInfo(r0)     // Catch:{ Exception -> 0x0074 }
            r2 = 1
            android.net.NetworkInfo r3 = r8.getNetworkInfo(r2)     // Catch:{ Exception -> 0x0074 }
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0074 }
            r4 = 2
            r5 = 3
            if (r8 != 0) goto L_0x0036
            boolean r6 = r7.a((android.net.NetworkInfo) r1)     // Catch:{ Exception -> 0x0074 }
            if (r6 == 0) goto L_0x0029
            f49706a = r5     // Catch:{ Exception -> 0x0074 }
            goto L_0x0048
        L_0x0029:
            boolean r1 = r7.a((android.net.NetworkInfo) r3)     // Catch:{ Exception -> 0x0074 }
            if (r1 == 0) goto L_0x0033
            f49706a = r4     // Catch:{ Exception -> 0x0074 }
            r1 = r3
            goto L_0x0048
        L_0x0033:
            f49706a = r2     // Catch:{ Exception -> 0x0074 }
            goto L_0x0047
        L_0x0036:
            boolean r3 = r7.a((android.net.NetworkInfo) r8)     // Catch:{ Exception -> 0x0074 }
            if (r3 == 0) goto L_0x0033
            boolean r1 = r7.a((android.net.NetworkInfo) r1)     // Catch:{ Exception -> 0x0074 }
            if (r1 == 0) goto L_0x0044
            r1 = r5
            goto L_0x0045
        L_0x0044:
            r1 = r4
        L_0x0045:
            f49706a = r1     // Catch:{ Exception -> 0x0074 }
        L_0x0047:
            r1 = r8
        L_0x0048:
            int r8 = f49706a     // Catch:{ Exception -> 0x0074 }
            if (r8 == r2) goto L_0x005b
            if (r8 == r4) goto L_0x0058
            if (r8 == r5) goto L_0x0051
            goto L_0x005d
        L_0x0051:
            int r8 = b((android.net.NetworkInfo) r1)     // Catch:{ Exception -> 0x0074 }
            f49708c = r8     // Catch:{ Exception -> 0x0074 }
            goto L_0x005d
        L_0x0058:
            f49708c = r2     // Catch:{ Exception -> 0x0074 }
            goto L_0x005d
        L_0x005b:
            f49708c = r0     // Catch:{ Exception -> 0x0074 }
        L_0x005d:
            java.lang.String r8 = r7.c(r1)     // Catch:{ Exception -> 0x0074 }
            f49707b = r8     // Catch:{ Exception -> 0x0074 }
            int r0 = f49709d     // Catch:{ Exception -> 0x0074 }
            if (r0 != 0) goto L_0x006d
            int r0 = f49706a     // Catch:{ Exception -> 0x0074 }
            f49709d = r0     // Catch:{ Exception -> 0x0074 }
            f49710e = r8     // Catch:{ Exception -> 0x0074 }
        L_0x006d:
            r7.f()     // Catch:{ Exception -> 0x0074 }
            r7.e()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.i.b(android.content.Context):void");
    }

    public static int c() {
        return f49706a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bb, code lost:
        if (r0.length() > 0) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(android.net.NetworkInfo r16) {
        /*
            r15 = this;
            r0 = 0
            if (r16 == 0) goto L_0x0008
            java.lang.String r1 = r16.getTypeName()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "getDetailNetworkType, typeName: "
            java.lang.String r2 = r3.concat(r2)
            java.lang.String r3 = "TPNetworkChangeMonitor"
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.d(r3, r2)
            java.lang.String r2 = "3gnet"
            java.lang.String r3 = "3gwap"
            java.lang.String r4 = "net"
            java.lang.String r5 = "wap"
            java.lang.String r6 = "uninet"
            java.lang.String r7 = "uniwap"
            java.lang.String r8 = "cmnet"
            java.lang.String r9 = "cmwap"
            java.lang.String r10 = "wifi"
            java.lang.String r11 = "unknown"
            java.lang.String r12 = "ctnet"
            java.lang.String r13 = "ctwap"
            if (r1 == 0) goto L_0x00c2
            java.util.Locale r14 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.toLowerCase(r14)
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x00c0
            java.lang.String r1 = r16.getExtraInfo()
            if (r1 == 0) goto L_0x004e
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r1.toLowerCase(r0)
        L_0x004e:
            if (r0 == 0) goto L_0x00c2
            boolean r1 = r0.startsWith(r9)
            if (r1 == 0) goto L_0x0059
            r2 = r9
            goto L_0x00c3
        L_0x0059:
            boolean r1 = r0.startsWith(r8)
            if (r1 != 0) goto L_0x00be
            java.lang.String r1 = "epc.tmobile.com"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0069
            goto L_0x00be
        L_0x0069:
            boolean r1 = r0.startsWith(r7)
            if (r1 == 0) goto L_0x0072
            r2 = r7
            goto L_0x00c3
        L_0x0072:
            boolean r1 = r0.startsWith(r6)
            if (r1 == 0) goto L_0x007a
            r2 = r6
            goto L_0x00c3
        L_0x007a:
            boolean r1 = r0.startsWith(r5)
            if (r1 == 0) goto L_0x0082
            r2 = r5
            goto L_0x00c3
        L_0x0082:
            boolean r1 = r0.startsWith(r4)
            if (r1 == 0) goto L_0x008a
            r2 = r4
            goto L_0x00c3
        L_0x008a:
            boolean r1 = r0.startsWith(r13)
            if (r1 == 0) goto L_0x0092
        L_0x0090:
            r2 = r13
            goto L_0x00c3
        L_0x0092:
            boolean r1 = r0.startsWith(r12)
            if (r1 == 0) goto L_0x009a
        L_0x0098:
            r2 = r12
            goto L_0x00c3
        L_0x009a:
            boolean r1 = r0.startsWith(r3)
            if (r1 == 0) goto L_0x00a2
            r2 = r3
            goto L_0x00c3
        L_0x00a2:
            boolean r1 = r0.startsWith(r2)
            if (r1 == 0) goto L_0x00a9
            goto L_0x00c3
        L_0x00a9:
            java.lang.String r1 = "#777"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x00c2
            java.lang.String r0 = android.net.Proxy.getDefaultHost()
            if (r0 == 0) goto L_0x0098
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0098
            goto L_0x0090
        L_0x00be:
            r2 = r8
            goto L_0x00c3
        L_0x00c0:
            r2 = r10
            goto L_0x00c3
        L_0x00c2:
            r2 = r11
        L_0x00c3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.i.c(android.net.NetworkInfo):java.lang.String");
    }

    private static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void e() {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = f49706a     // Catch:{ all -> 0x0084 }
            int r1 = f49709d     // Catch:{ all -> 0x0084 }
            r2 = 0
            if (r0 != r1) goto L_0x0015
            java.lang.String r0 = f49707b     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = f49710e     // Catch:{ all -> 0x0084 }
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch:{ all -> 0x0084 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            java.lang.String r1 = "TPNetworkChangeMonitor"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "notifyIfNetChanged, isNetChanged: "
            r3.<init>(r4)     // Catch:{ all -> 0x0084 }
            r3.append(r0)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = ",  mListeners:  "
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            java.util.ArrayList<com.tencent.thumbplayer.tcmedia.utils.i$b> r4 = r6.f49711f     // Catch:{ all -> 0x0084 }
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0084 }
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r1, r3)     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = "TPNetworkChangeMonitor"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "onNetworkStatusChanged oldNetStatus: "
            r3.<init>(r4)     // Catch:{ all -> 0x0084 }
            int r4 = f49709d     // Catch:{ all -> 0x0084 }
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = ", netStatus: "
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            int r4 = f49706a     // Catch:{ all -> 0x0084 }
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = ", mobileNetSubType"
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            int r4 = f49708c     // Catch:{ all -> 0x0084 }
            r3.append(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0084 }
            com.tencent.thumbplayer.tcmedia.utils.TPLogUtil.i(r1, r3)     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0082
            java.util.ArrayList<com.tencent.thumbplayer.tcmedia.utils.i$b> r0 = r6.f49711f     // Catch:{ all -> 0x0084 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0084 }
        L_0x0064:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0084 }
            com.tencent.thumbplayer.tcmedia.utils.i$b r1 = (com.tencent.thumbplayer.tcmedia.utils.i.b) r1     // Catch:{ all -> 0x0084 }
            int r3 = f49709d     // Catch:{ all -> 0x0084 }
            int r4 = f49706a     // Catch:{ all -> 0x0084 }
            int r5 = f49708c     // Catch:{ all -> 0x0084 }
            r1.a(r3, r4, r2, r5)     // Catch:{ all -> 0x0084 }
            goto L_0x0064
        L_0x007a:
            int r0 = f49706a     // Catch:{ all -> 0x0084 }
            f49709d = r0     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = f49707b     // Catch:{ all -> 0x0084 }
            f49710e = r0     // Catch:{ all -> 0x0084 }
        L_0x0082:
            monitor-exit(r6)
            return
        L_0x0084:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.i.e():void");
    }

    private void f() {
        TPLogUtil.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + f49706a + "[wifi: 2, mobile: 3], lastNetStatus=" + f49709d + ", mDetailNetworkType=" + f49707b + ", mobileNetSubType=" + f49708c + "[2G:2 3G:3 4G:4], currentDetailNetType=" + f49707b + ", lastDetailNetType=" + f49710e);
    }

    public synchronized void a(Context context) {
        b.a((Object) context, "context can not be null!");
        if (this.f49712g == null) {
            this.f49712g = o.a().b();
        }
        a(context, new Handler(this.f49712g.getLooper()));
    }

    public synchronized void a(b bVar) {
        ArrayList<b> arrayList = this.f49711f;
        if (arrayList != null && !arrayList.contains(bVar)) {
            this.f49711f.add(bVar);
            TPLogUtil.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + bVar + ", mListeners: " + this.f49711f.size());
        }
    }

    public synchronized void b(b bVar) {
        ArrayList<b> arrayList = this.f49711f;
        if (arrayList != null) {
            arrayList.remove(bVar);
            TPLogUtil.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + bVar + ", mListeners: " + this.f49711f.size());
        }
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        StringBuilder sb2 = new StringBuilder("onReceive broadcast action and update net status,onReceive broadcast in ");
        sb2.append(d() ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "work");
        sb2.append(" thread.");
        TPLogUtil.d("TPNetworkChangeMonitor", sb2.toString());
        b(context);
    }
}
