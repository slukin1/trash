package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;

public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;

    /* renamed from: id  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f65979id;
    private PrepareListener listener;
    private MediaPeriod mediaPeriod;
    private MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = -9223372036854775807L;
    private final long preparePositionUs;

    public interface PrepareListener {
        void onPrepareComplete(MediaSource.MediaPeriodId mediaPeriodId);

        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator2, long j11) {
        this.f65979id = mediaPeriodId;
        this.allocator = allocator2;
        this.preparePositionUs = j11;
    }

    private long getPreparePositionWithOverride(long j11) {
        long j12 = this.preparePositionOverrideUs;
        return j12 != -9223372036854775807L ? j12 : j11;
    }

    public boolean continueLoading(long j11) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        return mediaPeriod2 != null && mediaPeriod2.continueLoading(j11);
    }

    public void createPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        long preparePositionWithOverride = getPreparePositionWithOverride(this.preparePositionUs);
        MediaPeriod createPeriod = ((MediaSource) Assertions.checkNotNull(this.mediaSource)).createPeriod(mediaPeriodId, this.allocator, preparePositionWithOverride);
        this.mediaPeriod = createPeriod;
        if (this.callback != null) {
            createPeriod.prepare(this, preparePositionWithOverride);
        }
    }

    public void discardBuffer(long j11, boolean z11) {
        ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).discardBuffer(j11, z11);
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getAdjustedSeekPositionUs(j11, seekParameters);
    }

    public long getBufferedPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getNextLoadPositionUs();
    }

    public long getPreparePositionOverrideUs() {
        return this.preparePositionOverrideUs;
    }

    public long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    public /* synthetic */ List getStreamKeys(List list) {
        return d.a(this, list);
    }

    public TrackGroupArray getTrackGroups() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getTrackGroups();
    }

    public boolean isLoading() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        return mediaPeriod2 != null && mediaPeriod2.isLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        try {
            MediaPeriod mediaPeriod2 = this.mediaPeriod;
            if (mediaPeriod2 != null) {
                mediaPeriod2.maybeThrowPrepareError();
                return;
            }
            MediaSource mediaSource2 = this.mediaSource;
            if (mediaSource2 != null) {
                mediaSource2.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e11) {
            PrepareListener prepareListener = this.listener;
            if (prepareListener == null) {
                throw e11;
            } else if (!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                prepareListener.onPrepareError(this.f65979id, e11);
            }
        }
    }

    public void onPrepared(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Util.castNonNull(this.callback)).onPrepared(this);
        PrepareListener prepareListener = this.listener;
        if (prepareListener != null) {
            prepareListener.onPrepareComplete(this.f65979id);
        }
    }

    public void overridePreparePositionUs(long j11) {
        this.preparePositionOverrideUs = j11;
    }

    public void prepare(MediaPeriod.Callback callback2, long j11) {
        this.callback = callback2;
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            mediaPeriod2.prepare(this, getPreparePositionWithOverride(this.preparePositionUs));
        }
    }

    public long readDiscontinuity() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).readDiscontinuity();
    }

    public void reevaluateBuffer(long j11) {
        ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).reevaluateBuffer(j11);
    }

    public void releasePeriod() {
        if (this.mediaPeriod != null) {
            ((MediaSource) Assertions.checkNotNull(this.mediaSource)).releasePeriod(this.mediaPeriod);
        }
    }

    public long seekToUs(long j11) {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).seekToUs(j11);
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        long j12;
        long j13 = this.preparePositionOverrideUs;
        if (j13 == -9223372036854775807L || j11 != this.preparePositionUs) {
            j12 = j11;
        } else {
            this.preparePositionOverrideUs = -9223372036854775807L;
            j12 = j13;
        }
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j12);
    }

    public void setMediaSource(MediaSource mediaSource2) {
        Assertions.checkState(this.mediaSource == null);
        this.mediaSource = mediaSource2;
    }

    public void setPrepareListener(PrepareListener prepareListener) {
        this.listener = prepareListener;
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Util.castNonNull(this.callback)).onContinueLoadingRequested(this);
    }
}
