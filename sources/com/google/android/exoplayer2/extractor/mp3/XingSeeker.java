package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class XingSeeker implements Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long j11, int i11, long j12) {
        this(j11, i11, j12, -1, (long[]) null);
    }

    public static XingSeeker create(long j11, long j12, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt;
        long j13 = j11;
        MpegAudioUtil.Header header2 = header;
        int i11 = header2.samplesPerFrame;
        int i12 = header2.sampleRate;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp((long) readUnsignedIntToInt, ((long) i11) * 1000000, (long) i12);
        if ((readInt & 6) != 6) {
            return new XingSeeker(j12, header2.frameSize, scaleLargeTimestamp);
        }
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = (long) parsableByteArray.readUnsignedByte();
        }
        if (j13 != -1) {
            long j14 = j12 + readUnsignedInt;
            if (j13 != j14) {
                StringBuilder sb2 = new StringBuilder(67);
                sb2.append("XING data size mismatch: ");
                sb2.append(j13);
                sb2.append(", ");
                sb2.append(j14);
                Log.w(TAG, sb2.toString());
            }
        }
        return new XingSeeker(j12, header2.frameSize, scaleLargeTimestamp, readUnsignedInt, jArr);
    }

    private long getTimeUsForTableIndex(int i11) {
        return (this.durationUs * ((long) i11)) / 100;
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        double d11;
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.dataStartPosition + ((long) this.xingFrameSize)));
        }
        long constrainValue = Util.constrainValue(j11, 0, this.durationUs);
        double d12 = (((double) constrainValue) * 100.0d) / ((double) this.durationUs);
        double d13 = 0.0d;
        if (d12 > 0.0d) {
            if (d12 >= 100.0d) {
                d13 = 256.0d;
            } else {
                int i11 = (int) d12;
                long[] jArr = (long[]) Assertions.checkStateNotNull(this.tableOfContents);
                double d14 = (double) jArr[i11];
                if (i11 == 99) {
                    d11 = 256.0d;
                } else {
                    d11 = (double) jArr[i11 + 1];
                }
                d13 = d14 + ((d12 - ((double) i11)) * (d11 - d14));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d13 / 256.0d) * ((double) this.dataSize)), (long) this.xingFrameSize, this.dataSize - 1)));
    }

    public long getTimeUs(long j11) {
        long j12;
        long j13 = j11 - this.dataStartPosition;
        if (!isSeekable() || j13 <= ((long) this.xingFrameSize)) {
            return 0;
        }
        long[] jArr = (long[]) Assertions.checkStateNotNull(this.tableOfContents);
        double d11 = (((double) j13) * 256.0d) / ((double) this.dataSize);
        int binarySearchFloor = Util.binarySearchFloor(jArr, (long) d11, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(binarySearchFloor);
        long j14 = jArr[binarySearchFloor];
        int i11 = binarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i11);
        if (binarySearchFloor == 99) {
            j12 = 256;
        } else {
            j12 = jArr[i11];
        }
        return timeUsForTableIndex + Math.round((j14 == j12 ? 0.0d : (d11 - ((double) j14)) / ((double) (j12 - j14))) * ((double) (timeUsForTableIndex2 - timeUsForTableIndex)));
    }

    public boolean isSeekable() {
        return this.tableOfContents != null;
    }

    private XingSeeker(long j11, int i11, long j12, long j13, long[] jArr) {
        this.dataStartPosition = j11;
        this.xingFrameSize = i11;
        this.durationUs = j12;
        this.tableOfContents = jArr;
        this.dataSize = j13;
        this.dataEndPosition = j13 != -1 ? j11 + j13 : -1;
    }
}
