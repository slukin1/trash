package com.tencent.liteav.audio2.route;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.liteav.audio2.route.a;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;

@JNINamespace("liteav::audio")
public class AudioDeviceProperty implements a.C0168a {
    private static final String TAG = "AudioDeviceProperty";
    private AudioDeviceCallback mAudioDeviceCallback;
    private a mAudioEventBroadcastReceiver;
    private final AudioManager mAudioManager;
    private b mBluetoothHeadsetListener;
    private final Context mContext;
    /* access modifiers changed from: private */
    public long mNativeAudioDeviceProperty;

    public AudioDeviceProperty(long j11) {
        this.mNativeAudioDeviceProperty = j11;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mContext = applicationContext;
        this.mAudioManager = (AudioManager) applicationContext.getSystemService("audio");
    }

    private void buildAudioDeviceCallback() {
        if (this.mAudioDeviceCallback == null) {
            this.mAudioDeviceCallback = new AudioDeviceCallback() {
                public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                    if (audioDeviceInfoArr.length != 0) {
                        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                            Log.i(AudioDeviceProperty.TAG, "added device type is " + audioDeviceInfo.getType() + " sink: " + audioDeviceInfo.isSink(), new Object[0]);
                            if (audioDeviceInfo.getType() == 8) {
                                AudioDeviceProperty.nativeNotifyBluetoothConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, true);
                            }
                        }
                    }
                }

