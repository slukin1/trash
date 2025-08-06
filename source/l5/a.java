package l5;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class a implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f58004a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f58005b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EventInternal f58006c;

    public /* synthetic */ a(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f58004a = defaultScheduler;
        this.f58005b = transportContext;
        this.f58006c = eventInternal;
    }

    public final Object execute() {
        return this.f58004a.lambda$schedule$0(this.f58005b, this.f58006c);
    }
}
