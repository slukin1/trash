package i8;

import com.hbg.lib.network.linear.swap.controller.LinearSwapSettlementController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class o implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f55027b;

    public /* synthetic */ o(String str) {
        this.f55027b = str;
    }

    public final Object call(Object obj) {
        return LinearSwapSettlementController.d(this.f55027b, (List) obj);
    }
}
