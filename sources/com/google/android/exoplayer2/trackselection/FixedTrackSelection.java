package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

public final class FixedTrackSelection extends BaseTrackSelection {
    private final Object data;
    private final int reason;

    public FixedTrackSelection(TrackGroup trackGroup, int i11) {
        this(trackGroup, i11, 0);
    }

    public int getSelectedIndex() {
        return 0;
    }

    public Object getSelectionData() {
        return this.data;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public void updateSelectedTrack(long j11, long j12, long j13, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i11, int i12) {
        this(trackGroup, i11, i12, 0, (Object) null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i11, int i12, int i13, Object obj) {
        super(trackGroup, new int[]{i11}, i12);
        this.reason = i13;
        this.data = obj;
    }
}
