package com.tencent.liteav.audio2;

import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.liteav.audio2.d;
import com.tencent.liteav.audio2.e;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.List;

@JNINamespace("liteav::audio")
public class AndroidInterruptedStateListener implements d.a, e.a {
    private static final int RECORDING_CONFIGS_LIMIT = 10;
    public static final String TAG = "AndroidInterruptedStateListener";
    private static d mRecordingCallback = new d();
    private final long mNativeRecordingConfigListener;
    private volatile boolean mNeedNotify = false;
    private Object mObject = new Object();
    private e mPhoneStateManager;

    public static class RecordingConfig {

        /* renamed from: a  reason: collision with root package name */
        public int f21318a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21319b = false;

        public int getSessionId() {
            return this.f21318a;
        }

        public boolean isSilenced() {
            return this.f21319b;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
        }
    }

    public AndroidInterruptedStateListener(long j11) {
        this.mNativeRecordingConfigListener = j11;
        Log.d(TAG, "new AndroidInterruptedStateListener" + hashCode(), new Object[0]);
    }

    public static /* synthetic */ void lambda$registerAudioRecordingCallback$0(AndroidInterruptedStateListener androidInterruptedStateListener) {
        if (androidInterruptedStateListener.mPhoneStateManager == null) {
            androidInterruptedStateListener.mPhoneStateManager = new e(androidInterruptedStateListener);
        }
        e eVar = androidInterruptedStateListener.mPhoneStateManager;
        if (e.b()) {
            try {
                TelephonyManager telephonyManager = eVar.f21328a;
                if (telephonyManager != null) {
                    telephonyManager.listen(eVar, 32);
                } else {
                    Log.w("PhoneStateManager", "TelephonyManager is null, start listen phone state failed.", new Object[0]);
                }
            } catch (Throwable th2) {
                Log.e("PhoneStateManager", "start listen phone state failed, " + th2.getMessage(), new Object[0]);
            }
        } else if (Build.VERSION.SDK_INT >= 26 && e.f21327b != null) {
            Log.i("PhoneStateManager", "register audio playback callback.", new Object[0]);
            e.f21327b.f21325a = eVar;
        }
    }

    public static /* synthetic */ void lambda$unregisterAudioRecordingCallback$1(AndroidInterruptedStateListener androidInterruptedStateListener) {
        e eVar = androidInterruptedStateListener.mPhoneStateManager;
        if (eVar == null) {
            return;
        }
        if (e.b()) {
            try {
                TelephonyManager telephonyManager = eVar.f21328a;
                if (telephonyManager != null) {
                    telephonyManager.listen(eVar, 0);
                }
                eVar.f21329c = 0;
            } catch (Throwable th2) {
                Log.e("PhoneStateManager", "stop listen phone state failed, " + th2.getMessage(), new Object[0]);
            }
        } else {
            e.c();
        }
    }

    private static native void nativeNotifyAudioRecordingConfigChangedFromJava(long j11, RecordingConfig[] recordingConfigArr);

    private static native void nativeNotifyInterruptedByPhoneCallFromJava(long j11);

    private static native void nativeNotifyResumedByPhoneCallFromJava(long j11);

    public void OnRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            RecordingConfig[] recordingConfigArr = new RecordingConfig[min];
            for (int i11 = 0; i11 < min; i11++) {
                recordingConfigArr[i11] = new RecordingConfig();
                AudioRecordingConfiguration audioRecordingConfiguration = list.get(i11);
                recordingConfigArr[i11].f21318a = audioRecordingConfiguration.getClientAudioSessionId();
                if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
                    recordingConfigArr[i11].f21319b = false;
                } else if (Build.VERSION.SDK_INT >= 29) {
                    recordingConfigArr[i11].f21319b = audioRecordingConfiguration.isClientSilenced();
                }
            }
            synchronized (this.mObject) {
                if (this.mNeedNotify) {
                    nativeNotifyAudioRecordingConfigChangedFromJava(this.mNativeRecordingConfigListener, recordingConfigArr);
                }
            }
        }
    }

    public void onInterruptedByPhoneCall() {
        synchronized (this.mObject) {
            if (this.mNeedNotify) {
                nativeNotifyInterruptedByPhoneCallFromJava(this.mNativeRecordingConfigListener);
            }
        }
    }

    public void onResumedByPhoneCall() {
        synchronized (this.mObject) {
            if (this.mNeedNotify) {
                nativeNotifyResumedByPhoneCallFromJava(this.mNativeRecordingConfigListener);
            }
        }
    }

    public void registerAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24) {
            d dVar = mRecordingCallback;
            if (dVar != null) {
                dVar.f21326a = this;
            }
            ThreadUtils.getUiThreadHandler().post(a.a(this));
            this.mNeedNotify = true;
        }
    }

    public void unregisterAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24 && mRecordingCallback != null) {
            synchronized (this.mObject) {
                this.mNeedNotify = false;
                mRecordingCallback.f21326a = null;
                ThreadUtils.getUiThreadHandler().post(b.a(this));
            }
        }
    }
}
