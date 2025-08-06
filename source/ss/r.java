package ss;

import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.swap.presenter.SwapTradeBasePresenter;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeBasePresenter.p f26168b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapPosition f26169c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f26170d;

    public /* synthetic */ r(SwapTradeBasePresenter.p pVar, SwapPosition swapPosition, DialogUtils.b bVar) {
        this.f26168b = pVar;
        this.f26169c = swapPosition;
        this.f26170d = bVar;
    }

    public final void run() {
        this.f26168b.o(this.f26169c, this.f26170d);
    }
}
