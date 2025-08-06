package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Mp4WebvttSubtitle implements Subtitle {
    private final List<Cue> cues;

    public Mp4WebvttSubtitle(List<Cue> list) {
        this.cues = Collections.unmodifiableList(list);
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
}
