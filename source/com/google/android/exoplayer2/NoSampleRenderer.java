package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;

    public final void disable() {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j11, boolean z11, boolean z12, long j12, long j13) throws ExoPlaybackException {
        boolean z13 = z11;
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z11);
        replaceStream(formatArr, sampleStream, j12, j13);
        long j14 = j11;
        onPositionReset(j11, z11);
    }

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    public final int getIndex() {
        return this.index;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    public final int getState() {
        return this.state;
    }

    public final SampleStream getStream() {
        return this.stream;
    }

    public final int getTrackType() {
        return 7;
    }

    public void handleMessage(int i11, Object obj) throws ExoPlaybackException {
    }

    public final boolean hasReadStreamToEnd() {
        return true;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public boolean isEnded() {
        return true;
    }

    public boolean isReady() {
        return true;
    }

    public final void maybeThrowStreamError() throws IOException {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z11) throws ExoPlaybackException {
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
    }

    public void onRendererOffsetChanged(long j11) throws ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j11, long j12) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        onRendererOffsetChanged(j12);
    }

    public final void reset() {
        Assertions.checkState(this.state == 0);
        onReset();
    }

    public final void resetPosition(long j11) throws ExoPlaybackException {
        this.streamIsFinal = false;
        onPositionReset(j11, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }

    public /* synthetic */ void setPlaybackSpeed(float f11, float f12) {
        r0.a(this, f11, f12);
    }

    public final void start() throws ExoPlaybackException {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.state = 2;
        onStarted();
    }

    public final void stop() {
        Assertions.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public int supportsFormat(Format format) throws ExoPlaybackException {
        return s0.a(0);
    }

    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }
}
