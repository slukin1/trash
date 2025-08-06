package com.tencent.liteav.audio2.route;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.media.AudioManager;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.List;

public final class b implements BluetoothProfile.ServiceListener {

    /* renamed from: a  reason: collision with root package name */
    public final BluetoothAdapter f21391a;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothProfile f21392b = null;

    /* renamed from: c  reason: collision with root package name */
    public final Object f21393c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Context f21394d;

    /* renamed from: e  reason: collision with root package name */
    private AudioManager f21395e;

    public b(Context context) {
        this.f21394d = context;
        BluetoothAdapter c11 = c();
        this.f21391a = c11;
        if (c11 != null) {
            try {
                c11.getProfileProxy(context, this, 1);
            } catch (Throwable th2) {
                Log.w("BluetoothHeadsetListener", "Get profile proxy exception " + th2.getMessage(), new Object[0]);
            }
        } else {
            Log.i("BluetoothHeadsetListener", "Bluetooth adapter is null", new Object[0]);
        }
        this.f21395e = (AudioManager) this.f21394d.getSystemService("audio");
    }

    private static BluetoothAdapter c() {
        try {
            return BluetoothAdapter.getDefaultAdapter();
        } catch (Throwable th2) {
            Log.w("BluetoothHeadsetListener", "Get default adapter exception " + th2.getMessage(), new Object[0]);
            return null;
        }
    }

    private List<BluetoothDevice> d() {
        try {
            return this.f21392b.getConnectedDevices();
        } catch (Throwable th2) {
            Log.w("BluetoothHeadsetListener", "Get connected devices exception " + th2.getMessage(), new Object[0]);
            return null;
        }
    }

