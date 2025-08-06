package ts;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import java.util.HashMap;

public final /* synthetic */ class m0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwapTradeBaseFragment f60388a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f60389b;

    public /* synthetic */ m0(SwapTradeBaseFragment swapTradeBaseFragment, HashMap hashMap) {
        this.f60388a = swapTradeBaseFragment;
        this.f60389b = hashMap;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f60388a.Gi(this.f60389b, hBDialogFragment);
    }
}
