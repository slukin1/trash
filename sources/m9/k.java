package m9;

import com.hbg.lib.network.swap.core.bean.SwapHiddenInstruments;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class k implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfoController f58130b;

    public /* synthetic */ k(SwapCurrencyInfoController swapCurrencyInfoController) {
        this.f58130b = swapCurrencyInfoController;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f58130b.s((List) obj, (SwapHiddenInstruments) obj2);
    }
}
