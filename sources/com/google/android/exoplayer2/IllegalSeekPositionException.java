package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline2, int i11, long j11) {
        this.timeline = timeline2;
        this.windowIndex = i11;
        this.positionMs = j11;
    }
}
