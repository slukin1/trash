package jumio.core;

import com.jumio.core.views.CameraScanView;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class n1 extends Lambda implements a<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraScanView f56282a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n1(CameraScanView cameraScanView) {
        super(0);
        this.f56282a = cameraScanView;
    }

    public final Object invoke() {
        c1 drawView$jumio_core_release = this.f56282a.getDrawView$jumio_core_release();
        if (drawView$jumio_core_release != null) {
            drawView$jumio_core_release.invalidate();
        }
        return Unit.f56620a;
    }
}
