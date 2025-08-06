package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;

class ap implements aj {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f51387a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile int f2532a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f2533a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f2534a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile a f2535a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2536a = new Object();

    public class a {

        /* renamed from: a  reason: collision with other field name */
        public String f2537a;

        /* renamed from: b  reason: collision with root package name */
        public String f51389b;

        /* renamed from: c  reason: collision with root package name */
        public String f51390c;

        /* renamed from: d  reason: collision with root package name */
        public String f51391d;

        private a() {
            this.f2537a = null;
            this.f51389b = null;
            this.f51390c = null;
            this.f51391d = null;
        }
    }

    public class b implements ServiceConnection {
        private b() {
        }

        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (ap.a(ap.this) == null) {
                new Thread(new Runnable() {
                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x007f */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00a8 */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0055 */
                    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r6 = this;
                            r0 = 2
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            android.content.Context r1 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r1)     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap$b r2 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap r2 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            java.lang.String r2 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r2)     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap$a r3 = new com.xiaomi.push.ap$a     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap$b r4 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap r4 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            r5 = 0
                            r3.<init>()     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            android.os.IBinder r4 = r3     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            java.lang.String r5 = "OUID"
                            java.lang.String r1 = com.xiaomi.push.ap.c.a(r4, r1, r2, r5)     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            r3.f51389b = r1     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap.a unused = r1.f2535a = r3     // Catch:{ Exception -> 0x0083, all -> 0x0059 }
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this
                            com.xiaomi.push.ap.a((com.xiaomi.push.ap) r1)
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this
                            int unused = r1.f2532a = r0
                            com.xiaomi.push.ap$b r0 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r0 = com.xiaomi.push.ap.this
                            java.lang.Object r1 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r0)
                            monitor-enter(r1)
                            com.xiaomi.push.ap$b r0 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x0055 }
                            com.xiaomi.push.ap r0 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x0055 }
                            java.lang.Object r0 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r0)     // Catch:{ Exception -> 0x0055 }
                            r0.notifyAll()     // Catch:{ Exception -> 0x0055 }
                            goto L_0x0055
                        L_0x0053:
                            r0 = move-exception
                            goto L_0x0057
                        L_0x0055:
                            monitor-exit(r1)     // Catch:{ all -> 0x0053 }
                            goto L_0x00a9
                        L_0x0057:
                            monitor-exit(r1)     // Catch:{ all -> 0x0053 }
                            throw r0
                        L_0x0059:
                            r1 = move-exception
                            com.xiaomi.push.ap$b r2 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r2 = com.xiaomi.push.ap.this
                            com.xiaomi.push.ap.a((com.xiaomi.push.ap) r2)
                            com.xiaomi.push.ap$b r2 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r2 = com.xiaomi.push.ap.this
                            int unused = r2.f2532a = r0
                            com.xiaomi.push.ap$b r0 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r0 = com.xiaomi.push.ap.this
                            java.lang.Object r2 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r0)
                            monitor-enter(r2)
                            com.xiaomi.push.ap$b r0 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x007f }
                            com.xiaomi.push.ap r0 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x007f }
                            java.lang.Object r0 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r0)     // Catch:{ Exception -> 0x007f }
                            r0.notifyAll()     // Catch:{ Exception -> 0x007f }
                            goto L_0x007f
                        L_0x007d:
                            r0 = move-exception
                            goto L_0x0081
                        L_0x007f:
                            monitor-exit(r2)     // Catch:{ all -> 0x007d }
                            throw r1
                        L_0x0081:
                            monitor-exit(r2)     // Catch:{ all -> 0x007d }
                            throw r0
                        L_0x0083:
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this
                            com.xiaomi.push.ap.a((com.xiaomi.push.ap) r1)
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this
                            int unused = r1.f2532a = r0
                            com.xiaomi.push.ap$b r0 = com.xiaomi.push.ap.b.this
                            com.xiaomi.push.ap r0 = com.xiaomi.push.ap.this
                            java.lang.Object r0 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r0)
                            monitor-enter(r0)
                            com.xiaomi.push.ap$b r1 = com.xiaomi.push.ap.b.this     // Catch:{ Exception -> 0x00a8 }
                            com.xiaomi.push.ap r1 = com.xiaomi.push.ap.this     // Catch:{ Exception -> 0x00a8 }
                            java.lang.Object r1 = com.xiaomi.push.ap.a((com.xiaomi.push.ap) r1)     // Catch:{ Exception -> 0x00a8 }
                            r1.notifyAll()     // Catch:{ Exception -> 0x00a8 }
                            goto L_0x00a8
                        L_0x00a6:
                            r1 = move-exception
                            goto L_0x00aa
                        L_0x00a8:
                            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
                        L_0x00a9:
                            return
                        L_0x00aa:
                            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ap.b.AnonymousClass1.run():void");
                    }
                }).start();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ap(Context context) {
        this.f2533a = context;
        a();
    }

    /* renamed from: b  reason: collision with other method in class */
    private void m2395b() {
        ServiceConnection serviceConnection = this.f2534a;
        if (serviceConnection != null) {
            try {
                this.f2533a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    private String b() {
        try {
            Signature[] signatureArr = this.f2533a.getPackageManager().getPackageInfo(this.f2533a.getPackageName(), 64).signatures;
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_SHA1);
            StringBuilder sb2 = new StringBuilder();
            byte[] digest = instance.digest(signatureArr[0].toByteArray());
            for (byte b11 : digest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2397a() {
        return f51387a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2396a() {
        a("getOAID");
        if (this.f2535a == null) {
            return null;
        }
        return this.f2535a.f51389b;
    }

    private void a() {
        boolean z11;
        this.f2534a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i11 = 1;
        try {
            z11 = this.f2533a.bindService(intent, this.f2534a, 1);
        } catch (Exception unused) {
            z11 = false;
        }
        if (!z11) {
            i11 = 2;
        }
        this.f2532a = i11;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r3.f2532a
            r1 = 1
            if (r0 != r1) goto L_0x0039
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0039
            java.lang.Object r0 = r3.f2536a
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "oppo's "
            r1.append(r2)     // Catch:{ Exception -> 0x0035 }
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = " wait..."
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0035 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r4 = r3.f2536a     // Catch:{ Exception -> 0x0035 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ap.a(java.lang.String):void");
    }

    public static boolean a(Context context) {
        long j11;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    j11 = packageInfo.getLongVersionCode();
                } else {
                    j11 = (long) packageInfo.versionCode;
                }
                boolean z11 = (packageInfo.applicationInfo.flags & 1) != 0;
                f51387a = j11 >= 1;
                if (z11) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
