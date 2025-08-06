package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Parcel;

class ai implements aj {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f51365a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile int f2509a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f2510a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f2511a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2512a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile String f2513a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f51366b = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public volatile boolean f2514b = false;

    public class a implements ServiceConnection {
        private a() {
        }

        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() {
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006a */
                /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0093 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0040 */
                /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r3 = this;
                        r0 = 2
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        android.os.IBinder r2 = r3     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        java.lang.String r2 = com.xiaomi.push.ai.b.a((android.os.IBinder) r2)     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        java.lang.String unused = r1.f2513a = r2     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        android.os.IBinder r2 = r3     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        boolean r2 = com.xiaomi.push.ai.b.a((android.os.IBinder) r2)     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        boolean unused = r1.f2514b = r2     // Catch:{ Exception -> 0x006e, all -> 0x0044 }
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this
                        com.xiaomi.push.ai.a((com.xiaomi.push.ai) r1)
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this
                        int unused = r1.f2509a = r0
                        com.xiaomi.push.ai$a r0 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r0 = com.xiaomi.push.ai.this
                        java.lang.Object r1 = com.xiaomi.push.ai.a((com.xiaomi.push.ai) r0)
                        monitor-enter(r1)
                        com.xiaomi.push.ai$a r0 = com.xiaomi.push.ai.a.this     // Catch:{ Exception -> 0x0040 }
                        com.xiaomi.push.ai r0 = com.xiaomi.push.ai.this     // Catch:{ Exception -> 0x0040 }
                        java.lang.Object r0 = com.xiaomi.push.ai.a((com.xiaomi.push.ai) r0)     // Catch:{ Exception -> 0x0040 }
                        r0.notifyAll()     // Catch:{ Exception -> 0x0040 }
                        goto L_0x0040
                    L_0x003e:
                        r0 = move-exception
                        goto L_0x0042
                    L_0x0040:
                        monitor-exit(r1)     // Catch:{ all -> 0x003e }
                        goto L_0x0094
                    L_0x0042:
                        monitor-exit(r1)     // Catch:{ all -> 0x003e }
                        throw r0
                    L_0x0044:
                        r1 = move-exception
                        com.xiaomi.push.ai$a r2 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r2 = com.xiaomi.push.ai.this
                        com.xiaomi.push.ai.a((com.xiaomi.push.ai) r2)
                        com.xiaomi.push.ai$a r2 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r2 = com.xiaomi.push.ai.this
                        int unused = r2.f2509a = r0
                        com.xiaomi.push.ai$a r0 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r0 = com.xiaomi.push.ai.this
                        java.lang.Object r2 = com.xiaomi.push.ai.a((com.xiaomi.push.ai) r0)
                        monitor-enter(r2)
                        com.xiaomi.push.ai$a r0 = com.xiaomi.push.ai.a.this     // Catch:{ Exception -> 0x006a }
                        com.xiaomi.push.ai r0 = com.xiaomi.push.ai.this     // Catch:{ Exception -> 0x006a }
                        java.lang.Object r0 = com.xiaomi.push.ai.a((com.xiaomi.push.ai) r0)     // Catch:{ Exception -> 0x006a }
                        r0.notifyAll()     // Catch:{ Exception -> 0x006a }
                        goto L_0x006a
                    L_0x0068:
                        r0 = move-exception
                        goto L_0x006c
                    L_0x006a:
                        monitor-exit(r2)     // Catch:{ all -> 0x0068 }
                        throw r1
                    L_0x006c:
                        monitor-exit(r2)     // Catch:{ all -> 0x0068 }
                        throw r0
                    L_0x006e:
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this
                        com.xiaomi.push.ai.a((com.xiaomi.push.ai) r1)
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this
                        int unused = r1.f2509a = r0
                        com.xiaomi.push.ai$a r0 = com.xiaomi.push.ai.a.this
                        com.xiaomi.push.ai r0 = com.xiaomi.push.ai.this
                        java.lang.Object r0 = com.xiaomi.push.ai.a((com.xiaomi.push.ai) r0)
                        monitor-enter(r0)
                        com.xiaomi.push.ai$a r1 = com.xiaomi.push.ai.a.this     // Catch:{ Exception -> 0x0093 }
                        com.xiaomi.push.ai r1 = com.xiaomi.push.ai.this     // Catch:{ Exception -> 0x0093 }
                        java.lang.Object r1 = com.xiaomi.push.ai.a((com.xiaomi.push.ai) r1)     // Catch:{ Exception -> 0x0093 }
                        r1.notifyAll()     // Catch:{ Exception -> 0x0093 }
                        goto L_0x0093
                    L_0x0091:
                        r1 = move-exception
                        goto L_0x0095
                    L_0x0093:
                        monitor-exit(r0)     // Catch:{ all -> 0x0091 }
                    L_0x0094:
                        return
                    L_0x0095:
                        monitor-exit(r0)     // Catch:{ all -> 0x0091 }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ai.a.AnonymousClass1.run():void");
                }
            }).start();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public ai(Context context) {
        this.f2510a = context;
        a();
    }

    private void b() {
        ServiceConnection serviceConnection = this.f2511a;
        if (serviceConnection != null) {
            try {
                this.f2510a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2387a() {
        return f51365a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2386a() {
        a("getOAID");
        return this.f2513a;
    }

    private void a() {
        boolean z11;
        this.f2511a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i11 = 1;
        try {
            z11 = this.f2510a.bindService(intent, this.f2511a, 1);
        } catch (Exception unused) {
            z11 = false;
        }
        if (!z11) {
            i11 = 2;
        }
        this.f2509a = i11;
    }

    public static class b {
        public static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public static boolean m2388a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z11 = false;
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z11 = true;
                }
                return z11;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r3.f2509a
            r1 = 1
            if (r0 != r1) goto L_0x0039
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0039
            java.lang.Object r0 = r3.f2512a
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "huawei's "
            r1.append(r2)     // Catch:{ Exception -> 0x0035 }
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = " wait..."
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0035 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r4 = r3.f2512a     // Catch:{ Exception -> 0x0035 }
            r1 = 3000(0xbb8, double:1.482E-320)
            r4.wait(r1)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0035
        L_0x0033:
            r4 = move-exception
            goto L_0x0037
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0039
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r4
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ai.a(java.lang.String):void");
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z11 = (packageInfo.applicationInfo.flags & 1) != 0;
            f51365a = packageInfo.versionCode >= 20602000;
            if (z11) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
