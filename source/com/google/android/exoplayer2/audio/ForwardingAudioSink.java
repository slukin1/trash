package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioSink;
import java.nio.ByteBuffer;

public class ForwardingAudioSink implements AudioSink {
    private final AudioSink sink;

    public ForwardingAudioSink(AudioSink audioSink) {
        this.sink = audioSink;
    }

    public void configure(Format format, int i11, int[] iArr) throws AudioSink.ConfigurationException {
        this.sink.configure(format, i11, iArr);
    }

    public void disableTunneling() {
        this.sink.disableTunneling();
    }

    public void enableTunnelingV21() {
        this.sink.enableTunnelingV21();
    }

    public void experimentalFlushWithoutAudioTrackRelease() {
        this.sink.experimentalFlushWithoutAudioTrackRelease();
    }

    public void flush() {
        this.sink.flush();
    }

    public long getCurrentPositionUs(boolean z11) {
        return this.sink.getCurrentPositionUs(z11);
    }

    public int getFormatSupport(Format format) {
        return this.sink.getFormatSupport(format);
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.sink.getPlaybackParameters();
    }

    public boolean getSkipSilenceEnabled() {
        return this.sink.getSkipSilenceEnabled();
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long j11, int i11) throws AudioSink.InitializationException, AudioSink.WriteException {
        return this.sink.handleBuffer(byteBuffer, j11, i11);
    }

    public void handleDiscontinuity() {
        this.sink.handleDiscontinuity();
    }

    public boolean hasPendingData() {
        return this.sink.hasPendingData();
    }

    public boolean isEnded() {
        return this.sink.isEnded();
    }

    public void pause() {
        this.sink.pause();
    }

    public void play() {
        this.sink.play();
    }

    public void playToEndOfStream() throws AudioSink.WriteException {
        this.sink.playToEndOfStream();
    }

    public void reset() {
        this.sink.reset();
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        this.sink.setAudioAttributes(audioAttributes);
    }

    public void setAudioSessionId(int i11) {
        this.sink.setAudioSessionId(i11);
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        this.sink.setAuxEffectInfo(auxEffectInfo);
    }

    public void setListener(AudioSink.Listener listener) {
        this.sink.setListener(listener);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.sink.setPlaybackParameters(playbackParameters);
    }

    public void setSkipSilenceEnabled(boolean z11) {
        this.sink.setSkipSilenceEnabled(z11);
    }

    public void setVolume(float f11) {
        this.sink.setVolume(f11);
    }

    public boolean supportsFormat(Format format) {
        return this.sink.supportsFormat(format);
    }
}
