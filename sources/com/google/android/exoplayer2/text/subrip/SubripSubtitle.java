package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    public List<Cue> getCues(long j11) {
        int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j11, true, false);
        if (binarySearchFloor != -1) {
            Cue[] cueArr = this.cues;
            if (cueArr[binarySearchFloor] != Cue.EMPTY) {
                return Collections.singletonList(cueArr[binarySearchFloor]);
            }
        }
        return Collections.emptyList();
    }

    public long getEventTime(int i11) {
        boolean z11 = true;
        Assertions.checkArgument(i11 >= 0);
        if (i11 >= this.cueTimesUs.length) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        return this.cueTimesUs[i11];
    }

    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    public int getNextEventTimeIndex(long j11) {
        int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j11, false, false);
        if (binarySearchCeil < this.cueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
