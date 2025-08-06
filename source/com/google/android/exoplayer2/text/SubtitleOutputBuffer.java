package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    public List<Cue> getCues(long j11) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getCues(j11 - this.subsampleOffsetUs);
    }

    public long getEventTime(int i11) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getEventTime(i11) + this.subsampleOffsetUs;
    }

    public int getEventTimeCount() {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getEventTimeCount();
    }

    public int getNextEventTimeIndex(long j11) {
        return ((Subtitle) Assertions.checkNotNull(this.subtitle)).getNextEventTimeIndex(j11 - this.subsampleOffsetUs);
    }

    public void setContent(long j11, Subtitle subtitle2, long j12) {
        this.timeUs = j11;
        this.subtitle = subtitle2;
        if (j12 != Long.MAX_VALUE) {
            j11 = j12;
        }
        this.subsampleOffsetUs = j11;
    }
}
