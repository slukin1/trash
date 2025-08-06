package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public abstract class BinarySearchSeeker {
    private static final long MAX_SKIP_BYTES = 262144;
    private final int minimumSearchRange;
    public final BinarySearchSeekMap seekMap;
    public SeekOperationParams seekOperationParams;
    public final TimestampSeeker timestampSeeker;

    public static class BinarySearchSeekMap implements SeekMap {
        /* access modifiers changed from: private */
        public final long approxBytesPerFrame;
        /* access modifiers changed from: private */
        public final long ceilingBytePosition;
        /* access modifiers changed from: private */
        public final long ceilingTimePosition;
        private final long durationUs;
        /* access modifiers changed from: private */
        public final long floorBytePosition;
        /* access modifiers changed from: private */
        public final long floorTimePosition;
        private final SeekTimestampConverter seekTimestampConverter;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter2, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.seekTimestampConverter = seekTimestampConverter2;
            this.durationUs = j11;
            this.floorTimePosition = j12;
            this.ceilingTimePosition = j13;
            this.floorBytePosition = j14;
            this.ceilingBytePosition = j15;
            this.approxBytesPerFrame = j16;
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public SeekMap.SeekPoints getSeekPoints(long j11) {
            return new SeekMap.SeekPoints(new SeekPoint(j11, SeekOperationParams.calculateNextSearchBytePosition(this.seekTimestampConverter.timeUsToTargetTime(j11), this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame)));
        }

        public boolean isSeekable() {
            return true;
        }

        public long timeUsToTargetTime(long j11) {
            return this.seekTimestampConverter.timeUsToTargetTime(j11);
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        public long timeUsToTargetTime(long j11) {
            return j11;
        }
    }

    public static class SeekOperationParams {
        private final long approxBytesPerFrame;
        private long ceilingBytePosition;
        private long ceilingTimePosition;
        private long floorBytePosition;
        private long floorTimePosition;
        private long nextSearchBytePosition;
        private final long seekTimeUs;
        private final long targetTimePosition;

        public SeekOperationParams(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
            this.seekTimeUs = j11;
            this.targetTimePosition = j12;
            this.floorTimePosition = j13;
            this.ceilingTimePosition = j14;
            this.floorBytePosition = j15;
            this.ceilingBytePosition = j16;
            this.approxBytesPerFrame = j17;
            this.nextSearchBytePosition = calculateNextSearchBytePosition(j12, j13, j14, j15, j16, j17);
        }

        public static long calculateNextSearchBytePosition(long j11, long j12, long j13, long j14, long j15, long j16) {
            if (j14 + 1 >= j15 || j12 + 1 >= j13) {
                return j14;
            }
            long j17 = (long) (((float) (j11 - j12)) * (((float) (j15 - j14)) / ((float) (j13 - j12))));
            return Util.constrainValue(((j17 + j14) - j16) - (j17 / 20), j14, j15 - 1);
        }

        /* access modifiers changed from: private */
        public long getCeilingBytePosition() {
            return this.ceilingBytePosition;
        }

        /* access modifiers changed from: private */
        public long getFloorBytePosition() {
            return this.floorBytePosition;
        }

        /* access modifiers changed from: private */
        public long getNextSearchBytePosition() {
            return this.nextSearchBytePosition;
        }

        /* access modifiers changed from: private */
        public long getSeekTimeUs() {
            return this.seekTimeUs;
        }

        /* access modifiers changed from: private */
        public long getTargetTimePosition() {
            return this.targetTimePosition;
        }

        private void updateNextSearchBytePosition() {
            this.nextSearchBytePosition = calculateNextSearchBytePosition(this.targetTimePosition, this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame);
        }

        /* access modifiers changed from: private */
        public void updateSeekCeiling(long j11, long j12) {
            this.ceilingTimePosition = j11;
            this.ceilingBytePosition = j12;
            updateNextSearchBytePosition();
        }

        /* access modifiers changed from: private */
        public void updateSeekFloor(long j11, long j12) {
            this.floorTimePosition = j11;
            this.floorBytePosition = j12;
            updateNextSearchBytePosition();
        }
    }

    public interface SeekTimestampConverter {
        long timeUsToTargetTime(long j11);
    }

    public static final class TimestampSearchResult {
        public static final TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new TimestampSearchResult(-3, -9223372036854775807L, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;
        /* access modifiers changed from: private */
        public final long bytePositionToUpdate;
        /* access modifiers changed from: private */
        public final long timestampToUpdate;
        /* access modifiers changed from: private */
        public final int type;

        private TimestampSearchResult(int i11, long j11, long j12) {
            this.type = i11;
            this.timestampToUpdate = j11;
            this.bytePositionToUpdate = j12;
        }

        public static TimestampSearchResult overestimatedResult(long j11, long j12) {
            return new TimestampSearchResult(-1, j11, j12);
        }

        public static TimestampSearchResult targetFoundResult(long j11) {
            return new TimestampSearchResult(0, -9223372036854775807L, j11);
        }

        public static TimestampSearchResult underestimatedResult(long j11, long j12) {
            return new TimestampSearchResult(-2, j11, j12);
        }
    }

    public interface TimestampSeeker {
        void onSeekFinished();

        TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j11) throws IOException;
    }

    public BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker2, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.timestampSeeker = timestampSeeker2;
        this.minimumSearchRange = i11;
        this.seekMap = new BinarySearchSeekMap(seekTimestampConverter, j11, j12, j13, j14, j15, j16);
    }

    public SeekOperationParams createSeekParamsForTargetTimeUs(long j11) {
        long j12 = j11;
        return new SeekOperationParams(j12, this.seekMap.timeUsToTargetTime(j12), this.seekMap.floorTimePosition, this.seekMap.ceilingTimePosition, this.seekMap.floorBytePosition, this.seekMap.ceilingBytePosition, this.seekMap.approxBytesPerFrame);
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public int handlePendingSeek(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            SeekOperationParams seekOperationParams2 = (SeekOperationParams) Assertions.checkStateNotNull(this.seekOperationParams);
            long access$100 = seekOperationParams2.getFloorBytePosition();
            long access$200 = seekOperationParams2.getCeilingBytePosition();
            long access$300 = seekOperationParams2.getNextSearchBytePosition();
            if (access$200 - access$100 <= ((long) this.minimumSearchRange)) {
                markSeekOperationFinished(false, access$100);
                return seekToPosition(extractorInput, access$100, positionHolder);
            } else if (!skipInputUntilPosition(extractorInput, access$300)) {
                return seekToPosition(extractorInput, access$300, positionHolder);
            } else {
                extractorInput.resetPeekPosition();
                TimestampSearchResult searchForTimestamp = this.timestampSeeker.searchForTimestamp(extractorInput, seekOperationParams2.getTargetTimePosition());
                int access$500 = searchForTimestamp.type;
                if (access$500 == -3) {
                    markSeekOperationFinished(false, access$300);
                    return seekToPosition(extractorInput, access$300, positionHolder);
                } else if (access$500 == -2) {
                    seekOperationParams2.updateSeekFloor(searchForTimestamp.timestampToUpdate, searchForTimestamp.bytePositionToUpdate);
                } else if (access$500 == -1) {
                    seekOperationParams2.updateSeekCeiling(searchForTimestamp.timestampToUpdate, searchForTimestamp.bytePositionToUpdate);
                } else if (access$500 == 0) {
                    skipInputUntilPosition(extractorInput, searchForTimestamp.bytePositionToUpdate);
                    markSeekOperationFinished(true, searchForTimestamp.bytePositionToUpdate);
                    return seekToPosition(extractorInput, searchForTimestamp.bytePositionToUpdate, positionHolder);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean isSeeking() {
        return this.seekOperationParams != null;
    }

    public final void markSeekOperationFinished(boolean z11, long j11) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        onSeekOperationFinished(z11, j11);
    }

    public void onSeekOperationFinished(boolean z11, long j11) {
    }

    public final int seekToPosition(ExtractorInput extractorInput, long j11, PositionHolder positionHolder) {
        if (j11 == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = j11;
        return 1;
    }

    public final void setSeekTargetUs(long j11) {
        SeekOperationParams seekOperationParams2 = this.seekOperationParams;
        if (seekOperationParams2 == null || seekOperationParams2.getSeekTimeUs() != j11) {
            this.seekOperationParams = createSeekParamsForTargetTimeUs(j11);
        }
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput, long j11) throws IOException {
        long position = j11 - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }
}
