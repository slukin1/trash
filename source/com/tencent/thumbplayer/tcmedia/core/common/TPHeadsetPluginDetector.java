package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TPHeadsetPluginDetector {
    private static final int AUDIO_TYPE_BLUETOOTH_A2DP = 2;
    private static final int AUDIO_TYPE_BUILTIN_OTHERS = 99;
    private static final int AUDIO_TYPE_BUILTIN_SPEAKER = 0;
    private static final int AUDIO_TYPE_HEADPHONES = 1;
    private static final String TAG = "TPHeadsetPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static List<HeadsetPluginListener> listeners = new LinkedList();
    private static WeakReference<Context> mContextRef;
    /* access modifiers changed from: private */
    public static Set<Integer> mCurOutputs = null;
    private static BroadcastReceiver mReceiver;

    public interface HeadsetPluginListener {
        void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2);
    }

    public static class HeadsetPluginReceiver extends BroadcastReceiver {
        private HeadsetPluginReceiver() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
            if (r7 != null) goto L_0x0045;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r7, android.content.Intent r8) {
            /*
                r6 = this;
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(r6, r7, r8)
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r0 = "onReceive: "
                r7.<init>(r0)
                java.lang.String r0 = r8.getAction()
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r0 = 2
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                java.lang.String r2 = "TPHeadsetPluginDetector"
                com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r0, r2, r7)
                java.util.Set r7 = com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.getAudioOutputs()
                java.lang.String r2 = r8.getAction()
                java.lang.String r3 = "android.intent.action.HEADSET_PLUG"
                boolean r2 = r3.equals(r2)
                r3 = 0
                r4 = 1
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                if (r2 == 0) goto L_0x0056
                java.lang.String r0 = "state"
                boolean r1 = r8.hasExtra(r0)
                if (r1 == 0) goto L_0x0041
                int r3 = r8.getIntExtra(r0, r3)
            L_0x0041:
                if (r7 == 0) goto L_0x004e
                if (r3 != 0) goto L_0x0049
            L_0x0045:
                r7.remove(r5)
                goto L_0x004e
            L_0x0049:
                if (r3 != r4) goto L_0x004e
                r7.add(r5)
            L_0x004e:
                java.util.Set r8 = com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.mCurOutputs
                com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.notifyAudioOutputStateChange(r8, r7)
                return
            L_0x0056:
                java.lang.String r2 = r8.getAction()
                java.lang.String r4 = "android.media.AUDIO_BECOMING_NOISY"
                boolean r2 = r4.equals(r2)
                if (r2 == 0) goto L_0x0065
                if (r7 == 0) goto L_0x004e
                goto L_0x0045
            L_0x0065:
                java.lang.String r2 = r8.getAction()
                java.lang.String r4 = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED"
                boolean r2 = r4.equals(r2)
                if (r2 == 0) goto L_0x008b
                java.lang.String r2 = "android.bluetooth.profile.extra.STATE"
                int r8 = r8.getIntExtra(r2, r3)
                if (r7 == 0) goto L_0x0084
                if (r8 != r0) goto L_0x007f
                r7.add(r1)
                goto L_0x0084
            L_0x007f:
                if (r8 != 0) goto L_0x0084
                r7.remove(r1)
            L_0x0084:
                java.util.Set r8 = com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.mCurOutputs
                com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.notifyAudioOutputStateChange(r8, r7)
            L_0x008b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.HeadsetPluginReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public static void addHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        synchronized (TPHeadsetPluginDetector.class) {
            if (listeners.add(headsetPluginListener) && !hasRegisterReceiver) {
                registerReceiver();
                hasRegisterReceiver = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void deinit() {
        /*
            java.lang.Class<com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector> r0 = com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.class
            monitor-enter(r0)
            boolean r1 = isInitted     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x001c
            java.lang.ref.WeakReference<android.content.Context> r1 = mContextRef     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x000c
            goto L_0x001c
        L_0x000c:
            r1.clear()     // Catch:{ all -> 0x001e }
            r1 = 0
            isInitted = r1     // Catch:{ all -> 0x001e }
            r1 = 2
            java.lang.String r2 = "TPHeadsetPluginDetector"
            java.lang.String r3 = "HeadsetPluginDetector deinit succeed!"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r2, r3)     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector.deinit():void");
    }

    private static AudioManager getAudioManager() {
        String str;
        WeakReference<Context> weakReference;
        if (!isInitted || (weakReference = mContextRef) == null) {
            str = "getAudioManager failed, HeadsetPluginDetector is not init yet!";
        } else {
            Context context = (Context) weakReference.get();
            if (context == null) {
                str = "getAudioManager failed, context is null, maybe is invalid!";
            } else {
                AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    return audioManager;
                }
                str = "getAudioManager failed, audioMgr is null!";
            }
        }
        TPNativeLog.printLog(4, TAG, str);
        return null;
    }

    /* access modifiers changed from: private */
    public static Set<Integer> getAudioOutputs() {
        int i11;
        HashSet hashSet = new HashSet();
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return hashSet;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            AudioDeviceInfo[] devices = audioManager.getDevices(2);
            if (devices != null) {
                for (AudioDeviceInfo audioDeviceInfo : devices) {
                    if (audioDeviceInfo.getType() == 2) {
                        i11 = 0;
                    } else if (audioDeviceInfo.getType() == 8) {
                        i11 = 2;
                    } else if (audioDeviceInfo.getType() == 3) {
                        i11 = 1;
                    }
                    hashSet.add(i11);
                }
            }
        } else {
            hashSet.add(0);
            if (isHeadsetPlugin()) {
                hashSet.add(1);
            }
            if (isBluetoothPlugin()) {
                hashSet.add(2);
            }
        }
        return hashSet;
    }

    public static Set<Integer> getCurrentRoutes() {
        return mCurOutputs;
    }

    public static void init(Context context) {
        synchronized (TPHeadsetPluginDetector.class) {
            if (!isInitted) {
                mContextRef = new WeakReference<>(context.getApplicationContext());
                isInitted = true;
                initCurrentOutputs();
                TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector init succeed!");
            }
        }
    }

    private static void initCurrentOutputs() {
        mCurOutputs = getAudioOutputs();
    }

    public static boolean isAudioRouteTypeOn(int i11) {
        Set<Integer> set = mCurOutputs;
        if (set == null) {
            return false;
        }
        return set.contains(Integer.valueOf(i11));
    }

    public static boolean isBluetoothPlugin() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return false;
        }
        return audioManager.isBluetoothA2dpOn();
    }

    public static boolean isHeadsetPlugin() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return false;
        }
        return audioManager.isWiredHeadsetOn();
    }

    /* access modifiers changed from: private */
    public static void notifyAudioOutputStateChange(Set<Integer> set, Set<Integer> set2) {
        if (set == null || set2 == null || set.size() != set2.size() || !set2.containsAll(set)) {
            mCurOutputs = set2;
            synchronized (TPHeadsetPluginDetector.class) {
                for (HeadsetPluginListener onHeadsetPlugin : listeners) {
                    onHeadsetPlugin.onHeadsetPlugin(set, set2);
                }
            }
        }
    }

    private static boolean registerDeviceCallback() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            return false;
        }
        audioManager.registerAudioDeviceCallback(new AudioDeviceCallback() {
            public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesAdded!");
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.getAudioOutputs());
            }

            public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesRemoved!");
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.getAudioOutputs());
            }
        }, (Handler) null);
        return true;
    }

    private static void registerReceiver() {
        WeakReference<Context> weakReference;
        if (Build.VERSION.SDK_INT < 23 || !registerDeviceCallback()) {
            if (mReceiver == null) {
                mReceiver = new HeadsetPluginReceiver();
            }
            if (!isInitted || (weakReference = mContextRef) == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, TPHeadsetPluginDetector is not init yet!");
                return;
            }
            Context context = (Context) weakReference.get();
            if (context == null) {
                TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            context.registerReceiver(mReceiver, intentFilter);
        }
    }

    public static void removeHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        synchronized (TPHeadsetPluginDetector.class) {
            listeners.remove(headsetPluginListener);
            if (listeners.isEmpty() && hasRegisterReceiver) {
                unregisterReceiver();
                hasRegisterReceiver = false;
            }
        }
    }

    private static void unregisterReceiver() {
        WeakReference<Context> weakReference;
        if (!isInitted || (weakReference = mContextRef) == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, HeadsetPluginDetector is not init yet!");
            return;
        }
        Context context = (Context) weakReference.get();
        if (context == null) {
            TPNativeLog.printLog(4, TAG, "registerReceiver failed, context is null, maybe is invalid!");
        } else {
            context.unregisterReceiver(mReceiver);
        }
    }
}
