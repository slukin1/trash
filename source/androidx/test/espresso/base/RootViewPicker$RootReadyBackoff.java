package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.concurrent.TimeUnit;

final class RootViewPicker$RootReadyBackoff extends RootViewPicker$BackOff {

    /* renamed from: d  reason: collision with root package name */
    public static final ImmutableList<Integer> f11114d = ImmutableList.of(10, 25, 50, 100, 200, 400, Integer.valueOf(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE), 1000);

    public RootViewPicker$RootReadyBackoff() {
        super(f11114d, TimeUnit.MILLISECONDS);
    }
}
