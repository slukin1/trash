package hw;

import com.jumio.core.api.QueueProcessor;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f54993b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QueueProcessor f54994c;

    public /* synthetic */ a(long j11, QueueProcessor queueProcessor) {
        this.f54993b = j11;
        this.f54994c = queueProcessor;
    }

    public final void run() {
        QueueProcessor.a(this.f54993b, this.f54994c);
    }
}
