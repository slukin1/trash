package com.jumio.core.performance;

import java.util.List;

public interface JDisplayListener {
    public static final Companion Companion = Companion.f39468a;
    public static final long DEFAULT_SAMPLE_TIME_IN_NS = 1000000000;

    public static final class Companion {
        public static final long DEFAULT_SAMPLE_TIME_IN_NS = 1000000000;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39468a = new Companion();
    }

    void onFramesSampled(List<Long> list);
}
