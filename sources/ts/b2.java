package ts;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.swap.ui.SwapTradeTogetherView;

public final /* synthetic */ class b2 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeTogetherView f60332a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f60333b;

    public /* synthetic */ b2(SwapTradeTogetherView swapTradeTogetherView, String str) {
        this.f60332a = swapTradeTogetherView;
        this.f60333b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f60332a.m2(this.f60333b, hBDialogFragment);
    }
}
