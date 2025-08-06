package ss;

import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.swap.presenter.SwapTradeBasePresenter;

public final /* synthetic */ class q implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeBasePresenter.p f26166a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPosition f26167b;

    public /* synthetic */ q(SwapTradeBasePresenter.p pVar, SwapPosition swapPosition) {
        this.f26166a = pVar;
        this.f26167b = swapPosition;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f26166a.m(this.f26167b, hBDialogFragment);
    }
}
