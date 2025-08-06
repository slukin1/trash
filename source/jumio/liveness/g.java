package jumio.liveness;

import com.jumio.liveness.DaClient;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class g extends Lambda implements a<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final g f56471a = new g();

    public g() {
        super(0);
    }

    public final Object invoke() {
        DaClient.sendEvent(System.currentTimeMillis(), DaClient.EVENT_POSE_READY, (String) null, (String) null);
        DaClient.stopCompat();
        return Unit.f56620a;
    }
}
