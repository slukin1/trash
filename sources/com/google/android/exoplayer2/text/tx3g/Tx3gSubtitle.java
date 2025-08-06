package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle EMPTY = new Tx3gSubtitle();
    private final List<Cue> cues;

    public Tx3gSubtitle(Cue cue) {
        this.cues = Collections.singletonList(cue);
    }

    public List<Cue> getCues(long j11) {
        return j11 >= 0 ? this.cues : Collections.emptyList();
    }

    public long getEventTime(int i11) {
        Assertions.checkArgument(i11 == 0);
        return 0;
    }

    public int getEventTimeCount() {
        return 1;
    }

    public int getNextEventTimeIndex(long j11) {
        return j11 < 0 ? 0 : -1;
    }

    private Tx3gSubtitle() {
        this.cues = Collections.emptyList();
    }
}
