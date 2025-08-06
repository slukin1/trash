package com.tencent.liteav.audio2.route;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteav.base.Log;

public final class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f21389a;

    /* renamed from: b  reason: collision with root package name */
    private final C0168a f21390b;

    /* renamed from: com.tencent.liteav.audio2.route.a$a  reason: collision with other inner class name */
    public interface C0168a {
        void onBluetoothConnectionChanged(boolean z11);

        void onBluetoothScoConnected(boolean z11);

        void onSystemVolumeChanged();

        void onUsbConnectionChanged(boolean z11);

        void onWiredHeadsetConnectionChanged(boolean z11);
    }

    public a(Context context, C0168a aVar) {
        this.f21389a = context;
        this.f21390b = aVar;
    }

    private static int a(Intent intent, String str, int i11) {
        try {
            return intent.getIntExtra(str, i11);
        } catch (Exception e11) {
            Log.e("AudioEventBroadcastReceiver", "getIntentIntExtra ".concat(String.valueOf(e11)), new Object[0]);
            return i11;
        }
    }

    private static String a(int i11) {
        switch (i11) {
            case 10:
                return "STATE_OFF";
            case 11:
                return "STATE_TURNING_ON";
            case 12:
                return "STATE_ON";
            case 13:
                return "STATE_TURNING_OFF";
            default:
                return "unknown";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r12, android.content.Intent r13) {
        /*
            r11 = this;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(r11, r12, r13)
            java.lang.String r0 = "AudioEventBroadcastReceiver"
            r1 = 0
            if (r13 == 0) goto L_0x01b9
            if (r12 != 0) goto L_0x000c
            goto L_0x01b9
        L_0x000c:
            java.lang.String r12 = r13.getAction()
            if (r12 != 0) goto L_0x0013
            return
        L_0x0013:
            int r2 = r12.hashCode()
            r3 = 3
            java.lang.String r4 = "android.hardware.usb.action.USB_DEVICE_DETACHED"
            java.lang.String r5 = "android.hardware.usb.action.USB_DEVICE_ATTACHED"
            r6 = 2
            r7 = -1
            r8 = 1
            switch(r2) {
                case -2114103349: goto L_0x0064;
                case -1940635523: goto L_0x0059;
                case -1676458352: goto L_0x004e;
                case -1608292967: goto L_0x0045;
                case -1530327060: goto L_0x003a;
                case -1435586571: goto L_0x002f;
                case 545516589: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            r2 = r7
            goto L_0x006c
        L_0x0024:
            java.lang.String r2 = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"
            boolean r2 = r12.equals(r2)
            if (r2 != 0) goto L_0x002d
            goto L_0x0022
        L_0x002d:
            r2 = 6
            goto L_0x006c
        L_0x002f:
            java.lang.String r2 = "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"
            boolean r2 = r12.equals(r2)
            if (r2 != 0) goto L_0x0038
            goto L_0x0022
        L_0x0038:
            r2 = 5
            goto L_0x006c
        L_0x003a:
            java.lang.String r2 = "android.bluetooth.adapter.action.STATE_CHANGED"
            boolean r2 = r12.equals(r2)
            if (r2 != 0) goto L_0x0043
            goto L_0x0022
        L_0x0043:
            r2 = 4
            goto L_0x006c
        L_0x0045:
            boolean r2 = r12.equals(r4)
            if (r2 != 0) goto L_0x004c
            goto L_0x0022
        L_0x004c:
            r2 = r3
            goto L_0x006c
        L_0x004e:
            java.lang.String r2 = "android.intent.action.HEADSET_PLUG"
            boolean r2 = r12.equals(r2)
            if (r2 != 0) goto L_0x0057
            goto L_0x0022
        L_0x0057:
            r2 = r6
            goto L_0x006c
        L_0x0059:
            java.lang.String r2 = "android.media.VOLUME_CHANGED_ACTION"
            boolean r2 = r12.equals(r2)
            if (r2 != 0) goto L_0x0062
            goto L_0x0022
        L_0x0062:
            r2 = r8
            goto L_0x006c
        L_0x0064:
            boolean r2 = r12.equals(r5)
            if (r2 != 0) goto L_0x006b
            goto L_0x0022
        L_0x006b:
            r2 = r1
        L_0x006c:
            java.lang.String r9 = "android.bluetooth.profile.extra.STATE"
            r10 = 10
            switch(r2) {
                case 0: goto L_0x013e;
                case 1: goto L_0x0136;
                case 2: goto L_0x010e;
                case 3: goto L_0x013e;
                case 4: goto L_0x00d7;
                case 5: goto L_0x00b3;
                case 6: goto L_0x007f;
                default: goto L_0x0073;
            }
        L_0x0073:
            java.lang.String r13 = "Ignore unknown Action:"
            java.lang.String r12 = r13.concat(r12)
            java.lang.Object[] r13 = new java.lang.Object[r1]
            com.tencent.liteav.base.Log.w(r0, r12, r13)
            return
        L_0x007f:
            int r12 = a(r13, r9, r7)
            java.lang.Object[] r13 = new java.lang.Object[r8]
            if (r12 == 0) goto L_0x0099
            if (r12 == r8) goto L_0x0096
            if (r12 == r6) goto L_0x0093
            if (r12 == r3) goto L_0x0090
            java.lang.String r2 = "unknown"
            goto L_0x009b
        L_0x0090:
            java.lang.String r2 = "STATE_DISCONNECTING"
            goto L_0x009b
        L_0x0093:
            java.lang.String r2 = "STATE_CONNECTED"
            goto L_0x009b
        L_0x0096:
            java.lang.String r2 = "STATE_CONNECTING"
            goto L_0x009b
        L_0x0099:
            java.lang.String r2 = "STATE_DISCONNECTED"
        L_0x009b:
            r13[r1] = r2
            java.lang.String r2 = "Receive bluetooth headset connection state changed: %s"
            com.tencent.liteav.base.Log.i(r0, r2, r13)
            if (r12 == 0) goto L_0x00ad
            if (r12 == r6) goto L_0x00a7
            goto L_0x00ac
        L_0x00a7:
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onBluetoothConnectionChanged(r8)
        L_0x00ac:
            return
        L_0x00ad:
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onBluetoothConnectionChanged(r1)
            return
        L_0x00b3:
            int r12 = a(r13, r9, r10)
            r13 = 12
            if (r12 != r13) goto L_0x00c8
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "Receive bluetooth audio state changed to STATE_AUDIO_CONNECTED"
            com.tencent.liteav.base.Log.i(r0, r13, r12)
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onBluetoothScoConnected(r8)
            return
        L_0x00c8:
            if (r12 != r10) goto L_0x00d6
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "Receive bluetooth audio state changed to STATE_AUDIO_DISCONNECTED"
            com.tencent.liteav.base.Log.i(r0, r13, r12)
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onBluetoothScoConnected(r1)
        L_0x00d6:
            return
        L_0x00d7:
            java.lang.String r12 = "android.bluetooth.adapter.extra.STATE"
            int r12 = a(r13, r12, r1)
            java.lang.String r2 = "android.bluetooth.adapter.extra.PREVIOUS_STATE"
            int r13 = a(r13, r2, r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Receive ACTION_STATE_CHANGED, EXTRA_STATE:"
            r2.<init>(r3)
            java.lang.String r3 = a(r12)
            r2.append(r3)
            java.lang.String r3 = " EXTRA_PREVIOUS_STATE: "
            r2.append(r3)
            java.lang.String r13 = a(r13)
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.tencent.liteav.base.Log.i(r0, r13, r2)
            if (r12 != r10) goto L_0x010d
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onBluetoothConnectionChanged(r1)
        L_0x010d:
            return
        L_0x010e:
            java.lang.String r12 = "state"
            int r12 = a(r13, r12, r7)
            java.lang.String r13 = java.lang.String.valueOf(r12)
            java.lang.String r2 = "Receive ACTION_HEADSET_PLUG, EXTRA_STATE:"
            java.lang.String r13 = r2.concat(r13)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.tencent.liteav.base.Log.i(r0, r13, r2)
            if (r12 != r7) goto L_0x012d
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "Unknown headset state, ignore..."
            com.tencent.liteav.base.Log.e(r0, r13, r12)
            return
        L_0x012d:
            com.tencent.liteav.audio2.route.a$a r13 = r11.f21390b
            if (r12 == 0) goto L_0x0132
            r1 = r8
        L_0x0132:
            r13.onWiredHeadsetConnectionChanged(r1)
            return
        L_0x0136:
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            if (r12 == 0) goto L_0x013d
            r12.onSystemVolumeChanged()
        L_0x013d:
            return
        L_0x013e:
            java.lang.String r12 = "device"
            android.os.Parcelable r12 = r13.getParcelableExtra(r12)
            android.hardware.usb.UsbDevice r12 = (android.hardware.usb.UsbDevice) r12
            if (r12 == 0) goto L_0x01b8
            int r2 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r3 = 21
            if (r2 < r3) goto L_0x0173
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Usb device attached "
            r2.<init>(r3)
            java.lang.String r3 = r12.getProductName()
            r2.append(r3)
            java.lang.String r3 = " manufacture "
            r2.append(r3)
            java.lang.String r3 = r12.getManufacturerName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r1]
            com.tencent.liteav.base.Log.i(r0, r2, r3)
        L_0x0173:
            boolean r12 = com.tencent.liteav.audio2.route.AudioDeviceProperty.isUsbHeadsetDevice(r12)
            if (r12 != 0) goto L_0x0181
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "The attached usb device doesn't seem to support audio, ignore it"
            com.tencent.liteav.base.Log.i(r0, r13, r12)
            return
        L_0x0181:
            java.lang.String r12 = r13.getAction()
            boolean r12 = r5.equals(r12)
            if (r12 == 0) goto L_0x0191
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onUsbConnectionChanged(r8)
            return
        L_0x0191:
            java.lang.String r12 = r13.getAction()
            boolean r12 = r4.equals(r12)
            if (r12 == 0) goto L_0x01a1
            com.tencent.liteav.audio2.route.a$a r12 = r11.f21390b
            r12.onUsbConnectionChanged(r1)
            return
        L_0x01a1:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown action, ignore it "
            r12.<init>(r2)
            java.lang.String r13 = r13.getAction()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.Object[] r13 = new java.lang.Object[r1]
            com.tencent.liteav.base.Log.i(r0, r12, r13)
        L_0x01b8:
            return
        L_0x01b9:
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "Receive intent or context is null"
            com.tencent.liteav.base.Log.e(r0, r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio2.route.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
