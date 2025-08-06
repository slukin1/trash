package com.google.android.exoplayer2.audio;

@Deprecated
public interface AudioListener {
    void onAudioAttributesChanged(AudioAttributes audioAttributes);

    void onAudioSessionIdChanged(int i11);

    void onSkipSilenceEnabledChanged(boolean z11);

    void onVolumeChanged(float f11);
}
