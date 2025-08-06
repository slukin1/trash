package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class Period {
    public final List<AdaptationSet> adaptationSets;
    public final Descriptor assetIdentifier;
    public final List<EventStream> eventStreams;

    /* renamed from: id  reason: collision with root package name */
    public final String f66008id;
    public final long startMs;

    public Period(String str, long j11, List<AdaptationSet> list) {
        this(str, j11, list, Collections.emptyList(), (Descriptor) null);
    }

    public int getAdaptationSetIndex(int i11) {
        int size = this.adaptationSets.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.adaptationSets.get(i12).type == i11) {
                return i12;
            }
        }
        return -1;
    }

    public Period(String str, long j11, List<AdaptationSet> list, List<EventStream> list2) {
        this(str, j11, list, list2, (Descriptor) null);
    }

    public Period(String str, long j11, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        this.f66008id = str;
        this.startMs = j11;
        this.adaptationSets = Collections.unmodifiableList(list);
        this.eventStreams = Collections.unmodifiableList(list2);
        this.assetIdentifier = descriptor;
    }
}
