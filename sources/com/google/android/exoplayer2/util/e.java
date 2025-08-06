package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f66090b = new e();

    public final int compare(Object obj, Object obj2) {
        return Float.compare(((SlidingPercentile.Sample) obj).value, ((SlidingPercentile.Sample) obj2).value);
    }
}
