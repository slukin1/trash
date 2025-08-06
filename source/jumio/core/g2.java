package jumio.core;

import com.jumio.core.api.QueueProcessor;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class g2 extends Lambda implements a<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueueProcessor f56213a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g2(QueueProcessor queueProcessor) {
        super(0);
        this.f56213a = queueProcessor;
    }

    public final Object invoke() {
        this.f56213a.b();
        return Unit.f56620a;
    }
}
