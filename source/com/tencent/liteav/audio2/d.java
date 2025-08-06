package com.tencent.liteav.audio2;

import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Handler;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.List;

public final class d extends AudioManager.AudioRecordingCallback {

    /* renamed from: a  reason: collision with root package name */
    public volatile a f21326a;

    public interface a {
        void OnRecordingConfigChanged(List<AudioRecordingConfiguration> list);
    }

    public d() {
        AudioManager audioManager;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24 && (audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio")) != null) {
            try {
                audioManager.registerAudioRecordingCallback(this, (Handler) null);
                Log.i("LiteavAudioRecordingCallback", "register audio recording callback", new Object[0]);
            } catch (Throwable th2) {
                Log.e("LiteavAudioRecordingCallback", "register audio recording callback exception " + th2.getMessage(), new Object[0]);
            }
        }
    }

    public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
        a aVar = this.f21326a;
        if (aVar != null) {
            aVar.OnRecordingConfigChanged(list);
        }
    }
}
