package m9;

import com.hbg.lib.network.swap.core.controller.SwapSettlementController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58138b;

    public /* synthetic */ u(String str) {
        this.f58138b = str;
    }

    public final Object call(Object obj) {
        return SwapSettlementController.d(this.f58138b, (List) obj);
    }
}
