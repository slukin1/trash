package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DashManifest implements FilterableManifest<DashManifest> {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final List<Period> periods;
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    public final ServiceDescriptionElement serviceDescription;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    public final UtcTimingElement utcTiming;

    public DashManifest(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, ProgramInformation programInformation2, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List<Period> list) {
        this.availabilityStartTimeMs = j11;
        this.durationMs = j12;
        this.minBufferTimeMs = j13;
        this.dynamic = z11;
        this.minUpdatePeriodMs = j14;
        this.timeShiftBufferDepthMs = j15;
        this.suggestedPresentationDelayMs = j16;
        this.publishTimeMs = j17;
        this.programInformation = programInformation2;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.serviceDescription = serviceDescriptionElement;
        this.periods = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i11 = poll.periodIndex;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i12 = poll.groupIndex;
            AdaptationSet adaptationSet = list.get(i12);
            List<Representation> list2 = adaptationSet.representations;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.trackIndex));
                poll = linkedList.poll();
                if (!(poll.periodIndex == i11 && poll.groupIndex == i12)) {
                    arrayList.add(new AdaptationSet(adaptationSet.f66006id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
                }
                arrayList2.add(list2.get(poll.trackIndex));
                poll = linkedList.poll();
                break;
            } while (poll.groupIndex == i12);
            arrayList.add(new AdaptationSet(adaptationSet.f66006id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
        } while (poll.periodIndex == i11);
        linkedList.addFirst(poll);
        return arrayList;
    }

    public final Period getPeriod(int i11) {
        return this.periods.get(i11);
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final long getPeriodDurationMs(int i11) {
        if (i11 != this.periods.size() - 1) {
            return this.periods.get(i11 + 1).startMs - this.periods.get(i11).startMs;
        }
        long j11 = this.durationMs;
        if (j11 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j11 - this.periods.get(i11).startMs;
    }

    public final long getPeriodDurationUs(int i11) {
        return C.msToUs(getPeriodDurationMs(i11));
    }

    public final DashManifest copy(List<StreamKey> list) {
        long j11;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j12 = 0;
        int i11 = 0;
        while (true) {
            j11 = -9223372036854775807L;
            if (i11 >= getPeriodCount()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i11) {
                long periodDurationMs = getPeriodDurationMs(i11);
                if (periodDurationMs != -9223372036854775807L) {
                    j12 += periodDurationMs;
                }
            } else {
                Period period = getPeriod(i11);
                arrayList.add(new Period(period.f66008id, period.startMs - j12, copyAdaptationSets(period.adaptationSets, linkedList), period.eventStreams));
            }
            i11++;
        }
        long j13 = this.durationMs;
        if (j13 != -9223372036854775807L) {
            j11 = j13 - j12;
        }
        return new DashManifest(this.availabilityStartTimeMs, j11, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.serviceDescription, this.location, arrayList);
    }
}
