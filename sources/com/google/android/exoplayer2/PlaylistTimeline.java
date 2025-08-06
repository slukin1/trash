package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class PlaylistTimeline extends AbstractConcatenatedTimeline {
    private final HashMap<Object, Integer> childIndexByUid = new HashMap<>();
    private final int[] firstPeriodInChildIndices;
    private final int[] firstWindowInChildIndices;
    private final int periodCount;
    private final Timeline[] timelines;
    private final Object[] uids;
    private final int windowCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaylistTimeline(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i11 = 0;
        int size = collection.size();
        this.firstPeriodInChildIndices = new int[size];
        this.firstWindowInChildIndices = new int[size];
        this.timelines = new Timeline[size];
        this.uids = new Object[size];
        int i12 = 0;
        int i13 = 0;
        for (MediaSourceInfoHolder mediaSourceInfoHolder : collection) {
            this.timelines[i13] = mediaSourceInfoHolder.getTimeline();
            this.firstWindowInChildIndices[i13] = i11;
            this.firstPeriodInChildIndices[i13] = i12;
            i11 += this.timelines[i13].getWindowCount();
            i12 += this.timelines[i13].getPeriodCount();
            this.uids[i13] = mediaSourceInfoHolder.getUid();
            this.childIndexByUid.put(this.uids[i13], Integer.valueOf(i13));
            i13++;
        }
        this.windowCount = i11;
        this.periodCount = i12;
    }

    public int getChildIndexByChildUid(Object obj) {
        Integer num = this.childIndexByUid.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public int getChildIndexByPeriodIndex(int i11) {
        return Util.binarySearchFloor(this.firstPeriodInChildIndices, i11 + 1, false, false);
    }

    public int getChildIndexByWindowIndex(int i11) {
        return Util.binarySearchFloor(this.firstWindowInChildIndices, i11 + 1, false, false);
    }

    public List<Timeline> getChildTimelines() {
        return Arrays.asList(this.timelines);
    }

    public Object getChildUidByChildIndex(int i11) {
        return this.uids[i11];
    }

    public int getFirstPeriodIndexByChildIndex(int i11) {
        return this.firstPeriodInChildIndices[i11];
    }

    public int getFirstWindowIndexByChildIndex(int i11) {
        return this.firstWindowInChildIndices[i11];
    }

    public int getPeriodCount() {
        return this.periodCount;
    }

    public Timeline getTimelineByChildIndex(int i11) {
        return this.timelines[i11];
    }

    public int getWindowCount() {
        return this.windowCount;
    }
}
