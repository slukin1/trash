package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;

public abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z11, ShuffleOrder shuffleOrder2) {
        this.isAtomic = z11;
        this.shuffleOrder = shuffleOrder2;
        this.childCount = shuffleOrder2.getLength();
    }

    public static Object getChildPeriodUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object getChildTimelineUidFromConcatenatedUid(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object getConcatenatedUid(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int getNextChildIndex(int i11, boolean z11) {
        if (z11) {
            return this.shuffleOrder.getNextIndex(i11);
        }
        if (i11 < this.childCount - 1) {
            return i11 + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i11, boolean z11) {
        if (z11) {
            return this.shuffleOrder.getPreviousIndex(i11);
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        return -1;
    }

    public abstract int getChildIndexByChildUid(Object obj);

    public abstract int getChildIndexByPeriodIndex(int i11);

    public abstract int getChildIndexByWindowIndex(int i11);

    public abstract Object getChildUidByChildIndex(int i11);

    public abstract int getFirstPeriodIndexByChildIndex(int i11);

    public int getFirstWindowIndex(boolean z11) {
        if (this.childCount == 0) {
            return -1;
        }
        int i11 = 0;
        if (this.isAtomic) {
            z11 = false;
        }
        if (z11) {
            i11 = this.shuffleOrder.getFirstIndex();
        }
        while (getTimelineByChildIndex(i11).isEmpty()) {
            i11 = getNextChildIndex(i11, z11);
            if (i11 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i11) + getTimelineByChildIndex(i11).getFirstWindowIndex(z11);
    }

    public abstract int getFirstWindowIndexByChildIndex(int i11);

    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(childPeriodUidFromConcatenatedUid)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    public int getLastWindowIndex(boolean z11) {
        int i11 = this.childCount;
        if (i11 == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z11 = false;
        }
        int lastIndex = z11 ? this.shuffleOrder.getLastIndex() : i11 - 1;
        while (getTimelineByChildIndex(lastIndex).isEmpty()) {
            lastIndex = getPreviousChildIndex(lastIndex, z11);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(lastIndex) + getTimelineByChildIndex(lastIndex).getLastWindowIndex(z11);
    }

    public int getNextWindowIndex(int i11, int i12, boolean z11) {
        int i13 = 0;
        if (this.isAtomic) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i11);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i14 = i11 - firstWindowIndexByChildIndex;
        if (i12 != 2) {
            i13 = i12;
        }
        int nextWindowIndex = timelineByChildIndex.getNextWindowIndex(i14, i13, z11);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z11);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z11);
        }
        if (nextChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z11);
        }
        if (i12 == 2) {
            return getFirstWindowIndex(z11);
        }
        return -1;
    }

    public final Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i11);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i11 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z11);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z11) {
            period.uid = getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), Assertions.checkNotNull(period.uid));
        }
        return period;
    }

    public final Timeline.Period getPeriodByUid(Object obj, Timeline.Period period) {
        Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).getPeriodByUid(childPeriodUidFromConcatenatedUid, period);
        period.windowIndex += firstWindowIndexByChildIndex;
        period.uid = obj;
        return period;
    }

    public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
        int i13 = 0;
        if (this.isAtomic) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i11);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i14 = i11 - firstWindowIndexByChildIndex;
        if (i12 != 2) {
            i13 = i12;
        }
        int previousWindowIndex = timelineByChildIndex.getPreviousWindowIndex(i14, i13, z11);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z11);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z11);
        }
        if (previousChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z11);
        }
        if (i12 == 2) {
            return getLastWindowIndex(z11);
        }
        return -1;
    }

    public abstract Timeline getTimelineByChildIndex(int i11);

    public final Object getUidOfPeriod(int i11) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i11);
        return getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).getUidOfPeriod(i11 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    public final Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i11);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i11 - firstWindowIndexByChildIndex, window, j11);
        Object childUidByChildIndex = getChildUidByChildIndex(childIndexByWindowIndex);
        if (!Timeline.Window.SINGLE_WINDOW_UID.equals(window.uid)) {
            childUidByChildIndex = getConcatenatedUid(childUidByChildIndex, window.uid);
        }
        window.uid = childUidByChildIndex;
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}
