package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList;
import java.util.concurrent.TimeUnit;

final class RootViewPicker$NoActiveRootsBackoff extends RootViewPicker$BackOff {

    /* renamed from: d  reason: collision with root package name */
    public static final ImmutableList<Integer> f11112d = ImmutableList.of(10, 10, 20, 30, 50, 80, 130, 210, 340);

    public RootViewPicker$NoActiveRootsBackoff() {
        super(f11112d, TimeUnit.MILLISECONDS);
    }
}
