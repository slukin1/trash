package com.google.android.exoplayer2.text;

import java.util.List;

public interface Subtitle {
    List<Cue> getCues(long j11);

    long getEventTime(int i11);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j11);
}
