package g10;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.scheduling.SchedulerTimeSource;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f54781a = d0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public static final long f54782b = f0.f("kotlinx.coroutines.scheduler.resolution.ns", IndexSeeker.MIN_TIME_BETWEEN_POINTS_US, 0, 0, 12, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f54783c = f0.e("kotlinx.coroutines.scheduler.core.pool.size", RangesKt___RangesKt.d(d0.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final int f54784d = f0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    public static final long f54785e = TimeUnit.SECONDS.toNanos(f0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: f  reason: collision with root package name */
    public static SchedulerTimeSource f54786f = c.f54778a;

    /* renamed from: g  reason: collision with root package name */
    public static final d f54787g = new e(0);

    /* renamed from: h  reason: collision with root package name */
    public static final d f54788h = new e(1);
}
