package cn;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import java.util.HashMap;

public final /* synthetic */ class e1 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBaseFragment f13134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f13135b;

    public /* synthetic */ e1(LinearSwapTradeBaseFragment linearSwapTradeBaseFragment, HashMap hashMap) {
        this.f13134a = linearSwapTradeBaseFragment;
        this.f13135b = hashMap;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f13134a.Yi(this.f13135b, hBDialogFragment);
    }
}
