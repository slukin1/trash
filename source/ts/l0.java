package ts;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.swap.ui.SwapTradeBaseFragment;

public final /* synthetic */ class l0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeBaseFragment f60382a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f60383b;

    public /* synthetic */ l0(SwapTradeBaseFragment swapTradeBaseFragment, String str) {
        this.f60382a = swapTradeBaseFragment;
        this.f60383b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f60382a.Mi(this.f60383b, hBDialogFragment);
    }
}
