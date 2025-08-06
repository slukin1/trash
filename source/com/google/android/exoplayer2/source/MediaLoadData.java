package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;

public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int i11) {
        this(i11, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
    }

    public MediaLoadData(int i11, int i12, Format format, int i13, Object obj, long j11, long j12) {
        this.dataType = i11;
        this.trackType = i12;
        this.trackFormat = format;
        this.trackSelectionReason = i13;
        this.trackSelectionData = obj;
        this.mediaStartTimeMs = j11;
        this.mediaEndTimeMs = j12;
    }
}
