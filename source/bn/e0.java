package bn;

import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class e0 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBasePresenter f12821b;

    public /* synthetic */ e0(LinearSwapTradeBasePresenter linearSwapTradeBasePresenter) {
        this.f12821b = linearSwapTradeBasePresenter;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f12821b.w3((List) obj, (List) obj2);
    }
}
