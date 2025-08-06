package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList;
import java.util.concurrent.TimeUnit;

final class RootViewPicker$NoMatchingRootBackoff extends RootViewPicker$BackOff {

    /* renamed from: d  reason: collision with root package name */
    public static final ImmutableList<Integer> f11113d = ImmutableList.of(10, 20, 200, 400, 1000, 2000);

    public RootViewPicker$NoMatchingRootBackoff() {
        super(f11113d, TimeUnit.MILLISECONDS);
    }
}
