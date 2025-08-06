package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private final FormatHolder formatHolder = new FormatHolder();
    private int index;
    private long lastResetPositionUs;
    private long readingPositionUs = Long.MIN_VALUE;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;

    public BaseRenderer(int i11) {
        this.trackType = i11;
    }

    public final ExoPlaybackException createRendererException(Throwable th2, Format format) {
        return createRendererException(th2, format, false);
    }

    public final void disable() {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        Assertions.checkState(z11);
        this.formatHolder.clear();
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j11, boolean z11, boolean z12, long j12, long j13) throws ExoPlaybackException {
        long j14 = j11;
        boolean z13 = z11;
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration;
        this.state = 1;
        this.lastResetPositionUs = j14;
        onEnabled(z13, z12);
        replaceStream(formatArr, sampleStream, j12, j13);
        onPositionReset(j14, z13);
    }

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public final RendererConfiguration getConfiguration() {
        return (RendererConfiguration) Assertions.checkNotNull(this.configuration);
    }

    public final FormatHolder getFormatHolder() {
        this.formatHolder.clear();
        return this.formatHolder;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getLastResetPositionUs() {
        return this.lastResetPositionUs;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    public final int getState() {
        return this.state;
    }

    public final SampleStream getStream() {
        return this.stream;
    }

    public final Format[] getStreamFormats() {
        return (Format[]) Assertions.checkNotNull(this.streamFormats);
    }

    public final int getTrackType() {
        return this.trackType;
    }

    public void handleMessage(int i11, Object obj) throws ExoPlaybackException {
    }

    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == Long.MIN_VALUE;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.streamIsFinal : ((SampleStream) Assertions.checkNotNull(this.stream)).isReady();
    }

    public final void maybeThrowStreamError() throws IOException {
        ((SampleStream) Assertions.checkNotNull(this.stream)).maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z11, boolean z12) throws ExoPlaybackException {
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) throws ExoPlaybackException {
    }

    public final int readSource(FormatHolder formatHolder2, DecoderInputBuffer decoderInputBuffer, int i11) {
        int readData = ((SampleStream) Assertions.checkNotNull(this.stream)).readData(formatHolder2, decoderInputBuffer, i11);
        if (readData == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.readingPositionUs = Long.MIN_VALUE;
                if (this.streamIsFinal) {
                    return -4;
                }
                return -3;
            }
            long j11 = decoderInputBuffer.timeUs + this.streamOffsetUs;
            decoderInputBuffer.timeUs = j11;
            this.readingPositionUs = Math.max(this.readingPositionUs, j11);
        } else if (readData == -5) {
            Format format = (Format) Assertions.checkNotNull(formatHolder2.format);
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder2.format = format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.streamOffsetUs).build();
            }
        }
        return readData;
    }

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j11, long j12) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        this.readingPositionUs = j12;
        this.streamFormats = formatArr;
        this.streamOffsetUs = j12;
        onStreamChanged(formatArr, j11, j12);
    }

    public final void reset() {
        Assertions.checkState(this.state == 0);
        this.formatHolder.clear();
        onReset();
    }

    public final void resetPosition(long j11) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.lastResetPositionUs = j11;
        this.readingPositionUs = j11;
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

    public int skipSource(long j11) {
        return ((SampleStream) Assertions.checkNotNull(this.stream)).skipData(j11 - this.streamOffsetUs);
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

    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public final ExoPlaybackException createRendererException(Throwable th2, Format format, boolean z11) {
        int i11;
        if (format != null && !this.throwRendererExceptionIsExecuting) {
            this.throwRendererExceptionIsExecuting = true;
            try {
                i11 = s0.d(supportsFormat(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.throwRendererExceptionIsExecuting = false;
            }
            return ExoPlaybackException.createForRenderer(th2, getName(), getIndex(), format, i11, z11);
        }
        i11 = 4;
        return ExoPlaybackException.createForRenderer(th2, getName(), getIndex(), format, i11, z11);
    }
}
