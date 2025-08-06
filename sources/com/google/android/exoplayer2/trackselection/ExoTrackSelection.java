package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

public interface ExoTrackSelection extends TrackSelection {

    public static final class Definition {
        public final TrackGroup group;
        public final int[] tracks;
        public final int type;

        public Definition(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public Definition(TrackGroup trackGroup, int[] iArr, int i11) {
            this.group = trackGroup;
            this.tracks = iArr;
            this.type = i11;
        }
    }

    public interface Factory {
        ExoTrackSelection[] createTrackSelections(Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);
    }

    boolean blacklist(int i11, long j11);

    void disable();

    void enable();

    int evaluateQueueSize(long j11, List<? extends MediaChunk> list);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    boolean isBlacklisted(int i11, long j11);

    void onDiscontinuity();

    void onPlayWhenReadyChanged(boolean z11);

    void onPlaybackSpeed(float f11);

    void onRebuffer();

    boolean shouldCancelChunkLoad(long j11, Chunk chunk, List<? extends MediaChunk> list);

    void updateSelectedTrack(long j11, long j12, long j13, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr);
}
