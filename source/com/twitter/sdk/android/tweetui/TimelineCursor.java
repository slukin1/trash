package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.Identifiable;
import java.util.List;

public class TimelineCursor {
    public final Long maxPosition;
    public final Long minPosition;

    public TimelineCursor(Long l11, Long l12) {
        this.minPosition = l11;
        this.maxPosition = l12;
    }

    public TimelineCursor(List<? extends Identifiable> list) {
        Long l11 = null;
        this.minPosition = list.size() > 0 ? Long.valueOf(((Identifiable) list.get(list.size() - 1)).getId()) : null;
        this.maxPosition = list.size() > 0 ? Long.valueOf(((Identifiable) list.get(0)).getId()) : l11;
    }
}