    private boolean e() {
        try {
            return this.f21391a.isEnabled();
        } catch (Throwable th2) {
            Log.w("BluetoothHeadsetListener", "Get bluetooth adapter status exception " + th2.getMessage(), new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0091, code lost:
        if (r3.size() > 0) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r9 = this;
            android.bluetooth.BluetoothAdapter r0 = r9.f21391a
            r1 = 0
            if (r0 == 0) goto L_0x00c5
            boolean r0 = r9.e()
            if (r0 != 0) goto L_0x000d
            goto L_0x00c5
        L_0x000d:
            java.lang.Object r0 = r9.f21393c
            monitor-enter(r0)
            android.bluetooth.BluetoothProfile r2 = r9.f21392b     // Catch:{ all -> 0x00c2 }
            if (r2 != 0) goto L_0x0056
            java.lang.String r2 = "BluetoothHeadsetListener"
            java.lang.String r3 = "mBluetoothHeadsetProfile is null ,wait for 1000ms"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0025 }
            com.tencent.liteav.base.Log.i(r2, r3, r4)     // Catch:{ all -> 0x0025 }
            java.lang.Object r2 = r9.f21393c     // Catch:{ all -> 0x0025 }
            r3 = 1000(0x3e8, double:4.94E-321)
            r2.wait(r3)     // Catch:{ all -> 0x0025 }
            goto L_0x003f
        L_0x0025:
            r2 = move-exception
            java.lang.String r3 = "BluetoothHeadsetListener"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = "Wait exception "
            r4.<init>(r5)     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00c2 }
            r4.append(r2)     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00c2 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c2 }
            com.tencent.liteav.base.Log.w(r3, r2, r4)     // Catch:{ all -> 0x00c2 }
        L_0x003f:
            android.bluetooth.BluetoothProfile r2 = r9.f21392b     // Catch:{ all -> 0x00c2 }
            if (r2 != 0) goto L_0x004d
            java.lang.String r2 = "BluetoothHeadsetListener"
            java.lang.String r3 = "mBluetoothHeadsetProfile is still null"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c2 }
            com.tencent.liteav.base.Log.i(r2, r3, r4)     // Catch:{ all -> 0x00c2 }
            goto L_0x0056
        L_0x004d:
            java.lang.String r2 = "BluetoothHeadsetListener"
            java.lang.String r3 = "mBluetoothHeadsetProfile service is connected now"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c2 }
            com.tencent.liteav.base.Log.i(r2, r3, r4)     // Catch:{ all -> 0x00c2 }
        L_0x0056:
            r2 = 1
            int r3 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()     // Catch:{ all -> 0x0094 }
            r4 = 30
            if (r3 <= r4) goto L_0x007f
            android.media.AudioManager r3 = r9.f21395e     // Catch:{ all -> 0x0094 }
            r4 = 2
            android.media.AudioDeviceInfo[] r3 = r3.getDevices(r4)     // Catch:{ all -> 0x0094 }
            int r4 = r3.length     // Catch:{ all -> 0x0094 }
            r5 = r1
        L_0x0068:
            if (r5 >= r4) goto L_0x00ae
            r6 = r3[r5]     // Catch:{ all -> 0x0094 }
            int r7 = r6.getType()     // Catch:{ all -> 0x0094 }
            r8 = 8
            if (r7 == r8) goto L_0x00af
            int r6 = r6.getType()     // Catch:{ all -> 0x0094 }
            r7 = 7
            if (r6 != r7) goto L_0x007c
            goto L_0x00af
        L_0x007c:
            int r5 = r5 + 1
            goto L_0x0068
        L_0x007f:
            android.content.Context r3 = r9.f21394d     // Catch:{ all -> 0x0094 }
            boolean r3 = a(r3)     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x00ae
            java.util.List r3 = r9.d()     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x00ae
            int r3 = r3.size()     // Catch:{ all -> 0x0094 }
            if (r3 <= 0) goto L_0x00ae
            goto L_0x00af
        L_0x0094:
            r2 = move-exception
            java.lang.String r3 = "BluetoothHeadsetListener"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = "get connected bluetooth devices failed."
            r4.<init>(r5)     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00c2 }
            r4.append(r2)     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00c2 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c2 }
            com.tencent.liteav.base.Log.e(r3, r2, r4)     // Catch:{ all -> 0x00c2 }
        L_0x00ae:
            r2 = r1
        L_0x00af:
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            java.lang.String r0 = "BluetoothHeadsetListener"
            java.lang.String r3 = "find bluetooth device "
            java.lang.String r4 = java.lang.String.valueOf(r2)
            java.lang.String r3 = r3.concat(r4)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.tencent.liteav.base.Log.i(r0, r3, r1)
            return r2
        L_0x00c2:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            throw r1
        L_0x00c5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio2.route.b.a():boolean");
    }

    public final void b() {
        try {
            this.f21391a.closeProfileProxy(1, this.f21392b);
        } catch (Throwable th2) {
            Log.w("BluetoothHeadsetListener", "Close profile proxy exception " + th2.getMessage(), new Object[0]);
        }
    }

    public final void onServiceConnected(int i11, BluetoothProfile bluetoothProfile) {
        BluetoothProfile bluetoothProfile2;
        if (i11 == 1) {
            synchronized (this.f21393c) {
                if (!(this.f21391a == null || (bluetoothProfile2 = this.f21392b) == null)) {
                    Log.i("BluetoothHeadsetListener", "Bluetooth Headset proxy changed from %s to %s", bluetoothProfile2, bluetoothProfile);
                    b();
                }
                this.f21392b = bluetoothProfile;
                this.f21393c.notifyAll();
            }
        }
    }

    public final void onServiceDisconnected(int i11) {
        if (i11 == 1) {
            synchronized (this.f21393c) {
                if (!(this.f21391a == null || this.f21392b == null)) {
                    b();
                    this.f21392b = null;
                }
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null || LiteavSystemInfo.getSystemOSVersionInt() < 31) {
            return true;
        }
        try {
            if (context.checkPermission("android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.w("BluetoothHeadsetListener", "checkPermission exception " + th2.getMessage(), new Object[0]);
            return true;
        }
    }
}
