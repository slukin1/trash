package com.mob.commons.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.iproov.sdk.bridge.OptionsBridge;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public final Context f27079a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27080b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27081c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f27082d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f27083e = 0;

    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public boolean f27084a;

        /* renamed from: c  reason: collision with root package name */
        private final BlockingQueue<IBinder> f27086c;

        private a() {
            this.f27084a = false;
            this.f27086c = new LinkedBlockingQueue();
        }

        public IBinder a(long j11) throws InterruptedException {
            if (!this.f27084a) {
                this.f27084a = true;
                BlockingQueue<IBinder> blockingQueue = this.f27086c;
                if (j11 <= 0) {
                    j11 = com.sumsub.sns.internal.ml.autocapture.a.f34923p;
                }
                return blockingQueue.poll(j11, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f27086c.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f27087a;
    }

    public h(Context context) {
        this.f27079a = context;
        this.f27080b = context.getPackageName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void e() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f27081c     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            android.content.Intent r0 = r3.a()     // Catch:{ all -> 0x001e }
            boolean r0 = r3.a((android.content.Intent) r0)     // Catch:{ all -> 0x001e }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            int r0 = r3.f27083e     // Catch:{ all -> 0x001e }
            r2 = 4
            if (r0 < r2) goto L_0x001c
            r3.f27081c = r1     // Catch:{ all -> 0x001e }
            goto L_0x001c
        L_0x001a:
            r3.f27081c = r1     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r3)
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.h.e():void");
    }

    public Intent a() {
        return null;
    }

    public b a(IBinder iBinder) {
        return null;
    }

    public synchronized void a(String str) {
        if (str != null) {
            if (!Pattern.compile("^[0fF\\-]+").matcher(str).matches()) {
                this.f27082d = str;
            }
        }
    }

    public b b() {
        return null;
    }

    public long c() {
        return ((((long) (this.f27083e - 1)) * 2) + 2) * 1000;
    }

    public synchronized String d() {
        e();
        return this.f27082d;
    }

    private synchronized boolean a(Intent intent) {
        boolean z11;
        z11 = true;
        this.f27083e++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            b b11 = b();
            if (b11 == null) {
                b11 = a(this.f27079a, intent);
            }
            if (b11 != null) {
                this.f27082d = b11.f27087a;
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                MobLog.getInstance().d("oa use time: " + elapsedRealtime2, new Object[0]);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        z11 = false;
        long elapsedRealtime22 = SystemClock.elapsedRealtime() - elapsedRealtime;
        MobLog.getInstance().d("oa use time: " + elapsedRealtime22, new Object[0]);
        return z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f A[SYNTHETIC, Splitter:B:26:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[Catch:{ all -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r7, android.os.IBinder r8, java.lang.String r9, int r10, java.lang.String... r11) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            android.os.Parcel r2 = android.os.Parcel.obtain()     // Catch:{ all -> 0x0034 }
            android.os.Parcel r3 = android.os.Parcel.obtain()     // Catch:{ all -> 0x0031 }
            r2.writeInterfaceToken(r9)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x001e
            int r9 = r11.length     // Catch:{ all -> 0x002f }
            if (r9 <= 0) goto L_0x001e
            int r9 = r11.length     // Catch:{ all -> 0x002f }
            r4 = r0
        L_0x0014:
            if (r4 >= r9) goto L_0x001e
            r5 = r11[r4]     // Catch:{ all -> 0x002f }
            r2.writeString(r5)     // Catch:{ all -> 0x002f }
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001e:
            r8.transact(r10, r2, r3, r0)     // Catch:{ all -> 0x002f }
            r3.readException()     // Catch:{ all -> 0x002f }
            java.lang.String r7 = r3.readString()     // Catch:{ all -> 0x002f }
            r3.recycle()     // Catch:{ all -> 0x002e }
            r2.recycle()     // Catch:{ all -> 0x002e }
        L_0x002e:
            return r7
        L_0x002f:
            r8 = move-exception
            goto L_0x0037
        L_0x0031:
            r8 = move-exception
            r3 = r1
            goto L_0x0037
        L_0x0034:
            r8 = move-exception
            r2 = r1
            r3 = r2
        L_0x0037:
            com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r10.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r11 = "getStringValue: "
            r10.append(r11)     // Catch:{ all -> 0x0068 }
            r10.append(r7)     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = " failed! "
            r10.append(r7)     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = r8.getMessage()     // Catch:{ all -> 0x0068 }
            r10.append(r7)     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x0068 }
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ all -> 0x0068 }
            r9.d(r7, r8)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0062
            r3.recycle()     // Catch:{ all -> 0x0067 }
        L_0x0062:
            if (r2 == 0) goto L_0x0067
            r2.recycle()     // Catch:{ all -> 0x0067 }
        L_0x0067:
            return r1
        L_0x0068:
            r7 = move-exception
            if (r3 == 0) goto L_0x006e
            r3.recycle()     // Catch:{ all -> 0x0073 }
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.recycle()     // Catch:{ all -> 0x0073 }
        L_0x0073:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.h.a(java.lang.String, android.os.IBinder, java.lang.String, int, java.lang.String[]):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A[SYNTHETIC, Splitter:B:19:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0056 A[SYNTHETIC, Splitter:B:28:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b A[Catch:{ all -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r4, android.os.IBinder r5, java.lang.String r6, int r7) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            android.os.Parcel r2 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0026, all -> 0x0023 }
            android.os.Parcel r0 = android.os.Parcel.obtain()     // Catch:{ RemoteException -> 0x0020, all -> 0x001e }
            r2.writeInterfaceToken(r6)     // Catch:{ RemoteException -> 0x0020, all -> 0x001e }
            r5.transact(r7, r2, r0, r1)     // Catch:{ RemoteException -> 0x0020, all -> 0x001e }
            r0.readException()     // Catch:{ RemoteException -> 0x0020, all -> 0x001e }
            int r4 = r0.readInt()     // Catch:{ RemoteException -> 0x0020, all -> 0x001e }
            r0.recycle()     // Catch:{ all -> 0x001d }
            r2.recycle()     // Catch:{ all -> 0x001d }
        L_0x001d:
            return r4
        L_0x001e:
            r4 = move-exception
            goto L_0x0054
        L_0x0020:
            r5 = r0
            r0 = r2
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r2 = r0
            goto L_0x0054
        L_0x0026:
            r5 = r0
        L_0x0027:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r7.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "getIntValue: "
            r7.append(r2)     // Catch:{ all -> 0x0051 }
            r7.append(r4)     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = " failed! (remoteException)"
            r7.append(r4)     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0051 }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x0051 }
            r6.d(r4, r7)     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x004b
            r5.recycle()     // Catch:{ all -> 0x0050 }
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.recycle()     // Catch:{ all -> 0x0050 }
        L_0x0050:
            return r1
        L_0x0051:
            r4 = move-exception
            r2 = r0
            r0 = r5
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r0.recycle()     // Catch:{ all -> 0x005e }
        L_0x0059:
            if (r2 == 0) goto L_0x005e
            r2.recycle()     // Catch:{ all -> 0x005e }
        L_0x005e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.h.a(java.lang.String, android.os.IBinder, java.lang.String, int):int");
    }

    private b a(Context context, Intent intent) throws Throwable {
        boolean z11;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a aVar = new a();
            try {
                if (Build.VERSION.SDK_INT >= 34) {
                    z11 = context.bindService(intent, aVar, 513);
                } else {
                    z11 = context.bindService(intent, aVar, 1);
                }
                if (intent == null || !z11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("bind service ");
                    sb2.append(intent == null ? OptionsBridge.NULL_VALUE : intent.getComponent());
                    sb2.append(" failed!");
                    throw new Throwable(sb2.toString());
                }
                long c11 = c();
                NLog instance = MobLog.getInstance();
                instance.d("wte " + c11, new Object[0]);
                IBinder a11 = aVar.a(c());
                if (a11 != null) {
                    b a12 = a(a11);
                    try {
                        context.unbindService(aVar);
                    } catch (Throwable th2) {
                        MobLog.getInstance().d(th2);
                    }
                    return a12;
                }
                throw new Throwable("get binder " + intent.getComponent() + " failed!");
            } catch (Throwable th3) {
                MobLog.getInstance().d(th3);
            }
        } else {
            throw new Throwable("unable to invoke in main thread!");
        }
        throw th;
    }
}
