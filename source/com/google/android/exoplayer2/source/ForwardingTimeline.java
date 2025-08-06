package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline {
    public final Timeline timeline;

    public ForwardingTimeline(Timeline timeline2) {
        this.timeline = timeline2;
    }

    public int getFirstWindowIndex(boolean z11) {
        return this.timeline.getFirstWindowIndex(z11);
    }

    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    public int getLastWindowIndex(boolean z11) {
        return this.timeline.getLastWindowIndex(z11);
    }

    public int getNextWindowIndex(int i11, int i12, boolean z11) {
        return this.timeline.getNextWindowIndex(i11, i12, z11);
    }

    public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
        return this.timeline.getPeriod(i11, period, z11);
    }

    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
        return this.timeline.getPreviousWindowIndex(i11, i12, z11);
    }

    public Object getUidOfPeriod(int i11) {
        return this.timeline.getUidOfPeriod(i11);
    }

    public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
        return this.timeline.getWindow(i11, window, j11);
    }

    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}
