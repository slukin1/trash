package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;

final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        private Results(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i11;
            this.timestamps = jArr2;
            this.flags = iArr2;
            this.duration = j11;
        }
    }

    private FixedSampleSizeRechunker() {
    }

    public static Results rechunk(int i11, long[] jArr, int[] iArr, long j11) {
        int[] iArr2 = iArr;
        int i12 = 8192 / i11;
        int i13 = 0;
        for (int ceilDivide : iArr2) {
            i13 += Util.ceilDivide(ceilDivide, i12);
        }
        long[] jArr2 = new long[i13];
        int[] iArr3 = new int[i13];
        long[] jArr3 = new long[i13];
        int[] iArr4 = new int[i13];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < iArr2.length; i17++) {
            int i18 = iArr2[i17];
            long j12 = jArr[i17];
            while (i18 > 0) {
                int min = Math.min(i12, i18);
                jArr2[i15] = j12;
                iArr3[i15] = i11 * min;
                i16 = Math.max(i16, iArr3[i15]);
                jArr3[i15] = ((long) i14) * j11;
                iArr4[i15] = 1;
                j12 += (long) iArr3[i15];
                i14 += min;
                i18 -= min;
                i15++;
            }
        }
        return new Results(jArr2, iArr3, i16, jArr3, iArr4, j11 * ((long) i14));
    }
}
