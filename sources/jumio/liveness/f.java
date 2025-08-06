package jumio.liveness;

import com.jumio.liveness.DaClient;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class f extends Lambda implements a<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f56470a = new f();

    public f() {
        super(0);
    }

    public final Object invoke() {
        DaClient.deinitCompat();
        return Unit.f56620a;
    }
}
