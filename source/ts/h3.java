package ts;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.swap.ui.SwapTradeView;

public final /* synthetic */ class h3 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeView f60365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f60366b;

    public /* synthetic */ h3(SwapTradeView swapTradeView, String str) {
        this.f60365a = swapTradeView;
        this.f60366b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f60365a.q2(this.f60366b, hBDialogFragment);
    }
}
