package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j11, long j12) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j11;
        this.dataEndPosition = j12;
    }

    public static VbriSeeker create(long j11, long j12, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i11;
        long j13 = j11;
        MpegAudioUtil.Header header2 = header;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i12 = header2.sampleRate;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp((long) readInt, 1000000 * ((long) (i12 >= 32000 ? 1152 : 576)), (long) i12);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j14 = j12 + ((long) header2.frameSize);
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i13 = 0;
        long j15 = j12;
        while (i13 < readUnsignedShort) {
            int i14 = readUnsignedShort2;
            jArr[i13] = (((long) i13) * scaleLargeTimestamp) / ((long) readUnsignedShort);
            long j16 = j14;
            jArr2[i13] = Math.max(j15, j16);
            if (readUnsignedShort3 == 1) {
                i11 = parsableByteArray.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                i11 = parsableByteArray.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                i11 = parsableByteArray.readUnsignedInt24();
            } else if (readUnsignedShort3 != 4) {
                return null;
            } else {
                i11 = parsableByteArray.readUnsignedIntToInt();
            }
            j15 += (long) (i11 * i14);
            i13++;
            j14 = j16;
            readUnsignedShort2 = i14;
        }
        if (!(j13 == -1 || j13 == j15)) {
            StringBuilder sb2 = new StringBuilder(67);
            sb2.append("VBRI data size mismatch: ");
            sb2.append(j13);
            sb2.append(", ");
            sb2.append(j15);
            Log.w(TAG, sb2.toString());
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp, j15);
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j11, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs >= j11 || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i11 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i11], this.positions[i11]));
    }

    public long getTimeUs(long j11) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j11, true, true)];
    }

    public boolean isSeekable() {
        return true;
    }
}
