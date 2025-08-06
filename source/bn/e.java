package bn;

import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBasePresenter f12819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12820c;

    public /* synthetic */ e(LinearSwapTradeBasePresenter linearSwapTradeBasePresenter, String str) {
        this.f12819b = linearSwapTradeBasePresenter;
        this.f12820c = str;
    }

    public final Object call(Object obj) {
        return this.f12819b.x3(this.f12820c, (Long) obj);
    }
}
