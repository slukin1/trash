package androidx.test.espresso.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

abstract class RootViewPicker$BackOff {

    /* renamed from: a  reason: collision with root package name */
    public final List<Integer> f11109a;

    /* renamed from: b  reason: collision with root package name */
    public final TimeUnit f11110b;

    /* renamed from: c  reason: collision with root package name */
    public int f11111c = 0;

    public RootViewPicker$BackOff(List<Integer> list, TimeUnit timeUnit) {
        this.f11109a = list;
        this.f11110b = timeUnit;
    }
}
