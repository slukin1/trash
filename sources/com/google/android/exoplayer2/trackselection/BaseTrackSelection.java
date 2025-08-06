package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTrackSelection implements ExoTrackSelection {
    private final long[] excludeUntilTimes;
    private final Format[] formats;
    public final TrackGroup group;
    private int hashCode;
    public final int length;
    public final int[] tracks;
    private final int type;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(Format format, Format format2) {
        return format2.bitrate - format.bitrate;
    }

    public boolean blacklist(int i11, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i11, elapsedRealtime);
        int i12 = 0;
        while (i12 < this.length && !isBlacklisted) {
            isBlacklisted = i12 != i11 && !isBlacklisted(i12, elapsedRealtime);
            i12++;
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.excludeUntilTimes;
        jArr[i11] = Math.max(jArr[i11], Util.addWithOverflowDefault(elapsedRealtime, j11, Long.MAX_VALUE));
        return true;
    }

    public void disable() {
    }

    public void enable() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        if (this.group != baseTrackSelection.group || !Arrays.equals(this.tracks, baseTrackSelection.tracks)) {
            return false;
        }
        return true;
    }

    public int evaluateQueueSize(long j11, List<? extends MediaChunk> list) {
        return list.size();
    }

    public final Format getFormat(int i11) {
        return this.formats[i11];
    }

    public final int getIndexInTrackGroup(int i11) {
        return this.tracks[i11];
    }

    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public final int indexOf(Format format) {
        for (int i11 = 0; i11 < this.length; i11++) {
            if (this.formats[i11] == format) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isBlacklisted(int i11, long j11) {
        return this.excludeUntilTimes[i11] > j11;
    }

    public final int length() {
        return this.tracks.length;
    }

    public /* synthetic */ void onDiscontinuity() {
        d.a(this);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(boolean z11) {
        d.b(this, z11);
    }

    public void onPlaybackSpeed(float f11) {
    }

    public /* synthetic */ void onRebuffer() {
        d.c(this);
    }

    public /* synthetic */ boolean shouldCancelChunkLoad(long j11, Chunk chunk, List list) {
        return d.d(this, j11, chunk, list);
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i11) {
        int i12 = 0;
        Assertions.checkState(iArr.length > 0);
        this.type = i11;
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length2 = iArr.length;
        this.length = length2;
        this.formats = new Format[length2];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            this.formats[i13] = trackGroup.getFormat(iArr[i13]);
        }
        Arrays.sort(this.formats, a.f66067b);
        this.tracks = new int[this.length];
        while (true) {
            int i14 = this.length;
            if (i12 < i14) {
                this.tracks[i12] = trackGroup.indexOf(this.formats[i12]);
                i12++;
            } else {
                this.excludeUntilTimes = new long[i14];
                return;
            }
        }
    }

    public final int indexOf(int i11) {
        for (int i12 = 0; i12 < this.length; i12++) {
            if (this.tracks[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }
}