                public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                    if (audioDeviceInfoArr.length != 0) {
                        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                            Log.i(AudioDeviceProperty.TAG, "removed device type is " + audioDeviceInfo.getType() + " sink: " + audioDeviceInfo.isSink(), new Object[0]);
                            if (audioDeviceInfo.getType() == 8) {
                                AudioDeviceProperty.nativeNotifyBluetoothConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, false);
                            }
                        }
                    }
                }
            };
        }
    }

    public static boolean isUsbHeadsetDevice(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        int i11 = 0;
        while (i11 < usbDevice.getInterfaceCount()) {
            try {
                if (usbDevice.getInterface(i11).getInterfaceClass() == 1) {
                    return true;
                }
                i11++;
            } catch (Throwable th2) {
                Log.e(TAG, "Get interface exception " + th2.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static native void nativeNotifyBluetoothConnectionChangedFromJava(long j11, boolean z11);

    private static native void nativeNotifyBluetoothScoConnectedFromJava(long j11, boolean z11);

    private static native void nativeNotifySystemVolumeChangedFromJava(long j11);

    private static native void nativeNotifyUsbConnectionChangedFromJava(long j11, boolean z11);

    private static native void nativeNotifyWiredHeadsetConnectionChangedFromJava(long j11, boolean z11);

    private void registerAudioDeviceCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() > 30) {
            if (this.mAudioDeviceCallback == null) {
                buildAudioDeviceCallback();
            }
            AudioDeviceCallback audioDeviceCallback = this.mAudioDeviceCallback;
            if (audioDeviceCallback != null) {
                try {
                    this.mAudioManager.registerAudioDeviceCallback(audioDeviceCallback, (Handler) null);
                    Log.i(TAG, "register audio device callback", new Object[0]);
                } catch (Throwable th2) {
                    Log.e(TAG, "registerAudioDeviceCallback exception " + th2.getMessage(), new Object[0]);
                }
            }
        }
    }

    private void unregisterAudioDeviceCallback() {
        AudioDeviceCallback audioDeviceCallback;
        if (LiteavSystemInfo.getSystemOSVersionInt() > 30 && (audioDeviceCallback = this.mAudioDeviceCallback) != null) {
            try {
                this.mAudioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
                Log.i(TAG, "unregister audio device callback", new Object[0]);
            } catch (Throwable th2) {
                Log.e(TAG, "unregisterAudioDeviceCallback exception " + th2.getMessage(), new Object[0]);
            }
        }
    }

    public boolean checkBluetoothPermission() {
        return b.a(this.mContext);
    }

    public int getMode() {
        try {
            return this.mAudioManager.getMode();
        } catch (Throwable th2) {
            Log.i(TAG, "Get mode exception " + th2.getMessage(), new Object[0]);
            return 0;
        }
    }

    public int getSystemVolume() {
        try {
            AudioManager audioManager = this.mAudioManager;
            return audioManager.getStreamVolume(audioManager.getMode() == 0 ? 3 : 0);
        } catch (Throwable th2) {
            Log.e(TAG, "getStreamVolume exception " + th2.getMessage(), new Object[0]);
            return -1;
        }
    }

    public boolean isBluetoothHeadsetConnected() {
        b bVar = this.mBluetoothHeadsetListener;
        if (bVar != null) {
            return bVar.a();
        }
        Log.e(TAG, "mBluetoothHeadsetListener is null", new Object[0]);
        return false;
    }

    public boolean isBluetoothScoConnected() {
        try {
            new IntentFilter();
            Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
            if (registerReceiver != null && registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0) == 1) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.i(TAG, "isBluetoothScoConnected exception " + th2.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isBluetoothScoOn() {
        try {
            return this.mAudioManager.isBluetoothScoOn();
        } catch (Throwable th2) {
            Log.i(TAG, "isBluetoothScoOn exception " + th2.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isSpeakerphoneOn() {
        try {
            return this.mAudioManager.isSpeakerphoneOn();
        } catch (Throwable th2) {
            Log.i(TAG, "isSpeakerphoneOn exception " + th2.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isUsbHeadsetAvailable() {
        try {
            UsbManager usbManager = (UsbManager) this.mContext.getSystemService("usb");
            if (usbManager == null) {
                return false;
            }
            for (UsbDevice isUsbHeadsetDevice : usbManager.getDeviceList().values()) {
                if (isUsbHeadsetDevice(isUsbHeadsetDevice)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            Log.i(TAG, "getDeviceList exception " + th2.getMessage(), new Object[0]);
        }
    }

    public boolean isWiredHeadsetOn() {
        try {
            return this.mAudioManager.isWiredHeadsetOn();
        } catch (Throwable th2) {
            Log.i(TAG, "isWiredHeadsetOn exception " + th2.getMessage(), new Object[0]);
            return false;
        }
    }

    public void onBluetoothConnectionChanged(boolean z11) {
        nativeNotifyBluetoothConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z11);
    }

    public void onBluetoothScoConnected(boolean z11) {
        nativeNotifyBluetoothScoConnectedFromJava(this.mNativeAudioDeviceProperty, z11);
    }

    public void onSystemVolumeChanged() {
        nativeNotifySystemVolumeChangedFromJava(this.mNativeAudioDeviceProperty);
    }

    public void onUsbConnectionChanged(boolean z11) {
        nativeNotifyUsbConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z11);
    }

    public void onWiredHeadsetConnectionChanged(boolean z11) {
        nativeNotifyWiredHeadsetConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z11);
    }

    public void setBluetoothScoOn(boolean z11) {
        try {
            this.mAudioManager.setBluetoothScoOn(z11);
            Log.i(TAG, "setBluetoothScoOn ".concat(String.valueOf(z11)), new Object[0]);
        } catch (Throwable th2) {
            Log.i(TAG, "setBluetoothScoOn exception " + th2.getMessage(), new Object[0]);
        }
    }

    public void setSpeakerphoneOn(boolean z11) {
        try {
            this.mAudioManager.setSpeakerphoneOn(z11);
            Log.i(TAG, "setSpeakerphoneOn ".concat(String.valueOf(z11)), new Object[0]);
        } catch (Throwable th2) {
            Log.i(TAG, "setSpeakerphoneOn exception " + th2.getMessage(), new Object[0]);
        }
    }

    public void setVoip(boolean z11) {
        int i11 = z11 ? 3 : 0;
        try {
            this.mAudioManager.setMode(i11);
            Log.i(TAG, "setMode ".concat(String.valueOf(i11)), new Object[0]);
        } catch (Throwable th2) {
            Log.i(TAG, "Set mode exception " + th2.getMessage(), new Object[0]);
        }
    }

    public void setWiredHeadsetOn(boolean z11) {
        try {
            this.mAudioManager.setWiredHeadsetOn(z11);
            Log.i(TAG, "setWiredHeadsetOn ".concat(String.valueOf(z11)), new Object[0]);
        } catch (Throwable th2) {
            Log.i(TAG, "setWiredHeadsetOn exception " + th2.getMessage(), new Object[0]);
        }
    }

    public void start() {
        a aVar = new a(this.mContext, this);
        this.mAudioEventBroadcastReceiver = aVar;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            aVar.f21389a.registerReceiver(aVar, intentFilter);
        } catch (Throwable unused) {
            Log.e("AudioEventBroadcastReceiver", "register broadcast exception", new Object[0]);
        }
        registerAudioDeviceCallback();
        this.mBluetoothHeadsetListener = new b(this.mContext);
    }

    public void startBluetoothSco() {
        try {
            this.mAudioManager.startBluetoothSco();
            Log.i(TAG, "startBluetoothSco", new Object[0]);
        } catch (Throwable th2) {
            Log.i(TAG, "startBluetoothSco exception " + th2.getMessage(), new Object[0]);
        }
    }

    public void stop() {
        Context context;
        a aVar = this.mAudioEventBroadcastReceiver;
        if (!(aVar == null || (context = aVar.f21389a) == null)) {
            try {
                context.unregisterReceiver(aVar);
            } catch (Exception unused) {
            }
        }
        this.mAudioEventBroadcastReceiver = null;
        b bVar = this.mBluetoothHeadsetListener;
        if (bVar != null) {
            synchronized (bVar.f21393c) {
                if (!(bVar.f21391a == null || bVar.f21392b == null)) {
                    bVar.b();
                    bVar.f21392b = null;
                }
            }
        }
        this.mBluetoothHeadsetListener = null;
        unregisterAudioDeviceCallback();
    }

    public void stopBluetoothSco() {
        try {
            this.mAudioManager.stopBluetoothSco();
            Log.i(TAG, "stopBluetoothSco", new Object[0]);
        } catch (Throwable th2) {
            Log.i(TAG, "stopBluetoothSco exception " + th2.getMessage(), new Object[0]);
        }
    }
}
