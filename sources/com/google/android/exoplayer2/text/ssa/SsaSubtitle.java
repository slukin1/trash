package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle implements Subtitle {
    private final List<Long> cueTimesUs;
    private final List<List<Cue>> cues;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.cues = list;
        this.cueTimesUs = list2;
    }

    public List<Cue> getCues(long j11) {
        int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, Long.valueOf(j11), true, false);
        if (binarySearchFloor == -1) {
            return Collections.emptyList();
        }
        return this.cues.get(binarySearchFloor);
    }

    public long getEventTime(int i11) {
        boolean z11 = true;
        Assertions.checkArgument(i11 >= 0);
        if (i11 >= this.cueTimesUs.size()) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        return this.cueTimesUs.get(i11).longValue();
    }

    public int getEventTimeCount() {
        return this.cueTimesUs.size();
    }

    public int getNextEventTimeIndex(long j11) {
        int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, Long.valueOf(j11), false, false);
        if (binarySearchCeil < this.cueTimesUs.size()) {
            return binarySearchCeil;
        }
        return -1;
    }
}
