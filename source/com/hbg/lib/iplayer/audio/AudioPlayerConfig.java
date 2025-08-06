package com.hbg.lib.iplayer.audio;

import com.hbg.lib.iplayer.common.util.LogUtil;

public class AudioPlayerConfig {

    /* renamed from: a  reason: collision with root package name */
    public boolean f69195a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69196b;

    public boolean a() {
        c("isRegisterAudioFocus-->" + this.f69195a);
        return this.f69195a;
    }

    public boolean b() {
        c("isRegisterMediaSession-->" + this.f69196b);
        return this.f69196b;
    }

    public final void c(String str) {
        LogUtil.a("AudioPlayerConfig-->" + str);
    }
}
