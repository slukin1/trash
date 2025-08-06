package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f66089b = new d();

    public final int compare(Object obj, Object obj2) {
        return SlidingPercentile.lambda$static$0((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
    }
}
