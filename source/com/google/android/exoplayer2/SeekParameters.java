package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final SeekParameters DEFAULT;
    public static final SeekParameters EXACT;
    public static final SeekParameters NEXT_SYNC = new SeekParameters(0, Long.MAX_VALUE);
    public static final SeekParameters PREVIOUS_SYNC = new SeekParameters(Long.MAX_VALUE, 0);
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters = new SeekParameters(0, 0);
        EXACT = seekParameters;
        DEFAULT = seekParameters;
    }

    public SeekParameters(long j11, long j12) {
        boolean z11 = true;
        Assertions.checkArgument(j11 >= 0);
        Assertions.checkArgument(j12 < 0 ? false : z11);
        this.toleranceBeforeUs = j11;
        this.toleranceAfterUs = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        if (this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }

    public long resolveSeekPositionUs(long j11, long j12, long j13) {
        long j14 = this.toleranceBeforeUs;
        if (j14 == 0 && this.toleranceAfterUs == 0) {
            return j11;
        }
        long subtractWithOverflowDefault = Util.subtractWithOverflowDefault(j11, j14, Long.MIN_VALUE);
        long addWithOverflowDefault = Util.addWithOverflowDefault(j11, this.toleranceAfterUs, Long.MAX_VALUE);
        boolean z11 = true;
        boolean z12 = subtractWithOverflowDefault <= j12 && j12 <= addWithOverflowDefault;
        if (subtractWithOverflowDefault > j13 || j13 > addWithOverflowDefault) {
            z11 = false;
        }
        if (z12 && z11) {
            return Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13;
        }
        if (z12) {
            return j12;
        }
        return z11 ? j13 : subtractWithOverflowDefault;
    }
}
