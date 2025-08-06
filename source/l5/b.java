package l5;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f58007b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f58008c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TransportScheduleCallback f58009d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EventInternal f58010e;

    public /* synthetic */ b(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f58007b = defaultScheduler;
        this.f58008c = transportContext;
        this.f58009d = transportScheduleCallback;
        this.f58010e = eventInternal;
    }

    public final void run() {
        this.f58007b.lambda$schedule$1(this.f58008c, this.f58009d, this.f58010e);
    }
}
