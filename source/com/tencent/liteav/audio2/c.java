package com.tencent.liteav.audio2;

import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.List;

public final class c extends AudioManager.AudioPlaybackCallback {

    /* renamed from: a  reason: collision with root package name */
    public volatile a f21325a;

    public interface a {
        void a();
    }

    public c() {
        AudioManager audioManager;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26 && (audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio")) != null) {
            try {
                audioManager.registerAudioPlaybackCallback(this, (Handler) null);
                Log.i("LiteavAudioPlaybackCallback", "register audio playback callback", new Object[0]);
            } catch (Throwable th2) {
                Log.e("LiteavAudioPlaybackCallback", "register audio playback callback exception " + th2.getMessage(), new Object[0]);
            }
        }
    }

    public final void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> list) {
        a aVar = this.f21325a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
