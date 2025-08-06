package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean allRenderersInCorrectState;
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    private final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSourceList mediaSourceList;
    private MediaPeriodHolder next;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private TrackGroupArray trackGroups = TrackGroupArray.EMPTY;
    private final TrackSelector trackSelector;
    private TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j11, TrackSelector trackSelector2, Allocator allocator, MediaSourceList mediaSourceList2, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult2) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = j11;
        this.trackSelector = trackSelector2;
        this.mediaSourceList = mediaSourceList2;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f65678id;
        this.uid = mediaPeriodId.periodUid;
        this.info = mediaPeriodInfo;
        this.trackSelectorResult = trackSelectorResult2;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        this.mediaPeriod = createMediaPeriod(mediaPeriodId, mediaSourceList2, allocator, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.endPositionUs);
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i11 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i11 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i11].getTrackType() == 7 && this.trackSelectorResult.isRendererEnabled(i11)) {
                    sampleStreamArr[i11] = new EmptySampleStream();
                }
                i11++;
            } else {
                return;
            }
        }
    }

    private static MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, MediaSourceList mediaSourceList2, Allocator allocator, long j11, long j12) {
        MediaPeriod createPeriod = mediaSourceList2.createPeriod(mediaPeriodId, allocator, j11);
        return (j12 == -9223372036854775807L || j12 == Long.MIN_VALUE) ? createPeriod : new ClippingMediaPeriod(createPeriod, true, 0, j12);
    }

    private void disableTrackSelectionsInResult() {
        if (isLoadingMediaPeriod()) {
            int i11 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
                if (i11 < trackSelectorResult2.length) {
                    boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i11);
                    ExoTrackSelection exoTrackSelection = this.trackSelectorResult.selections[i11];
                    if (isRendererEnabled && exoTrackSelection != null) {
                        exoTrackSelection.disable();
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i11 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i11 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i11].getTrackType() == 7) {
                    sampleStreamArr[i11] = null;
                }
                i11++;
            } else {
                return;
            }
        }
    }

    private void enableTrackSelectionsInResult() {
        if (isLoadingMediaPeriod()) {
            int i11 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult2 = this.trackSelectorResult;
                if (i11 < trackSelectorResult2.length) {
                    boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i11);
                    ExoTrackSelection exoTrackSelection = this.trackSelectorResult.selections[i11];
                    if (isRendererEnabled && exoTrackSelection != null) {
                        exoTrackSelection.enable();
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean isLoadingMediaPeriod() {
        return this.next == null;
    }

    private static void releaseMediaPeriod(long j11, MediaSourceList mediaSourceList2, MediaPeriod mediaPeriod2) {
        if (j11 == -9223372036854775807L || j11 == Long.MIN_VALUE) {
            mediaSourceList2.releasePeriod(mediaPeriod2);
            return;
        }
        try {
            mediaSourceList2.releasePeriod(((ClippingMediaPeriod) mediaPeriod2).mediaPeriod);
        } catch (RuntimeException e11) {
            Log.e(TAG, "Period release failed.", e11);
        }
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult2, long j11, boolean z11) {
        return applyTrackSelection(trackSelectorResult2, j11, z11, new boolean[this.rendererCapabilities.length]);
    }

    public void continueLoading(long j11) {
        Assertions.checkState(isLoadingMediaPeriod());
        this.mediaPeriod.continueLoading(toPeriodTime(j11));
    }

    public long getBufferedPositionUs() {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.info.durationUs : bufferedPositionUs;
    }

    public MediaPeriodHolder getNext() {
        return this.next;
    }

    public long getNextLoadPositionUs() {
        if (!this.prepared) {
            return 0;
        }
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public TrackSelectorResult getTrackSelectorResult() {
        return this.trackSelectorResult;
    }

    public void handlePrepared(float f11, Timeline timeline) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        TrackSelectorResult selectTracks = selectTracks(f11, timeline);
        MediaPeriodInfo mediaPeriodInfo = this.info;
        long j11 = mediaPeriodInfo.startPositionUs;
        long j12 = mediaPeriodInfo.durationUs;
        if (j12 != -9223372036854775807L && j11 >= j12) {
            j11 = Math.max(0, j12 - 1);
        }
        long applyTrackSelection = applyTrackSelection(selectTracks, j11, false);
        long j13 = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo2 = this.info;
        this.rendererPositionOffsetUs = j13 + (mediaPeriodInfo2.startPositionUs - applyTrackSelection);
        this.info = mediaPeriodInfo2.copyWithStartPositionUs(applyTrackSelection);
    }

    public boolean isFullyBuffered() {
        return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public void reevaluateBuffer(long j11) {
        Assertions.checkState(isLoadingMediaPeriod());
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j11));
        }
    }

    public void release() {
        disableTrackSelectionsInResult();
        releaseMediaPeriod(this.info.endPositionUs, this.mediaSourceList, this.mediaPeriod);
    }

    public TrackSelectorResult selectTracks(float f11, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, getTrackGroups(), this.info.f65678id, timeline);
        for (ExoTrackSelection exoTrackSelection : selectTracks.selections) {
            if (exoTrackSelection != null) {
                exoTrackSelection.onPlaybackSpeed(f11);
            }
        }
        return selectTracks;
    }

    public void setNext(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != this.next) {
            disableTrackSelectionsInResult();
            this.next = mediaPeriodHolder;
            enableTrackSelectionsInResult();
        }
    }

    public void setRendererOffset(long j11) {
        this.rendererPositionOffsetUs = j11;
    }

    public long toPeriodTime(long j11) {
        return j11 - getRendererOffset();
    }

    public long toRendererTime(long j11) {
        return j11 + getRendererOffset();
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult2, long j11, boolean z11, boolean[] zArr) {
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult2;
        int i11 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= trackSelectorResult3.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z11 || !trackSelectorResult2.isEquivalent(this.trackSelectorResult, i11)) {
                z12 = false;
            }
            zArr2[i11] = z12;
            i11++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        disableTrackSelectionsInResult();
        this.trackSelectorResult = trackSelectorResult3;
        enableTrackSelectionsInResult();
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectorResult3.selections, this.mayRetainStreamFlags, this.sampleStreams, zArr, j11);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i12 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i12 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i12] != null) {
                Assertions.checkState(trackSelectorResult2.isRendererEnabled(i12));
                if (this.rendererCapabilities[i12].getTrackType() != 7) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectorResult3.selections[i12] == null);
            }
            i12++;
        }
    }
}
