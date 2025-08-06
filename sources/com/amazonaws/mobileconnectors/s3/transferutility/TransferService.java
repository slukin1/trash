package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

public class TransferService extends Service {

    /* renamed from: e  reason: collision with root package name */
    public static final Log f15003e = LogFactory.b(TransferService.class);

    /* renamed from: f  reason: collision with root package name */
    public static TransferNetworkLossHandler f15004f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15005b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f15006c = 3462;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15007d = true;

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) != 0) {
            printWriter.printf("network status: %s\n", new Object[]{Boolean.valueOf(f15004f.e())});
            Map<Integer, TransferRecord> e11 = TransferStatusUpdater.c(this).e();
            printWriter.printf("# of active transfers: %d\n", new Object[]{Integer.valueOf(e11.size())});
            for (TransferRecord next : e11.values()) {
                printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", new Object[]{next.f14992p, next.f14993q, next.f14991o, Long.valueOf(next.f14984h), Long.valueOf(next.f14985i)});
            }
            printWriter.flush();
        }
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r3 = this;
            super.onCreate()
            com.amazonaws.logging.Log r0 = f15003e
            java.lang.String r1 = "Starting Transfer Service to listen for network connectivity changes."
            r0.j(r1)
            android.content.Context r1 = r3.getApplicationContext()
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler.d(r1)
            f15004f = r1
            monitor-enter(r3)
            boolean r1 = r3.f15005b     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = "Registering the network receiver"
            r0.j(r1)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = f15004f     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            r3.registerReceiver(r0, r1)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            r0 = 0
            r3.f15005b = r0     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            goto L_0x003d
        L_0x002e:
            com.amazonaws.logging.Log r0 = f15003e     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "Ignoring the leak in registering the receiver."
            r0.g(r1)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0036:
            com.amazonaws.logging.Log r0 = f15003e     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "Ignoring the exception trying to register the receiver for connectivity change."
            r0.g(r1)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onCreate():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0018 }
            r1 = 26
            if (r0 < r1) goto L_0x002f
            com.amazonaws.logging.Log r0 = f15003e     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.j(r1)     // Catch:{ Exception -> 0x0018 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r4.f15007d     // Catch:{ all -> 0x0015 }
            r4.stopForeground(r0)     // Catch:{ all -> 0x0015 }
            monitor-exit(r4)     // Catch:{ all -> 0x0015 }
            goto L_0x002f
        L_0x0015:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0015 }
            throw r0     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = f15003e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.c(r0)
        L_0x002f:
            com.amazonaws.logging.Log r0 = f15003e     // Catch:{ IllegalArgumentException -> 0x004b }
            java.lang.String r1 = "De-registering the network receiver."
            r0.j(r1)     // Catch:{ IllegalArgumentException -> 0x004b }
            monitor-enter(r4)     // Catch:{ IllegalArgumentException -> 0x004b }
            boolean r0 = r4.f15005b     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0046
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = f15004f     // Catch:{ all -> 0x0048 }
            r4.unregisterReceiver(r0)     // Catch:{ all -> 0x0048 }
            r0 = 1
            r4.f15005b = r0     // Catch:{ all -> 0x0048 }
            r0 = 0
            f15004f = r0     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r4)     // Catch:{ all -> 0x0048 }
            goto L_0x0052
        L_0x0048:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0048 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x004b }
        L_0x004b:
            com.amazonaws.logging.Log r0 = f15003e
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.g(r1)
        L_0x0052:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public int onStartCommand(android.content.Intent r4, int r5, int r6) {
        /*
            r3 = this;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(r3, r4, r5, r6)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 1
            r0 = 26
            if (r5 < r0) goto L_0x0063
            monitor-enter(r3)     // Catch:{ Exception -> 0x004c }
            java.lang.String r0 = "notification"
            android.os.Parcelable r0 = r4.getParcelableExtra(r0)     // Catch:{ all -> 0x0049 }
            android.app.Notification r0 = (android.app.Notification) r0     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0040
            java.lang.String r1 = "ongoing-notification-id"
            int r2 = r3.f15006c     // Catch:{ all -> 0x0049 }
            int r1 = r4.getIntExtra(r1, r2)     // Catch:{ all -> 0x0049 }
            r3.f15006c = r1     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "remove-notification"
            boolean r2 = r3.f15007d     // Catch:{ all -> 0x0049 }
            boolean r4 = r4.getBooleanExtra(r1, r2)     // Catch:{ all -> 0x0049 }
            r3.f15007d = r4     // Catch:{ all -> 0x0049 }
            com.amazonaws.logging.Log r4 = f15003e     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "Putting the service in Foreground state."
            r4.j(r1)     // Catch:{ all -> 0x0049 }
            r4 = 34
            if (r5 < r4) goto L_0x003a
            int r4 = r3.f15006c     // Catch:{ all -> 0x0049 }
            r3.startForeground(r4, r0, r6)     // Catch:{ all -> 0x0049 }
            goto L_0x0047
        L_0x003a:
            int r4 = r3.f15006c     // Catch:{ all -> 0x0049 }
            r3.startForeground(r4, r0)     // Catch:{ all -> 0x0049 }
            goto L_0x0047
        L_0x0040:
            com.amazonaws.logging.Log r4 = f15003e     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = "No notification is passed in the intent. Unable to transition to foreground."
            r4.c(r5)     // Catch:{ all -> 0x0049 }
        L_0x0047:
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            goto L_0x0063
        L_0x0049:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            throw r4     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            r4 = move-exception
            com.amazonaws.logging.Log r5 = f15003e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error in moving the service to foreground state: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.c(r4)
        L_0x0063:
            monitor-enter(r3)
            boolean r4 = r3.f15005b     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x008e
            com.amazonaws.logging.Log r4 = f15003e     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            java.lang.String r5 = "Registering the network receiver"
            r4.j(r5)     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r4 = f15004f     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            java.lang.String r0 = "android.net.conn.CONNECTIVITY_CHANGE"
            r5.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            r3.registerReceiver(r4, r5)     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            r4 = 0
            r3.f15005b = r4     // Catch:{ IllegalArgumentException -> 0x0087, IllegalStateException -> 0x007f }
            goto L_0x008e
        L_0x007f:
            com.amazonaws.logging.Log r4 = f15003e     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "Ignoring the leak in registering the receiver."
            r4.g(r5)     // Catch:{ all -> 0x0090 }
            goto L_0x008e
        L_0x0087:
            com.amazonaws.logging.Log r4 = f15003e     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = "Ignoring the exception trying to register the receiver for connectivity change."
            r4.g(r5)     // Catch:{ all -> 0x0090 }
        L_0x008e:
            monitor-exit(r3)     // Catch:{ all -> 0x0090 }
            return r6
        L_0x0090:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0090 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onStartCommand(android.content.Intent, int, int):int");
    }
}
